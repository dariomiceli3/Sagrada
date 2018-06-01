package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Events.Event;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class CliView extends View implements Runnable {

    // ovveride dei metodi dell'interfaccia view con gli show per metodi comportamentali
    // metodi che in base alla scelta dell'utente mandano usando socket handler

    private boolean singlePlayer;


    public CliView(boolean singlePlayer) {
        //this.reader = scanner;
        this.singlePlayer = singlePlayer;

    }


    @Override
    public void run() {

        boolean loop = true;
        Scanner reader = new Scanner(System.in);

        if (!isStarted) {
            System.out.println("Please wait, the game will start soon");
        }

        while (loop) {


            System.out.println("Enter your name: ");
            String username = reader.nextLine();
            setPlayerName(username);

            System.out.println("Choose one of the 4 pattern card");

        }

    }


















    //------------------------ metodi chiamabili client override---------------------------

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

    @Override
    public void showPatternList(List<PatternCard> patternCards) {

        System.out.println(patternCards.toString());

    }
}




