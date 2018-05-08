package it.polimi.se2018.model.Components;

public class GlassCoord {
    private final int coordX;
    private final int coordY;


    public GlassCoord(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }
}