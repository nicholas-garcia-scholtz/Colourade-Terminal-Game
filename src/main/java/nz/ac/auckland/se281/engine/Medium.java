package nz.ac.auckland.se281.engine;

public class Medium implements Level {
  private boolean firstRound = true;

  @Override
  public Strategy decideStrategy() {
    if (firstRound) {
      firstRound = false;
      return new RandomStrategy();
    }
    return new AvoidLastColourStrategy();
  }
}
