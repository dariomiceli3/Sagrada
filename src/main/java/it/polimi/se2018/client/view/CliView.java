package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.server.model.Events.Event;

import java.util.Scanner;

public class CliView extends View implements Runnable{

    private Scanner scanner;
    private ClientInterface communication;

    public CliView(Scanner scanner, String username) {
        super.setPlayerName(username);
        this.scanner = scanner;
    }

    @Override
    public void run() {

        /*boolean active = true;
        while (true) {

        }*/
    }

    @Override
    public void readEvent(Event event) {
        System.out.println(event.toString());
    }


    @Override
    public void setConnection(ClientInterface client) {
        this.communication = client;

    }
}
