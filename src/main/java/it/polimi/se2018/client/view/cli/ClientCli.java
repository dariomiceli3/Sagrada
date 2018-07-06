package it.polimi.se2018.client.view.cli;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.client.network.rmi.Ping;
import it.polimi.se2018.client.network.rmi.RmiHandler;
import it.polimi.se2018.client.network.socket.SocketHandler;
import it.polimi.se2018.client.view.View;


import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.System.out;

/**
 * Class ClientCli: the class is responsible of the the launch of a client from the command line interface, and then let the
 * player choose between the different modality of the game. It's responsible of the connection to the server, both socket and
 * rmi and at the end start the thread of the cli view
 * @author fadda-miceli-mundo
 */
public class ClientCli {

    private int SOCKETPORT;
    private String host;
    private static SocketHandler serverSocket;
    private static RmiHandler serverRmi;
    private View view;
    private Ping ping;


    /**
     * Class constructor with the connection type decided bu the user in the login scene
     * @param connectionType technologies, both socket and rmi
     */
    public ClientCli(String connectionType) {

        out.println("\t" + "\t" + "\t" + "Welcome to the game of " + "\n" + "\n" +
                " ####      #      ###     ###     #     ###      #        " + "\n" +
                "#         # #    #   #    #  #   # #    #  #    # #       " + "\n" +
                " ####    #####   #        ###   #####   #   #  #####      " + "\n" +
                "     #   #   #   #  ###   # #   #   #   #  #   #   #      " + "\n" +
                " ####    #   #    ###     #  #  #   #   ###    #   #      " + "\n");

        Gson gson = new Gson();
        InputStream fileStream = ClientCli.class.getResourceAsStream("/json/settings" + ".json");
        JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);
        this.SOCKETPORT = jsonObject.get("socketPort").getAsInt();
        this.host = jsonObject.get("ipAddress").getAsString();


        view = new CliView();

        if (connectionType.equalsIgnoreCase("socket")) {

            serverSocket = new SocketHandler(host, SOCKETPORT, view);

            view.setConnection(serverSocket);

            Thread socketThread = new Thread(serverSocket);
            socketThread.start();

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
