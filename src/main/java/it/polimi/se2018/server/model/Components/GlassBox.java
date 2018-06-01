package it.polimi.se2018.server.model.Components;

import org.fusesource.jansi.Ansi;

import java.io.Serializable;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Representation of a single box of a Pattern Card
 * @author adrianomundo
 */

public class GlassBox implements Serializable {
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
        if (this.dice == null)
        {
            return true;
        }
        else
            return false;
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
                if (this.constraintValue != DEFAULT) {
                    if (this.constraintValue == dice.getValue()) {
                        setDice(dice);
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                // value = 0 e color = null case
                else {
                    setDice(dice);
                    return true;
                }
            }
        }
        // box full case
        else return false;
    }

    @Override
    public String toString() {

        return String.valueOf(ansi().eraseScreen().fg(Ansi.Color.RED).a("\u25FC").reset());

        //2610



    }

}


