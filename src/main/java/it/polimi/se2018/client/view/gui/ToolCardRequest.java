package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Components.DiceColor;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class ToolCardRequest {

    private final Logger log = Logger.getLogger(ToolCardRequest.class.getName());
    private static final String logMsg = "Null pointer catch";
    private static int toolNumber;
    private static DiceColor color;
    private static BoardController board;
    private static Stage window;
    private int tool1;
    private int tool11;
    private int tool12;

    static void setToolNumber(int n){
        ToolCardRequest.toolNumber = n;
    }
    static void setBoard(BoardController board){
        ToolCardRequest.board = board;
    }
    public static void setColor(DiceColor color) {
        ToolCardRequest.color = color;
    }

    public void setTool11(int tool11) {
        this.tool11 = tool11;
    }

    public static void display()  throws IOException {

        window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(ToolCardRequest.class.getResource("/ToolExtraRequest.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        InputStream fileStream = ToolCardRequest.class.getResourceAsStream("/images/icon" + ".png");
        Image image = new Image(fileStream);
        window.getIcons().add(image);
        window.setScene(scene);
        window.setResizable(false);
        Platform.runLater(() -> window.showAndWait());
    }

    @FXML
    private TextArea text;
    @FXML
    private Button select;
    @FXML
    private ToggleGroup toolElevenGroup;
    @FXML
    private ToggleButton toolEleven1;
    @FXML
    private ToggleButton toolEleven2;
    @FXML
    private ToggleButton toolEleven3;
    @FXML
    private ToggleButton toolEleven4;
    @FXML
    private ToggleButton toolEleven5;
    @FXML
    private ToggleButton toolEleven6;
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


    //nel caso non funzionasse c'erano solo action event

    @FXML
    void buttonSelected() {

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
    void handleToolEleven() {

        try {
            if (toolElevenGroup.getSelectedToggle().equals(toolEleven1)) {
                setTool11(1);
            }
            if (toolElevenGroup.getSelectedToggle().equals(toolEleven2)) {
                setTool11(2);
            }
            if (toolElevenGroup.getSelectedToggle().equals(toolEleven3)) {
                setTool11(3);
            }
            if (toolElevenGroup.getSelectedToggle().equals(toolEleven4)) {
                setTool11(4);
            }
            if (toolElevenGroup.getSelectedToggle().equals(toolEleven5)) {
                setTool11(5);
            }
            if (toolElevenGroup.getSelectedToggle().equals(toolEleven6)) {
                setTool11(6);
            }

        }
        catch (NullPointerException e) {
            log.info(logMsg);
            log.warning(e.getMessage());
        }
    }

    @FXML
    void handleTool1() {

        try {
            if (tool1Group.getSelectedToggle().equals(tool1ButtonMin)) {
                tool1 = 0;
                System.out.println("entro in 1");
            }
            if (tool1Group.getSelectedToggle().equals(tool1ButtonPlus)) {
                tool1 = 1;
                System.out.println("entro in 2");
            }
        }
        catch (NullPointerException e) {
            log.info(logMsg);
            log.warning(e.getMessage());
        }
    }

    @FXML
    void handleTool12() {

        try {
            if (tool12Group.getSelectedToggle().equals(tool12Button1)) {
                tool12 = 1;
            }
            if (tool12Group.getSelectedToggle().equals(tool12Button2)) {
                tool12 = 2;
            }
        }
        catch (NullPointerException e) {
            log.info(logMsg);
            log.warning(e.getMessage());
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

            select.disableProperty().bind(Bindings.isNull(toolElevenGroup.selectedToggleProperty()));

            toolEleven1.setVisible(true);
            toolEleven2.setVisible(true);
            toolEleven3.setVisible(true);
            toolEleven4.setVisible(true);
            toolEleven5.setVisible(true);
            toolEleven6.setVisible(true);

        }
        if(toolNumber == 12){

            text.setText("Click how many dice you want to move, then SELECT");

            select.disableProperty().bind(Bindings.isNull(tool12Group.selectedToggleProperty()));

            tool12Button1.setVisible(true);
            tool12Button2.setVisible(true);

        }

    }
}
