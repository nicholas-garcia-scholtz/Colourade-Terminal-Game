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
  private GameStats stats = new GameStats();

  public Game() {}

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    String namePlayer = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(namePlayer);

    // Intitialise/Reset all variables
    this.numRounds = numRounds;
    currentRound = 0;
    human = new Human(namePlayer);
    ai = new Ai(difficulty, AI_NAME, stats);
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

    // Human and the AI take their turns
    human.play();
    ai.play();

    // Add the selected colour by human to the history of the game to change future stategies by the
    // AI
    stats.addHumanColour(human.getColour());

    if (currentRound % 3 == 0) {
      // Power colour round
      Colour powerColour = Colour.getRandomColourForPowerColour();
      MessageCli.PRINT_POWER_COLOUR.printMessage(powerColour);

      // Check if the AI or human guessed the power colour
      if (human.getGuess() == powerColour && ai.getColour() == powerColour) {
        humanPoints += 2;
      }
      if (ai.getGuess() == powerColour && human.getColour() == powerColour) {
        aiPoints += 2;
      }
    }

    // Check if the AI or human guessed on another's colour
    if (human.getGuess() == ai.getColour()) {
      humanPoints++;
    }
    if (ai.getGuess() == human.getColour()) {
      aiPoints++;
    }

    // Add points
    human.wonPoints(humanPoints);
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(human.getName(), humanPoints);
    ai.wonPoints(aiPoints);
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(ai.getName(), aiPoints);

    // Check if the AI won points - the strategy used by the hard level depends on this
    stats.aiWonPoints(aiPoints);

    if (currentRound == numRounds) {
      // End the game after all rounds finish
      gameStarted = false;
      stats.clearColourHistory();
      MessageCli.PRINT_END_GAME.printMessage();
    }
  }

  public void showStats() {}
}
