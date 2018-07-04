package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class CorkBackedRequestEvent implements Event {

    private static final long serialVersionUID = 4454678L;
    private  int id;
    private int poolSize;

    public CorkBackedRequestEvent(int id, int poolSize) {
        this.id = id;
        this.poolSize = poolSize;
    }


    public int getId() {
        return id;
    }

    public int getPoolSize() {
        return poolSize;
    }
}
