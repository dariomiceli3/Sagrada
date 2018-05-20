package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Components.GlassBox;
import static java.lang.Math.min;
import java.util.Iterator;

/**
 * class used to count the number of points
 * @author Dario Miceli
 */

public class LightShade implements PublicEffects{


    @Override
    public int RunPublic(PatternCard pattern){
        int points;
        int setOf1= 0;
        int setOf2 = 0;
        GlassBox box;

        Iterator<GlassBox> it = pattern.getPattern().iterator();
        while (it.hasNext()) {
            box = it.next();
            if(!box.isBoxEmpty()){
            if (box.getDice().getValue() == 1 ) {
                setOf1++;
            }
            if (box.getDice().getValue() == 2){
                setOf2++;
            }
            }
        }
        points = min(setOf1, setOf2);
        points = points * 2;

        return points;
    }

}


