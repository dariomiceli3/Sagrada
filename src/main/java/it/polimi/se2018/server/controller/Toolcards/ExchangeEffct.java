package it.polimi.se2018.server.controller.Toolcards;

import com.sun.xml.internal.bind.v2.TODO;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceBag;

public class ExchangeEffct {

    public Dice fluxRemoverEffect(Dice dice, DiceBag diceBag){
        diceBag.setDice(dice);
        Dice dice1 = diceBag.getDice();
        return dice1;
    }

    //TODO fare la toolcard 8 dopo aver fatto i turni
}
