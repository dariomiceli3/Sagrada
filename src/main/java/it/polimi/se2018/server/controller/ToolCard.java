package it.polimi.se2018.server.controller;

import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Components.DiceColor;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class ToolCard implements Serializable{
    private String name;
    private DiceColor color;
    private int number;


    protected ToolCard (String name, DiceColor color, int number) {
        this.name = name;
        this.color = color;
        this.number = number;
    }

    public DiceColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public String toString(){
        return name;
    }



}

