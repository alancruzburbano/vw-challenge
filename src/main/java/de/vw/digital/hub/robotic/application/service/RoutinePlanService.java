package de.vw.digital.hub.robotic.application.service;

import de.vw.digital.hub.robotic.application.usecase.RunCleanRoutineUseCase;
import de.vw.digital.hub.robotic.domain.model.routine.Routine;
import de.vw.digital.hub.robotic.domain.model.routine.RoutineConfigurable;
import de.vw.digital.hub.robotic.domain.model.routine.RoutineExecutable;
import de.vw.digital.hub.robotic.domain.model.workspace.Square;
import de.vw.digital.hub.robotic.domain.model.workspace.Workspace;
import de.vw.digital.hub.robotic.infrastructure.ports.incoming.InputReader;
import de.vw.digital.hub.robotic.infrastructure.ports.outgoing.PrintResultPort;
import org.springframework.stereotype.Service;

@Service
public class RoutinePlanService implements RunCleanRoutineUseCase {

  private final InputReader reader;
  private final PrintResultPort printResultPort;

  public RoutinePlanService(InputReader reader, PrintResultPort printResultPort) {
    this.reader = reader;
    this.printResultPort = printResultPort;
  }

  @Override
  public void executeRoutine() {
    Workspace workspace = new Square();
    RoutineConfigurable routineConfigurable = new Routine(reader, workspace);
    routineConfigurable.configure().stream()
        .map(RoutineExecutable::executeRoutine)
        .forEach(printResultPort::printOutByCleanMachine);
  }
}
