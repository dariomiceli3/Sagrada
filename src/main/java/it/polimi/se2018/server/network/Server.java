package it.polimi.se2018.server.network;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.client.network.rmi.RmiClientInterface;
import it.polimi.se2018.server.controller.GameController;
import it.polimi.se2018.server.network.rmi.RmiGatherer;
import it.polimi.se2018.server.network.rmi.RmiServerImpl;
import it.polimi.se2018.server.network.rmi.VirtualRmi;
import it.polimi.se2018.server.network.socket.SocketGatherer;
import it.polimi.se2018.server.network.socket.VirtualSocket;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.logging.Logger;


/**
 * Class Server: the class represents the Server, responsible for handling and manage the user connection, it's the class
 * responsible for the creation of the controller and the handling of the timer at the start of the gameController
 * @author fadda-miceli-mundo
 */
public class Server {

    private final Logger log = Logger.getLogger(Server.class.getName());

    private static final int MAXPLAYERS = 4;
    private static final int DEFAULT = 0;
    private static final int SINGLEPLAY = 1;

    private boolean mutex;
    private SocketGatherer socketGatherer;
    private RmiGatherer rmiGatherer;
    private List<VirtualView> socketClients = new ArrayList<>();
    private List<VirtualView> clients = new ArrayList<>();
    private boolean gameStarted;
    private static boolean singlePlayer;
    private static int idPlayer;
    private static int multi;
    private GameController gameController;
    private Timer timer;
    private final int TIMERLOGIN;

    /**
     * Class constructor: load from a settings file the socket and rmi port for the user connection and the timer of the login
     * it's responsible for the creation of the socket and rmi gatherer that handle the connection
     */
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

    /**
     * method main that start a new Server instance
     * @param args command line parameter
     */
    public static void main(String[] args) {
        new Server();
    }

    /**
     * method that provide the caller of the state of started game at the moment of the call
     * @return the state of the game
     */
    public boolean isGameStarted() {
        return gameStarted;
    }

    public boolean isSinglePlayer() {
        return singlePlayer;
    }
    /**
     * method that provide the caller of the available id to set to the player
     * @return int value of the id
     */
    public static int getIdPlayer() {
        return idPlayer;
    }

    /**
     * method that provide the caller of the current number of player in the multiplayer mode gameController
     * @return int value of the number
     */
    public static int getMulti() {
        return multi;
    }

    /**
     * method that provide the caller of the current gameController controller
     * @return GameController
     */
    public GameController getGameController() {
        return gameController;
    }

    /**
     * method that provide the caller of the rmi gatherer
     * @return the Rmi gatherer
     */
    public RmiGatherer getRmiGatherer() {
        return rmiGatherer;
    }

    /**
     * synchronized method that provide the caller of the current list of clients connected to the server
     * @return a list of the virtual view connected
     */
    public synchronized List<VirtualView> getClients() {
        return clients;
    }

    /**
     * method that allow the caller to set the gameController state to started or not
     * @param gameStarted state of the current gameController
     */
    private void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    /**
     * method that allow the caller to set if the modality of the gameController is single player or not
     * @param singlePlayer boolean value of the current gameController mode
     */
    public static void setSinglePlayer(boolean singlePlayer) {
        Server.singlePlayer = singlePlayer;
    }

    /**
     * method that allow the caller to set the next id available to assign to a player
     * @param idPlayer to set to a player
     */
    public static void setIdPlayer(int idPlayer) {
        Server.idPlayer = idPlayer;
    }

    /**
     * method that allow the caller to set the current number player in the multi player gameController mode
     * @param multi number of player in the current gameController
     */
    public static void setMulti(int multi) {
        Server.multi = multi;
    }

    /**
     * method that allow the caller to set the controller of a match
     * @param gameController to set
     */
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    //-----------------methods for managing the socket and rmi clients----------------------------------


    /**
     * synchronized method that add a new virtual socket to the list of the socket clients connected to the server
     * @param virtualSocket to add to the clients connected
     */
    public synchronized void addSocketClient(VirtualSocket virtualSocket) {
        socketClients.add(virtualSocket);
    }

    /**
     * synchronized method that create a virtual rmi and add it to the list of the rmi clients connected to the server
     * @param clientRmi to add to the clients connected
     * @param rmiServer where the rmi client tried to connect
     */
    public synchronized void addRmiClient(RmiClientInterface clientRmi, RmiServerImpl rmiServer) {
        VirtualRmi virtualRmi = new VirtualRmi(clientRmi, this, Server.idPlayer);
        Server.setIdPlayer(Server.getIdPlayer() + 1);
        rmiServer.addToClientsRmiImpl(virtualRmi);
        clients.add(virtualRmi);
    }

    /**
     * synchronized method that remove a virtual socket from the list of the socket clients connected to the server
     * @param virtualSocket to remove from the clients
     */
    public synchronized void removeSocketClient(VirtualSocket virtualSocket) {
        if (socketClients.contains(virtualSocket)) {
            socketClients.remove(virtualSocket);
        }
        else {
            log.info("SocketClient not present");
        }
    }

    /**
     * synchronized method that remove a virtual view from the list of the clients connected to the server if the
     * server contains it
     * @param virtualView to remove from the clients
     */
    public synchronized void removeClient(VirtualView virtualView) {
        if (clients.contains(virtualView)) {
            clients.remove(virtualView);
        }
        else {
            log.info("Client not present");
        }
    }

    /**
     * synchronized method responsible for the waiting of the connections of the other players, if the player are greater than or equal to 2
     * start a timer for waiting other players to connect, at the end of the timer create e new instance of the controller
     * and set the gameController started to true,while if the gameController mode is single player jump the timer and directly start a new gameController.
     * It immediately start a gameController if the players connected are 4
     */
    public synchronized void waitingOtherPlayers() {

        if (singlePlayer) {
            List<VirtualView> viewGame = new ArrayList<>(clients);
            gameController = new GameController(viewGame, singlePlayer);
            setGameStarted(true);
            log.info("Started single player");
        }
        if (getMulti() == MAXPLAYERS) {
            List<VirtualView> viewGame = new ArrayList<>(clients);
            gameController = new GameController(viewGame, singlePlayer);
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
                        gameController = new GameController(viewGame, singlePlayer);
                        setGameStarted(true);
                        log.info("Started gameController");
                    }
                }
            }, TIMERLOGIN);
        }
    }

    /**
     * method helper the check if the number of players have reached the maximum
     * @return boolean of (un)successful check
     */
    public boolean checkNumberPlayer() {

        if (singlePlayer) {
             return getMulti() < SINGLEPLAY;
        }
        else {
            return getMulti() < MAXPLAYERS;

        }
    }

    /**
     * method that stop the login timer if there's an instance created yet
     */
    public void endTimerLogin() {

        if (timer != null) {
            log.info("cancelling timer");
            timer.cancel();
            mutex = false;
        }
    }

    /**
     * method that eliminate the clients and the controller instance at the end of a match and when
     * no player remain connected to the server
     */
    public void endGame() {
        setGameController(null);
        mutex = false;
        gameStarted = false;
        Server.setSinglePlayer(false);
        clients = null;
        clients = new ArrayList<>();
        socketClients = null;
        socketClients = new ArrayList<>();
        setIdPlayer(0);
    }


}
