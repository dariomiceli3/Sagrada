package it.polimi.se2018.controller;

import it.polimi.se2018.model.Components.Player;

import java.util.Comparator;

public class PointsComparator implements Comparator<Player> {

    @Override
    public int compare (Player o1, Player o2) {
        return o1.getFinalPoints() > o2.getFinalPoints() ? -1 :(o1.getFinalPoints() < o2.getFinalPoints() ? 1 : 0);
    }

}
