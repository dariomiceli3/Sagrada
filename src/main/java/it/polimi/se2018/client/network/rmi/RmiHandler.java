package it.polimi.se2018.client.network.rmi;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.client.network.ClientInterface;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.network.rmi.RmiServerInterface;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Logger;

public class RmiHandler implements ClientInterface {

    private final Logger log = Logger.getLogger(RmiHandler.class.getName());
    private RmiServerInterface stub;
    private View view;
    private Ping ping;

    // creazione del collegamento con il lato server

    public RmiHandler(View view, Ping ping) {

        try {
            this.view = view;
            this.ping = ping;

            Gson gson = new Gson();
            InputStream fileStream = RmiHandler.class.getResourceAsStream("/json/settings" + ".json");
            JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);

            String ipAddress = jsonObject.get("ipAddress").getAsString();

            this.stub = (RmiServerInterface) Naming.lookup("//" + ipAddress+ "/Sagrada");

            RmiClientImpl clientRmi = new RmiClientImpl(this.view, this.ping);

            stub.registerRmiClient(clientRmi);
        }
        catch (MalformedURLException e){
            log.info("URL not found");
        }
        catch (RemoteException e) {
            log.info("Connection error client");
        }
        catch (NotBoundException e) {
            log.info("Reference not correct");
        }
    }



    //---------------------ovveride metodi di client interface-------------------------
    // metodi invocabili dal client sul server



    @Override
    public void setSinglePlayerMode(int id, boolean singlePlayer) {
        try {
            stub.setSinglePlayerMode(id, singlePlayer);
        } catch (RemoteException e) {
            log.info("Error in setting player mode");
            log.warning(e.getMessage());
        }
    }


    @Override
    public void setPlayerNameToServer(String username, int id) {
        try{
            stub.setPlayerNameToServer(username, id);
        }
        catch (RemoteException e) {
            log.info("Error in setting name");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void setPatternCardToServer(int indexPatternChoose, int id) {
        try {
            stub.setPatternCardToServer(indexPatternChoose, id);
        }
        catch (RemoteException e) {
            log.info("Error in setting pattern card");
            log.warning(e.getMessage());
        }


    }

    @Override
    public void setDraftPoolToServer(int id) {
        try {
            stub.setDraftPoolToServer(id);
        }
        catch (RemoteException e) {
            log.info("Error in setting pattern card");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void setChooseToServer(int id, int step) {
        try{
            stub.setChooseToServer(id, step);
        }
        catch (RemoteException e) {
            log.info("Error in setting choose");
            log.warning(e.getMessage());
        }
    }

    @Override
    public void setMoveToServer(int id, int indexPool, int indexPattern) {
        try{
            stub.setMoveToServer(id, indexPool, indexPattern);
        }
        catch (RemoteException e) {
            log.info("Error in setting move");
            log.warning(e.getMessage());
        }


    }

    @Override
    public void setStartToolToServer(int id) {
        try{
            stub.setStartToolToServer(id);
        }
        catch (RemoteException e) {
            log.info("Error in setting tool");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void setNextTurnToServer(int id) {
        try{
            stub.setNextTurnToServer(id);
        }
        catch (RemoteException e) {
            log.info("Error in setting turn");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void setNoTokenToServer(int id) {
        try{
            stub.setNoTokenToServer(id);
        }
        catch (RemoteException e) {
            log.info("Error in setting no tool");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useToolCardToServer(int id, int indexTool) {
        try{
            stub.useToolCardToServer(id, indexTool);
        }
        catch (RemoteException e) {
            log.info("Error in setting using tool");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useGrozingToolCard(int id, int indexPool, int increase) {
        try{
            stub.useGrozingToolCard(id, indexPool, increase);
        }
        catch (RemoteException e) {
            log.info("Error in setting grozing ");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useEglomiseToolCard(int id, int indexStart, int indexEnd) {
        try{
            stub.useEglomiseToolCard(id, indexStart, indexEnd);
        }
        catch (RemoteException e) {
            log.info("Error in setting eglomise");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useCopperFoilToolCard(int id, int indexStart, int indexEnd) {
        try{
            stub.useCopperFoilToolCard(id, indexStart, indexEnd);
        }
        catch (RemoteException e) {
            log.info("Error in setting copper foil");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useLathekinToolCard(int id, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        try{
            stub.useLathekinToolCard(id, indexStartOne, indexEndOne, indexStartTwo, indexEndTwo);
        }
        catch (RemoteException e) {
            log.info("Error in setting lathekin");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useLensCutterToolCard(int id, int indexPool, int indexRound, int indexPosition) {
        try{
            stub.useLensCutterToolCard(id, indexPool, indexRound, indexPosition);
        }
        catch (RemoteException e) {
            log.info("Error in setting lens cutter");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useFluxBrushToolCard(int id, int indexPool) {
        try{
            stub.useFluxBrushToolCard(id, indexPool);
        }
        catch (RemoteException e) {
            log.info("Error in setting flux brush");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useGlazingHammerToolCard(int id) {
        try{
            stub.useGlazingHammerToolCard(id);
        }
        catch (RemoteException e) {
            log.info("Error in setting glazing hammer");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useRunningPliersToolCard(int id, int indexPool, int indexPattern) {
        try{
            stub.useRunningPliersToolCard(id, indexPool, indexPattern);
        }
        catch (RemoteException e) {
            log.info("Error in setting running pliers");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useCorkBackedToolCard(int id, int indexPool, int indexPattern) {
        try{
            stub.useCorkBackedToolCard(id, indexPool, indexPattern);
        }
        catch (RemoteException e) {
            log.info("Error in setting cork backed");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useGrindingStoneToolCard(int id, int indexPool) {
        try{
            stub.useGrindingStoneToolCard(id, indexPool);
        }
        catch (RemoteException e) {
            log.info("Error in setting grinding stone");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useFluxRemoverToolCard(int id, int indexPool, int diceValue) {
        try {
            stub.useFluxRemoverToolCard(id, indexPool, diceValue);
        }
        catch (RemoteException e) {
            log.info("Error in setting flux remover");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useTapWheelToolCard(int id, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        try{
            stub.useTapWheelToolCard(id, number, indexStartOne, indexEndOne, indexStartTwo, indexEndTwo);
        }
        catch (RemoteException e) {
            log.info("Error in setting tap wheel");
            log.warning(e.getMessage());
        }
    }

    @Override
    public void setEndGameTimer(int id) {
        try {
            stub.setEndGameTimer(id);
        }
        catch (RemoteException e) {
            log.info("Error in setting end game timer");
            log.warning(e.getMessage());
        }
    }


    //-------------------------single player----------------------

    @Override
    public void setDifficultyToServer(int id, int difficulty) {
        try{
            stub.setDifficultyToServer(id, difficulty);
        }
        catch (RemoteException e) {
            log.info("Error in setting difficulty");
            log.warning(e.getMessage());
        }

    }

    @Override
    public void useToolSingleToServer(int id, int indexTool, int indexPool) {
        try{
            stub.useToolSingleToServer(id, indexTool, indexPool);
        }
        catch (RemoteException e) {
            log.info("Error in setting tool single player");
            log.warning(e.getMessage());
        }
    }

    //-----------------------custom card------------------------------------

    @Override
    public void setPatternCustomToServer(int id, PatternCard patternCard) {
        try {
            stub.setPatternCustomToServer(id, patternCard);
        }
        catch (RemoteException e) {
            log.info("error in setting custom card");
            log.warning(e.getMessage());
        }

    }

    //----------------------disconnection------------------------------------

    @Override
    public void setExitToServer(int id) {
        try {
            stub.setExitToServer(id);
        }
        catch (RemoteException e) {
            log.info("Error in exit the game");
            log.warning(e.getMessage());
        }
    }

    @Override
    public void setReconnectToServer(int id) {
        try {
            stub.setReconnectToServer(id);
        }catch (RemoteException e) {
            log.info("Error in reconnect in the game");
            log.warning(e.getMessage());
        }
    }

    void clientPing(int id) {
        try {
            stub.clientPing(id);
        }
        catch (RemoteException e) {
            log.info("Error in client ping");
            log.warning(e.getMessage());
        }
    }
}

