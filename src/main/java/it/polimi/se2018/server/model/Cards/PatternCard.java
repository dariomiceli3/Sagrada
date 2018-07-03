package it.polimi.se2018.server.model.Cards;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.server.model.Components.GlassBox;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.exceptions.InvalidMoveException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The class responsible of the representation of the Pattern Card, adding dice on it and load from json
 * @author adrianomundo
 */

public class PatternCard implements Serializable {
     private String name;
     private int difficulty;
     private ArrayList<GlassBox> pattern;
     private Dice dice;
     private boolean custom = false;

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

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


     public void putAnyDice(Dice dice, int index) {

         GlassBox box = pattern.get(index);
         if (box.isBoxEmpty()) {
             box.setDice(dice);
             pattern.set(index, box);
         }
     }



     // put dice on the box, but doing a check of the contrainst color or value
     public void putDice(Dice dice, int index) throws InvalidMoveException {

          GlassBox box = pattern.get(index);

          if (box.isBoxValid(dice)) {
               pattern.set(index, box);
          }
          else
               throw new InvalidMoveException("Invalid Constraint Value or Color");
     }

    public void putDiceEglomise(Dice dice, int index) throws InvalidMoveException {

        GlassBox box = pattern.get(index);

        if (box.isBoxValidEglomise(dice)) {
            pattern.set(index, box);
        }
        else
            throw new InvalidMoveException("Invalid Constraint Value");
    }
    public void putDiceCopper(Dice dice, int index) throws InvalidMoveException {

        GlassBox box = pattern.get(index);

        if (box.isBoxValidCopper(dice)) {
            pattern.set(index, box);
        }
        else
            throw new InvalidMoveException("Invalid Constraint Color");
    }

     // remove dice from the box
     public Dice removeDice(int index) {

          GlassBox box = pattern.get(index);

          Dice diceRemoved;
          diceRemoved = box.unsetDice();
          return diceRemoved;
     }


