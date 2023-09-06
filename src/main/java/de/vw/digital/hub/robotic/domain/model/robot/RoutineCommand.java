package de.vw.digital.hub.robotic.domain.model.robot;

public class RoutineCommand {
  private String initPos;
  private String steps;

  public RoutineCommand(String initPos, String steps) {
    this.initPos = initPos;
    this.steps = steps;
  }

  public String getInitPos() {
    return initPos;
  }

  public void setInitPos(String initPos) {
    this.initPos = initPos;
  }

  public String getSteps() {
    return steps;
  }

  public void setSteps(String steps) {
    this.steps = steps;
  }
}
