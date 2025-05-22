package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public abstract class Player {
  protected Colour colour;
  protected Colour guess;

  abstract void play();

  public Colour getColour() {
    return colour;
  }

  public Colour getGuess() {
    return guess;
  }
}
