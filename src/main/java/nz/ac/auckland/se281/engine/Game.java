package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;

public class Game {
  public static String AI_NAME = "HAL-9000";

  private Human human;
  private Player ai;
  private int numRounds;
  private int currentRound;

  public Game() {
    human = new Human();
    ai = new Ai();
  }

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    String namePlayer = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(namePlayer);
    GameStats stats = new GameStats();
    this.numRounds = numRounds;
    currentRound = 0;
  }

  public void play() {
    currentRound++;
    MessageCli.START_ROUND.printMessage(currentRound, numRounds);
    human.play();
  }

  public void showStats() {}
}
