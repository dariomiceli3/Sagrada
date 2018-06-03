package it.polimi.se2018.TestController.TestToolCard;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.controller.Toolcards.DiceOnPatternEffect;
import it.polimi.se2018.server.controller.Toolcards.UseDiceEffect;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class TestDiceOnPatternEffect {

    @Test
    public void testEglomiseBrushEffect() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard = patternCardArrayList.get(19);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);
        Dice diceGreen1 = new Dice(1, DiceColor.GREEN);
        Dice diceRed2 = new Dice(2, DiceColor.RED);

        patternCard.putDiceOnPattern(diceBlue2, 10, patternCard);
        patternCard.putDiceOnPattern(diceGreen1, 6, patternCard);
        patternCard.putDiceOnPattern(diceRed2, 0, patternCard);

        //patternCard.putDiceOnPatternEglomise();
        System.out.println(patternCard.toString());
        DiceOnPatternEffect diceOnPatternEffect = new DiceOnPatternEffect();
        diceOnPatternEffect.eglomiseBrushEffect(patternCard, diceRed2, 7);
        System.out.println(patternCard.toString());
    }

}
