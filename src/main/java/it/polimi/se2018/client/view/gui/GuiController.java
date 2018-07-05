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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static java.lang.System.out;

public class GuiController extends View {

    private final Logger log = Logger.getLogger(GuiController.class.getName());
    private static final String error = "Error";
    private boolean singlePlayer;
    private boolean gameStarted;
    private boolean maxPlayers;
    private boolean customCard;
    private int tokens;
    private static BoardController board;
    private Stage stage;
    private String name;
    private SimpleBooleanProperty nameSet = new SimpleBooleanProperty(false);
    private Integer selectedDifficulty;
    private ClientInterface connection;
    private List<ToolCard>  toolList;
    private List<PatternCard>  patternList;
    private List<PublicObjectiveCard>  publicCardList;
    private List<PrivateObjectiveCard> privateCardSingle;
    private PrivateObjectiveCard privateCard;
    private PatternCard patternCurrent;
    private PatternCard patternID0;
    private PatternCard patternID1;
    private PatternCard patternID2;
    private PatternCard patternID3;
    private String nameID0;
    private String nameID1;
    private String nameID2;
    private String nameID3;


    Stage getStage() {
        return stage;
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
    int getTokens() {
        return tokens;
    }
    static void setBoard(BoardController board) {
        GuiController.board = board;
    }
    boolean isCustomCard() {
        return customCard;
    }



    public boolean isSinglePlayer() {
        return singlePlayer;
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
    private void setCustomCard(boolean customCard) {
        this.customCard = customCard;
    }

    //-------------------------gui start-----------------

    public void setConnectionTypeAndStage(String connectionType, Stage primaryStage,boolean singlePlayer) {

        Gson gson = new Gson();
        InputStream fileStream = GuiController.class.getResourceAsStream("/json/settings" + ".json");
        JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);
        final int SOCKETPORT = jsonObject.get("socketPort").getAsInt();
        String host = jsonObject.get("ipAddress").getAsString();

        this.stage = primaryStage;
        this.singlePlayer = singlePlayer;

        if (connectionType.equalsIgnoreCase("socket")) {

            SocketHandler serverSocket = new SocketHandler(host, SOCKETPORT, this);

            this.setConnection(serverSocket);

            Thread socketThread = new Thread(serverSocket);
            socketThread.start();

            //Thread viewSocketThread = new Thread(this);
            //viewSocketThread.start();
        }

        if (connectionType.equalsIgnoreCase("rmi")) {

            Ping ping = new Ping();
            RmiHandler serverRmi = new RmiHandler(this, ping);
            ping.setConnection(serverRmi);
            this.setConnection(serverRmi);

            Thread viewRmiThread = new Thread(this);
            viewRmiThread.start();
        }
    }

    //-------------switch scene method--------------------------------


    private void patternScene() throws IOException{
        ChoosePattern.setMainController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CardDraw.fxml"));
        Parent root1 = loader.load();

        Scene scene = new Scene(root1);
        stage.setTitle("Sagrada GameController");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    private void boardScene() throws IOException {

        BoardController.setMainController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board.fxml"));
        Parent root2 = loader.load();
        Scene gameBoard = new Scene(root2);
        stage.setTitle("Sagrada GameController");
        stage.setScene(gameBoard);
        stage.setResizable(false);
        stage.show();
    }

    //----------------methods for setting----------------------------------

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

    void setCustomPattern(PatternCard pattern) {
        getConnection().setPatternCustomToServer(getPlayerID(), pattern);
        setCustomCard(true);
    }


    //----------------mode.fxml controller----------------

    public void initialize() {

        gameStarted = false;
        maxPlayers = false;

        playButton.disableProperty().bind(txtName.textProperty().isEmpty().or(nameSet));

        playButton.disableProperty().addListener(
                (observable, oldValue, newValue) -> out.println(newValue)

        );
    }


    @FXML
    private TextField txtName;
    @FXML
    private Button playButton;
    //-----fxml single player----
    @FXML
    private ComboBox<Integer> comboBox;
    private ObservableList<Integer> comboBoxData = FXCollections.observableArrayList();


    @FXML
    void handlePlayButton() {

        if (gameStarted) {
            if (singlePlayer) {
                getConnection().setDifficultyToServer(getPlayerID(), selectedDifficulty);
            }
            this.name = txtName.getText();
            getConnection().setPlayerNameToServer(getName(), getPlayerID());
            nameSet.setValue(true);
            AlertBox.display("Name", "Name entered, some seconds and will go");
        }
        else if (maxPlayers) {
            AlertBox.display(error, "The number of player reached the maximum, retry later!");
        }
        else {
            AlertBox.display(error, "You have to wait till the game is started!");
        }

    }

    @FXML
    void handleDifficultyBox() {
        this.selectedDifficulty = comboBox.getSelectionModel().getSelectedItem();
        txtName.setDisable(false);
    }


    //-----------------ovveride di view methods

    @Override
    public void run() {
        log.info("runner run");
    }

    @Override
    public void setConnection(ClientInterface connection) {
        this.connection = connection;
    }

    @Override
    public ClientInterface getConnection() {
        return connection;
    }


    @Override
    public void showID() {
        log.info("Player GUI id set");
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
            AlertBox.display("Name Choose", "GameController is started, enter your name");
        });
    }

