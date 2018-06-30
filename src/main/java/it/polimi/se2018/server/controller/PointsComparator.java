package it.polimi.se2018.server.controller;

import it.polimi.se2018.server.model.Components.Player;

import java.util.Comparator;

public class PointsComparator implements Comparator<Player> {

    @Override
    public int compare (Player o1, Player o2) {
        return Integer.compare(o2.getFinalPoints(), o1.getFinalPoints());
    }

}
