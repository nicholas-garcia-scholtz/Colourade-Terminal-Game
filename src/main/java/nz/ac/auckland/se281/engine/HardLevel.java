package nz.ac.auckland.se281.engine;

public class HardLevel implements Level {
  private GameStats stats;
  private Strategy strat;

  public HardLevel(GameStats stats) {
    this.stats = stats;
  }

  @Override
  public Strategy decideStrategy() {
    if (stats.getHumanColourHistorySize() <= 1) {
      // Rounds 1 and 2
      return new Random();
    }
    if (stats.getHumanColourHistorySize() == 2) {
      // Round 3
      strat = new LeastUsed(stats);
      return strat;
    }

    // Round 4 onwards
    if (stats.getAiWonPoints()) {
      // Ai won so use same strategy
      return strat;
    }
    // Ai lost so switch to other strategy
    if (strat instanceof LeastUsed) {
      strat = new AvoidLast(stats);
    } else {
      strat = new LeastUsed(stats);
    }
    return strat;
  }
}
