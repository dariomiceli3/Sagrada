package it.polimi.se2018.TestComponents;


import it.polimi.se2018.Exceptions.InvalidMoveException;
import it.polimi.se2018.model.Components.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestRoundTracker {

    @Test
    public void testConstructor() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        ArrayList<Dice> list = draftPool.cleanListDice();

        RoundTracker roundTracker = new RoundTracker(list);

        assertEquals(9,roundTracker.getRoundDice(0).size());
        assertEquals(1,roundTracker.getRoundTracker().size());

    }

    @Test
    public void testSetTracker() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        ArrayList<Dice> list = draftPool.cleanListDice();

        RoundTracker roundTracker = new RoundTracker(list);
        roundTracker.setTracker(list);
        roundTracker.setTracker(list);

        assertEquals(9, roundTracker.getRoundDice(1).size());
        assertEquals(9, roundTracker.getRoundDice(2).size());
        assertEquals(3,roundTracker.getRoundTracker().size());
    }

    @Test (expected = InvalidMoveException.class)
    public void testAddDice() throws InvalidMoveException {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        ArrayList<Dice> list = draftPool.cleanListDice();
        Dice dice = new Dice(3, DiceColor.PURPLE);
        Dice dice1 = new Dice(3, DiceColor.PURPLE);
        RoundTracker roundTracker = new RoundTracker(list);
        roundTracker.addDice(dice, 0);
        roundTracker.addDice(dice1, 2);
        assertEquals(10, roundTracker.getRoundDice(1).size());

    }
}


