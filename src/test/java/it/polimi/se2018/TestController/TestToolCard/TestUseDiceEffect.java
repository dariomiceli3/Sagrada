package it.polimi.se2018.TestController.TestToolCard;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.controller.Toolcards.UseDiceEffect;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestUseDiceEffect {


   /* @Test(expected = InvalidMoveException.class)
    public void testGrozingPliersEffect() throws InvalidMoveException {
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice2 = new Dice(6, DiceColor.RED);
        Dice dice1;
        Dice dice4;
        UseDiceEffect useDiceEffect = new UseDiceEffect();
         dice1 = useDiceEffect.grozingPliersEffect(dice);
         dice4 = useDiceEffect.grozingPliersEffect(dice2);

         assertEquals(4, dice1.getValue());
    }

    @Test
    public void testfluxBrushEffect() {
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice2 = new Dice(6, DiceColor.RED);
        Dice dice1;
        Dice dice4;
        UseDiceEffect useDiceEffect = new UseDiceEffect();
        dice1 = useDiceEffect.fluxBrushEffect(dice);
        dice4 = useDiceEffect.fluxBrushEffect(dice2);

        System.out.println(dice1.getValue()+"\n"+dice4.getValue());
    }

    @Test
    public void testGlazingHammerEffect() {
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice2 = new Dice(6, DiceColor.RED);
        ArrayList<Dice> diceArrayList = new ArrayList<>();
        diceArrayList.add(dice);
        diceArrayList.add(dice2);
        UseDiceEffect useDiceEffect = new UseDiceEffect();
        diceArrayList = useDiceEffect.glazingHammerEffect(diceArrayList);


    }

    @Test
    public void testGrindingStoneEffect() {
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice2 = new Dice(6, DiceColor.RED);
        UseDiceEffect useDiceEffect = new UseDiceEffect();
        dice = useDiceEffect.grindingStoneEffect(dice);
        dice2 = useDiceEffect.grindingStoneEffect(dice2);

        assertEquals(4, dice.getValue());
        assertEquals(1, dice2.getValue());
    }

    @Test
    public void testLensCutterEffect() {
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice2 = new Dice(6, DiceColor.RED);
        UseDiceEffect useDiceEffect = new UseDiceEffect();
        ArrayList<Dice> diceArrayList;

        diceArrayList = useDiceEffect.lensCutterEffect(dice, dice2);

        assertEquals(3, diceArrayList.get(1).getValue());
        assertEquals(6, diceArrayList.get(0).getValue());
    }*/
}
