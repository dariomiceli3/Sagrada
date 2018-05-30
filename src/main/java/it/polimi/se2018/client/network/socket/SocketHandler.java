package it.polimi.se2018.client.network.socket;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.model.Events.ClientServer.PlayerNameEvent;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.ServerClient.PlayerIDEvent;
import it.polimi.se2018.server.model.Events.ServerClient.PlayerNameUpdateEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// this class must do:
// create the new socket connection and get the input/output stream
// method run, waiting to read the object from the server and
// call the readEvent, depending on the runtime types, that it's responsible to set it to the Client View
// method sendEvent, it's responsible of sending the object using socket across the network
// override of the methods of the clientInterface, that could be callable from the Client (aka socketClientImpl)

public class SocketHandler implements ClientInterface, Runnable {

    private Socket clientConnection;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;
    private View view;

    public SocketHandler(String host, int port, View view) {

        try {
            this.clientConnection = new Socket(host, port);
            //this.socketIn = new ObjectInputStream(clientConnection.getInputStream());
            //socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
            this.view = view;

            //new Thread(this).start();

        }
        catch (IOException e) {
            System.out.println("Connection error socket");
            e.printStackTrace();
        }

    }

    /**
     * The method run represent the Socket Handler Input mode, this is a thread that generate a loop waiting
     * for new object input to read, then call the method responsible for the proper behaviour, catch IOException
     * and ClassNotFoundException if something goes wrong.
     * @author adrianomundo
     */

    @Override
    public void run() {

        System.out.println("Listen the event from the server");
        boolean loop = true;

        while (loop) {

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

        if (event instanceof PlayerIDEvent) {
            view.setPlayerID(((PlayerIDEvent) event).getPlayerID());
            System.out.println("Player id set " + view.getPlayerID());
        }
        else if (event instanceof PlayerNameUpdateEvent) {

            if ((view.getPlayerID()) == (((PlayerNameUpdateEvent) event).getID())) {
               view.setNameView(((PlayerNameUpdateEvent) event).getName());
               System.out.println("Name set" + view.getPlayerName());
              //  view.showNameView(((PlayerNameUpdateEvent) event).getName());
                //System.out.println("Player name set " + view.getPlayerName() + "for player id" + view.getPlayerID());
                //System.out.println("My name is:" + view.getPlayerName());
            }
            else {
                System.out.println("Other name" + ((PlayerNameUpdateEvent) event).getName());
            }
        }

        else {
            System.out.println("Not understood the message");
        }
    }


    /**
     * sendEvent represent the Socket Handler Output mode, it is used to send the event invoked by the client
     * across the network, catch IOException if something goes wrong
     * @param event
     * @author adrianomundo
     *
     */
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


    // todo vedere se id effettivamente necessario -> stessa cosa nell'evento
    @Override
    public void setPlayerNameToServer(String name, int id) {
        sendEvent(new PlayerNameEvent(name, id));
        //System.out.println("sto chiedendo di impostare" + name + "come id" + id);
    }



}
