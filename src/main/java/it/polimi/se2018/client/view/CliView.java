package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Events.Event;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

public class CliView extends View implements Runnable {

    // ovveride dei metodi dell'interfaccia view con gli show per metodi comportamentali
    // metodi che in base alla scelta dell'utente mandano usando socket handler

    private boolean singlePlayer;
    //private Scanner reader;


    public CliView(boolean singlePlayer) {
        //this.reader = scanner;
        this.singlePlayer = singlePlayer;
    }


    @Override
    public void run() {

        boolean loop = true;
        Scanner reader = new Scanner(System.in);

        while (loop) {

        System.out.println("Enter a command");
        String command = reader.nextLine();

        System.out.println("Enter a username:");
        String username = reader.nextLine();
        setPlayerName(username);

        if (!isStarted) {
            System.out.println("Please wait, the game will start soon");
        }

        //TODO inserire le varie azioni che il giocatore può fare (anche switch va bene)
        }

    }

    @Override
    public void setPlayerName(String username) {

        try {
            super.getConnection().setPlayerNameToServer(username, super.getPlayerID());
        } catch (RemoteException e) {
            System.out.println("Error in setting name");
            e.printStackTrace();
        }
    }

    @Override
    public void showPrivateCard(PrivateObjectiveCard privateObjectiveCard) {

        System.out.println(privateObjectiveCard.toString());


    }

}




