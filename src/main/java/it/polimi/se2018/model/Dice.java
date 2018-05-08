package it.polimi.se2018.model;


public class Dice {

    private final int DEFAULT = 0;
    private int value;
    private DiceColour colour;

    public Dice() {
        this.value = DEFAULT;
        this.colour = null;
    }

    public Dice (int value, DiceColour colour){
        this.value = value;
        this.colour = colour;
    }

    public DiceColour getColour (){
        return colour;
    }

    public int getValue () {
        return value;
    }

    public void setValue(int v){

        value = v;

    }



}
