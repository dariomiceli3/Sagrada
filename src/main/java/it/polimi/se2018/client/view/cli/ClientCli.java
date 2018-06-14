package it.polimi.se2018.client.view.cli;

import it.polimi.se2018.client.network.rmi.RmiHandler;
import it.polimi.se2018.client.network.socket.SocketHandler;
import it.polimi.se2018.client.view.cli.CliView;
import it.polimi.se2018.client.view.View;
//import it.polimi.se2018.client.view.gui.GuiView;

import java.util.Scanner;

public class ClientCli {

    private static final int SOCKETPORT = 8888;
    private static String host = "localhost";
    private static SocketHandler serverSocket;
    private static RmiHandler serverRmi;
    private String connectionType;
    private View view;


    public ClientCli(String connectionType) {

        System.out.println("\t" + "\t" + "\t" + "Welcome to the game of " + "\n" + "\n" +
                " ####      #      ###     ###     #     ###      #        " + "\n" +
                "#         # #    #   #    #  #   # #    #  #    # #       " + "\n" +
                " ####    #####   #        ###   #####   #   #  #####      " + "\n" +
                "     #   #   #   #  ###   # #   #   #   #  #   #   #      " + "\n" +
                " ####    #   #    ###     #  #  #   #   ###    #   #      " + "\n");

        this.connectionType = connectionType;

        view = new CliView();

        if (connectionType.equalsIgnoreCase("socket")) {

            serverSocket = new SocketHandler(host, SOCKETPORT, view);

            //  necessario
            view.setConnection(serverSocket);

            //decidere se così o dentro sockethandler
            Thread socketThread = new Thread(serverSocket);
            socketThread.start();

            // start of the thread of the selected cli
            Thread viewSocketThread = new Thread(view);
            viewSocketThread.start();

        }

        if (connectionType.equalsIgnoreCase("rmi")) {

            serverRmi = new RmiHandler(view);

            view.setConnection(serverRmi);

            Thread viewRmiThread = new Thread(view);
            viewRmiThread.start();

        }
    }

    public static void main(String args[]) {
        new ClientCli("socket");
    }
}
