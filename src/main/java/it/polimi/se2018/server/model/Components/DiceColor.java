package it.polimi.se2018.server.model.Components;




public enum DiceColor{
    RED, YELLOW, PURPLE, GREEN, BLUE, TEST;

    @Override
    public String toString() {
        switch(this){
            case RED:
                return "red";
            case BLUE:
                return  "blue";
            case GREEN:
                return "green";
            case PURPLE:
                return "purple";
            case YELLOW:
                return "yellow";
        }
        return "";
    }


}

