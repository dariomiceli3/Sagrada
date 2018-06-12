package it.polimi.se2018.client.view;

import it.polimi.se2018.client.Client;
import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.client.view.gui.GUI;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.*;
import javafx.application.Application;

import java.util.*;
import java.util.List;



public class CliView extends View implements Runnable {

    // ovveride dei metodi dell'interfaccia view con gli show per metodi comportamentali
    // metodi che in base alla scelta dell'utente mandano usando socket handler


    private static ViewState cliState;
    private static int poolSize;
    private static int indexPool;
    private static int indexPattern;
    private static int indexTool;
    private static int indexStartOne;
    private static int indexStartTwo;
    private static int indexEndOne;
    private static int indexEndTwo;
    private static int indexRound;
    private static List<Integer> toolCost;
    private static List<Integer> roundList;
    private static DiceColor colorDice;
    private static int diceNumber;
    private static int toolSingleNumber;
    private ClientInterface connection;

    public CliView() {
        Application.launch(GUI.class);
    }

    public static int getPoolSize() {
        return poolSize;
    }


    public static int getIndexPool() {
        return indexPool;
    }

    public static int getIndexPattern() {
        return indexPattern;
    }

    public static List<Integer> getToolCost() {
        return toolCost;
    }

    public static int getIndexTool() {
        return indexTool;
    }

    public static int getIndexStartOne() {
        return indexStartOne;
    }

    public static int getIndexStartTwo() {
        return indexStartTwo;
    }

    public static int getIndexEndOne() {
        return indexEndOne;
    }

    public static int getIndexEndTwo() {
        return indexEndTwo;
    }

    public static int getIndexRound() {
        return indexRound;
    }

    public static int getToolSingleNumber() {
        return toolSingleNumber;
    }

    public static DiceColor getColorDice() {
        return colorDice;
    }

    public static int getDiceNumber() {
        return diceNumber;
    }

    public static void setToolCost(List<Integer> toolCoost) {
        CliView.toolCost = toolCoost;
    }

    public static List<Integer> getRound() {
        return roundList;
    }

    public static void setPoolSize(int poolSize) {
        CliView.poolSize = poolSize;
    }

    public static void setIndexPool(int indexPool) {
        CliView.indexPool = indexPool;
    }

    public static void setIndexPattern(int indexPattern) {
        CliView.indexPattern = indexPattern;
    }

    public static void setIndexTool(int indexTool) {
        CliView.indexTool = indexTool;
    }

    public static void setIndexStartOne(int indexStartOne) {
        CliView.indexStartOne = indexStartOne;
    }

    public static void setIndexStartTwo(int indexStartTwo) {
        CliView.indexStartTwo = indexStartTwo;
    }

    public static void setIndexEndOne(int indexEndOne) {
        CliView.indexEndOne = indexEndOne;
    }

    public static void setIndexEndTwo(int indexEndTwo) {
        CliView.indexEndTwo = indexEndTwo;
    }

    public static void setRound(List<Integer> round) {
        CliView.roundList = round;
    }

    public static void setIndexRound(int indexRound) {
        CliView.indexRound = indexRound;
    }

    public static void setColorDice(DiceColor colorDice) {
        CliView.colorDice = colorDice;
    }

    public static void setDiceNumber(int diceNumber) {
        CliView.diceNumber = diceNumber;
    }

    public static void setToolSingleNumber(int toolSingleNumber) {
        CliView.toolSingleNumber = toolSingleNumber;
    }

