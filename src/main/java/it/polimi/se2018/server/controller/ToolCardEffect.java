package it.polimi.se2018.server.controller;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Components.Dice;

class ToolCardEffect {

    private GameController gameController;

    ToolCardEffect(GameController gameController){
        this.gameController = gameController;
    }

    //toolcard 1
    void grozingPliersEffect(int id, int indexPool, int increase) throws InvalidMoveException {

        if (increase == 0) {
            gameController.getModel().setDiceValue(indexPool, 0, 1);
        }
        if (increase == 1) {
            gameController.getModel().setDiceValue(indexPool, 1, 1);
        }
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }

    //toolcard 2 + 3
    void moveOneDiceEffect(int id, int indexStart, int indexEnd, int number) throws InvalidMoveException {
        if (number == 2) {
            gameController.getModel().putFirstDiceToolCard(id, indexStart, indexEnd, 2);
        }
        else {
            gameController.getModel().putFirstDiceToolCard(id, indexStart, indexEnd, 3);
        }
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }

    //toolcard 4
    void lathekinEffect(int id, int indexStart1, int indexEnd1, int indexStart2, int indexEnd2) throws InvalidMoveException {

        gameController.getModel().putFirstDiceToolCard(id, indexStart1, indexEnd1, 4);
        gameController.getModel().putSecondDiceToolCard(id ,indexStart1, indexEnd1, indexStart2, indexEnd2, 4);
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }

    //toolcard 5
    void lensCutterEffect(int id, int indexPool, int indexRound, int indexPosition) {

        gameController.getModel().exchangePoolRoundTracker(id, indexPool, indexRound, indexPosition);
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);

    }


    //toolcard 7
    void glazingHammerEffect(int id) throws InvalidMoveException{

        if (gameController.getTurn() > (gameController.getViewGame().size() - 1)) {
            gameController.getModel().reRollPool();
            gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
        }
        else {
            throw new InvalidMoveException("Not Permitted to use it in the first round man!");
        }
    }

   //toolcard 8
   void runningPliers(int id, int indexPool, int indexPattern) throws InvalidMoveException {

       if (gameController.getTurn() < gameController.getViewGame().size()) {
           gameController.getModel().putDiceToolCard(id, indexPool, indexPattern, 8);
       }
       else {
           throw new InvalidMoveException("Invalid turn moment");
       }
   }

    //toolcard 9
    void corkBackedStraightedgeEffect(int id, int indexPool, int indexPattern) throws InvalidMoveException {

        if (gameController.getStep() == 1) {
            gameController.getModel().putDiceToolCard(id, indexPool, indexPattern, 9);
            gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
        }
        else {
            throw new InvalidMoveException("Invalid turn moment");
        }
    }

    //toolcard 6+10
    void changeDiceValueEffect(int id, int indexPool, int number) {
        if (number == 6) {
            gameController.getModel().setDiceValue(indexPool, 0, 6);
        }
        else {
            gameController.getModel().setDiceValue(indexPool, 0, 10);
        }
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }

    //toolcard 11
    void fluxRemoverEffect(int id, int indexPool, int value, Dice dice){

        gameController.getModel().exchangePoolBag(indexPool, value, dice);
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }

    //toolcard 12
    void tapWheelEffect(int id, int numberOfDice, int indexStart1, int indexEnd1, int indexStart2, int indexEnd2) throws InvalidMoveException {

        int c = 0;
        for(int i = 0; i < gameController.getModel().getRoundTracker().getRoundTracker().size(); i++) {
            for(int j = 0; j < gameController.getModel().getRoundTracker().getRoundDice(i).size(); j++ ){
                if(gameController.getModel().getRoundTracker().getRoundDice(i).get(j).getColor().equals(gameController.getModel().getPlayerFromID(id).getPattern().getDice(indexStart1).getColor())){
                    c++;
                }
            }
        }
        if (numberOfDice > 1 && c > 0) {

            if (gameController.getModel().checkEqualsDice(id, indexStart1, indexStart2)) {
                gameController.getModel().putFirstDiceToolCard(id, indexStart1, indexEnd1, 12);
                gameController.getModel().putSecondDiceToolCard(id, indexStart1, indexEnd1, indexStart2, indexEnd2,12);
            }
            else {
                throw new InvalidMoveException("You choose two dice with different colors");
            }
        }
        else if (c > 0){
            gameController.getModel().putFirstDiceToolCard(id,indexStart1, indexEnd1, 12);
        }
        else {
            throw new InvalidMoveException("There's no dice on the Round Tracker of the same color");
        }
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }


}
