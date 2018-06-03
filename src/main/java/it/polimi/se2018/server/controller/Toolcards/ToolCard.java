package it.polimi.se2018.server.controller.Toolcards;

import it.polimi.se2018.server.model.Components.DiceColor;

public class ToolCard {
    private String name;
    private DiceColor color;

    public ToolCard (String name, DiceColor color) {
        this.name = name;
        this.color = color;
    }

    public DiceColor getCOLOR() {
        return color;
    }



}

