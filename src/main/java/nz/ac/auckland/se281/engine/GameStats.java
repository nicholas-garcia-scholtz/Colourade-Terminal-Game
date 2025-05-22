package nz.ac.auckland.se281.engine;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.model.Colour;

public class GameStats {
  private List<Colour> humanColourHistory = new ArrayList<>();
  private int redCount = 0;
  private int greenCount = 0;
  private int blueCount = 0;
  private int yellowCount = 0;
  private boolean aiWon = false;

  public Colour getLastColour() {
    return humanColourHistory.get(humanColourHistory.size() - 1);
  }

  public void aiWonPoints(int points) {
    aiWon = (points > 0);
  }

  public boolean getAiWonPoints() {
    return aiWon;
  }

  public void clearColourHistory() {
    humanColourHistory.clear();
    redCount = 0;
    greenCount = 0;
    blueCount = 0;
    yellowCount = 0;
  }

  public void addHumanColour(Colour col) {
    humanColourHistory.add(col);

    // Increment the appropriate counter
    switch (col) {
      case Colour.RED:
        redCount++;
        break;
      case Colour.GREEN:
        greenCount++;
        break;
      case Colour.BLUE:
        blueCount++;
        break;
      case Colour.YELLOW:
        yellowCount++;
        break;
    }
  }

  public int getHumanColourHistorySize() {
    return humanColourHistory.size();
  }

  public Colour getLeastUsedColour() {

    // Red has the least occurances or joint least
    if (redCount <= greenCount && redCount <= blueCount && redCount <= yellowCount) {
      return Colour.RED;
    }

    // Green has the least occurances or joint least (excluding with red)
    if (greenCount <= redCount && greenCount <= blueCount && greenCount <= yellowCount) {
      return Colour.GREEN;
    }

    // Blue has the least occurances or joint least (excluding with red and green)
    if (blueCount <= redCount && blueCount <= greenCount && blueCount <= yellowCount) {
      return Colour.BLUE;
    }

    // Yellow has the least occurances
    return Colour.YELLOW;
  }
}
