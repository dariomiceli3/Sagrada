package it.polimi.se2018.TestComponents;

import static org.fusesource.jansi.Ansi.ansi;
import static org.junit.Assert.assertEquals;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
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

    @Test
    public void testToString() {
        System.setProperty("jansi.passthrough", "true");


        //AnsiConsole.systemInstall();

        Dice dice = new Dice(1, DiceColor.RED);
        Dice dice2 = new Dice(2, DiceColor.PURPLE);
        Dice dice3 = new Dice(3, DiceColor.BLUE);
        Dice dice4 = new Dice(4, DiceColor.YELLOW);
        Dice dice5 = new Dice(5, DiceColor.GREEN);
        Dice dice6 = new Dice(6, DiceColor.RED);

        System.out.println(dice.toString());
        System.out.println(dice2.toString());
        System.out.println(dice3.toString());
        System.out.println(dice4.toString());
        System.out.println(dice5.toString());
        System.out.println(dice6.toString());


        //AnsiConsole.systemUninstall();
    }
}
