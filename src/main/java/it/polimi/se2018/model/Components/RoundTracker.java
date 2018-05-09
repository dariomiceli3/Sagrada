package it.polimi.se2018.model.Components;



import java.util.ArrayList;
/**
 * Class RoundTracker: the round tracker is the table used to keep track of the current round and the die or dice not used in each round
 * @author Salvatrore Fadda
 */
public class RoundTracker {

    private final int IN = 0;
    private final int ROUND = 10;
    private ArrayList<Dice> listDice[];
    private Dice dice;

    /**
     * Default class constructor
     */
    public RoundTracker(){
        this.listDice = null;
        this.dice = null;
    }

    /**
     * Class constructor, create the round tracker whith 10 round signals where every round signals have its list of dice, only the first dice list is set
     * @param listDice dice not used in the first round
     */
    public RoundTracker(ArrayList<Dice> listDice){
        this.listDice = new ArrayList[ROUND];
        this.listDice[IN] = listDice;
    }

    /**
     * Class constructor
     * @param round the round where the die has been extracted
     * @param listDice dice not used in the specified round
     */
    public void setTracker(int round, ArrayList<Dice> listDice){
        this.listDice[round] = listDice;
    }

    /**
     * Get and remove from the round tracker the die on the specified position(from bottom to top) in the dice list belonging from the not used dice of the specified round
     * @param round the round where the die has been extracted
     * @param pos the die position in the list of dice (from bottom to top)
     * @return the die whitch has been removed
     */
    public Dice getDice(int round, int pos){

        return listDice[round].remove(pos);

    }

    /**
     * Add a die from the top of the list of dice not used in the specified round
     * @param dice the die to add
     * @param round the round where the die has been extracted
     */
    public void addDice(Dice dice, int round){

        listDice[round].add(dice);
    }

    //restituisce una copia della lista di dadi del round indicato se gia giocato----------------
    //eccezioni e controlli ancora da gestire
    public ArrayList<Dice> getRoundDice(int round){
        return listDice[round];
    }





}




