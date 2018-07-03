package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Components.DiceColor;
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

    private static Stage window;

    private int tool1;

    private int tool11;

    private int tool12;


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

        if(toolNumber == 1){
            board.setIncrease(tool1);
        }
        if(toolNumber == 11){
            board.setDiceValue(tool11);
        }
        if(toolNumber == 12){
            board.setNumberDice(tool12);
        }
        window.close();
    }

    @FXML
    void handleTool1(ActionEvent event) {

        try {
            if (tool1Group.getSelectedToggle().equals(tool1ButtonMin)) {
                tool1 = 0;
            }
            if (tool1Group.getSelectedToggle().equals(tool1ButtonPlus)) {

                tool1 = 1;
            }
        }
        catch (NullPointerException e){

        }
    }

    @FXML
    void handleTool11(ActionEvent event) {

        try {
            if (tool11Group.getSelectedToggle().equals(tool11Button1)) {

                tool11 = 1;
            }
            if (tool1Group.getSelectedToggle().equals(tool11Button2)) {

                tool11 = 2;
            }
            if (tool11Group.getSelectedToggle().equals(tool11Button3)) {

                tool11 = 3;
            }
            if (tool1Group.getSelectedToggle().equals(tool11Button4)) {

                tool11 = 4;
            }
            if (tool11Group.getSelectedToggle().equals(tool11Button5)) {

                tool11 = 5;
            }
            if (tool1Group.getSelectedToggle().equals(tool11Button6)) {

                tool11 = 6;
            }
        }
        catch (NullPointerException e) {

        }

    }

    @FXML
    void handleTool12(ActionEvent event) {

        try {
            if (tool12Group.getSelectedToggle().equals(tool12Button1)) {

                tool12 = 1;
            }
            if (tool12Group.getSelectedToggle().equals(tool12Button2)) {

                tool12 = 2;
            }
        }
        catch (NullPointerException e) {

        }

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

        window = new Stage();

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
