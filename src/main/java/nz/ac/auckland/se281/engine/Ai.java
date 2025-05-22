package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class Ai implements Player {
  @Override
  public Colour play() {
    return Colour.BLUE;
  }
}
