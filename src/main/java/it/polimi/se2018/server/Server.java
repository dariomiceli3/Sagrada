package it.polimi.se2018.server;

import it.polimi.se2018.server.controller.Game;
import it.polimi.se2018.server.network.rmi.RmiGatherer;
import it.polimi.se2018.server.network.socket.SocketGatherer;
import it.polimi.se2018.server.network.socket.VirtualSocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Server {

    private static final int SOCKETPORT = 5555;
    private static final int RMIPORT = 1099;
    private static final int MAXPLAYERS = 4;
    private static final int SECONDS = 20;

    private SocketGatherer socketGatherer;
    private RmiGatherer rmiGatherer;
    private List<VirtualView> socketClients = new ArrayList<>();
    private List<VirtualView> clients = new ArrayList<>();

    // add timer e timerturn

    public Server() {

        socketGatherer = new SocketGatherer(this, SOCKETPORT);

        Thread socketThread = new Thread(socketGatherer);
        socketThread.start();

        //todo rmi gatherer add for starting its server

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

        if (clients.size() == 2) {
            System.out.println("Due client connessi");
            System.out.println("Starting timer before the game");

            Timer timer = new Timer();
            timer.schedule(new TimerTask()
            {
                @Override
                public void run() {

                    if (clients.size() >= 2 && clients.size() <= MAXPLAYERS) {
                        List<VirtualView> viewGame = new ArrayList<>();
                        viewGame.addAll(clients);
                        new Game(viewGame);
                        System.out.println("Started game");
                    }

                }
            }, SECONDS * 1000);

        }

        if (clients.size() == MAXPLAYERS) {
            List<VirtualView> viewGame = new ArrayList<>();
            viewGame.addAll(clients);
            new Game(viewGame);
        }

    }


    public static void main(String[] args) {
        new Server();
    }





}
