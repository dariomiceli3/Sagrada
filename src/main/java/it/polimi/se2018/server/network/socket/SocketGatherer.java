package it.polimi.se2018.server.network.socket;

import it.polimi.se2018.server.Server;
import it.polimi.se2018.server.VirtualView;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketGatherer implements Runnable {

    private ServerSocket serverSocket;
    private final Server server;
    private final int port;
    private int counter;

    public SocketGatherer(Server server, int port) {
        this.server = server;
        this.port = port;
        this.counter = 0;

        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server socket started");

        }
        catch (IOException e) {
            System.out.println("Socket error in creation");
            e.printStackTrace();
        }

    }


    // thread socket server, in loop waiting connections of the new clients
    @Override
    public void run() {

        boolean wait = true;

        while (wait) {

            Socket clientConnection;

            try {
                clientConnection = serverSocket.accept();
                System.out.println("New socket connected");

                VirtualSocket virtualSocket = new VirtualSocket(clientConnection, server, counter);
                counter++;

                // add arraylist di socket
                server.addSocketClient(virtualSocket);

                // add arraylist unico
                server.getClients().add(virtualSocket);

                server.waitingOtherPlayers();
                //  TODO waiting other connections method!!

                Thread vsThread = new Thread(virtualSocket);
                vsThread.start();

                }
            catch (IOException e) {
                System.out.println("Socket error in clients connection");
                e.printStackTrace();

            }
        }



    }



}
