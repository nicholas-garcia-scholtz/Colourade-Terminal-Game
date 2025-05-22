package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.cli.Utils;
import nz.ac.auckland.se281.model.Colour;

public class Human extends Player {

  public Human(String name) {
    super(name);
  }

  @Override
  public void play() {
    int iteration = 1;
    do {
      if (iteration == 1) {
        // first iteration so dont output invalid
        iteration++;
      } else {
        MessageCli.INVALID_HUMAN_INPUT.printMessage();
      }
      MessageCli.ASK_HUMAN_INPUT.printMessage();
      String[] input = Utils.scanner.nextLine().trim().split(" ");

      // Check to see if the number of input arguments is valid
      if (input.length != 2) {
        continue;
      }

      // Check if the actual input arguments are valid
      colour = Colour.fromInput(input[0]);
      guess = Colour.fromInput(input[1]);
    } while (colour == null || guess == null);

    MessageCli.PRINT_INFO_MOVE.printMessage(name, colour, guess);
  }
}
