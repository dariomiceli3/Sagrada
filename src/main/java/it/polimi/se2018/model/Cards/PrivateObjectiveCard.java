package it.polimi.se2018.model.Cards;

import it.polimi.se2018.model.Components.DiceColour;

public class PrivateObjectiveCard {

    private final int DEF = 0;
    private int counter;
    private DiceColour colour;



    public PrivateObjectiveCard(){
        this.colour = null;
        this.counter = DEF;
    }

    public PrivateObjectiveCard(int counter, DiceColour colour){
        this.counter = counter;
        this.colour = colour;
    }

    public int getCounter(){
        return counter;
    }

    public DiceColour getColour(){
        return colour;
    }

    public int RunPoint(PatternCard pattern){
        int points = 0;


        return points ;
    }




}
