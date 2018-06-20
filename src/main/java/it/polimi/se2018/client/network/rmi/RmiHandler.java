package it.polimi.se2018.client.network.rmi;


import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.network.rmi.RmiServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiHandler implements ClientInterface {

    private RmiServerInterface stub;
    private View view;

    // creazione del collegamento con il lato server

    public RmiHandler(View view) {

        try {
            this.view = view;

            this.stub = (RmiServerInterface) Naming.lookup("//localhost/Sagrada");

            RmiClientImpl clientRmi = new RmiClientImpl(this.view);

            stub.registerRmiClient(clientRmi);

        }
        catch (MalformedURLException e){
            System.out.println("URL not found");
        }
        catch (RemoteException e) {
            System.out.println("Connection error client");
        }
        catch (NotBoundException e) {
            System.out.println("Reference not correct");
        }

    }



    //---------------------ovveride metodi di client interface-------------------------
    // metodi invocabili dal client sul server



    @Override
    public void setSinglePlayerMode(int id, boolean singlePlayer) {
        try {
            stub.setSinglePlayerMode(id, singlePlayer);
        } catch (RemoteException e) {
            System.out.println("Error in setting player mode");
            e.printStackTrace();
        }
    }


    @Override
    public void setPlayerNameToServer(String username, int iD) {
        try{
            stub.setPlayerNameToServer(username, iD);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting name");
            e.printStackTrace();
        }

    }

    @Override
    public void setPatternCardToServer(int indexPatternChoose, int ID) {
        try {
            stub.setPatternCardToServer(indexPatternChoose, ID);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting pattern card");
            e.printStackTrace();
        }


    }

    @Override
    public void setDraftPoolToServer(int ID) {
        try {
            stub.setDraftPoolToServer(ID);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting pattern card");
            e.printStackTrace();
        }

    }

    @Override
    public void setChooseToServer(int ID, int step) {
        try{
            stub.setChooseToServer(ID, step);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting choose");
            e.printStackTrace();
        }
    }

    @Override
    public void setMoveToServer(int ID, int indexPool, int indexPattern) {
        try{
            stub.setMoveToServer(ID, indexPool, indexPattern);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting move");
            e.printStackTrace();
        }


    }

    @Override
    public void setStartToolToServer(int ID) {
        try{
            stub.setStartToolToServer(ID);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting tool");
            e.printStackTrace();
        }

    }

    @Override
    public void setNextTurnToServer(int ID) {
        try{
            stub.setNextTurnToServer(ID);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting turn");
            e.printStackTrace();
        }

    }

    @Override
    public void setNoTokenToServer(int ID) {
        try{
            stub.setNoTokenToServer(ID);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting no tool");
            e.printStackTrace();
        }

    }

    @Override
    public void useToolCardToServer(int id, int indexTool) {
        try{
            stub.useToolCardToServer(id, indexTool);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting using tool");
            e.printStackTrace();
        }

    }

    @Override
    public void useGrozingToolCard(int ID, int indexPool, int increase) {
        try{
            stub.useGrozingToolCard(ID, indexPool, increase);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting grozing ");
            e.printStackTrace();
        }

    }

    @Override
    public void useEglomiseToolCard(int ID, int indexStart, int indexEnd) {
        try{
            stub.useEglomiseToolCard(ID, indexStart, indexEnd);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting eglomise");
            e.printStackTrace();
        }

    }

    @Override
    public void useCopperFoilToolCard(int ID, int indexStart, int indexEnd) {
        try{
            stub.useCopperFoilToolCard(ID, indexStart, indexEnd);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting copper foil");
            e.printStackTrace();
        }

    }

    @Override
    public void useLathekinToolCard(int ID, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        try{
            stub.useLathekinToolCard(ID, indexStartOne, indexEndOne, indexStartTwo, indexEndTwo);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting lathekin");
            e.printStackTrace();
        }

    }

    @Override
    public void useLensCutterToolCard(int ID, int indexPool, int indexRound, int indexPosition) {
        try{
            stub.useLensCutterToolCard(ID, indexPool, indexRound, indexPosition);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting lens cutter");
            e.printStackTrace();
        }

    }

    @Override
    public void useFluxBrushToolCard(int ID, int indexPool) {
        try{
            stub.useFluxBrushToolCard(ID, indexPool);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting flux brush");
            e.printStackTrace();
        }

    }

    @Override
    public void useGlazingHammerToolCard(int ID) {
        try{
            stub.useGlazingHammerToolCard(ID);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting glazing hammer");
            e.printStackTrace();
        }

    }

    @Override
    public void useRunningPliersToolCard(int ID, int indexPool, int indexPattern) {
        try{
            stub.useRunningPliersToolCard(ID, indexPool, indexPattern);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting running pliers");
            e.printStackTrace();
        }

    }

    @Override
    public void useCorkBackedToolCard(int ID, int indexPool, int indexPattern) {
        try{
            stub.useCorkBackedToolCard(ID, indexPool, indexPattern);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting cork backed");
            e.printStackTrace();
        }

    }

    @Override
    public void useGrindingStoneToolCard(int ID, int indexPool) {
        try{
            stub.useGrindingStoneToolCard(ID, indexPool);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting grinding stone");
            e.printStackTrace();
        }

    }

    @Override
    public void useFluxRemoverToolCard(int ID, int indexPool, int diceValue) {
        try {
            stub.useFluxRemoverToolCard(ID, indexPool, diceValue);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting flux remover");
            e.printStackTrace();
        }

    }

    @Override
    public void useTapWheelToolCard(int ID, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        try{
            stub.useTapWheelToolCard(ID, number, indexStartOne, indexEndOne, indexStartTwo, indexEndTwo);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting tap wheel");
            e.printStackTrace();
        }
    }

    @Override
    public void setEndGameTimer(int ID) {
        try {
            stub.setEndGameTimer(ID);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting end game timer");
            e.printStackTrace();
        }
    }


    //-------------------------single player----------------------

    @Override
    public void setDifficultyToServer(int ID, int difficulty) {
        try{
            stub.setDifficultyToServer(ID, difficulty);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting difficulty");
            e.printStackTrace();
        }

    }

    @Override
    public void useToolSingleToServer(int ID, int indexTool, int indexPool) {
        try{
            stub.useToolSingleToServer(ID, indexTool, indexPool);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting tool single player");
            e.printStackTrace();
        }
    }


}

