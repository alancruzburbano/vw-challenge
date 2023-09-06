package de.vw.digital.hub.robotic.domain.model.workspace;

import java.util.StringTokenizer;

public class Square implements Workspace {

  private Integer xMax;
  private Integer yMax;

  @Override
  public void configure(String dimensions) {
    StringTokenizer st = new StringTokenizer(dimensions, " ");
    this.xMax = Integer.valueOf(st.nextToken());
    this.yMax = Integer.valueOf(st.nextToken());
  }

  @Override
  public int limitOnXAxis() {
    return this.xMax;
  }

  @Override
  public int limitOnYAxis() {
    return this.yMax;
  }
}
