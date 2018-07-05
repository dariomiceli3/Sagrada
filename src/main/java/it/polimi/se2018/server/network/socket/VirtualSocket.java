package it.polimi.se2018.server.network.socket;

import it.polimi.se2018.server.network.Server;
import it.polimi.se2018.server.network.VirtualView;
import it.polimi.se2018.events.clientserver.*;
import it.polimi.se2018.events.Event;
import it.polimi.se2018.events.serverclient.modelview.PlayerIDEvent;
import it.polimi.se2018.events.singleplayer.SinglePlayerEvent;
import it.polimi.se2018.events.singleplayer.SinglePlayerRequestEvent;
import it.polimi.se2018.events.singleplayer.ToolCardSinglePlayerStartEvent;
import it.polimi.se2018.events.singleplayer.ToolNumberEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Observable;
import java.util.logging.Logger;

/**
 * Class VirtualSocket: the class is a subclass of the Virtual View, so it implements the same features, but it's
 * responsible to effectively manage the communication with the socket technology. The class runs a thread to read
 * the object sent from the client that use a socket connection and send the event to the controller to notify it.
 * @see it.polimi.se2018.server.network.VirtualView
 * @see java.lang.Runnable
 * @author fadda-miceli-mundo
 */
public class VirtualSocket extends VirtualView implements Runnable {

    private final Logger log = Logger.getLogger(VirtualSocket.class.getName());
    private Socket clientConnection;
    private boolean running;
    private Server server;

    /**
     * Class constructor
     * @param clientConnection the socket associated with the virtual socket
     * @param server on which the virtual socket is running
     * @param id associated to relate with the client id
     */
    VirtualSocket(Socket clientConnection, Server server, int id) {
        super(id);
        this.server = server;
        this.clientConnection = clientConnection;
        this.running = true;
        sendEvent(new PlayerIDEvent(this.playerID));
        log.info("Send socket id to the player");
        sendEvent(new SinglePlayerRequestEvent(this.playerID));
    }

    /**
     * method that provide to the caller the current state of the virtual socket
     * @return the state of the virtual socketa as boolean
     */
    private boolean isRunning() {
        return running;
    }

    /**
     * method that provide to the caller the current Server where the virtual socket is running
     * @return the Server
     */
    public Server getServer() {
        return server;
    }


    /**
     * Override of the method run to start a virtual socket thread. The method is responsible to receive the event from
     * the socket handler of the client, read the object associated with them and send the notification to the controller,
     * the method also understand when a client disconnect and reconnect (Observable)
     */
    @Override
    public void run() {

        try {
            log.info("thread socket andato");
            while (this.isRunning()) {

                Object received = null;
                try {
                    ObjectInputStream socketIn = new ObjectInputStream(clientConnection.getInputStream());
                    received = socketIn.readObject();
                } catch (IOException e) {
                    log.info("error socket: " + super.getPlayerID() + " disconnected from the game ");
                    if (getServer().getGame() == null) {
                        getServer().removeSocketClient(this);
                        getServer().removeClient(this);
                        Server.setMulti(Server.getMulti() - 1);
                        if (Server.getMulti() == 1) {
                            getServer().endTimerLogin();
                        }
                    } else {
                        Server.setMulti(Server.getMulti() - 1);
                        setChanged();
                        notifyObservers(new DisconnectionEvent(super.getPlayerID()));
                    }
                    this.running = false;
                }
                if (received instanceof PlayerNameEvent) {
                    super.setName(((PlayerNameEvent) received).getName());
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof SinglePlayerEvent) {

                    if (!getServer().isGameStarted()) {

                        if (!(((SinglePlayerEvent) received).isSinglePlayer())) {
                            Server.setSinglePlayer(false);
                        } else if (((SinglePlayerEvent) received).isSinglePlayer() && Server.getMulti() == 0) {
                            Server.setSinglePlayer(true);
                        } else {
                            log.info("client socket extra in start multi as single tried to connect");
                            getServer().removeSocketClient(this);
                            getServer().removeClient(this);
                            this.running = false;
                        }

                    }
                    if (getServer().checkNumberPlayer()) {
                        if (getServer().isGameStarted()) {

                            log.info("reconnection socket");
                            this.addObserver(getServer().getGame());
                            Server.setMulti(Server.getMulti() + 1);
                            setChanged();
                            notifyObservers(new ReconnectionEvent());
                        } else {
                            Server.setMulti(Server.getMulti() + 1);
                            this.getServer().waitingOtherPlayers();
                        }
                    } else {
                        log.info("client socket extra tried to connect");
                        getServer().removeSocketClient(this);
                        getServer().removeClient(this);
                        this.running = false;
                    }
                }
                if (received instanceof PlayerPatternEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof PlayerDraftPoolEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof PlayerChooseEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof PlayerMoveEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof PlayerStartToolEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof PlayerNextTurnEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof ToolCardStartEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof GrozingPliersEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof EglomiseBrushEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof CopperFoilEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof LathekinEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof LensCutterEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof FluxBrushEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof GlazingHammerEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof RunningPliersEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof CorkBackedEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof GrindingStoneEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof FluxRemoverEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof TapWheelEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof EndGameTimerEvent) {
                    setChanged();
                    notifyObservers(received);
                }

                //-------------single player events------------

                if (received instanceof ToolNumberEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof PlayerNoTokenEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof ToolCardSinglePlayerStartEvent) {
                    setChanged();
                    notifyObservers(received);
                }

                //-----------custom card-----------------

                if (received instanceof CustomPatternEvent) {
                    setChanged();
                    notifyObservers(received);
                }

                //------------disconnection-----------------

                if (received instanceof ExitEvent) {
                    setChanged();
                    notifyObservers(received);
                }
                if (received instanceof ReconnectPlayerEvent) {
                    setChanged();
                    notifyObservers(received);
                }
            }
        } catch (ClassNotFoundException e) {
            log.info("Error in finding classes");
            log.warning(e.getMessage());
        }
        finally {
            stopConnection();
        }
    }


    /**
     * Override of the method of the superclass, the method is responsible to send the object of the event obtained
     * as parameter and send it to socket handler of the client
     * @param event to send to the client
     */
    @Override
    public synchronized void sendEvent(Event event) {
        try {
            if (this.isRunning()) {

                try {
                    ObjectOutputStream socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
                    socketOut.writeObject(event);
                    socketOut.flush();
                }
                catch (SocketException e) {
                    log.info("error in send event virtual socket");
                    this.running = false;
                }
            }
        }
        catch (IOException e) {
            log.info("Error in writing from virtual socket");
            log.warning(e.getMessage());
            this.running = false;
        }
    }

    // observable -> update
    // invocato dopo notify del model, e chiama sendEvent che la manda al client (run->readEvent->clientView)

    /**
     * Override of the built-in method of the Observer class, it's called after a notify of the model, so that the
     * virtual socket can update after a modification of the model and send to the client with the right method (Observer)
     * @param o the observable
     * @param arg the object of the update
     */
    @Override
    public void update(Observable o, Object arg) {

        if (this.isRunning()) {
            if (arg instanceof Event) {
                sendEvent((Event) arg);
            }
        }
    }


    /**
     *  method that's responsible of closing the connection of the virtual socket with the socket handler of the client
     *  and update its state to not running anymore
     */
    private void stopConnection () {
        try {
            clientConnection.close();
            log.info("Closing connection virtual socket");
        }
        catch (IOException e) {
            log.info("Error in closing connection");
            log.warning(e.getMessage());
        }
        running = false;
    }

}
