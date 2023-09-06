package de.vw.digital.hub;

import de.vw.digital.hub.robotic.application.service.RoutinePlanService;
import de.vw.digital.hub.robotic.application.usecase.RunCleanRoutineUseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RobotCleanerApplication {

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        SpringApplication.run(RobotCleanerApplication.class, args);
    RunCleanRoutineUseCase service = applicationContext.getBean(RoutinePlanService.class);
    service.executeRoutine();
  }
}
