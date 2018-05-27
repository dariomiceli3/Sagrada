package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.server.model.Events.Event;

import java.util.Scanner;

public class CliView extends View implements Runnable {

    private Scanner scanner;
    private ClientInterface communication;

    public CliView(Scanner scanner, String username) {
        super.setPlayerName(username);
        this.scanner = scanner;
    }

    @Override
    public void run() {

        boolean loop = true;

        while (loop) {

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
        }



    }

    @Override
    public void toStringEvent(Event event) {
        System.out.println(event.toString());
    }


    @Override
    public void setConnection(ClientInterface client) {
        this.communication = client;

    }
}
