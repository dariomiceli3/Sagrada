package it.polimi.se2018.server.model.Components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class DrafPool: DP Singleton, the pool of dice from where the players take the die to be placed on their turn
 * @author Salvatrore Fadda
 */
public class DraftPool implements Serializable {

    //private static DraftPool istanceDP;
    private static final int DEFAULT = 0;
    private int number;
    private DiceBag diceBag;
    private List<Dice> dicePlay;

    /**
     * Private Default class constructor
     */
    public DraftPool(){
        this.number = DEFAULT;
        this.dicePlay = null;
        this.diceBag = null;

    }

    /*public static DraftPool getIstanceDP(){
        if (istanceDP == null){
            istanceDP = new DraftPool();
        }
        return istanceDP;

    }*/

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
     * Class constructor, create the draftpool of the current round taking a number (=2*number+1) of dice from the dicebag
     * @param dicebag the dicebag from which to take the dice
     */
    public DraftPool(DiceBag dicebag) {
        this.diceBag = dicebag;
        this.dicePlay = new ArrayList<>();

    }
    /*public static DraftPool getIstanceDPWithParam(int number, DiceBag diceBag){
        if (istanceDP == null){
            istanceDP = new DraftPool(number, diceBag);
        }
        return istanceDP;

    }*/


    /**
     * Get number of dice content in the pool atm
     * @return number of dice
     */
    public int getNowNumber(){
        if (dicePlay == null) {
            return DEFAULT;
        }
        else return dicePlay.size();
    }

    /**
     * Get a selected die from the pool and remove it from pool
     * @return the selected die
     */
    public Dice removeDice(int a) {
        return dicePlay.remove(a);
    }

    /**
     * Set the inizial size of draftpool
     * @param number  the number of dice to rake from bag
     */
    public void setNumber(int number){
        this.number = number;
    }

    //passare una copia della lista dei dadi della pool-------------------
    public List<Dice> getDraftPool() {//clone necessaria
        return dicePlay;
    }

    public void setDraftPool(List<Dice> diceList){
        if(dicePlay.isEmpty()){
            this.dicePlay = diceList;
        }

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
        for(int i= DEFAULT; i <= (number); i++) {
            this.dicePlay.add(this.diceBag.getDice());
        }
        }
    }

    /**
     Get the list of dice present in the pool and clean the pool
     @return the list of dice present in the pool atm
     */
    public List<Dice> cleanListDice() {

        List<Dice> listDice = new ArrayList<>();
        Iterator<Dice> it = dicePlay.iterator();
        while (it.hasNext()) {
            listDice.add(it.next());
            it.remove();

        }
        return listDice;
    }

    @Override
    public String toString() {
        return "Draft Pool: " + dicePlay.toString();
    }

}
