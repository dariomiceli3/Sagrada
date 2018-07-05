package it.polimi.se2018.server.model.Components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class DraftPool: representation in the game of the Draft Pool,contains the dice used by the players in the game, it
 * is responsible for the creation and the clean of the pool in every round, it's associated with the Dice Bag,
 * from where the pool draft the die
 * @author fadda-miceli-mundo
 * @see java.io.Serializable
 */
public class DraftPool implements Serializable {

    private static final int DEFAULT = 0;
    private int number;
    private DiceBag diceBag;
    private List<Dice> dicePlay;


    /**
     * Class default constructor re-definition
     */
    public DraftPool(){
        this.number = DEFAULT;
        this.dicePlay = null;
        this.diceBag = null;
    }

    /**
     * Class constructor, create the Draft Pool of the current round associated with Dice Bag and the
     * current number of players
     * @param number number of player
     * @param diceBag the Dice bag where draft the dice
     */
    public DraftPool(int number, DiceBag diceBag) {
        this.number = number;
        this.diceBag = diceBag;
        this.dicePlay = new ArrayList<>();
    }

    /**
     * Class constructor, create the Draft Pool of the current round and associate it to the Dice Bag
     * @param diceBag the Dice Bag where draft the dice
     */
    public DraftPool(DiceBag diceBag) {
        this.diceBag = diceBag;
        this.dicePlay = new ArrayList<>();
    }

    /**
     * Class copy constructor, create a new Draft Pool from an old Draft Pool,useful to create a safe copy
     * @param draftPool the pool to copy
     */
    public DraftPool(DraftPool draftPool) {
        this.number = draftPool.getNowNumber();
        this.diceBag = draftPool.getDiceBag();
        this.dicePlay = draftPool.getDraftPool();
    }

    /**
     * private method that provides the caller of the Bag associated with the Draft Pool
     * @return the Dice Bag associated
     */
    public DiceBag getDiceBag() {
        return diceBag;
    }

    /**
     * method that provides the caller of the current number of dice available in the Draft Pool
     * @return the number of dice
     */
    public int getNowNumber(){
        if (dicePlay == null) {
            return DEFAULT;
        }
        else return dicePlay.size();
    }

    /**
     * method that provides the caller with the current dice available in the Draft Pool
     * @return a list of the Dice contained in the Draft Pool
     */
    public List<Dice> getDraftPool() {
        return dicePlay;
    }


    /**
     * method that allow the caller to set the number of the dice in the Draft Pool to draft from the Bag
     * @param number the number of dice to take from bag
     */
    public void setNumber(int number){
        this.number = number;
    }

    /**
     * method that allow the caller to fill an empty Draft Pool with a list of dice
     * @param diceList list of the dice to set
     */
    public void setDraftPool(List<Dice> diceList){
        if(dicePlay.isEmpty()){
            this.dicePlay = diceList;
        }
    }

    /**
     * method that allow the caller to add a dice to the tail of the Draft Pool
     * @param dice die to add
     */
    public void setDice(Dice dice){
        dicePlay.add(dice);
    }

    /**
     * method that allow the caller to remove a dice from the Draft Pool and the calling to return
     * the dice removed from the Draft Pool
     * @param index the index of the dice in the list
     * @return the selected die
     */
    public Dice removeDice(int index) {
        return dicePlay.remove(index);
    }

    /**
     * method that create the ArrayList implementation of the dice contained in the Draft Pool, drafting
     * them directly from the Dice Bag
     */
    public void createListDice(){
        if(dicePlay.isEmpty()){
        this.dicePlay = new ArrayList<>();
        for(int i= DEFAULT; i <= (number); i++) {
            this.dicePlay.add(this.diceBag.getDice());
        }
        }
    }

    /**
     * method that remove the current dice contained in the pool and return it to the caller
     * @return the list of dice removed
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

    /**
     * Override of the Object toString method to provide the caller of a String version of a Draft Pool
     * @return string format of a draft pool
     */
    @Override
    public String toString() {
        return "Draft Pool: " + dicePlay.toString();
    }

}
