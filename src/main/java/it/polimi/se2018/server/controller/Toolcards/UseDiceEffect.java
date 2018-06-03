package it.polimi.se2018.server.controller.Toolcards;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DraftPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UseDiceEffect {

    public Dice grozingPliersEffect(Dice dice, boolean increase) throws InvalidMoveException {

        int diceValue = dice.getValue();
        // case decrease
        if (!increase) {

            if (diceValue == 1) throw new InvalidMoveException("not valid move");
            diceValue--;
            dice.setValue(diceValue);
        }
        // case increase
        else {
            if (diceValue == 6) throw new InvalidMoveException("not valid move");
            diceValue++;
            dice.setValue(diceValue);
        }
        return dice;

    }

    public Dice fluxBrushEffect (Dice dice){

        Random random = new Random();
        int newValue = random.nextInt(6) + 1;
        dice.setValue(newValue);
        return dice;
    }


    public DraftPool glazingHammerEffect(int turn, int numberPlayers, DraftPool draftPool) throws InvalidMoveException{

        if (turn > (numberPlayers - 1)) {
            List<Dice> newDicePlay;
            newDicePlay = draftPool.cleanListDice();

            for (Dice dice : newDicePlay) {
                Random random = new Random();
                int newValue = random.nextInt(6) + 1;
                dice.setValue(newValue);
                draftPool.setDice(dice);
            }
        }

        else {
            throw new InvalidMoveException("not allowed now");
        }
        return draftPool;
    }

    public Dice grindingStoneEffect(Dice dice) {

        int newValue = 7 - dice.getValue();
        dice.setValue(newValue);
        return dice;

    }


    // todo cambiare in base alla cli, e decidere cosa passarle
    /*public void lensCutterEffect(Dice diceTracker, Dice dicePool) {
        List<Dice> diceArrayList = new ArrayList<>();
        diceArrayList.add(diceFromDraftPool);
        diceArrayList.add(diceFromRoundTracker);
        return  diceArrayList;
    }*/
}
