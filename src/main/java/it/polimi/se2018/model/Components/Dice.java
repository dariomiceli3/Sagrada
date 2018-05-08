package it.polimi.se2018.model.Components;


public class Dice {

    private final int DEFAULT = 0;
    private int value;
    private DiceColor color;

    public Dice() {
        this.value = DEFAULT;
        this.color = null;
    }

    public Dice (int value, DiceColor color){
        this.value = value;
        this.color = color;
    }

    public DiceColor getColor ()
    {
        return color;
    }

    public int getValue ()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public void setColor(DiceColor color)
    {
        this.color = color;
    }

}
