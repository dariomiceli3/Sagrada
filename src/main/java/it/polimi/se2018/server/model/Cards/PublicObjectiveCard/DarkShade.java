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
public class DarkShade implements PublicEffects, Serializable {
    private static final int VPOINTS = 2;
    private static final String NAME = "Deep Shades ";

    @Override
    public int runPublic(PatternCard pattern){
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
        points = points * VPOINTS;


        return points;
    }

    @Override
    public String toString() {
        return NAME + "\n"
                + "Set of 5 & 6 values anywhere" + "\n"
                + "VP : " + VPOINTS;
    }

    public static String getNAME() {
        return NAME;
    }
}
