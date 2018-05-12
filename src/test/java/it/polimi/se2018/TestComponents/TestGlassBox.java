package it.polimi.se2018.TestComponents;

import it.polimi.se2018.model.Components.Dice;
import it.polimi.se2018.model.Components.DiceColor;
import it.polimi.se2018.model.Components.GlassBox;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGlassBox {

    @Test
    public void testConstructorDefault() {
        GlassBox glassBox = new GlassBox();

        assertEquals(0, glassBox.getConstraintValue());
        assertEquals(null, glassBox.getConstraintColor());
        assertEquals(null, glassBox.getDice());
    }

    @Test
    public void testConstructorValue() {
        GlassBox glassBox = new GlassBox(5);

        assertEquals(5,glassBox.getConstraintValue());
        assertEquals(null, glassBox.getConstraintColor());
        assertEquals(null, glassBox.getDice());
    }

    @Test
    public void testConstructorColor() {
        GlassBox glassBox = new GlassBox("Red");

        assertEquals(0, glassBox.getConstraintValue());
        assertEquals("Red", glassBox.getConstraintColor());
        assertEquals(null, glassBox.getDice());

    }

    @Test
    public void testUnsetDice() {
        GlassBox glassBox = new GlassBox();
        Dice dice = new Dice(3, DiceColor.YELLOW);

        glassBox.setDice(dice);
        Dice oldDice = glassBox.unsetDice();

        assertEquals(null, glassBox.getDice());
        assertEquals(3, oldDice.getValue());
        assertEquals(DiceColor.YELLOW, oldDice.getColor());
    }

    @Test
    public void testIsEmpty() {
        GlassBox glassBox = new GlassBox();
        Dice dice = new Dice(3, DiceColor.PURPLE);

        assertEquals(true, glassBox.isBoxEmpty());

        glassBox.setDice(dice);

        assertEquals(false, glassBox.isBoxEmpty());
    }

    @Test
    public void testIsBoxValid() {
        GlassBox glassBox = new GlassBox("Red");
        GlassBox glassBox1 = new GlassBox(3);
        GlassBox glassBox2 = new GlassBox();
        GlassBox glassBox3 = new GlassBox();
        Dice dice = new Dice(3, DiceColor.PURPLE);
        Dice dice1 = new Dice(4, DiceColor.RED);

        glassBox3.setDice(dice);



        assertEquals(false, glassBox.isBoxValid(dice));
        assertEquals(true, glassBox.isBoxValid(dice1));
        assertEquals(false, glassBox1.isBoxValid(dice1));
        assertEquals(true, glassBox1.isBoxValid(dice));
        assertEquals(true, glassBox2.isBoxValid(dice));
        glassBox2.unsetDice();
        assertEquals(true, glassBox2.isBoxValid(dice1));
        assertEquals(false, glassBox3.isBoxValid(dice1));
    }
}
