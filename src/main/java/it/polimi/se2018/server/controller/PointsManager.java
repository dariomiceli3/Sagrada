package it.polimi.se2018.server.controller;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Components.RoundTracker;

import java.util.*;

/**
 * class PointsManager: class used to calculate the final points of players at the end of the
 * game in both of two mode(multi player and single player)
 *
 */
class PointsManager {

    private static final int VPOINTS = 3;

    /**
     * method that calculates the points of the private card for each player
     * @param playerArrayList list of players that played the game
     * @return list of integer corresponding the points of each player in the same order of the players
     */
    private List<Integer> calculatePrivate(List<Player> playerArrayList) {
        List<Integer> results = new ArrayList<>();

        for (Player aPlayerArrayList : playerArrayList) {
            int result;
            result = aPlayerArrayList.getPrivate().runPrivate(aPlayerArrayList.getPattern());
            aPlayerArrayList.setPrivatePoints(result);
            results.add(result);
        }
        return results;
    }

    /**
     * method that calculates the left tokens of each player
     * @param playerArrayList list of players that played the game
     * @return list of integer corresponding the tokens of each player in the same order of the players
     */
    private List<Integer> calculateTokens(List<Player> playerArrayList) {

        List<Integer> results = new ArrayList<>();

        for (Player aPlayerArrayList : playerArrayList) {
            int result;
            result = aPlayerArrayList.getTokensNumber();
            results.add(result);
        }
        return results;
    }

    /**
     * method that calculates the number of empty boxes of players' pattern card
     * @param playerArrayList list of players that played the game
     * @return list of integer corresponding the number of empty boxes in the same order of the players
     */
    private List<Integer> calculateEmptyBox(List<Player> playerArrayList) {

        PatternCard result;
        List<Integer> results = new ArrayList<>();

        for (Player aPlayerArrayList : playerArrayList) {
            result = aPlayerArrayList.getPattern();
            int boxEmptyCounter = 0;

            for (int j = 0; j < result.getPattern().size(); j++) {
                if (result.getPattern().get(j).isBoxEmpty()) {
                    boxEmptyCounter++;
                }
            }
            results.add(boxEmptyCounter);
        }
        return results;
    }

    /**
     * method that calculates the total points of the public cards for each player
     * @param playerArrayList list of players that played the game
     * @param publicObjectiveCardArrayList list of public cards delivered at the beginning of the game
     * @return list of integer corresponding the total points of the public cards in the same order of the players
     */
    private List<Integer> calculatePublic(List<Player> playerArrayList, List<PublicObjectiveCard> publicObjectiveCardArrayList) {

        List<Integer> results = new ArrayList<>();

        for (Player aPlayerArrayList : playerArrayList) {
            PatternCard result;
            int personalResult = 0;
            result = aPlayerArrayList.getPattern();
            for (PublicObjectiveCard aPublicObjectiveCardArrayList : publicObjectiveCardArrayList) {
                personalResult = personalResult + aPublicObjectiveCardArrayList.executeEffect(result);

            }
            results.add(personalResult);
        }
        return results;
    }

    /**
     * method that calculates the final points for each player
     * @param playerArrayList list of players that played the game
     * @param publicObjectiveCardArrayList list of public cards delivered at the beginning of the game
     * @return list of players
     */
    private List<Player> calculatePoints (List<Player> playerArrayList, List<PublicObjectiveCard> publicObjectiveCardArrayList ) {

        List<Integer> result1;
        List<Integer> result2;
        List<Integer> result3;
        List<Integer> result4;

        result1 = calculateEmptyBox(playerArrayList);
        result2 = calculatePrivate(playerArrayList);
        result3 = calculateTokens(playerArrayList);
        result4 = calculatePublic(playerArrayList, publicObjectiveCardArrayList);

        for (int i = 0; i < result1.size(); i++) {
            int sum;
            sum = result4.get(i) + result2.get(i) + result3.get(i) - result1.get(i);
            playerArrayList.get(i).setFinalPoints(sum);
        }
        return playerArrayList;
    }

    /**
     * method that sorts the list of players by final points and private points
     * @param playerArrayList list of players that played the game
     * @return list of sorted players
     */
    private List<Player> checkPoints (List<Player> playerArrayList) {
        for (int k=0; k < playerArrayList.size(); k++) {
            for (int i = 0; i < playerArrayList.size() - 1; i++) {
                if (playerArrayList.get(i).getFinalPoints() == playerArrayList.get(i + 1).getFinalPoints()) {

                    if (playerArrayList.get(i).getPrivatePoints() < playerArrayList.get(i + 1).getPrivatePoints()) {

                        Player player = copy(playerArrayList.get(i));


                        playerArrayList.set(i, playerArrayList.get(i + 1));
                        playerArrayList.set(i + 1, player);


                    }
                }
            }
        }
        for (int k=0; k < playerArrayList.size(); k++) {
            for (int i = 0; i < playerArrayList.size() - 1; i++) {
                if (playerArrayList.get(i).getPrivatePoints() == playerArrayList.get(i + 1).getPrivatePoints()) {

                    if (playerArrayList.get(i).getTokensNumber() < playerArrayList.get(i + 1).getTokensNumber()) {

                        Player player = copy(playerArrayList.get(i));

                        playerArrayList.set(i, playerArrayList.get(i + 1));
                        playerArrayList.set(i + 1, player);


                    }
                }
            }

        }
        return playerArrayList;
    }

