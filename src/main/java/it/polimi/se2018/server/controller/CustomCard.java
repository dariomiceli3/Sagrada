package it.polimi.se2018.server.controller;

import it.polimi.se2018.server.model.Cards.PatternCard;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static java.lang.String.*;

public class CustomCard {


    public void createCard(PatternCard patternCard){

        Stage canvasWindow = new Stage();

        Canvas canvas = new Canvas();

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

        //Close Button
        Button button = new Button("Close");
        button.setLayoutX(137);
        button.setLayoutY(280);
        button.setPrefSize(70, 20);

        AnchorPane root = new AnchorPane();


        // Set the Style-properties of the Pane
        root.setStyle(
                "-fx-background-color: #D3D3D3;"
        );

        // Add the Canvas to the Pane
        root.getChildren().add(canvas);
        root.getChildren().add(button);

        Scene scene = new Scene(root);
        canvasWindow.setResizable(false);
        canvasWindow.setScene(scene);
        canvasWindow.show();



    }

    private void cardParser(PatternCard patternCard, GraphicsContext gc){

        //Colour constraint

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(7.5, 7.5, 55, 50, 0, 0); //dado 1

        gc.setFill(Color.DARKBLUE);
        gc.fillRoundRect(70, 7.5, 55, 50, 0, 0); //dado 2

        gc.setFill(Color.DARKGREEN);
        gc.fillRoundRect(132.5, 7.5, 55, 50, 0, 0); //dado 3

        gc.setFill(Color.PURPLE);
        gc.fillRoundRect(195, 7.5, 55, 50, 0, 0); //dado 4

        gc.setFill(Color.YELLOW);
        gc.fillRoundRect(257.5, 7.5, 55, 50, 0, 0); //dado 5

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(7.5, 65, 55, 50, 0, 0); //dado 6

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(70, 65, 55, 50, 0, 0); //dado 7

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(132.5, 65, 55, 50, 0, 0); //dao 8

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(195, 65, 55, 50, 0, 0); //dado 9

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(257.5, 65, 55, 50, 0, 0); //dado 10

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(7.5, 122.5, 55, 50, 0, 0); //dado 11

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(70, 122.5, 55, 50, 0, 0); //dado 12

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(132.5, 122.5, 55, 50, 0, 0); //dado 13

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(195, 122.5, 55, 50, 0, 0); //dado 14

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(257.5, 122.5, 55, 50, 0, 0); //dado 15

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(7.5, 180, 55, 50, 0, 0); //dado 16

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(70, 180, 55, 50, 0, 0); //dado 17

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(132.5, 180, 55, 50, 0, 0); //dado 18

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(195, 180, 55, 50, 0, 0); //dado 19

        gc.setFill(Color.DARKRED);
        gc.fillRoundRect(257.5, 180, 55, 50, 0, 0); //dado 20



        //Text constraint
        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "1", 22, 47); //dado 1

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "2", 84.5, 47); //dado 2

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "3", 147, 47); //dado 3

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "4", 209.5, 47); //dado 4

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "5", 272, 47); //dado 5

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "6", 22, 104.5); //dado 6

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "1", 84.5, 104.5); //dado 7

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "2", 147, 104.5); //dado 8

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "3", 209.5, 104.5); //dado 9

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "4", 272, 104.5); //dado 10

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "1", 22, 162); //dado 11

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "2", 84.5, 162); //dado 12

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "3", 147, 162); //dado 13

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "4", 209.5, 162); //dado 14

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "5", 272, 162); //dado 15

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "6", 22, 219.5); //dado 16

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "1", 84.5, 219.5); //dado 17

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "2", 147, 219.5); //dado 18

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "3", 209.5, 219.5); //dado 19

        gc.setFont(Font.font("Arial", 50));
        gc.setFill(Color.BLACK);
        gc.fillText( "4", 272, 219.5); //dado 20

    }





}
