package it.polimi.se2018.model;

public class GlassBox {
    private GlassCoord coord;
    private Dice dice;
    private int constraintValue;
    private String constraintColor;

    public GlassBox(GlassCoord coord, Dice dice, int constraintValue, String constraintColor)
    {
        this.coord = coord;
        setDice(null);
        this.constraintColor = constraintColor;
        this.constraintValue = constraintValue;
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

    public boolean isEmpty() {
        if (this.dice == null)
        {
            return true;
        }
        else
            return false;
    }

    public GlassCoord getCoord()
    {
        return coord;
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


}


