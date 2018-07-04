package it.polimi.se2018.server.model.Components;

import org.fusesource.jansi.Ansi;

import java.io.Serializable;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Class GlassBox: representation in the game of a box of the window panel, contains the dice if there's one on it
 * and the constraint value or color of the Pattern Card used by the player during the game. It's also responsible
 * of putting the dice on the box and check if it the box is empty or the dice does not match the constraint of the card
 *  @author fadda-miceli-mundo
 *  @see java.io.Serializable
 */

public class GlassBox implements Serializable {

    private static final String escapeDice1 = "\u2680";
    private static final String escapeDice2 = "\u2681";
    private static final String escapeDice3 = "\u2682";
    private static final String escapeDice4 = "\u2683";
    private static final String escapeDice5 = "\u2684";
    private static final String escapeDice6 = "\u2685";
    private static final String escapeBlank = "\u25FC";
    private static final int DEFAULT = 0;
    private Dice dice;
    private int constraintValue;
    private String constraintColor;

    /**
     * Class default constructor re-definition for a box without constraint value or color
     */
    public GlassBox() {
        setDice(null);
        this.constraintValue = DEFAULT;
        this.constraintColor = null;
    }

    /**
     * Class constructor for a box with a constraint value
     * @param constraintValue of the cell
     */
    public GlassBox(int constraintValue) {
        setDice(null);
        this.constraintColor = null;
        this.constraintValue = constraintValue;
    }

    /**
     * Class constructor for a box with a constraint color
     * @param constraintColor of the cell
     */
    public GlassBox(String constraintColor) {
        setDice(null);
        this.constraintColor = constraintColor;
        this.constraintValue = DEFAULT;
    }

    /**
     * method that provides the caller of the dice contained in the box without removing it
     * @return the dice of the box
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * method that provides the caller of the constraint value of the selected box
     * @return int value of the constraint
     */
    public int getConstraintValue() {
        return constraintValue;
    }

    /**
     * method that provides the caller of the constraint color of the selected box
     * @return String format of the constraint
     */

    public String getConstraintColor() {
        return constraintColor;
    }

    /**
     * method that allow the caller to set the dice on the selected box
     */
    public void setDice(Dice dice) {
        this.dice = dice;
    }

    /**
     * method that allow the caller to remove a dice from a specific box and obtain it
     * @return dice that was on the box
     */
    public Dice unsetDice() {
        Dice diceReturned = this.dice;
        this.dice = null;
        return diceReturned;
    }


    /**
     * method that return to the caller the information of the presence of a dice in the specified box
     * @return true if there's no dice on the box
     */
    public boolean isBoxEmpty() {
        return this.dice == null;
    }

    /**
     * method used for put a dice on the box if the dice match the constraint of the selected box and it's empty
     * @param dice to put on the box
     * @return boolean value of the (un)successful set of the dice
     */
    public boolean isBoxValid (Dice dice) {
        if (isBoxEmpty()) {
            // si color no value case
            if (this.constraintColor != null) {
                if (this.constraintColor.equals(dice.getColor().toString())) {
                    setDice(dice);
                    return true;
                }
                else {
                    return false;
                }
            }
            // no color si value case
            else {

                return valueCase(dice);
            }
        }
        // box full case
        else return false;
    }

    /**
     * method used for put a dice on the box for the particular case of the Eglomise brush tool card
     * @param dice to put on the box
     * @return boolean value of the (un)successful set of the dice
     */
    public boolean isBoxValidEglomise(Dice dice) {
        if (isBoxEmpty()) {

            // si color no value case
            if (this.constraintColor != null) {
                    setDice(dice);
                    return true;
            }
            // no color si value case
            else {

               return valueCase(dice);
            }
        }
        // box full case
        else return false;
    }

    /**
     * method used for put a dice on the box for the particular case of the Copper foil burnisher tool card
     * @param dice to put on the box
     * @return boolean value of the (un)successful set of the dice
     */
    public boolean isBoxValidCopper(Dice dice) {
        if (isBoxEmpty()) {

            // si color no value case
            if (this.constraintColor != null) {
                if (this.constraintColor.equals(dice.getColor().toString())) {
                    setDice(dice);
                    return true;
                }
                else {
                    return false;
                }
            }
            // no color si value case
            else {
                    setDice(dice);
                    return true;
            }
        }
        // box full case
        else return false;
    }

