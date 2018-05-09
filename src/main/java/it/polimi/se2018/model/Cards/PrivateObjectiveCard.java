package it.polimi.se2018.model.Cards;

import it.polimi.se2018.model.Components.DiceColor;

public class PrivateObjectiveCard {

    private final int DEF = 0;
    private DiceColor colour;



    public PrivateObjectiveCard(){
        this.colour = null;
    }

    public PrivateObjectiveCard(int counter, DiceColor colour){
        this.colour = colour;
    }

    public DiceColor getColour(){
        return colour;
    }

    public int RunPoint(PatternCard pattern){
        int count = 0;

        return count;
    }




}
