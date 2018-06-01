package it.polimi.se2018.server.model.Components;

import java.io.Serializable;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.*;
import org.fusesource.jansi.Ansi.Color.*;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Class Dice: the die
 * @author Salvatrore Fadda
 */
public class Dice implements Serializable {

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

        if (this.getColor().toString() == "red") {

            if (this.getValue() == 1) {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a("\u2680").reset());
            }
            else if (this.getValue() == 2) {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a("\u2681").reset());
            }
            else if (this.getValue() == 3) {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a("\u2682").reset());
            }
            else if (this.getValue() == 4) {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a("\u2683").reset());
            }
            else if (this.getValue() == 5) {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a("\u2684").reset());
            }
            else {
                return String.valueOf(ansi().eraseScreen().fg(Color.RED).a("\u2685").reset());
            }
        }

        else if (this.getColor().toString() == "yellow") {

            if (this.getValue() == 1) {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a("\u2680").reset());
            }
            else if (this.getValue() == 2) {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a("\u2681").reset());
            }
            else if (this.getValue() == 3) {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a("\u2682").reset());
            }
            else if (this.getValue() == 4) {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a("\u2683").reset());
            }
            else if (this.getValue() == 5) {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a("\u2684").reset());
            }
            else {
                return String.valueOf(ansi().eraseScreen().fg(Color.YELLOW).a("\u2685").reset());
            }
        }

        else if (this.getColor().toString() == "blue") {

            if (this.getValue() == 1) {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a("\u2680").reset());
            }
            else if (this.getValue() == 2) {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a("\u2681").reset());
            }
            else if (this.getValue() == 3) {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a("\u2682").reset());
            }
            else if (this.getValue() == 4) {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a("\u2683").reset());
            }
            else if (this.getValue() == 5) {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a("\u2684").reset());
            }
            else {
                return String.valueOf(ansi().eraseScreen().fg(Color.BLUE).a("\u2685").reset());
            }
        }

        else if (this.getColor().toString() == "green") {

            if (this.getValue() == 1) {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a("\u2680").reset());
            }
            else if (this.getValue() == 2) {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a("\u2681").reset());
            }
            else if (this.getValue() == 3) {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a("\u2682").reset());
            }
            else if (this.getValue() == 4) {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a("\u2683").reset());
            }
            else if (this.getValue() == 5) {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a("\u2684").reset());
            }
            else {
                return String.valueOf(ansi().eraseScreen().fg(Color.GREEN).a("\u2685").reset());
            }
        }

        else

            if (this.getValue() == 1) {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a("\u2680").reset());
            }
            else if (this.getValue() == 2) {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a("\u2681").reset());
            }
            else if (this.getValue() == 3) {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a("\u2682").reset());
            }
            else if (this.getValue() == 4) {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a("\u2683").reset());
            }
            else if (this.getValue() == 5) {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a("\u2684").reset());
            }
            else {
                return String.valueOf(ansi().eraseScreen().fg(Color.MAGENTA).a("\u2685").reset());
            }
        }





    }


