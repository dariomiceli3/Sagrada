package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
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

        /*while (loop) {

        System.out.println("Enter a command");
        String command = reader.nextLine();

        if (command.equalsIgnoreCase("name")) {
*/
            System.out.println("Enter a username:");
            String username = reader.nextLine();
            setPlayerName(username);
        //}
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
        //}


         //}

    }

    public void setPlayerName(String username) {

        try {
            // todo provare con this anziche super
            super.getConnection().setPlayerNameToServer(username, this.getPlayerID());
        } catch (RemoteException e) {
            System.out.println("Error in setting name");
            e.printStackTrace();
        }
    }
}




