package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;

import java.util.Arrays;


public class DiagonalColor implements PublicEffects {


   @Override
   public int RunPublic(PatternCard pattern) {
      int points = 0;
      boolean[] control = new boolean[20];
      Arrays.fill(control, Boolean.FALSE);
      for (int i = 0; i < pattern.getPattern().size(); i = i+5){
         for(int j = 0; j < 4; j++)
            if ((pattern.getPattern().get(i + j).getDice().getColor() == pattern.getPattern().get(i + j + 6).getDice().getColor())) {
               if (!(control[i + j] && control[i + j + 6])) {
                  points++;
               }
               control[i + j] = true;
               control[i + j + 6] = true;
               points++;
            }
      }
      for (int i = 1; i < pattern.getPattern().size(); i = i+5){
         for(int j = 0; j < 4; j++){
            if((pattern.getPattern().get(i+j).getDice().getColor() == pattern.getPattern().get(i +j+ 4).getDice().getColor())){
               if (!(control[i+j] && control[i+j+6])) {
                  points++;
               }
               control[i+j] = true;
               control[i+j+4] = true;
               points++;
            }
         }
      }


      return points;
   }


   }



