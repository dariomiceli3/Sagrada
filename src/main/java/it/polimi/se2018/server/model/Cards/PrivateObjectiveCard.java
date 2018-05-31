package it.polimi.se2018.server.model.Cards;


import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.GlassBox;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Class PrivateObjectiveCard: Public Objective Card
 * @author Salvatrore Fadda
 */
public class PrivateObjectiveCard implements Serializable {

    private static final int DEF = 0;
    private DiceColor colour;
    private static final String name = "Shade of ";

    /**
     * Class Constructor
     * @param colour color of the card
     */
    public PrivateObjectiveCard(DiceColor colour){
        this.colour = colour;
    }

    public DiceColor getColour(){
        return colour;
    }

    /**
     * @param pattern scheme card of a player
     * @return sum of values on ,color of the card, dice
     */
    public int RunPrivate(PatternCard pattern) {
        int count = DEF;
        GlassBox box;
        Iterator<GlassBox> it = pattern.getPattern().iterator();
        while (it.hasNext()) {
            box = it.next();
            if(!box.isBoxEmpty())
            if (box.getDice().getColor() == colour) {
                count = count + box.getDice().getValue();
            }

        }
        return count;
    }

    @Override
    public String toString(){
        return "Private card : " + this.name + this.colour + "\n" +
                "Sum of values on " + this.colour + " dice"
                ;
    }



}
