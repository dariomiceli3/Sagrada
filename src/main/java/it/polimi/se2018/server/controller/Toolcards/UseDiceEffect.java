package it.polimi.se2018.server.controller.Toolcards;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Components.Dice;

import java.util.ArrayList;
import java.util.Random;

public class UseDiceEffect {

    public Dice grozingPliersEffect(Dice dice) throws InvalidMoveException {
        int value = dice.getValue();
        if (value != 6) {
            int i = value + 1;
            dice.setValue(i);
        }
        else throw new InvalidMoveException("Mossa non valida");
        return dice;
    }

    public Dice fluxBrushEffect (Dice dice){
        Random random = new Random();
        int newValue = random.nextInt(6)+1;
        dice.setValue(newValue);
        return dice;
    }


    public ArrayList<Dice> glazingHammerEffect(ArrayList<Dice> diceArrayList){
        for (int i=0; i < diceArrayList.size(); i++) {
            Random random = new Random();
            int newValue = random.nextInt(6)+1;
            diceArrayList.get(i).setValue(newValue);
        }
        return diceArrayList;
    }

    public  Dice grindingStoneEffect(Dice dice) {
        int newValue = 7- dice.getValue();
        dice.setValue(newValue);
        return dice;
    }
    //TODO assumo che i due dadi mi vengano dati da RoundTracker e DraftPool e il metodo li restituisce nell'ordine inverso
    public ArrayList<Dice> lensCutterEffect(Dice diceFromRoundTracker, Dice diceFromDraftPool) {
        ArrayList<Dice> diceArrayList = new ArrayList<>();
        diceArrayList.add(diceFromDraftPool);
        diceArrayList.add(diceFromRoundTracker);
        return  diceArrayList;
    }
}
