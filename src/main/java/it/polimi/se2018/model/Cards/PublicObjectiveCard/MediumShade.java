package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Components.GlassBox;

import java.util.Iterator;

public class MediumShade implements PublicEffects {

    @Override
    public int RunPublic(PatternCard pattern){
        int points;
        int setOf3= 0;
        int setOf4 = 0;
        GlassBox box;

        Iterator<GlassBox> it = pattern.getPattern().iterator();
        while (it.hasNext()) {
            box = it.next();
            if (box.getDice().getValue() == 3 ) {
                setOf3++;
            }
            if (box.getDice().getValue() == 4){
                setOf4++;
            }
        }
        if ( setOf3 < setOf4) {
            points = setOf3;
        }
        else points = setOf4;

        return points ;
    }

}
