package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.client.view.gui.GuiController;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.List;

public class ChoosePattern {


    @FXML
    private ImageView privateCard;

    @FXML
    private ImageView toolCardOne;

    @FXML
    private ImageView toolCardThree;

    @FXML
    private ImageView publicOne;

    @FXML
    private ImageView publicTwo;

    @FXML
    private ImageView publicThree;

    @FXML
    private ImageView patternCardTwo;

    @FXML
    private ImageView patternCardThree;

    @FXML
    private ImageView patternCardFour;

    @FXML
    private ImageView toolCard1Zoom;

    @FXML
    private ImageView toolCard2Zoom;

    @FXML
    private ImageView toolCard3Zoom;

    @FXML
    private ImageView publicCard1Zoom;

    @FXML
    private ImageView publicCard2Zoom;

    @FXML
    private ImageView publicCard3Zoom;

    @FXML
    private ImageView privateCardZoom;

    @FXML
    private Button playGameButton;

    @FXML
    private ImageView patternCardOne;

    @FXML
    private RadioButton radioPatternOne;

    @FXML
    private ToggleGroup patternToggleGroup;

    @FXML
    private RadioButton radioPatternThree;

    @FXML
    private RadioButton radioPatternTwo;

    @FXML
    private RadioButton radioPatternFour;

    private  int indexPattern;

    private GuiController mainController;


    public void setMainController(GuiController mainController){
        this.mainController = mainController;
    }



        @FXML
        void handlePrivateUnzoom (MouseEvent event){
            privateCardZoom.setVisible(false);
        }

        @FXML
        void handlePrivateZoom (MouseEvent event){
            privateCardZoom.setVisible(true);
        }

        @FXML
        void handlePublicUnzoom1 (MouseEvent event){
            publicCard1Zoom.setVisible(false);
        }

        @FXML
        void handlePublicUnzoom2 (MouseEvent event){
            publicCard2Zoom.setVisible(false);
        }

        @FXML
        void handlePublicUnzoom3 (MouseEvent event){
            publicCard3Zoom.setVisible(false);
        }

        @FXML
        void handlePublicZoom1 (MouseEvent event){
            publicCard1Zoom.setVisible(true);
        }

        @FXML
        void handlePublicZoom2 (MouseEvent event){
            publicCard2Zoom.setVisible(true);
        }

        @FXML
        void handlePublicZoom3 (MouseEvent event){
            publicCard3Zoom.setVisible(true);
        }

        @FXML
        void handleToolUnzoom1 (MouseEvent event){
            toolCard1Zoom.setVisible(false);
        }

        @FXML
        void handleToolUnzoom2 (MouseEvent event){
            toolCard2Zoom.setVisible(false);
        }

        @FXML
        void handleToolUnzoom3 (MouseEvent event){
            toolCard3Zoom.setVisible(false);
        }

        @FXML
        void handleToolZoom1 (MouseEvent event){
            toolCard1Zoom.setVisible(true);
        }

        @FXML
        void handleToolZoom2 (MouseEvent event){
            toolCard2Zoom.setVisible(true);
        }

        @FXML
        void handleToolZoom3 (MouseEvent event){
            toolCard3Zoom.setVisible(true);
        }

    @FXML
    void playButtonSelected(ActionEvent event) {

           if(patternToggleGroup.getSelectedToggle().equals(radioPatternFour)){
                indexPattern = 3;
           }else if(patternToggleGroup.getSelectedToggle().equals(radioPatternThree)){
               indexPattern = 2;
           }else if(patternToggleGroup.getSelectedToggle().equals(radioPatternTwo)){
               indexPattern = 1;
           }else{
               indexPattern = 0;
           }

           mainController.setPattern(indexPattern);




    }


        public void initialize () {




            toolCard1Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    System.out.println(newValue);
                }

            });
            toolCard2Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    System.out.println(newValue);
                }

            });
            toolCard3Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    System.out.println(newValue);
                }
            });
            privateCardZoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    System.out.println(newValue);
                }

            });
            publicCard3Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    System.out.println(newValue);
                }

            });
            publicCard2Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    System.out.println(newValue);
                }

            });
            publicCard1Zoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    System.out.println(newValue);
                }

            });
        }
}

