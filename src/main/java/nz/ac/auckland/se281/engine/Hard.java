package nz.ac.auckland.se281.engine;

public class Hard implements Level {
  private GameStats stats;

  public Hard(GameStats stats) {
    this.stats = stats;
  }

  @Override
  public Strategy decideStrategy() {
    if (stats.getHumanColourHistorySize() <= 2) {
      // Rounds 1 and 2
      return new RandomStrategy();
    }
    if (stats.getHumanColourHistorySize() == 3) {
      // Round 3
      return new LeastUsedColourStrategy(stats);
    }
    // Round 4 onwards
    throw new UnsupportedOperationException("Unimplemented method 'decideStrategy'");
  }
}
