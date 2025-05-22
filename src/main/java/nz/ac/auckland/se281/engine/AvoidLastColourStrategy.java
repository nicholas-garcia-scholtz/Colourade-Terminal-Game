package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class AvoidLastColourStrategy implements Strategy {
  private GameStats stats;

  public AvoidLastColourStrategy(GameStats stats) {
    this.stats = stats;
  }

  @Override
  public Colour[] decideColours() {
    return new Colour[] {
      Colour.getRandomColourForAi(), Colour.getRandomColourExcluding(stats.getLastColour())
    };
  }
}
