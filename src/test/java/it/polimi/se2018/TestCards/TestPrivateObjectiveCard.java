package it.polimi.se2018.TestCards;

import it.polimi.se2018.model.Components.Dice;
import it.polimi.se2018.model.Components.DiceColor;
import it.polimi.se2018.Exceptions.InvalidMoveException;
import it.polimi.se2018.model.Cards.*;
import it.polimi.se2018.model.Components.GlassBox;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TestPrivateObjectiveCard {
    @Test
    public void testConstructor() {
        PrivateObjectiveCard privateCard = new PrivateObjectiveCard(DiceColor.BLUE);
        assertEquals("Blue", privateCard.getColour().toString());

    }

    @Test
    public void testRunPrivate() throws InvalidMoveException{
        PatternCard pattern = new PatternCard();
        try {
            Dice dice = new Dice(5, DiceColor.BLUE);
            ArrayList<PatternCard> patternList = pattern.loadPatternList();
            pattern = patternList.get(4);
            pattern.putDiceOnPattern(dice, 10, pattern);
            PrivateObjectiveCard privateCard = new PrivateObjectiveCard(DiceColor.BLUE);
            assertEquals(5,privateCard.RunPrivate(pattern));
        } catch(FileNotFoundException e) {
            fail();
        }

    }
}
