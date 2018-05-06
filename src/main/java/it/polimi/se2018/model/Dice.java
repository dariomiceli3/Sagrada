package it.polimi.se2018.model;

import java.util.Random;

public class Dice {

    protected final int MAX_VALUE = 6;
    private final int DEFAULT = 0;
    private int value;
    private DiceColour colour;

    public Dice (){
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




}
