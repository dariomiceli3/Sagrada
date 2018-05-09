package it.polimi.se2018.model.Cards;

import it.polimi.se2018.model.Components.DiceColor;

public class PrivateObjectiveCard {

    private final int DEF = 0;
    private int counter;
    private DiceColor colour;



    public PrivateObjectiveCard(){
        this.colour = null;
        this.counter = DEF;
    }

    public PrivateObjectiveCard(int counter, DiceColor colour){
        this.counter = counter;
        this.colour = colour;
    }

    public int getCounter(){
        return counter;
    }

    public DiceColor getColour(){
        return colour;
    }

    public int RunPoint(PatternCard pattern){
        int points = 0;


        return points ;
    }




}
