package it.polimi.se2018.server.model.Cards;

import it.polimi.se2018.server.model.Components.DiceColor;

import java.io.Serializable;

public class ToolCard implements Serializable {

    private String name;
    private DiceColor color;
    private int number;
    private int cost;
    private int usage;
    private static final int DEFAULT = 1;

    public ToolCard (String name, DiceColor color, int number) {
        this.name = name;
        this.color = color;
        this.number = number;
        this.cost = DEFAULT;
        this.usage = 0;
    }

    // copy constructor
    public ToolCard(ToolCard toolCard) {
        this.name = toolCard.getName();
        this.color = toolCard.getColor();
        this.number = toolCard.getNumber();
        this.cost = toolCard.getCost();
        this.usage = toolCard.getUsage();
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

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getUsage() {
        return usage;
    }

    public void incrementUsage(){
        this.usage = usage + 1;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    @Override
    public String toString(){

        if (this.number == 1) {
            return "Tool Card: " + name + "\n" +
                    "color: " + color.toString() + "\n" +
                    "cost: " + cost + "\n" +
                    "Action: " + "After drafting, increase  or decrease the value of the drafted die by 1 ";
        }

        else if (number == 2) {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "move any one die in your window ignoring the color restrictions" + "\n" +
                    "You must obey all other placement restrictions";
        }

        else if (number == 3) {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "move any one die in your window ignoring shade restriction, " + "\n" +
                    "You must obey all other placement restrictions";
        }

        else if (number == 4) {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "move exactly two dice, obeying all placement restrictions";
        }

        else if (number == 5) {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "after drafting, swap the drafted die with a die from the Round Tracker";
        }

        else if (number == 6) {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "after drafting, re-roll the drafted die." + "\n" +
                    "If it cannot be placed, return it to the Draft Pool";
        }

        else if (number == 7) {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "re-roll all dice in the Draft Pool" + "\n" +
                    "This may only be used on your second turn before drafting";
        }

        else if (number == 8) {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "after your first turn, immediately draft a die" + "\n" +
                    "Skip your next turn this round";
        }
        else if (number == 9) {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "after drafting, place the die in a spot that is not adjacent to another die." + "\n" +
                    "You must obey all other placement restrictions";
        }

        else if (number == 10) {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "after drafting, flip the die to its opposite side";
        }

        else if (number == 11) {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "after drafting, return the die to the Dice Bag and pull 1 die from the Bag." + "\n" +
                    "choose a value and place the new die, obeying all placements restrictions, or return it to the Draft Pool";
        }

        else {
            return "Tool Card: " + name + "\n" +
                    "color " + color.toString() + "\n" +
                    "cost " + cost + "\n" +
                    "Action: " + "move up to two dice of the same color that match the color of a die on the Round Track" + "\n" +
                    "You must obey all placement restrictions";
        }
    }

}

