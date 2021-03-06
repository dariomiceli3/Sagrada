package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.GlassBox;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.String.*;

/**
 * Class CustomCard: this class handles to create a custom card
 * @author fadda-miceli-mundo
 */
public class CustomCard {

    /**
     * Class constructor
     */
    private CustomCard() {
        final Logger log = Logger.getLogger(CustomCard.class.getName());
        log.info("private constructor");
    }

    private static Canvas canvas;

    /**
     * method that allows to rendering a pattern card
     * @param patternCard pattern card
     * @return image of the pattern card
     */
    static Image rendering(PatternCard patternCard) {
        createCard(patternCard);
        SnapshotParameters snap = new SnapshotParameters();
        snap.setDepthBuffer(true);
        return canvas.snapshot(snap, null);
    }

    /**
     * method that allows to create a pattern card
     * @param patternCard pattern card to create
     */
    private static void createCard(PatternCard patternCard){

        canvas = new Canvas();

        // Set the width of the Canvas
        canvas.setWidth(320);

        // Set the height of the Canvas
        canvas.setHeight(257);

        // Get the graphics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //-------------Set Canvas-----------------------------

        //Vertical lines
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(0, 0, 7.5, 257, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(62.5, 0, 7.5, 257, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(125, 0, 7.5, 257, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(187.5, 0, 7.5, 257, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(250, 0, 7.5, 257, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(312.5, 0, 7.5, 257, 0, 0);

        //Horizontal lines
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(0, 0, 320, 7.5, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(0, 57.5, 320, 7.5, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(0, 115, 320, 7.5, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(0, 172.5, 320, 7.5, 0, 0);
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(0, 230, 320, 27, 0, 0);

        //Name and difficulty text
        gc.setFill(Color.WHITE);
        gc.fillText(format("%s%d", patternCard.getName(), patternCard.getDifficulty()), 100, 250);

        cardParser(patternCard, gc);

    }


    /**
     * method that allows to create dynamically a pattern card using a graphic context
     * @param patternCard pattern card to create
     * @param gc graphic context
     */
    private static void cardParser(PatternCard patternCard, GraphicsContext gc) {


        List<GlassBox> boxList = patternCard.getPattern();

        for (int i = 0; i < boxList.size(); i++) {

            if(boxList.get(i).getConstraintColor() != null){
                setFillColor(boxList.get(i).getConstraintColor(), gc);
                parserColor(i, gc);
            }
            if(boxList.get(i).getConstraintValue() != 0){
                String constraintValue = Integer.toString(boxList.get(i).getConstraintValue());
                parserNum(constraintValue, i ,gc);
            }

        }

    }

    /**
     * method that allows to display the color of one box of the pattern
     * @param i number of the cell
     * @param gc graphic context
     */
    private static void parserColor(int i, GraphicsContext gc){

        if(i == 0){
            gc.fillRoundRect(7.5, 7.5, 55, 50, 0, 0); //dado 1
        }
        if(i == 1){
            gc.fillRoundRect(70, 7.5, 55, 50, 0, 0); //dado 2
        }
        if(i == 2){
            gc.fillRoundRect(132.5, 7.5, 55, 50, 0, 0); //dado 3
        }
        if(i == 3){
            gc.fillRoundRect(195, 7.5, 55, 50, 0, 0); //dado 4
        }
        if(i == 4){
            gc.fillRoundRect(257.5, 7.5, 55, 50, 0, 0); //dado 5
        }
        if(i == 5){
            gc.fillRoundRect(7.5, 65, 55, 50, 0, 0); //dado 6
        }
        if(i == 6){
            gc.fillRoundRect(70, 65, 55, 50, 0, 0); //dado 7
        }
        if(i == 7){
            gc.fillRoundRect(132.5, 65, 55, 50, 0, 0); //dao 8
        }
        if(i == 8){
            gc.fillRoundRect(195, 65, 55, 50, 0, 0); //dado 9
        }
        if(i == 9){
            gc.fillRoundRect(257.5, 65, 55, 50, 0, 0); //dado 10
        }
        if(i == 10){
            gc.fillRoundRect(7.5, 122.5, 55, 50, 0, 0); //dado 11
        }
        if(i == 11){
            gc.fillRoundRect(70, 122.5, 55, 50, 0, 0); //dado 12
        }
        if(i == 12){
            gc.fillRoundRect(132.5, 122.5, 55, 50, 0, 0); //dado 13
        }
        if(i == 13){
            gc.fillRoundRect(195, 122.5, 55, 50, 0, 0); //dado 14
        }
        if(i == 14){
            gc.fillRoundRect(257.5, 122.5, 55, 50, 0, 0); //dado 15
        }
        if(i == 15){
            gc.fillRoundRect(7.5, 180, 55, 50, 0, 0); //dado 16
        }
        if(i == 16){
            gc.fillRoundRect(70, 180, 55, 50, 0, 0); //dado 17
        }
        if(i == 17){
            gc.fillRoundRect(132.5, 180, 55, 50, 0, 0); //dado 18
        }
        if(i == 18){
            gc.fillRoundRect(195, 180, 55, 50, 0, 0); //dado 19
        }
        if(i == 19){
            gc.fillRoundRect(257.5, 180, 55, 50, 0, 0); //dado 20
        }

    }

    /**
     * method that allows to display the number of one box of the pattern
     * @param contraintValue value to display
     * @param i number of the cell
     * @param gc graphic context
     */
    private static void parserNum(String contraintValue, int i, GraphicsContext gc){

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);

        if(i == 0){
            gc.fillText(contraintValue, 22, 47); //dado 1
        }
        if(i == 1){
            gc.fillText(contraintValue, 84.5, 47); //dado 2
        }
        if(i == 2){
            gc.fillText(contraintValue, 147, 47); //dado 3
        }
        if(i == 3){
            gc.fillText(contraintValue, 209.5, 47); //dado 4
        }
        if(i == 4){
            gc.fillText(contraintValue, 272, 47); //dado 5
        }
        if(i == 5){
            gc.fillText(contraintValue, 22, 104.5); //dado 6
        }
        if(i == 6){
            gc.fillText(contraintValue, 84.5, 104.5); //dado 7
        }
        if(i == 7){
            gc.fillText(contraintValue, 147, 104.5); //dado 8
        }
        if(i == 8){
            gc.fillText(contraintValue, 209.5, 104.5); //dado 9
        }
        if(i == 9){
            gc.fillText(contraintValue, 272, 104.5); //dado 10
        }
        if(i == 10){
            gc.fillText(contraintValue, 22, 162); //dado 11
        }
        if(i == 11){
            gc.fillText(contraintValue, 84.5, 162); //dado 12
        }
        if(i == 12){
            gc.fillText(contraintValue, 147, 162); //dado 13
        }
        if(i == 13){
            gc.fillText(contraintValue, 209.5, 162); //dado 14
        }
        if(i == 14){
            gc.fillText(contraintValue, 272, 162); //dado 15
        }
        if(i == 15){
            gc.fillText(contraintValue, 22, 219.5); //dado 16
        }
        if(i == 16){
            gc.fillText(contraintValue, 84.5, 219.5); //dado 17
        }
        if(i == 17){
            gc.fillText(contraintValue, 147, 219.5); //dado 18
        }
        if(i == 18){
            gc.fillText(contraintValue, 209.5, 219.5); //dado 19
        }
        if(i == 19){
            gc.fillText(contraintValue, 272, 219.5); //dado 20
        }
    }

    /**
     * method that allows to fill the boxes of the pattern card
     * @param string color of the box
     * @param gc graphic context
     */
    private static void setFillColor(String string, GraphicsContext gc){

        if(string.equalsIgnoreCase("yellow")){
            gc.setFill(Color.YELLOW);

        }
        if(string.equalsIgnoreCase("red")){
            gc.setFill(Color.DARKRED);

        }
        if(string.equalsIgnoreCase("green")){
            gc.setFill(Color.DARKGREEN);

        }
        if(string.equalsIgnoreCase("purple")){
            gc.setFill(Color.PURPLE);

        }
        if(string.equalsIgnoreCase("blue")){
            gc.setFill(Color.DARKBLUE);

        }

    }

}
