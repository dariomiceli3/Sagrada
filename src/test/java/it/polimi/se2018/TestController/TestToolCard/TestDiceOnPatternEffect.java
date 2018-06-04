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

    @Test
    public void testCopperFoilBurnisherffect() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard = patternCardArrayList.get(19);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);
        Dice diceGreen1 = new Dice(1, DiceColor.GREEN);
        Dice diceRed2 = new Dice(2, DiceColor.RED);
        Dice dice = new Dice(6, DiceColor.BLUE);

        patternCard.putDiceOnPattern(diceBlue2, 10, patternCard);
        patternCard.putDiceOnPattern(diceGreen1, 6, patternCard);
        patternCard.putDiceOnPattern(diceRed2, 0, patternCard);

        System.out.println(patternCard.toString());

        DiceOnPatternEffect diceOnPatternEffect = new DiceOnPatternEffect();
        diceOnPatternEffect.copperFoilBurnisherEffect(patternCard, dice, 12 );
        System.out.println(patternCard.toString());

    }

    @Test
    public void testLathekinffect() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard = patternCardArrayList.get(19);
        Dice diceBlue3 = new Dice(3, DiceColor.BLUE);
        Dice diceGreen1 = new Dice(1, DiceColor.GREEN);
        Dice diceRed2 = new Dice(2, DiceColor.RED);
        Dice dice = new Dice(6, DiceColor.BLUE);

        patternCard.putDiceOnPattern(diceBlue3, 10, patternCard);
        patternCard.putDiceOnPattern(diceGreen1, 6, patternCard);
        patternCard.putDiceOnPattern(diceRed2, 0, patternCard);

        System.out.println(patternCard.toString());
        ArrayList<Integer> indexToMove = new ArrayList<>();
        ArrayList<Integer> indexToArrive = new ArrayList<>();
        indexToMove.add(10);
        indexToMove.add(6);
        indexToArrive.add(1);
        indexToArrive.add(2);


        DiceOnPatternEffect diceOnPatternEffect = new DiceOnPatternEffect();
        diceOnPatternEffect.lathekinEffect(patternCard, indexToMove, indexToArrive );
        System.out.println(patternCard.toString());

    }

    @Test
    public void testTapWheelffect() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard = patternCardArrayList.get(19);
        Dice diceBlue3 = new Dice(3, DiceColor.BLUE);
        Dice diceGreen1 = new Dice(1, DiceColor.GREEN);
        Dice diceRed2 = new Dice(2, DiceColor.RED);
        Dice dice = new Dice(6, DiceColor.BLUE);

        patternCard.putDiceOnPattern(diceBlue3, 10, patternCard);
        patternCard.putDiceOnPattern(diceGreen1, 6, patternCard);
        patternCard.putDiceOnPattern(diceRed2, 0, patternCard);
        patternCard.putDiceOnPattern(dice, 1, patternCard);

        System.out.println(patternCard.toString());
        ArrayList<Integer> indexToMove = new ArrayList<>();
        ArrayList<Integer> indexToArrive = new ArrayList<>();
        //indexToMove.add(10);
        indexToMove.add(6);
        //indexToArrive.add(1);
        indexToArrive.add(2);


        DiceOnPatternEffect diceOnPatternEffect = new DiceOnPatternEffect();
        diceOnPatternEffect.tapWheelEffect(patternCard, indexToMove, indexToArrive );
        System.out.println(patternCard.toString());

    }

    @Test
    public void testCorckBackedStraighredgeEffect() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard = patternCardArrayList.get(19);
        Dice diceBlue3 = new Dice(3, DiceColor.BLUE);
        Dice diceGreen1 = new Dice(1, DiceColor.GREEN);
        Dice diceRed2 = new Dice(2, DiceColor.RED);
        Dice dice = new Dice(6, DiceColor.RED);

        patternCard.putDiceOnPattern(diceBlue3, 10, patternCard);
        patternCard.putDiceOnPattern(diceGreen1, 6, patternCard);
        patternCard.putDiceOnPattern(diceRed2, 0, patternCard);

        System.out.println(patternCard.toString());


        DiceOnPatternEffect diceOnPatternEffect = new DiceOnPatternEffect();
        diceOnPatternEffect.corckBackedStraightedgeEffect(patternCard, dice, 19);
        System.out.println(patternCard.toString());

    }


}
