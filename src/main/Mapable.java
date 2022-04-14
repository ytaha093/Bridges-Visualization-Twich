package main;

import bridges.base.Color;

public interface Mapable {

  /**
   * Returns the size of the mapable object on a scale of 1-50 based off its values.
   *
   * @author Yaseen
   * @return The size of the element between 1-50
   */
  double getSize();

  /**
   * Returns the color of the mapable object to be displayed, based off its values.
   *
   * @author Yaseen
   * @return the color of the mapable object
   */
  Color getColor();

  /**
   * returns total watch time for a mapable object.
   *
   * @author Christopher
   * @return the watch time of the mapable object
   */
  int getWatched();

  /**
   * returns the rank for a mapable object.
   *
   * @author Christopher
   * @return the rank of the mapable object
   */
  int getRank();

  /**
   * Returns the Label of the mapable object to be displayed, based off its name.
   *
   * @author Yaseen
   * @return the Label of the mapable object
   */
  String getLable();
}
