package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.model.Colour;

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
    ai = new Ai(difficulty, AI_NAME);
    gameStarted = true;
  }

  public void play() {
    int points = 1;
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    currentRound++;
    MessageCli.START_ROUND.printMessage(currentRound, numRounds);
    human.play();
    ai.play();

    if (currentRound % 3 == 0) {
      Colour powerColour = Colour.getRandomColourForPowerColour();
      MessageCli.PRINT_POWER_COLOUR.printMessage(powerColour);
      points = 3;
    }

    if (ai.getColour() == human.getGuess()) {
      human.wonPoints(points);
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(human.getName(), points);
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(human.getName(), 0);
    }

    if (human.getColour() == ai.getGuess()) {
      ai.wonPoints(points);
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(ai.getName(), points);
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(ai.getName(), 0);
    }
  }

  public void showStats() {}
}
