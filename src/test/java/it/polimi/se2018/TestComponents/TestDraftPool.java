package it.polimi.se2018.TestComponents;

import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceBag;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.DraftPool;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestDraftPool {

    @Test
    public void testConstructor() {
        DiceBag diceBag = new DiceBag();

        DraftPool draftPool = new DraftPool();
        DraftPool draftPool1 = new DraftPool(draftPool);

        draftPool. getDiceBag();

        assertEquals(0, draftPool.getNowNumber());
        assertEquals(90, diceBag.getListBag().size());

    }

    @Test
    public void testCleanListDice () {
        DiceBag diceBag = new DiceBag();

        DraftPool draftPool = new DraftPool(3, diceBag );
        draftPool.createListDice();
        List<Dice> listDice = draftPool.cleanListDice();

        assertEquals(0, draftPool.getDraftPool().size());
        assertEquals(4,listDice.size());
    }

    @Test
    public void testCreateListDice () {
        DiceBag diceBag = new DiceBag();

        DraftPool draftPool = new DraftPool(3, diceBag );
        draftPool.createListDice();

        assertEquals(4, draftPool.getDraftPool().size());
        assertEquals(86, diceBag.getListBag().size());
    }

    @Test
    public void testSetDice() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4, diceBag);
        draftPool.createListDice();
        Dice dice = new Dice(4, DiceColor.YELLOW);

        draftPool.setDice(dice);
        assertEquals(6, draftPool.getNowNumber());
    }

    @Test
    public void testConstructorDefault() {
        DraftPool draftPool = new DraftPool();

        assertEquals(null, draftPool.getDraftPool());
    }

    @Test
    public void testGetDice() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4, diceBag);
        draftPool.createListDice();
        draftPool.removeDice(0);
        assertEquals(4, draftPool.getNowNumber());
    }

    @Test
    public void testSetNumber() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4, diceBag);
        draftPool.setNumber(3);
        draftPool.createListDice();

        assertEquals(4, draftPool.getNowNumber());
    }


    @Test
    public void testToString() {
        DiceBag diceBag = new DiceBag();
        //DraftPool draftPool = new DraftPool(4, diceBag);
         DraftPool draftPool = new DraftPool(diceBag);

        draftPool.setNumber(3);
        draftPool.createListDice();

        System.out.println(draftPool.toString());

    }

}
