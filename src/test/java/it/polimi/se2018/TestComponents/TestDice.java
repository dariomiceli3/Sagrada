package it.polimi.se2018.TestComponents;

import static org.junit.Assert.assertEquals;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import  org.junit.Test;

public class TestDice {
    @Test

    public void testConstructor() {
        Dice dice = new Dice(5, DiceColor.RED);

        assertEquals(5, dice.getValue());
        assertEquals( DiceColor.RED, dice.getColor());
    }
    @Test
    public void testConstructor1() {
        Dice dice = new Dice();

        assertEquals(0, dice.getValue());
        assertEquals(null, dice.getColor());
    }

    @Test
    public void testSet() {
        Dice dice = new Dice();
        dice.setValue(6);
        dice.setColor(DiceColor.BLUE);

        assertEquals(6, dice.getValue());
        assertEquals(DiceColor.BLUE,dice.getColor());

    }
}
