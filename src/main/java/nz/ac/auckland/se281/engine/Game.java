package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;

public class Game {
  public static String AI_NAME = "HAL-9000";

  public Game() {}

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    String namePlayer = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(namePlayer);
    GameStats stats = new GameStats();

    for (int i = 1; i < numRounds + 1; i++) {
      MessageCli.START_ROUND.printMessage(i, numRounds);
    }
  }

  public void play() {}

  public void showStats() {}
}
