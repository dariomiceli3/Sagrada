package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.client.view.View;
import it.polimi.se2018.client.view.ViewState;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BoardController {

    //----start single player-----------------------

    @FXML
    private TextField textPrivateSingle;
    @FXML
    private ImageView toolCard4;
    @FXML
    private ImageView toolCard5;
    @FXML
    private ImageView toolCardZoom4;
    @FXML
    private ImageView toolCardZoom5;

    @FXML
    void handleTool4(MouseEvent event) {

    }

    @FXML
    void handleTool5(MouseEvent event) {

    }

    @FXML
    void handleUnzoomTool4(MouseEvent event) {

    }

    @FXML
    void handleUnzoomTool5(MouseEvent event) {

    }

    //----------end single player--------------


    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView panelWindow;

    @FXML
    private ImageView patternPlayer2;

    @FXML
    private ImageView patternPlayer3;

    @FXML
    private ImageView patternPlayer4;

    @FXML
    private ImageView privateCard;

    @FXML
    private ImageView patternCard;

    @FXML
    private Text tokensNumber;


    @FXML
    private ImageView toolCard1;

    @FXML
    private ImageView toolCard2;

    @FXML
    private ImageView toolCard3;

    @FXML
    private ImageView publicCard1;

    @FXML
    private ImageView publicCard2;

    @FXML
    private ImageView publicCard3;

    @FXML
    private TextArea textGame;

    @FXML
    private Button next;

    @FXML
    private Button skip;

    @FXML
    private Button exit;

    @FXML
    private Button roll;

    @FXML
    private ToggleGroup patternToggleGroup;

    @FXML
    private ToggleButton cell1;

    @FXML
    private ImageView imageCell1;

    @FXML
    private ToggleButton cell2;

    @FXML
    private ImageView imageCell2;

    @FXML
    private ToggleButton cell3;

    @FXML
    private ImageView imageCell3;

    @FXML
    private ToggleButton cell4;

    @FXML
    private ImageView imageCell4;

    @FXML
    private ToggleButton cell5;

    @FXML
    private ImageView imageCell5;

    @FXML
    private ToggleButton cell6;

    @FXML
    private ImageView imageCell6;

    @FXML
    private ToggleButton cell7;

    @FXML
    private ImageView imageCell7;

    @FXML
    private ToggleButton cell8;

    @FXML
    private ImageView imageCell8;

    @FXML
    private ToggleButton cell9;

    @FXML
    private ImageView imageCell9;

    @FXML
    private ToggleButton cell10;

    @FXML
    private ImageView imageCell10;

    @FXML
    private ToggleButton cell11;

    @FXML
    private ImageView imageCell11;

    @FXML
    private ToggleButton cell12;

    @FXML
    private ImageView imageCell12;

    @FXML
    private ToggleButton cell13;

    @FXML
    private ImageView imageCell13;

    @FXML
    private ToggleButton cell14;

    @FXML
    private ImageView imageCell14;

    @FXML
    private ToggleButton cell15;

    @FXML
    private ImageView imageCell15;

    @FXML
    private ToggleButton cell16;

    @FXML
    private ImageView imageCell16;

    @FXML
    private ToggleButton cell17;

    @FXML
    private ImageView imageCell17;

    @FXML
    private ToggleButton cell18;

    @FXML
    private ImageView imageCell18;

    @FXML
    private ToggleButton cell19;

    @FXML
    private ImageView imageCell19;

    @FXML
    private ToggleButton cell20;

    @FXML
    private ImageView imageCell20;

    @FXML
    private ToggleGroup roundToggleGroup;

    @FXML
    private ToggleButton round1;

    @FXML
    private ToggleButton round2;

    @FXML
    private ToggleButton round3;

    @FXML
    private ToggleButton round4;

    @FXML
    private ToggleButton round5;

    @FXML
    private ToggleButton round6;

    @FXML
    private ToggleButton round7;

    @FXML
    private ToggleButton round8;

    @FXML
    private ToggleButton round9;

    @FXML
    private ToggleGroup poolToggleGroup;

    @FXML
    private ToggleButton dice1;

    @FXML
    private ImageView imageDice1;

    @FXML
    private ToggleButton dice2;

    @FXML
    private ImageView imageDice2;

    @FXML
    private ToggleButton dice3;

    @FXML
    private ImageView imageDice3;

    @FXML
    private ToggleButton dice4;

    @FXML
    private ImageView imageDice4;

    @FXML
    private ToggleButton dice5;

    @FXML
    private ImageView imageDice5;

    @FXML
    private ToggleButton dice6;

    @FXML
    private ImageView imageDice6;

    @FXML
    private ToggleButton dice7;

    @FXML
    private ImageView imageDice7;

    @FXML
    private ToggleButton dice8;

    @FXML
    private ImageView imageDice8;

    @FXML
    private ToggleButton dice9;

    @FXML
    private ImageView imageDice9;

    @FXML
    private ImageView privateCardZoom;

    @FXML
    private ImageView publicCardZoom1;

    @FXML
    private ImageView publicCardZoom2;

    @FXML
    private ImageView publicCardZoom3;

    @FXML
    private ImageView toolCardZoom1;

    @FXML
    private ImageView toolCardZoom2;

    @FXML
    private ImageView toolCardZoom3;

    @FXML
    private Text costTool1;

    @FXML
    private Text costTool2;

    @FXML
    private Text costTool3;


    @FXML
    void handleCellEvent(ActionEvent event) {

        disableTool();
        disablePool();

        if (guiState == ViewState.DICEMOVESECOND) {
            next.setDisable(false);


        }

        if (guiState == ViewState.DICEMOVE) {
            next.setDisable(false);


        }

        try {
            if (patternToggleGroup.getSelectedToggle().equals(cell1)) {
                setIndexPattern(0);

            }
            if (patternToggleGroup.getSelectedToggle().equals(cell2)) {
                setIndexPattern(1);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell3)) {
                setIndexPattern(2);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell4)) {
                setIndexPattern(3);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell5)) {
                setIndexPattern(4);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell6)) {
                setIndexPattern(5);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell7)) {
                setIndexPattern(6);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell8)) {
                setIndexPattern(7);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell9)) {
                setIndexPattern(8);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell10)) {
                setIndexPattern(9);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell11)) {
                setIndexPattern(10);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell12)) {
                setIndexPattern(11);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell13)) {
                setIndexPattern(12);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell14)) {
                setIndexPattern(13);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell15)) {
                setIndexPattern(14);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell16)) {
                setIndexPattern(15);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell17)) {
                setIndexPattern(16);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell18)) {
                setIndexPattern(17);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell19)) {
                setIndexPattern(18);
            }
            if (patternToggleGroup.getSelectedToggle().equals(cell20)) {
                setIndexPattern(19);
            }
        }
        catch (NullPointerException e) {

        }

        if (guiState == ViewState.EGLOMISEEND) {
            setIndexPatternEndOne(indexPattern);
            next.setDisable(false);


        }

        if (guiState == ViewState.EGLOMISESTART) {
            setIndexPatternStartOne(indexPattern);
            setGuiState(ViewState.EGLOMISEEND);
        }

        if (guiState == ViewState.COPPEREND) {
            setIndexPatternEndOne(indexPattern);
            next.setDisable(false);

        }

        if (guiState == ViewState.COPPERSTART) {
            setIndexPatternStartOne(indexPattern);
            setGuiState(ViewState.COPPEREND);

        }

        if (guiState == ViewState.LATHEKINENDTWO) {
            setIndexPatternEndTwo(indexPattern);
            next.setDisable(false);
        }

        if (guiState == ViewState.LATHEKINSTARTTWO) {
            setIndexPatternStartTwo(indexPattern);
            setGuiState(ViewState.LATHEKINENDTWO);
        }

        if (guiState == ViewState.LATHEKINENDONE) {
            setIndexPatternEndOne(indexPattern);
            textGame.setText("Click the 2nd dice you want to move, and where you want to move it, then NEXT");
            setGuiState(ViewState.LATHEKINSTARTTWO);
        }

        if (guiState == ViewState.LATHEKINSTARTONE) {
            setIndexPatternStartOne(indexPattern);
            setGuiState(ViewState.LATHEKINENDONE);
        }

        if (guiState == ViewState.RUNNINGPOOL) {
            next.setDisable(false);
        }

        if (guiState == ViewState.CORKPOOL) {
            next.setDisable(false);
        }

        if (guiState == ViewState.TAPENDTWO) {
            setIndexPatternEndTwo(indexPattern);
            next.setDisable(false);
            disablePattern();
        }
        if (guiState == ViewState.TAPSTARTTWO) {
            setIndexPatternStartTwo(indexPattern);
            setGuiState(ViewState.TAPENDTWO);
        }
        if (guiState == ViewState.TAPENDONE) {
            setIndexPatternEndOne(indexPattern);
            next.setDisable(false);
            disablePattern();
        }
        if (guiState == ViewState.TAPSTARTONE) {
            setIndexPatternStartOne(indexPattern);
            setGuiState(ViewState.TAPENDONE);
        }








    }

    @FXML
    void handleDicePool(ActionEvent event) {

        if (guiState == ViewState.GROZINGPOOL) {
            next.setDisable(false);
        } else if (guiState == ViewState.MOVE) {
            setGuiState(ViewState.DICEMOVE);
        } else if (guiState == ViewState.FLUXBRUSH) {
            next.setDisable(false);
        } else if (guiState == ViewState.LENSCUTTERPOOL) {
            disablePool();
        } else if (guiState == ViewState.RUNNINGPOOL) {
            enablePattern();
        } else if (guiState == ViewState.CORKPOOL) {
            enablePattern();
        } else if (guiState == ViewState.GRINDING) {
            next.setDisable(false);
        } else if (guiState == ViewState.FLUXPOOL) {
            next.setDisable(false);
        }
        else {
            setGuiState(ViewState.DICEMOVESECOND);
        }

        try {
            if (poolToggleGroup.selectedToggleProperty().isNull().get()) {
                System.out.println("reset dice");
                dice1.setBlendMode(BlendMode.SRC_OVER);
                dice2.setBlendMode(BlendMode.SRC_OVER);
                dice3.setBlendMode(BlendMode.SRC_OVER);
                dice4.setBlendMode(BlendMode.SRC_OVER);
                dice5.setBlendMode(BlendMode.SRC_OVER);
                dice6.setBlendMode(BlendMode.SRC_OVER);
                dice7.setBlendMode(BlendMode.SRC_OVER);
                dice8.setBlendMode(BlendMode.SRC_OVER);
                dice9.setBlendMode(BlendMode.SRC_OVER);
            }
            if (poolToggleGroup.getSelectedToggle().equals(dice1)) {
                setIndexPool(0);
                dice1.setBlendMode(BlendMode.COLOR_BURN);
                dice2.setBlendMode(BlendMode.SRC_OVER);
                dice3.setBlendMode(BlendMode.SRC_OVER);
                dice4.setBlendMode(BlendMode.SRC_OVER);
                dice5.setBlendMode(BlendMode.SRC_OVER);
                dice6.setBlendMode(BlendMode.SRC_OVER);
                dice7.setBlendMode(BlendMode.SRC_OVER);
                dice8.setBlendMode(BlendMode.SRC_OVER);
                dice9.setBlendMode(BlendMode.SRC_OVER);
            }

            if (poolToggleGroup.getSelectedToggle().equals(dice2)) {
                setIndexPool(1);
                dice1.setBlendMode(BlendMode.SRC_OVER);
                dice2.setBlendMode(BlendMode.COLOR_BURN);
                dice3.setBlendMode(BlendMode.SRC_OVER);
                dice4.setBlendMode(BlendMode.SRC_OVER);
                dice5.setBlendMode(BlendMode.SRC_OVER);
                dice6.setBlendMode(BlendMode.SRC_OVER);
                dice7.setBlendMode(BlendMode.SRC_OVER);
                dice8.setBlendMode(BlendMode.SRC_OVER);
                dice9.setBlendMode(BlendMode.SRC_OVER);
            }
            if (poolToggleGroup.getSelectedToggle().equals(dice3)) {
                setIndexPool(2);
                dice1.setBlendMode(BlendMode.SRC_OVER);
                dice2.setBlendMode(BlendMode.SRC_OVER);
                dice3.setBlendMode(BlendMode.COLOR_BURN);
                dice4.setBlendMode(BlendMode.SRC_OVER);
                dice5.setBlendMode(BlendMode.SRC_OVER);
                dice6.setBlendMode(BlendMode.SRC_OVER);
                dice7.setBlendMode(BlendMode.SRC_OVER);
                dice8.setBlendMode(BlendMode.SRC_OVER);
                dice9.setBlendMode(BlendMode.SRC_OVER);
            }
            if (poolToggleGroup.getSelectedToggle().equals(dice4)) {
                setIndexPool(3);
                dice1.setBlendMode(BlendMode.SRC_OVER);
                dice2.setBlendMode(BlendMode.SRC_OVER);
                dice3.setBlendMode(BlendMode.SRC_OVER);
                dice4.setBlendMode(BlendMode.COLOR_BURN);
                dice5.setBlendMode(BlendMode.SRC_OVER);
                dice6.setBlendMode(BlendMode.SRC_OVER);
                dice7.setBlendMode(BlendMode.SRC_OVER);
                dice8.setBlendMode(BlendMode.SRC_OVER);
                dice9.setBlendMode(BlendMode.SRC_OVER);
            }
            if (poolToggleGroup.getSelectedToggle().equals(dice5)) {
                setIndexPool(4);
                dice1.setBlendMode(BlendMode.SRC_OVER);
                dice2.setBlendMode(BlendMode.SRC_OVER);
                dice3.setBlendMode(BlendMode.SRC_OVER);
                dice4.setBlendMode(BlendMode.SRC_OVER);
                dice5.setBlendMode(BlendMode.COLOR_BURN);
                dice6.setBlendMode(BlendMode.SRC_OVER);
                dice7.setBlendMode(BlendMode.SRC_OVER);
                dice8.setBlendMode(BlendMode.SRC_OVER);
                dice9.setBlendMode(BlendMode.SRC_OVER);
            }
            if (poolToggleGroup.getSelectedToggle().equals(dice6)) {
                setIndexPool(5);
                dice1.setBlendMode(BlendMode.SRC_OVER);
                dice2.setBlendMode(BlendMode.SRC_OVER);
                dice3.setBlendMode(BlendMode.SRC_OVER);
                dice4.setBlendMode(BlendMode.SRC_OVER);
                dice5.setBlendMode(BlendMode.SRC_OVER);
                dice6.setBlendMode(BlendMode.COLOR_BURN);
                dice7.setBlendMode(BlendMode.SRC_OVER);
                dice8.setBlendMode(BlendMode.SRC_OVER);
                dice9.setBlendMode(BlendMode.SRC_OVER);
            }
            if (poolToggleGroup.getSelectedToggle().equals(dice7)) {
                setIndexPool(6);
                dice1.setBlendMode(BlendMode.SRC_OVER);
                dice2.setBlendMode(BlendMode.SRC_OVER);
                dice3.setBlendMode(BlendMode.SRC_OVER);
                dice4.setBlendMode(BlendMode.SRC_OVER);
                dice5.setBlendMode(BlendMode.SRC_OVER);
                dice6.setBlendMode(BlendMode.SRC_OVER);
                dice7.setBlendMode(BlendMode.COLOR_BURN);
                dice8.setBlendMode(BlendMode.SRC_OVER);
                dice9.setBlendMode(BlendMode.SRC_OVER);
            }
            if (poolToggleGroup.getSelectedToggle().equals(dice8)) {
                setIndexPool(7);
                dice1.setBlendMode(BlendMode.SRC_OVER);
                dice2.setBlendMode(BlendMode.SRC_OVER);
                dice3.setBlendMode(BlendMode.SRC_OVER);
                dice4.setBlendMode(BlendMode.SRC_OVER);
                dice5.setBlendMode(BlendMode.SRC_OVER);
                dice6.setBlendMode(BlendMode.SRC_OVER);
                dice7.setBlendMode(BlendMode.SRC_OVER);
                dice8.setBlendMode(BlendMode.COLOR_BURN);
                dice9.setBlendMode(BlendMode.SRC_OVER);
            }
            if (poolToggleGroup.getSelectedToggle().equals(dice9)) {
                setIndexPool(8);
                dice1.setBlendMode(BlendMode.SRC_OVER);
                dice2.setBlendMode(BlendMode.SRC_OVER);
                dice3.setBlendMode(BlendMode.SRC_OVER);
                dice4.setBlendMode(BlendMode.SRC_OVER);
                dice5.setBlendMode(BlendMode.SRC_OVER);
                dice6.setBlendMode(BlendMode.SRC_OVER);
                dice7.setBlendMode(BlendMode.SRC_OVER);
                dice8.setBlendMode(BlendMode.SRC_OVER);
                dice9.setBlendMode(BlendMode.COLOR_BURN);
            }
        }
        catch (NullPointerException e) {
            //System.out.println(poolToggleGroup.getSelectedToggle().isSelected());

        }



    }

    @FXML
    void handlePrivateUnzoom(MouseEvent event) {
        privateCardZoom.setVisible(false);

    }

    @FXML
    void handlePrivateZoom(MouseEvent event) {
        privateCardZoom.setVisible(true);

    }

    @FXML
    void handleRoundButton(ActionEvent event) throws IOException {

        try {
            if (roundToggleGroup.getSelectedToggle().equals(round1)) {
                RoundTrackerBox.setBoxRound(0);

            }

            if (roundToggleGroup.getSelectedToggle().equals(round2)) {
                RoundTrackerBox.setBoxRound(1);

            }
            if (roundToggleGroup.getSelectedToggle().equals(round3)) {
                RoundTrackerBox.setBoxRound(2);

            }
            if (poolToggleGroup.getSelectedToggle().equals(round4)) {
                RoundTrackerBox.setBoxRound(3);

            }
            if (poolToggleGroup.getSelectedToggle().equals(round5)) {
                RoundTrackerBox.setBoxRound(4);

            }
            if (poolToggleGroup.getSelectedToggle().equals(round6)) {
                RoundTrackerBox.setBoxRound(5);

            }
            if (poolToggleGroup.getSelectedToggle().equals(round7)) {
                RoundTrackerBox.setBoxRound(6);

            }
            if (poolToggleGroup.getSelectedToggle().equals(round8)) {
                RoundTrackerBox.setBoxRound(7);

            }
            if (poolToggleGroup.getSelectedToggle().equals(round9)) {
                RoundTrackerBox.setBoxRound(8);
            }
        }
        catch (NullPointerException e) {
            //System.out.println(poolToggleGroup.getSelectedToggle().isSelected());

        }
        finally {
            RoundTrackerBox.display();
        }
    }

    @FXML
    void handleTool1(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {

            disablePool();

            toolCard1.setBlendMode(BlendMode.OVERLAY);
            toolCard2.setBlendMode(BlendMode.SRC_OVER);
            toolCard3.setBlendMode(BlendMode.SRC_OVER);

            // 1a mossa
            if (guiState == ViewState.MOVE) {
                next.setDisable(false);
                setGuiState(ViewState.TOOLMOVE);
                setIndexTool(0);
            }

            //2a mossa
            if (guiState == ViewState.TOOLMOVESECOND) {
                next.setDisable(false);
                setIndexTool(0);
            }

            if (guiState == ViewState.TOOLMOVE) {
                next.setDisable(false);
                setIndexTool(0);
            }

            if (guiState == ViewState.DICEMOVE) {
                next.setDisable(false);
                setIndexTool(0);
            }

            if (guiState == ViewState.DICEMOVESECOND) {
                next.setDisable(false);
                setIndexTool(0);
            }

        }
        if (event.getButton().equals(MouseButton.SECONDARY)) {
            toolCard1.setBlendMode(BlendMode.SRC_OVER);
            toolCardZoom1.setVisible(true);
            next.setDisable(true);
            enablePool();

        }

        }

    @FXML
    void handleTool2(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {

            disablePool();

            toolCard1.setBlendMode(BlendMode.SRC_OVER);
            toolCard2.setBlendMode(BlendMode.OVERLAY);
            toolCard3.setBlendMode(BlendMode.SRC_OVER);

            if (guiState == ViewState.MOVE) {
                next.setDisable(false);
                setGuiState(ViewState.TOOLMOVE);
                setIndexTool(1);
            }
            if (guiState == ViewState.TOOLMOVESECOND) {
                next.setDisable(false);
                setIndexTool(1);
            }
            if (guiState == ViewState.TOOLMOVE) {
                next.setDisable(false);
                setIndexTool(1);
            }
            if (guiState == ViewState.DICEMOVE) {
                next.setDisable(false);
                setIndexTool(1);
            }
            if (guiState == ViewState.DICEMOVESECOND) {
                next.setDisable(false);
                setIndexTool(1);
            }


        }
        if (event.getButton().equals(MouseButton.SECONDARY)) {
            enablePool();
            toolCard2.setBlendMode(BlendMode.SRC_OVER);
            toolCardZoom2.setVisible(true);
            next.setDisable(true);
        }


    }

    @FXML
    void handleTool3(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {

            disablePool();

            toolCard1.setBlendMode(BlendMode.SRC_OVER);
            toolCard2.setBlendMode(BlendMode.SRC_OVER);
            toolCard3.setBlendMode(BlendMode.OVERLAY);

            if (guiState == ViewState.MOVE) {
                next.setDisable(false);
                setGuiState(ViewState.TOOLMOVE);
                setIndexTool(2);

            }
            if (guiState == ViewState.TOOLMOVESECOND) {
                next.setDisable(false);
                setIndexTool(2);
            }
            if (guiState == ViewState.TOOLMOVE) {
                next.setDisable(false);
                setIndexTool(2);
            }
            if (guiState == ViewState.DICEMOVE) {
                next.setDisable(false);
                setIndexTool(2);
            }
            if (guiState == ViewState.DICEMOVESECOND) {
                next.setDisable(false);
                setIndexTool(2);
            }



        }
        if (event.getButton().equals(MouseButton.SECONDARY)) {
            toolCard3.setBlendMode(BlendMode.SRC_OVER);
            toolCardZoom3.setVisible(true);
            enablePool();
            next.setDisable(true);
        }

    }

    @FXML
    void handleZoomPublic1(MouseEvent event) {
        publicCardZoom1.setVisible(true);

    }

    @FXML
    void handleZoomPublic2(MouseEvent event) {
        publicCardZoom2.setVisible(true);
    }

    @FXML
    void handleZoomPublic3(MouseEvent event) {
        publicCardZoom3.setVisible(true);

    }

    @FXML
    void handleUnzoomPublic1(MouseEvent event) {
        publicCardZoom1.setVisible(false);

    }

    @FXML
    void handleUnzoomPublic2(MouseEvent event) {
        publicCardZoom2.setVisible(false);

    }

    @FXML
    void handleUnzoomPublic3(MouseEvent event) {
        publicCardZoom3.setVisible(false);

    }

    @FXML
    void handleUnzoomTool1(MouseEvent event) {
        toolCardZoom1.setVisible(false);
    }

    @FXML
    void handleUnzoomTool2(MouseEvent event) {
        toolCardZoom2.setVisible(false);

    }

    @FXML
    void handleUnzoomTool3(MouseEvent event) {
        toolCardZoom3.setVisible(false);

    }

    @FXML
    void handleUpdatePattern2(MouseEvent event) throws IOException {

        if (mainController.getPlayerID() == 0){
            OtherPatternCard.setPatternCard(mainController.getPatternID1());
            OtherPatternCard.displayOtherPattern(mainController.getNameID1());
        }
        if (mainController.getPlayerID() == 1) {
            OtherPatternCard.setPatternCard(mainController.getPatternID0());
            OtherPatternCard.displayOtherPattern(mainController.getNameID0());
        }

        if (mainController.getPlayerID() == 2) {
            OtherPatternCard.setPatternCard(mainController.getPatternID0());
            OtherPatternCard.displayOtherPattern(mainController.getNameID0());
        }
        if (mainController.getPlayerID() == 3) {
            OtherPatternCard.setPatternCard(mainController.getPatternID0());
            OtherPatternCard.displayOtherPattern(mainController.getNameID0());
        }

    }

    @FXML
    void handleUpdatePattern3(MouseEvent event) throws IOException {

        if (mainController.getPlayerID() == 0){
            OtherPatternCard.setPatternCard(mainController.getPatternID2());
            OtherPatternCard.displayOtherPattern(mainController.getNameID2());
        }
        if (mainController.getPlayerID() == 1) {
            OtherPatternCard.setPatternCard(mainController.getPatternID2());
            OtherPatternCard.displayOtherPattern(mainController.getNameID2());
        }

        if (mainController.getPlayerID() == 2) {
            OtherPatternCard.setPatternCard(mainController.getPatternID1());
            OtherPatternCard.displayOtherPattern(mainController.getNameID1());
        }
        if (mainController.getPlayerID() == 3) {
            OtherPatternCard.setPatternCard(mainController.getPatternID1());
            OtherPatternCard.displayOtherPattern(mainController.getNameID1());
        }
    }

    @FXML
    void handleUpdatePattern4(MouseEvent event) throws IOException{

        if (mainController.getPlayerID() == 0){
            OtherPatternCard.setPatternCard(mainController.getPatternID3());
            OtherPatternCard.displayOtherPattern(mainController.getNameID3());
        }
        if (mainController.getPlayerID() == 1) {
            OtherPatternCard.setPatternCard(mainController.getPatternID3());
            OtherPatternCard.displayOtherPattern(mainController.getNameID3());
        }

        if (mainController.getPlayerID() == 2) {
            OtherPatternCard.setPatternCard(mainController.getPatternID3());
            OtherPatternCard.displayOtherPattern(mainController.getNameID3());
        }
        if (mainController.getPlayerID() == 3) {
            OtherPatternCard.setPatternCard(mainController.getPatternID2());
            OtherPatternCard.displayOtherPattern(mainController.getNameID2());
        }


    }



    @FXML
    void nextButtonSelected(ActionEvent event) {

        if (guiState == ViewState.DICEMOVE) {
            mainController.getConnection().setChooseToServer(mainController.getPlayerID(), 0);
        }

        if (guiState == ViewState.TOOLMOVE) {
            mainController.getConnection().setChooseToServer(mainController.getPlayerID(), 1);
            toolCard1.setBlendMode(BlendMode.SRC_OVER);
            toolCard2.setBlendMode(BlendMode.SRC_OVER);
            toolCard3.setBlendMode(BlendMode.SRC_OVER);
        }

        if (guiState == ViewState.TOOLMOVESECOND) {
            updateCost(indexTool);
            mainController.getConnection().useToolCardToServer(mainController.getPlayerID(), indexTool);
            toolCard1.setBlendMode(BlendMode.SRC_OVER);
            toolCard2.setBlendMode(BlendMode.SRC_OVER);
            toolCard3.setBlendMode(BlendMode.SRC_OVER);
        }

        if (guiState == ViewState.DICEMOVESECOND) {
            mainController.getConnection().setMoveToServer(mainController.getPlayerID(), indexPool, indexPattern);
        }

        if (guiState == ViewState.GROZINGPOOL) {
            next.setDisable(true);
            ToolCardRequest.setToolNumber(1);
            try {
                pane.setDisable(true);
                ToolCardRequest.display();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (guiState == ViewState.GROZINGCOMMAND) {
            mainController.getConnection().useGrozingToolCard(mainController.getPlayerID(), indexPool, increase);
        }

        if (guiState == ViewState.EGLOMISEEND) {
            mainController.getConnection().useEglomiseToolCard(mainController.getPlayerID(), indexPatternStartOne, indexPatternEndOne);
        }

        if (guiState == ViewState.COPPEREND) {
            mainController.getConnection().useCopperFoilToolCard(mainController.getPlayerID(), indexPatternStartOne, indexPatternEndOne);
        }

        if (guiState == ViewState.LATHEKINENDTWO) {
            mainController.getConnection().useLathekinToolCard(mainController.getPlayerID(), indexPatternStartOne, indexPatternEndOne, indexPatternStartTwo, indexPatternEndTwo );
        }

        if (guiState == ViewState.FLUXBRUSH) {
            mainController.getConnection().useFluxBrushToolCard(mainController.getPlayerID(), indexPool);
        }
        if (guiState == ViewState.LENSCUTTERPOOL) {
            mainController.getConnection().useLensCutterToolCard(mainController.getPlayerID(), indexPool, round, indexPosition);
        }
        if (guiState == ViewState.RUNNINGPOOL) {
            mainController.getConnection().useRunningPliersToolCard(mainController.getPlayerID(), indexPool, indexPattern);
        }
        if (guiState == ViewState.CORKPOOL) {
            mainController.getConnection().useCorkBackedToolCard(mainController.getPlayerID(),indexPool, indexPattern);
        }
        if (guiState == ViewState.GRINDING) {
            mainController.getConnection().useGrindingStoneToolCard(mainController.getPlayerID(), indexPool);
        }
        if (guiState == ViewState.FLUXPOOL) {
            next.setDisable(true);
            ToolCardRequest.setToolNumber(11);
            try {
                pane.setDisable(true);
                ToolCardRequest.display();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (guiState == ViewState.FLUXVALUE) {
            mainController.getConnection().useFluxRemoverToolCard(mainController.getPlayerID(), indexPool, diceValue);
        }
        if (guiState == ViewState.TAPNUMBER) {
            next.setDisable(true);
            textTapWheelFirstDice();
        }
        if (guiState == ViewState.TAPENDONE) {
            if (numberDice == 1) {
                mainController.getConnection().useTapWheelToolCard(mainController.getPlayerID(), numberDice, indexPatternStartOne, indexPatternEndOne, 0, 0);
            }
            if (numberDice == 2) {
                textTapWheelSecondDice();
            }
        }
        if (guiState == ViewState.TAPENDTWO) {
            mainController.getConnection().useTapWheelToolCard(mainController.getPlayerID(), numberDice, indexPatternStartOne, indexPatternEndOne, indexPatternStartTwo, indexPatternEndTwo);
        }




    }

    @FXML
    void skipButtonSelected(ActionEvent event) {

        mainController.getConnection().setNextTurnToServer(mainController.getPlayerID());

    }

    @FXML
    void exitButtonSelected(ActionEvent event) {

    }

    @FXML
    void rollButtonSelected(ActionEvent event) {

        if (guiState == ViewState.GLAZINGHAMMER) {
            mainController.getConnection().useGlazingHammerToolCard(mainController.getPlayerID());
        }
        else {
            mainController.getConnection().setDraftPoolToServer(mainController.getPlayerID());
        }
    }

    private static final int DEFAULT = 0;
    private static GuiController mainController;
    private FileInputStream fileStream;
    private static int indexPool;
    private static int indexPattern;
    private static int indexPatternStartOne;
    private static int indexPatternEndOne;
    private static int indexPatternStartTwo;
    private static int indexPatternEndTwo;
    private static int indexTool;
    private static ViewState guiState;
    private DraftPool draftPool;
    private int prevPoolSize = DEFAULT;
    private int currPoolSize;
    private RoundTracker roundTracker;
    private int increase;
    private int indexPosition;
    private int round;
    private int diceValue;
    private int numberDice;


    public static void setMainController(GuiController mainController){
        BoardController.mainController = mainController;
    }

    private static void setIndexPool(int indexPool) {
        BoardController.indexPool = indexPool;
    }

    private static void setIndexTool(int indexTool) {
        BoardController.indexTool = indexTool;
    }

    private static void setIndexPattern(int indexPattern) {
        BoardController.indexPattern = indexPattern;
    }

    private static void setIndexPatternStartOne(int indexPatternStartOne) {
        BoardController.indexPatternStartOne = indexPatternStartOne;
    }
    private static void setIndexPatternEndOne(int indexPatternEndOne) {
        BoardController.indexPatternEndOne = indexPatternEndOne;
    }

    private static void setIndexPatternStartTwo(int indexPatternStartTwo) {
        BoardController.indexPatternStartTwo = indexPatternStartTwo;
    }
    private static void setIndexPatternEndTwo(int indexPatternEndTwo) {
        BoardController.indexPatternEndTwo = indexPatternEndTwo;
    }


    private static void setGuiState(ViewState state) {
        BoardController.guiState = state;
    }

    private DraftPool getDraftPool() {
        return draftPool;
    }

    private void setDraftPool(DraftPool draftPool) {
        this.draftPool = draftPool;
    }

    protected RoundTracker getRoundTracker() {
        return roundTracker;
    }

    protected void setRoundTracker(RoundTracker roundTracker){
        this.roundTracker = roundTracker;
    }

    protected void setIncrease(int increase) {
        setGuiState(ViewState.GROZINGCOMMAND);
        pane.setDisable(false);
        next.setDisable(false);
        disablePool();
        this.increase = increase;
    }

    protected void setIndexPosition(int index) {
        if (guiState == ViewState.LENSCUTTERPOOL) {
            this.indexPosition = index;
            next.setDisable(false);
        }
    }

    protected void setDiceValue(int diceValue) {
        setGuiState(ViewState.FLUXVALUE);
        pane.setDisable(false);
        next.setDisable(false);
        disablePool();
        this.diceValue = diceValue;
    }

    protected void setNumberDice(int numberDice) {

        if (guiState == ViewState.TAPNUMBER) {
            pane.setDisable(false);
            next.setDisable(false);
            this.numberDice = numberDice;
        }
    }

    protected void setRound(int round) {
        this.round = round;
    }


    public void initialize() throws IOException {

        GuiController.setBoard(this);
        RoundTrackerBox.setMainController(this);
        ToolCardRequest.setBoard(this);

        setToolCost();

        loadPanel();
        loadPattern();
        loadTokensNumber();
        loadPrivate();
        loadPublicCard();
        loadToolCard();
        loadOtherPattern();


        privateCardZoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        publicCardZoom1.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        publicCardZoom2.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        publicCardZoom3.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        toolCardZoom1.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        toolCardZoom2.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        toolCardZoom3.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });
    }




    private void setToolCost() {

        costTool1.setText("" + mainController.getToolList().get(0).getCost());
        costTool2.setText("" + mainController.getToolList().get(1).getCost());
        costTool3.setText("" + mainController.getToolList().get(2).getCost());
    }


    private void loadPanel() throws IOException {

        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/panel");

        try {
            System.out.println("consegna panel");
            if ((mainController.getPlayerID() == 0)) {
                fileStream = new FileInputStream(filePath + "/BluePanel" + ".png");
                Image imagePlayerOne = new Image(fileStream);
                panelWindow.setImage(imagePlayerOne);
            }
            if ((mainController.getPlayerID() == 1)) {
                fileStream = new FileInputStream(filePath + "/GreenPanel" + ".png");
                Image imagePlayerTwo = new Image(fileStream);
                panelWindow.setImage(imagePlayerTwo);
            }
            if ((mainController.getPlayerID() == 2)) {
                fileStream = new FileInputStream(filePath + "/PurplePanel" + ".png");
                Image imagePlayerThree = new Image(fileStream);
                panelWindow.setImage(imagePlayerThree);
            }

            if ((mainController.getPlayerID() == 3)) {
                fileStream = new FileInputStream(filePath + "/RedPanel" + ".png");
                Image imagePlayerFour = new Image(fileStream);
                panelWindow.setImage(imagePlayerFour);
            }
        } finally {
            fileStream.close();
        }

    }

    private void loadPrivate() throws IOException {

        File file = new File("./");
        String fileColor = mainController.getPrivateCard().getColour().toString();
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/private");

        try {
            System.out.println("private board");
            fileStream = new FileInputStream(filePath + "/" + fileColor + ".png");
            Image image = new Image(fileStream);
            privateCard.setImage(image);
            privateCardZoom.setImage(image);
        }
        finally {
            fileStream.close();
        }
    }


    private void loadPattern() throws IOException {

        File file = new File("./");
        String filePattern = mainController.getPatternCurrent().getName();
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/pattern");

        try {
            System.out.println("consegna singola pattern");
            fileStream = new FileInputStream(filePath + "/" + filePattern + ".jpg");
            Image image = new Image(fileStream);
            patternCard.setImage(image);
        }
        finally {
            fileStream.close();
        }

    }


    private void loadPublicCard() throws IOException  {

        for (int i = 0; i < mainController.getPublicCardList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getPublicCardList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/public");

            try {
                System.out.println("consegna public board");
                fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                Image image = new Image(fileStream);
                if (i == 0) {
                    publicCard1.setImage(image);
                    publicCardZoom1.setImage(image);
                }
                if (i == 1) {
                    publicCard2.setImage(image);
                    publicCardZoom2.setImage(image);
                }
                if (i == 2) {
                    publicCard3.setImage(image);
                    publicCardZoom3.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }

        }
    }

    private void loadToolCard() throws IOException {

        for (int i = 0; i < mainController.getToolList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getToolList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/tool");

            try {
                System.out.println("consegna tool board");
                fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                Image image = new Image(fileStream);
                if (i == 0) {
                    toolCard1.setImage(image);
                    toolCardZoom1.setImage(image);
                }
                if (i == 1) {
                    toolCard2.setImage(image);
                    toolCardZoom2.setImage(image);
                }
                if (i == 2) {
                    toolCard3.setImage(image);
                    toolCardZoom3.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }

        }
    }

    private void loadTokensNumber() {
        tokensNumber.setText("" + mainController.getPatternCurrent().getDifficulty());
    }

    private void loadOtherPattern() throws IOException {

        if (mainController.getPlayerID() == 0) {

            if (mainController.getPatternID1() != null) {
                String fileName = mainController.getPatternID1().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
                System.out.println("setted player2-0");
                fileStream.close();
            }

            if (mainController.getPatternID2() != null) {
                String fileName = mainController.getPatternID2().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
                System.out.println("setted player3-0");
                fileStream.close();
            }

            if (mainController.getPatternID3() != null) {
                String fileName = mainController.getPatternID3().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
                System.out.println("setted player4-0");
                fileStream.close();
            }

        }

        if (mainController.getPlayerID() == 1) {

            if (mainController.getPatternID0() != null) {
                String fileName = mainController.getPatternID0().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
                System.out.println("setted player2-1");
                fileStream.close();
            }

            if (mainController.getPatternID2() != null) {
                String fileName = mainController.getPatternID2().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
                System.out.println("setted player 3-1");
                fileStream.close();
            }

            if (mainController.getPatternID3() != null) {
                String fileName = mainController.getPatternID3().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
                System.out.println("setted player 4-1");
                fileStream.close();
            }

        }

        if (mainController.getPlayerID() == 2){

            if (mainController.getPatternID0() != null) {
                String fileName = mainController.getPatternID0().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
                System.out.println("setted player 2-2");
                fileStream.close();
            }

            if (mainController.getPatternID1() != null) {
                String fileName = mainController.getPatternID1().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
                System.out.println("setted player 3-2");
                fileStream.close();
            }

            if (mainController.getPatternID3() != null) {
                String fileName = mainController.getPatternID3().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
                System.out.println("setted player 4-2");
                fileStream.close();
            }

        }

        if (mainController.getPlayerID() == 3){

            if (mainController.getPatternID0() != null) {
                String fileName = mainController.getPatternID0().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
                System.out.println("setted player 2-3");
                fileStream.close();
            }

            if (mainController.getPatternID1() != null) {
                String fileName = mainController.getPatternID1().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
                System.out.println("setted player 3-3");
                fileStream.close();
            }

            if (mainController.getPatternID2() != null) {
                String fileName = mainController.getPatternID2().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
                System.out.println("setted player 3-3 ");
                fileStream.close();
            }

        }

    }

    private Image loadImage(String fileName) throws IOException {

        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/pattern");
        fileStream = new FileInputStream(filePath + "/" + fileName + ".jpg");
        return new Image(fileStream);
    }

    private void loadDiceOnPattern(int indexPattern, String fileName) throws IOException {

        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/images/dice");

        try {
            System.out.println("updating  pattern");
            fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
            Image image = new Image(fileStream);

            if (indexPattern == 0) {
                imageCell1.setImage(image);
                cell1.setOpacity(1);
            }
            if (indexPattern == 1) {
                imageCell2.setImage(image);
                cell2.setOpacity(1);
            }
            if (indexPattern == 2) {
                imageCell3.setImage(image);
                cell3.setOpacity(1);
            }
            if (indexPattern == 3) {
                imageCell4.setImage(image);
                cell4.setOpacity(1);
            }
            if (indexPattern == 4) {
                imageCell5.setImage(image);
                cell5.setOpacity(1);
            }
            if (indexPattern == 5) {
                imageCell6.setImage(image);
                cell6.setOpacity(1);
            }
            if (indexPattern == 6) {
                imageCell7.setImage(image);
                cell7.setOpacity(1);
            }
            if (indexPattern == 7) {
                imageCell8.setImage(image);
                cell8.setOpacity(1);
            }
            if (indexPattern == 8) {
                imageCell9.setImage(image);
                cell9.setOpacity(1);
            }
            if (indexPattern == 9) {
                imageCell10.setImage(image);
                cell10.setOpacity(1);
            }
            if (indexPattern == 10) {
                imageCell11.setImage(image);
                cell11.setOpacity(1);
            }
            if (indexPattern == 11) {
                imageCell12.setImage(image);
                cell12.setOpacity(1);
            }
            if (indexPattern == 12) {
                imageCell13.setImage(image);
                cell13.setOpacity(1);
            }
            if (indexPattern == 13) {
                imageCell14.setImage(image);
                cell14.setOpacity(1);
            }
            if (indexPattern == 14) {
                imageCell15.setImage(image);
                cell15.setOpacity(1);
            }
            if (indexPattern == 15) {
                imageCell16.setImage(image);
                cell16.setOpacity(1);
            }
            if (indexPattern == 16) {
                imageCell17.setImage(image);
                cell17.setOpacity(1);
            }
            if (indexPattern == 17) {
                imageCell18.setImage(image);
                cell18.setOpacity(1);
            }
            if (indexPattern == 18) {
                imageCell19.setImage(image);
                cell19.setOpacity(1);
            }
            if (indexPattern == 19) {
                imageCell20.setImage(image);
                cell20.setOpacity(1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            fileStream.close();
        }

    }

    private void removeDiceOnPattern(int index) {

        if (index == 0) {
            imageCell1.setImage(null);
            cell1.setOpacity(0);
        }

        if (index == 1) {
            imageCell2.setImage(null);
            cell2.setOpacity(0);
        }

        if (index == 2) {
            imageCell3.setImage(null);
            cell3.setOpacity(0);
        }

        if (index == 3) {
            imageCell4.setImage(null);
            cell4.setOpacity(0);

        }

        if (index == 4) {
            imageCell5.setImage(null);
            cell5.setOpacity(0);

        }

        if (index == 5) {
            imageCell6.setImage(null);
            cell6.setOpacity(0);

        }

        if (index == 6) {
            imageCell7.setImage(null);
            cell7.setOpacity(0);

        }

        if (index == 7) {
            imageCell8.setImage(null);
            cell8.setOpacity(0);

        }

        if (index == 8) {
            imageCell9.setImage(null);
            cell9.setOpacity(0);

        }

        if (index == 9) {
            imageCell10.setImage(null);
            cell10.setOpacity(0);

        }

        if (index == 10) {
            imageCell11.setImage(null);
            cell11.setOpacity(0);

        }

        if (index == 11) {
            imageCell12.setImage(null);
            cell12.setOpacity(0);
        }

        if (index == 12) {
            imageCell13.setImage(null);
            cell13.setOpacity(0);

        }

        if (index == 13) {
            imageCell14.setImage(null);
            cell14.setOpacity(0);

        }

        if (index == 14) {
            imageCell15.setImage(null);
            cell15.setOpacity(0);

        }
        if (index == 15) {
            imageCell16.setImage(null);
            cell16.setOpacity(0);

        }
        if (index == 16) {
            imageCell17.setImage(null);
            cell17.setOpacity(0);

        }
        if (index == 17) {
            imageCell18.setImage(null);
            cell18.setOpacity(0);

        }
        if (index == 18) {
            imageCell19.setImage(null);
            cell19.setOpacity(0);

        }
        if (index == 19) {
            imageCell20.setImage(null);
            cell20.setOpacity(0);
        }


    }

    private void cleanDraftPool() {

        int size = getDraftPool().getDraftPool().size();

        if (size == 1) {
            dice1.setVisible(false);
        }
        if (size == 2) {
            dice1.setVisible(false);
            dice2.setVisible(false);
        }
        if (size == 3) {
            dice1.setVisible(false);
            dice2.setVisible(false);
            dice3.setVisible(false);
        }
        if (size == 4) {
            dice1.setVisible(false);
            dice2.setVisible(false);
            dice3.setVisible(false);
            dice4.setVisible(false);
        }
        if (size == 5) {
            dice1.setVisible(false);
            dice2.setVisible(false);
            dice3.setVisible(false);
            dice4.setVisible(false);
            dice5.setVisible(false);
        }

        if (size == 6) {
            dice1.setVisible(false);
            dice2.setVisible(false);
            dice3.setVisible(false);
            dice4.setVisible(false);
            dice5.setVisible(false);
            dice6.setVisible(false);
        }

        if (size == 7) {
            dice1.setVisible(false);
            dice2.setVisible(false);
            dice3.setVisible(false);
            dice4.setVisible(false);
            dice5.setVisible(false);
            dice6.setVisible(false);
            dice7.setVisible(false);
        }

        if (size == 8) {
            dice1.setVisible(false);
            dice2.setVisible(false);
            dice3.setVisible(false);
            dice4.setVisible(false);
            dice5.setVisible(false);
            dice6.setVisible(false);
            dice7.setVisible(false);
            dice8.setVisible(false);

        }

        if (size == 9) {
            dice1.setVisible(false);
            dice2.setVisible(false);
            dice3.setVisible(false);
            dice4.setVisible(false);
            dice5.setVisible(false);
            dice6.setVisible(false);
            dice7.setVisible(false);
            dice8.setVisible(false);
            dice9.setVisible(false);

        }

    }

    private void unvisibleDraftPool(int size) {

        if (size == 1) {
            dice1.setVisible(false);
        }
        if (size == 2) {
            dice2.setVisible(false);
        }
        if (size == 3) {
            dice3.setVisible(false);
        }
        if (size == 4) {
            dice4.setVisible(false);
        }
        if (size == 5) {
            dice5.setVisible(false);
        }
        if (size == 6) {
            dice6.setVisible(false);
        }
        if (size == 7) {
            dice7.setVisible(false);
        }
        if (size == 8) {
            dice8.setVisible(false);
        }
        if (size == 9) {
            dice9.setVisible(false);
        }
    }

    private void disablePattern() {

        cell1.setDisable(true);
        cell2.setDisable(true);
        cell3.setDisable(true);
        cell4.setDisable(true);
        cell5.setDisable(true);
        cell6.setDisable(true);
        cell7.setDisable(true);
        cell8.setDisable(true);
        cell9.setDisable(true);
        cell10.setDisable(true);
        cell11.setDisable(true);
        cell12.setDisable(true);
        cell13.setDisable(true);
        cell14.setDisable(true);
        cell15.setDisable(true);
        cell16.setDisable(true);
        cell17.setDisable(true);
        cell18.setDisable(true);
        cell19.setDisable(true);
        cell20.setDisable(true);


    }

    private void enablePattern() {

        cell1.setDisable(false);
        cell2.setDisable(false);
        cell3.setDisable(false);
        cell4.setDisable(false);
        cell5.setDisable(false);
        cell6.setDisable(false);
        cell7.setDisable(false);
        cell8.setDisable(false);
        cell9.setDisable(false);
        cell10.setDisable(false);
        cell11.setDisable(false);
        cell12.setDisable(false);
        cell13.setDisable(false);
        cell14.setDisable(false);
        cell15.setDisable(false);
        cell16.setDisable(false);
        cell17.setDisable(false);
        cell18.setDisable(false);
        cell19.setDisable(false);
        cell20.setDisable(false);

    }

    private void enablePool() {
        dice1.setDisable(false);
        dice2.setDisable(false);
        dice3.setDisable(false);
        dice4.setDisable(false);
        dice5.setDisable(false);
        dice6.setDisable(false);
        dice7.setDisable(false);
        dice8.setDisable(false);
        dice9.setDisable(false);
    }

    private void disablePool(){
        dice1.setDisable(true);
        dice2.setDisable(true);
        dice3.setDisable(true);
        dice4.setDisable(true);
        dice5.setDisable(true);
        dice6.setDisable(true);
        dice7.setDisable(true);
        dice8.setDisable(true);
        dice9.setDisable(true);
    }

    private void enableTool() {
        toolCard1.setDisable(false);
        toolCard2.setDisable(false);
        toolCard3.setDisable(false);
    }

    private void disableTool() {
        toolCard1.setDisable(true);
        toolCard2.setDisable(true);
        toolCard3.setDisable(true);
    }

    public void updateRound(int round) {

        textGame.setText("Round " + round + "is started");
        next.setDisable(true);
        skip.setDisable(true);
        roll.setDisable(true);

        if (round == 1) {
            AlertBox.display("Round", "Round 1 is started");
        }
        if (round == 2) {
            AlertBox.display("Round", "Round " + round + " is started. Check the Round Tracker");
            round1.setVisible(true);
        }
        if (round == 3) {
            AlertBox.display("Round", "Round " + round + " is started. Check the Round Tracker");
            round2.setVisible(true);
        }
        if (round == 4) {
            AlertBox.display("Round", "Round " + round + " is started. Check the Round Tracker");
            round3.setVisible(true);
        }
        if (round == 5) {
            AlertBox.display("Round", "Round " + round + " is started. Check the Round Tracker");
            round4.setVisible(true);
        }
        if (round == 6) {
            AlertBox.display("Round", "Round " + round + " is started. Check the Round Tracker");
            round5.setVisible(true);
        }
        if (round == 7) {
            AlertBox.display("Round", "Round " + round + " is started. Check the Round Tracker");
            round6.setVisible(true);
        }
        if (round == 8) {
            AlertBox.display("Round", "Round " + round + " is started. Check the Round Tracker");
            round7.setVisible(true);
        }
        if (round == 9) {
            AlertBox.display("Round", "Round " + round + " is started. Check the Round Tracker");
            round8.setVisible(true);
        }
        if (round == 10) {
            AlertBox.display("Round", "Round " + round + " is started. Check the Round Tracker");
            round9.setVisible(true);
        }

    }



    public void updateTurn() {
        textGame.setText("It's your turn");
        pane.setDisable(false);
        next.setDisable(false);
        skip.setDisable(false);
        roll.setDisable(true);
    }

    public void updateOtherTurn(String name) {
        textGame.setText("It's " + name + " turn");
        pane.setDisable(true);
        next.setDisable(true);
        skip.setDisable(true);
        roll.setDisable(true);
        exit.setDisable(false);
    }

    public void textRollMsg() {
        textGame.setText("Click the roll button to roll the draft pool");
        disablePool();
        next.setDisable(true);
        skip.setDisable(true);
        roll.setDisable(false);
    }

    public void updateDraftPool(DraftPool draftPool) throws IOException {

        setToken(mainController.getTokens());

        dice1.setBlendMode(BlendMode.SRC_OVER);
        dice2.setBlendMode(BlendMode.SRC_OVER);
        dice3.setBlendMode(BlendMode.SRC_OVER);
        dice4.setBlendMode(BlendMode.SRC_OVER);
        dice5.setBlendMode(BlendMode.SRC_OVER);
        dice6.setBlendMode(BlendMode.SRC_OVER);
        dice7.setBlendMode(BlendMode.SRC_OVER);
        dice8.setBlendMode(BlendMode.SRC_OVER);
        dice9.setBlendMode(BlendMode.SRC_OVER);

        setDraftPool(draftPool);

       for (int i = 0; i < draftPool.getDraftPool().size(); i++) {

           File file = new File("./");
           String fileName = draftPool.getDraftPool().get(i).toStringGui();
           String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/dice");

           try {
               fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
               Image image = new Image(fileStream);
               if (i == 0) {
                   imageDice1.setImage(image);
                   dice1.setVisible(true);
               }
               if (i == 1) {
                   imageDice2.setImage(image);
                   dice2.setVisible(true);
               }
               if (i == 2) {
                   imageDice3.setImage(image);
                   dice3.setVisible(true);
               }
               if (i == 3) {
                   imageDice4.setImage(image);
                   dice4.setVisible(true);
               }
               if (i == 4) {
                   imageDice5.setImage(image);
                   dice5.setVisible(true);
               }
               if (i == 5) {
                   imageDice6.setImage(image);
                   dice6.setVisible(true);
               }
               if (i == 6) {
                   imageDice7.setImage(image);
                   dice7.setVisible(true);
               }
               if (i == 7) {
                   imageDice8.setImage(image);
                   dice8.setVisible(true);
               }
               if (i == 8) {
                   imageDice9.setImage(image);
                   dice9.setVisible(true);
               }
           }
           catch (FileNotFoundException e) {
               e.printStackTrace();
           }
           finally {
               fileStream.close();
           }
       }

        currPoolSize = getDraftPool().getDraftPool().size();

        if (currPoolSize == 0) {
            cleanDraftPool();
        }

        else if (currPoolSize < prevPoolSize) {
            unvisibleDraftPool(prevPoolSize);
            prevPoolSize = currPoolSize;
        }

        else {
            prevPoolSize = currPoolSize;
        }


    }


    public void setToken(int token) {
        tokensNumber.setText("" + token);
    }

    public void updatePattern(PatternCard patternCard) {

        setToken(mainController.getTokens());

        if (guiState == ViewState.EGLOMISEEND) {
            removeDiceOnPattern(indexPatternStartOne);
        }
        if (guiState == ViewState.COPPEREND) {
            removeDiceOnPattern(indexPatternStartOne);
        }
        if (guiState == ViewState.LATHEKINENDTWO) {
            removeDiceOnPattern(indexPatternStartOne);
            removeDiceOnPattern(indexPatternStartTwo);
        }


        for (int index = 0; index < patternCard.getPattern().size(); index++) {

            if (!patternCard.getPattern().get(index).isBoxEmpty()) {

                String filename = patternCard.getDice(index).toStringGui();

                try {
                    loadDiceOnPattern(index, filename);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void updateCost(int toolIndex) {

        if (toolIndex == 0) {

            if (costTool1.getText().equalsIgnoreCase("" + 1)) {
                costTool1.setText(null);
                costTool1.setText("" + 2);
            }
            else {
                costTool1.setText("" + 2);
            }
        }
        if (toolIndex == 1) {

            if (costTool2.getText().equalsIgnoreCase("" + 1)) {
                costTool2.setText(null);
                costTool2.setText("" + 2);
            }
            else {
                costTool2.setText("" + 2);
            }

        }
        if (toolIndex == 2) {
            if (costTool3.getText().equalsIgnoreCase("" + 1)) {
                costTool3.setText(null);
                costTool3.setText("" + 2);
            }
            else {
                costTool3.setText("" + 2);
            }
        }
    }



    public void updateRoundTracker(RoundTracker roundTracker) {

        setRoundTracker(roundTracker);

    }

    public void textChooseMsg() {

        enablePool();
        enablePattern();
        enableTool();
        skip.setDisable(false);
        roll.setDisable(true);
        next.setDisable(true);
        setGuiState(ViewState.MOVE);
        textGame.setText("Click a Dice & the Card position or a Tool, then NEXT");
    }

    public void errorStateDice() {
        if (guiState == ViewState.GLAZINGHAMMER) {
            setGuiState(ViewState.ERRORTOOL);
        }
        else {
            setGuiState(ViewState.ERRORDICE);
        }
    }

    public void textMoveMsg() {

        enablePool();
        enablePattern();

        if (guiState == ViewState.DICEMOVE) {
           mainController.getConnection().setMoveToServer(mainController.getPlayerID(), indexPool, indexPattern);
        }
        else if (guiState == ViewState.ERRORDICE) {
            skip.setDisable(false);
            roll.setDisable(true);
            next.setDisable(true);
            disableTool();
            textGame.setText("Click the Dice & the correct position, then NEXT");
        }
        else {
           setGuiState(ViewState.DICEMOVESECOND);
           skip.setDisable(false);
           roll.setDisable(true);
           next.setDisable(true);
           disableTool();
           textGame.setText("Click the Dice & the Card position, then NEXT");
        }
    }

    public void errorStateTool() {
        setGuiState(ViewState.ERRORTOOL);
    }

    public void toolMoveMsg() {

        disablePattern();
        disablePool();

        if (guiState == ViewState.TOOLMOVE) {
            updateCost(indexTool);
            mainController.getConnection().useToolCardToServer(mainController.getPlayerID(), indexTool);
        }
        else if (guiState == ViewState.ERRORTOOL) {

            setGuiState(ViewState.TOOLMOVESECOND);
            enableTool();
            next.setDisable(true);
            textGame.setText("Click on another tool card (if) you want to use it, then NEXT or SKIP");
        }
        else {
            setGuiState(ViewState.TOOLMOVESECOND);
            enableTool();
            next.setDisable(true);
            textGame.setText("Click on the tool card (if) you want to use it, then NEXT or SKIP");
        }
    }

    public void endTimer() {
        AlertBox.display("Timer", "You're time is over man!");
    }

    public void endOtherTimer(String playerName) {
        AlertBox.display("Timer", "The time of " + playerName + " ended");
    }

    public void showRank(List<Player> playerList) throws IOException{
        pane.setDisable(true);
        EndGameScene.setPlayerList(playerList);
        EndGameScene.display();
    }

    protected void textGrozingMsg() {
        enablePool();
        setToken(mainController.getTokens());
        disablePattern();
        roll.setDisable(true);
        next.setDisable(true);
        disableTool();
        setGuiState(ViewState.GROZINGPOOL);
        textGame.setText("Click the dice you want to increase/decrease, then NEXT");
    }

    protected void textEglomiseMsg() {
        disablePool();
        enablePattern();
        setToken(mainController.getTokens());
        roll.setDisable(true);
        next.setDisable(true);
        disableTool();
        setGuiState(ViewState.EGLOMISESTART);
        textGame.setText("Click the dice you want to move, and where you want to move it, then NEXT");
    }

    protected void textCopperFoilMsg() {
        disablePool();
        enablePattern();
        roll.setDisable(true);
        next.setDisable(true);
        disableTool();
        setGuiState(ViewState.COPPERSTART);
        textGame.setText("Click the dice you want to move, and where you want to move it, then NEXT");
    }

    protected void textLathekinMsg() {
        disablePool();
        enablePattern();
        disableTool();
        roll.setDisable(true);
        next.setDisable(true);
        setGuiState(ViewState.LATHEKINSTARTONE);
        textGame.setText("Click the 1st dice you want to move, and where you want to move it");
    }

    protected void textLensCutterMsg() {
        enablePool();
        disablePattern();
        disableTool();
        roll.setDisable(true);
        next.setDisable(true);
        setGuiState(ViewState.LENSCUTTERPOOL);
        textGame.setText("Click the dice in the Draft Pool, and in the Round Tracker, then NEXT");

    }

    protected void textFluxBrushMsg() {
        disablePattern();
        disableTool();
        enablePool();
        roll.setDisable(true);
        next.setDisable(true);
        setGuiState(ViewState.FLUXBRUSH);
        textGame.setText("Click the dice you want to re-roll, then NEXT");
    }

    protected void textGlazingHammerMsg() {
        disablePattern();
        disableTool();
        disablePool();
        next.setDisable(true);
        setGuiState(ViewState.GLAZINGHAMMER);
        textGame.setText("Click ROLL to re-roll all dice in the pool, then NEXT");
        roll.setDisable(false);
    }

    protected void textRunningPliersMsg() {
        disablePattern();
        disableTool();
        enablePool();
        next.setDisable(true);
        roll.setDisable(true);
        setGuiState(ViewState.RUNNINGPOOL);
        textGame.setText("Click a dice and the position, then NEXT");
    }

    protected void textCorkBackedMsg() {
        disablePattern();
        disableTool();
        enablePool();
        next.setDisable(true);
        roll.setDisable(true);
        setGuiState(ViewState.CORKPOOL);
        textGame.setText("Click the dice in the pool and a position not adjacent, then NEXT");
    }

    protected void textGrindingStoneMsg() {
        disablePattern();
        disableTool();
        enablePool();
        next.setDisable(true);
        roll.setDisable(true);
        setGuiState(ViewState.GRINDING);
        textGame.setText("Click the dice you want to flip, then NEXT");
    }

    protected void textFluxRemoverMsg(DiceColor color) {
        disablePattern();
        disableTool();
        enablePool();
        next.setDisable(true);
        roll.setDisable(true);
        setGuiState(ViewState.FLUXPOOL);
        ToolCardRequest.setColor(color);
        textGame.setText("Select the dice you want to return to the Dice Bag, then NEXT");
    }

    protected void textTapWheelMsg() {
        disablePattern();
        disableTool();
        disablePool();
        next.setDisable(true);
        roll.setDisable(true);
        setGuiState(ViewState.TAPNUMBER);
        textGame.setText("Click the number on the Box, then NEXT");
        ToolCardRequest.setToolNumber(12);
        try {
            pane.setDisable(true);
            ToolCardRequest.display();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void textTapWheelFirstDice() {
        disableTool();
        disablePool();
        enablePattern();
        next.setDisable(true);
        roll.setDisable(true);
        setGuiState(ViewState.TAPSTARTONE);
        textGame.setText("Click the 1st dice and where you want to move it, then NEXT");
    }

    private void textTapWheelSecondDice() {
        disableTool();
        disablePool();
        enablePattern();
        next.setDisable(true);
        roll.setDisable(true);
        setGuiState(ViewState.TAPSTARTTWO);
        textGame.setText("Click the 2nd dice and where yuo want to move it, then NEXT");

    }

}
