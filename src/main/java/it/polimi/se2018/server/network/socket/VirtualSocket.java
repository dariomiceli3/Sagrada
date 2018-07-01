package it.polimi.se2018.server.network.socket;

import it.polimi.se2018.server.Server;
import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.GameStartedEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.PlayerIDEvent;
import it.polimi.se2018.server.model.Events.SinglePlayer.SinglePlayerEvent;
import it.polimi.se2018.server.model.Events.SinglePlayer.SinglePlayerRequestEvent;
import it.polimi.se2018.server.model.Events.SinglePlayer.ToolCardSinglePlayerStartEvent;
import it.polimi.se2018.server.model.Events.SinglePlayer.ToolNumberEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Observable;

public class VirtualSocket extends VirtualView implements Runnable {

    private Socket clientConnection;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;
    private boolean running;
    private Server server;

    public VirtualSocket(Socket clientConnection, Server server, int ID) {
            super(ID);
            this.server = server;
            this.clientConnection = clientConnection;
            this.running = true;
            sendEvent(new PlayerIDEvent(this.playerID));
            System.out.println("Send socket id to the player");
            sendEvent(new SinglePlayerRequestEvent(this.playerID));

    }

    // observable -> notify
    // waiting for msg from the clients
    // gestisce eventi che notificano controller ed eventi che prendano da model
    @Override
    public void run() {

        try {
            System.out.println("thread socket andato");
            while (this.isRunning()) {

                Object received = null;
                try {
                     socketIn = new ObjectInputStream(clientConnection.getInputStream());
                     received = socketIn.readObject();
                }
                catch (IOException e) {
                    System.out.println("error: " + super.getPlayerID() + " disconnected from the game ");
                    if (getServer().getGame() == null) {
                        getServer().getSocketClients().remove(this);
                        getServer().getClients().remove(this);
                        Server.setMulti(Server.getMulti() - 1);
                        if (Server.getMulti() == 1) {
                            getServer().endTimerLogin();
                        }
                    }
                    else {
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
                            this.getServer().setSinglePlayer(false);
                        }
                        else {
                            System.out.println("client socket extra in avvio multi come single ha provato a connettersi");
                            getServer().getSocketClients().remove(this);
                            getServer().getClients().remove(this);
                            this.running = false;
                        }


                        System.out.println("modalita settata " + getServer().isSinglePlayer());
                    }
                    if (getServer().checkNumberPlayer()) {
                        if (getServer().isGameStarted()) {
                            // todo finire di gestire la riconnessione
                            setChanged();
                            notifyObservers(new ReconnectionEvent());
                        }
                        else {
                            Server.setMulti(Server.getMulti() + 1);
                            System.out.println(Server.getMulti());
                            this.getServer().waitingOtherPlayers();
                        }
                    }

                    else {
                        System.out.println("client socket extra ha provato a connettersi");
                        getServer().getSocketClients().remove(this);
                        getServer().getClients().remove(this);
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
            System.out.println("Error in finding classes");
            e.printStackTrace();
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
                    socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
                    socketOut.writeObject(event);
                    socketOut.flush();
                }
                catch (SocketException e) {
                    System.out.println("error in send event virtual socket appena inserito");
                    this.running = false;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error in writing from virtual socket");
            e.printStackTrace();
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

    public boolean isRunning() {
        return running;
    }


    public void stopConnection () {
        try {
            clientConnection.close();
            System.out.println("Closing connection virtual socket");
        }
        catch (IOException e) {
            System.out.println("Error in closing connection");
            e.printStackTrace();
        }
        running = false;
    }

    public Server getServer() {
        return server;
    }
}
