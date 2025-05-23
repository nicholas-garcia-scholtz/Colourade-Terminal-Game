package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class Random implements Strategy {

  @Override
  public Colour[] decideColours() {
    // return a random colour for both the colour and guess
    return new Colour[] {Colour.getRandomColourForAi(), Colour.getRandomColourForAi()};
  }
}
