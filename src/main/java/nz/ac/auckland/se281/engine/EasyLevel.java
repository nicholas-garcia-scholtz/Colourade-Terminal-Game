package nz.ac.auckland.se281.engine;

public class EasyLevel implements Level {

  @Override
  public Strategy decideStrategy() {
    // Return a random strategy
    return new RandomStrategy();
  }
}
