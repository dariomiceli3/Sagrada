package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Components.DiceColor;
import it.polimi.se2018.model.Components.GlassBox;

import java.util.Iterator;

import static java.lang.Math.min;

/**
 * Class VarietyColor: Public Objective Card
 * @author Salvatrore Fadda
 */
public class VarietyColor implements PublicEffects {

    /**
     *
     * @param pattern scheme card of a player
     * @return number of sets of one of each value
     */
    @Override
    public int RunPublic(PatternCard pattern){
        int points;
        int setOfY= 0;
        int setOfP = 0;
        int setOfG = 0;
        int setOfB = 0;
        int setOfR = 0;
        int temp1;
        int temp2;
        int temp3;

        GlassBox box;

        Iterator<GlassBox> it = pattern.getPattern().iterator();
        while (it.hasNext()) {
            box = it.next();
            if(!box.isBoxEmpty()) {
                if (box.getDice().getColor() == DiceColor.YELLOW) {
                    setOfY++;
                }
                if (box.getDice().getColor() == DiceColor.PURPLE) {
                    setOfP++;
                }
                if (box.getDice().getColor() == DiceColor.GREEN) {
                    setOfG++;
                }
                if (box.getDice().getColor() == DiceColor.BLUE) {
                    setOfB++;
                }
                if (box.getDice().getColor() == DiceColor.RED) {
                    setOfR++;
                }
            }
        }

        temp1 = min(setOfY, setOfP);
        temp2 = min(setOfG, setOfB);
        temp3 = min(setOfR, temp1);
        points = min(temp3, temp2) * 4;

        return points;
    }
}
