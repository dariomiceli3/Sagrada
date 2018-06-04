package it.polimi.se2018.TestController.TestToolCard;

import it.polimi.se2018.server.controller.Toolcards.ExchangeEffct;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceBag;
import org.junit.Test;

public class TestExchangeEffect {

    @Test
    public void testFluxRemoverEffect() {
        DiceBag diceBag=new DiceBag();
        Dice dice;
        dice = diceBag.getDice();
        System.out.println(dice.toString());
        ExchangeEffct exchangeEffct = new ExchangeEffct();
        dice = exchangeEffct.fluxRemoverEffect(dice, diceBag);
        System.out.println(dice.toString());
    }
}
