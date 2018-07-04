package it.polimi.se2018.TestComponents;



import it.polimi.se2018.server.model.Components.*;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestRoundTracker {

    @Test
    public void testConstructor() {

        RoundTracker roundTracker = new RoundTracker();
        RoundTracker roundTracker1= new RoundTracker(roundTracker);

        assertEquals(0,roundTracker.getRoundTracker().size());

    }

    @Test
    public void testSetTracker() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        draftPool.createListDice();
        List<Dice> list = draftPool.cleanListDice();

        RoundTracker roundTracker = new RoundTracker();
        roundTracker.setTracker(list);
        roundTracker.setTracker(list);

        assertEquals(5, roundTracker.getRoundDice(0).size());
        assertEquals(5, roundTracker.getRoundDice(1).size());
        assertEquals(2,roundTracker.getRoundTracker().size());
    }

    @Test
    public void testAddDice() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        draftPool.createListDice();
        List<Dice> list = draftPool.cleanListDice();
        Dice dice = new Dice(3, DiceColor.PURPLE);
        RoundTracker roundTracker = new RoundTracker();
        roundTracker.setTracker(list);
        roundTracker.addDice(dice, 0);
        assertEquals(6, roundTracker.getRoundDice(0).size());

    }

    @Test
    public void testGetDice()  {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        draftPool.createListDice();
        List<Dice> list = draftPool.cleanListDice();
        RoundTracker roundTracker =new RoundTracker();
        roundTracker.setTracker(list);
        assertEquals(5, roundTracker.getRoundDice(0).size());
        Dice dice = roundTracker.getDice(0, 4);
    }

    @Test
    public void testGetRoundSizes() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        draftPool.createListDice();
        List<Dice> list = draftPool.cleanListDice();
        RoundTracker roundTracker =new RoundTracker();
        roundTracker.setTracker(list);
        roundTracker.getRoundsSizes();
        assertEquals(1, roundTracker.getRoundsSizes().size());
    }

    @Test
    public void testToString() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4, diceBag);
        draftPool.createListDice();
        List<Dice> list = draftPool.cleanListDice();

        RoundTracker roundTracker = new RoundTracker();
        System.out.println(roundTracker.toString());
        roundTracker.setTracker(list);
        System.out.println(roundTracker.toString());
        roundTracker.setTracker(list);
        System.out.println(roundTracker.toString());
        roundTracker.setTracker(list);
        System.out.println(roundTracker.toString());
        roundTracker.setTracker(list);
        System.out.println(roundTracker.toString());
        roundTracker.setTracker(list);
        System.out.println(roundTracker.toString());
        roundTracker.setTracker(list);
        System.out.println(roundTracker.toString());
        roundTracker.setTracker(list);
        System.out.println(roundTracker.toString());
        roundTracker.setTracker(list);
        System.out.println(roundTracker.toString());
        roundTracker.setTracker(list);
        System.out.println(roundTracker.toString());
        roundTracker.setTracker(list);

        System.out.println(roundTracker.toString());
    }
}


