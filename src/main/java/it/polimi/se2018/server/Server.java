package it.polimi.se2018.server;

import it.polimi.se2018.client.network.rmi.RmiClientInterface;
import it.polimi.se2018.server.controller.Game;
import it.polimi.se2018.server.network.rmi.RmiGatherer;
import it.polimi.se2018.server.network.rmi.RmiServerImpl;
import it.polimi.se2018.server.network.rmi.VirtualRmi;
import it.polimi.se2018.server.network.socket.SocketGatherer;
import it.polimi.se2018.server.network.socket.VirtualSocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Server {

    private static final int SOCKETPORT = 8888;
    private static final int RMIPORT = 1099;
    private static final int MAXPLAYERS = 4;
    private static final int SECONDS = 15;

    private boolean mutex;
    private SocketGatherer socketGatherer;
    private RmiGatherer rmiGatherer;
    private List<VirtualView> socketClients = new ArrayList<>();
    private List<VirtualView> clients = new ArrayList<>();
    private boolean gameStarted;
    private static boolean singlePlayer;
    public static int idPlayer;

    public Server() {

        idPlayer = 0;

        socketGatherer = new SocketGatherer(this, SOCKETPORT);

        rmiGatherer = new RmiGatherer(this, RMIPORT);

        Thread socketThread = new Thread(socketGatherer);
        socketThread.start();

    }

    public static void main(String[] args) {
        new Server();
    }

    public static int getIdPlayer() {
        return idPlayer;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public boolean isSinglePlayer() {
        return singlePlayer;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public void setSinglePlayer(boolean singlePlayer) {
        this.singlePlayer = singlePlayer;
    }

    public static void setIdPlayer(int idPlayer) {
        Server.idPlayer = idPlayer;
    }

    //-------------------------------methods for clients list -------------------------------------


    public synchronized List<VirtualView> getSocketClients() {
        return socketClients;
    }

    public synchronized List<VirtualView> getClients() {
        return clients;
    }

    public synchronized void addSocketClient(VirtualSocket virtualSocket) {
        socketClients.add(virtualSocket);
    }

    public synchronized void addRmiClient(RmiClientInterface clientRmi, RmiServerImpl rmiServer) {
        VirtualRmi virtualRmi = new VirtualRmi(clientRmi, this, Server.idPlayer);
        Server.setIdPlayer(Server.getIdPlayer() + 1);
        rmiServer.addToClientsRmiImpl(virtualRmi);
        clients.add(virtualRmi);
    }


    public synchronized void removeSocketClient(VirtualSocket virtualSocket) {
        if (socketClients.contains(virtualSocket)) {
            socketClients.remove(virtualSocket);
        }
        else {
            System.out.println("SocketClient not present");
        }
    }

    public synchronized void removeClient(VirtualView virtualView) {
        if (clients.contains(virtualView)) {
            clients.remove(virtualView);
        }
        else {
            System.out.println("Client not present");
        }
    }



    public synchronized void waitingOtherPlayers() {

        System.out.println("in waiting the boolean of single player: " + singlePlayer);
        System.out.println(clients.size());

        if (singlePlayer) {

            List<VirtualView> viewGame = new ArrayList<>();
            viewGame.addAll(clients);
            System.out.println(getClients().size());
            new Game(viewGame, singlePlayer);
            setGameStarted(true);
            System.out.println("Started single player");
        }

        if (clients.size() < 2) {

            return;

        }

        if(mutex) {

            return;
        }
        mutex = true;

        System.out.println("superato mutex");


        if (clients.size() == 2) {
            System.out.println("Due client connessi");
            System.out.println("Starting timer before the game");

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        mutex = true;
                        if (clients.size() >= 2 && clients.size() <= MAXPLAYERS) {
                            List<VirtualView> viewGame = new ArrayList<>();
                            viewGame.addAll(clients);
                            new Game(viewGame, singlePlayer);
                            setGameStarted(true);
                            System.out.println("Started game");
                        }

                    }
                }, (long) SECONDS * 1000);

            }


        if (clients.size() == MAXPLAYERS) {
            List<VirtualView> viewGame = new ArrayList<>();
            viewGame.addAll(clients);
            new Game(viewGame, singlePlayer);
            setGameStarted(true);
        }

    }






}
