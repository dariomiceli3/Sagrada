package it.polimi.se2018.server.controller;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.events.serverclient.controllerview.ToolCardUpdateEvent;

import java.util.List;
import java.util.Random;


class ToolCardEffect {

    private GameController gameController;

    ToolCardEffect(GameController gameController){
        this.gameController = gameController;
    }

    //toolcard 1
    void grozingPliersEffect(int iD, int indexPool, int increase) throws InvalidMoveException {

        Dice dice = gameController.getModel().getDraftPool().getDraftPool().get(indexPool);
        // case decrease
        if (increase == 0) {

            if (dice.getValue() == 1) throw new InvalidMoveException("not valid decrease if value is 1");
            gameController.getModel().getDraftPool().getDraftPool().get(indexPool).setValue(dice.getValue() - 1);
        }
        // case increase
        if (increase == 1) {

            if (dice.getValue() == 6) throw new InvalidMoveException("not valid increase if value is 6");
            gameController.getModel().getDraftPool().getDraftPool().get(indexPool).setValue(dice.getValue() + 1);
        }

        gameController.getModel().updateBoardAndNotify();
        if(!gameController.isSinglePlayer()){
            gameController.getModel().updateTokenAndNotify(iD);
        }else {
            gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
        }

    }

    //toolcard 2
    void eglomiseBrushEffect(int iD, int indexStart, int indexEnd) throws InvalidMoveException {

        Dice dice = gameController.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart);
        gameController.getModel().getPlayerFromID(iD).getPattern().putDiceOnPatternEglomise(dice, indexEnd, gameController.getModel().getPlayerFromID(iD).getPattern());
        gameController.getModel().updatePatternAndNotify(iD);
        if(!gameController.isSinglePlayer()){
            gameController.getModel().updateTokenAndNotify(iD);
        }else {
            gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
        }
    }

    //toolcard 3
    void copperFoilBurnisherEffect(int iD, int indexStart, int indexEnd) throws InvalidMoveException {

        Dice dice = gameController.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart);
        gameController.getModel().getPlayerFromID(iD).getPattern().putDiceOnPatternCopper(dice, indexEnd, gameController.getModel().getPlayerFromID(iD).getPattern());
        gameController.getModel().updatePatternAndNotify(iD);
        if(!gameController.isSinglePlayer()){
            gameController.getModel().updateTokenAndNotify(iD);
        }else {
            gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
        }
    }

    //toolcard 4
    void lathekinEffect(int iD, int indexStart1, int indexEnd1, int indexStart2, int indexEnd2) throws InvalidMoveException {

        Dice dice1 = gameController.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart1);
        try {
            gameController.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice1, indexEnd1, gameController.getModel().getPlayerFromID(iD).getPattern());
        }
        catch (InvalidMoveException e) {
            gameController.getModel().getPlayerFromID(iD).getPattern().putAnyDice(dice1, indexStart1);
            throw new InvalidMoveException("Error first dice");
        }

        Dice dice2 = gameController.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart2);
        try {
            gameController.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice2, indexEnd2, gameController.getModel().getPlayerFromID(iD).getPattern());
        }
        catch (InvalidMoveException e) {
            gameController.getModel().getPlayerFromID(iD).getPattern().putAnyDice(dice2, indexStart2);
            throw new InvalidMoveException("Error second dice");
        }
        gameController.getModel().updatePatternAndNotify(iD);
        if(!gameController.isSinglePlayer()){
            gameController.getModel().updateTokenAndNotify(iD);
        }else {
            gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
        }
    }

    //toolcard 5
    void lensCutterEffect(int iD, int indexPool, int indexRound, int indexPosition) {

        Dice dice1 = gameController.getModel().getDraftPool().getDraftPool().remove(indexPool);
        Dice dice2 = gameController.getModel().getRoundTracker().getDice(indexRound, indexPosition);
        gameController.getModel().getDraftPool().setDice(dice2);
        gameController.getModel().getRoundTracker().addDice(dice1, indexRound);
        gameController.getModel().updateBoardAndNotify();
        if(!gameController.isSinglePlayer()){
            gameController.getModel().updateTokenAndNotify(iD);
        }else {
            gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
        }


    }

    //toolcard 6
    void fluxBrushEffect(int iD, int indexPool) {


        Random random = new Random();
        int newValue = random.nextInt(6) + 1;
        gameController.getModel().getDraftPool().getDraftPool().get(indexPool).setValue(newValue);
        gameController.getModel().updateBoardAndNotify();
        if(!gameController.isSinglePlayer()){
            gameController.getModel().updateTokenAndNotify(iD);
        }else {
            gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
        }
    }

    //toolcard 7
    void glazingHammerEffect(int iD) throws InvalidMoveException{

        if (gameController.getTurn() > (gameController.getViewGame().size() - 1)) {
            List<Dice> newDicePlay;
            newDicePlay = gameController.getModel().getDraftPool().cleanListDice();

            for (Dice dice : newDicePlay) {
                Random random = new Random();
                int newValue = random.nextInt(6) + 1;
                dice.setValue(newValue);
                gameController.getModel().getDraftPool().setDice(dice);
            }
            gameController.getModel().updateBoardAndNotify();
            if(!gameController.isSinglePlayer()){
                gameController.getModel().updateTokenAndNotify(iD);
            }else {
                gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
            }
        }

        else {
            throw new InvalidMoveException("Not Permitted to use it in the first round man!");
        }
    }

   //toolcard 8
   void runningPliers(int iD, int indexPool, int indexPattern) throws InvalidMoveException {

       if (gameController.getStep() == 0 && gameController.getTurn() < gameController.getViewGame().size()) {
           Dice dice = gameController.getModel().getDraftPool().getDraftPool().remove(indexPool);
           gameController.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice, indexPattern, gameController.getModel().getPlayerFromID(iD).getPattern());
           gameController.getModel().getPlayerFromID(iD).setRunningP(true);
           gameController.getModel().updatePatternAndNotify(iD);
           gameController.getModel().updateBoardAndNotify();
           gameController.getModel().updateTokenAndNotify(iD);

       } else {
           throw new InvalidMoveException("Invalid turn moment");
       }
   }

    //toolcard 9
    void corkBackedStraightedgeEffect(int iD, int indexPool, int indexPattern) throws InvalidMoveException {

        if(gameController.getStep() == 1) {
            Dice dice = gameController.getModel().getDraftPool().getDraftPool().remove(indexPool);
            gameController.getModel().getPlayerFromID(iD).getPattern().putDice(dice, indexPattern);
            gameController.getModel().updatePatternAndNotify(iD);
            gameController.getModel().updateBoardAndNotify();
            if(!gameController.isSinglePlayer()){
                gameController.getModel().updateTokenAndNotify(iD);
            }else {
                gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
            }
        } else {
            throw new InvalidMoveException("Invalid turn moment");
        }
    }

    //toolcard 10
    void grindingStoneEffect(int iD, int indexPool) {

        int value = gameController.getModel().getDraftPool().getDraftPool().get(indexPool).getValue();
        gameController.getModel().getDraftPool().getDraftPool().get(indexPool).setValue(7 - value);
        gameController.getModel().updateBoardAndNotify();
        if(!gameController.isSinglePlayer()){
            gameController.getModel().updateTokenAndNotify(iD);
        }else {
            gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
        }

    }

    //toolcard 11
    void fluxRemoverEffect(int iD, int indexPool, int value, Dice dice){


        dice.setValue(value);
        Dice dice1 = gameController.getModel().getDraftPool().getDraftPool().remove(indexPool);
        gameController.getModel().getDiceBag().setDice(dice1);
        gameController.getModel().getDraftPool().setDice(dice);
        gameController.getModel().updateBoardAndNotify();
        if(!gameController.isSinglePlayer()){
            gameController.getModel().updateTokenAndNotify(iD);
        }else {
            gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
        }



    }


    //toolcard 12
    void tapWheelEffect(int iD, int numberOfDice, int indexStart1, int indexEnd1, int indexStart2, int indexEnd2) throws InvalidMoveException {

        int c = 0;
        for(int i = 0; i < gameController.getModel().getRoundTracker().getRoundTracker().size(); i++) {
            for(int j = 0; j < gameController.getModel().getRoundTracker().getRoundDice(i).size(); j++ ){
                if(gameController.getModel().getRoundTracker().getRoundDice(i).get(j).getColor().equals(gameController.getModel().getPlayerFromID(iD).getPattern().getDice(indexStart1).getColor())){
                    c++;
                }
            }


        }
        if (numberOfDice > 1 && c > 0){

            if (gameController.getModel().getPlayerFromID(iD).getPattern().getDice(indexStart1).getColor().equals(gameController.getModel().getPlayerFromID(iD).getPattern().getDice(indexStart2).getColor()))
            {
                Dice dice1 = gameController.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart1);
                try {
                    gameController.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice1, indexEnd1, gameController.getModel().getPlayerFromID(iD).getPattern());
                }
                catch (InvalidMoveException e) {
                    gameController.getModel().getPlayerFromID(iD).getPattern().putAnyDice(dice1, indexStart1);
                    throw new InvalidMoveException("Error in the first dice");
                }
                Dice dice2 = gameController.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart2);
                try {
                    gameController.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice2, indexEnd2, gameController.getModel().getPlayerFromID(iD).getPattern());
                }
                catch (InvalidMoveException e) {
                    gameController.getModel().getPlayerFromID(iD).getPattern().putAnyDice(dice2, indexStart2);
                    gameController.getModel().getPlayerFromID(iD).getPattern().removeDice(indexEnd1);
                    gameController.getModel().getPlayerFromID(iD).getPattern().putAnyDice(dice1, indexStart1);
                    throw new InvalidMoveException("Error in the second dice");
                }
            }
            else {
                throw new InvalidMoveException("You choose two dice with different colors");
            }
        }
        else if (c > 0){
            Dice dice1 = gameController.getModel().getPlayerFromID(iD).getPattern().removeDice(indexStart1);
            gameController.getModel().getPlayerFromID(iD).getPattern().putDiceOnPattern(dice1, indexEnd1, gameController.getModel().getPlayerFromID(iD).getPattern());
        }
        else {
            throw new InvalidMoveException("There's no dice on the Round Tracker of the same color");
        }
        gameController.getModel().updatePatternAndNotify(iD);
        if(!gameController.isSinglePlayer()){
            gameController.getModel().updateTokenAndNotify(iD);
        }else {
            gameController.getViewGame().get(0).sendEvent(new ToolCardUpdateEvent(gameController.getModel().getToolCardList()));
        }
    }






}
