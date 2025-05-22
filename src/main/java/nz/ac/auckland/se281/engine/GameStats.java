package nz.ac.auckland.se281.engine;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.model.Colour;

public class GameStats {
  private List<Colour> humanColourHistory = new ArrayList<>();

  public Colour getLastColour() {
    return humanColourHistory.get(humanColourHistory.size() - 1);
  }

  public void clearColourHistory() {
    humanColourHistory.clear();
  }

  public void addHumanColour(Colour col) {
    humanColourHistory.add(col);
  }

  public int getHumanColourHistorySize() {
    return humanColourHistory.size();
  }

  public Colour getLeastUsedColour() {
    int redCount = 0;
    int greenCount = 0;
    int blueCount = 0;
    int yellowCount = 0;
    for (Colour col : humanColourHistory) {
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

    if (redCount <= greenCount && redCount <= blueCount && redCount <= yellowCount) {
      return Colour.RED;
    }

    if (greenCount <= redCount && greenCount <= blueCount && greenCount <= yellowCount) {
      return Colour.GREEN;
    }

    if (blueCount <= redCount && blueCount <= greenCount && blueCount <= yellowCount) {
      return Colour.BLUE;
    }

    return Colour.YELLOW;
  }
}
