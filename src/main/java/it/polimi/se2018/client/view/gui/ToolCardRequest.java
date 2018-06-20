package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Events.SinglePlayer.ToolNumberEvent;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ToolCardRequest {

    private static int toolNumber;


    public static void setToolNumber(int n){
        ToolCardRequest.toolNumber = n;
    }

    private static DiceColor color;


    public static void setColor(DiceColor color) {
        ToolCardRequest.color = color;
    }

    private static BoardController board;


    public static void setBoard(BoardController board){
        ToolCardRequest.board = board;
    }



    @FXML
    private TextArea text;

    @FXML
    private Button select;

    @FXML
    private ToggleButton tool11Button1;

    @FXML
    private ToggleGroup tool11Group;

    @FXML
    private ToggleButton tool11Button2;

    @FXML
    private ToggleButton tool11Button3;

    @FXML
    private ToggleButton tool11Button4;

    @FXML
    private ToggleButton tool11Button5;

    @FXML
    private ToggleButton tool11Button6;

    @FXML
    private ToggleButton tool1ButtonPlus;

    @FXML
    private ToggleGroup tool1Group;

    @FXML
    private ToggleButton tool1ButtonMin;

    @FXML
    private ToggleButton tool12Button2;

    @FXML
    private ToggleGroup tool12Group;

    @FXML
    private ToggleButton tool12Button1;

    @FXML
    void buttonSelected(ActionEvent event) {

    }

    @FXML
    void handleTool1(ActionEvent event) {

    }

    @FXML
    void handleTool11(ActionEvent event) {

    }

    @FXML
    void handleTool12(ActionEvent event) {

    }

    public void initialize(){

        if(toolNumber == 1){

            text.setText("Click Plus to increase, Minus to decrease, then SELECT");

            select.disableProperty().bind(Bindings.isNull(tool1Group.selectedToggleProperty()));

            tool1ButtonMin.setVisible(true);
            tool1ButtonPlus.setVisible(true);
        }
        if(toolNumber == 11){

            text.setText("Color of the dice is: " + color + ". Click the value for the selected dice, then SELECT");

            select.disableProperty().bind(Bindings.isNull(tool11Group.selectedToggleProperty()));

            tool11Button1.setVisible(true);
            tool11Button2.setVisible(true);
            tool11Button3.setVisible(true);
            tool11Button4.setVisible(true);
            tool11Button5.setVisible(true);
            tool11Button6.setVisible(true);

        }
        if(toolNumber == 12){

            text.setText("Click how many dice you want to move, then SELECT");

            select.disableProperty().bind(Bindings.isNull(tool12Group.selectedToggleProperty()));

            tool12Button1.setVisible(true);
            tool12Button2.setVisible(true);

        }

    }

    public static void display()  throws IOException {

        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(RoundTrackerBox.class.getResource("/ToolExtraRequest.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.setResizable(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                window.showAndWait();
            }
        });
    }
}
