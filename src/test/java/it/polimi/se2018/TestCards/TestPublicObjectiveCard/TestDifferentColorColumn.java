package it.polimi.se2018.TestCards.TestPublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.DiagonalColor;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.DifferentColorColumn;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.exceptions.InvalidMoveException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TestDifferentColorColumn {
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
            PublicObjectiveCard publicCard = new PublicObjectiveCard(new DifferentColorColumn(), "Column Color Variety");
            assertEquals(10, publicCard.executeEffect(pattern));


        } catch(FileNotFoundException e) {
            fail();
        }

    }

    /*@Test
    public void test() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        PatternCard Pattern = patternCard.loadPatternForTesting();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);
        Dice diceBlue3 = new Dice(3, DiceColor.RED);
        Dice diceGreen4 = new Dice(4, DiceColor.PURPLE);


        Pattern.putDiceOnPattern(diceBlue1, 0, Pattern);
        Pattern.putDiceOnPattern(diceGreen2, 5, Pattern);
        Pattern.putDiceOnPattern(diceBlue3, 10, Pattern);
        Pattern.putDiceOnPattern(diceGreen4, 15, Pattern);

        Pattern.putDiceOnPattern(diceGreen4, 1, Pattern);
        Pattern.putDiceOnPattern(diceBlue3, 6, Pattern);
        Pattern.putDiceOnPattern(diceGreen2, 11, Pattern);
        Pattern.putDiceOnPattern(diceBlue1, 16, Pattern);

        Pattern.putDiceOnPattern(diceBlue1, 2, Pattern);
        Pattern.putDiceOnPattern(diceGreen2, 7, Pattern);
        Pattern.putDiceOnPattern(diceBlue3, 12, Pattern);
        Pattern.putDiceOnPattern(diceGreen4, 17, Pattern);

        Pattern.putDiceOnPattern(diceGreen4, 3, Pattern);
        Pattern.putDiceOnPattern(diceBlue3, 8, Pattern);
        Pattern.putDiceOnPattern(diceGreen2, 13, Pattern);
        Pattern.putDiceOnPattern(diceBlue1, 18, Pattern);

        Pattern.putDiceOnPattern(diceBlue1, 4, Pattern);
        Pattern.putDiceOnPattern(diceGreen2, 9, Pattern);
        Pattern.putDiceOnPattern(diceBlue3, 14, Pattern);
        Pattern.putDiceOnPattern(diceGreen4, 19, Pattern);

        PublicObjectiveCard publicCard = new PublicObjectiveCard(new DifferentColorColumn(), "Column Color Variety");
        publicCard.executeEffect(Pattern);


    }*/

    /*@Test
    public void test2() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        PatternCard Pattern = patternCard.loadPatternForTesting();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);
        Dice diceBlue3 = new Dice(3, DiceColor.RED);
        Dice diceGreen4 = new Dice(4, DiceColor.PURPLE);


        Pattern.putDiceOnPattern(diceBlue1, 0, Pattern);
        Pattern.putDiceOnPattern(diceGreen2, 5, Pattern);
        Pattern.putDiceOnPattern(diceBlue3, 10, Pattern);
        Pattern.putDiceOnPattern(diceGreen4, 15, Pattern);

        //Pattern.putDiceOnPattern(diceGreen4, 1, Pattern);
        Pattern.putDiceOnPattern(diceBlue3, 6, Pattern);
        Pattern.putDiceOnPattern(diceGreen2, 11, Pattern);
        Pattern.putDiceOnPattern(diceBlue1, 16, Pattern);

        //Pattern.putDiceOnPattern(diceBlue1, 2, Pattern);
        Pattern.putDiceOnPattern(diceGreen2, 7, Pattern);
        Pattern.putDiceOnPattern(diceBlue3, 12, Pattern);
        Pattern.putDiceOnPattern(diceGreen4, 17, Pattern);

        //Pattern.putDiceOnPattern(diceGreen4, 3, Pattern);
        Pattern.putDiceOnPattern(diceBlue3, 8, Pattern);
        Pattern.putDiceOnPattern(diceGreen2, 13, Pattern);
        Pattern.putDiceOnPattern(diceBlue1, 18, Pattern);

        //Pattern.putDiceOnPattern(diceBlue1, 4, Pattern);
        Pattern.putDiceOnPattern(diceGreen2, 9, Pattern);
        Pattern.putDiceOnPattern(diceBlue3, 14, Pattern);
        Pattern.putDiceOnPattern(diceGreen4, 19, Pattern);

        PublicObjectiveCard publicCard = new PublicObjectiveCard(new DifferentColorColumn(), "Column Color Variety");
        publicCard.executeEffect(Pattern);


    }*/

    @Test
    public void testToString(){
        PublicObjectiveCard publicCard = new PublicObjectiveCard(new DifferentColorColumn(), "Column Color Variety");
        System.out.println(publicCard.toString());
    }
}
