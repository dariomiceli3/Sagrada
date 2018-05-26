package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.GlassBox;
import static java.lang.Math.min;
import java.util.Iterator;

/**
 * class used to count the number of points
 * @author Dario Miceli
 */
public class DarkShade implements PublicEffects {


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
        points = points * 2;


        return points;
    }

}
