package it.polimi.se2018.server.controller;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Components.Dice;

import java.util.logging.Logger;

/**
 * Class ToolCardEffect: the class responsible of the different effect implemented by the tool card in the game
 */
class ToolCardEffect {

    private final Logger log = Logger.getLogger(ToolCardEffect.class.getName());
    private GameController gameController;

    /**
     * Class constructor that associate the class with the controller
     * @param gameController controller associated with the effect
     */
    ToolCardEffect(GameController gameController){
        this.gameController = gameController;
    }

    //toolcard 1
    /**
     * effect implemented by the grozing pliers tool card, set a new value to the dice depending on the choose made by the
     * player in the match
     * @param id of tha player
     * @param indexPool index of the dice in the card
     * @param increase increase or decrease decision by the player
     * @throws InvalidMoveException if something goes wrong
     */
    void grozingPliersEffect(int id, int indexPool, int increase) throws InvalidMoveException  {
        if (increase == 0) {
            try {
                gameController.getModel().setDiceValue(indexPool, 0, 1);
            }
            catch (InvalidMoveException e) {
                throw new InvalidMoveException(e.getMessage());
            }
        }
        if (increase == 1) {
            try {
                gameController.getModel().setDiceValue(indexPool, 1, 1);
            }
            catch (InvalidMoveException e) {
                throw new InvalidMoveException(e.getMessage());
            }
        }
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }

    //toolcard 2 + 3
    /**
     * method responsible of the effect of some tool cards that move a dice from an index of the pattern box list to
     * another one
     * @param id of the player
     * @param indexStart index where to take the dice
     * @param indexEnd index where to move it
     * @param number of the tool card on which the effect is running
     * @throws InvalidMoveException if something goes wrong
     */
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
    /**
     * method responsible of the effect of a tool card to move two dice from a position to another in the pattern card
     * @param id of the player
     * @param indexStart1 where to take the first dice
     * @param indexEnd1 where to move the first dice
     * @param indexStart2 where to take the second dice
     * @param indexEnd2 where to move the second dice
     * @throws InvalidMoveException if something goes wrong
     */
    void lathekinEffect(int id, int indexStart1, int indexEnd1, int indexStart2, int indexEnd2) throws InvalidMoveException {
        gameController.getModel().putFirstDiceToolCard(id, indexStart1, indexEnd1, 4);
        gameController.getModel().putSecondDiceToolCard(id ,indexStart1, indexEnd1, indexStart2, indexEnd2, 4);
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }

    //toolcard 5
    /**
     * method responsible of the effect of an exchange of a dice between the dice and the Round Tracker
     * @param id of the player
     * @param indexPool of the dice in draft pool
     * @param indexRound of the current round
     * @param indexPosition of the dice in the current round list
     */
    void lensCutterEffect(int id, int indexPool, int indexRound, int indexPosition) {
        gameController.getModel().exchangePoolRoundTracker(id, indexPool, indexRound, indexPosition);
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }

    //toolcard 7
    /**
     * method responsible of the effect of the shuffling all the dice in the draft pool at the moment of the cal
     * @param id of the player
     * @throws InvalidMoveException if something goes wrong
     */
    void glazingHammerEffect(int id) throws InvalidMoveException{
        if (gameController.getTurn() > (gameController.getViewGame().size() - 1)) {
            gameController.getModel().shufflePool();
            gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
        }
        else {
            throw new InvalidMoveException("Not Permitted to use it in the first round man!");
        }
    }

   //toolcard 8
    /**
     * method responsible of the effect to draft a die immediately after the first turn
     * @param id of the player
     * @param indexPool index of the dice in draft pool
     * @param indexPattern index of pattern box list where to put the dice
     * @throws InvalidMoveException if something goes wrong
     */
   void runningPliers(int id, int indexPool, int indexPattern) throws InvalidMoveException {
       try {
           if (gameController.getTurn() < gameController.getViewGame().size()) {
               gameController.getModel().putDiceToolCard(id, indexPool, indexPattern, 8);
           } else {
               throw new InvalidMoveException("Invalid turn moment");
           }
       }
       catch (InvalidMoveException e) {
           throw new InvalidMoveException(e.getMessage());

       }
   }

    //toolcard 9
    /**
     * method responsible of the effect of put a dice in the card ignoring the constraint of the other dice
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the pattern box list where to put the dice
     * @throws InvalidMoveException if something goes wrong
     */
    void corkBackedStraightedgeEffect(int id, int indexPool, int indexPattern) throws InvalidMoveException {

        try {
            if (gameController.getStep() == 1) {
                gameController.getModel().putDiceToolCard(id, indexPool, indexPattern, 9);
                gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
            }
            else {
                throw new InvalidMoveException("Invalid turn moment");
            }
        }
        catch (InvalidMoveException e) {
             throw new InvalidMoveException(e.getMessage());
        }
    }

    //toolcard 6+10
    /**
     * method responsible of the effect of changing the values of a dice depending on the tool card used by the player
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param number of the tool choosen by the player
     */
    void changeDiceValueEffect(int id, int indexPool, int number) {
        if (number == 6) {
            try {
                gameController.getModel().setDiceValue(indexPool, 0, 6);
            }
            catch (InvalidMoveException e) {
                log.warning(e.getMessage());
            }
        }
        else {
            try {
                gameController.getModel().setDiceValue(indexPool, 0, 10);
            }
            catch (InvalidMoveException e){
                log.warning(e.getMessage());
            }
        }
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }

    //toolcard 11
    /**
     * method responsible of the exchange of a dice between the draft pool and the dice bag
     * @param id of the player
     * @param indexPool of the dice in the draft pool
     * @param value to set to the dice
     * @param dice to insert in the pool
     */
    void fluxRemoverEffect(int id, int indexPool, int value, Dice dice){

        gameController.getModel().exchangePoolBag(indexPool, value, dice);
        gameController.getModel().endToolCard(gameController.isSinglePlayer(), id);
    }

    //toolcard 12
    /**
     * method responsible of the effect of moving up to two dice,depending on the chose of the player,
     * in the pattern box list that match the color of a dice in the round tracker
     * @param id of the player
     * @param numberOfDice to move up
     * @param indexStart1 index of the first dice to move
     * @param indexEnd1 index where to move the first dice
     * @param indexStart2 index of the second dice to move
     * @param indexEnd2 index where to move the second dice
     * @throws InvalidMoveException if something goes wrong
     */
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
