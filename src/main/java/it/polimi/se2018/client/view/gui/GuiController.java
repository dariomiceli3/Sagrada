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

/**
 * Class GuiController: the class responsible of starting the gui, establish a connection with the server and of the switch
 * of the scene depending on the state of the game. The class extends the abstract class and implements all the generics
 * method to update the view depending on the event received from the server
 * @see java.lang.Runnable
 * @author fadda-miceli-mundo
 */
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

    /**
     * method that provides the caller the stage of the game
     * @return stage of the game
     */
    Stage getStage() {
        return stage;
    }

    /**
     * method that provides the caller the list of the tool cards
     * @return list of the tool cards
     */
    List<ToolCard> getToolList() {
        return toolList;
    }

    /**
     * method that provides the caller the list of the public cards
     * @return list of the public cards
     */
    List<PublicObjectiveCard> getPublicCardList() {
        return publicCardList;
    }

    /**
     * method that provides the caller the list of the private cards in single player mode
     * @return list of private cards
     */
    List<PrivateObjectiveCard> getPrivateCardSingle() {
        return privateCardSingle;
    }

    /**
     * method that provides the caller the current pattern
     * @return current pattern
     */
    PatternCard getPatternCurrent() {
        return patternCurrent;
    }

    /**
     * method that provides the caller the pattern of the player with id 0
     * @return pattern card
     */
    PatternCard getPatternID0() {
        return patternID0;
    }
    /**
     * method that provides the caller the pattern of the player with id 1
     * @return pattern card
     */
    PatternCard getPatternID1() {
        return patternID1;
    }
    /**
     * method that provides the caller the pattern of the player with id 2
     * @return pattern card
     */
    PatternCard getPatternID2() {
        return patternID2;
    }
    /**
     * method that provides the caller the pattern of the player with id 3
     * @return pattern card
     */
    PatternCard getPatternID3() {
        return patternID3;
    }

    /**
     * method that provides the caller the name of the player with id 0
     * @return name of the player
     */
    String getNameID0() {
        return nameID0;
    }
    /**
     * method that provides the caller the name of the player with id 1
     * @return name of the player
     */
    String getNameID1() {
        return nameID1;
    }

    /**
     * method that provides the caller the name of the player with id 2
     * @return name of the player
     */
    String getNameID2() {
        return nameID2;
    }

    /**
     * method that provides the caller the name of the player with id 3
     * @return name of the player
     */
    String getNameID3() {
        return nameID3;
    }

    /**
     * method that provides the caller the number of tokens
     * @return number of tokens
     */
    int getTokens() {
        return tokens;
    }

    /**
     * method that allows to set the controller
     * @param board board of the game
     */
    static void setBoard(BoardController board) {
        GuiController.board = board;
    }

    /**
     * method that provides the caller if the player use a custom card
     * @return boolean custom card
     */
    boolean isCustomCard() {
        return customCard;
    }


    /**
     * method that provides the caller if the modality is in single player
     * @return boolean single player
     */
    public boolean isSinglePlayer() {
        return singlePlayer;
    }

    /**
     * method that provides the caller the name of the player
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * method that provides the caller the private card
     * @return private card
     */
    public PrivateObjectiveCard getPrivateCard() {
        return privateCard;
    }

    /**
     * method that provides the caller the list of the pattern cards
     * @return list of the pattern cards
     */
    public List<PatternCard> getPatternList() {
        return patternList;
    }

    /**
     * method that allows to set the name of the player with id 0
     * @param nameID0 name of the player
     */
    private void setNameID0(String nameID0) {
        this.nameID0 = nameID0;
    }

    /**
     * method that allows to set the name of the player with id 1
     * @param nameID1 name of the player
     */
    private void setNameID1(String nameID1) {
        this.nameID1 = nameID1;
    }

    /**
     * method that allows to set the name of the player with id 2
     * @param nameID2 name of the player
     */
    private void setNameID2(String nameID2) {
        this.nameID2 = nameID2;
    }

    /**
     * method that allows to set the name of the player with id 3
     * @param nameID3 name of the player
     */
    private void setNameID3(String nameID3) {
        this.nameID3 = nameID3;
    }

    /**
     * method that allows to set the number of tokens
     * @param tokens number of tokens
     */
    private void setTokens(int tokens) {
        this.tokens = tokens;
    }

    /**
     * method that allows to set if the pattern card used by the player is custom or not
     * @param customCard boolean custom vard
     */
    private void setCustomCard(boolean customCard) {
        this.customCard = customCard;
    }

    //-------------------------gui start-----------------

    /**
     * method that allows to set the type of the connection, the stage and the mode of the game
     * @param connectionType type of the connection
     * @param primaryStage stage of the game
     * @param singlePlayer boolean that indicates if the mode is single player
     */
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

    /**
     * method that allows to set the pattern scene
     * @throws IOException Something goes wrong
     */
    private void patternScene() throws IOException{
        ChoosePattern.setMainController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CardDraw.fxml"));
        Parent root1 = loader.load();

        Scene scene = new Scene(root1);
        stage.setTitle("Sagrada Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    /**
     * method that allows to set the board scene
     * @throws IOException Something goes wrong
     */
    private void boardScene() throws IOException {

        BoardController.setMainController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board.fxml"));
        Parent root2 = loader.load();
        Scene gameBoard = new Scene(root2);
        stage.setTitle("Sagrada Game");
        stage.setScene(gameBoard);
        stage.setResizable(false);
        stage.show();
    }

    //----------------methods for setting----------------------------------

    /**
     * method that allows to set the mode
     */
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

    /**
     * method that allows to set the pattern
     * @param indexPattern index of the pattern
     */
    public void setPattern(int indexPattern){
        getConnection().setPatternCardToServer(indexPattern, getPlayerID());
    }

    /**
     * method that allows to set the custom pattern
     * @param pattern pattern card to set
     */
    void setCustomPattern(PatternCard pattern) {
        getConnection().setPatternCustomToServer(getPlayerID(), pattern);
        setCustomCard(true);
    }


    //----------------mode.fxml controller----------------

    /***
     * method that initializes the scene
     */
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

    /**
     * method that handle the click of the play button to set the name of the player to the server
     */
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
            AlertBox.display(error, "You have to wait till the match is started!");
        }

    }

    /**
     * method that handle the difficulty selected from the user in the combo box for the single player mode
     */
    @FXML
    void handleDifficultyBox() {
        this.selectedDifficulty = comboBox.getSelectionModel().getSelectedItem();
        txtName.setDisable(false);
    }


    //-------------------override of the view's abstract class methods

    @Override
    public void run() {
        log.info("runner run");
    }

    /**
     * method that allows to set the connection of the client
     * @param connection client to set
     */
    @Override
    public void setConnection(ClientInterface connection) {
        this.connection = connection;
    }

    /**
     * method that allows to show the id of the player
     */
    @Override
    public ClientInterface getConnection() {
        return connection;
    }

    /**
     * method that allows to show the id of the player
     */
    @Override
    public void showID() {
        log.info("Player GUI id set");
    }

    /**
     * method that allows the request for the single player mode
     */
    @Override
    public void showSinglePlayerRequest() {

        setMode();

        Platform.runLater(() -> {
            if (!singlePlayer) {
                AlertBox.display("Name Choose", "Please wait, the match will start in a few seconds");
            }
        });

    }

    /**
     * method that alert the game is started
     */
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
            AlertBox.display("Name Choose", "Match is started, enter your name");
        });
    }

    /**
     * method that alter of the choose of the name
     */
    @Override
    public void showNameChoose() {
        log.info("name choose GUI");
    }

    /**
     * method that alert the name is set
     */
    @Override
    public void showName() {
        nameSet.setValue(true);
    }

    /**
     * method that alert the name of the player is setted
     * @param playerName of the other player
     */
    @Override
    public void showNameOther(String playerName) {
        log.info("Name other");
    }

    /**
     * method that alert that the chosen name is already used
     */
    @Override
    public void showNameError() {
        nameSet.setValue(false);
        Platform.runLater(() -> AlertBox.display(error, "Name already chosen"));
    }

    /**
     * method that provide the private card to the view
     * @param privateObjectiveCard private card to show
     */
    @Override
    public void showPrivateCard(PrivateObjectiveCard privateObjectiveCard) {
        Platform.runLater(() -> privateCard = new PrivateObjectiveCard(privateObjectiveCard));
    }

    /**
     * method that provide the public card to the view
     * @param publicList list of public cards
     */
    @Override
    public void showPublicCard(List<PublicObjectiveCard> publicList) {
        Platform.runLater(() -> {
            publicCardList = new ArrayList<>();
            for (PublicObjectiveCard publicCard : publicList) {
                publicCardList.add(new PublicObjectiveCard(publicCard));
            }
        });
    }

    /**
     * method that provide the patter card to the view
     * @param patternCards list of pattern cards
     */
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

    /**
     * method that provide the pattern card chose
     * @param patternCard pattern chosen by the player
     */
    @Override
    public void showPattern(PatternCard patternCard)  {
        Platform.runLater(() -> patternCurrent = new PatternCard(patternCard));
    }

    /**
     * method that show the pattern chosen by the other player
     * @param patternCard pattern card chosen by the player
     * @param id id of the player
     */
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

    /**
     * method that shows the update of the  pattern card of the other player during the name
     * @param patternCard pattern card of a player
     * @param playerName name of the player
     * @param id id of the player
     */
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

    /**
     * method that update the pattern card of the player
     * @param patternCard pattern card of a player
     */
    @Override
    public void showPatternUpdate(PatternCard patternCard) {

        Platform.runLater(() -> board.updatePattern(new PatternCard(patternCard)));
    }

    /**
     * method that update the number of tokens of the player
     * @param tokensNumber number of tokens
     */
    @Override
    public void showTokens(int tokensNumber) {
        setTokens(tokensNumber);
    }

    /**
     * method that alter that the game board is ready to show
     */
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

    /**
     * method that alert of the current round in the game
     * @param round int round of the game
     */
    @Override
    public void showCurrentRound(int round) {
        Platform.runLater(() -> board.updateRound(round));
    }

    /**
     * method that alert of the current turn in the game
     */
    @Override
    public void showCurrentTurn() {
        Platform.runLater(() -> board.updateTurn());
    }

    /**
     * method that alert the other player of current turn player name
     * @param username name of the selected player
     */
    @Override
    public void showOtherCurrentTurn(String username) {
        Platform.runLater(() -> board.updateOtherTurn(username));
    }

    /**
     * method that alert the player to roll the draft pool
     */
    @Override
    public void showRollCommand() {
        Platform.runLater(() -> board.textRollMsg());
    }

    /**
     * method that show the update of the draft pool
     * @param draftPool draft pool of the game
     */
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

    /**
     * method that show the user the choose of the move to do
     */
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

    /**
     * method that show the player the dice move message
     * @param poolSize size of the pool
     */
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

    /**
     * method that show the player to choose a dice from the pool
     * @param poolSize size of the pool
     */
    @Override
    public void showIndexPoolCommand(int poolSize) {
        log.info("pool size GUI");
    }

    /**
     * method that show the player where to put the dice
     */
    @Override
    public void showIndexPatternCommand() {
        log.info("index pattern command GUI");
    }

    /**
     * method that show the tool command to the player
     * @param toolCards list of tool cards
     */
    @Override
    public void showToolCommand(List<ToolCard> toolCards) {
        Platform.runLater(() -> board.toolMoveMsg());
    }

    /**
     * method that show the player the choose of the tool card to use
     */
    @Override
    public void showToolChooseCommand() {
        log.info("tool choose command received GUI");
    }

    /**
     * method that show the player the cost a tool card to use
     * @param toolCost list of tool card's costs
     * @param indexTool index of the selected tool
     */
    @Override
    public void showToolCostCommand(List<Integer> toolCost, int indexTool) {
        log.info("tool cost received GUI");
    }

    /**
     * method that show the round tracker
     * @param roundTracker round tracker of the game
     */
    @Override
    public void showRoundTracker(RoundTracker roundTracker) {
        Platform.runLater(() -> board.updateRoundTracker(new RoundTracker(roundTracker)));
    }

    /**
     * method that show the final rank of the game
     * @param playerList list of the players
     * @param ended boolean that indicates if the game is ended
     */
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

    /**
     * method that show the winner
     */
    @Override
    public void showWinner() {
        log.info("show winner received GUI");
    }

    /**
     * method that show the loser
     */
    @Override
    public void showLosers() {
        log.info("show losers received GUI");
    }

    /**
     * method that show the end of the timer to the player
     */
    @Override
    public void showTimer() {
        Platform.runLater(() -> board.endTimer());
    }

    /**
     * method that show the end of the timer of a player
     */
    @Override
    public void showOtherTimer(String playerName) {
        Platform.runLater(() -> board.endOtherTimer(playerName));
    }

    /**
     * method that show the tool cards list to the player
     * @param toolCardList list of tool cards
     */
    @Override
    public void showToolCards(List<ToolCard> toolCardList) {
        Platform.runLater(() -> {
            toolList = new ArrayList<>();
            for (ToolCard tool : toolCardList) {
                toolList.add(new ToolCard(tool));
            }
        });
    }

    /**
     * method that show the error of the use of a tool card
     */
    @Override
    public void showTokenError() {

        board.errorStateTool();

        Platform.runLater(() -> AlertBox.display(error, "You have NOT enough tokens!"));
    }

    /**
     * method that show the grozing pliers request tool card
     * @param poolSize size of the pool
     */
    @Override
    public void showGrozingRequest(int poolSize) {
        Platform.runLater(() -> board.textGrozingMsg());
    }

    /**
     * method that show the grozing pliers command to do for the tool card
     */
    @Override
    public void showGrozingCommand() {
        log.info("grozing command gui received");
    }

    /**
     * method that show the eglomise brush tool card dice to move
     */
    @Override
    public void showEglomiseStart() {
        Platform.runLater(() -> board.textEglomiseMsg());
    }

    /**
     * method that show the eglomise brush tool card where to move the dice
     */
    @Override
    public void showEglomiseEnd() {
        log.info("eglomise end gui received");
    }

    /**
     * method that show the copper foil tool card dice to move
     */
    @Override
    public void showCopperFoilStart() {
        Platform.runLater(() -> board.textCopperFoilMsg());
    }

    /**
     * method that show the copper foil tool card where to move the dice
     */
    @Override
    public void showCopperFoilEnd() {
        log.info("copper foil end received");
    }

    /**
     * method that show the lathekin first dice to move
     */
    @Override
    public void showLathekinStart() {
        Platform.runLater(() -> board.textLathekinMsg());
    }

    /**
     * method that show the lathekin second dice to move
     */
    @Override
    public void showLathekinStartTwo() {
        log.info("lathekin start two");
    }

    /**
     * method that show the lathekin tool card where to move the dice
     */
    @Override
    public void showLathekinEnd() {
        log.info("lathekin end one");
    }

    /**
     * method that show the lathekin tool card where to move the dice
     */
    @Override
    public void showLathekinEndTwo() {
        log.info("lathekin end two");
    }

    /**
     * method that show the lens cutter tool card the dice to use
     */
    @Override
    public void showLensCutterRequest(int poolSize, List<Integer> round) {
        Platform.runLater(() -> board.textLensCutterMsg());
    }

    /**
     * method that show the decision of the round in the round tracker
     * @param round round of the round tracker
     */
    @Override
    public void showLensCutterRound(List<Integer> round) {
        log.info("lens cutter round");
    }

    /**
     * method that show the choose of the dice in the current round
     * @param round round of the round tracker
     * @param roundIndex index of the round
     */
    @Override
    public void showLensCutterDice(List<Integer> round, int roundIndex) {
        log.info("lens cutter dice");
    }

    /**
     * method that show the flux brush tool card request for deciding which dice from the pool
     * @param poolSize size of the pool
     */
    @Override
    public void showFluxBrushRequest(int poolSize) {
        Platform.runLater(() -> board.textFluxBrushMsg());
    }

    /**
     * method that show the glazing hammer tool card request to re-shuffle the dice in the pool
     */
    @Override
    public void showGlazingHammerRequest() {
        Platform.runLater(() -> board.textGlazingHammerMsg());
    }

    /**
     * method that show the running pliers tool card request command for the draft pool
     * @param poolSize size of the pool
     */
    @Override
    public void showRunningPliersPool(int poolSize) {
        Platform.runLater(() -> board.textRunningPliersMsg());
    }

    /**
     * method that show the request where to put the dice chose in the draft pool
     */
    @Override
    public void showRunningPliersEnd() {
        log.info("running pliers end");
    }

    /**
     * method that allows to show the index of the pool
     * @param poolSize size of the pool
     */
    @Override
    public void showCorkBackedPool(int poolSize) {
        Platform.runLater(() -> board.textCorkBackedMsg());
    }

    /**
     * method that allows to show the index where to move the dice in the pattern card
     */
    @Override
    public void showCorkBackedEnd() {
        log.info("corkbacked end");
    }

    /**
     * method that allows to show the request for Cork Backed tool card
     * @param poolSize size of the pool
     */
    @Override
    public void showGrindingStoneRequest(int poolSize) {
        Platform.runLater(() -> board.textGrindingStoneMsg());
    }

    /**
     * method that allows to show the color of the selected dice e the index of the pool
     * @param color color of the selected dice
     * @param poolSize index of the pool
     */
    @Override
    public void showFluxRemoverPool(DiceColor color, int poolSize) {
        Platform.runLater(() -> board.textFluxRemoverMsg(color));
    }

    /**
     * method that allows to show the new value of the selected dice
     */
    @Override
    public void showFluxRemoverValue() {
        log.info("flux remover value");
    }

    /**
     * method that allows to show the number of dice the player wants to move
     */
    @Override
    public void showTapWheelNumber() {
        Platform.runLater(() -> board.textTapWheelMsg());
    }


    /**
     * method that allows to show the first index where to pick up the dice in Tap Wheel tool card
     */
    @Override
    public void showTapWheelStartOne() {
        log.info("tap wheel start one");
    }

    /**
     * method that allows to show the first index where to move the dice in Tap Wheel tool card
     */
    @Override
    public void showTapWheelEndOne() {
        log.info("tap wheel end one");
    }

    /**
     * method that allows to show the second index where to pick up the dice in Tap Wheel tool card
     */
    @Override
    public void showTapWheelStartTwo() {
        log.info("tap wheel start two");
    }

    /**
     * method that allows to show the second index where to move the dice in Tap Wheel tool card
     */
    @Override
    public void showTapWheelEndTwo() {
        log.info("tap wheel end two");
    }

    /**
     * method that allows to show the board of the game
     * @param roundTracker round tracker of the game
     * @param draftPool draft pool of the game
     */
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

    /**
     * method that allows to show an invalid move
     * @param msg message to show
     */
    @Override
    public void showInvalidMove(String msg) {

        board.errorStateDice();

        Platform.runLater(() -> AlertBox.display(error, msg));
    }


    //------------single  player----------------------------------------------------

    /**
     * method that allows to show request for the single player mode
     */
    @Override
    public void showDifficultyRequest() {
        log.info("difficulty single player gui");
    }


    /**
     * method that allows to show the list of the private cards
     * @param publicList list of private cards
     */
    @Override
    public void showPrivateSingle(List<PrivateObjectiveCard> publicList) {
        Platform.runLater(() -> {
            privateCardSingle = new ArrayList<>();
            for (PrivateObjectiveCard privateCardObjective : publicList) {
                privateCardSingle.add(new PrivateObjectiveCard(privateCardObjective));
            }
        });
    }

    /**
     * method that allows to show the possiblity to choose a tool card
     * @param toolListCard list of the tool cards
     * @param poolSize size of the pool
     */
    @Override
    public void showToolSingleCommand(List<ToolCard> toolListCard, int poolSize) {

        Platform.runLater(() -> {
            try {
                toolList = new ArrayList<>();
                for (ToolCard tool : toolListCard) {
                    toolList.add(new ToolCard(tool));
                }
                board.textToolSinglePlayerMsg();
            } catch (IOException e) {
                log.warning(e.getMessage());
            }
        });

    }


    /**
     * method that allows to show the selected tool card by the player
     */
    @Override
    public void showToolSingleChoose() {
        log.info("tool single choose");
    }


    /**
     * method that allows to show the selected dice to use the tool card
     */
    @Override
    public void showToolSingleDice() {
        log.info("tool single dice");
    }

    /**
     * method that allows to show that the selected dice isn't right to use the tool card
     */
    @Override
    public void showMatchError() {

        board.errorMatchDice();

        Platform.runLater(() -> AlertBox.display(error, "The dice selected doesn't match the color of the tool card"));
    }

    /**
     * method that allows to show if the player won the game
     * @param winner boolean that indicates if the player won
     * @param playerPoints total points of the player
     * @param gameThreshold threshold to overcome to win
     */
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

    /**
     * method that allows to show that the limit of the player reached the maximum
     */
    @Override
    public void showMaxPlayerLogin() {

        maxPlayers = true;

        Platform.runLater(() -> AlertBox.display(error, "The number of player reached the maximum, retry later!"));
    }

    /**
     * method that allows to show the player that exited the game
     * @param playerName name of the player who exited the game
     */
    @Override
    public void showExitPlayer(String playerName) {
        Platform.runLater(() -> AlertBox.display("Event",  "The player " + playerName + " disconnected from the game"));
    }

    /**
     * method that allows to show the player that reconnected to the game
     * @param playerName name of the player that reconnected to the game
     */
    @Override
    public void showReconnectPlayer(String playerName) {
        Platform.runLater(() -> AlertBox.display("Event", "The player " + playerName + " reconnected to the game"));
    }

    /**
     * method that allows to show that a player can't reconnect to a game because no players exit
     */
    @Override
    public void showNotPermittedReconnection() {
        Platform.runLater(() -> AlertBox.display(error, "There's no available player to reconnect"));
    }

    /**
     * method that allows to reload all the scene of the player who reconnected to the game
     * @param currPlayer current player
     * @param singlePlay boolean that indicates if the modality is single player
     * @param gameStart boolean that indicates if the game is started
     * @param toolCards list of tool cards
     * @param publicCard list of public cards
     * @param players list of players
     */
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

