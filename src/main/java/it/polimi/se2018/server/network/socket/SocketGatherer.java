package it.polimi.se2018.server.network.socket;

import it.polimi.se2018.server.network.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Class SocketGatherer : the class it's the real handler of the multiple connection of the client with the socket technology,
 * and to do this task, the socket gatherer runs in a thread and every time receives a new connection, it's responsible for
 * the creation of the virtual socket associated with it
 * @see java.lang.Runnable
 * @author fadda-miceli-mundo
 */
public class SocketGatherer implements Runnable {

    private final Logger log = Logger.getLogger(SocketGatherer.class.getName());
    private ServerSocket serverSocket;
    private final Server server;

    /**
     * Class constructor of the Gatherer in a specific port on a Server
     * @param server the server where is running
     * @param port on which is waiting the connection
     */
    public SocketGatherer(Server server, int port) {
        this.server = server;

        try {
            this.serverSocket = new ServerSocket(port);
            log.info("Server socket started on port: " + port);
        }
        catch (IOException e) {
            log.info("Socket error in creation");
            log.warning(e.getMessage());
        }

    }


    /**
     * Override of the method run, create an infinite loop in waiting the connection of new socket clients, after that
     * create the relative virtual socket and add it to the clients in the Server
     */
    @Override
    public void run() {

        boolean wait = true;

        while (wait) {

            Socket clientConnection;

            try {
                clientConnection = serverSocket.accept();
                log.info("New socket connected");

                VirtualSocket virtualSocket = new VirtualSocket(clientConnection, server, Server.getIdPlayer());

                log.info("player id : " + Server.getIdPlayer());

                Server.setIdPlayer(Server.getIdPlayer() + 1);


                // add arraylist di socket
                server.addSocketClient(virtualSocket);

                // add arraylist unico
                server.getClients().add(virtualSocket);

                Thread vsThread = new Thread(virtualSocket);
                vsThread.start();

                }
            catch (IOException e) {
                log.info("Socket error in clients connection");
                log.warning(e.getMessage());

            }
        }
    }

}
