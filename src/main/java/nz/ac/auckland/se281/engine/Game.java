package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;

public class Game {
  public static String AI_NAME = "HAL-9000";

  private Player human;
  private Player ai;
  private int numRounds;
  private int currentRound;
  private boolean gameStarted = false;

  public Game() {}

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    String namePlayer = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(namePlayer);
    this.numRounds = numRounds;
    human = new Human(namePlayer);
    ai = new Ai();
    gameStarted = true;
  }

  public void play() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    currentRound++;
    MessageCli.START_ROUND.printMessage(currentRound, numRounds);
    human.play();
  }

  public void showStats() {}
}
