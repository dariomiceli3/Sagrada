package it.polimi.se2018.client.view.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class BoardController {


    public class Board {

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
        private ImageView roundTracker;

        @FXML
        private ImageView toolCard1;

        @FXML
        private ImageView toolCard2;

        @FXML
        private ImageView toolCard3;

        @FXML
        private ImageView publicCard1;

        @FXML
        private TextField textGame;

        @FXML
        private Button skip;

        @FXML
        private Button exit;

        @FXML
        private ToggleButton cell1;

        @FXML
        private ToggleGroup patternToggleGroup;

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
        private ToggleButton round1;

        @FXML
        private ToggleGroup roundToggleGroup;

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
        private ToggleButton dice1;

        @FXML
        private ImageView imageDice1;

        @FXML
        private ToggleGroup poolToggleGroup;

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
        private Button next;

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
        void exitButtonSelected(ActionEvent event) {

        }

        @FXML
        void handleCellEvent(ActionEvent event) {

        }

        @FXML
        void handleDicePool(ActionEvent event) {

        }

        @FXML
        void handlePrivateUnzoom(MouseEvent event) {

        }

        @FXML
        void handlePrivateZoom(MouseEvent event) {

        }

        @FXML
        void handleRoundButton(ActionEvent event) {

        }

        @FXML
        void handleTool1(MouseEvent event) {

        }

        @FXML
        void handleTool2(MouseEvent event) {

        }

        @FXML
        void handleTool3(MouseEvent event) {

        }

        @FXML
        void handleUnzoomPublic1(MouseEvent event) {

        }

        @FXML
        void handleUnzoomPublic2(MouseEvent event) {

        }

        @FXML
        void handleUnzoomPublic3(MouseEvent event) {

        }

        @FXML
        void handleUnzoomTool1(MouseEvent event) {

        }

        @FXML
        void handleUnzoomTool2(MouseEvent event) {

        }

        @FXML
        void handleUnzoomTool3(MouseEvent event) {

        }

        @FXML
        void handleUpdatePattern2(MouseEvent event) {

        }

        @FXML
        void handleUpdatePattern3(MouseEvent event) {

        }

        @FXML
        void handleUpdatePattern4(MouseEvent event) {

        }

        @FXML
        void handleZoomPublic1(MouseEvent event) {

        }

        @FXML
        void handleZoomPublic2(MouseEvent event) {

        }

        @FXML
        void handleZoomPublic3(MouseEvent event) {

        }

        @FXML
        void nextButtonSelected(ActionEvent event) {

        }

        @FXML
        void skipButtonSelected(ActionEvent event) {

        }

    }

}
