package it.polimi.se2018.TestController.TestToolCard;

import it.polimi.se2018.server.controller.GameSetup;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Components.DiceColor;
import org.junit.Test;

import javax.tools.Tool;
import java.util.ArrayList;
import java.util.List;

public class TestToolCard {

    @Test
    public void testToString(){

        List<ToolCard> list = new ArrayList<>();

        list.add(new ToolCard("Grozing Pliers", DiceColor.PURPLE, 1));
        list.add(new ToolCard("Eglomise Brush", DiceColor.BLUE, 2));
        list.add(new ToolCard("Copper Foil Burnisher", DiceColor.RED, 3));
        list.add(new ToolCard("Lathekin", DiceColor.YELLOW, 4));
        list.add(new ToolCard("Lens Cutter", DiceColor.GREEN, 4));
        list.add(new ToolCard("Flux Brush", DiceColor.PURPLE, 6));
        list.add(new ToolCard("Glazing Hammer", DiceColor.BLUE, 7));
        list.add(new ToolCard("Running Pliers", DiceColor.RED, 8));
        list.add(new ToolCard("Cork-backed Straightedge", DiceColor.YELLOW, 9));
        list.add(new ToolCard("Grinding Stone", DiceColor.GREEN, 10));
        list.add(new ToolCard("Flux Remover", DiceColor.PURPLE, 11));
        list.add(new ToolCard("Tap Wheel", DiceColor.BLUE, 12));

        for (ToolCard toolCard :list) {
            System.out.println(toolCard.toString());
        }

    }
}
