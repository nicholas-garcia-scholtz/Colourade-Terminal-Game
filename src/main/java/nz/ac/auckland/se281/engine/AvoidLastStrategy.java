package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class AvoidLastStrategy implements Strategy {
  private GameStats stats;

  public AvoidLastStrategy(GameStats stats) {
    this.stats = stats;
  }

  @Override
  public Colour[] decideColours() {
    // Return a random colour and a random selected colour which exlcudes the human's last selected
    // colour
    return new Colour[] {
      Colour.getRandomColourForAi(), Colour.getRandomColourExcluding(stats.getLastColour())
    };
  }
}
