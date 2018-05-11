package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Components.GlassBox;
import it.polimi.se2018.model.Components.Player;

import java.util.Iterator;

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
            if (box.getDice().getValue() == 5 ) {
                setOf5++;
            }
            if (box.getDice().getValue() == 6){
                setOf6++;
            }
        }
        if ( setOf5 < setOf6) {
            points = setOf5;
        }
        else points = setOf6;

        return points ;
    }

}
