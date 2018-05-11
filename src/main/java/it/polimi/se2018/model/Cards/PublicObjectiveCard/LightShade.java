package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Components.GlassBox;
import java.util.Iterator;

/**
 * class used to count the number of sets of 1&2
 * @author Dario Miceli
 */
public class LightShade implements PublicEffects {

    /**
     *
     * @param pattern scheme card of a player
     * @return number of sets of 1&2
     */
    @Override
    public int RunPublic(PatternCard pattern){
        int points;
        int setOf1= 0;
        int setOf2 = 0;
        GlassBox box;

        Iterator<GlassBox> it = pattern.getPattern().iterator();
        while (it.hasNext()) {
            box = it.next();
            if (box.getDice().getValue() == 1 ) {
                setOf1++;
            }
            if (box.getDice().getValue() == 2){
                setOf2++;
            }
        }
        if ( setOf1 < setOf2) {
            points = setOf1*2;
        }
        else points = setOf2*2;

        return points ;
    }

}