    @Override
    public void showNameChoose() {
        log.info("name choose GUI");
    }

    @Override
    public void showName() {
        nameSet.setValue(true);
    }

    @Override
    public void showNameOther(String playerName) {
        log.info("Name other");
    }

    @Override
    public void showNameError() {
        nameSet.setValue(false);
        Platform.runLater(() -> AlertBox.display(error, "Name already chosen"));
    }

    @Override
    public void showPrivateCard(PrivateObjectiveCard privateObjectiveCard) {
        Platform.runLater(() -> privateCard = new PrivateObjectiveCard(privateObjectiveCard));
    }

    @Override
    public void showPublicCard(List<PublicObjectiveCard> publicList) {
        Platform.runLater(() -> {
            publicCardList = new ArrayList<>();
            for (PublicObjectiveCard publicCard : publicList) {
                publicCardList.add(new PublicObjectiveCard(publicCard));
            }
        });
    }

    @Override
    public void showPatternList(List<PatternCard> patternCards)  {
        Platform.runLater(() -> {
            patternList = new ArrayList<>();
            for (PatternCard pattern : patternCards) {
                patternList.add(new PatternCard(pattern));
            }
            try {
                patternScene();
            }
            catch (IOException e){
                log.warning(e.getMessage());
            }
        });
    }

    @Override
    public void showPattern(PatternCard patternCard)  {
        Platform.runLater(() -> patternCurrent = new PatternCard(patternCard));
    }

    @Override
    public void showOtherStartPattern(PatternCard patternCard, int id) {

        Platform.runLater(() -> {
            if (id == 0) {
                patternID0 = new PatternCard(patternCard);
            }
            if (id == 1) {
                patternID1 = new PatternCard(patternCard);
            }
            if (id == 2) {
                patternID2 = new PatternCard(patternCard);
            }
            if (id == 3) {
                patternID3 = new PatternCard(patternCard);
            }
        });
    }

    @Override
    public void showOtherPattern(PatternCard patternCard, String playerName, int id) {

        Platform.runLater(() -> {
            if (id == 0) {
                patternID0 = new PatternCard(patternCard);
                setNameID0(playerName);
            }
            if (id == 1) {
                patternID1 = new PatternCard(patternCard);
                setNameID1(playerName);
            }
            if (id  == 2) {
                patternID2 = new PatternCard(patternCard);
                setNameID2(playerName);
            }
            if (id == 3) {
                patternID3 = new PatternCard(patternCard);
                setNameID3(playerName);
            }
        });

    }

    @Override
    public void showPatternUpdate(PatternCard patternCard) {

        Platform.runLater(() -> board.updatePattern(new PatternCard(patternCard)));
    }

    @Override
    public void showTokens(int tokensNumber) {
        setTokens(tokensNumber);
    }

    @Override
    public void showStartScene() {

        Platform.runLater(() -> {
            try {
                boardScene();
            } catch (IOException e) {
                log.warning(e.getMessage());
            }
        });

    }

    @Override
    public void showCurrentRound(int round) {
        Platform.runLater(() -> board.updateRound(round));
    }

    @Override
    public void showCurrentTurn() {
        Platform.runLater(() -> board.updateTurn());
    }

    @Override
    public void showOtherCurrentTurn(String username) {
        Platform.runLater(() -> board.updateOtherTurn(username));
    }

    @Override
    public void showRollCommand() {
        Platform.runLater(() -> board.textRollMsg());
    }

    @Override
    public void showDraftPool(DraftPool draftPool) {

        Platform.runLater(() -> {
            try {
                board.updateDraftPool(new DraftPool(draftPool));
            }
            catch (IOException e) {
                log.warning(e.getMessage());
            }
        });
    }

