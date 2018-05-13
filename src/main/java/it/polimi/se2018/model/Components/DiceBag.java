package it.polimi.se2018.model.Components;




import it.polimi.se2018.Exceptions.NotValidBagException;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class DiceBag: the bag used for dice extraction
 * @author Salvatrore Fadda
 */
public class DiceBag {
    private final int TOP = 0;
    private final int MAX_VALUE = 6;
    private final int NUMBER = 90;
    private Dice dice;
    private ArrayList<Dice> listDice;
    private int value;
    private DiceColor colour;
//gestione eccezioni da dichiarare e controlli da fare

    /**
     * DiceBag constructor, create a bag of 90 dice with random face number, 18 dice for each colour
     */
    public DiceBag() throws NotValidBagException {
        this.listDice = new ArrayList<Dice>();

        //creazione dadi casuali, 18 per ogni colore
        Random random = new Random();
        for (int i = 0; i < (NUMBER / 5); i++) {

            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColor.YELLOW));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColor.PURPLE));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColor.RED));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColor.GREEN));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColor.BLUE));
        }

        //controllo numero elementi
        if (listDice.size() != NUMBER) throw new NotValidBagException("It's not a complete bag");

        //mischio la Bag
        Collections.shuffle(this.listDice);


    }

    //ritorna la copia dell'arraylist associatio alla Bag------------
    public ArrayList<Dice> getListBag() {

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

}

