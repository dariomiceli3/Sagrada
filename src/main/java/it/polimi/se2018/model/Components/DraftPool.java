package it.polimi.se2018.model.Components;

import it.polimi.se2018.Exceptions.UncleanedPoolException;

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
     * @param number number of players in the match
     * @param dicebag the dicebag from whitch to take the dice
     */
    public DraftPool(int number, DiceBag dicebag) {
        this.number = number;
        this.diceBag = dicebag;
        this.dicePlay = new ArrayList<>();
        for(int i=0; i <= (2*number); i++) {
            this.dicePlay.add(this.diceBag.getDice());
        }
        if (dicePlay.size() != (2*number));

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

    /**
     Get the list of dice present in the pool and clean the pool
     @return the list of dice present in the pool atm
     */
    public ArrayList<Dice> cleanListDice() throws UncleanedPoolException {

        ArrayList<Dice> listDice = new ArrayList<>();
        Iterator<Dice> it = dicePlay.iterator();
        while (it.hasNext()) {
                listDice.add(it.next());
                it.remove();

            }
            if (dicePlay.size() != DEFAULT) throw new UncleanedPoolException("Errore Draft Pool non pulita");
        return listDice;
    }


}