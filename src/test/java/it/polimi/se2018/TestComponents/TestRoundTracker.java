package it.polimi.se2018.TestComponents;

import it.polimi.se2018.model.Components.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/*public class TestRoundTracker {

    @Test
    public void testConstructor() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        ArrayList<Dice> list = draftPool.cleanListDice();

        RoundTracker roundTracker = new RoundTracker(list);

        assertEquals(9,roundTracker.getRoundDice(0).size());

    }

    @Test
    public void testSetRoundTracker() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        ArrayList<Dice> list = draftPool.cleanListDice();

        RoundTracker roundTracker = new RoundTracker(list);
        roundTracker.setTracker(1,list);
        roundTracker.setTracker(2,list);

        assertEquals(9, roundTracker.getRoundDice(1).size());
        assertEquals(9, roundTracker.getRoundDice(2).size());
    }

    @Test
    public void testAddDice() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4,diceBag);
        ArrayList<Dice> list = draftPool.cleanListDice();
        ArrayList<Dice> list1 = null;
        Dice dice = new Dice(3, DiceColor.PURPLE);
        Dice dice1 = new Dice(3, DiceColor.PURPLE);


        RoundTracker roundTracker = new RoundTracker(list);
        //roundTracker.setTracker(0, list);
        roundTracker.addDice(dice, 0);
        roundTracker.addDice(dice1, 1);
        //roundTracker.addDice(dice2, 2);
        //roundTracker.addDice(dice3, 3);
        //roundTracker.addDice(dice4, 4);

        //assertEquals(11,roundTracker.getRoundDice(0).size());
        //assertEquals(1,roundTracker.getRoundDice(1).size());
        //assertEquals(1,roundTracker.getRoundDice(2).size());
        //assertEquals(1,roundTracker.getRoundDice(3).size());
        //assertEquals(1,roundTracker.getRoundDice(4).size());

    }
}
*/