    /**
     * method that calculates the final rank sorting the list of players
     * @param playerArrayList list of players that played the game
     * @param publicObjectiveCardArrayList list of public cards delivered at the beginning of the game
     * @return list of sorted players
     */
    List<Player> calculateWinner(List<Player> playerArrayList, List<PublicObjectiveCard> publicObjectiveCardArrayList) {
        List<Player> unsortedPlayers;
        List<Player> sortedPlayers;


        unsortedPlayers = calculatePoints( playerArrayList, publicObjectiveCardArrayList );


        unsortedPlayers.sort(new PointsComparator());
        sortedPlayers = checkPoints(unsortedPlayers);


        return  sortedPlayers;
    }


    /**
     * method that calculates the total points of the private cards in the single player mode
     * @param player player that played the game
     * @param privateObjectiveCards list of private cards delivered at the beginning of the game
     * @return the total points of the private cards
     */
    private int calculatePrivateSinglePlayer(Player player, List<PrivateObjectiveCard> privateObjectiveCards) {
        int results=0;

        for (PrivateObjectiveCard privateObjectiveCard : privateObjectiveCards) {
            int result;
            result = privateObjectiveCard.runPrivate(player.getPattern());
            results = results + result;

        }
        player.setPrivatePoints(results);
        return results;

    }

    /**
     * method that calculates the total points of the public cards in the single player mode
     * @param player player that played the game
     * @param publicObjectiveCardArrayList list of public cards delivered at the beginning of the game
     * @return the total points of the public cards
     */
    private int calculatePublicSinglePlayer(Player player, List<PublicObjectiveCard> publicObjectiveCardArrayList) {
        int results=0;

        for (PublicObjectiveCard aPublicObjectiveCardArrayList : publicObjectiveCardArrayList) {
            int result;
            result = aPublicObjectiveCardArrayList.executeEffect(player.getPattern());
            results = results + result;
        }

        return results;

    }

    /**
     * method that calculates the number of empty boxes of player's pattern card multiplied by three
     * @param player player that played the game
     * @return number of empty boxes of player's pattern card multiplied by three
     */
    private int calculateEmptyBoxSinglePLayer(Player player) {
        int boxEmptyCounter=0;
        for (int i=0; i < player.getPattern().getPattern().size(); i++) {

            if (player.getPattern().getPattern().get(i).isBoxEmpty()) {
                boxEmptyCounter++;
            }
        }
        boxEmptyCounter = boxEmptyCounter * VPOINTS;

        return boxEmptyCounter;
    }

    /**
     * method that calculates the sum of the value of all dice in the round tracker
     * @param roundTracker round tracker used in the game
     * @return sum of the value of all dice in the round tracker
     */
    private int calculatePointsRoundTrackerSinglePlayer(RoundTracker roundTracker) {
        int sum;
        int finalSum=0;

        for (int i=0; i < roundTracker.getRoundTracker().size(); i++) {
            for (int j=0; j< roundTracker.getRoundDice(i).size(); j++ ) {
                sum = roundTracker.getRoundDice(i).get(j).getValue();
                finalSum = finalSum + sum;
            }
        }
        return finalSum;
    }

    /**
     * method that calculates the total points of the player and the points of round tracker
     * @param player player that played the game
     * @param publicObjectiveCardArrayList list of public cards delivered at the beginning of the game
     * @param privateObjectiveCardArrayList list of private cards delivered at the beginning of the game
     * @param roundTracker round tracker used in the game
     * @return sum of the value of all dice in the round tracker
     */
    int calculateWinnerSinglePlayer(Player player, List<PublicObjectiveCard> publicObjectiveCardArrayList, List<PrivateObjectiveCard> privateObjectiveCardArrayList, RoundTracker roundTracker){
        int i = calculateEmptyBoxSinglePLayer(player);
        int j = calculatePrivateSinglePlayer(player, privateObjectiveCardArrayList);
        int k = calculatePublicSinglePlayer(player, publicObjectiveCardArrayList);
        int roundTrackerPoints = calculatePointsRoundTrackerSinglePlayer(roundTracker);

        int totalPoints = j + k - i;
        player.setFinalPoints(totalPoints);

        return roundTrackerPoints;

    }

    /**
     * method that copies the selected player in a new player
     * @param playerToCopy selected player to copy
     * @return a new copy of the selected player
     */
    private Player copy(Player playerToCopy) {
        Player player = new Player();
        player.setPlayerName(playerToCopy.getPlayerName());
        player.setPlayerID(playerToCopy.getPlayerID());
        player.setPattern(playerToCopy.getPattern());
        player.setPrivate(playerToCopy.getPrivate());
        player.setTokensNumber(playerToCopy.getTokensNumber());
        player.setFinalPoints(playerToCopy.getFinalPoints());
        player.setPrivatePoints(playerToCopy.getPrivatePoints());
        player.setDisconnect(playerToCopy.isDisconnect());
        player.setRunningP(playerToCopy.isDisconnect());
        return player;
    }

    /**
     * Class PointsComparator: class used to compare final points of players
     * @sse java.util.Comparator<>
     */
    private class PointsComparator implements Comparator<Player> {

        /**
         * method that compare the final points of two players
         * @param o1 first player to compare
         * @param o2 second player to compare
         * @return one if the final points of the second player are greater than first player's ones
         */
        @Override
        public int compare (Player o1, Player o2) {
            return Integer.compare(o2.getFinalPoints(), o1.getFinalPoints());
        }

    }


}



