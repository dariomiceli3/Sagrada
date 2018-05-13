package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Components.GlassBox;

import java.util.ArrayList;
import java.util.Iterator;

public class DiagonalColor implements PublicEffects {



   @Override
   public int RunPublic(PatternCard pattern) {

      int points = 0;

      ArrayList<GlassBox> patternListCopy = pattern.getPattern();
      ArrayList<GlassBox> patternList = new ArrayList<>();
      patternList.addAll(patternListCopy);

      for (int index = 0; index < patternList.size(); index++) {

          GlassBox box = patternList.get(index);
          String color = box.getDice().getColor().toString();

          if (index == 1) {

              GlassBox boxTemp = patternList.get(index + 6);
              String colorTemp = box.getDice().getColor().toString();

              if (color.equals(colorTemp))
              {
                  points += 2;
              }




          }

      }

      return points;
   }


   }



