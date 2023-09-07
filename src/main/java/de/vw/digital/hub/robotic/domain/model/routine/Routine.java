package de.vw.digital.hub.robotic.domain.model.routine;

import de.vw.digital.hub.robotic.domain.model.robot.RobotR2D2;
import de.vw.digital.hub.robotic.domain.model.robot.RoutineCommand;
import de.vw.digital.hub.robotic.domain.model.workspace.Workspace;
import de.vw.digital.hub.robotic.infrastructure.ports.incoming.InputReader;
import java.util.List;
import java.util.stream.Collectors;

public class Routine implements RoutineConfigurable {
  private final InputReader inputReader;
  private final Workspace workspace;

  public Routine(InputReader inputReader, Workspace workspace) {
    this.inputReader = inputReader;
    this.workspace = workspace;
  }

  @Override
  public List<RoutineExecutable> configure() {
    inputReader.loadInputSource();
    List<RoutineCommand> robotsCommands = inputReader.readRobotConfiguration();
    workspace.configure(inputReader.readWorkSpaceDimensions());
    return robotsCommands.stream()
        .map(r -> new RobotR2D2(r.getInitPos(), workspace, r.getSteps()))
        .collect(Collectors.toList());
  }
}
