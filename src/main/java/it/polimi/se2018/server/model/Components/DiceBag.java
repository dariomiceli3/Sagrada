package it.polimi.se2018.server.model.Components;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class DiceBag: representation in the game of the Bag suited for draft the die to use in the game, it's responsible
 * for the creation of the 90 dice of the game and of their shuffle
 * @author fadda-miceli-mundo
 * @see java.io.Serializable
 */
public class DiceBag implements Serializable {

    private static final int TOP = 0;
    private static final int MAX_VALUE = 6;
    private static final int NUMBER = 90;
    private static final int DIV = 5;
    private List<Dice> listDice;


    /**
     * Class constructor, create a Dice Bag of 90 dice with random number value, 18 dice for each of the five color
     * and then shuffle them
     */
    public DiceBag(){

        this.listDice = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < (NUMBER / DIV); i++) {

            this.listDice.add(new Dice(random.nextInt(MAX_VALUE) + 1, DiceColor.YELLOW));
            this.listDice.add(new Dice(random.nextInt(MAX_VALUE) + 1, DiceColor.PURPLE));
            this.listDice.add(new Dice(random.nextInt(MAX_VALUE) + 1, DiceColor.RED));
            this.listDice.add(new Dice(random.nextInt(MAX_VALUE) + 1, DiceColor.GREEN));
            this.listDice.add(new Dice(random.nextInt(MAX_VALUE) + 1, DiceColor.BLUE));
        }
        Collections.shuffle(this.listDice);
    }

    /**
     * method that provides the caller of the all the dice contained in the Dice Bag
     * @return a list representation of the dice
     */
    public List<Dice> getListBag() {
        return listDice;
    }

    /**
     * method that provides the caller of the first dice of the bag and remove it
     * @return the die to get and remove
     */
    public Dice getDice() {
        Dice dice;
        dice = listDice.remove(TOP);
        return dice;
    }

    /**
     * method that allowed the caller to add a dice in the bag and then shuffle the dice of the bag
     * @param dice the dice to add
     */
    public void setDice(Dice dice) {
        listDice.add(dice);
        Collections.shuffle(listDice);
    }

}

