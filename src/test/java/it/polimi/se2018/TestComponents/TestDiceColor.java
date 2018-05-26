package it.polimi.se2018.TestComponents;

import it.polimi.se2018.server.model.Components.DiceColor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDiceColor {

    @Test
    public void testDiceColor() {
        assertEquals("Red", DiceColor.RED.toString());
        assertEquals("Yellow", DiceColor.YELLOW.toString());
        assertEquals("Blue", DiceColor.BLUE.toString());
        assertEquals("Green", DiceColor.GREEN.toString());
        assertEquals("Purple", DiceColor.PURPLE.toString());

    }
}
