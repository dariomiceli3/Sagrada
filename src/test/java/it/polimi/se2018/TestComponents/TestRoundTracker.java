package it.polimi.se2018.TestComponents;


import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Components.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestRoundTracker {

    @Test
    public void testConstructor() {

        RoundTracker roundTracker = new RoundTracker();

        assertEquals(0,roundTracker.getRoundTracker().size());

    }

    @Test
    public void testSetTracker() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        draftPool.createListDice();
        ArrayList<Dice> list = draftPool.cleanListDice();

        RoundTracker roundTracker = new RoundTracker();
        roundTracker.setTracker(list);
        roundTracker.setTracker(list);

        assertEquals(9, roundTracker.getRoundDice(0).size());
        assertEquals(9, roundTracker.getRoundDice(1).size());
        assertEquals(2,roundTracker.getRoundTracker().size());
    }

    @Test (expected = InvalidMoveException.class)
    public void testAddDice() throws InvalidMoveException {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        draftPool.createListDice();
        ArrayList<Dice> list = draftPool.cleanListDice();
        Dice dice = new Dice(3, DiceColor.PURPLE);
        Dice dice1 = new Dice(3, DiceColor.PURPLE);
        RoundTracker roundTracker = new RoundTracker();
        roundTracker.setTracker(list);
        roundTracker.addDice(dice, 0);
        roundTracker.addDice(dice1, 2);
        assertEquals(10, roundTracker.getRoundDice(1).size());

    }

    @Test
    public void testGetDice()  {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        draftPool.createListDice();
        ArrayList<Dice> list = draftPool.cleanListDice();
        RoundTracker roundTracker =new RoundTracker();
        roundTracker.setTracker(list);
        assertEquals(9, roundTracker.getRoundDice(0).size());
        Dice dice = roundTracker.getDice(0, 8);
    }

    @Test
    public void testToString() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        draftPool.createListDice();
        ArrayList<Dice> list = draftPool.cleanListDice();

        RoundTracker roundTracker = new RoundTracker();
        roundTracker.setTracker(list);
        roundTracker.setTracker(list);

        System.out.println(roundTracker.toString());
    }
}


