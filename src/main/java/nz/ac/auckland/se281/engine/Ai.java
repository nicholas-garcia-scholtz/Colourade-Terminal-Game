package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;

public class Ai extends Player {
  private Strategy strat;
  private Level level;
  private String name;

  public Ai(Difficulty difficulty, String name) {
    this.level = LevelFactory.createLevel(difficulty);
    this.name = name;
  }

  public void play() {}

  public void setStrategy(Strategy strat) {
    this.strat = strat;
  }
}
