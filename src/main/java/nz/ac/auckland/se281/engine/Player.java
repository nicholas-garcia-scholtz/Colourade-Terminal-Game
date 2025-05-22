package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public abstract class Player {
  protected Colour colour;
  protected Colour guess;
  protected String name;
  protected int points;

  public Player(String name) {
    this.name = name;
  }

  abstract void play();

  public Colour getColour() {
    return colour;
  }

  public Colour getGuess() {
    return guess;
  }

  public int getPoints() {
    return points;
  }

  public String getName() {
    return name;
  }

  public void wonPoints(int numWon) {
    points += numWon;
  }
}
