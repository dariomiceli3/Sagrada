package it.polimi.se2018.client.view.cli;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.client.network.rmi.Ping;
import it.polimi.se2018.client.network.rmi.RmiHandler;
import it.polimi.se2018.client.network.socket.SocketHandler;
import it.polimi.se2018.client.view.cli.CliView;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.network.Server;
//import it.polimi.se2018.client.view.gui.GuiView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ClientCli {

    private int SOCKETPORT;
    private String host;
    private static SocketHandler serverSocket;
    private static RmiHandler serverRmi;
    private String connectionType;
    private View view;
    private Ping ping;


    public ClientCli(String connectionType) {

        System.out.println("\t" + "\t" + "\t" + "Welcome to the game of " + "\n" + "\n" +
                " ####      #      ###     ###     #     ###      #        " + "\n" +
                "#         # #    #   #    #  #   # #    #  #    # #       " + "\n" +
                " ####    #####   #        ###   #####   #   #  #####      " + "\n" +
                "     #   #   #   #  ###   # #   #   #   #  #   #   #      " + "\n" +
                " ####    #   #    ###     #  #  #   #   ###    #   #      " + "\n");


        this.connectionType = connectionType;
        Gson gson = new Gson();
        InputStream fileStream = ClientCli.class.getResourceAsStream("/json/settings" + ".json");
        JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);
        this.SOCKETPORT = jsonObject.get("socketPort").getAsInt();
        this.host = jsonObject.get("ipAddress").getAsString();


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

            ping = new Ping();
            serverRmi = new RmiHandler(view, ping);
            ping.setConnection(serverRmi);
            view.setConnection(serverRmi);

            Thread viewRmiThread = new Thread(view);
            viewRmiThread.start();

        }
    }

}
