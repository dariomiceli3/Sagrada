package it.polimi.se2018.server.model.Components;

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
    public Dice (int value, DiceColor color) {
        this.color = color;
        this.value = value;
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


    @Override
    public String toString() {
        return "Dice value: " + this.value + " color: " + this.color.toString() + "\n";
    }

}
