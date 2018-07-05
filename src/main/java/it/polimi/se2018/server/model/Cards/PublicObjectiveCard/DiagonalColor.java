package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Class DiagonalColor: it represents the public card Diagonal Color of the game and its effect
 * @author fadda-miceli-mundo
 */
public class DiagonalColor implements PublicEffects, Serializable {

private static final String NAME = "Color Diagonals";

   /**
    * Override of the method of the interface for the DP Strategy with the algorithms of the Diagonal Color card, that
    * sums the values of the dice found diagonally adjacent
    * @param pattern where to run the effect
    * @return the points calculated by running this effect
    */
   @Override
   public int runPublic(PatternCard pattern) {
      int points = 0;
      boolean[] control = new boolean[20];
      Arrays.fill(control, Boolean.FALSE);
      for (int i = 0; i < 15; i = i + 5) {
         for (int j = 0; j < 4; j++) {
            if (!(pattern.getPattern().get(i + j).isBoxEmpty() || pattern.getPattern().get(i + j + 6).isBoxEmpty())) {
               if ((pattern.getPattern().get(i + j).getDice().getColor() == pattern.getPattern().get(i + j + 6).getDice().getColor())) {
                  control[i + j] = true;
                  control[i + j + 6] = true;
               }
            }

         }

      }
      for (int i = 1; i < 15; i = i + 5) {
         for (int j = 0; j < 4; j++) {
            if (!(pattern.getPattern().get(i + j).isBoxEmpty() || pattern.getPattern().get(i + j + 4).isBoxEmpty())) {
               if ((pattern.getPattern().get(i + j).getDice().getColor() == pattern.getPattern().get(i + j + 4).getDice().getColor())) {
                  control[i + j] = true;
                  control[i + j + 4] = true;
               }
            }
         }
      }
      for (int i = 0; i < 20; i++) {
         if (control[i]) {
            points++;
         }
      }

      return points;
   }

   /**
    * Override of the Object toString method to provide the caller of a String version of a Diagonal Color card
    * @return string format of the card
    */
   @Override
   public String toString(){
      return NAME + "\n"
              + "Count of diagonally adjacent same color dice" + "\n"
              + "VP : #";
   }


}