    @Override
    public void showChooseCommand() {

        Platform.runLater(() -> {
            try {
                board.textChooseMsg();
            } catch (IOException e) {
                log.warning(e.getMessage());
            }
        });
    }

    @Override
    public void showMoveCommand(int poolSize) {

        Platform.runLater(() -> {
            try {
                board.textMoveMsg();
            } catch (IOException e) {
                log.warning(e.getMessage());
            }
        });
    }

    @Override
    public void showIndexPoolCommand(int poolSize) {
        log.info("pool size GUI");
    }

    @Override
    public void showIndexPatternCommand() {
        log.info("index pattern command GUI");
    }

    @Override
    public void showToolCommand(List<ToolCard> toolCards) {
        Platform.runLater(() -> board.toolMoveMsg());
    }

    @Override
    public void showToolChooseCommand() {
        log.info("tool choose command received GUI");
    }

    @Override
    public void showToolCostCommand(List<Integer> toolCost, int indexTool) {
        log.info("tool cost received GUI");
    }

    @Override
    public void showRoundTracker(RoundTracker roundTracker) {
        Platform.runLater(() -> board.updateRoundTracker(new RoundTracker(roundTracker)));
    }

    @Override
    public void showFinalRank(List<Player> playerList, boolean ended) {

        Platform.runLater(() -> {
            try {
                getConnection().setEndGameTimer(getPlayerID());
                EndGameScene.setSinglePlayer(false);
                if(ended) {

                    board.showRank(playerList, true);

                }else {

                    EndGameScene.setFinish(false);
                    EndGameScene.setPlayerList(playerList);
                    EndGameScene.display();
                }
            }
            catch (IOException e){
                log.warning(e.getMessage());
            }
        });

    }

    @Override
    public void showWinner() {
        log.info("show winner received GUI");
    }

    @Override
    public void showLosers() {
        log.info("show losers received GUI");
    }

    @Override
    public void showTimer() {
        Platform.runLater(() -> board.endTimer());
    }

    @Override
    public void showOtherTimer(String playerName) {
        Platform.runLater(() -> board.endOtherTimer(playerName));
    }

    @Override
    public void showToolCards(List<ToolCard> toolCardList) {
        Platform.runLater(() -> {
            toolList = new ArrayList<>();
            for (ToolCard tool : toolCardList) {
                toolList.add(new ToolCard(tool));
            }
        });
    }

    @Override
    public void showTokenError() {

        board.errorStateTool();

        Platform.runLater(() -> AlertBox.display(error, "You have NOT enough tokens!"));
    }

    @Override
    public void showGrozingRequest(int poolSize) {
        Platform.runLater(() -> board.textGrozingMsg());
    }

    @Override
    public void showGrozingCommand() {
        log.info("grozing command gui received");
    }

    @Override
    public void showEglomiseStart() {
        Platform.runLater(() -> board.textEglomiseMsg());
    }

    @Override
    public void showEglomiseEnd() {
        log.info("eglomise end gui received");
    }

    @Override
    public void showCopperFoilStart() {
        Platform.runLater(() -> board.textCopperFoilMsg());
    }

    @Override
    public void showCopperFoilEnd() {
        log.info("copper foil end received");
    }

    @Override
    public void showLathekinStart() {
        Platform.runLater(() -> board.textLathekinMsg());
    }

    @Override
    public void showLathekinStartTwo() {
        log.info("lathekin start two");
    }

    @Override
    public void showLathekinEnd() {
        log.info("lathekin end one");
    }

    @Override
    public void showLathekinEndTwo() {
        log.info("lathekin end two");
    }

    @Override
    public void showLensCutterRequest(int poolSize, List<Integer> round) {
        Platform.runLater(() -> board.textLensCutterMsg());
    }

    @Override
    public void showLensCutterRound(List<Integer> round) {
        log.info("lens cutter round");
    }

    @Override
    public void showLensCutterDice(List<Integer> round, int roundIndex) {
        log.info("lens cutter dice");
    }

    @Override
    public void showFluxBrushRequest(int poolSize) {
        Platform.runLater(() -> board.textFluxBrushMsg());
    }

    @Override
    public void showGlazingHammerRequest() {
        Platform.runLater(() -> board.textGlazingHammerMsg());
    }

    @Override
    public void showRunningPliersPool(int poolSize) {
        Platform.runLater(() -> board.textRunningPliersMsg());
    }

    @Override
    public void showRunningPliersEnd() {
        log.info("running pliers end");
    }

