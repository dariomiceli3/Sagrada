package it.polimi.se2018.client.view.gui;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.client.network.ClientInterface;
import it.polimi.se2018.client.network.rmi.Ping;
import it.polimi.se2018.client.network.rmi.RmiHandler;
import it.polimi.se2018.client.network.socket.SocketHandler;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

public class GuiController extends View {

    private final Logger log = Logger.getLogger(GuiController.class.getName());
    private ClientInterface connection;
    private int SOCKETPORT;
    private String host;
    private static SocketHandler serverSocket;
    private static RmiHandler serverRmi;
    private Stage stage;
    private static BoardController board;
    private String name;
    private SimpleBooleanProperty nameSetted = new SimpleBooleanProperty(false);
    private Integer selectedDifficulty;
    private boolean singlePlayer;
    private boolean gameStarted;
    private boolean maxPlayers;
    private boolean customCard;
    private int tokens;
    private List<ToolCard>  toolList;
    private List<PatternCard>  patternList;
    private List<PublicObjectiveCard>  publicCardList;
    private List<PrivateObjectiveCard> privateCardSingle;
    private PrivateObjectiveCard privateCard;
    private RoundTracker roundTracker;
    private PatternCard patternCurrent;
    private PatternCard patternID0;
    private PatternCard patternID1;
    private PatternCard patternID2;
    private PatternCard patternID3;
    private String nameID0;
    private String nameID1;
    private String nameID2;
    private String nameID3;


    public Stage getStage() {
        return stage;
    }

    public String getName() {
        return name;
    }

    public PrivateObjectiveCard getPrivateCard() {
        return privateCard;
    }

    public List<PatternCard> getPatternList() {
        return patternList;
    }

    public RoundTracker getRoundTracker(){
        return roundTracker;
    }

    List<ToolCard> getToolList() {
        return toolList;
    }

    List<PublicObjectiveCard> getPublicCardList() {
        return publicCardList;
    }

    List<PrivateObjectiveCard> getPrivateCardSingle() {
        return privateCardSingle;
    }
    PatternCard getPatternCurrent() {
        return patternCurrent;
    }
    PatternCard getPatternID0() {
        return patternID0;
    }
    PatternCard getPatternID1() {
        return patternID1;
    }
    PatternCard getPatternID2() {
        return patternID2;
    }
    PatternCard getPatternID3() {
        return patternID3;
    }
    int getTokens() {
        return tokens;
    }
    String getNameID0() {
        return nameID0;
    }
    String getNameID1() {
        return nameID1;
    }
    String getNameID2() {
        return nameID2;
    }
    String getNameID3() {
        return nameID3;
    }
    private void setNameID0(String nameID0) {
        this.nameID0 = nameID0;
    }
    private void setNameID1(String nameID1) {
        this.nameID1 = nameID1;
    }
    private void setNameID2(String nameID2) {
        this.nameID2 = nameID2;
    }
    private void setNameID3(String nameID3) {
        this.nameID3 = nameID3;
    }

    private void setTokens(int tokens) {
        this.tokens = tokens;
    }


    static void setBoard(BoardController board) {
        GuiController.board = board;
    }
    public boolean isSinglePlayer() {
        return singlePlayer;
    }
    public Integer getSelectedDifficulty() {
        return selectedDifficulty;
    }
    boolean isCustomCard() {
        return customCard;
    }
    private void setCustomCard(boolean customCard) {
        this.customCard = customCard;
    }

    //-------------------------gui start-----------------

    public void setConnectionTypeAndStage(String connectionType, Stage primaryStage,boolean singlePlayer) throws IOException{

        Gson gson = new Gson();
        InputStream fileStream = GuiController.class.getResourceAsStream("/json/settings" + ".json");
        JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);
        this.SOCKETPORT = jsonObject.get("socketPort").getAsInt();
        this.host = jsonObject.get("ipAddress").getAsString();

        this.stage = primaryStage;
        this.singlePlayer = singlePlayer;

