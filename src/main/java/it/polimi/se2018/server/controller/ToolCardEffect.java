package it.polimi.se2018.server.controller;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.controller.Game;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceBag;
import it.polimi.se2018.server.model.Components.DraftPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToolCardEffect {

    private Game game;

    public ToolCardEffect(Game game){
        this.game = game;
    }

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
    public void lensCutterEffect(Dice diceTracker, Dice dicePool) {
        List<Dice> diceArrayList = new ArrayList<>();

    }

    public void eglomiseBrushEffect(PatternCard patternCard, Dice dice, int i) throws InvalidMoveException {
        patternCard.putDiceOnPatternEglomise(dice, i, patternCard);
    }

    public void copperFoilBurnisherEffect(PatternCard patternCard, Dice dice, int i) throws InvalidMoveException {
        patternCard.putDiceOnPatternCopper(dice, i, patternCard);
    }


    public void lathekinEffect(PatternCard patternCard, ArrayList<Integer> PositionDiceToMove, ArrayList<Integer>PositionToArrive ) throws InvalidMoveException {
        Dice dice = patternCard.getDice(PositionDiceToMove.get(0));
        Dice dice1 = patternCard.removeDice(dice, PositionDiceToMove.get(0));
        Dice dice2 = patternCard.getDice(PositionDiceToMove.get(1));
        Dice dice3 = patternCard.removeDice(dice2, PositionDiceToMove.get(1));
        patternCard.putDiceOnPattern(dice1, PositionToArrive.get(0), patternCard);
        patternCard.putDiceOnPattern(dice3, PositionToArrive.get(1), patternCard);
    }

    //TODO assumo che i dadi siano del colore giusto (Toolcard 12)
    public void tapWheelEffect(PatternCard patternCard, ArrayList<Integer> PositionDiceToMove,ArrayList<Integer>PositionToArrive) throws InvalidMoveException {
        for (int i=0; i<PositionDiceToMove.size(); i++){
            if (i==2) {
                break;
            }
            else {
                Dice dice = patternCard.getDice(PositionDiceToMove.get(i));
                Dice dice1 = patternCard.removeDice(dice, PositionDiceToMove.get(i));
                patternCard.putDiceOnPattern(dice1, PositionToArrive.get(i), patternCard);
            }
        }
    }
    public void corckBackedStraightedgeEffect(PatternCard patternCard, Dice dice, int position) throws InvalidMoveException {
        patternCard.putDice(dice, position);
    }

    public Dice fluxRemoverEffect(Dice dice, DiceBag diceBag){
               diceBag.setDice(dice);
               Dice dice1 = diceBag.getDice();
               return dice1;
           }
}