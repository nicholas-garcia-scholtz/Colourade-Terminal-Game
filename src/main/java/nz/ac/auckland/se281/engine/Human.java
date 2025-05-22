package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.cli.Utils;
import nz.ac.auckland.se281.model.Colour;

public class Human extends Player {
  private String name;

  public Human(String name) {
    super();
    this.name = name;
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

    MessageCli.PRINT_INFO_MOVE.printMessage(name, colour, guess);
  }
}
