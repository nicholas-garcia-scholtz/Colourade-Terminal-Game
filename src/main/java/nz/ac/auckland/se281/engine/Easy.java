package nz.ac.auckland.se281.engine;

public class Easy implements Level {
  private Strategy strat = new RandomStrategy();

  @Override
  public Strategy decideStrategy() {
    return strat;
  }
}
