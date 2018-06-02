package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
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


    }


















    //---------------------------ovveride metodi mostrano su view---------------------------------

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
    public void showNameChoose() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = reader.nextLine();
        setPlayerName(name);

    }

    @Override
    public void showPrivateCard(PrivateObjectiveCard privateObjectiveCard) {

        System.out.println(privateObjectiveCard.toString());

    }

    @Override
    public void showPublicCard(List<PublicObjectiveCard> publicList) {

        for (PublicObjectiveCard publicCard : publicList) {
            System.out.println(publicCard.toString());
        }

    }

    @Override
    public void showPatternList(List<PatternCard> patternCards) {

        for (PatternCard patternCard : patternCards) {
            System.out.println(patternCard.toString());
        }

        Scanner reader = new Scanner(System.in);
        System.out.println("Choose your pattern Card - Enter a number between 1 and 4");
        int num = reader.nextInt();

        showPatternChoose(num, patternCards);


    }

    @Override
    public void showPatternChoose(int num, List<PatternCard> patternCards) {

        PatternCard patternCard = patternCards.get(num - 1);

        try {
            super.getConnection().setPatternCardToServer(patternCard, super.getPlayerID());
        }
        catch (RemoteException e) {
            System.out.println("error in setting pattern card");
            e.printStackTrace();
        }

    }

    @Override
    public void showPattern(PatternCard patternCard) {

        System.out.println("This is your choosed PatternCard");
        System.out.println(patternCard.toString());
    }

    @Override
    public void showTokens(int tokensNumber) {

        System.out.println("This your number of favor tokens available: " + tokensNumber);
    }

    @Override
    public void showCurrentRound(int round) {

        System.out.println("Round " + round + "is started");
    }



}




