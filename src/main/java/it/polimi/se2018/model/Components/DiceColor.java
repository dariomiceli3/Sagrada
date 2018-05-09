package it.polimi.se2018.model.Components;

import java.io.Serializable;

public enum DiceColor implements Serializable {
    RED, YELLOW, PURPLE, GREEN, BLUE;

    @Override
    public String toString() {
        switch(this){
            case RED:
                return "Red";
            case BLUE:
                return  "Blue";
            case GREEN:
                return "Green";
            case PURPLE:
                return "Purple";
            case YELLOW:
                return "Yellow";
        }
        return null;
    }


}

