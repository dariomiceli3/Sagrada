package it.polimi.se2018.server.network.socket;

import it.polimi.se2018.server.network.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class SocketGatherer implements Runnable {

    private final Logger log = Logger.getLogger(SocketGatherer.class.getName());

    private ServerSocket serverSocket;
    private final Server server;
    private final int port;

    public SocketGatherer(Server server, int port) {
        this.server = server;
        this.port = port;

        try {
            this.serverSocket = new ServerSocket(port);
            log.info("Server socket started on port: { }" + port);
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

                VirtualSocket virtualSocket = new VirtualSocket(clientConnection, server, Server.getIdPlayer());

                System.out.println("player id : " + Server.getIdPlayer());

                Server.setIdPlayer(Server.getIdPlayer() + 1);


                // add arraylist di socket
                server.addSocketClient(virtualSocket);

                // add arraylist unico
                server.getClients().add(virtualSocket);

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
