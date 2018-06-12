package it.polimi.se2018.client;

import it.polimi.se2018.client.network.rmi.RmiHandler;
import it.polimi.se2018.client.network.socket.SocketHandler;
import it.polimi.se2018.client.view.CliView;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.client.view.gui.GUI;
import it.polimi.se2018.client.view.gui.GuiViewController;
import javafx.application.Application;
//import it.polimi.se2018.client.view.gui.GuiView;

import java.util.Scanner;

public class Client {

    private static final int SOCKETPORT = 8888;
    private static String host = "localhost";
    private static SocketHandler serverSocket;
    private static RmiHandler serverRmi;
    private static boolean singlePlay;

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.println("\t" + "\t" + "\t" + "Welcome to the game of " + "\n" + "\n" +
                " ####      #      ###     ###     #     ###      #        " + "\n" +
                "#         # #    #   #    #  #   # #    #  #    # #       " + "\n" +
                " ####    #####   #        ###   #####   #   #  #####      " + "\n" +
                "     #   #   #   #  ###   # #   #   #   #  #   #   #      " + "\n" +
                " ####    #   #    ###     #  #  #   #   ###    #   #      " + "\n");




        //-------------------------------view creation--------------------------------------------------------------

        String connectionType;
        do {
            System.out.println("Choose the connection type:Socket or RMI?");
            connectionType = reader.nextLine();
        }
        while (!((connectionType.equalsIgnoreCase("socket") || connectionType.equalsIgnoreCase("rmi"))));



        String textView;
        View view;
        do {
            System.out.println("How do you prefer to play: Gui or Cli?");
            textView = reader.nextLine();
        }
        while (!((textView.equalsIgnoreCase("gui") || textView.equalsIgnoreCase("cli"))));

        if (textView.equalsIgnoreCase("Gui")) {
            view = new GuiViewController();
        }
        else if (textView.equalsIgnoreCase("Cli")) {
            view = new CliView();
        }
        else {
            System.out.println("something went wrong in setting view");
            view = new CliView();
            reader.close();
        }


        //-------------------------------connectivity creation----------------------------------------------------------


        if (connectionType.equalsIgnoreCase("Socket")) {

            serverSocket = new SocketHandler(host, SOCKETPORT, view);

            //  necessario
            view.setConnection(serverSocket);

            //decidere se così o dentro sockethandler
            Thread socketThread = new Thread(serverSocket);
            socketThread.start();

            // accertarsi che abbia ricevuto ID e poi startare
            // start of the thread of the selected view
            if(textView.equalsIgnoreCase("Cli")){
                Thread viewSocketThread = new Thread(view);
                viewSocketThread.start();
            }else {
                Application.launch(GUI.class);
            }


        }
        else if (connectionType.equalsIgnoreCase("Rmi")) {
            serverRmi = new RmiHandler(view);

            view.setConnection(serverRmi);

            Thread viewRmiThread = new Thread(view);
            viewRmiThread.start();

        }
        else {
            System.out.println("something went wrong in setting connection");
            reader.close();
        }
    }
}
