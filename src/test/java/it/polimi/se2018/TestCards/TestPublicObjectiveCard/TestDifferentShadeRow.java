package it.polimi.se2018.TestCards.TestPublicObjectiveCard;


import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.DifferentShadeRow;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.exceptions.InvalidMoveException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TestDifferentShadeRow {
    @Test
    public void testRunPublic() throws InvalidMoveException{
        PatternCard pattern = new PatternCard();
        try {
            Dice dice = new Dice(4, DiceColor.GREEN);
            Dice dice1 = new Dice(3, DiceColor.YELLOW);
            Dice dice2 = new Dice(5, DiceColor.BLUE);
            Dice dice3 = new Dice(6, DiceColor.RED);
            Dice dice4 = new Dice(1, DiceColor.PURPLE);
            Dice dice5 = new Dice(4, DiceColor.YELLOW);
            Dice dice6 = new Dice(2, DiceColor.GREEN);

            ArrayList<PatternCard> patternList = pattern.loadPatternList();
            pattern = patternList.get(0);
            pattern.putDiceOnPattern(dice, 5, pattern);
            pattern.putDiceOnPattern(dice1, 0, pattern);
            pattern.putDiceOnPattern(dice1, 10, pattern);
            pattern.putDiceOnPattern(dice2, 1, pattern);
            pattern.putDiceOnPattern(dice, 2, pattern);
            pattern.putDiceOnPattern(dice3, 3, pattern);
            pattern.putDiceOnPattern(dice4, 4, pattern);
            pattern.putDiceOnPattern(dice2, 7, pattern);
            pattern.putDiceOnPattern(dice4, 8, pattern);
            pattern.putDiceOnPattern(dice5, 9, pattern);
            pattern.putDiceOnPattern(dice, 11, pattern);
            pattern.putDiceOnPattern(dice3, 12, pattern);
            pattern.putDiceOnPattern(dice1, 13, pattern);
            pattern.putDiceOnPattern(dice6, 14, pattern);
            pattern.putDiceOnPattern(dice6, 15, pattern);
            pattern.putDiceOnPattern(dice2, 16, pattern);
            pattern.putDiceOnPattern(dice5, 17, pattern);
            pattern.putDiceOnPattern(dice2, 18, pattern);
            pattern.putDiceOnPattern(dice1, 19, pattern);
            PublicObjectiveCard publicCard = new PublicObjectiveCard(new DifferentShadeRow());
            assertEquals(5, publicCard.executeEffect(pattern));


        } catch(FileNotFoundException e) {
            fail();
        }

    }
}