package de.vw.digital.hub.robotic.infrastructure.ports.outgoing;

import org.springframework.stereotype.Component;

@Component
public class ConsoleOut implements PrintResultPort {

  @Override
  public void printOutByCleanMachine(String output) {
    System.out.println(output);
  }
}
