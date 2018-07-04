package it.polimi.se2018.server.network;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.client.network.rmi.RmiClientInterface;
import it.polimi.se2018.server.controller.Game;
import it.polimi.se2018.server.network.rmi.RmiGatherer;
import it.polimi.se2018.server.network.rmi.RmiServerImpl;
import it.polimi.se2018.server.network.rmi.VirtualRmi;
import it.polimi.se2018.server.network.socket.SocketGatherer;
import it.polimi.se2018.server.network.socket.VirtualSocket;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class Server {

    private final Logger log = Logger.getLogger(Server.class.getName());

    private static final int MAXPLAYERS = 4;
    private static final int DEFAULT = 0;

    private boolean mutex;
    private SocketGatherer socketGatherer;
    private RmiGatherer rmiGatherer;
    private List<VirtualView> socketClients = new ArrayList<>();
    private List<VirtualView> clients = new ArrayList<>();
    private boolean gameStarted;
    private static boolean singlePlayer;
    private static int idPlayer;
    private static int multi;
    private Game game;
    private Timer timer;
    private final int TIMERLOGIN;

    public Server() {

        Gson gson = new Gson();
        InputStream fileStream = Server.class.getResourceAsStream("/json/settings" + ".json");
        JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);

        final int SOCKETPORT = jsonObject.get("socketPort").getAsInt();
        final int RMIPORT = jsonObject.get("rmiPort").getAsInt();
        TIMERLOGIN = jsonObject.get("timerLogin").getAsInt();

        setIdPlayer(DEFAULT);

        socketGatherer = new SocketGatherer(this, SOCKETPORT);
        rmiGatherer = new RmiGatherer(this, RMIPORT);

        Thread socketThread = new Thread(socketGatherer);
        socketThread.start();

    }

    public static void main(String[] args) {
        new Server();
    }

    //-------------------getter/setter

    public static int getIdPlayer() {
        return idPlayer;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public boolean isSinglePlayer() {
        return singlePlayer;
    }

    public static int getMulti() {
        return multi;
    }

    private void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public static void setSinglePlayer(boolean singlePlayer) {
        Server.singlePlayer = singlePlayer;
    }

    public static void setIdPlayer(int idPlayer) {
        Server.idPlayer = idPlayer;
    }

    public static void setMulti(int multi) {
        Server.multi = multi;
    }

    public Game getGame() {
        return game;
    }

    public RmiGatherer getRmiGatherer() {
        return rmiGatherer;
    }

    //-------------------------------methods for clients list -------------------------------------


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
            log.info("SocketClient not present");
        }
    }

    public synchronized void removeClient(VirtualView virtualView) {
        if (clients.contains(virtualView)) {
            clients.remove(virtualView);
        }
        else {
            log.info("Client not present");
        }
    }



    public synchronized void waitingOtherPlayers() {

        if (singlePlayer) {

            List<VirtualView> viewGame = new ArrayList<>(clients);
            game = new Game(viewGame, singlePlayer);
            setGameStarted(true);
            log.info("Started single player");
        }


        if (getMulti() == MAXPLAYERS) {
            List<VirtualView> viewGame = new ArrayList<>(clients);
            game = new Game(viewGame, singlePlayer);
            setGameStarted(true);
        }

        if (getMulti() < 2) {
            return;
        }

        if (mutex) {
            return;
        }
        mutex = true;

        log.info("over mutex");


        if (getMulti() >= 2) {


            log.info("Two clients connected");
            log.info("Starting timer");

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {


                    if (getMulti() >= 2 && getMulti() < MAXPLAYERS) {
                        List<VirtualView> viewGame = new ArrayList<>(clients);
                        game = new Game(viewGame, singlePlayer);
                        setGameStarted(true);
                        log.info("Started game");
                    }
                }
            }, TIMERLOGIN);

        }
    }

    public boolean checkNumberPlayer() {

        if (singlePlayer) {
             return getMulti() < 1;
        }
        else {
            return getMulti() < 4;

        }
    }

    public void endTimerLogin() {

        if (timer != null) {
            log.info("cancelling timer");
            timer.cancel();
            mutex = false;
        }
    }






}
