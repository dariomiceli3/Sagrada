package it.polimi.se2018.TestComponents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import it.polimi.se2018.model.Components.Dice;
import it.polimi.se2018.model.Components.DiceBag;
import it.polimi.se2018.model.Components.DiceColor;
import org.junit.Test;

import java.util.Iterator;

public class TestDiceBag {

    @Test
    public void testConstructor() {
        int countRed = 0;
        int countYellow = 0;
        int countGreen = 0;
        int countPurple = 0;
        int countBlue = 0;

        DiceBag diceBag = new DiceBag();
        assertEquals(90, diceBag.getListBag().size());
        for (int i = 0; i < 90; i++) {
            Dice dice = diceBag.getDice();

            if (dice.getColor()== DiceColor.RED) {
                countRed++;
            }
            if (dice.getColor()== DiceColor.YELLOW) {
                countYellow++;
            }
            if (dice.getColor() == DiceColor.GREEN) {
                countGreen++;
            }
            if (dice.getColor()== DiceColor.PURPLE) {
                countPurple++;
            }
            if (dice.getColor() == DiceColor.BLUE) {
                countBlue++;
            }
            if (dice.getValue() == 0)   {
                fail();
            }
            if (dice.getValue() > 6) {
                fail();
            }
        }
        assertEquals(18, countBlue);
        assertEquals(18, countRed);
        assertEquals(18, countGreen);
        assertEquals(18, countYellow);
        assertEquals(18, countPurple);
    }

    @Test
    public void testSet() {
        Dice dice = new Dice(3, DiceColor.GREEN);
        DiceBag diceBag = new DiceBag();
        diceBag.getDice();
        diceBag.getDice();
        assertEquals(88, diceBag.getListBag().size());
        diceBag.setDice(dice);
        assertEquals(89, diceBag.getListBag().size());
        
    }
}
