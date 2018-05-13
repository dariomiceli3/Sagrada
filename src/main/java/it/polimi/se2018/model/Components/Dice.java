package it.polimi.se2018.model.Components;

import it.polimi.se2018.Exceptions.NotValidDiceValueException;

/**
 * Class Dice: the die
 * @author Salvatrore Fadda
 */
public class Dice {

    private final int DEFAULT = 0;
    private int value;
    private DiceColor color;

    /**
     * Default class constructor
     */
    public Dice() {
        this.value = DEFAULT;
        this.color = null;
    }

    /**
     * Class constructor, create a die with face number and colour specified
     * @param value die face number
     * @param color die colour
     */
    public Dice (int value, DiceColor color) throws NotValidDiceValueException {
        if (value > 0 && value < 7){
        this.value = value;
        }
        else new NotValidDiceValueException("Creazione del dado non possibile per via del valore assegnato");
        this.color = color;
    }

    /**
     * Get die colour
     * @return die colour
     */
    public DiceColor getColor ()
    {
        return color;
    }

    /**
     * Get die face number
     * @return die face number
     */
    public int getValue ()
    {
        return value;
    }

    /**
     * Set die face number
     * @param value die face number
     */
    public void setValue(int value)
    {
        this.value = value;
    }

    /**
     * Set die colour
     * @param color  die colour
     */
    public void setColor(DiceColor color)
    {
        this.color = color;
    }

}
