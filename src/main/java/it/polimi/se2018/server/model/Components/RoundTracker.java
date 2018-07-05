package it.polimi.se2018.server.model.Components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class RoundTracker: represents the Round Tracker of the game, it contains the various list of the different dice remained
 * in the draft pool at the end of every round.
 * @author fadda-miceli-mundo
 */
public class RoundTracker implements Serializable {

    private List<List<Dice>> listDice;

    /**
     * Class default constructor, create the round tracker list dice
     */
    public RoundTracker(){
        this.listDice = new ArrayList<>();
    }

    /**
     * Class copy constructor, create a new Round Tracker from an old Round Tracker,useful to create a safe copy
     * @param roundTracker the round tracker to copy
     */
    public RoundTracker(RoundTracker roundTracker) {
        this.listDice = roundTracker.listDice;
    }

    /**
     * method that provide the caller of a dice from the round tracker at a specified position of a specific round
     * @param round the round where the dice will be extracted
     * @param pos the die position in the list of dice
     * @return the die that has been removed
     */
    public Dice getDice(int round, int pos){
        return listDice.get(round).remove(pos);
    }

    /**
     * method that provide the caller of a list of the size of the different rounds of the game
     * @return a list of the size of the rounds
     */
    public List<Integer> getRoundsSizes(){
       List<Integer> listSizes = new ArrayList<>();
       for(int i = 0; i < this.getRoundTracker().size(); i++) {
           listSizes.add(this.getRoundDice(i).size());

       }
       return listSizes;
    }

    /**
     * method that provide the caller the current state of the Round Tracker
     * @return a list of a list of dice in the round tracker
     */
    public List<List<Dice>> getRoundTracker(){
        return listDice;
    }

    /**
     * method that provide the caller the list of the dice of a specified round as parameter
     * @param round of the list
     * @return the list of the dice
     */
    public List<Dice> getRoundDice(int round){
        return listDice.get(round);
    }

    /**
     * method that allow the caller to set a list of dice in the round tracker
     * @param listDice to set
     */
    public void setTracker(List<Dice> listDice){
        this.listDice.add(listDice);
    }


    /**
     * method that allow the caller to add a dice at the tail of the list of a specified round list
     * @param dice the die to add
     * @param round the round where the die has been extracted
     */
    public void addDice(Dice dice, int round) {
        listDice.get(round).add(dice);
    }


    /**
     * Override of the Object toString method to provide the caller of a String version of a Round Tracker
     * @return string format of a player
     */
    @Override
    public String toString() {

        if (listDice.isEmpty()) {
            return "Round Tracker not generated";
        } else if (listDice.size() == 1) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString();
        } else if (listDice.size() == 2) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString();

        } else if (listDice.size() == 3) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString();
        } else if (listDice.size() == 4) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString();
        } else if (listDice.size() == 5) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString() + "\n" +
                    "Round 5 " + listDice.get(4).toString();
        } else if (listDice.size() == 6) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString() + "\n" +
                    "Round 5 " + listDice.get(4).toString() + "\n" +
                    "Round 6 " + listDice.get(5).toString();
        } else if (listDice.size() == 7) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString() + "\n" +
                    "Round 5 " + listDice.get(4).toString() + "\n" +
                    "Round 6 " + listDice.get(5).toString() + "\n" +
                    "Round 7 " + listDice.get(6).toString();

        } else if (listDice.size() == 8) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString() + "\n" +
                    "Round 5 " + listDice.get(4).toString() + "\n" +
                    "Round 6 " + listDice.get(5).toString() + "\n" +
                    "Round 7 " + listDice.get(6).toString() + "\n" +
                    "Round 8 " + listDice.get(7).toString();

        } else if (listDice.size() == 9) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString() + "\n" +
                    "Round 5 " + listDice.get(4).toString() + "\n" +
                    "Round 6 " + listDice.get(5).toString() + "\n" +
                    "Round 7 " + listDice.get(6).toString() + "\n" +
                    "Round 8 " + listDice.get(7).toString() + "\n" +
                    "Round 9 " + listDice.get(8).toString();
        } else {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString() + "\n" +
                    "Round 5 " + listDice.get(4).toString() + "\n" +
                    "Round 6 " + listDice.get(5).toString() + "\n" +
                    "Round 7 " + listDice.get(6).toString() + "\n" +
                    "Round 8 " + listDice.get(7).toString() + "\n" +
                    "Round 9 " + listDice.get(8).toString() + "\n" +
                    "Round 10 " + listDice.get(9).toString();
        }
    }
}
