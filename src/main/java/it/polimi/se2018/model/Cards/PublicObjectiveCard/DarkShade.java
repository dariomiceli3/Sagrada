package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Components.GlassBox;
import static java.lang.Math.min;
import java.util.Iterator;

/**
 * class used to count the number of points
 * @author Dario Miceli
 */
public class DarkShade implements PublicEffects {

    /**
     *
     * @param pattern scheme card of a player
     * @return number of sets of 5&6 multiplied by value of victory point
     */
    @Override
    public int RunPublic(PatternCard pattern){
        int points;
        int setOf5= 0;
        int setOf6 = 0;
        GlassBox box;

        Iterator<GlassBox> it = pattern.getPattern().iterator();
        while (it.hasNext()) {
            box = it.next();
            if(!box.isBoxEmpty()){
            if (box.getDice().getValue() == 5 ) {
                setOf5++;
            }
            if (box.getDice().getValue() == 6){
                setOf6++;
            }
            }
        }
        points = min(setOf5, setOf6);


        return points*2;
    }

}
