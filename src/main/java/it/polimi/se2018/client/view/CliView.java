package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Components.RoundTracker;
import it.polimi.se2018.server.model.Events.Event;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CliView extends View implements Runnable {

    // ovveride dei metodi dell'interfaccia view con gli show per metodi comportamentali
    // metodi che in base alla scelta dell'utente mandano usando socket handler

    private boolean singlePlayer;

    public CliView(boolean singlePlayer) {
        this.singlePlayer = singlePlayer;
    }


    @Override
    public void run() {

        boolean loop = true;

        if (!isStarted) {
            System.out.println("Please wait, the game will start soon");
        }

    }




    //---------------------------ovveride metodi mostrano su view---------------------------------

    @Override
    public void setPlayerName(String username) {

        try {
            super.getConnection().setPlayerNameToServer(username, super.getPlayerID());
        }
        catch (RemoteException e) {
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
        int num;
        do {

            System.out.println("Choose your pattern Card - Enter a number between 1 and 4");
            num = reader.nextInt();
        }
        while (! ((num == 1) || (num == 2) || (num == 3) || (num == 4)  )) ;

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
    public void showOtherPattern(PatternCard patternCard, String name) {

        System.out.println("Now Pattern of" + name + "is: ");
        System.out.println(patternCard.toString());

    }

    @Override
    public void showPatternUpdate(PatternCard patternCard) {

        System.out.println("Now you're Pattern Card is");
        System.out.println(patternCard.toString());

    }

    @Override
    public void showTokens(int tokensNumber) {

        System.out.println("This your number of favor tokens available: " + tokensNumber);
    }

    @Override
    public void showCurrentRound(int round) {

        System.out.println("Round " + round + " is started");
    }

    @Override
    public void showCurrentTurn() {

        System.out.println("It's your turn");
    }

    @Override
    public void showOtherCurrentTurn(String username) {

        System.out.println("It's " + username + "'s turn");

    }

    @Override
    public void showRollCommand() {

        Scanner scanner = new Scanner(System.in);
        String command;
        do {

            System.out.println("Write the command ROLL to casually roll the draft pool");
            command = scanner.nextLine();
        }
        while (!(command.equalsIgnoreCase("roll") )) ;

        if (command.equalsIgnoreCase("roll")) {

            try {
                super.getConnection().setDraftPoolToServer();
            }
            catch (RemoteException e)  {
                System.out.println("error in inserting roll");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void showDraftPool(DraftPool draftPool) {
        System.out.println(draftPool.toString());
    }

    @Override
    public void showChooseCommand() {

        Scanner reader = new Scanner(System.in);
        int request;
        do {
            System.out.println("What do you want to do: ? - Enter 0 to put dice, 1 to use a tool card");
            request = reader.nextInt();
        }
        while (!( (request == 0) || (request == 1) ) ) ;

        if (request == 0) {

            try {
                super.getConnection().setChooseToServer(request);
            }
            catch (RemoteException e) {
                System.out.println("error in setting request");
                e.printStackTrace();
            }
        }

        if (request == 1) {

            try {
                super.getConnection().setChooseToServer(request);
            }
            catch (RemoteException e) {
                System.out.println("error in setting request");
                e.printStackTrace();
            }
        }


    }

    @Override
    public void showMoveCommand(int poolSize)   {

        Scanner reader = new Scanner(System.in);
        String response;
        do {
            System.out.println("Do you want to move a dice from the pool to the card? - Enter yes or no?");
            response = reader.nextLine();
        }
        while (!( (response.equalsIgnoreCase("yes")) || (response.equalsIgnoreCase("no")) ) );

        if (response.equalsIgnoreCase("yes")) {


            int indexPool;
            do {
                System.out.println("Enter the index of the dice from the pool - from 1 to " + poolSize);
                indexPool = reader.nextInt();
            }
            while ( (indexPool < 1) || (indexPool > poolSize) );
            indexPool--;



            int indexPattern;
            do {
                System.out.println("Enter the index of the Pattern Card - from 1 to 20");
                indexPattern = reader.nextInt();
            }
            while ( (indexPattern < 1) || (indexPattern > 20) );
            indexPattern--;

            try {
                super.getConnection().setMoveToServer(indexPool, indexPattern);
            }
            catch (RemoteException e) {
                System.out.println("error in setting dice");
                e.printStackTrace();
            }
        }

        if (response.equalsIgnoreCase("no")) {

            try {
                super.getConnection().setStartToolToServer();
            }
            catch (RemoteException e) {
                System.out.println(" error in sending tool");
                e.printStackTrace();
            }

        }

    }

    @Override
    public void showToolCommand(List<ToolCard> toolCards) {

        Scanner reader = new Scanner(System.in);
        String response;
        do {
            System.out.println("Do you want to use a Tool Card ? - Enter yes or no");
            response = reader.nextLine();
        }
        while (!( (response.equalsIgnoreCase("yes")) || (response.equalsIgnoreCase("no")) ) );

        if (response.equalsIgnoreCase("yes")) {

            int indexTool;
            do {
                System.out.println("Which tool card do you want to use? - Enter a number from 1 to 3");
                indexTool = reader.nextInt();
            }
            while (! ( (indexTool == 1) || (indexTool == 2) || (indexTool == 3)  )) ;
            indexTool--;

            Scanner scanner = new Scanner(System.in);
            String reply;
            do {
                System.out.println("Do you want to use " + toolCards.get(indexTool).getCost() + " Tokens to use this card? - Enter yes or no");
                reply = scanner.nextLine();
            }
            while (!( (reply.equalsIgnoreCase("yes")) || (reply.equalsIgnoreCase("no")) ) );


            if (reply.equalsIgnoreCase("yes")) {

                try {
                    super.getConnection().useToolCardToServer(indexTool);
                }
                catch (RemoteException e) {
                    System.out.println("Error in choosing tool");
                    e.printStackTrace();
                }
            }

        }

        if (response.equalsIgnoreCase("no")) {

            try {
                super.getConnection().setNextTurnToServer();
            }
            catch (RemoteException e) {
                System.out.println("Error in turning around");
                e.printStackTrace();
            }

        }
    }

    @Override
    public void showRoundTracker(RoundTracker roundTracker) {

        System.out.println("End of the round");
        System.out.println(roundTracker.toString());

    }

    @Override
    public void showFinalRank(List<Player> playerList) {

        System.out.println("Final Rank:");
        for (Player player : playerList) {
            System.out.println(player.toStringPoints());
        }

    }

    @Override
    public void showWinner() {

        System.out.println("You win !!!!!!!!!");
    }

    @Override
    public void showLosers() {

        System.out.println("You lose maaaan!");
    }

    @Override
    public void showTimer() {

        System.out.println("You'r time is over");
    }

    @Override
    public void showOtherTimer(String playerName) {

        System.out.println(playerName + "timer is ended");
    }

    @Override
    public  void showToolCards(List<ToolCard> toolCardList) {

        for (ToolCard toolCard : toolCardList) {
            System.out.println(toolCard.toString());
        }

    }

    @Override
    public void showTokenError() {
        System.out.println("You have not enough favor tokens to use this tool card");
    }

    @Override
    public void showGrozingRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Select a die from the pool - Enter a number between 1 and N");
        int index = reader.nextInt();
        index--;

        System.out.println("Do you want to increase (1) or decrease (0)");
        int increase = reader.nextInt();

        try {
            super.getConnection().useGrozingToolCard(index, increase);
        }
        catch (RemoteException e) {
            System.out.println("error in setting index");
            e.printStackTrace();
        }

    }

    @Override
    public void showEglomiseRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Select a die from the pattern card to move - Enter a number between 1 and 20");
        int indexStart = reader.nextInt();
        indexStart--;

        System.out.println("Enter the index where you want to move it - Enter a number between 1 and 20");
        int indexEnd = reader.nextInt();
        indexEnd--;

        try {
            super.getConnection().useEglomiseToolCard(indexStart, indexEnd);
        }
        catch (RemoteException e) {
            System.out.println("error in setting index");
            e.printStackTrace();
        }
    }

    @Override
    public void showCopperFoilRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Select ad die from the pattern card to move - Enter a number from 1 to 20");
        int indexStart = reader.nextInt();
        indexStart--;

        System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
        int indexEnd = reader.nextInt();
        indexEnd--;

        try {
            super.getConnection().useCopperFoilToolCard(indexStart, indexEnd);
        }
        catch (RemoteException e) {
            System.out.println("error in setting index");
            e.printStackTrace();
        }
    }

    @Override
    public void showLathekinRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Select the first die to move - Enter a number from 1 to 20");
        int indexStartOne = reader.nextInt();
        indexStartOne--;

        System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
        int indexEndOne = reader.nextInt();
        indexEndOne--;

        System.out.println("Select the second die to move - Enter a number from 1 to 20");
        int indexStartTwo = reader.nextInt();
        indexStartTwo--;

        System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
        int indexEndTwo = reader.nextInt();
        indexEndTwo--;

        try {
            super.getConnection().useLathekinToolCard(indexStartOne, indexEndOne, indexStartTwo, indexEndTwo);
        }
        catch (RemoteException e) {
            System.out.println("Error in setting index");
            e.printStackTrace();
        }
    }

    @Override
    public void showLensCutterRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Selected the die from the draft pool you want to change - Enter a number from 1 to N");
        int indexPool = reader.nextInt();
        indexPool--;

        System.out.println("Select the number of the round where you want to change - Enter a number from 1 to N");
        int indexRound = reader.nextInt();
        indexRound--;

        System.out.println("Selected the die of the round selected - Enter a number from 1 to N");
        int indexPosition = reader.nextInt();
        indexPosition--;

        try {
            super.getConnection().useLensCutterToolCard(indexPool, indexRound, indexPosition);
        }
        catch (RemoteException e) {
            System.out.println("error ins setting index lens cutter");
            e.printStackTrace();
        }
    }

    @Override
    public void showFluxBrushRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Selected the die to re-roll from the pool: - Enter a number between 1 and N");
        int indexPool = reader.nextInt();
        indexPool--;

        try {
            super.getConnection().useFluxBrushToolCard(indexPool);
        }
        catch (RemoteException e) {
            System.out.println("error in setting dice");
            e.printStackTrace();
        }
    }

    @Override
    public void showGlazingHammerRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter START to roll the dice of the draft pool" );
        String reply = reader.nextLine();

        if (reply.equalsIgnoreCase("start")) {

            try  {
                super.getConnection().useGlazingHammerToolCard();
            }
            catch (RemoteException e) {
                System.out.println("error in setting start");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void showRunningPliersRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Selected a dice from the pool, but you'll skip your next turnr - Enter a number from 1 to N");
        int indexPool = reader.nextInt();
        indexPool--;

        try {
            super.getConnection().useRunningPliersToolCard(indexPool);
        }
        catch (RemoteException e) {
            System.out.println("error in setting index pool");
            e.printStackTrace();
        }

    }

    @Override
    public void showCorkBackedRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Select a die from the pool - Enter a number from 1 to N");
        int indexPool = reader.nextInt();
        indexPool--;

        System.out.println("Enter where you want to put the dice in the pattern card - Enter a number from 1 to 20");
        int indexPattern = reader.nextInt();
        indexPattern--;

        try {
            super.getConnection().useCorkBackedToolCard(indexPool, indexPattern);
        }
        catch (RemoteException e) {
            System.out.println("error in tool 9");
            e.printStackTrace();
        }

    }

    @Override
    public void showGrindingStoneRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Select a die from the pool that should be flipped - Enter a number from 1 to N");
        int indexPool = reader.nextInt();
        indexPool--;

        try {
            super.getConnection().useGrindingStoneToolCard(indexPool);
        }
        catch (RemoteException e) {
            System.out.println("Error in tool 10");
            e.printStackTrace();
        }

    }

    @Override
    public void showFluxRemoverRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println();

    }

    @Override
    public void showTapWheelRequest() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the number of dice that you want to move - Enter 1 or 2");
        int number = reader.nextInt();

        if (number == 1) {

            System.out.println("Enter the index of the dice you want to move - Enter a number from 1 to 20");
            int indexStarOne = reader.nextInt();
            indexStarOne--;

            System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
            int indexEndOne = reader.nextInt();
            indexEndOne--;

            try {
                super.getConnection().useTapWheelToolCard(number, indexStarOne, indexEndOne, 0, 0);
            }
            catch (RemoteException e) {
                System.out.println("Error in setting first dice");
                e.printStackTrace();
            }

        }

        else {

            System.out.println("Enter the index of the dice you want to move - Enter a number from 1 to 20");
            int indexStarOne = reader.nextInt();
            indexStarOne--;

            System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
            int indexEndOne = reader.nextInt();
            indexEndOne--;

            System.out.println("Enter the index of the dice you want to move - Enter a number from 1 to 20");
            int indexStartTwo = reader.nextInt();
            indexStartTwo--;

            System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
            int indexEndTwo = reader.nextInt();
            indexEndTwo--;

            try {
                super.getConnection().useTapWheelToolCard(number, indexStarOne, indexEndOne, indexStarOne, indexEndTwo);
            }
            catch (RemoteException e) {
                System.out.println("error in setting second dice");
                e.printStackTrace();
            }

        }

    }

    @Override
    public void showBoard(RoundTracker roundTracker, DraftPool draftPool) {
        System.out.println("Now Round Tracker is:");
        System.out.println(roundTracker.toString());

        System.out.println("\n");
        System.out.println("Now Draft Pool is: ");
        System.out.println(draftPool.toString());
    }
}




