package it.polimi.se2018.client.network.rmi;

public class Ping implements Runnable {

    private static final int DEFAULT = 999;
    private static final int PINGSECONDS = 2;
    private RmiHandler rmiHandler;
    private int ID;

    public Ping() {
        this.rmiHandler = null;
        this.ID = DEFAULT;
    }

    public void setID(int ID) {
        this.ID = ID;
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
                    if (ID != DEFAULT) {
                        Thread.sleep(2000);
                        getConnection().clientPing(ID);
                    }
                }
                else {
                    Thread.sleep(250);
                }
            }
            catch (InterruptedException e) {
                System.out.println("Interrupted ping");
                Thread.currentThread().interrupt();
            }
        }
    }
}
