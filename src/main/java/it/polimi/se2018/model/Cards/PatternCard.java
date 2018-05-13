package it.polimi.se2018.model.Cards;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.model.Components.GlassBox;
import it.polimi.se2018.model.Components.Dice;
import it.polimi.se2018.Exceptions.InvalidMoveException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PatternCard {
     private String name;
     private int difficulty;
     private ArrayList<GlassBox> pattern;
     private Dice dice;

     public int getDifficulty(){
          return difficulty;
     }

     public String getName(){
          return name;
     }

     public ArrayList<GlassBox> getPattern() {
          return pattern;
     }

     public Dice getDice(int index) {
          GlassBox box = pattern.get(index);
          return box.getDice();
     }


     // put dice on the box
     public void putDice(Dice dice, int index) throws InvalidMoveException {

          GlassBox box = pattern.get(index);

          if (box.isBoxValid(dice)) {
               pattern.set(index, box);
          }
          else
               throw new InvalidMoveException("Invalid Dice Position");
     }

     // remove dice from the box
     public Dice removeDice(Dice dice, int index) {

          GlassBox box = pattern.get(index);

          Dice diceRemoved;
          diceRemoved = box.unsetDice();
          return diceRemoved;
     }


     public void putDiceOnPattern(Dice dice, int index, PatternCard patternCard) throws InvalidMoveException {

          if (isPatternEmpty(patternCard)) {
               if (checkFirstDice(index)){
                    patternCard.putDice(dice, index);
               }
               else {
                    throw new InvalidMoveException("Invalid Initial Position");
               }
          }
          else {

               if (index == 0){

                    if ((checkNearDice(dice, index + 1)) &&
                            (checkNearDice(dice, index + 5)) &&
                            (checkNearDice(dice, index + 6))) {

                         patternCard.putDice(dice, index);
                    }
                    else throw new InvalidMoveException("Invalid Position");
               }

               else if ((index == 1) || (index == 2) || (index == 3)) {

                    if ((checkNearDice(dice, index - 1)) &&
                            (checkNearDice(dice, index + 1)) &&
                            (checkNearDice(dice, index + 4)) &&
                            (checkNearDice(dice, index + 5)) &&
                            (checkNearDice(dice, index + 6)) ) {

                         patternCard.putDice(dice, index);
                    }
                    else throw new InvalidMoveException("Invalid position");

               }

               else if (index == 4) {

                    if ((checkNearDice(dice, index - 1)) &&
                            (checkNearDice(dice, index + 4)) &&
                            (checkNearDice(dice, index + 5)) ) {

                         patternCard.putDice(dice, index);
                    }
                    else throw new InvalidMoveException("Invalid position");

               }

               else if ((index == 5) || (index == 10)) {

                    if ((checkNearDice(dice, index - 5)) &&
                            (checkNearDice(dice, index -4)) &&
                            (checkNearDice(dice, index + 1)) &&
                            (checkNearDice(dice, index + 5)) &&
                            (checkNearDice(dice, index + 6)) ) {

                         patternCard.putDice(dice, index);
                    }

                    else throw new InvalidMoveException("Invalid position");

               }

               else if ((index == 6) || (index == 7) || (index == 8) || (index == 11) || (index == 12) || (index == 13)) {

                    if ((checkNearDice(dice, index - 6)) &&
                            (checkNearDice(dice, index - 5)) &&
                            (checkNearDice(dice, index - 4)) &&
                            (checkNearDice(dice, index - 1)) &&
                            (checkNearDice(dice, index + 1)) &&
                            (checkNearDice(dice, index + 4)) &&
                            (checkNearDice(dice, index + 5)) &&
                            (checkNearDice(dice, index + 6)) ) {

                         patternCard.putDice(dice, index);
                    }

                    else throw new InvalidMoveException("Invalid position");

               }

               else if ((index == 9) || (index == 14)) {

                    if ((checkNearDice(dice, index - 6)) &&
                            (checkNearDice(dice, index - 5)) &&
                            (checkNearDice(dice, index - 1)) &&
                            (checkNearDice(dice, index + 4)) &&
                            (checkNearDice(dice, index + 5)) ) {

                         patternCard.putDice(dice, index);
                    }

                    else throw new InvalidMoveException("Invalid position");

               }

               else if (index == 15) {

                    if ((checkNearDice(dice, index - 5)) &&
                            (checkNearDice(dice, index - 4)) &&
                            (checkNearDice(dice, index + 1)) ) {

                         patternCard.putDice(dice, index);
                    }
                    else throw new InvalidMoveException("Invalid position");

               }

               else if ((index == 16) || (index == 17) || (index == 18)) {

                    if ((checkNearDice(dice, index - 6)) &&
                            (checkNearDice(dice, index - 5)) &&
                            (checkNearDice(dice, index - 4)) &&
                            (checkNearDice(dice, index - 1)) &&
                            (checkNearDice(dice, index + 1)) ) {

                         patternCard.putDice(dice, index);
                    }
                    else throw new InvalidMoveException("Invalid position");

               }

               else if (index == 19) {

                    if ((checkNearDice(dice, index - 6)) &&
                            (checkNearDice(dice, index - 5)) &&
                            (checkNearDice(dice, index - 1)) ) {

                         patternCard.putDice(dice, index);
                    }
                    else throw new InvalidMoveException("Invalid position");

               }

          }

     }

     // check if the constraint of the near dice are respected
     private boolean checkNearDice(Dice dice, int index) {

          GlassBox box = pattern.get(index);

          if (!(box.isBoxEmpty())) {
               if ((box.getDice().getColor().toString()).equals(dice.getColor().toString())) {
                    return false;
               }
               else {
                    if ((box.getDice().getValue()) == (dice.getValue())) {
                         return false;
                    }
                    else {
                         return true;
                    }
               }
          }
          else return false;
     }

     // check if the first dice is placed on an edge or corner
     private boolean checkFirstDice(int index) {

          Integer[] corner = {0,1,2,3,4,5,9,10,14,15,16,17,18,19};

          if (Arrays.asList(corner).contains(index)) {
               return true;
          }
          else {
               return false;
          }
     }


     // check if the pattern scheme is empty (no dice placed) or not
     private boolean isPatternEmpty(PatternCard patternCard) {

          GlassBox box;
          Iterator<GlassBox> it = patternCard.getPattern().iterator();
          while (it.hasNext()) {
               box = it.next();
               if (!(box.isBoxEmpty())) return false;
          }
          return true;

     }

     /* fill the pattern card with all null values
     public void fillPattern() {

          final int NUMBER_OF_BOX = 20;
          GlassBox nullBox = new GlassBox();

          for (int i = 0; i < NUMBER_OF_BOX; i++) {
               pattern.add(nullBox);
          }

     }*/


     public ArrayList<PatternCard> loadPatternList() throws FileNotFoundException
     {

              final int NUMBER_OF_CARDS = 24;
              ArrayList<PatternCard> patternList = new ArrayList<>();

              File file = new File("./");
              String filePath = file.getAbsolutePath().replace(".", "src/main/res/json/");

              for (int i = 1; i <= NUMBER_OF_CARDS; i++) {

                  patternList.add(loadCard(filePath + i + ".json"));
              }

              return patternList;
              }

     private PatternCard loadCard(String fileName) throws FileNotFoundException
     {
          Gson gson = new Gson();
          JsonReader reader = new JsonReader(new FileReader(fileName));
          return gson.fromJson(reader, PatternCard.class);

     }
}