package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.model.Colour;

public class Ai extends Player {
  private Strategy strat;
  private Level level;

  public Ai(Difficulty difficulty, String name, GameStats stats) {
    super(name);
    this.level = LevelFactory.createLevel(difficulty, stats);
    this.name = name;
  }

  @Override
  public void play() {
    setStrategy(level.decideStrategy());
    Colour[] decidedColours = strat.decideColours();
    colour = decidedColours[0];
    guess = decidedColours[1];
    MessageCli.PRINT_INFO_MOVE.printMessage(name, colour, guess);
  }

  public void setStrategy(Strategy strat) {
    this.strat = strat;
  }
}