    @Override
    public void showCorkBackedPool(int poolSize) {
        Platform.runLater(() -> board.textCorkBackedMsg());
    }

    @Override
    public void showCorkBackedEnd() {
        log.info("corkbacked end");
    }

    @Override
    public void showGrindingStoneRequest(int poolSize) {
        Platform.runLater(() -> board.textGrindingStoneMsg());
    }

    @Override
    public void showFluxRemoverPool(DiceColor color, int poolSize) {
        Platform.runLater(() -> board.textFluxRemoverMsg(color));
    }

    @Override
    public void showFluxRemoverValue() {
        log.info("flux remover value");
    }

    @Override
    public void showTapWheelNumber() {
        Platform.runLater(() -> board.textTapWheelMsg());
    }

    @Override
    public void showTapWheelStartOne() {
        log.info("tap wheel start one");
    }

    @Override
    public void showTapWheelEndOne() {
        log.info("tap wheel end one");
    }

    @Override
    public void showTapWheelStartTwo() {
        log.info("tap wheel start two");
    }

    @Override
    public void showTapWheelEndTwo() {
        log.info("tap wheel end two");
    }

    @Override
    public void showBoard(RoundTracker roundTracker, DraftPool draftPool) {

        Platform.runLater(() -> {
            try {
                board.updateDraftPool(new DraftPool(draftPool));
                board.updateRoundTracker(new RoundTracker(roundTracker));
            } catch (IOException e) {
                log.warning(e.getMessage());
            }
        });

    }

    @Override
    public void showInvalidMove(String msg) {

        board.errorStateDice();

        Platform.runLater(() -> AlertBox.display(error, msg));
    }


    //------------single  player----------------------------------------------------

    @Override
    public void showDifficultyRequest() {
        log.info("difficulty single player gui");
    }

    @Override
    public void showPrivateSingle(List<PrivateObjectiveCard> publicList) {
        Platform.runLater(() -> {
            privateCardSingle = new ArrayList<>();
            for (PrivateObjectiveCard privateCardObjective : publicList) {
                privateCardSingle.add(new PrivateObjectiveCard(privateCardObjective));
            }
        });
    }

    @Override
    public void showToolSingleCommand(List<ToolCard> toolList, int poolSize) {

        Platform.runLater(() -> {
            try {
                board.textToolSinglePlayerMsg();
            } catch (IOException e) {
                log.warning(e.getMessage());
            }
        });

    }

    @Override
    public void showToolSingleChoose() {
        log.info("tool single choose");
    }

    @Override
    public void showToolSingleDice() {
        log.info("tool single dice");
    }

    @Override
    public void showMatchError() {

        board.errorMatchDice();

        Platform.runLater(() -> AlertBox.display(error, "The dice selected doesn't match the color of the tool card"));
    }

    @Override
    public void showEndSinglePlayer(boolean winner, int playerPoints, int gameThreshold) {

        Platform.runLater(() -> {
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
        });
    }

    //---------------disconnection---------------------------------------------

    @Override
    public void showMaxPlayerLogin() {

        maxPlayers = true;

        Platform.runLater(() -> AlertBox.display(error, "The number of player reached the maximum, retry later!"));
    }

    @Override
    public void showExitPlayer(String playerName) {
        Platform.runLater(() -> AlertBox.display("Event",  "The player " + playerName + " disconnected from the game"));
    }

    @Override
    public void showReconnectPlayer(String playerName) {
        Platform.runLater(() -> AlertBox.display("Event", "The player " + playerName + " reconnected to the game"));
    }

    @Override
    public void showNotPermittedReconnection() {
        Platform.runLater(() -> AlertBox.display(error, "There's no available player to reconnect"));
    }

    @Override
    public void showReload(Player currPlayer, boolean singlePlay, boolean gameStart, List<ToolCard> toolCards, List<PublicObjectiveCard> publicCard, List<Player> players) {
        Platform.runLater(() -> {
            try {
                name = currPlayer.getPlayerName();
                singlePlayer = singlePlay;
                gameStarted = gameStart;
                toolList = new ArrayList<>();
                for (ToolCard toolCard : toolCards){
                    toolList.add(new ToolCard(toolCard));
                }
                publicCardList = new ArrayList<>();
                for (PublicObjectiveCard card : publicCard) {
                    publicCardList.add(new PublicObjectiveCard(card));
                }
                privateCard = new PrivateObjectiveCard(currPlayer.getPrivate());
                patternCurrent = new PatternCard(currPlayer.getPattern());
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
        });
    }

}

