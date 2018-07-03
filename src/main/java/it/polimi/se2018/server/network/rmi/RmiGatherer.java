package it.polimi.se2018.server.network.rmi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.client.network.rmi.RmiHandler;
import it.polimi.se2018.server.network.Server;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiGatherer {

    private RmiServerImpl serverRmi;

    public RmiServerImpl getServerRmi() {
        return serverRmi;
    }

    // crea registry e si collega all'impl lato server

    public RmiGatherer(Server server, int port) {

        try {
            LocateRegistry.createRegistry(port);

        }
        catch (RemoteException e) {
            System.out.println("Registry yet present");
            e.printStackTrace();
        }

        try {
            // todo check if everything is ok with this
            /*RmiServerImpl*/ serverRmi = new RmiServerImpl(server);

            Gson gson = new Gson();
            InputStream fileStream = RmiGatherer.class.getResourceAsStream("/json/settings" + ".json");
            JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);

            String ipAddress = jsonObject.get("ipAddress").getAsString();

            Naming.rebind("//" + ipAddress + "/Sagrada", serverRmi);
            System.out.println("Server rmi started on port " + port);

        }
        catch (MalformedURLException e) {
            System.out.println("Impossible to register the object");
            e.printStackTrace();

        }
        catch (RemoteException e) {
            System.out.println("Connection error server");
            e.printStackTrace();
        }

    }
}


