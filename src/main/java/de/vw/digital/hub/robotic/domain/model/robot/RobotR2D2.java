package de.vw.digital.hub.robotic.domain.model.robot;

import de.vw.digital.hub.robotic.domain.model.routine.RoutineExecutable;
import de.vw.digital.hub.robotic.domain.model.workspace.Workspace;
import java.util.Map;
import java.util.StringTokenizer;

public class RobotR2D2 implements RoutineExecutable {

  private Integer xPosition;
  private Integer yPosition;
  private OrientationEnum orientation;
  private final Workspace workspace;
  private final String routine;
  private Map<OrientationEnum, OrientationEnum> turnLeft;
  private Map<OrientationEnum, OrientationEnum> turnRight;

  public RobotR2D2(String initCoordinates, Workspace workspace, String routine) {
    initOrientationMaps();
    StringTokenizer st = new StringTokenizer(initCoordinates, " ");
    this.xPosition = Integer.valueOf(st.nextToken());
    this.yPosition = Integer.valueOf(st.nextToken());
    this.orientation = OrientationEnum.valueOf(st.nextToken());
    this.workspace = workspace;
    this.routine = routine;
  }

  @Override
  public String executeRoutine() {
    char[] chars = (routine).trim().toCharArray();
    for (char ch : chars) {
      updatePosition(String.valueOf(ch));
    }
    return this.xPosition + " " + this.yPosition + " " + this.orientation.name();
  }

  private void updatePosition(String c) {
    if (MovementEnum.valueOf(c).equals(MovementEnum.R)) {
      this.orientation = turnRight.get(this.orientation);
    }
    if (MovementEnum.valueOf(c).equals(MovementEnum.L)) {
      this.orientation = turnLeft.get(this.orientation);
    }
    if (MovementEnum.valueOf(c).equals(MovementEnum.M)) {
      stepAhead();
    }
  }

  private void stepAhead() {
    if (this.orientation.equals(OrientationEnum.E)) {
      this.xPosition =
          this.xPosition + 1 <= workspace.limitOnXAxis() ? this.xPosition + 1 : this.xPosition;
    }
    if (this.orientation.equals(OrientationEnum.W)) {
      this.xPosition = this.xPosition - 1 >= 0 ? this.xPosition - 1 : this.xPosition;
    }
    if (this.orientation.equals(OrientationEnum.N)) {
      this.yPosition =
          this.yPosition + 1 <= workspace.limitOnYAxis() ? this.yPosition + 1 : this.yPosition;
    }
    if (this.orientation.equals(OrientationEnum.S)) {
      this.yPosition = this.yPosition - 1 >= 0 ? this.yPosition - 1 : this.yPosition;
    }
  }

  public void initOrientationMaps() {
    turnLeft =
        Map.of(
            OrientationEnum.E,
            OrientationEnum.N,
            OrientationEnum.W,
            OrientationEnum.S,
            OrientationEnum.N,
            OrientationEnum.W,
            OrientationEnum.S,
            OrientationEnum.E);
    turnRight =
        Map.of(
            OrientationEnum.E,
            OrientationEnum.S,
            OrientationEnum.W,
            OrientationEnum.N,
            OrientationEnum.N,
            OrientationEnum.E,
            OrientationEnum.S,
            OrientationEnum.W);
  }
}
