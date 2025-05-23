package nz.ac.auckland.se281.engine;

public class MediumLevel implements Level {
  private GameStats stats;

  public MediumLevel(GameStats stats) {
    this.stats = stats;
  }

  @Override
  public Strategy decideStrategy() {
    if (stats.getHumanColourHistorySize() == 0) {
      // First round so no human inputs in this game yet
      return new RandomStrategy();
    }
    return new AvoidLastStrategy(stats);
  }
}