    /**
     * method used for put a dice on the box after the check that the dice match the value restriction
     * @param dice to put on the box
     * @return boolean value of the (un)successful set of the dice
     */
    private boolean valueCase(Dice dice) {

        if (this.constraintValue != DEFAULT) {
            if (this.constraintValue == dice.getValue()) {
                setDice(dice);
                return true;
            } else {
                return false;
            }
        }
        // value = 0 e color = null case
        else {
            setDice(dice);
            return true;
        }

    }

    /**
     * Override of the Object toString method to provide the caller of a String version of a Glass Box.
     * The String representation use Jansi library and unicode characters to show the blank box and the box
     * with constraint value/color and the box with a set dice
     * @return string format of a glassbox
     */
    @Override
    public String toString() {

        if (isBoxEmpty()) {

            if (this.constraintColor != null) {
                if (this.constraintColor.equals("red")) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeBlank).reset());
                } else if (this.constraintColor.equals("green")) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeBlank).reset());
                } else if (this.constraintColor.equals("yellow")) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeBlank).reset());
                } else if (this.constraintColor.equals("blue")) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeBlank).reset());
                } else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeBlank).reset());
                }

            } else if (this.constraintValue != DEFAULT) {
                if (this.constraintValue == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.WHITE).a(escapeDice1).reset());
                } else if (this.constraintValue == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.WHITE).a(escapeDice2).reset());
                } else if (this.constraintValue == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.WHITE).a(escapeDice3).reset());
                } else if (this.constraintValue == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.WHITE).a(escapeDice4).reset());
                } else if (this.constraintValue == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.WHITE).a(escapeDice5).reset());
                } else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.WHITE).a(escapeDice6).reset());
                }
            } else {
                return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.WHITE).a(escapeBlank).reset());
            }
        } else {

            if (this.getDice().getColor().toString().equals("red")) {

                if (this.getDice().getValue() == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice1).reset());
                } else if (this.getDice().getValue() == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice2).reset());
                } else if (this.getDice().getValue() == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice3).reset());
                } else if (this.getDice().getValue() == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice4).reset());
                } else if (this.getDice().getValue() == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice5).reset());
                } else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice6).reset());
                }
            } else if (this.getDice().getColor().toString().equals("yellow")) {

                if (this.getDice().getValue() == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice1).reset());
                } else if (this.getDice().getValue() == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice2).reset());
                } else if (this.getDice().getValue() == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice3).reset());
                } else if (this.getDice().getValue() == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice4).reset());
                } else if (this.getDice().getValue() == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice5).reset());
                } else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice6).reset());
                }
            } else if (this.getDice().getColor().toString().equalsIgnoreCase("green")) {

                if (this.getDice().getValue() == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice1).reset());
                } else if (this.getDice().getValue() == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice2).reset());
                } else if (this.getDice().getValue() == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice3).reset());
                } else if (this.getDice().getValue() == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice4).reset());
                } else if (this.getDice().getValue() == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice5).reset());
                } else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice6).reset());
                }
            } else if (this.getDice().getColor().toString().equalsIgnoreCase("blue")) {

                if (this.getDice().getValue() == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice1).reset());
                } else if (this.getDice().getValue() == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice2).reset());
                } else if (this.getDice().getValue() == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice3).reset());
                } else if (this.getDice().getValue() == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice4).reset());
                } else if (this.getDice().getValue() == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice5).reset());
                } else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice6).reset());
                }

            }
            // purple case
            else {
                if (this.getDice().getValue() == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice1).reset());
                } else if (this.getDice().getValue() == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice2).reset());
                } else if (this.getDice().getValue() == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice3).reset());
                } else if (this.getDice().getValue() == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice4).reset());
                } else if (this.getDice().getValue() == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice5).reset());
                } else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice6).reset());
                }
            }
        }
    }
}


