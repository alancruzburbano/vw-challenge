package de.vw.digital.hub.robotic.infrastructure.ports.incoming;

import de.vw.digital.hub.robotic.domain.model.robot.RoutineCommand;
import java.util.List;

public interface InputReader {
  void loadInputSource();

  String readWorkSpaceDimensions();

  List<RoutineCommand> readRobotConfiguration();
}
