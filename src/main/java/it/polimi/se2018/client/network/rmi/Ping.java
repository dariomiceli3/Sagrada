package it.polimi.se2018.client.network.rmi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * Class Ping: class that runs a thread for every rmi client and ping the server to alert that an rmi client
 * is connected, from the moment the client disconnected from the game, the thread stop to ping the server, so
 * the server knows the rmi client is not available anymore
 * @see java.lang.Runnable
 * @author fadda-miceli-mundo
 */
public class Ping implements Runnable {

    private final Logger log = Logger.getLogger(Ping.class.getName());

    private static final int DEFAULT = 999;
    private final int PINGSECONDS;
    private final int SLEEPMILLIS;
    private RmiHandler rmiHandler;
    private int id;

    /**
     * Class constructor: create a Ping type and load from file its settings, so the seconds between every ping of the server
     * and the sleep milliseconds
     */
    public Ping() {

        Gson gson = new Gson();
        InputStream fileStream = Ping.class.getResourceAsStream("/json/settings" + ".json");
        JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);

        PINGSECONDS = jsonObject.get("pingSeconds").getAsInt();
        SLEEPMILLIS = jsonObject.get("sleepMillis").getAsInt();

        this.rmiHandler = null;
        this.id = DEFAULT;
    }


    /**
     * method that provide the caller of the rmi handler associated with the ping classe
     * @return the rmi handler responsible of the connection
     */
    private RmiHandler getConnection() {
        return rmiHandler;
    }

    /**
     * method that allow the caller to set the id of the ping, that must be equal to the id of the rmi client
     * @param id of the player
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * method that allow the caller to set the handler associated with the ping class
     * @param rmiHandler to set to the ping
     */
    public void setConnection(RmiHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }


    /**
     * Override methods of the Runnable interface, the thread ping the server if the rmi handler and id aren't null thanks
     * to a remote method client ping that try to call in the server, in this way if the call doesn't work as expected
     * is easy to understand
     */
    @Override
    public void run() {
        boolean loop =  true;

        while (loop) {
            try {
                if (rmiHandler != null) {
                    if (id != DEFAULT) {
                        Thread.sleep(PINGSECONDS);
                        getConnection().clientPing(id);
                    }
                }
                else {
                    Thread.sleep(SLEEPMILLIS);
                }
            }
            catch (InterruptedException e) {
                log.warning("Interrupted ping thread");
                Thread.currentThread().interrupt();
            }
        }
    }
}
