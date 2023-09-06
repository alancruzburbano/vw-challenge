package de.vw.digital.hub.robotic.domain.model.workspace;

public interface Workspace {
  void configure(String dimensions);

  int limitOnXAxis();

  int limitOnYAxis();
}
