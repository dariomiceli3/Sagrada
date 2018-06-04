package it.polimi.se2018.server.model.Components;

import it.polimi.se2018.exceptions.InvalidMoveException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class RoundTracker: DP Singleton, the round tracker is the table used to keep track of the current round and the die or dice not used in each round
 * @author Salvatrore Fadda
 */
public class RoundTracker implements Serializable {

    //private static RoundTracker istanceRT;
    private List<List<Dice>> listDice;



    /**
     * Private Class constructor, create the round tracker where the first dice list is set
     */
    public RoundTracker(){
        this.listDice = new ArrayList();
    }

   /* public static RoundTracker getIstanceRT(){
        if (istanceRT == null){
            istanceRT = new RoundTracker();
        }
        return istanceRT;
    }*/

    /**
     * Class SetDice: add at the round tracker the new list of dice corresponding to the list of the the round ended in the last turn
     * @param listDice dice not used in the round
     */
    public void setTracker(List<Dice> listDice){
        this.listDice.add(listDice);
    }

    /**
     * Get and remove from the round tracker the die on the specified position(from bottom to top) in the dice list belonging from the not used dice of the specified round
     * @param round the round where the die has been extracted
     * @param pos the die position in the list of dice (from bottom to top)
     * @return the die whitch has been removed
     */
    public Dice getDice(int round, int pos){

            return listDice.get(round).remove(pos);

            }

    /**
     * Add a die from the top of the list of dice not used in the specified round
     * @param dice the die to add
     * @param round the round where the die has been extracted
     * @throws InvalidMoveException if the insert in not valid
     */
    public void addDice(Dice dice, int round) throws InvalidMoveException {
        if (round < listDice.size()) {
            listDice.get(round).add(dice);
        } else throw new InvalidMoveException("Round ancora non giocato");
    }

    public List<List<Dice>> getRoundTracker(){
        return listDice;
    }

    //restituisce una copia della lista di dadi del round indicato se gia giocato----------------
    //eccezioni e controlli ancora da gestire
    public List<Dice> getRoundDice(int round){
        return listDice.get(round);
    }



    @Override
    public String toString() {

        if (listDice.size() == 1) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString();
        }
        else if (listDice.size() == 2) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString();

        }
        else if (listDice.size() == 3) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString();
        }
        else if (listDice.size() == 4) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString();
        }
        else if (listDice.size() == 5) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString() + "\n" +
                    "Round 5 " + listDice.get(4).toString();
        }
        else if (listDice.size() == 6) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString() + "\n" +
                    "Round 5 " + listDice.get(4).toString() + "\n" +
                    "Round 6 " + listDice.get(5).toString();
        }
        else if (listDice.size() == 7) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString() + "\n" +
                    "Round 5 " + listDice.get(4).toString() + "\n" +
                    "Round 6 " + listDice.get(5).toString() + "\n" +
                    "Round 7 " + listDice.get(6).toString();

        }
        else if (listDice.size() == 8) {
            return "Round Tracker : " + "\n" +
                    "Round 1 " + listDice.get(0).toString() + "\n" +
                    "Round 2 " + listDice.get(1).toString() + "\n" +
                    "Round 3 " + listDice.get(2).toString() + "\n" +
                    "Round 4 " + listDice.get(3).toString() + "\n" +
                    "Round 5 " + listDice.get(4).toString() + "\n" +
                    "Round 6 " + listDice.get(5).toString() + "\n" +
                    "Round 7 " + listDice.get(6).toString() + "\n" +
                    "Round 8 " + listDice.get(7).toString();

        }
        else if (listDice.size() == 9) {
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
        }
        else {
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
