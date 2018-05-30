package it.polimi.se2018.server;

import it.polimi.se2018.server.controller.Game;
import it.polimi.se2018.server.network.rmi.RmiGatherer;
import it.polimi.se2018.server.network.socket.SocketGatherer;
import it.polimi.se2018.server.network.socket.VirtualSocket;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private static final int SOCKETPORT = 5555;
    private static final int RMIPORT = 1099;

    private int maxPlayers;
    //private SocketServerInterface serverSocket;
    private SocketGatherer socketGatherer;
    private RmiGatherer rmiGatherer;
    private List<VirtualView> socketClients = new ArrayList<>();
    private List<VirtualView> clients = new ArrayList<>();

    // add timer e timerturn

    public Server() {

        //this.serverSocket = new SocketServerImpl(this);
        this.maxPlayers = 4;
        socketGatherer = new SocketGatherer(this, SOCKETPORT);

        Thread socketThread = new Thread(socketGatherer);
        socketThread.start();

        //rmi gatherer add for starting its server

    }


    public synchronized List<VirtualView> getSocketClients() {
        return socketClients;
    }

    public synchronized List<VirtualView> getClients() {
        return clients;
    }

    public synchronized void addSocketClient(VirtualSocket virtualSocket) {
        socketClients.add(virtualSocket);
    }

    // add registerAddRmiClient

    public synchronized void removeSocketClient(VirtualSocket virtualSocket) {
        if (socketClients.contains(virtualSocket)) {
            socketClients.remove(virtualSocket);
        }
        else {
            System.out.println("SocketClient non presente");
        }
    }

    public synchronized void removeClient(VirtualView virtualView) {
        if (clients.contains(virtualView)) {
            clients.remove(virtualView);
        }
        else {
            System.out.println("Client non presente");
        }
    }

    /*public synchronized void SocketServerInterface getImplementation() {
        return this.serverSocket;
    }*/

    public synchronized void waitingOtherPlayers() {

        // TODO sostituire 1 con 4
        if (clients.size() == 2) {
            System.out.println("Due client connessi");
            List<VirtualView> viewGame = new ArrayList<>(clients);
            //viewGame.addAll(clients);
            new Game(viewGame);
        }




        //if (clients.size() == 2){

            // TODO completare waiting connection
            // far partire il timer
            // finchè sono > 2 e < 4
            // poi new Game Server

       // }
    }


    public static void main(String[] args) {
        new Server();
    }





}
