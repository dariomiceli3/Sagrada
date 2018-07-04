package it.polimi.se2018.client.network.rmi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Ping implements Runnable {

    private final Logger log = Logger.getLogger(Ping.class.getName());

    private static final int DEFAULT = 999;
    private final int PINGSECONDS;
    private final int SLEEPMILLIS;
    private RmiHandler rmiHandler;
    private int id;

    public Ping() {

        Gson gson = new Gson();
        InputStream fileStream = Ping.class.getResourceAsStream("/json/settings" + ".json");
        JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);

        PINGSECONDS = jsonObject.get("pingSeconds").getAsInt();
        SLEEPMILLIS = jsonObject.get("sleepMillis").getAsInt();

        this.rmiHandler = null;
        this.id = DEFAULT;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setConnection(RmiHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    public RmiHandler getConnection() {
        return rmiHandler;
    }

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
                log.warning("Interrupted ping");
                Thread.currentThread().interrupt();
            }
        }
    }
}