        if (connectionType.equalsIgnoreCase("socket")) {

            serverSocket = new SocketHandler(host, SOCKETPORT, this);

            this.setConnection(serverSocket);

            Thread socketThread = new Thread(serverSocket);
            socketThread.start();

            //Thread viewSocketThread = new Thread(this);
            //viewSocketThread.start();

        }

        if (connectionType.equalsIgnoreCase("rmi")) {

            Ping ping = new Ping();
            serverRmi = new RmiHandler(this, ping);
            ping.setConnection(serverRmi);
            this.setConnection(serverRmi);

            Thread viewRmiThread = new Thread(this);
            viewRmiThread.start();
        }
    }



    //----------------mode.fxml controller----------------


    @FXML
    private TextField txtName;
    @FXML
    private Button playButton;
    //-----fxml single player----
    @FXML
    private ComboBox<Integer> comboBox;
    private ObservableList<Integer> comboBoxData = FXCollections.observableArrayList();


    public void initialize() {

        gameStarted = false;
        maxPlayers = false;

        playButton.disableProperty().bind(txtName.textProperty().isEmpty().or(nameSetted));

        playButton.disableProperty().addListener(
                (observable, oldValue, newValue) -> log.info(newValue.toString())

        );
    }


    @FXML
    void handlePlayButton(ActionEvent event) {

        if (gameStarted) {
            if (singlePlayer) {
                getConnection().setDifficultyToServer(getPlayerID(), selectedDifficulty);
            }
            this.name = txtName.getText();
            getConnection().setPlayerNameToServer(getName(), getPlayerID());
            nameSetted.setValue(true);
            AlertBox.display("Name Choose", "Name entered, some seconds and will go");
        }
        else if (maxPlayers) {
            AlertBox.display("Error", "The number of player reached the maximum, retry later!");
        }
        else {
            AlertBox.display("Name Choose", "You have to wait till the game is started!");
        }

    }

    @FXML
    void handleDifficultyBox(ActionEvent event) {
        this.selectedDifficulty = comboBox.getSelectionModel().getSelectedItem();
        txtName.setDisable(false);
    }

    private void setMode() {

        Platform.runLater(() -> {
            if (singlePlayer) {
                getConnection().setSinglePlayerMode(getPlayerID(), true);
            }
            else {
                getConnection().setSinglePlayerMode(getPlayerID(), false);

            }
        });
    }


    public void setPattern(int indexPattern){
        getConnection().setPatternCardToServer(indexPattern, getPlayerID());
    }

    public void setCustomPattern(PatternCard pattern, boolean customCard) {
        getConnection().setPatternCustomToServer(getPlayerID(), pattern);
        setCustomCard(customCard);
    }



    //--------------getter and setter-------------------

    @Override
    public void setConnection(ClientInterface connection) {
        this.connection = connection;
    }

    @Override
    public ClientInterface getConnection() {
        return connection;
    }



    //--------------------show methods for update scene-------------------------

    @Override
    public void run() {

    }

    @Override
    public void showID() {

    }

    @Override
    public void showSinglePlayerRequest() {

        setMode();

        Platform.runLater(() -> {
            if (!singlePlayer) {
                AlertBox.display("Name Choose", "Please wait, the game will start in a few seconds");
            }
        });

    }

    @Override
    public void showGameStarted() {

        gameStarted = true;

        Platform.runLater(() -> {
            if (singlePlayer) {
                comboBoxData.add(1);
                comboBoxData.add(2);
                comboBoxData.add(3);
                comboBoxData.add(4);
                comboBoxData.add(5);
                comboBox.setItems(comboBoxData);
                comboBox.setVisible(true);
                txtName.setDisable(true);
            }
            AlertBox.display("Name Choose", "Game is started, enter your name");
        });
    }

    @Override
    public void showNameChoose() {


    }

    @Override
    public void showName() {

        log.info("Player name: " + super.getPlayerName());

    }

    @Override
    public void showNameOther(String playerName) {

        /*Platform.runLater(new Runnable() {
            @Override
            public void run() {
                AlertBox.display("Name Choose", "Another player connected with name " + playerName);
            }
        });*/

    }

    @Override
    public void showNameError() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                AlertBox.display("Error", "Name already chosen");
            }
        });

    }

    @Override
    public void showPrivateCard(PrivateObjectiveCard privateObjectiveCard) {

        log.info(privateObjectiveCard.getColour().toString());

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                privateCard = privateObjectiveCard;
            }
        });

    }

    @Override
    public void showPublicCard(List<PublicObjectiveCard> publicList) throws IOException{

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                publicCardList = publicList;
            }
        });


    }

    @Override
    public void showPatternList(List<PatternCard> patternCards) throws IOException {


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                patternList = patternCards;
            try {
                patternScene();
            }catch (IOException e){
                log.warning(e.getMessage());
            }


            }
        });

    }

    @Override
    public void showPattern(PatternCard patternCard) throws IOException {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                patternCurrent = patternCard;
            }
        });

    }

    @Override
    public void showOtherStartPattern(PatternCard patternCard, int ID) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (ID == 0) {
                    patternID0 = patternCard;
                }
                if (ID == 1) {
                    patternID1 = patternCard;
                }
                if (ID == 2) {
                    patternID2 = patternCard;
                }
                if (ID == 3) {
                    patternID3 = patternCard;
                }
            }
        });



    }

    @Override
    public void showOtherPattern(PatternCard patternCard, String playerName, int ID) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                if (ID == 0) {
                    patternID0 = patternCard;
                    setNameID0(playerName);
                }
                if (ID == 1) {
                    patternID1 = patternCard;
                    setNameID1(playerName);
                }
                if (ID  == 2) {
                    patternID2 = patternCard;
                    setNameID2(playerName);
                }
                if (ID == 3) {
                    patternID3 = patternCard;
                    setNameID3(playerName);
                }
            }
        });

    }

    @Override
    public void showPatternUpdate(PatternCard patternCard) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.updatePattern(patternCard);
            }
        });

    }

    @Override
    public void showTokens(int tokensNumber) {
        setTokens(tokensNumber);
    }

    @Override
    public void showStartScene() throws IOException {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    boardScene();
                } catch (IOException e) {
                    log.warning(e.getMessage());
                }
            }
        });

    }

    @Override
    public void showCurrentRound(int round) {


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.updateRound(round);
            }
        });


    }

    @Override
    public void showCurrentTurn() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.updateTurn();
            }
        });

    }

    @Override
    public void showOtherCurrentTurn(String username) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.updateOtherTurn(username);
            }
        });

    }

    @Override
    public void showRollCommand() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textRollMsg();
            }
        });

    }

    @Override
    public void showDraftPool(DraftPool draftPool) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    board.updateDraftPool(draftPool);
                }
                catch (IOException e) {
                    log.warning(e.getMessage());
                }
            }
        });

    }

    @Override
    public void showChooseCommand() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    board.textChooseMsg();
                } catch (IOException e) {
                    log.warning(e.getMessage());
                }
            }
        });
    }

    @Override
    public void showMoveCommand(int poolSize) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    board.textMoveMsg();
                } catch (IOException e) {
                    log.warning(e.getMessage());
                }
            }
        });

    }

    @Override
    public void showIndexPoolCommand(int poolsize) {
        //non usare
    }

    @Override
    public void showIndexPatternCommand() {
        //non usare
    }

    @Override
    public void showToolCommand(List<ToolCard> toolCards) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.toolMoveMsg();
            }
        });
    }

    @Override
    public void showToolChooseCommand() {
        // non usare

    }

    @Override
    public void showToolCostCommand(List<Integer> toolCost, int indexTool) {
        // non usare

    }

    @Override
    public void showRoundTracker(RoundTracker roundTracker) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.updateRoundTracker(roundTracker);
            }
        });


    }

    @Override
    public void showFinalRank(List<Player> playerList, boolean ended) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    getConnection().setEndGameTimer(getPlayerID());
                    EndGameScene.setSinglePlayer(false);
                    if(ended) {

                        board.showRank(playerList, true);

                    }else {

                            EndGameScene.setFinish(ended);
                            EndGameScene.setPlayerList(playerList);
                            EndGameScene.display();
                    }
                }
                catch (IOException e){
                    log.warning(e.getMessage());
                }
            }
        });

    }

    @Override
    public void showWinner() {
        //non usare
    }

    @Override
    public void showLosers() {
        // non usare
    }

    @Override
    public void showTimer() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.endTimer();
            }
        });

    }

    @Override
    public void showOtherTimer(String playerName) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.endOtherTimer(playerName);
            }
        });
    }

    @Override
    public void showToolCards(List<ToolCard> toolCardList) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                toolList = toolCardList;
            }
        });


    }

    @Override
    public void showTokenError() {

        board.errorStateTool();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                AlertBox.display("Error", "You have NOT enough tokens!");

            }
        });

    }

    @Override
    public void showGrozingRequest(int poolSize) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textGrozingMsg();
            }
        });

    }

    @Override
    public void showGrozingCommand() {
        // non usare
    }

    @Override
    public void showEglomiseStart() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textEglomiseMsg();
            }
        });
    }

    @Override
    public void showEglomiseEnd() {
        // non usare
    }

    @Override
    public void showCopperFoilStart() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textCopperFoilMsg();
            }
        });

    }

    @Override
    public void showCopperFoilEnd() {
        // non usare
    }

    @Override
    public void showLathekinStart() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textLathekinMsg();
            }
        });

    }

    @Override
    public void showLathekinStartTwo() {
        // non usare
    }

    @Override
    public void showLathekinEnd() {
        // non usare
    }

    @Override
    public void showLathekinEndTwo() {
        // non usare
    }

    @Override
    public void showLensCutterRequest(int poolSize, List<Integer> round) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textLensCutterMsg();
            }
        });

    }

    @Override
    public void showLensCutterRound(List<Integer> round) {
        //non usare
    }

    @Override
    public void showLensCutterDice(List<Integer> round, int roundIndex) {
        //non usare
    }

    @Override
    public void showFluxBrushRequest(int poolSize) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textFluxBrushMsg();
            }
        });
    }

    @Override
    public void showGlazingHammerRequest() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textGlazingHammerMsg();
            }
        });
    }

    @Override
    public void showRunningPliersPool(int poolSize) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textRunningPliersMsg();
            }
        });

    }

    @Override
    public void showRunningPliersEnd() {
        // non usare
    }

    @Override
    public void showCorkBackedPool(int poolSize) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textCorkBackedMsg();
            }
        });
    }

    @Override
    public void showCorkBackedEnd() {

        // non usare

    }

    @Override
    public void showGrindingStoneRequest(int poolSize) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textGrindingStoneMsg();
            }
        });

    }

    @Override
    public void showFluxRemoverPool(DiceColor color, int poolSize) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textFluxRemoverMsg(color);
            }
        });

    }

    @Override
    public void showFluxRemoverValue() {

        //non usare

    }

    @Override
    public void showTapWheelNumber() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.textTapWheelMsg();
            }
        });
    }

    @Override
    public void showTapWheelStartOne() {

        // non usare
    }

    @Override
    public void showTapWheelEndOne() {
        // non usare
    }

    @Override
    public void showTapWheelStartTwo() {
        // non usare
    }

    @Override
    public void showTapWheelEndTwo() {
        // non usare
    }

    @Override
    public void showBoard(RoundTracker roundTracker, DraftPool draftPool) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    board.updateDraftPool(draftPool);
                    board.updateRoundTracker(roundTracker);
                } catch (IOException e) {
                    log.warning(e.getMessage());
                }
            }
        });

    }

    @Override
    public void showInvalidMove(String msg) {

        board.errorStateDice();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                AlertBox.display("Error", msg);

            }
        });
    }


    //------------single  player----------------------------------------------------

    @Override
    public void showDifficultyRequest() {

        // non usare

    }

    @Override
    public void showPrivateSingle(List<PrivateObjectiveCard> publicList) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                privateCardSingle = publicList;
            }
        });
    }

    @Override
    public void showToolSingleCommand(List<ToolCard> toolList, int poolSize) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    board.textToolSinglePlayerMsg();
                } catch (IOException e) {
                    log.warning(e.getMessage());
                }
            }
        });

    }

    @Override
    public void showToolSingleChoose() {
        // non usare
    }

    @Override
    public void showToolSingleDice() {
        // non usare
    }

    @Override
    public void showMatchError() {

        board.errorMatchDice();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                AlertBox.display("Error", "The dice selected doesn't match the color of the tool card");
            }
        });

    }

    @Override
    public void showEndSinglePlayer(boolean winner, int playerPoints, int gameThreshold) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                getConnection().setEndGameTimer(getPlayerID());
                EndGameScene.setSinglePlayer(true);
                EndGameScene.setWinnerSingle(winner);
                EndGameScene.setPlayerPoints(playerPoints);
                EndGameScene.setGameThreshold(gameThreshold);
                EndGameScene.setFinish(true);
                try {
                    EndGameScene.display();
                } catch (IOException e) {
                    log.warning(e.getMessage());
                }
            }
        });

    }

    //---------------disconnection---------------------------------------------

    @Override
    public void showMaxPlayerLogin() {

        maxPlayers = true;

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                AlertBox.display("Error", "The number of player reached the maximum, retry later!");
            }
        });
    }

    @Override
    public void showExitPlayer(String playerName) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                AlertBox.display("Event",  "The player " + playerName + " disconnected from the game");
            }
        });

    }

    @Override
    public void showReconnectPlayer(String playerName) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                AlertBox.display("Event", "The player " + playerName + " reconnected to the game");
            }
        });

    }

    @Override
    public void showNotPermittedReconnection() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                AlertBox.display("Error", "There's no available player to reconnect");
            }
        });
    }

    @Override
    public void showReload(Player currPlayer,boolean singlePlay, boolean gameStart, List<ToolCard> tool, List<PublicObjectiveCard> publicCard, List<Player> players) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {

                    // private boolean gameStarted;
                    // private boolean maxPlayers;
                    //private boolean customCard;
                    name = currPlayer.getPlayerName();
                    singlePlayer = singlePlay;
                    gameStarted = gameStart;
                    toolList = tool;
                    publicCardList = publicCard;
                    privateCard = currPlayer.getPrivate();
                    patternCurrent = currPlayer.getPattern();
                    customCard = patternCurrent.isCustom();
                    tokens = currPlayer.getTokensNumber();
                    for(Player player : players) {
                        if (player.getPlayerID() == 0) {
                            patternID0 = player.getPattern();
                            nameID0 = player.getPlayerName();
                        }
                        if (player.getPlayerID() == 1) {
                            patternID1 = player.getPattern();
                            nameID1 = player.getPlayerName();
                        }
                        if (player.getPlayerID() == 2) {
                            patternID2 = player.getPattern();
                            nameID2 = player.getPlayerName();
                        }
                        if (player.getPlayerID() == 3) {

                            patternID3 = player.getPattern();
                            nameID3 = player.getPlayerName();
                        }

                    }
                    boardScene();
                } catch (IOException e) {
                    log.warning(e.getMessage());
                }
            }

        });
    }


    //-------------switch scene method----------


    private void patternScene() throws IOException{
        ChoosePattern.setMainController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CardDraw.fxml"));
        Parent root1 = (Parent) loader.load();

        Scene scene = new Scene(root1);
        stage.setTitle("Sagrada Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    private void boardScene() throws IOException {

        BoardController.setMainController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board.fxml"));
        Parent root2 = (Parent) loader.load();
        Scene gameBoard = new Scene(root2);
        stage.setTitle("Sagrada Game");
        stage.setScene(gameBoard);
        stage.setResizable(false);
        stage.show();
    }


}