     public void putDiceOnPattern(Dice dice, int index, PatternCard patternCard) throws InvalidMoveException {

         if (isPatternEmpty(patternCard)) {
             if (checkFirstDice(index)) {
                 patternCard.putDice(dice, index);
             }
             else {
                 throw  new InvalidMoveException("Invalid initial position");
             }
         }
         else {

             if (index == 0) {

                 if ((checkNearEmpty(index + 1)) &&
                         (checkNearEmpty(index + 5))) {
                     if (checkNearEmpty(index + 6)) {
                         throw new InvalidMoveException("Invalid Near position");
                     }
                     else {
                         patternCard.putDice(dice, index);
                     }
                 }
                 else {
                     if ((checkNearConstraint(dice, index + 1)) &&
                             (checkNearConstraint(dice, index + 5)) ) {
                         patternCard.putDice(dice, index);
                     }
                     else {
                         throw new InvalidMoveException("Invalid near position");
                     }
                 }
             }

             if ((index == 1) || (index == 2) || (index == 3)) {

                 if ((checkNearEmpty(index - 1)) &&
                         (checkNearEmpty(index + 1)) &&
                         (checkNearEmpty(index + 5)) ) {
                     if ((checkNearEmpty(index + 4)) &&
                             (checkNearEmpty(index + 6)) ) {
                         throw new InvalidMoveException("Invalid near position");
                     }
                     else {
                         patternCard.putDice(dice, index);
                     }
                 }
                 else {
                     if ((checkNearConstraint(dice, index - 1)) &&
                             (checkNearConstraint(dice, index + 1)) &&
                             (checkNearConstraint(dice, index + 5)) ) {
                         patternCard.putDice(dice, index);
                     }
                     else {
                         throw  new InvalidMoveException("Invalid near position");
                     }
                 }

             }

             if (index == 4) {

                 if ((checkNearEmpty(index - 1)) &&
                         (checkNearEmpty(index + 5)) ) {
                     if (checkNearEmpty(index + 4)) {
                         throw  new InvalidMoveException("Invalid near position");
                     }
                     else {
                         patternCard.putDice(dice, index);
                     }
                 }
                 else {
                     if ((checkNearConstraint(dice, index - 1)) &&
                             (checkNearConstraint(dice, index + 5)) ) {
                         patternCard.putDice(dice, index);
                     }
                     else {
                         throw  new InvalidMoveException("Invalid near position");
                     }
                 }
             }

             if ((index == 5) || (index == 10)) {

                 if ((checkNearEmpty(index - 5)) &&
                         (checkNearEmpty(index + 1)) &&
                         (checkNearEmpty(index + 5)) ) {
                     if ((checkNearEmpty(index - 4)) &&
                             (checkNearEmpty(index + 6)) ) {
                         throw  new InvalidMoveException("Invalid near position");
                     }
                     else {
                         patternCard.putDice(dice, index);
                     }

                 }
                 else {
                     if ((checkNearConstraint(dice,index - 5)) &&
                             (checkNearConstraint(dice,index + 1)) &&
                             (checkNearConstraint(dice,index + 5)) ) {
                         patternCard.putDice(dice, index);
                     }
                     else {
                         throw new InvalidMoveException("Invalid near position");
                     }
                 }
             }

             if ((index == 6) || (index == 7) || (index == 8) || (index == 11) || (index == 12) || (index == 13)) {

                 if ((checkNearEmpty(index - 5 )) &&
                         (checkNearEmpty(index - 1 )) &&
                         (checkNearEmpty(index + 1 )) &&
                         (checkNearEmpty(index + 5)) ) {
                     if ((checkNearEmpty(index - 6)) &&
                             (checkNearEmpty(index - 4)) &&
                             (checkNearEmpty(index + 4 )) &&
                             (checkNearEmpty(index + 6)) ) {
                         throw new InvalidMoveException("Invalid near position");
                     }
                     else {
                         patternCard.putDice(dice, index);
                     }
                 }
                 else {
                     if ((checkNearConstraint(dice,index - 5)) &&
                             (checkNearConstraint(dice,index - 1)) &&
                             (checkNearConstraint(dice,index + 1)) &&
                             (checkNearConstraint(dice,index + 5))) {
                         patternCard.putDice(dice, index);
                     }
                     else {
                         throw  new InvalidMoveException("Invalid near position");
                     }
                 }
             }

             if ((index == 9) || (index == 14)) {

                 if ((checkNearEmpty(index - 5)) &&
                         (checkNearEmpty(index - 1)) &&
                         (checkNearEmpty(index + 5)) ) {
                     if ((checkNearEmpty(index - 6)) &&
                             (checkNearEmpty(index + 4))) {
                         throw  new InvalidMoveException("Invalid near position");

                     }
                     else {
                         patternCard.putDice(dice, index);
                     }
                 }
                 else {
                     if ((checkNearConstraint(dice, index - 5)) &&
                             (checkNearConstraint(dice, index - 1)) &&
                             (checkNearConstraint(dice, index + 5)) ){
                         patternCard.putDice(dice, index);
                     }
                     else {
                         throw new InvalidMoveException("Invalid near position");
                     }
                 }
             }

             if (index == 15) {

                 if ((checkNearEmpty(index - 5)) &&
                         (checkNearEmpty(index + 1)) ) {
                     if (checkNearEmpty(index - 4 )) {
                         throw new InvalidMoveException("Invalid near position");
                     }
                     else {
                         patternCard.putDice(dice, index);
                     }
                 }
                 else {
                     if ((checkNearConstraint(dice, index - 5)) &&
                             (checkNearConstraint(dice, index + 1)) ) {
                         patternCard.putDice(dice, index);
                     }
                     else {
                         throw new InvalidMoveException("Invalid near position");
                     }
                 }
             }

             if ((index == 16) || (index == 17) || (index == 18)) {

                 if ((checkNearEmpty(index - 5)) &&
                         (checkNearEmpty(index - 1)) &&
                         (checkNearEmpty(index + 1)) ) {
                     if ((checkNearEmpty(index - 6 )) &&
                             (checkNearEmpty(index - 4)) ) {
                         throw new InvalidMoveException("Invalid near position");
                     }
                     else {
                         patternCard.putDice(dice, index);
                     }
                 }
                 else {
                     if ((checkNearConstraint(dice, index - 5)) &&
                             (checkNearConstraint(dice, index - 1)) &&
                             (checkNearConstraint(dice, index + 1)) ) {
                         patternCard.putDice(dice, index);
                     }
                     else {
                         throw new InvalidMoveException("Invalid near position");
                     }
                 }
             }

             if (index == 19) {

                 if ((checkNearEmpty(index - 5)) &&
                         (checkNearEmpty(index - 1)) ) {
                     if (checkNearEmpty(index - 6 )) {
                         throw new InvalidMoveException("Invalid near position");
                     }
                     else {
                         patternCard.putDice(dice, index);
                     }
                 }
                 else {
                     if ((checkNearConstraint(dice, index - 5)) &&
                             (checkNearConstraint(dice, index - 1)) ) {
                         patternCard.putDice(dice, index);
                     }
                     else {
                         throw new InvalidMoveException("Invalid near position");
                     }
                 }
             }

         }
     }

