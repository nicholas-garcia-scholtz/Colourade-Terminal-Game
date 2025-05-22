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
    currentRound = 0;
    human = new Human(namePlayer);
    ai = new Ai(difficulty, AI_NAME);
    gameStarted = true;
  }

  public void play() {
    int humanPoints = 0;
    int aiPoints = 0;
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
      if (human.getGuess() == powerColour) {
        humanPoints += 2;
      }
      if (ai.getGuess() == powerColour) {
        aiPoints += 2;
      }
    }

    if (human.getGuess() == ai.getColour()) {
      humanPoints++;
    }

    if (ai.getGuess() == human.getColour()) {
      aiPoints++;
    }

    human.wonPoints(humanPoints);
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(human.getName(), humanPoints);
    ai.wonPoints(aiPoints);
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(ai.getName(), aiPoints);

    if (currentRound == numRounds) {
      gameStarted = false;
      MessageCli.PRINT_END_GAME.printMessage();
    }
  }

  public void showStats() {}
}
