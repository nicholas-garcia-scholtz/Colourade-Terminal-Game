package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {

  public static Level createLevel(Difficulty difficulty, GameStats stats) {

    // Create the Appropriate difficulty level
    switch (difficulty) {
      case Difficulty.EASY:
        return new EasyLevel();
      case Difficulty.MEDIUM:
        return new MediumLevel(stats);
      case Difficulty.HARD:
        return new HardLevel(stats);
    }

    // Not a difficulty level implemented yet
    return null;
  }
}
