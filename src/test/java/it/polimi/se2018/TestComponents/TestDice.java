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

        System.out.println(diceRed1.toString());
        System.out.println(diceRed2.toString());
        System.out.println(diceRed3.toString());
        System.out.println(diceRed4.toString());
        System.out.println(diceRed5.toString());
        System.out.println(diceRed6.toString());
        System.out.println(diceYellow1.toString());
        System.out.println(diceYellow2.toString());
        System.out.println(diceYellow3.toString());
        System.out.println(diceYellow4.toString());
        System.out.println(diceYellow5.toString());
        System.out.println(diceYellow6.toString());
        System.out.println(dicePurple1.toString());
        System.out.println(dicePurple2.toString());
        System.out.println(dicePurple3.toString());
        System.out.println(dicePurple4.toString());
        System.out.println(dicePurple5.toString());
        System.out.println(dicePurple6.toString());
        System.out.println(diceBlue1.toString());
        System.out.println(diceBlue2.toString());
        System.out.println(diceBlue3.toString());
        System.out.println(diceBlue4.toString());
        System.out.println(diceBlue5.toString());
        System.out.println(diceBlue6.toString());
        System.out.println(diceGreen1.toString());
        System.out.println(diceGreen2.toString());
        System.out.println(diceGreen3.toString());
        System.out.println(diceGreen4.toString());
        System.out.println(diceGreen5.toString());
        System.out.println(diceGreen6.toString());


        //AnsiConsole.systemUninstall();
    }

    @Test
    public void testToStringGui() {
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

        System.out.println(diceRed1.toStringGui());
        System.out.println(diceRed2.toStringGui());
        System.out.println(diceRed3.toStringGui());
        System.out.println(diceRed4.toStringGui());
        System.out.println(diceRed5.toStringGui());
        System.out.println(diceRed6.toStringGui());
        System.out.println(diceYellow1.toStringGui());
        System.out.println(diceYellow2.toStringGui());
        System.out.println(diceYellow3.toStringGui());
        System.out.println(diceYellow4.toStringGui());
        System.out.println(diceYellow5.toStringGui());
        System.out.println(diceYellow6.toStringGui());
        System.out.println(dicePurple1.toStringGui());
        System.out.println(dicePurple2.toStringGui());
        System.out.println(dicePurple3.toStringGui());
        System.out.println(dicePurple4.toStringGui());
        System.out.println(dicePurple5.toStringGui());
        System.out.println(dicePurple6.toStringGui());
        System.out.println(diceBlue1.toStringGui());
        System.out.println(diceBlue2.toStringGui());
        System.out.println(diceBlue3.toStringGui());
        System.out.println(diceBlue4.toStringGui());
        System.out.println(diceBlue5.toStringGui());
        System.out.println(diceBlue6.toStringGui());
        System.out.println(diceGreen1.toStringGui());
        System.out.println(diceGreen2.toStringGui());
        System.out.println(diceGreen3.toStringGui());
        System.out.println(diceGreen4.toStringGui());
        System.out.println(diceGreen5.toStringGui());
        System.out.println(diceGreen6.toStringGui());
    }
}
