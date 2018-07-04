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
        GlassBox glassBox = new GlassBox(2);
        GlassBox glassBox1 = new GlassBox("Green");


        assertEquals(2, glassBox.getConstraintValue());
        assertEquals("Green", glassBox1.getConstraintColor());
    }

    @Test
    public void testToString() {

        GlassBox glassBox = new GlassBox("red");
        GlassBox glassBox1 = new GlassBox("purple");
        GlassBox glassBox2 = new GlassBox(5);
        GlassBox glassBox4 = new GlassBox("yellow");
        GlassBox glassBox5 = new GlassBox("blue");
        GlassBox glassBox6 = new GlassBox("green");



        Dice diceRed1 = new Dice(1, DiceColor.RED);
        Dice diceRed2 = new Dice(2, DiceColor.RED);
        Dice diceRed3 = new Dice(3, DiceColor.RED);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceRed5 = new Dice(5, DiceColor.RED);
        Dice diceRed6 = new Dice(6, DiceColor.RED);
        Dice diceYellow1 = new Dice(1, DiceColor.YELLOW);
        Dice diceYellow2 = new Dice(2, DiceColor.YELLOW);
        Dice diceYellow3 = new Dice(3, DiceColor.YELLOW);
        Dice diceYellow4 = new Dice(4, DiceColor.YELLOW);
        Dice diceYellow5 = new Dice(5, DiceColor.YELLOW);
        Dice diceYellow6 = new Dice(6, DiceColor.YELLOW);
        Dice dicePurple1 = new Dice(1, DiceColor.PURPLE);
        Dice dicePurple2 = new Dice(2, DiceColor.PURPLE);
        Dice dicePurple3 = new Dice(3, DiceColor.PURPLE);
        Dice dicePurple4 = new Dice(4, DiceColor.PURPLE);
        Dice dicePurple5 = new Dice(5, DiceColor.PURPLE);
        Dice dicePurple6 = new Dice(6, DiceColor.PURPLE);
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);
        Dice diceBlue3 = new Dice(3, DiceColor.BLUE);
        Dice diceBlue4 = new Dice(4, DiceColor.BLUE);
        Dice diceBlue5 = new Dice(5, DiceColor.BLUE);
        Dice diceBlue6 = new Dice(6, DiceColor.BLUE);
        Dice diceGreen1 = new Dice(1, DiceColor.GREEN);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);
        Dice diceGreen3 = new Dice(3, DiceColor.GREEN);
        Dice diceGreen4 = new Dice(4, DiceColor.GREEN);
        Dice diceGreen5 = new Dice(5, DiceColor.GREEN);
        Dice diceGreen6 = new Dice(6, DiceColor.GREEN);

        Dice dice = new Dice(6, DiceColor.GREEN);
        glassBox.setDice(dice);
        glassBox.unsetDice();

        Dice dice2 = new Dice(5, DiceColor.YELLOW);
        glassBox2.setDice(dice2);

        System.out.println(glassBox.toString());
        System.out.println(glassBox2.toString());

        glassBox.setDice(diceRed1);
        System.out.println(glassBox.toString());
        glassBox.unsetDice();
        glassBox.setDice(diceRed2);
        System.out.println(glassBox.toString());
        glassBox.unsetDice();
        glassBox.setDice(diceRed3);
        System.out.println(glassBox.toString());
        glassBox.unsetDice();
        glassBox.setDice(diceRed4);
        System.out.println(glassBox.toString());
        glassBox.unsetDice();
        glassBox.setDice(diceRed5);
        System.out.println(glassBox.toString());
        glassBox.unsetDice();
        glassBox.setDice(diceRed6);
        System.out.println(glassBox.toString());
        glassBox.unsetDice();

        glassBox4.setDice(diceYellow1);
        System.out.println(glassBox4.toString());
        glassBox4.unsetDice();
        glassBox4.setDice(diceYellow2);
        System.out.println(glassBox4.toString());
        glassBox4.unsetDice();
        glassBox4.setDice(diceYellow3);
        System.out.println(glassBox4.toString());
        glassBox4.unsetDice();
        glassBox4.setDice(diceYellow4);
        System.out.println(glassBox4.toString());
        glassBox4.unsetDice();
        glassBox4.setDice(diceYellow5);
        System.out.println(glassBox4.toString());
        glassBox4.unsetDice();
        glassBox4.setDice(diceYellow6);
        System.out.println(glassBox4.toString());
        glassBox4.unsetDice();

        glassBox1.setDice(dicePurple1);
        System.out.println(glassBox1.toString());
        glassBox1.unsetDice();
        glassBox1.setDice(dicePurple2);
        System.out.println(glassBox1.toString());
        glassBox1.unsetDice();
        glassBox1.setDice(dicePurple3);
        System.out.println(glassBox1.toString());
        glassBox1.unsetDice();
        glassBox1.setDice(dicePurple4);
        System.out.println(glassBox1.toString());
        glassBox1.unsetDice();
        glassBox1.setDice(dicePurple5);
        System.out.println(glassBox1.toString());
        glassBox1.unsetDice();
        glassBox1.setDice(dicePurple6);
        System.out.println(glassBox1.toString());
        glassBox1.unsetDice();

        glassBox5.setDice(diceBlue1);
        System.out.println(glassBox5.toString());
        glassBox5.unsetDice();
        glassBox5.setDice(diceBlue2);
        System.out.println(glassBox5.toString());
        glassBox5.unsetDice();
        glassBox5.setDice(diceBlue3);
        System.out.println(glassBox5.toString());
        glassBox5.unsetDice();
        glassBox5.setDice(diceBlue4);
        System.out.println(glassBox5.toString());
        glassBox5.unsetDice();
        glassBox5.setDice(diceBlue5);
        System.out.println(glassBox5.toString());
        glassBox5.unsetDice();
        glassBox5.setDice(diceBlue6);
        System.out.println(glassBox5.toString());
        glassBox5.unsetDice();

        glassBox6.setDice(diceGreen1);
        System.out.println(glassBox6.toString());
        glassBox6.unsetDice();
        glassBox6.setDice(diceGreen2);
        System.out.println(glassBox6.toString());
        glassBox6.unsetDice();
        glassBox6.setDice(diceGreen3);
        System.out.println(glassBox6.toString());
        glassBox6.unsetDice();
        glassBox6.setDice(diceGreen4);
        System.out.println(glassBox6.toString());
        glassBox6.unsetDice();
        glassBox6.setDice(diceGreen5);
        System.out.println(glassBox6.toString());
        glassBox6.unsetDice();
        glassBox6.setDice(diceGreen6);
        System.out.println(glassBox6.toString());
        glassBox6.unsetDice();
    }
}
