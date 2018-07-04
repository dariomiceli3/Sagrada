package it.polimi.se2018.server.model.Components;

import org.fusesource.jansi.Ansi.Color;

import java.io.Serializable;

import static org.fusesource.jansi.Ansi.ansi;

/**Class Dice: representation of the dice, it is characterized by a value (int) and a color (enum)
 * @author fadda-miceli-mundo
 * @see java.io.Serializable
 */

public class Dice implements Serializable {

    private static final String escapeDice1 = "\u2680";
    private static final String escapeDice2 = "\u2681";
    private static final String escapeDice3 = "\u2682";
    private static final String escapeDice4 = "\u2683";
    private static final String escapeDice5 = "\u2684";
    private static final String escapeDice6 = "\u2685";
    private static final int DEFAULT = 0;
    private int value;
    private DiceColor color;

    /**
     * Default class constructor
     */
    public Dice() {
        this.value = DEFAULT;
        this.color = null;
    }

    /**
     * Class constructor, create a die with a number and color
     * @param value dice number
     * @param color dice color
     */
    public Dice (int value, DiceColor color) {
        this.color = color;
        this.value = value;
    }

    /**
     * method that provides the caller the color of a Dice
     * @return DiceColor dice color
     */
    public DiceColor getColor() {
        return color;
    }

    /**
     * method that provides the caller the value of a Dice
     * @return int value of the dice number
     */
    public int getValue () {
        return value;
    }

    /**
     * method that permits the caller to set the color of a Dice
     * @param color dice color to set
     */
    public void setColor(DiceColor color) {
        this.color = color;
    }

    /**
     * method that permits the caller to set the value of a Dice
     * @param value dice number to set
     */
    public void setValue(int value) {
        this.value = value;
    }


    /**
     * Override of the Object toString method to provide the caller of a String version of a Dice
     * @return string format of a dice
     */
    @Override
    public String toString() {


        if (this.getColor().toString().equals("red")) {

            if (this.getValue() == 1) {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a(escapeDice1).reset());
            }
            else if (this.getValue() == 2) {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a(escapeDice2).reset());
            }
            else if (this.getValue() == 3) {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a(escapeDice3).reset());
            }
            else if (this.getValue() == 4) {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a(escapeDice4).reset());
            }
            else if (this.getValue() == 5) {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a(escapeDice5).reset());
            }
            else {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a(escapeDice6).reset());
            }
        }

        else if (this.getColor().toString().equals("yellow")) {

            if (this.getValue() == 1) {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a(escapeDice1).reset());
            }
            else if (this.getValue() == 2) {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a(escapeDice2).reset());
            }
            else if (this.getValue() == 3) {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a(escapeDice3).reset());
            }
            else if (this.getValue() == 4) {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a(escapeDice4).reset());
            }
            else if (this.getValue() == 5) {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a(escapeDice5).reset());
            }
            else {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a(escapeDice6).reset());
            }
        }

        else if (this.getColor().toString().equals("blue")) {

            if (this.getValue() == 1) {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a(escapeDice1).reset());
            }
            else if (this.getValue() == 2) {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a(escapeDice2).reset());
            }
            else if (this.getValue() == 3) {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a(escapeDice3).reset());
            }
            else if (this.getValue() == 4) {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a(escapeDice4).reset());
            }
            else if (this.getValue() == 5) {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a(escapeDice5).reset());
            }
            else {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a(escapeDice6).reset());
            }
        }

        else if (this.getColor().toString().equals("green")) {

            if (this.getValue() == 1) {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a(escapeDice1).reset());
            }
            else if (this.getValue() == 2) {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a(escapeDice2).reset());
            }
            else if (this.getValue() == 3) {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a(escapeDice3).reset());
            }
            else if (this.getValue() == 4) {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a(escapeDice4).reset());
            }
            else if (this.getValue() == 5) {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a(escapeDice5).reset());
            }
            else {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a(escapeDice6).reset());
            }
        }

        else

            if (this.getValue() == 1) {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a(escapeDice1).reset());
            }
            else if (this.getValue() == 2) {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a(escapeDice2).reset());
            }
            else if (this.getValue() == 3) {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a(escapeDice3).reset());
            }
            else if (this.getValue() == 4) {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a(escapeDice4).reset());
            }
            else if (this.getValue() == 5) {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a(escapeDice5).reset());
            }
            else {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a(escapeDice6).reset());
            }
        }


    /**
     * method that provides the caller of a String version of the Dice in a format useful to load from file
     * the Dice image
     * @return String short version a dice
     */
    public String toStringGui() {

        if (this.getColor().toString().equalsIgnoreCase("red")) {

            if (this.getValue() == 1) {
                return "R1";
            }
            else if (this.getValue() == 2) {
                return "R2";
            }
            else if (this.getValue() == 3) {
                return "R3";
            }
            else if (this.getValue() == 4) {
                return "R4";
            }
            else if (this.getValue() == 5) {
                return "R5";
            }
            else {
                return "R6";
            }
        }

        else if (this.getColor().toString().equalsIgnoreCase("yellow")) {

            if (this.getValue() == 1) {
                return "Y1";
            }
            else if (this.getValue() == 2) {
                return "Y2";
            }
            else if (this.getValue() == 3) {
                return "Y3";
            }
            else if (this.getValue() == 4) {
                return "Y4";
            }
            else if (this.getValue() == 5) {
                return "Y5";
            }
            else {
                return "Y6";
            }
        }

        else if (this.getColor().toString().equalsIgnoreCase("blue")) {

            if (this.getValue() == 1) {
                return "B1";
            }
            else if (this.getValue() == 2) {
                return "B2";
            }
            else if (this.getValue() == 3) {
                return "B3";
            }
            else if (this.getValue() == 4) {
                return "B4";
            }
            else if (this.getValue() == 5) {
                return "B5";
            }
            else {
                return "B6";
            }
        }

        else if (this.getColor().toString().equalsIgnoreCase("green")) {

            if (this.getValue() == 1) {
                return "G1";
            }
            else if (this.getValue() == 2) {
                return "G2";
            }
            else if (this.getValue() == 3) {
                return "G3";
            }
            else if (this.getValue() == 4) {
                return "G4";
            }
            else if (this.getValue() == 5) {
                return "G5";
            }
            else {
                return "G6";
            }
        }

        else if (this.getValue() == 1) {
            return "P1";
        }
        else if (this.getValue() == 2) {
            return "P2";
        }
        else if (this.getValue() == 3) {
            return "P3";
        }
        else if (this.getValue() == 4) {
            return "P4";
        }
        else if (this.getValue() == 5) {
            return "P5";
        }
        else {
            return "P6";
        }
    }


}


