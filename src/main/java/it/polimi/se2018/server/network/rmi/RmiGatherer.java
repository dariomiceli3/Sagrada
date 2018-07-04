package it.polimi.se2018.server.network.rmi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.server.network.Server;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Logger;

public class RmiGatherer {

    private RmiServerImpl serverRmi;

    RmiServerImpl getServerRmi() {
        return serverRmi;
    }

    // crea registry e si collega all'impl lato server

    public RmiGatherer(Server server, int port) {

        final Logger log = Logger.getLogger(RmiGatherer.class.getName());

        try {
            LocateRegistry.createRegistry(port);
        }
        catch (RemoteException e) {
           log.info("Registry yet present");
           log.warning(e.getMessage());
        }

        try {
            serverRmi = new RmiServerImpl(server);

            Gson gson = new Gson();
            InputStream fileStream = RmiGatherer.class.getResourceAsStream("/json/settings" + ".json");
            JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);

            String ipAddress = jsonObject.get("ipAddress").getAsString();

            log.info("ip address rmi: " + ipAddress);

            Naming.rebind("//" + ipAddress + "/Sagrada", serverRmi);
            log.info("Server rmi started on port " + port);

        }
        catch (MalformedURLException e) {
            log.warning("Impossible to register the object");
            log.info(e.getMessage());

        }
        catch (RemoteException e) {
           log.warning("Connection error server");
           log.info(e.getMessage());
        }
    }
}


