package de.vw.digital.hub.robotic.infrastructure.ports.incoming;

import de.vw.digital.hub.robotic.domain.model.robot.RoutineCommand;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TextReader implements InputReader {

  private static final Integer INIT_POS_DIMENSION = 0;
  private static final Integer INIT_POS_ROBOTS = 1;

  @Value("${robot.file.path}")
  private String filePath;

  private Map<Integer, String> fileContent;

  @Override
  public void loadInputSource() {
    this.fileContent = new HashMap<>();
    Path path = Paths.get(filePath);
    List<String> fileLines;
    try {
      fileLines = Files.readAllLines(path);
      if (!fileLines.isEmpty()) {
        for (int i = 0; i < fileLines.size(); i++) {
          fileContent.put(i, fileLines.get(i));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String readWorkSpaceDimensions() {
    return fileContent.get(INIT_POS_DIMENSION);
  }

  @Override
  public List<RoutineCommand> readRobotConfiguration() {
    int next = INIT_POS_ROBOTS;
    List<RoutineCommand> robots = new ArrayList<>();
    while (Objects.nonNull(fileContent.get(next)) && Objects.nonNull(fileContent.get(next + 1))) {
      robots.add(new RoutineCommand(fileContent.get(next), fileContent.get(next + 1)));
      next = next + 2;
    }
    return robots;
  }
}
