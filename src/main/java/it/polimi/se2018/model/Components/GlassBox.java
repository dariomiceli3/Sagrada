package it.polimi.se2018.model.Components;

public class GlassBox {
    //private GlassCoord coord; nel caso la reinseriamo, ma con tale implementazione non sembra avere senso
    private Dice dice;
    private int constraintValue;
    private String constraintColor;


    // constructor for box with no constraint value and color
    public GlassBox()
    {
        setDice(null);
        this.constraintValue = 0;
        this.constraintColor = null;
    }
    // constructor for box with a constraint value
    public GlassBox(int constraintValue)
    {
        //this.coord = coord;
        setDice(null);
        this.constraintColor = null;
        this.constraintValue = constraintValue;
    }

    // constructor for box with a constraint color
    public GlassBox(String constraintColor)
    {
        setDice(null);
        this.constraintColor = constraintColor;
        this.constraintValue = 0;
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

    public boolean isValidMove(Dice dice)
    {
        if (isEmpty())
        {
            if (this.constraintColor.equals(dice.getColor().toString()))
            {
                if (this.constraintValue == dice.getValue())
                {
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else return false;
    }

}


