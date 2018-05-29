package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.server.model.Events.Event;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

public class CliView extends View implements Runnable {

    //private Scanner scanner;
    private ClientInterface communication;
    private boolean singlePlayer;

    // TODO controllare utilita di questo costruttore
    public CliView(String username, boolean singlePlayer) {
        //super.setPlayerName(username);
        //this.scanner = scanner;
        this.singlePlayer = singlePlayer;
    }

    public CliView( boolean singlePlayer) {
        //this.scanner = scanner;
        this.singlePlayer = singlePlayer;
    }



    @Override
    public void run() {

        //boolean loop = true;
        Scanner reader = new Scanner(System.in);

        //while (loop) {

            System.out.println("Enter a command");
            String command = reader.nextLine();

            if (command.equalsIgnoreCase("name")) {

                System.out.println("Enter a username:");
                String username = reader.nextLine();
                this.setPlayerName(username);
            }
            /*System.out.println("Enter a command");
            String command = scanner.nextLine();



            if (!isStarted) {
                System.out.println("Please wait, the game will start soon");
            }
            else if (command.equalsIgnoreCase("exit")) {
                break;
            }
            else if (command.equalsIgnoreCase("Tool")){

            }

            //TODO inserire le varie azioni che il giocatore può fare (anche switch va bene)
            // TODO oltre a se serializzare o passare le stringhe(classe Parser)
            */
        }



   // }

    @Override
    public void setPlayerName(String username)  {

        try {
            getConnection().setPlayerNameToServer(username);
        }

        catch (RemoteException e) {
            System.out.println("Error in setting name");
            e.printStackTrace();
        }
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void toStringEvent(Event event) {
        System.out.println(event.toString());
    }


    @Override
    public void setConnection(ClientInterface client) {
        this.communication = client;

    }

    @Override
    public ClientInterface getConnection() {
        return communication;
    }
}
