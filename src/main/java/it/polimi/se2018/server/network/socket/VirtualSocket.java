package it.polimi.se2018.server.network.socket;

import it.polimi.se2018.server.Server;
import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.MVPlayerNameEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;

public class VirtualSocket extends VirtualView implements Runnable {

    private Server server;
    private Socket clientConnection;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;
    private boolean running;

    public VirtualSocket(Socket clientConnection, Server server) {

        try {
            this.server = server;
            this.clientConnection = clientConnection;
            this.running = true;
            this.socketIn = new ObjectInputStream(clientConnection.getInputStream());
            this.socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
        }
        catch (IOException e) {
            System.out.println("Error in virtual socket");
            e.printStackTrace();
        }

    }

    // waiting for msg from the clients
    // gestisce eventi che notificano controller ed eventi che prendano da model usando sendUpdate superclasse
    @Override
    public void run() {

        try {
            while(this.isRunning()) {

                Object received = socketIn.readObject();

                if (received instanceof MVPlayerNameEvent) {
                    super.setName(((MVPlayerNameEvent) received).getName());
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

                socketOut.writeObject(event);
                socketOut.flush();
            }
        }
        catch (IOException e) {
            System.out.println("Error in writing from virtual socket");
            e.printStackTrace();
        }

    }

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
}
