package de.vw.digital.hub.robotic.domain.model.routine;

import java.util.List;

public interface RoutineConfigurable {
  List<RoutineExecutable> configure();
}
