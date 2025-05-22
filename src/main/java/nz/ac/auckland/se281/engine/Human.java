package nz.ac.auckland.se281.engine;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.cli.Utils;
import nz.ac.auckland.se281.model.Colour;

public class Human extends Player {

  private List<Colour> colourHistory = new ArrayList<>();

  public Human(String name) {
    super(name);
  }

  public Colour getLastColour() {
    return colourHistory.get(colourHistory.size() - 2);
  }

  public Colour getLeastUsedColour() {
    colourHistory.remove(colourHistory.size() - 1);
    int redCount = 0;
    int greenCount = 0;
    int blueCount = 0;
    int yellowCount = 0;
    for (Colour col : colourHistory) {
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
    colourHistory.add(colour);

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

  @Override
  public void play() {
    int iteration = 1;
    do {
      if (iteration == 1) {
        iteration++;
      } else {
        MessageCli.INVALID_HUMAN_INPUT.printMessage();
      }
      MessageCli.ASK_HUMAN_INPUT.printMessage();
      String[] input = Utils.scanner.nextLine().trim().split(" ");
      if (input.length != 2) {
        continue;
      }
      colour = Colour.fromInput(input[0]);
      guess = Colour.fromInput(input[1]);
    } while (colour == null || guess == null);

    colourHistory.add(colour);

    MessageCli.PRINT_INFO_MOVE.printMessage(name, colour, guess);
  }
}
