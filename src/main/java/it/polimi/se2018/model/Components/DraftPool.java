package it.polimi.se2018.model.Components;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class DrafPool: the pool of dice from where the players take the die to be placed on their turn
 * @author Salvatrore Fadda
 */
public class DraftPool {

    private final int DEFAULT = 0;
    private int number;
    private DiceBag diceBag;
    private ArrayList<Dice> dicePlay;

    /**
     * Default class constructor
     */
    public DraftPool(){
        this.number = DEFAULT;
        this.dicePlay = null;
        this.diceBag = null;

    }

    /**
     * Class constructor, create the draftpool of the current round taking a number (=2*number+1) of dice from the dicebag
     * @param number number of player
     * @param dicebag the dicebag from which to take the dice
     */
    public DraftPool(int number, DiceBag dicebag) {
        this.number = number;
        this.diceBag = dicebag;
        this.dicePlay = new ArrayList<>();

    }

    /**
     * Get number of dice content in the pool atm
     * @return number of dice
     */
    public int getNowNumber(){
        return dicePlay.size();
    }

    /**
     * Get a selected die from the pool and remove it from pool
     * @return the selected die
     */
    public Dice getDice() {
        return dicePlay.remove(DEFAULT);
    }

    /**
     * Set the inizial size of draftpool
     * @param number  the number of dice to rake from bag
     */
    public void setNumber(int number){
        this.number = number;
    }

    //passare una copia della lista dei dadi della pool-------------------
    public ArrayList<Dice> getDraftPool() {//clone necessaria
        return dicePlay;
    }

    /**
     * Set die in the pool
     * @param dice die to add
     */
    public void setDice(Dice dice){
        dicePlay.add(dice);
    }

    public void createListDice(){
        if(dicePlay.isEmpty()){
        this.dicePlay = new ArrayList<>();
        for(int i=0; i <= (number*2); i++) {
            this.dicePlay.add(this.diceBag.getDice());
        }
        }
    }

    /**
     Get the list of dice present in the pool and clean the pool
     @return the list of dice present in the pool atm
     */
    public ArrayList<Dice> cleanListDice() {

        ArrayList<Dice> listDice = new ArrayList<>();
        Iterator<Dice> it = dicePlay.iterator();
        while (it.hasNext()) {
            listDice.add(it.next());
            it.remove();

        }
        return listDice;
    }


}

