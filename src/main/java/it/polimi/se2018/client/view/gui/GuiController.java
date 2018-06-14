package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.client.network.rmi.RmiHandler;
import it.polimi.se2018.client.network.socket.SocketHandler;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Components.RoundTracker;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class GuiController extends View {


    private ClientInterface connection;
    private static final int SOCKETPORT = 8888;
    private static SocketHandler serverSocket;
    private static RmiHandler serverRmi;
    private static String host = "localhost";
    private String name;
    private Stage primaryStage;
    private String connectionType;

    //-------------------------gui start-----------------


    public GuiController(String connectionType, Stage primaryStage) throws IOException{

        //Application.launch(Gui.class);
        this.primaryStage = primaryStage;

        this.showMode();

        this.connectionType = connectionType;

        if (connectionType.equalsIgnoreCase("socket")) {

            serverSocket = new SocketHandler(host, SOCKETPORT, this);

            this.setConnection(serverSocket);

            Thread socketThread = new Thread(serverSocket);
            socketThread.start();

            Thread viewSocketThread = new Thread(this);
            viewSocketThread.start();

        }

        if (connectionType.equalsIgnoreCase("rmi")) {

            serverRmi = new RmiHandler(this);

            this.setConnection(serverRmi);

            Thread viewRmiThread = new Thread(this);
            viewRmiThread.start();


        }



    }


    private void showMode() throws IOException {

        primaryStage.setTitle("Sagrada Game");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mode.fxml"));
        AnchorPane root = (AnchorPane) loader.load();

        Scene scene1 = new Scene(root);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    //----------------fxml controller----------------
    @FXML
    private RadioButton singlePlayer;

    @FXML
    private RadioButton multiPlayer;

    @FXML
    private TextField txtName;

    @FXML
    void handleMode(ActionEvent event) {

        this.name = txtName.getText();

        if(singlePlayer.isSelected()){
            getConnection().setSinglePlayerMode(getPlayerID(), true);
        }
        if(multiPlayer.isSelected()){
            getConnection().setSinglePlayerMode(getPlayerID(), false);
        }


    }

    public String getName() {
        return name;
    }



    private void setName(){
        System.out.println("name" + name);
        getConnection().setPlayerNameToServer(getName(), getPlayerID());

    }




    @Override
    public void run() {



    }





    //--------------method to change scene-------------------


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

    }

    @Override
    public void showGameStarted() {

    }

    @Override
    public void showNameChoose() {

        setName();
    }

    @Override
    public void showName() {

        System.out.println("Player name: " + super.getPlayerName());

    }

    @Override
    public void showNameOther(String name) {

    }

    @Override
    public void showNameError() {

    }

    @Override
    public void showPrivateCard(PrivateObjectiveCard privateObjectiveCard) {

    }

    @Override
    public void showPublicCard(List<PublicObjectiveCard> publicList) {

    }

    @Override
    public void showPatternList(List<PatternCard> patternCards) {

    }

    @Override
    public void showPattern(PatternCard patternCard) {

    }

    @Override
    public void showOtherPattern(PatternCard patternCard, String playerName) {

    }

    @Override
    public void showPatternUpdate(PatternCard patternCard) {

    }

    @Override
    public void showTokens(int tokensNumber) {

    }

    @Override
    public void showCurrentRound(int round) {

    }

    @Override
    public void showCurrentTurn() {

    }

    @Override
    public void showOtherCurrentTurn(String username) {

    }

    @Override
    public void showRollCommand() {

    }

    @Override
    public void showDraftPool(DraftPool draftPool) {

    }

    @Override
    public void showChooseCommand() {

    }

    @Override
    public void showMoveCommand(int poolSize) {

    }

    @Override
    public void showIndexPoolCommand(int poolsize) {

    }

    @Override
    public void showIndexPatternCommand() {

    }

    @Override
    public void showToolCommand(List<ToolCard> toolCards) {

    }

    @Override
    public void showToolChooseCommand() {

    }

    @Override
    public void showToolCostCommand(List<Integer> toolCost, int indexTool) {

    }

    @Override
    public void showRoundTracker(RoundTracker roundTracker) {

    }

    @Override
    public void showFinalRank(List<Player> playerList) {

    }

    @Override
    public void showWinner() {

    }

    @Override
    public void showLosers() {

    }

    @Override
    public void showTimer() {

    }

    @Override
    public void showOtherTimer(String playerName) {

    }

    @Override
    public void showToolCards(List<ToolCard> toolCardList) {

    }

    @Override
    public void showTokenError() {

    }

    @Override
    public void showGrozingRequest(int poolSize) {

    }

    @Override
    public void showGrozingCommand() {

    }

    @Override
    public void showEglomiseStart() {

    }

    @Override
    public void showEglomiseEnd() {

    }

    @Override
    public void showCopperFoilStart() {

    }

    @Override
    public void showCopperFoilEnd() {

    }

    @Override
    public void showLathekinStart() {

    }

    @Override
    public void showLathekinStartTwo() {

    }

    @Override
    public void showLathekinEnd() {

    }

    @Override
    public void showLathekinEndTwo() {

    }

    @Override
    public void showLensCutterRequest(int poolSize, List<Integer> round) {

    }

    @Override
    public void showLensCutterRound(List<Integer> round) {

    }

    @Override
    public void showLensCutterDice(List<Integer> round, int roundIndex) {

    }

    @Override
    public void showFluxBrushRequest(int poolSize) {

    }

    @Override
    public void showGlazingHammerRequest() {

    }

    @Override
    public void showRunningPliersPool(int poolSize) {

    }

    @Override
    public void showRunningPliersEnd() {

    }

    @Override
    public void showCorkBackedPool(int poolSize) {

    }

    @Override
    public void showCorkBackedEnd() {

    }

    @Override
    public void showGrindingStoneRequest(int poolSize) {

    }

    @Override
    public void showFluxRemoverPool(DiceColor color, int poolSize) {

    }

    @Override
    public void showFluxRemoverValue() {

    }

    @Override
    public void showTapWheelNumber() {

    }

    @Override
    public void showTapWheelStartOne() {

    }

    @Override
    public void showTapWheelEndOne() {

    }

    @Override
    public void showTapWheelStartTwo() {

    }

    @Override
    public void showTapWheelEndTwo() {

    }

    @Override
    public void showBoard(RoundTracker roundTracker, DraftPool draftPool) {

    }

    @Override
    public void showInvalidMove(String msg) {

    }

    @Override
    public void showSinglePlayerRequest() {

    }

    @Override
    public void showDifficultyRequest() {

    }

    @Override
    public void showPrivateSingle(List<PrivateObjectiveCard> publicList) {

    }

    @Override
    public void showToolSingleCommand(List<ToolCard> toolList, int poolSize) {

    }

    @Override
    public void showToolSingleChoose() {

    }

    @Override
    public void showToolSingleDice() {

    }

    @Override
    public void showMatchError() {

    }

    @Override
    public void showEndSinglePlayer(boolean winner, int playerPoints, int gameThreshold) {

    }
}