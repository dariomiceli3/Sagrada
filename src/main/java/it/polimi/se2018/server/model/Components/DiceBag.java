package it.polimi.se2018.server.model.Components;




import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class DiceBag:DP Singleton, the bag used for dice extraction
 * @author Salvatrore Fadda
 */
public class DiceBag implements Serializable {
    //private static DiceBag istanceDB;
    private static final int TOP = 0;
    private static final int MAX_VALUE = 6;
    private static final int NUMBER = 90;
    private static final int DIV = 5;
    private List<Dice> listDice;
//TODO gestione eccezioni da dichiarare e controlli da fare


    /*public static DiceBag getIstanceDB(){
        if (istanceDB == null){
            istanceDB = new DiceBag();
        }
        return istanceDB;
    }*/

    /**
     * Private DiceBag constructor, create a bag of 90 dice with random face number, 18 dice for each colour
     */
    public  DiceBag(){
        this.listDice = new ArrayList<>();

        //creazione dadi casuali, 18 per ogni colore
        Random random = new Random();
        for (int i = 0; i < (NUMBER / DIV); i++) {

            this.listDice.add(new Dice(random.nextInt(MAX_VALUE) + 1, DiceColor.YELLOW));
            this.listDice.add(new Dice(random.nextInt(MAX_VALUE) + 1, DiceColor.PURPLE));
            this.listDice.add(new Dice(random.nextInt(MAX_VALUE) + 1, DiceColor.RED));
            this.listDice.add(new Dice(random.nextInt(MAX_VALUE) + 1, DiceColor.GREEN));
            this.listDice.add(new Dice(random.nextInt(MAX_VALUE) + 1, DiceColor.BLUE));
        }

        //mischio la Bag
        Collections.shuffle(this.listDice);


    }

    //ritorna la copia dell'arraylist associata alla Bag------------
    public List<Dice> getListBag() {

        return listDice;
    }

    /**
     * Get the first die of the bag and remove it from the bag.
     * @return the die to get and remove
     */
    public Dice getDice() {
        Dice dice;
        dice = listDice.remove(TOP);
        return dice;
    }

    /**
     * Add an existing die from the bag and mixes it
     * @param dice the die to add
     */
    public void setDice(Dice dice) {
        listDice.add(dice);
        Collections.shuffle(listDice);
    }

}

