package it.polimi.se2018.server.controller;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceBag;
import it.polimi.se2018.server.model.Components.DraftPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//todo unire metodi di toolcard(somigliano 10-11-6-7   12-4-3)
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
    protected void fluxBrushEffect(int iD, int indexPool) {


        Random random = new Random();
        int newValue = random.nextInt(6) + 1;
        game.getModel().getDraftPool().getDraftPool().get(indexPool).setValue(newValue);
        game.getModel().updateBoardAndNotify();
        game.getModel().updateTokenAndNotify(iD);
    }

    //toolcard 7
    protected void glazingHammerEffect(int iD) throws InvalidMoveException{

        if (game.getTurn() > (game.getViewGame().size() - 1)) {
            List<Dice> newDicePlay;
            newDicePlay = game.getModel().getDraftPool().cleanListDice();

            for (Dice dice : newDicePlay) {
                Random random = new Random();
                int newValue = random.nextInt(6) + 1;
                dice.setValue(newValue);
                game.getModel().getDraftPool().setDice(dice);
            }
            game.getModel().updateBoardAndNotify();
            game.getModel().updateTokenAndNotify(iD);
        }

        else {
            throw new InvalidMoveException("not allowed now");
        }
    }

   /* //todo toolcard 8
    protected void runningPliers(VirtualView view) throws InvalidMoveException {

    }*/


    //toolcard 9
    protected void corkBackedStraightedgeEffect(int iD, int indexPool, int indexPattern) throws InvalidMoveException {

        if(game.getStep() == 1) {
            Dice dice = game.getModel().getDraftPool().getDraftPool().get(indexPool);
            game.getModel().getPlayerFromID(iD).getPattern().putDice(dice, indexPattern);
            game.getModel().updatePatternAndNotify(iD);
            game.getModel().updateBoardAndNotify();
            game.getModel().updateTokenAndNotify(iD);
        } else {
            System.out.println("Non puoi usarla ora");//Todo cancellare il println
            throw new InvalidMoveException("you just got a move");
        }
    }

    //toolcard 10
    protected void grindingStoneEffect(int iD, int indexPool) {

        int value = game.getModel().getDraftPool().getDraftPool().get(indexPool).getValue();
        game.getModel().getDraftPool().getDraftPool().get(indexPool).setValue(7 - value);
        game.getModel().updateBoardAndNotify();
        game.getModel().updateTokenAndNotify(iD);

    }

    //toolcard 11
    protected void fluxRemoverEffect(int iD, int indexPool, int value, Dice dice){


        dice.setValue(value);
        Dice dice1 = game.getModel().getDraftPool().getDraftPool().remove(indexPool);
        game.getModel().getDiceBag().setDice(dice1);
        game.getModel().getDraftPool().setDice(dice);
        game.getModel().updateBoardAndNotify();
        game.getModel().updateTokenAndNotify(iD);



        }

    //TODO assumo che i dadi siano del colore giusto (Toolcard 12)
    //toolcard 12
    protected void tapWheelEffect(int iD,int numberOfDice, int indexStart1, int indexEnd1, int indexStart2, int indexEnd2) throws InvalidMoveException {

        int c = 0;
        for(int i = 0; i < game.getModel().getRoundTracker().getRoundTracker().size(); i++) {
            for(int j = 0; j < game.getModel().getRoundTracker().getRoundDice(i).size(); j++ ){
                if(game.getModel().getRoundTracker().getRoundDice(i).get(j).getColor().equals(game.getModel().getPlayerFromID(iD).getPattern().getDice(indexStart1).getColor())){
                    c++;
                }
            }


        }
        if(numberOfDice > 1 && c > 0){

            if (game.getModel().getPlayerFromID(iD).getPattern().getDice(indexStart1).getColor().equals(game.getModel().getPlayerFromID(iD).getPattern().getDice(indexStart2).getColor()))
            {
            Dice dice1 = game.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart1);
            game.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice1, indexEnd1, game.getModel().getPlayerFromID(iD).getPattern());
            Dice dice2 = game.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart2);
            game.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice2, indexEnd2, game.getModel().getPlayerFromID(iD).getPattern());
            }
            else {
                throw new InvalidMoveException("you choose dice with different color");
            }
        }else if (c > 0){
            Dice dice1 = game.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart1);
            game.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice1, indexEnd1, game.getModel().getPlayerFromID(iD).getPattern());
        }else {
            throw new InvalidMoveException("color of dice not in RoundTracker");
        }
        game.getModel().updatePatternAndNotify(iD);
        game.getModel().updateTokenAndNotify(iD);
    }




}
