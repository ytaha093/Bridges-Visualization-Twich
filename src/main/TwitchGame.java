package main;

import bridges.base.Color;

public class TwitchGame implements Mapable {

  private String name;
  private int rank;
  private int hoursWatched;
  private double avgViewerRatio;

  public TwitchGame(String name, int rank, int hoursWatched, double avgViewerRatio) {
    this.name = name;
    this.rank = rank;
    this.hoursWatched = hoursWatched;
    this.avgViewerRatio = avgViewerRatio;
  }

  /**
   * Changes the size of a game node based on its rank.
   *
   * @author Christopher
   * @author Yaseen
   * @return double : represents size of node.
   */
  @Override
  public double getSize() {
    //    if (rank < 50) {
    //      return 50;
    //    } else if (rank < 125) {
    //      return 25;
    //    } else if (rank < 250) {
    //      return 12;
    //    } else {
    //      return 6;
    //    }
    int noomba = -(rank / 10) + 50;
    if (noomba < 1) {
      noomba = 1;
    }
    return noomba;
  }

  @Override
  public String getLable() {
    return name;
  }

  @Override
  public int getWatched() {
    return hoursWatched;
  }

  @Override
  public int getRank() {
    return rank;
  }

  /**
   * Sets the color based on the viwer ratio.
   *
   * @author Christopher
   * @author Yaseen
   */
  @Override
  public Color getColor() {
    if (avgViewerRatio > 120) {
      return new Color(210, 10, 210);
    } else if (avgViewerRatio > 110) {
      return new Color(210, 10, 170);
    } else if (avgViewerRatio > 100) {
      return new Color(210, 10, 130);
    } else if (avgViewerRatio > 90) {
      return new Color(210, 10, 90);
    } else if (avgViewerRatio > 80) {
      return new Color(210, 10, 50);
    } else if (avgViewerRatio > 70) {
      return new Color(210, 10, 10);
    } else if (avgViewerRatio > 60) {
      return new Color(20, 100, 255);
    } else {
      return new Color(0, 0, 222);
    }
  }
}
