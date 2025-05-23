package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class LeastUsed implements Strategy {
  private GameStats stats;

  public LeastUsed(GameStats stats) {
    this.stats = stats;
  }

  @Override
  public Colour[] decideColours() {
    // Return a random colour and guess the least used colour
    return new Colour[] {Colour.getRandomColourForAi(), stats.getLeastUsedColour()};
  }
}
