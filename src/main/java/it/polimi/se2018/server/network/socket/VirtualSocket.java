package it.polimi.se2018.server.network.socket;

import it.polimi.se2018.server.Server;
import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.PlayerIDEvent;
import it.polimi.se2018.server.model.Events.SinglePlayer.SinglePlayerEvent;
import it.polimi.se2018.server.model.Events.SinglePlayer.SinglePlayerRequestEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
            //System.out.println("Send id to the player");
            sendEvent(new SinglePlayerRequestEvent(this.playerID));

    }

    // waiting for msg from the clients
    // gestisce eventi che notificano controller ed eventi che prendano da model usando sendUpdate superclasse
    @Override
    public void run() {

        try {
            while (this.isRunning()) {


                socketIn = new ObjectInputStream(clientConnection.getInputStream());
                Object received = socketIn.readObject();

                if (received instanceof PlayerNameEvent) {
                    super.setName(((PlayerNameEvent) received).getName());
                    setChanged();
                    notifyObservers(received);
                }

                if (received instanceof SinglePlayerEvent) {
                    this.getServer().setSinglePlayer(((SinglePlayerEvent) received).isSinglePlayer());
                    System.out.println(this.getServer().isSinglePlayer());

                    // todo refactor with multithreading
                    this.getServer().waitingOtherPlayers();
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



                // TODO add the other msg from the client:
                // if the msg is a modification of the model, notify, ecc.
                // if the msg is an update, access the model to get the latest information
                // add the disconnection if there's an exception
            }
        }
        catch (IOException e) {
            System.out.println("Error in reading object");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error in finding classes");
            e.printStackTrace();
        }
        finally {
            stopConnection();
            // devo rimuovere dall'array il client(?)
        }

    }


    @Override
    public synchronized void sendEvent(Event event) {
        try {

            if (this.isRunning()) {

                socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
                socketOut.writeObject(event);
                socketOut.flush();
            }
        }
        catch (IOException e) {
            System.out.println("Error in writing from virtual socket");
            e.printStackTrace();
        }

    }

    // invocato dopo notify del model, e chiama sendEvent che la manda al client (run->readEvent->clientView)
    @Override
    public void update(Observable o, Object arg) {

        if (this.isRunning()) {

            if (arg instanceof Event) {
                sendEvent((Event) arg);
            }


            /*if (arg instanceof Event) {
                sendEvent((Event) arg);
            }*/

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
