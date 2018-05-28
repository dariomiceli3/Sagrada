package it.polimi.se2018.client.network.socket;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.MVPlayerNameEvent;
import it.polimi.se2018.server.model.Events.MVPlayerNameUpdateEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// this class must do:
// create the new socket connection and get the input/output stream
// method run, waiting to read the object from the server and
// call the readEvent, depending on the runtime types, that it's responsible to set it to the Client View
// method sendEvent, it's responsible of sending the object using socket across the network
// method stopConnection, close the connection, we'll see if it's necessary
// override of the methods of the clientInterface, that could be callable from the Client (aka socketClientImpl)

public class SocketHandler implements ClientInterface, Runnable {

    private Socket clientConnection;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;
    private View view;

    public SocketHandler(String host, int port, View view) {

        try {
            this.clientConnection = new Socket(host, port);
            // TODO DANNO errore input stream e gli output stream, causa (?) -> provato ad inserirli sotto, controllare se va
            //this.socketIn = new ObjectInputStream(clientConnection.getInputStream());
            //this.socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
            this.view = view;

            //new Thread(this).start();

        }
        catch (IOException e) {
            System.out.println("Connection error socket");
            e.printStackTrace();
        }

    }

    /**
     * The method run is a thread that generate a loop waiting for new object input
     * to read, then call the method responsible for the proper behaviour
     * @author adrianomundo
     */
    // socket handler INPUT che legge oggetto e chiama read per capire come comportarsi
    @Override
    public void run() {

        System.out.println("Listen the event from the server");
        boolean loop = true;

        while (loop) { // maybe add controllo se clientConnection isClose

            try {

                socketIn = new ObjectInputStream(clientConnection.getInputStream());
                Object object = socketIn.readObject();

                if (object instanceof Event) {
                    readEvent((Event) object);
                }
                else {
                    System.out.println("Not received an object");
                }

            }
            catch (IOException e) {
                System.out.println("Error in I/O socket");
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                System.out.println("Error loading class socket");
                e.printStackTrace();
            }
        }

    }

    // metodo per leggere evento chiamato dal socket INPUT e in base all'evento fare la cosa giusta
    public void readEvent(Event event) {

        if (event instanceof MVPlayerNameUpdateEvent) { //add controllo se nome diverso null
            view.setPlayerName(((MVPlayerNameUpdateEvent) event).getName());
            System.out.println("Player name set" + view.getPlayerName());
        }
        else {
            System.out.println("Not understood the message");
        }

    }

    // socket handler OUTPUT che manda evento e lo trasmette attraverso socket
    public synchronized void sendEvent(Event event) {

        try {
            socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
            socketOut.writeObject(event);
            socketOut.flush();
        }
        catch (IOException e) {
            System.out.println("Error in writing object in socket");
            e.printStackTrace();
        }
    }



    // ----socket client impl----------------override methods callable by the client------------------------------

    @Override
    public void setPlayerName(String name) {
        sendEvent(new MVPlayerNameEvent(name));
    }



}
