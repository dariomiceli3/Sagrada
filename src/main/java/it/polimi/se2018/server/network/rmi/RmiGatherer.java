package it.polimi.se2018.server.network.rmi;

import it.polimi.se2018.server.network.Server;

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
            Naming.rebind("//localhost/Sagrada", serverRmi);
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


