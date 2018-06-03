package it.polimi.se2018.TestComponents;

import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.GlassBox;
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
        GlassBox glassBox = new GlassBox("red");
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



    @Test
    public void testIsBoxValidEglomise() {
        GlassBox glassBox = new GlassBox("red");
        GlassBox glassBox1 = new GlassBox(3);
        GlassBox glassBox2 = new GlassBox();
        GlassBox glassBox3 = new GlassBox();
        Dice dice = new Dice(3, DiceColor.PURPLE);
        Dice dice1 = new Dice(4, DiceColor.RED);

        glassBox3.setDice(dice);



        assertEquals(true, glassBox.isBoxValidEglomise(dice));
        glassBox.unsetDice();
        assertEquals(true, glassBox.isBoxValidEglomise(dice1));

        assertEquals(false, glassBox1.isBoxValidEglomise(dice1));
        assertEquals(true, glassBox1.isBoxValidEglomise(dice));
        assertEquals(true, glassBox2.isBoxValidEglomise(dice));
        glassBox2.unsetDice();
        assertEquals(true, glassBox2.isBoxValidEglomise(dice1));
        assertEquals(false, glassBox3.isBoxValidEglomise(dice1));
    }

    @Test
    public void testIsBoxValidCopper() {
        GlassBox glassBox = new GlassBox("red");
        GlassBox glassBox1 = new GlassBox(3);
        GlassBox glassBox2 = new GlassBox();
        GlassBox glassBox3 = new GlassBox();
        Dice dice = new Dice(3, DiceColor.PURPLE);
        Dice dice1 = new Dice(4, DiceColor.RED);

        glassBox3.setDice(dice);



        assertEquals(false, glassBox.isBoxValidCopper(dice));
        assertEquals(true, glassBox.isBoxValidCopper(dice1));
        assertEquals(true, glassBox1.isBoxValidCopper(dice1));
        glassBox1.unsetDice();
        assertEquals(true, glassBox1.isBoxValidCopper(dice));
        assertEquals(true, glassBox2.isBoxValidCopper(dice));
        glassBox2.unsetDice();
        assertEquals(true, glassBox2.isBoxValidCopper(dice1));
        assertEquals(false, glassBox3.isBoxValidCopper(dice1));
    }

    @Test
    public void testSetter() {
        GlassBox glassBox = new GlassBox();

        glassBox.setConstraintColor("Green");
        glassBox.setConstraintValue(2);

        assertEquals(2, glassBox.getConstraintValue());
        assertEquals("Green", glassBox.getConstraintColor());
    }

    @Test
    public void testToString() {

        GlassBox glassBox = new GlassBox();
        GlassBox glassBox1 = new GlassBox();
        GlassBox glassBox2 = new GlassBox();
        GlassBox glassBox3 = new GlassBox();

        glassBox.setConstraintColor("red");
        glassBox1.setConstraintColor("purple");
        glassBox2.setConstraintValue(5);
        glassBox3.setConstraintValue(6);

        //System.out.println(glassBox.toString());
        //System.out.println(glassBox1.toString());
        //System.out.println(glassBox2.toString());
        //System.out.println(glassBox3.toString());

        Dice dice = new Dice(6, DiceColor.GREEN);
        glassBox.setDice(dice);
        Dice dice2 = new Dice(5, DiceColor.YELLOW);
        glassBox2.setDice(dice2);

        System.out.println(glassBox.toString());
        System.out.println(glassBox2.toString());

    }
}
