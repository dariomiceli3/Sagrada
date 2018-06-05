package it.polimi.se2018.server.controller;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceBag;
import it.polimi.se2018.server.model.Components.DraftPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToolCardEffect {

    private Game game;

    protected ToolCardEffect(Game game){
        this.game = game;
    }

    //toolcard 1
    protected void grozingPliersEffect(int iD, int indexPool, int increase) throws InvalidMoveException {

        Dice dice = game.getModel().getDraftPool().getDraftPool().get(indexPool);
        // case decrease
        if (increase == 0) {

            if (dice.getValue() == 1) throw new InvalidMoveException("not valid move");
            game.getModel().getDraftPool().getDraftPool().get(indexPool).setValue(dice.getValue() - 1);
        }
        // case increase
        else {
            if (dice.getValue() == 6) throw new InvalidMoveException("not valid move");
            game.getModel().getDraftPool().getDraftPool().get(indexPool).setValue(dice.getValue() + 1);
        }

        game.getModel().updateBoardAndNotify();
        game.getModel().updateTokenAndNotify(iD);

    }

    //toolcard 2
    protected void eglomiseBrushEffect(int iD, int indexStart, int indexEnd) throws InvalidMoveException {

        Dice dice = game.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart);
        game.getModel().getPlayerFromID(iD).getPattern().putDiceOnPatternEglomise(dice, indexEnd, game.getModel().getPlayerFromID(iD).getPattern());
        game.getModel().updatePatternAndNotify(iD);
        game.getModel().updateTokenAndNotify(iD);
    }

    //toolcard 3
    protected void copperFoilBurnisherEffect(int iD, int indexStart, int indexEnd) throws InvalidMoveException {

        Dice dice = game.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart);
        game.getModel().getPlayerFromID(iD).getPattern().putDiceOnPatternCopper(dice, indexEnd, game.getModel().getPlayerFromID(iD).getPattern());
        game.getModel().updatePatternAndNotify(iD);
        game.getModel().updateTokenAndNotify(iD);
    }

    //toolcard 4
    protected void lathekinEffect(int iD, int indexStart1, int indexEnd1, int indexStart2, int indexEnd2) throws InvalidMoveException {

        Dice dice1 = game.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart1);
        game.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice1, indexEnd1, game.getModel().getPlayerFromID(iD).getPattern());
        Dice dice2 = game.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart2);
        game.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice2, indexEnd2, game.getModel().getPlayerFromID(iD).getPattern());
        game.getModel().updatePatternAndNotify(iD);
        game.getModel().updateTokenAndNotify(iD);
    }

    //toolcard 5
    protected void lensCutterEffect(int iD, int indexPool, int indexRound, int indexPosition) throws InvalidMoveException {

        Dice dice1 = game.getModel().getDraftPool().getDraftPool().remove(indexPool);
        Dice dice2 = game.getModel().getRoundTracker().getDice(indexRound, indexPosition);
        game.getModel().getDraftPool().setDice(dice2);
        try {
            game.getModel().getRoundTracker().addDice(dice1, indexRound);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        game.getModel().updateBoardAndNotify();
        game.getModel().updateTokenAndNotify(iD);


    }

    //toolcard 6


    protected Dice fluxBrushEffect (Dice dice){

        Random random = new Random();
        int newValue = random.nextInt(6) + 1;
        dice.setValue(newValue);
        return dice;
    }


    protected DraftPool glazingHammerEffect(int turn, int numberPlayers, DraftPool draftPool) throws InvalidMoveException{

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

    protected Dice grindingStoneEffect(Dice dice) {

        int newValue = 7 - dice.getValue();
        dice.setValue(newValue);
        return dice;

    }

    //TODO assumo che i dadi siano del colore giusto (Toolcard 12)
    protected void tapWheelEffect(PatternCard patternCard, ArrayList<Integer> PositionDiceToMove,ArrayList<Integer>PositionToArrive) throws InvalidMoveException {
        for (int i=0; i<PositionDiceToMove.size(); i++){
            if (i==2) {
                break;
            }
            else {
                Dice dice1 = patternCard.removeDice(PositionDiceToMove.get(i));
                patternCard.putDiceOnPattern(dice1, PositionToArrive.get(i), patternCard);
            }
        }
    }
    protected void corckBackedStraightedgeEffect(PatternCard patternCard, Dice dice, int position) throws InvalidMoveException {
        patternCard.putDice(dice, position);
    }

    protected Dice fluxRemoverEffect(Dice dice, DiceBag diceBag){
               diceBag.setDice(dice);
               Dice dice1 = diceBag.getDice();
               return dice1;
           }
}
