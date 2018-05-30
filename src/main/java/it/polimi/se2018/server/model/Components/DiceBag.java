package it.polimi.se2018.server.model.Components;




import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class DiceBag:DP Singleton, the bag used for dice extraction
 * @author Salvatrore Fadda
 */
public class DiceBag {
    //private static DiceBag istanceDB;
    private static final int TOP = 0;
    private static final int MAX_VALUE = 6;
    private static final int NUMBER = 90;
    private static final int DIV = 5;
    private Dice dice;
    private List<Dice> listDice;
    private int value;
    private DiceColor colour;
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
        this.listDice = new ArrayList<Dice>();

        //creazione dadi casuali, 18 per ogni colore
        Random random = new Random();
        for (int i = 0; i < (NUMBER / DIV); i++) {

            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColor.YELLOW));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColor.PURPLE));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColor.RED));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColor.GREEN));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColor.BLUE));
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

    @Override
    public String toString() {
        System.out.println("DiceBag");
        System.out.println("Size: " + getListBag().size());
        return "";
    }
    public static void main(String args[])  {
        DiceBag diceBag = new DiceBag();
        diceBag.toString();
        diceBag.getDice();
        diceBag.toString();
    }
}

