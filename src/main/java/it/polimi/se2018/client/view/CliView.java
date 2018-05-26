package it.polimi.se2018.client.view;

import it.polimi.se2018.server.model.Events.Event;

import java.util.Scanner;

public class CliView extends View implements Runnable{

    private Scanner scanner;
    // aggiungere la communicationtype

    public CliView(Scanner scanner, String username) {
        super.setPlayerName(username);
        this.scanner = scanner;
    }

    private void print(String anotherString) {
        System.out.println(anotherString);
    }

    @Override
    public void readEvent(Event event) {
        print(event.toString());
    }

    @Override
    public void run() {

        boolean active = true;
        while (true) {

        }
    }







}