    public void putDiceOnPatternEglomise(Dice dice, int index, PatternCard patternCard) throws InvalidMoveException {

        if (isPatternEmpty(patternCard)) {
            if (checkFirstDice(index)) {
                patternCard.putDiceEglomise(dice, index);
            }
            else {
                throw  new InvalidMoveException("Invalid initial position");
            }
        }
        else {

            if (index == 0) {

                if ((checkNearEmpty(index + 1)) &&
                        (checkNearEmpty(index + 5))) {
                    if (checkNearEmpty(index + 6)) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceEglomise(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index + 1)) &&
                            (checkNearConstraint(dice, index + 5)) ) {
                        patternCard.putDiceEglomise(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if ((index == 1) || (index == 2) || (index == 3)) {

                if ((checkNearEmpty(index - 1)) &&
                        (checkNearEmpty(index + 1)) &&
                        (checkNearEmpty(index + 5)) ) {
                    if ((checkNearEmpty(index + 4)) &&
                            (checkNearEmpty(index + 6)) ) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceEglomise(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 1)) &&
                            (checkNearConstraint(dice, index + 1)) &&
                            (checkNearConstraint(dice, index + 5)) ) {
                        patternCard.putDiceEglomise(dice, index);
                    }
                    else {
                        throw  new InvalidMoveException("Invalid near position");
                    }
                }

            }

            if (index == 4) {

                if ((checkNearEmpty(index - 1)) &&
                        (checkNearEmpty(index + 5)) ) {
                    if (checkNearEmpty(index + 4)) {
                        throw  new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceEglomise(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 1)) &&
                            (checkNearConstraint(dice, index + 5)) ) {
                        patternCard.putDiceEglomise(dice, index);
                    }
                    else {
                        throw  new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if ((index == 5) || (index == 10)) {

                if ((checkNearEmpty(index - 5)) &&
                        (checkNearEmpty(index + 1)) &&
                        (checkNearEmpty(index + 5)) ) {
                    if ((checkNearEmpty(index - 4)) &&
                            (checkNearEmpty(index + 6)) ) {
                        throw  new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceEglomise(dice, index);
                    }

                }
                else {
                    if ((checkNearConstraint(dice,index - 5)) &&
                            (checkNearConstraint(dice,index + 1)) &&
                            (checkNearConstraint(dice,index + 5)) ) {
                        patternCard.putDiceEglomise(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if ((index == 6) || (index == 7) || (index == 8) || (index == 11) || (index == 12) || (index == 13)) {

                if ((checkNearEmpty(index - 5 )) &&
                        (checkNearEmpty(index - 1 )) &&
                        (checkNearEmpty(index + 1 )) &&
                        (checkNearEmpty(index + 5)) ) {
                    if ((checkNearEmpty(index - 6)) &&
                            (checkNearEmpty(index - 4)) &&
                            (checkNearEmpty(index + 4 )) &&
                            (checkNearEmpty(index + 6)) ) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceEglomise(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice,index - 5)) &&
                            (checkNearConstraint(dice,index - 1)) &&
                            (checkNearConstraint(dice,index + 1)) &&
                            (checkNearConstraint(dice,index + 5))) {
                        patternCard.putDiceEglomise(dice, index);
                    }
                    else {
                        throw  new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if ((index == 9) || (index == 14)) {

                if ((checkNearEmpty(index - 5)) &&
                        (checkNearEmpty(index - 1)) &&
                        (checkNearEmpty(index + 5)) ) {
                    if ((checkNearEmpty(index - 6)) &&
                            (checkNearEmpty(index + 4))) {
                        throw  new InvalidMoveException("Invalid near position");

                    }
                    else {
                        patternCard.putDiceEglomise(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 5)) &&
                            (checkNearConstraint(dice, index - 1)) &&
                            (checkNearConstraint(dice, index + 5)) ){
                        patternCard.putDiceEglomise(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if (index == 15) {

                if ((checkNearEmpty(index - 5)) &&
                        (checkNearEmpty(index + 1)) ) {
                    if (checkNearEmpty(index - 4 )) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceEglomise(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 5)) &&
                            (checkNearConstraint(dice, index + 1)) ) {
                        patternCard.putDiceEglomise(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if ((index == 16) || (index == 17) || (index == 18)) {

                if ((checkNearEmpty(index - 5)) &&
                        (checkNearEmpty(index - 1)) &&
                        (checkNearEmpty(index + 1)) ) {
                    if ((checkNearEmpty(index - 6 )) &&
                            (checkNearEmpty(index - 4)) ) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceEglomise(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 5)) &&
                            (checkNearConstraint(dice, index - 1)) &&
                            (checkNearConstraint(dice, index + 1)) ) {
                        patternCard.putDiceEglomise(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if (index == 19) {

                if ((checkNearEmpty(index - 5)) &&
                        (checkNearEmpty(index - 1)) ) {
                    if (checkNearEmpty(index - 6 )) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceEglomise(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 5)) &&
                            (checkNearConstraint(dice, index - 1)) ) {
                        patternCard.putDiceEglomise(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

        }
    }

    public void putDiceOnPatternCopper(Dice dice, int index, PatternCard patternCard) throws InvalidMoveException {

        if (isPatternEmpty(patternCard)) {
            if (checkFirstDice(index)) {
                patternCard.putDiceCopper(dice, index);
            }
            else {
                throw  new InvalidMoveException("Invalid initial position");
            }
        }
        else {

            if (index == 0) {

                if ((checkNearEmpty(index + 1)) &&
                        (checkNearEmpty(index + 5))) {
                    if (checkNearEmpty(index + 6)) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceCopper(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index + 1)) &&
                            (checkNearConstraint(dice, index + 5)) ) {
                        patternCard.putDiceCopper(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if ((index == 1) || (index == 2) || (index == 3)) {

                if ((checkNearEmpty(index - 1)) &&
                        (checkNearEmpty(index + 1)) &&
                        (checkNearEmpty(index + 5)) ) {
                    if ((checkNearEmpty(index + 4)) &&
                            (checkNearEmpty(index + 6)) ) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceCopper(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 1)) &&
                            (checkNearConstraint(dice, index + 1)) &&
                            (checkNearConstraint(dice, index + 5)) ) {
                        patternCard.putDiceCopper(dice, index);
                    }
                    else {
                        throw  new InvalidMoveException("Invalid near position");
                    }
                }

            }

            if (index == 4) {

                if ((checkNearEmpty(index - 1)) &&
                        (checkNearEmpty(index + 5)) ) {
                    if (checkNearEmpty(index + 4)) {
                        throw  new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceCopper(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 1)) &&
                            (checkNearConstraint(dice, index + 5)) ) {
                        patternCard.putDiceCopper(dice, index);
                    }
                    else {
                        throw  new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if ((index == 5) || (index == 10)) {

                if ((checkNearEmpty(index - 5)) &&
                        (checkNearEmpty(index + 1)) &&
                        (checkNearEmpty(index + 5)) ) {
                    if ((checkNearEmpty(index - 4)) &&
                            (checkNearEmpty(index + 6)) ) {
                        throw  new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceCopper(dice, index);
                    }

                }
                else {
                    if ((checkNearConstraint(dice,index - 5)) &&
                            (checkNearConstraint(dice,index + 1)) &&
                            (checkNearConstraint(dice,index + 5)) ) {
                        patternCard.putDiceCopper(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if ((index == 6) || (index == 7) || (index == 8) || (index == 11) || (index == 12) || (index == 13)) {

                if ((checkNearEmpty(index - 5 )) &&
                        (checkNearEmpty(index - 1 )) &&
                        (checkNearEmpty(index + 1 )) &&
                        (checkNearEmpty(index + 5)) ) {
                    if ((checkNearEmpty(index - 6)) &&
                            (checkNearEmpty(index - 4)) &&
                            (checkNearEmpty(index + 4 )) &&
                            (checkNearEmpty(index + 6)) ) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceCopper(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice,index - 5)) &&
                            (checkNearConstraint(dice,index - 1)) &&
                            (checkNearConstraint(dice,index + 1)) &&
                            (checkNearConstraint(dice,index + 5))) {
                        patternCard.putDiceCopper(dice, index);
                    }
                    else {
                        throw  new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if ((index == 9) || (index == 14)) {

                if ((checkNearEmpty(index - 5)) &&
                        (checkNearEmpty(index - 1)) &&
                        (checkNearEmpty(index + 5)) ) {
                    if ((checkNearEmpty(index - 6)) &&
                            (checkNearEmpty(index + 4))) {
                        throw  new InvalidMoveException("Invalid near position");

                    }
                    else {
                        patternCard.putDiceCopper(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 5)) &&
                            (checkNearConstraint(dice, index - 1)) &&
                            (checkNearConstraint(dice, index + 5)) ){
                        patternCard.putDiceCopper(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if (index == 15) {

                if ((checkNearEmpty(index - 5)) &&
                        (checkNearEmpty(index + 1)) ) {
                    if (checkNearEmpty(index - 4 )) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceCopper(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 5)) &&
                            (checkNearConstraint(dice, index + 1)) ) {
                        patternCard.putDiceCopper(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if ((index == 16) || (index == 17) || (index == 18)) {

                if ((checkNearEmpty(index - 5)) &&
                        (checkNearEmpty(index - 1)) &&
                        (checkNearEmpty(index + 1)) ) {
                    if ((checkNearEmpty(index - 6 )) &&
                            (checkNearEmpty(index - 4)) ) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceCopper(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 5)) &&
                            (checkNearConstraint(dice, index - 1)) &&
                            (checkNearConstraint(dice, index + 1)) ) {
                        patternCard.putDiceCopper(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

            if (index == 19) {

                if ((checkNearEmpty(index - 5)) &&
                        (checkNearEmpty(index - 1)) ) {
                    if (checkNearEmpty(index - 6 )) {
                        throw new InvalidMoveException("Invalid near position");
                    }
                    else {
                        patternCard.putDiceCopper(dice, index);
                    }
                }
                else {
                    if ((checkNearConstraint(dice, index - 5)) &&
                            (checkNearConstraint(dice, index - 1)) ) {
                        patternCard.putDiceCopper(dice, index);
                    }
                    else {
                        throw new InvalidMoveException("Invalid near position");
                    }
                }
            }

        }
    }


    // check if the constraint of the near dice are respected
     private boolean checkNearConstraint(Dice dice, int index) {

         GlassBox box = pattern.get(index);
         if (box.isBoxEmpty()) {
             return true;
         } else {
             if ((box.getDice().getColor() == dice.getColor())) {
                 return false;
             } else {
                 return (box.getDice().getValue()) != (dice.getValue());
             }
         }
     }


     // check if a dice at the index is empty or not
     private boolean checkNearEmpty(int index) {

          GlassBox box = pattern.get(index);

         return box.isBoxEmpty();

     }


     // check if the first dice is placed on an edge or corner
     private boolean checkFirstDice(int index) {

         Integer[] corner = {0,1,2,3,4,5,9,10,14,15,16,17,18,19};

         return Arrays.asList(corner).contains(index);
     }


     // check if the pattern scheme is empty (no dice placed) or not
     private boolean isPatternEmpty(PatternCard patternCard) {

          ArrayList <GlassBox> patternCopy = patternCard.getPattern();

          for(GlassBox box : patternCopy) {

              if (!(box.isBoxEmpty())) {
                  return false;
              }

          }
          return true;

     }


     public ArrayList<PatternCard> loadPatternList() {
         InputStream input;
         final int NUMBER_OF_CARDS = 24;
              ArrayList<PatternCard> patternList = new ArrayList<>();

              for (int i = 1; i <= NUMBER_OF_CARDS; i++) {

                  input = PatternCard.class.getResourceAsStream( "/json/" + i + ".json");
                  patternList.add(loadCard(input));
              }

              return patternList;
              }

     public PatternCard loadCard(InputStream inputStream)
     {
          Gson gson = new Gson();
          JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
          return gson.fromJson(reader, PatternCard.class);

     }

    public PatternCard  loadPatternForTesting() {

         InputStream input = PatternCard.class.getResourceAsStream("/json/" + 25 + ".json");
         return loadCard(input);
    }

     @Override
    public String toString() {

         String card = "Pattern Card Name: " + this.name + "\n" + "Difficulty: " + this.difficulty + "\n";

         for (int i = 0; i < pattern.size(); i++) {

             card = card + pattern.get(i).toString();
             if (i == 4 || i == 9 || i == 14){
                 card = card + "\n";
             }
             else {
                 card = card + " ";
             }
         }
         return card;
     }
}