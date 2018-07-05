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
 * Class PatternCard: represents the card in the panel of a player, every card is characterized by a name and a difficulty, and a list
 * of box that represents the 20 box of the card. The pattern could be custom, personalized by the player or a standard one provided
 * from the game.
 * The class is responsible of put the dice in the box, checking the constraint imposed by the rule. The cards are dynamically
 * loaded from file .json, to lets the user of the class add new card in an easy way
 * @author adrianomundo
 */
public class PatternCard implements Serializable {
     private String name;
     private int difficulty;
     private ArrayList<GlassBox> pattern;
     private boolean custom = false;

    /**
     * Class default constructor re-definition
     */
    public PatternCard() {
         this.name = null;
         this.difficulty = 0;
         this.pattern = null;
         this.custom = false;
    }

    /**
     * Class copy constructor, create a new Pattern Card from an old Pattern Card,useful to create a safe copy
     * @param patternCard to copy
     */
    public PatternCard(PatternCard patternCard) {
         this.name = patternCard.getName();
         this.difficulty = patternCard.getDifficulty();
         this.pattern = patternCard.getPattern();
         this.custom = patternCard.isCustom();
    }

    /**
     * method that provide the caller information about the card, if it is a custom card created by the player
     * or is a standard card provided by the game
     * @return boolean of the request
     */
    public boolean isCustom() {
        return custom;
    }

    /**
     * method that provide the caller the difficulty of the pattern card
     * @return int value of the difficulty
     */
    public int getDifficulty(){
        return difficulty;
    }

    /**
     * method that provide the caller the name of the pattern card
     * @return String of the name
     */
    public String getName(){
        return name;
    }

    /**
     * method that provide the caller the list of the box of the pattern card at the moment of the call
     * @return a list of box
     */
    public ArrayList<GlassBox> getPattern() {
        return pattern;
    }

    /**
     * method that provide the caller the dice positioned on the card at a specified index in the box list
     * @param index of the box list
     * @return the dice
     */
    public Dice getDice(int index) {
        GlassBox box = pattern.get(index);
        return box.getDice();
    }

    /**
     * method that allow the caller to set if a card is a custom one or is a standard one
     * @param custom boolean that specified the characteristic of the card
     */
    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    /**
     * method that allow the caller to put a dice if the box is empty ignoring the restrictions of the card
     * @param dice to put on the box
     * @param index of the box list
     */
    public void putAnyDice(Dice dice, int index) {

         GlassBox box = pattern.get(index);
         if (box.isBoxEmpty()) {
             box.setDice(dice);
             pattern.set(index, box);
         }
    }


    /**
     * method that allow the user to put the dice on the box checking the constraint color or value
     * @param dice to put on the box
     * @param index of the box list
     * @throws InvalidMoveException
     */
     // put dice on the box, but doing a check of the contrainst color or value
     public void putDice(Dice dice, int index) throws InvalidMoveException {

          GlassBox box = pattern.get(index);

          if (box.isBoxValid(dice)) {
               pattern.set(index, box);
          }
          else
               throw new InvalidMoveException("Invalid Constraint Value or Color");
     }

    /**
     * method that allow the user to put the dice on the box ignoring color restrictions
     * @param dice to put on the box
     * @param index of the box list
     * @throws InvalidMoveException
     */
    public void putDiceEglomise(Dice dice, int index) throws InvalidMoveException {

        GlassBox box = pattern.get(index);

        if (box.isBoxValidEglomise(dice)) {
            pattern.set(index, box);
        }
        else
            throw new InvalidMoveException("Invalid Constraint Value");
    }

    /**
     * method that allow the user to put the dice on the box ignoring shade restrictions
     * @param dice to put on the box
     * @param index of the box list
     * @throws InvalidMoveException
     */
    public void putDiceCopper(Dice dice, int index) throws InvalidMoveException {

        GlassBox box = pattern.get(index);

        if (box.isBoxValidCopper(dice)) {
            pattern.set(index, box);
        }
        else
            throw new InvalidMoveException("Invalid Constraint Color");
    }

    /**
     * method that allow the user to remove a dice from the box specified as parameter
     * @param index of the box list
     * @return the dice removed from the box
     */
     public Dice removeDice(int index) {

          GlassBox box = pattern.get(index);
          Dice diceRemoved;
          diceRemoved = box.unsetDice();
          return diceRemoved;
     }


    /**
     * method that allow the user to put a dice on a box of the pattern card indicated
     * @param dice to put on the box
     * @param index of the box list
     * @param patternCard where to put the dice
     * @throws InvalidMoveException if the move is incorrect
     */
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

    /**
     *  method that allow the user to put a dice on a box of the pattern card indicated ignoring color restrictions
     * @param dice to put on the box
     * @param index of the box list
     * @param patternCard where to put the dice
     * @throws InvalidMoveException if the move is incorrect
     */
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

    /**
     * method that allow the user to put a dice on a box of the pattern card indicated ignoring shade restrictions
     * @param dice to put on the box
     * @param index of the box list
     * @param patternCard where to put the dice
     * @throws InvalidMoveException if the move is incorrect
     */

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

    /**
     * helper method used from the other method of the class to check if the dice obey to the restrictions
     * of the the near dice positioned
     * @param dice to put on the box
     * @param index of the box list
     * @return a boolean value for the (un)successful check
     */
     private boolean checkNearConstraint(Dice dice, int index) {

         GlassBox box = pattern.get(index);
         if (box.isBoxEmpty()) {
             return true;
         } else {
             if ((box.getDice().getColor() == dice.getColor())) {
                 return false;
             }
             else {
                 return (box.getDice().getValue()) != (dice.getValue());
             }
         }
     }


    /**
     * helper method to check if the box at the specified index is empty
     * @param index to check
     * @return a boolean value for (un)successful check
     */
     private boolean checkNearEmpty(int index) {

         GlassBox box = pattern.get(index);
         return box.isBoxEmpty();

     }


    /**
     * helper method to check if the first dice placed on the card is on edge or a corner
     * @param index to check
     * @return boolean value for (un)successful check
     */
     private boolean checkFirstDice(int index) {

         Integer[] corner = {0,1,2,3,4,5,9,10,14,15,16,17,18,19};

         return Arrays.asList(corner).contains(index);
     }


    /**
     * helper method to check if the pattern card is empty (no dice placed on it) or not
     * @param patternCard to check
     * @return boolean value for (un)successful check
     */
    private boolean isPatternEmpty(PatternCard patternCard) {

          ArrayList <GlassBox> patternCopy = patternCard.getPattern();

          for(GlassBox box : patternCopy) {

              if (!(box.isBoxEmpty())) {
                  return false;
              }

          }
          return true;
    }

    /**
     * method that allow the caller to load the list of the standard pattern card from file json
     * @return a list of tha pattern card loaded
     */
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

    /**
     * method that allow the caller to load a pattern card from a file json format
     * @param inputStream to get the resources as a stream
     * @return the PatternCard object loaded from file
     */
    public PatternCard loadCard(InputStream inputStream) {
          Gson gson = new Gson();
          JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
          return gson.fromJson(reader, PatternCard.class);

    }

    /**
     * helper method that allow the caller to load a blank pattern card from file to use it for testing
     * @return the PatternCard object loaded from file
     */
    public PatternCard  loadPatternForTesting() {

         InputStream input = PatternCard.class.getResourceAsStream("/json/" + 25 + ".json");
         return loadCard(input);
    }

    /**
     * Override of the Object toString method to provide the caller of a String version of a Pattern Card
     * @return String format of a Pattern Card object
     */
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