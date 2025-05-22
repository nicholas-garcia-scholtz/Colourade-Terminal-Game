package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {

  public static Level createLevel(Difficulty difficulty, GameStats stats) {

    switch (difficulty) {
      case Difficulty.EASY:
        return new Easy();
      case Difficulty.MEDIUM:
        return new Medium(stats);
      case Difficulty.HARD:
        return new Hard(stats);
    }

    return null;
  }
}
