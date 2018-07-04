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

public class VirtualSocket extends VirtualView implements Runnable {

    private final Logger log = Logger.getLogger(VirtualSocket.class.getName());
    private Socket clientConnection;
    private boolean running;
    private Server server;

    VirtualSocket(Socket clientConnection, Server server, int id) {
        super(id);
        this.server = server;
        this.clientConnection = clientConnection;
        this.running = true;
        sendEvent(new PlayerIDEvent(this.playerID));
        log.info("Send socket id to the player");
        sendEvent(new SinglePlayerRequestEvent(this.playerID));
    }

    // observable -> notify
    // waiting for msg from the clients
    // gestisce eventi che notificano controller ed eventi che prendano da model
    @Override
    public void run() {

        try {
            log.info("thread socket andato");
            while (this.isRunning()) {

                Object received = null;
                try {
                     ObjectInputStream socketIn = new ObjectInputStream(clientConnection.getInputStream());
                     received = socketIn.readObject();
                }
                catch (IOException e) {
                    log.info("error socket: " + super.getPlayerID() + " disconnected from the game ");
                    if (getServer().getGame() == null) {
                        getServer().removeSocketClient(this);
                        getServer().removeClient(this);
                        Server.setMulti(Server.getMulti() - 1);
                        if (Server.getMulti() == 1) {
                            getServer().endTimerLogin();
                        }
                    }
                    else {
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

                        if (!(((SinglePlayerEvent)received).isSinglePlayer())) {
                            Server.setSinglePlayer(false);
                        }
                        else if ( ((SinglePlayerEvent) received).isSinglePlayer() && Server.getMulti() == 0) {
                            Server.setSinglePlayer(true);
                        }
                        else {
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
                        }
                        else {
                            Server.setMulti(Server.getMulti() + 1);
                            this.getServer().waitingOtherPlayers();
                        }
                    }
                    else {
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

                //-------------single player

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
                // add the disconnection if there's an exception
        } catch (ClassNotFoundException e) {
            log.info("Error in finding classes");
            log.warning(e.getMessage());
        } finally {
            stopConnection();
            // devo rimuovere dall'array il client(?)
        }
    }


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
    @Override
    public void update(Observable o, Object arg) {

        if (this.isRunning()) {

            if (arg instanceof Event) {
                sendEvent((Event) arg);
            }

            // aggiungere il resto e nel caso oggetto ricevuto non sia messaggio
        }

    }

    private boolean isRunning() {
        return running;
    }


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

    public Server getServer() {
        return server;
    }
}