    @Override
    public void run() {

        Scanner reader = new Scanner(System.in);
        boolean loop = true;
        String input;

        while (loop) {

            input = reader.nextLine();

            if (input.isEmpty()) {
                System.out.println("You are not writing nothing");
            } else if (cliState == ViewState.NOTAUTHORIZED) {
                if (input.matches(".*[a-zA-Z0-9]+.*")){
                    System.out.println("Please, it's not your turn! Waiting for your moment");
                }
            } else if (cliState == ViewState.MODE) {
                if (input.equalsIgnoreCase("multi")) {
                    System.out.println("Please wait, the game will start soon");
                    getConnection().setSinglePlayerMode(super.getPlayerID(), false);
                } else if (input.equalsIgnoreCase("single")) {
                    System.out.println("Now the game will start");
                    getConnection().setSinglePlayerMode(super.getPlayerID(), true);
                } else {
                    System.out.println("You are not choosing a mode to play");
                    showSinglePlayerRequest();
                }
            } else if (cliState == ViewState.NAME || cliState == ViewState.ERRORNAME) {
                if (input.matches(".*[a-zA-Z0-9]+.*")) {
                    getConnection().setPlayerNameToServer(input, super.getPlayerID());
                } else {
                    System.out.println("blank name");
                }

            } else if (cliState == ViewState.PATTERN) {
                try {
                    int choose = Integer.parseInt(input);

                    if (choose >= 1 && choose <= 4) {
                        choose--;
                        getConnection().setPatternCardToServer(choose, super.getPlayerID());
                    } else {
                        System.out.println("Please, decide which pattern to use");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number between 1 and 4!");
                }

            } else if (cliState == ViewState.ROLL) {

                if (input.equalsIgnoreCase("roll")) {
                    getConnection().setDraftPoolToServer();
                } else {
                    System.out.println("Please, enter the command ROLL");
                    showRollCommand();
                }

            } else if (cliState == ViewState.CHOOSE) {
                try {
                    int command = Integer.parseInt(input);
                    if (command == 0 || command == 1) {
                        getConnection().setChooseToServer(command);
                    } else {
                        System.out.println("Please enter the correct number");
                        showChooseCommand();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number, 0 or 1!");
                    showChooseCommand();
                }
            } else if (cliState == ViewState.MOVE) {

                if (input.equalsIgnoreCase("yes")) {
                    showIndexPoolCommand(poolSize);
                } else if (input.equalsIgnoreCase("no")) {
                    getConnection().setStartToolToServer();
                } else {
                    System.out.println("You are not entering the expected command");
                    showMoveCommand(poolSize);
                }
            } else if (cliState == ViewState.POOLINDEX) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= poolSize) {
                        idPool--;
                        setIndexPool(idPool);
                        showIndexPatternCommand();
                    } else {
                        System.out.println("Please enter a right index");
                        showIndexPoolCommand(poolSize);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the command expected");
                    showIndexPoolCommand(poolSize);
                }
            } else if (cliState == ViewState.PATTERNINDEX) {
                try {
                    int idPattern = Integer.parseInt(input);
                    if (idPattern >= 1 && idPattern <= 20) {
                        idPattern--;
                        setIndexPattern(idPattern);
                        getConnection().setMoveToServer(indexPool, indexPattern);
                    } else {
                        System.out.println("Please enter the correct number");
                        showIndexPatternCommand();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are entering the wrong command");
                    System.out.println("Enter the index of the Pattern Card - Enter a number between 1 and 20");

                }
            } else if (cliState == ViewState.TOOL) {
                if (input.equalsIgnoreCase("yes")) {
                    showToolChooseCommand();

                } else if (input.equalsIgnoreCase("no")) {
                    getConnection().setNextTurnToServer();

                } else {
                    System.out.println("You are not entering the right command");
                    System.out.println("Do you want to use a Tool Card ? - Enter yes or no");

                }
            } else if (cliState == ViewState.TOOLINDEX) {
                try {
                    int idTool = Integer.parseInt(input);
                    if (idTool >= 1 && idTool <= 3) {
                        idTool--;
                        setIndexTool(idTool);
                        showToolCostCommand(toolCost, indexTool);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("You are entering a wrong command");
                    showToolChooseCommand();
                }
            } else if (cliState == ViewState.TOOLCOST) {

                if (input.equalsIgnoreCase("yes")) {
                    getConnection().useToolCardToServer(indexTool);
                } else if (input.equalsIgnoreCase("no")) {
                    getConnection().setNoTokenToServer();
                } else {
                    System.out.println("You are entering the wrong command");
                    showToolCostCommand(toolCost, indexTool);
                }

            }

            //--------------------tool card--------------------------------------------------------------------------

            else if (cliState == ViewState.GROZINGPOOL) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= poolSize) {
                        idPool--;
                        setIndexPool(idPool);
                        showGrozingCommand();
                    } else {
                        System.out.println("Please enter a right index");
                        showGrozingRequest(poolSize);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the right command");
                    showGrozingRequest(poolSize);
                }

            } else if (cliState == ViewState.GROZINGCOMMAND) {
                try {
                    int increase = Integer.parseInt(input);
                    if (increase == 0 || increase == 1) {
                        getConnection().useGrozingToolCard(indexPool, increase);
                    } else {
                        System.out.println("You are not choosing what to do");
                        showGrozingCommand();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the correct number");
                    showGrozingCommand();
                }
            } else if (cliState == ViewState.EGLOMISESTART) {
                try {
                    int idOne = Integer.parseInt(input);
                    if (idOne >= 1 && idOne <= 20) {
                        idOne--;
                        setIndexStartOne(idOne);
                        showEglomiseEnd();
                    } else {
                        System.out.println("Please enter the right index");
                        showEglomiseStart();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the index of a pattern card");
                    showEglomiseStart();
                }

            } else if (cliState == ViewState.EGLOMISEEND) {
                try {
                    int idTwo = Integer.parseInt(input);
                    if (idTwo >= 1 && idTwo <= 20) {
                        idTwo--;
                        setIndexEndOne(idTwo);
                        getConnection().useEglomiseToolCard(indexStartOne, indexEndOne);
                    } else {
                        System.out.println("Please, enter the right index");
                        showEglomiseEnd();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the index of a Pattern Card");
                    showEglomiseEnd();
                }
            } else if (cliState == ViewState.COPPERSTART) {
                try {
                    int idOne = Integer.parseInt(input);
                    if (idOne >= 1 && idOne <= 20) {
                        idOne--;
                        setIndexStartOne(idOne);
                        showCopperFoilEnd();
                    } else {
                        System.out.println("Please enter the right index");
                        showCopperFoilStart();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the index of a pattern card");
                    showCopperFoilStart();
                }
            } else if (cliState == ViewState.COPPEREND) {
                try {
                    int idTwo = Integer.parseInt(input);
                    if (idTwo >= 1 && idTwo <= 20) {
                        idTwo--;
                        setIndexEndOne(idTwo);
                        getConnection().useCopperFoilToolCard(indexStartOne, indexEndOne);
                    } else {
                        System.out.println("Please, enter the right index");
                        showCopperFoilEnd();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the index of a Pattern Card");
                    showCopperFoilEnd();
                }
            } else if (cliState == ViewState.LATHEKINSTARTONE) {
                try {
                    int idOne = Integer.parseInt(input);
                    if (idOne >= 1 && idOne <= 20) {
                        idOne--;
                        setIndexStartOne(idOne);
                        showLathekinEnd();
                    } else {
                        System.out.println("Please enter a right index");
                        showLathekinStart();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the index of a Pattern Card");
                    showLathekinStart();
                }

            } else if (cliState == ViewState.LATHEKINENDONE) {
                try {
                    int idEnd = Integer.parseInt(input);
                    if (idEnd >= 1 && idEnd <= 20) {
                        idEnd--;
                        setIndexEndOne(idEnd);
                        showLathekinStartTwo();
                    } else {
                        System.out.println("Please enter the right index");
                        showLathekinEnd();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the index of a Pattern Card");
                    showLathekinEnd();
                }

            } else if (cliState == ViewState.LATHEKINSTARTTWO) {
                try {
                    int idTwo = Integer.parseInt(input);
                    if (idTwo >= 1 && idTwo <= 20) {
                        idTwo--;
                        setIndexStartTwo(idTwo);
                        showLathekinEndTwo();
                    } else {
                        System.out.println("Please enter a right index");
                        showLathekinStartTwo();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the index of a Pattern Card");
                    showLathekinStartTwo();
                }

            } else if (cliState == ViewState.LATHEKINENDTWO) {

                try {
                    int idEndTwo = Integer.parseInt(input);
                    if (idEndTwo >= 1 && idEndTwo <= 20) {
                        idEndTwo--;
                        setIndexEndTwo(idEndTwo);
                        getConnection().useLathekinToolCard(indexStartOne, indexEndOne, indexStartTwo, indexEndTwo);
                    } else {
                        System.out.println("Please enter a right index");
                        showLathekinEndTwo();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("You are not entering an index of the Pattern Card");
                    showLathekinEndTwo();
                }

            } else if (cliState == ViewState.LENSCUTTERPOOL) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= getPoolSize()) {
                        idPool--;
                        setIndexPool(idPool);
                        showLensCutterRound(roundList);
                    } else {
                        System.out.println("Please enter an index in the correct range");
                        showLensCutterRequest(poolSize, roundList);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering an index of the pool");
                    showLensCutterRequest(poolSize, roundList);
                }
            } else if (cliState == ViewState.LENSCUTTERROUND) {
                try {
                    int idRound = Integer.parseInt(input);
                    if (idRound >= 1 && idRound <= getRound().size()) {
                        idRound--;
                        setIndexRound(idRound);
                        showLensCutterDice(roundList, indexRound);
                    } else {
                        System.out.println("Please enter an index in the range");
                        showLensCutterRound(roundList);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the index of a round");
                    showLensCutterRound(roundList);
                }
            } else if (cliState == ViewState.LENSCUTTERDICE) {
                try {
                    int idPos = Integer.parseInt(input);
                    if (idPos >= 1 && idPos <= roundList.get(indexRound)) {
                        idPos--;
                        getConnection().useLensCutterToolCard(indexPool, indexRound, idPos);
                    } else {
                        System.out.println("Please enter a number in the range");
                        showLensCutterDice(roundList, indexRound);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the index of a dice");
                    showLensCutterDice(roundList, indexRound);
                }
            } else if (cliState == ViewState.FLUXBRUSH) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= getPoolSize()) {
                        idPool--;
                        setIndexPool(idPool);
                        getConnection().useFluxBrushToolCard(indexPool);
                    } else {
                        System.out.println("Please enter a number in the range");
                        showFluxBrushRequest(poolSize);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering an index in the range of the pool");
                    showFluxBrushRequest(poolSize);
                }
            } else if (cliState == ViewState.GLAZINGHAMMER) {
                if (input.equalsIgnoreCase("start")) {
                    getConnection().useGlazingHammerToolCard();
                } else {
                    System.out.println("Command not recognized for this card");
                }
            } else if (cliState == ViewState.RUNNINGPOOL) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= getPoolSize()) {
                        idPool--;
                        setIndexPool(idPool);
                        showRunningPliersEnd();
                    } else {
                        System.out.println("Please enter a number in the range");
                        showRunningPliersPool(poolSize);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering an index in the correct range");
                    showRunningPliersPool(poolSize);
                }

            } else if (cliState == ViewState.RUNNINGEND) {
                try {
                    int idPattern = Integer.parseInt(input);
                    if (idPattern >= 1 && idPattern <= 20) {
                        idPattern--;
                        setIndexEndOne(idPattern);
                        getConnection().useRunningPliersToolCard(indexPool, indexEndOne);
                    } else {
                        System.out.println("Please enter a number between 1 and 20");
                        showRunningPliersEnd();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You aren't entering an index correct");
                    showRunningPliersEnd();
                }

            } else if (cliState == ViewState.CORKPOOL) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= getPoolSize()) {
                        idPool--;
                        setIndexPool(idPool);
                        showCorkBackedEnd();
                    } else {
                        System.out.println("Please, enter a number in the correct range");
                        showCorkBackedPool(poolSize);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You aren't entering a correct index");
                    showCorkBackedPool(poolSize);
                }
            } else if (cliState == ViewState.CORKEND) {
                try {
                    int idPattern = Integer.parseInt(input);
                    if (idPattern >= 1 && idPattern <= 20) {
                        idPattern--;
                        setIndexEndOne(idPattern);
                        getConnection().useCorkBackedToolCard(indexPool, indexEndOne);
                    } else {
                        System.out.println("Please, enter a number in the range");
                        showCorkBackedEnd();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering an index of the card");
                    showCorkBackedEnd();
                }
            } else if (cliState == ViewState.GRINDING) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= getPoolSize()) {
                        idPool--;
                        setIndexPool(idPool);
                        getConnection().useGrindingStoneToolCard(indexPool);
                    } else {
                        System.out.println("Please, enter a number in the range correct");
                        showGrindingStoneRequest(poolSize);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("You are not entering an index for choosing the dice");
                    showGrindingStoneRequest(poolSize);
                }
            } else if (cliState == ViewState.FLUXPOOL) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= getPoolSize()) {
                        idPool--;
                        setIndexPool(idPool);
                        showFluxRemoverValue();
                    } else {
                        System.out.println("Please, enter a number in the correct range to continue the game");
                        showFluxRemoverPool(colorDice, poolSize);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering an index of the draft pool");
                    showFluxRemoverPool(colorDice, poolSize);
                }
            } else if (cliState == ViewState.FLUXVALUE) {
                try {
                    int value = Integer.parseInt(input);
                    if (value >= 1 && value <= 6) {
                        getConnection().useFluxRemoverToolCard(indexPool, value);
                    } else {
                        System.out.println("Please, a dice should have as value" + value);
                        showFluxRemoverValue();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering a numeric value for the dice");
                    showFluxRemoverValue();
                }

            } else if (cliState == ViewState.TAPNUMBER) {
                try {
                    int num = Integer.parseInt(input);
                    if (num == 1 || num == 2) {
                        setDiceNumber(num);
                        showTapWheelStartOne();
                    } else {
                        System.out.println("Please, enter a correct value!");
                        showTapWheelNumber();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the value expected");
                    showTapWheelNumber();
                }
            } else if (cliState == ViewState.TAPSTARTONE) {
                try {
                    int idStartOne = Integer.parseInt(input);
                    if (idStartOne >= 1 && idStartOne <= 20) {
                        idStartOne--;
                        setIndexStartOne(idStartOne);
                        showTapWheelEndOne();
                    } else {
                        System.out.println("Please,enter a correct index for the pattern");
                        showTapWheelStartOne();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the expected value");
                    showTapWheelStartOne();
                }
            } else if (cliState == ViewState.TAPENDONE) {
                try {
                    int idEndOne = Integer.parseInt(input);
                    if (idEndOne >= 1 && idEndOne <= 20) {
                        idEndOne--;
                        setIndexEndOne(idEndOne);

                        if (getDiceNumber() == 1) {
                            getConnection().useTapWheelToolCard(getDiceNumber(), indexStartOne, indexEndOne, 0, 0);
                        } else {
                            showTapWheelStartTwo();
                        }
                    } else {
                        System.out.println("Please, enter a correct index for the range");
                        showTapWheelEndOne();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the correct index");
                    showTapWheelEndOne();
                }
            } else if (cliState == ViewState.TAPSTARTTWO) {
                try {
                    int idStartTwo = Integer.parseInt(input);
                    if (idStartTwo >= 1 && idStartTwo <= 20) {
                        idStartTwo--;
                        setIndexStartTwo(idStartTwo);
                        showTapWheelEndTwo();
                    } else {
                        System.out.println("Please, enter the index for the range");
                        showTapWheelStartTwo();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the correct index");
                    showTapWheelStartTwo();
                }
            } else if (cliState == ViewState.TAPENDTWO) {
                try {
                    int idEndTwo = Integer.parseInt(input);
                    if (idEndTwo >= 1 && idEndTwo <= 20) {
                        idEndTwo--;
                        setIndexEndTwo(idEndTwo);
                        getConnection().useTapWheelToolCard(getDiceNumber(), indexStartOne, indexEndOne, indexStartTwo, indexEndTwo);
                    } else {
                        System.out.println("Please, enter the index correct for the range");
                        showTapWheelEndTwo();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering the correct index");
                    showTapWheelEndTwo();
                }
            }

            //------------------------single player--------------------------------------------------------

            else if (cliState == ViewState.DIFFICULTYSP) {
                try {
                    int difficulty = Integer.parseInt(input);
                    if (difficulty >= 1 && difficulty <= 5) {
                        getConnection().setDifficultyToServer(difficulty);
                    } else {
                        System.out.println("Please, enter the difficulty");
                        showDifficultyRequest();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not choosing the difficulty");
                    showDifficultyRequest();
                }
            } else if (cliState == ViewState.TOOLSP) {
                if (input.equalsIgnoreCase("yes")) {
                    showToolSingleChoose();
                } else if (input.equalsIgnoreCase("no")) {
                    getConnection().setNextTurnToServer();
                } else {
                    System.out.println("You are not entering the right command");
                    System.out.println("Do you want to use a Tool Card ? - Enter yes or no");
                }
            } else if (cliState == ViewState.TOOLSPCHOOSE) {
                try {
                    int index = Integer.parseInt(input);
                    if (index >= 1 && index <= getToolSingleNumber()) {
                        index--;
                        setIndexTool(index);
                        showToolSingleDice();
                    } else {
                        System.out.println("Please, enter the right command");
                        showToolSingleChoose();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not entering an index");
                    showToolSingleChoose();
                }
            } else if (cliState == ViewState.TOOLSPDICE) {
                try {
                    int idDice = Integer.parseInt(input);
                    if (idDice >= 1 && idDice <= getPoolSize()) {
                        idDice--;
                        setIndexPool(idDice);
                        getConnection().useToolSingleToServer(indexTool, indexPool);
                    } else {
                        System.out.println("Please, enter the right command");
                        showToolSingleDice();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You are not choosing the dice");
                    showToolSingleDice();
                }
            }

        }
    }




    //---------------------------ovveride metodi mostrano su view---------------------------------


    @Override
    public ClientInterface getConnection() {
        return connection;
    }

    @Override
    public void setConnection(ClientInterface connection) {
        this.connection = connection;
    }

    @Override
    public void showID() {
        System.out.println("Player id set " + super.getPlayerID());
    }

    @Override
    public void showSinglePlayerRequest() {
        cliState = ViewState.MODE;
        System.out.println("How do you want to play: Single or Multi?");
    }



    @Override
    public void showGameStarted() {
        System.out.println("Game started: " + super.isStarted());
    }


    @Override
    public void showNameChoose() {
        cliState = ViewState.NAME;
        System.out.println("Enter your name: ");
    }

    @Override
    public void showName() {
        cliState = ViewState.NOTAUTHORIZED;
        System.out.println("Name set as: " + super.getPlayerName());
    }

    @Override
    public void showNameOther(String name) {
        System.out.println("Another player connected with name: " + name);
    }


    @Override
    public void showNameError() {
        cliState = ViewState.ERRORNAME;
        System.out.println("This name is used by another player!");
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

        cliState = ViewState.PATTERN;
        System.out.println("Choose your Pattern Card - Enter a number between 1 and 4");
    }


    @Override
    public void showPattern(PatternCard patternCard) {
        System.out.println("This is the PatternCard you will use ");
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
        cliState = ViewState.NOTAUTHORIZED;
        System.out.println("It's " + username + "'s turn");

    }

    @Override
    public void showRollCommand() {
        cliState = ViewState.ROLL;
        System.out.println("Write the command ROLL to casually roll the draft pool");
    }

    @Override
    public void showDraftPool(DraftPool draftPool) {
        System.out.println(draftPool.toString());
    }

    @Override
    public void showChooseCommand() {
        cliState = ViewState.CHOOSE;
        System.out.println("What do you want to do: ? - Enter 0 to put dice, 1 to use a tool card");

    }

    @Override
    public void showMoveCommand(int poolSize)  {
        setPoolSize(poolSize);
        cliState = ViewState.MOVE;
        System.out.println("Do you want to move a dice from the pool to the card? - Enter yes or no?");

    }

    @Override
    public void showIndexPoolCommand(int poolSize) {
        setPoolSize(poolSize);
        cliState = ViewState.POOLINDEX;
        System.out.println("Enter the index of the dice from the pool - from 1 to " + getPoolSize());
    }

    @Override
    public void showIndexPatternCommand() {
        cliState = ViewState.PATTERNINDEX;
        System.out.println("Enter the index of the Pattern Card - Enter a number between 1 and 20");
    }

    @Override
    public void showToolCommand(List<ToolCard> toolCards) {
        toolCost = new ArrayList<>();
        for(ToolCard tool : toolCards) {
            toolCost.add(tool.getCost());
        }
        cliState = ViewState.TOOL;
        System.out.println("Do you want to use a Tool Card ? - Enter yes or no");
    }

    @Override
    public void showToolChooseCommand() {
        cliState = ViewState.TOOLINDEX;
        System.out.println("Which tool card do you want to use? - Enter a number from 1 to 3");
    }

    @Override
    public void showToolCostCommand(List<Integer> toolCost, int indexTool) {
        cliState = ViewState.TOOLCOST;
        int cost = toolCost.get(indexTool);
        System.out.println("Do you want to use " + cost + " tokens to use this card? - Enter yes or no");
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
        System.out.println(playerName + " turn time is ended");
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



    //------------------------tool card----------------------------------------------------------------------------


    // tool grozing pliers
    @Override
    public void showGrozingRequest(int poolSize) {
        setPoolSize(poolSize);
        cliState = ViewState.GROZINGPOOL;
        System.out.println("Select a die from the pool - Enter a number between 1 and " + getPoolSize());

    }

    @Override
    public void showGrozingCommand() {
        cliState = ViewState.GROZINGCOMMAND;
        System.out.println("Do you want to increase (1) or decrease (0)");
    }



    // tool eglomise brush
    @Override
    public void showEglomiseStart() {
        cliState = ViewState.EGLOMISESTART;
        System.out.println("Select a die from the pattern card to move - Enter a number between 1 and 20");
    }

    @Override
    public void showEglomiseEnd() {
        cliState = ViewState.EGLOMISEEND;
        System.out.println("Enter the index where you want to move it - Enter a number between 1 and 20");

    }


    // tool copper foil burnisher
    @Override
    public void showCopperFoilStart() {
        cliState = ViewState.COPPERSTART;
        System.out.println("Select ad die from the pattern card to move - Enter a number from 1 to 20");

    }

    @Override
    public void showCopperFoilEnd() {
        cliState = ViewState.COPPEREND;
        System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
    }


    // tool lathekin
    @Override
    public void showLathekinStart() {
        cliState = ViewState.LATHEKINSTARTONE;
        System.out.println("Select the first die to move - Enter a number from 1 to 20");
    }


    @Override
    public void showLathekinEnd() {
        cliState = ViewState.LATHEKINENDONE;
        System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
    }


    @Override
    public void showLathekinStartTwo() {
        cliState = ViewState.LATHEKINSTARTTWO;
        System.out.println("Select the second die to move - Enter a number from 1 to 20");
    }

    @Override
    public void showLathekinEndTwo() {
        cliState = ViewState.LATHEKINENDTWO;
        System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
    }



    // tool lens cutter
    @Override
    public void showLensCutterRequest(int poolSize, List<Integer> round) {
        roundList = new ArrayList<>();
        for (Integer integer : round) {
            roundList.add(integer);
        }
        setPoolSize(poolSize);
        cliState = ViewState.LENSCUTTERPOOL;
        System.out.println("Selected the die from the draft pool you want to change - Enter a number from 1 to " + getPoolSize());
    }

    @Override
    public void showLensCutterRound(List<Integer> round) {
        cliState = ViewState.LENSCUTTERROUND;
        System.out.println("Select the number of the round where you want to change - Enter a number from 1 to " + round.size());
    }

    @Override
    public void showLensCutterDice(List<Integer> round, int roundIndex) {
        cliState = ViewState.LENSCUTTERDICE;
        System.out.println("Selected the die of the round selected - Enter a number from 1 to " + round.get(roundIndex).toString());
    }



    // tool flux brush
    @Override
    public void showFluxBrushRequest(int poolSize) {
        setPoolSize(poolSize);
        cliState = ViewState.FLUXBRUSH;
        System.out.println("Selected the die to re-roll from the pool: - Enter a number between 1 and " + getPoolSize());
    }


    // tool glazing hammer
    @Override
    public void showGlazingHammerRequest() {
        cliState = ViewState.GLAZINGHAMMER;
        System.out.println("Enter START to roll the dice of the draft pool" );
    }

    // tool running pliers
    @Override
    public void showRunningPliersPool(int poolSize) {
        setPoolSize(poolSize);
        cliState = ViewState.RUNNINGPOOL;
        System.out.println("Selected a dice from the pool, but you'll skip your next turn - Enter a number from 1 to " + getPoolSize());

    }

    @Override
    public void showRunningPliersEnd() {
        cliState = ViewState.RUNNINGEND;
        System.out.println("Enter the index where you want to put the dice - Enter a number between 1 and 20");
    }



    // tool card cork backed straightedge
    @Override
    public void showCorkBackedPool(int poolSize) {
        setPoolSize(poolSize);
        cliState = ViewState.CORKPOOL;
        System.out.println("Select a die from the pool - Enter a number from 1 to " + getPoolSize());
    }

    @Override
    public void showCorkBackedEnd() {
        cliState = ViewState.CORKEND;
        System.out.println("Enter where you want to put the dice in the pattern card - Enter a number from 1 to 20");
    }



    // tool card grinding stone
    @Override
    public void showGrindingStoneRequest(int poolSize) {
        setPoolSize(poolSize);
        cliState = ViewState.GRINDING;
        System.out.println("Select a die from the pool that should be flipped - Enter a number from 1 to " + getPoolSize());
    }

    // tool card flux remover
    @Override
    public void showFluxRemoverPool(DiceColor color, int poolSize) {
        setPoolSize(poolSize);
        setColorDice(color);
        cliState = ViewState.FLUXPOOL;
        System.out.println("Select the die you want to return from the pool - Enter a number from 1 to " + getPoolSize());
    }

    @Override
    public void showFluxRemoverValue() {
        cliState = ViewState.FLUXVALUE;
        System.out.println("The color of the die drafted from the bag is " + getColorDice().toString());
        System.out.println("Which value do you want for the dice? - Enter a number from 1 to 6");
    }

    // tool card thap wheel
    @Override
    public void showTapWheelNumber() {
        cliState = ViewState.TAPNUMBER;
        System.out.println("Enter the number of dice that you want to move - Enter 1 or 2");
    }

    @Override
    public void showTapWheelStartOne() {
        cliState = ViewState.TAPSTARTONE;
        System.out.println("Enter the index of the 1st dice you want to move - Enter a number from 1 to 20");
    }

    @Override
    public void showTapWheelEndOne() {
        cliState = ViewState.TAPENDONE;
        System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
    }

    @Override
    public void showTapWheelStartTwo() {
        cliState = ViewState.TAPSTARTTWO;
        System.out.println("Enter the index of the 2nd dice you want to move - Enter a number from 1 to 20");
    }

    @Override
    public void showTapWheelEndTwo() {
        cliState = ViewState.TAPENDTWO;
        System.out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
    }


    @Override
    public void showBoard(RoundTracker roundTracker, DraftPool draftPool) {
        System.out.println("Now Round Tracker is:");
        System.out.println(roundTracker.toString());
        System.out.println("Now Draft Pool is: ");
        System.out.println(draftPool.toString());
    }

    @Override
    public void showInvalidMove(String msg) {
        System.out.println("ERROR: " + msg);
    }



    //---------------------------------------single player-------------------------------------------------------------


    @Override
    public void showDifficultyRequest() {
        cliState = ViewState.DIFFICULTYSP;
        System.out.println("You have to choose the difficulty - Enter a number from 1 to 5 - This will change the number of the Tool Card");
    }

    @Override
    public void showPrivateSingle(List<PrivateObjectiveCard> publicList) {
        for (PrivateObjectiveCard privateCard : publicList) {
            System.out.println(privateCard.toString());
        }

    }

    @Override
    public void showToolSingleCommand(List<ToolCard> toolList, int poolSize) {
        setPoolSize(poolSize);
        setToolSingleNumber(toolList.size());
        cliState = ViewState.TOOLSP;
        System.out.println("Do you want to use a Tool Card ? - Enter yes or no");
    }

    @Override
    public void showToolSingleChoose() {
        cliState = ViewState.TOOLSPCHOOSE;
        System.out.println("Which tool card do you want to use? - Enter a number from 1 to " + getToolSingleNumber());
    }

    @Override
    public void showToolSingleDice() {
        cliState = ViewState.TOOLSPDICE;
        System.out.println("Select a die from the pool, which has the same color of the Tool Card - Enter a number from 1 to " + getPoolSize());
    }

    @Override
    public void showMatchError() {
        System.out.println("You are choosed a not right dice, it doesn't match the color of the tool card");
    }

    @Override
    public void showEndSinglePlayer(boolean winner, int playerPoints, int gameThreshold) {
        if (winner) {
            System.out.println("You win");
            System.out.println("You scored: " + playerPoints);
            System.out.println("The threshold of the round tracker is: " + gameThreshold);
        }
        else {
            System.out.println("You lose maaan!");
            System.out.println("You scored: " + playerPoints);
            System.out.println("The threshold of the round tracker is: " + gameThreshold);
        }
    }
}





