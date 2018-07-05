package it.polimi.se2018.server.model.Cards;


import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.GlassBox;
import java.io.Serializable;

/**
 * Class PrivateObjectiveCard: represents a Private Card of the board game, it's characterized by a color, that allow
 * the caller to create the different Private Card by changing the color associated with its
 * @author fadda-miceli-mundo
 */
public class PrivateObjectiveCard implements Serializable {

    private static final int DEF = 0;
    private DiceColor colour;
    private static final String NAME = "Shade of ";

    /**
     * Class Constructor for a card associated with a color
     * @param colour color of the card
     */
    public PrivateObjectiveCard(DiceColor colour){
        this.colour = colour;
    }

    /**
     * Class copy constructor, create a new Private Objective Card from an old one,useful to create a safe copy
     * @param card to copy
     */
    public PrivateObjectiveCard(PrivateObjectiveCard card) {
        this.colour = card.getColour();
    }

    public DiceColor getColour(){
        return colour;
    }

    /**
     * method that provide the caller to run the count of the points obtained by a player using the private card
     * on a pattern card passed as parameter
     * @param pattern scheme card of a player
     * @return sum of dice values of the card color
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

    /**
     * Override of the Object toString method to provide the caller of a String version of a Private Objective Card
     * @return String format of a Private Card object
     */
    @Override
    public String toString(){
        return "Private card : " + NAME + this.colour + "\n" +
                "Sum of values on " + this.colour + " dice"
                ;
    }



}
