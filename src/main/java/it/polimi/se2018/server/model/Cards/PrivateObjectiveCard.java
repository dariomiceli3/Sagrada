package it.polimi.se2018.server.model.Cards;


import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.GlassBox;
import java.io.Serializable;

/**
 * Class PrivateObjectiveCard: Public Objective Card
 * @author Salvatrore Fadda
 */
public class PrivateObjectiveCard implements Serializable {

    private static final int DEF = 0;
    private DiceColor colour;
    private static final String NAME = "Shade of ";

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
    public int runPrivate(PatternCard pattern) {
        int count = DEF;
        GlassBox box;
        for (GlassBox glassBox : pattern.getPattern()) {
            box = glassBox;
            if (!box.isBoxEmpty())
                if (box.getDice().getColor() == colour) {
                    count = count + box.getDice().getValue();
                }

        }
        return count;
    }

    @Override
    public String toString(){
        return "Private card : " + NAME + this.colour + "\n" +
                "Sum of values on " + this.colour + " dice"
                ;
    }



}
