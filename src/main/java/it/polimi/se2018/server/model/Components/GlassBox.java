package it.polimi.se2018.server.model.Components;

import org.fusesource.jansi.Ansi;

import java.io.Serializable;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Representation of a single box of a Pattern Card
 * @author adrianomundo
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


    // constructor for box with no constraint value and color
    public GlassBox()
    {
        setDice(null);
        this.constraintValue = DEFAULT;
        this.constraintColor = null;
    }
    // constructor for box with a constraint value
    public GlassBox(int constraintValue)
    {
        setDice(null);
        this.constraintColor = null;
        this.constraintValue = constraintValue;
    }

    // constructor for box with a constraint color
    public GlassBox(String constraintColor)
    {
        setDice(null);
        this.constraintColor = constraintColor;
        this.constraintValue = DEFAULT;
    }

    public Dice getDice()
    {
        return dice;
    }

    public void setDice(Dice dice)
    {
        this.dice = dice;
    }

    // remove dice from the box and return it to the caller
    public Dice unsetDice()
    {
        Dice diceReturned = this.dice;
        this.dice = null;
        return diceReturned;
    }


    public int getConstraintValue()
    {
        return constraintValue;
    }

    public String getConstraintColor()
    {
        return constraintColor;
    }

    public void setConstraintValue(int constraintValue)
    {
        this.constraintValue = constraintValue;
    }

    public void setConstraintColor(String constraintColor)
    {
        this.constraintColor = constraintColor;
    }

    public boolean isBoxEmpty()
    {
        return this.dice == null;
    }

    public boolean isBoxValid(Dice dice)
    {
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

    public boolean isBoxValidEglomise(Dice dice)
    {
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

    public boolean isBoxValidCopper(Dice dice)
    {
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

            }
            else if (this.constraintValue != DEFAULT) {
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
        }

        else {

            if (this.getDice().getColor().toString().equals("red")) {

                if (this.getDice().getValue() == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice1).reset());
                }

                else if (this.getDice().getValue() == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice2).reset());
                }

                else if (this.getDice().getValue() == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice3).reset());
                }

                else if (this.getDice().getValue() == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice4).reset());
                }

                else if (this.getDice().getValue() == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice5).reset());
                }

                else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a(escapeDice6).reset());
                }



            }

            else if (this.getDice().getColor().toString().equals("yellow")) {

                if (this.getDice().getValue() == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice1).reset());
                }

                else if (this.getDice().getValue() == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice2).reset());
                }

                else if (this.getDice().getValue() == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice3).reset());
                }

                else if (this.getDice().getValue() == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice4).reset());
                }

                else if (this.getDice().getValue() == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice5).reset());
                }

                else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(escapeDice6).reset());
                }

            }

            else if (this.getDice().getColor().toString().equalsIgnoreCase("green")) {

                if (this.getDice().getValue() == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice1).reset());
                }

                else if (this.getDice().getValue() == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice2).reset());
                }

                else if (this.getDice().getValue() == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice3).reset());
                }

                else if (this.getDice().getValue() == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice4).reset());
                }

                else if (this.getDice().getValue() == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice5).reset());
                }

                else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.GREEN).a(escapeDice6).reset());
                }

            }

            else if (this.getDice().getColor().toString().equalsIgnoreCase("blue")) {

                if (this.getDice().getValue() == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice1).reset());
                }

                else if (this.getDice().getValue() == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice2).reset());
                }

                else if (this.getDice().getValue() == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice3).reset());
                }

                else if (this.getDice().getValue() == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice4).reset());
                }

                else if (this.getDice().getValue() == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice5).reset());
                }

                else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.BLUE).a(escapeDice6).reset());
                }

            }

            // purple case
            else  {

                if (this.getDice().getValue() == 1) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice1).reset());
                }

                else if (this.getDice().getValue() == 2) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice2).reset());
                }

                else if (this.getDice().getValue() == 3) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice3).reset());
                }

                else if (this.getDice().getValue() == 4) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice4).reset());
                }

                else if (this.getDice().getValue() == 5) {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice5).reset());
                }

                else {
                    return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.MAGENTA).a(escapeDice6).reset());
                }
            }

        }
    }

}


