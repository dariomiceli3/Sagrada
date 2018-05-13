package it.polimi.se2018.model.Components;

import it.polimi.se2018.Exceptions.InvalidMoveException;

import java.util.ArrayList;
/**
 * Class RoundTracker: the round tracker is the table used to keep track of the current round and the die or dice not used in each round
 * @author Salvatrore Fadda
 */
public class RoundTracker {

    private final int IN = 0;
    private final int ROUND = 10;
    private ArrayList<ArrayList<Dice>> listDice;
    private Dice dice;

    /**
     * Default class constructor
     */
    public RoundTracker(){
        this.listDice = null;
        this.dice = null;
    }

    /**
     * Class constructor, create the round tracker where the first dice list is set
     * @param listDice dice not used in the first round
     */
    public RoundTracker(ArrayList<Dice> listDice){
        this.listDice = new ArrayList();
        this.listDice.add(listDice);
    }

    /**
     * Class SetDice: add at the round tracker the new list of dice corresponding to the list of the the round ended in the last turn
     * @param listDice dice not used in the round
     */
    public void setTracker(ArrayList<Dice> listDice){
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
     */
    public void addDice(Dice dice, int round) throws InvalidMoveException {
        if (round < listDice.size()) {
            listDice.get(round).add(dice);
        } else throw new InvalidMoveException("Round ancora non giocato");
    }

    public ArrayList<ArrayList<Dice>> getRoundTracker(){
        return listDice;
    }

    //restituisce una copia della lista di dadi del round indicato se gia giocato----------------
    //eccezioni e controlli ancora da gestire
    public ArrayList<Dice> getRoundDice(int round){
        return listDice.get(round);
    }





}
