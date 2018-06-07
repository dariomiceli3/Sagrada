package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.*;
import it.polimi.se2018.server.model.Events.Event;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public class CliView extends View implements Runnable {

    // ovveride dei metodi dell'interfaccia view con gli show per metodi comportamentali
    // metodi che in base alla scelta dell'utente mandano usando socket handler

    private boolean singlePlayer;
    private static final int INITIALIZE = 99;

    public CliView( ) {
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
        int num = INITIALIZE;
        do {
            try {
                System.out.println("Choose your Pattern Card - Enter a number between 1 and 4");
                num = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are not entering a number, please enter a number");
            }
            reader.nextLine();
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
        int request = INITIALIZE;
        do {
            try {
                System.out.println("What do you want to do: ? - Enter 0 to put dice, 1 to use a tool card");
                request = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are not choosing what to do, please enter a number");

            }
            reader.nextLine();
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
    public void showMoveCommand(int poolSize)  {

        Scanner reader = new Scanner(System.in);
        String response;
        do {
            System.out.println("Do you want to move a dice from the pool to the card? - Enter yes or no?");
            response = reader.nextLine();
        }
        while (!( (response.equalsIgnoreCase("yes")) || (response.equalsIgnoreCase("no")) ) );

        if (response.equalsIgnoreCase("yes")) {


            int indexPool = INITIALIZE;
            do {
                try {
                    System.out.println("Enter the index of the dice from the pool - from 1 to " + poolSize);
                    indexPool = reader.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("You are entering a string, not an index of the pool");
                }
                reader.nextLine();
            }
            while ( (indexPool < 1) || (indexPool > poolSize) );
            indexPool--;



            int indexPattern = INITIALIZE;
            do {
                try {
                    System.out.println("Enter the index of the Pattern Card - from 1 to 20");
                    indexPattern = reader.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("You are entering a string, not an index of the card");
                }
                reader.nextLine();
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

            int indexTool = INITIALIZE;
            do {
                try {
                    System.out.println("Which tool card do you want to use? - Enter a number from 1 to 3");
                    indexTool = reader.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("You are entering a string, not the number of a toolcard");
                }
                reader.nextLine();
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
    public void showGrozingRequest(int poolSize) {

        Scanner reader = new Scanner(System.in);
        int index = INITIALIZE;
        do {
            try {
                System.out.println("Select a die from the pool - Enter a number between 1 and " + poolSize);
                index = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not an index of the draft pool");
            }
            reader.nextLine();
        }
        while ( (index < 1) || (index > poolSize) );
        index--;

        int increase = INITIALIZE;
        do {
            try {
                System.out.println("Do you want to increase (1) or decrease (0)");
                increase = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not choosing the effect of the card");
            }
            reader.nextLine();
        }
        while (! ( (increase == 0) || (increase == 1)));

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
        int indexStart = INITIALIZE;
        do {
            try {
                System.out.println("Select a die from the pattern card to move - Enter a number between 1 and 20");
                indexStart = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not an index of the card");
            }
            reader.nextLine();
        }
        while ( (indexStart < 1) || (indexStart > 20) );
        indexStart--;

        int indexEnd = INITIALIZE;
        do {
            try {
                System.out.println("Enter the index where you want to move it - Enter a number between 1 and 20");
                indexEnd = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not an index of the card");
            }
            reader.nextLine();
        }
        while ( (indexEnd < 1) || (indexEnd > 20) );
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
        int indexStart = INITIALIZE;
        do {
            try {
                System.out.println("Select ad die from the pattern card to move - Enter a number from 1 to 20");
                indexStart = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not the index of the card");
            }
            reader.nextLine();
        }
        while ( (indexStart < 1) || (indexStart > 20) );
        indexStart--;

        int indexEnd = INITIALIZE;
        do {
            try {
                System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
                indexEnd = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not the index of the card");
            }
            reader.nextLine();
        }
        while ( (indexEnd < 1) || (indexEnd > 20) );
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
        int indexStartOne = INITIALIZE;
        do {
            try {
                System.out.println("Select the first die to move - Enter a number from 1 to 20");
                indexStartOne = reader.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("You are entering a string, not an index of the card");
            }
            reader.nextLine();
        }
        while ( (indexStartOne < 1) || (indexStartOne > 20) );
        indexStartOne--;

        int indexEndOne = INITIALIZE;
        do {
            try {
                System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
                indexEndOne = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not an index of the card");
            }
            reader.nextLine();
        }
        while ( (indexEndOne < 1) || (indexEndOne > 20) );
        indexEndOne--;

        int indexStartTwo = INITIALIZE;
        do {
            try {
                System.out.println("Select the second die to move - Enter a number from 1 to 20");
                indexStartTwo = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not an index of the pattern card");
            }
            reader.nextLine();
        }
        while ( (indexStartTwo < 1) || (indexStartTwo > 20) );
        indexStartTwo--;

        int indexEndTwo = INITIALIZE;
        do {
            try {
                System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
                indexEndTwo = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not n index of the card");
            }
            reader.nextLine();
        }
        while ( (indexEndTwo < 1) || (indexEndTwo > 20) );
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
    public void showLensCutterRequest(int poolSize, List<Integer> round) {

        Scanner reader = new Scanner(System.in);
        int indexPool = INITIALIZE;
        do {
            try {
                System.out.println("Selected the die from the draft pool you want to change - Enter a number from 1 to " + poolSize);
                indexPool = reader.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("You are entering a string, not an index of the pool");
            }
            reader.nextLine();
        }
        while ( (indexPool < 1) || (indexPool > poolSize) );
        indexPool--;

        int indexRound = INITIALIZE;
        do {
            try {
                System.out.println("Select the number of the round where you want to change - Enter a number from 1 to " + round.size());
                indexRound = reader.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("You are entering a string, not the number of a round");
            }
            reader.nextLine();
        }
        while ( (indexRound < 1) || (indexRound > round.size()) );
        indexRound--;

        int indexPosition = INITIALIZE;
        do {
            try {
                System.out.println("Selected the die of the round selected - Enter a number from 1 to " + round.get(indexRound).toString());
                indexPosition = reader.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("You are entering a string, not an index of the round" + indexRound + "selected");
            }
            reader.nextLine();
        }
        while ( (indexPosition < 1) || (indexPosition > round.get(indexRound)) );
        indexPosition--;

        try {
            super.getConnection().useLensCutterToolCard(indexPool, indexRound, indexPosition);
        }
        catch (RemoteException e) {
            System.out.println("error in setting index lens cutter");
            e.printStackTrace();
        }
    }

    @Override
    public void showFluxBrushRequest(int poolSize) {

        Scanner reader = new Scanner(System.in);
        int indexPool = INITIALIZE;
        do {
            try {
                System.out.println("Selected the die to re-roll from the pool: - Enter a number between 1 and " + poolSize);
                indexPool = reader.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("You are entering a string, not an index of the pool");
            }
            reader.nextLine();
        }
        while ( (indexPool < 1) || (indexPool > poolSize) );
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
    public void showRunningPliersRequest(int poolSize) {

        Scanner reader = new Scanner(System.in);
        int indexPool = INITIALIZE;
        do {
            try {
                System.out.println("Selected a dice from the pool, but you'll skip your next turn - Enter a number from 1 to " + poolSize);
                indexPool = reader.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("You are entering a string, not an index of the draft pool");
            }
            reader.nextLine();
        }
        while ( (indexPool < 1) || (indexPool > poolSize) );
        indexPool--;

        int indexPattern = INITIALIZE;
        do {
            try {
                System.out.println("Enter the index where you want to put the dice - Enter a number between 1 and 20");
                indexPattern = reader.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("You are entering something wrong, not the index of the pattern card");
            }
            reader.nextLine();

        }
        while ( (indexPattern < 1 ) || (indexPattern > 20) );
        indexPattern--;

        try {
            super.getConnection().useRunningPliersToolCard(indexPool, indexPattern);
        }
        catch (RemoteException e) {
            System.out.println("error in setting index pool");
            e.printStackTrace();
        }

    }

    @Override
    public void showCorkBackedRequest(int poolSize) {

        Scanner reader = new Scanner(System.in);

        int indexPool = INITIALIZE;
        do {
            try {
                System.out.println("Select a die from the pool - Enter a number from 1 to " + poolSize);
                indexPool = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not a number of the pool");
            }
            reader.nextLine();
        }
        while ( (indexPool < 1) || (indexPool > poolSize) );
        indexPool--;

        int indexPattern = INITIALIZE;
        do {
            try {
                System.out.println("Enter where you want to put the dice in the pattern card - Enter a number from 1 to 20");
                indexPattern = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not an index of the card");
            }
            reader.nextLine();
        }
        while ( (indexPattern < 1) || (indexPattern > 20) );
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
    public void showGrindingStoneRequest(int poolSize) {

        Scanner reader = new Scanner(System.in);
        int indexPool = INITIALIZE;
        do {
            try {
                System.out.println("Select a die from the pool that should be flipped - Enter a number from 1 to " + poolSize);
                indexPool = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not an index of the pool");
            }
            reader.nextLine();
        }
        while ( (indexPool < 1) || (indexPool > poolSize) );
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
    public void showFluxRemoverRequest(DiceColor color, int poolSize) {

        Scanner reader = new Scanner(System.in);

        int indexPool = INITIALIZE;
        do {
            try {
                System.out.println("Select the die you want to return from the pool - Enter a number from 1 to " + poolSize);
                indexPool = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not the index");
            }
            reader.nextLine();
        }
        while ( (indexPool < 1) || (indexPool > poolSize) );
        indexPool--;

        System.out.println("The color of the die drafted from the bag is " + color.toString());

        int diceValue = INITIALIZE;
        do {
            try {
                System.out.println("Which value do you want for the dice? - Enter a number from 1 to 6");
                diceValue = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not the value of the dice");
            }
            reader.nextLine();
        }
        while ( (diceValue < 1) || (diceValue > 6) );

        try {
            super.getConnection().useFluxRemoverToolCard(indexPool, diceValue);
        }
        catch (RemoteException e) {
            System.out.println("error in setting the value");
            e.printStackTrace();
        }


    }

    @Override
    public void showTapWheelRequest() {

        Scanner reader = new Scanner(System.in);
        int number = INITIALIZE;
        do {
            try {
                System.out.println("Enter the number of dice that you want to move - Enter 1 or 2");
                number = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering a string, not the number");
            }
            reader.nextLine();
        }
        while (! ( (number == 1) || (number == 2)));


        if (number == 1) {

            int indexStarOne = INITIALIZE;
            do {
                try {
                    System.out.println("Enter the index of the dice you want to move - Enter a number from 1 to 20");
                    indexStarOne = reader.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("You are entering a string, not an index of the card");
                }
                reader.nextLine();
            }
            while ( (indexStarOne < 1) || (indexStarOne > 20) );
            indexStarOne--;

            int indexEndOne = INITIALIZE;
            do {
                try {
                    System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
                    indexEndOne = reader.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("You are entering a string, not the index of the pattern");
                }
                reader.nextLine();
            }
            while ( (indexEndOne < 1) || (indexEndOne > 20) );
            indexEndOne--;

            try {
                super.getConnection().useTapWheelToolCard(number, indexStarOne, indexEndOne, 0, 0);
            }
            catch (RemoteException e) {
                System.out.println("Error in setting first dice");
                e.printStackTrace();
            }

        }

        if (number == 2) {

            int indexStartOne = INITIALIZE;
            do {
                try {
                    System.out.println("Enter the index of the dice first dice you want to move - Enter a number from 1 to 20");
                    indexStartOne = reader.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("You are entering a string, not the index of the card");
                }
                reader.nextLine();
            }
            while ( (indexStartOne < 1) || (indexStartOne > 20) );
            indexStartOne--;

            int indexEndOne = INITIALIZE;
            do {
                try {
                    System.out.println("Enter the index where you want to move the 1st dice - Enter a number from 1 to 20");
                    indexEndOne = reader.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("You are entering a string, not the index of the your card");
                }
                reader.nextLine();
            }
            while ( (indexEndOne < 1) || (indexEndOne > 20) );
            indexEndOne--;

            int indexStartTwo = INITIALIZE;
            do {
                try {
                    System.out.println("Enter the index of the second dice you want to move - Enter a number from 1 to 20");
                    indexStartTwo = reader.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("You are entering a string , not the index of the card");
                }
                reader.nextLine();
            }
            while ( (indexStartTwo < 1) || (indexStartTwo > 20) );
            indexStartTwo--;

            int indexEndTwo = INITIALIZE;
            do {
                try {
                    System.out.println("Enter the index where you want to move the 2nd dice - Enter a number from 1 to 20");
                    indexEndTwo = reader.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("You are entering a string ,  not an index of the card");
                }
                reader.nextLine();
            }
            while ( (indexEndTwo < 1) || (indexEndTwo > 20) );
            indexEndTwo--;

            try {
                super.getConnection().useTapWheelToolCard(number, indexStartOne, indexEndOne, indexStartTwo, indexEndTwo);
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

    @Override
    public void showInvalidMove(String msg) {

        System.out.println("ERROR: " + msg);
    }



    //---------------------------------------single player

    @Override
    public void showSinglePlayerRequest() {

        Scanner reader = new Scanner(System.in);
        String mode;
        do {
            System.out.println("How do you want to play: Single or Multi?");
            mode = reader.nextLine();
        }
        while (!((mode.equalsIgnoreCase("single") || mode.equalsIgnoreCase("multi")))) ;

        if (mode.equalsIgnoreCase("single")) {
            singlePlayer = true;
            System.out.println("Now the game will start");
        }

        if (mode.equalsIgnoreCase("multi")) {
            singlePlayer = false;
            System.out.println("Please wait, the game will start soon");
        }

        try {
            super.getConnection().setSinglePlayerMode(super.getPlayerID(), singlePlayer);
        }
        catch (RemoteException e) {
            System.out.println("error in setting index");
            e.printStackTrace();
        }
    }

    @Override
    public void showDifficultyRequest() {

        Scanner reader = new Scanner(System.in);
        int difficulty = INITIALIZE;

        do {
            try {
                System.out.println("You have to choose the difficulty - Enter a number from 1 to 5 - This will change the number of the Tool Card");
                difficulty = reader.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("You are entering something wrong, please read the request");
            }
            reader.nextLine();
        }
        while ( (difficulty < 1) || (difficulty > 5) );

        try {
            super.getConnection().setDifficultyToServer(difficulty);
        }
        catch (RemoteException e) {
            System.out.println("error in setting difficulty");
            e.printStackTrace();
        }

    }

    @Override
    public void showPrivateSingle(List<PrivateObjectiveCard> publicList) {

        for (PrivateObjectiveCard privateCard : publicList) {
            System.out.println(privateCard.toString());
        }

    }
}




