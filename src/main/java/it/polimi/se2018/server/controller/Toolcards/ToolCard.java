package it.polimi.se2018.server.controller.Toolcards;

import it.polimi.se2018.server.model.Components.DiceColor;

import java.io.Serializable;

public class ToolCard implements Serializable {
    private String name;
    private DiceColor color;

    public ToolCard (String name, DiceColor color) {
        this.name = name;
        this.color = color;
    }

    public DiceColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }


}

