package it.polimi.se2018.TestComponents;

import it.polimi.se2018.server.model.Components.DiceColor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDiceColor {

    @Test
    public void testDiceColor() {
        assertEquals("red", DiceColor.RED.toString());
        assertEquals("yellow", DiceColor.YELLOW.toString());
        assertEquals("blue", DiceColor.BLUE.toString());
        assertEquals("green", DiceColor.GREEN.toString());
        assertEquals("purple", DiceColor.PURPLE.toString());
        assertEquals("", DiceColor.test.toString());

    }
}
