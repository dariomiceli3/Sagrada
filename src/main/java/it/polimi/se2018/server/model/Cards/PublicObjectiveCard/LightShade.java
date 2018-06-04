package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.GlassBox;
import static java.lang.Math.min;

import java.io.Serializable;
import java.util.Iterator;

/**
 * class used to count the number of points
 * @author Dario Miceli
 */

public class LightShade implements PublicEffects, Serializable {

    private static final int VPOINTS = 2;
    private static final String NAME = "Light Shades";

    @Override
    public int runPublic(PatternCard pattern){
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
        points = points * VPOINTS;

        return points;
    }

    @Override
    public String toString(){
        return NAME + "\n"
                + "Sets of 1 & 2 values anywhere" + "\n"
                + "VP : " + VPOINTS;
    }

}


