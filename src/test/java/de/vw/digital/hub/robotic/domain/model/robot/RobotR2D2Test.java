package de.vw.digital.hub.robotic.domain.model.robot;

import de.vw.digital.hub.robotic.domain.model.workspace.Square;
import de.vw.digital.hub.robotic.domain.model.workspace.Workspace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RobotR2D2Test {

    public RobotR2D2 initRobot(String dimensions,
                          String initCoordinates,
                          String routine) {
        Workspace square = new Square();
        square.configure(dimensions);
        return new RobotR2D2(initCoordinates, square, routine);
    }

    @Test
    void executeRoutine() {
        String desiredOut = "1 3 N";
        RobotR2D2 r = initRobot("5 5", "1 2 N", "LMLMLMLMM");
        Assertions.assertEquals(r.executeRoutine(), desiredOut);
    }
}