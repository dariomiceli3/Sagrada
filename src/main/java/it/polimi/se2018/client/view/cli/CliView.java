package it.polimi.se2018.client.view.cli;

import it.polimi.se2018.client.network.ClientInterface;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.server.model.Components.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;
import static java.lang.System.out;

/**
 * Class CliView: the class is a subclass of the abstract class View, show it's responsible of the override of all the methods
 * of the view, to respect the contract with the superclass and have the safety to work with the the rest of MVC pattern
 * and the network. The cli view runs in a thread, where an infinite loop is responsible of receive the input from the keyboard
 * of the user and in basis of that call the proper method and send it to class responsible to send the input across the network
 * @see java.lang.Runnable
 * @see it.polimi.se2018.client.view.View
 * @author fadda-miceli-mundo
 */
public class CliView extends View implements Runnable {

    private static GameState cliState;
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
    private static boolean connected = true;

    /**
     * class constructor
     */
    CliView() {
        System.setProperty("jansi.passthrough", "true");
    }

    /**
     * method that provides the caller the list of the cost of the tool
     * @return list of the cost of the tool
     */
    private static List<Integer> getToolCost() {
        return toolCost;
    }

    /**
     * method that allows to set if the client is connected or not
     * @param connected boolean connected
     */
    private static void setConnected(boolean connected) {
        CliView.connected = connected;
    }

    /**
     * method that allows to set the size of the pool
     * @param poolSize size of the pool
     */
    private static void setPoolSize(int poolSize) {
        CliView.poolSize = poolSize;
    }

    /**
     * method that allows to set the index of the pool
     * @param indexPool index of the pool
     */
    private static void setIndexPool(int indexPool) {
        CliView.indexPool = indexPool;
    }

    /**
     * method that allows to set the index of the pattern
     * @param indexPattern index of the pattern
     */
    private static void setIndexPattern(int indexPattern) {
        CliView.indexPattern = indexPattern;
    }

    /**
     * method that allows to set the index of the tool card
     * @param indexTool index of the tool card
     */
    private static void setIndexTool(int indexTool) {
        CliView.indexTool = indexTool;
    }

    /**
     * method that allows to set the first index where to take the dice
     * @param indexStartOne  first index of the box
     */
    private static void setIndexStartOne(int indexStartOne) {
        CliView.indexStartOne = indexStartOne;
    }

    /**
     * method that allows to set the second index where to take the dice
     * @param indexStartTwo  second index of the box
     */
    private static void setIndexStartTwo(int indexStartTwo) {
        CliView.indexStartTwo = indexStartTwo;
    }

    /**
     * method that allows to set the second index where to move the dice
     * @param indexEndOne index of the box
     */
    private static void setIndexEndOne(int indexEndOne) {
        CliView.indexEndOne = indexEndOne;
    }

    /**
     * method that allows to set the second index where to move the dice
     * @param indexEndTwo index of the box
     */
    private static void setIndexEndTwo(int indexEndTwo) {
        CliView.indexEndTwo = indexEndTwo;
    }

    /**
     * method that allow the caller to set the index of the round
     * @param indexRound index of the round
     */
    private static void setIndexRound(int indexRound) {
        CliView.indexRound = indexRound;
    }

    /**
     * method that allow the caller to set the color of the dice
     * @param colorDice dice color
     */
    private static void setColorDice(DiceColor colorDice) {
        CliView.colorDice = colorDice;
    }

    /**
     * method that allow the caller to set the dice number value
     * @param diceNumber number of dice to move
     */
    private static void setDiceNumber(int diceNumber) {
        CliView.diceNumber = diceNumber;
    }

    /**
     * method that allow the caller to set the number of tool card in the single plyer mode
     * @param toolSingleNumber number of card
     */
    private static void setToolSingleNumber(int toolSingleNumber) {
        CliView.toolSingleNumber = toolSingleNumber;
    }

    /**
     * method the allow the caller to set the cli state depending on the game state
     * @param state of the game
     */
    private static void setCliState(GameState state) {
        CliView.cliState = state;
    }

    /**
     * Override of the method run of Runnable class, the method is a thread with an infinite loop waiting for the input
     * from the user and depending on the input call the proper method to execute the action the clients requests to the
     * server
     */
    @Override
    public void run() {

        Scanner reader = new Scanner(System.in);
        boolean loop = true;
        String input;

        while (loop) {

            input = reader.nextLine();

            if (input.isEmpty()) {
                out.println("You are not writing nothing");
            } else if (input.equalsIgnoreCase("exit")) {
                if (cliState == GameState.ROLL) {
                    getConnection().setDraftPoolToServer(super.getPlayerID());
                    setConnected(false);
                    out.println("\n" + "from now you are suspended - enter RECONNECT to re-enter in the game");
                    getConnection().setExitToServer(super.getPlayerID());
                    setCliState(GameState.NOTCONNECTED);
                }
                if (cliState == GameState.NAME || cliState == GameState.PATTERN) {
                    out.println("\n" + "It's not time for exit the game");
                }
                else{
                    setConnected(false);
                    out.println("\n" + "from now you are suspended - enter RECONNECT to re-enter in the game");
                    getConnection().setExitToServer(super.getPlayerID());
                    setCliState(GameState.NOTCONNECTED);
                }
            } else if (cliState == GameState.NOTAUTHORIZED) {
                if (input.matches(".*[a-zA-Z0-9]+.*")){
                    out.println("Please, it's not your turn! Waiting for your moment");
                }
            } else if (cliState == GameState.NOTAUTHORIZEDNAME) {
                if (input.matches(".*[a-zA-Z0-9]+.*")) {
                    out.println("Please, you enter your name yet! Waiting for the game");
                }
            } else if (cliState == GameState.NOTCONNECTED) {
                if (input.equalsIgnoreCase("reconnect")) {
                    getConnection().setReconnectToServer(super.getPlayerID());
                    setConnected(true);
                    out.println("frow now you are in the game");
                } else {
                    out.println("You cannot enter commands now, you are not in the game");
                }
            } else if (cliState == GameState.MODE) {
                if (input.equalsIgnoreCase("multi")) {
                    out.println("Please wait, the game will start soon");
                    getConnection().setSinglePlayerMode(super.getPlayerID(), false);
                } else if (input.equalsIgnoreCase("single")) {
                    out.println("\n" + "Now the game will start");
                    getConnection().setSinglePlayerMode(super.getPlayerID(), true);
                } else {
                    out.println("You are not choosing a mode to play");
                    showSinglePlayerRequest();
                }
            } else if (cliState == GameState.NAME || cliState == GameState.ERRORNAME) {
                if (input.matches(".*[a-zA-Z0-9]+.*")) {
                    getConnection().setPlayerNameToServer(input, super.getPlayerID());
                } else {
                    out.println("blank name");
                }

            } else if (cliState == GameState.PATTERN) {
                try {
                    int choose = Integer.parseInt(input);

                    if (choose >= 1 && choose <= 4) {
                        choose--;
                        getConnection().setPatternCardToServer(choose, super.getPlayerID());
                    }
                    else if (choose == 0) {
                        showCustomCardPath();
                    }
                    else {
                        out.println("Please, decide which pattern to use");
                    }
                } catch (NumberFormatException e) {
                    out.println("Please enter a number between 1 and 4!");
                }

            } else if (cliState == GameState.CUSTOMPATTERN) {

                try {
                    InputStream inputStream = CliView.class.getResourceAsStream("/json/custom/" + input);
                    PatternCard customPattern = new PatternCard();
                    customPattern = customPattern.loadCard(inputStream);
                    getConnection().setPatternCustomToServer(super.getPlayerID(), customPattern);
                }
                catch (NullPointerException e) {
                    out.println("Enter a correct name");
                    showCustomCardPath();
                }


            } else if (cliState == GameState.ROLL) {

                if (input.equalsIgnoreCase("roll")) {
                    getConnection().setDraftPoolToServer(super.getPlayerID());
                } else {
                    out.println("Please, enter the command ROLL");
                    showRollCommand();
                }

            } else if (cliState == GameState.CHOOSE) {
                try {
                    int command = Integer.parseInt(input);
                    if (command == 0 || command == 1) {
                        getConnection().setChooseToServer(super.getPlayerID(), command);
                    } else {
                        out.println("Please enter the correct number");
                        showChooseCommand();
                    }

                } catch (NumberFormatException e) {
                    out.println("Please enter a number, 0 or 1!");
                    showChooseCommand();
                }
            } else if (cliState == GameState.MOVE) {

                if (input.equalsIgnoreCase("yes")) {
                    showIndexPoolCommand(poolSize);
                } else if (input.equalsIgnoreCase("no")) {
                    getConnection().setStartToolToServer(super.getPlayerID());
                } else {
                    out.println("You are not entering the expected command");
                    showMoveCommand(poolSize);
                }
            } else if (cliState == GameState.POOLINDEX) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= poolSize) {
                        idPool--;
                        setIndexPool(idPool);
                        showIndexPatternCommand();
                    } else {
                        out.println("Please enter a right index");
                        showIndexPoolCommand(poolSize);
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the command expected");
                    showIndexPoolCommand(poolSize);
                }
            } else if (cliState == GameState.PATTERNINDEX) {
                try {
                    int idPattern = Integer.parseInt(input);
                    if (idPattern >= 1 && idPattern <= 20) {
                        idPattern--;
                        setIndexPattern(idPattern);
                        getConnection().setMoveToServer(super.getPlayerID(), indexPool, indexPattern);
                    } else {
                        out.println("Please enter the correct number");
                        showIndexPatternCommand();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are entering the wrong command");
                    out.println("Enter the index of the Pattern Card - Enter a number between 1 and 20");

                }
            } else if (cliState == GameState.TOOL) {
                if (input.equalsIgnoreCase("yes")) {
                    showToolChooseCommand();

                } else if (input.equalsIgnoreCase("no")) {
                    getConnection().setNextTurnToServer(super.getPlayerID());

                } else {
                    out.println("You are not entering the right command");
                    out.println("Do you want to use a Tool Card ? - Enter yes or no");

                }
            } else if (cliState == GameState.TOOLINDEX) {
                try {
                    int idTool = Integer.parseInt(input);
                    if (idTool >= 1 && idTool <= 3) {
                        idTool--;
                        setIndexTool(idTool);
                        showToolCostCommand(getToolCost(), indexTool);
                    }

                } catch (NumberFormatException e) {
                    out.println("You are entering a wrong command");
                    showToolChooseCommand();
                }
            } else if (cliState == GameState.TOOLCOST) {

                if (input.equalsIgnoreCase("yes")) {
                    getConnection().useToolCardToServer(super.getPlayerID(), indexTool);
                } else if (input.equalsIgnoreCase("no")) {
                    getConnection().setNoTokenToServer(super.getPlayerID());
                } else {
                    out.println("You are entering the wrong command");
                    showToolCostCommand(getToolCost(), indexTool);
                }

            }

            //--------------------tool card--------------------------------------------------------------------------

            else if (cliState == GameState.GROZINGPOOL) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= poolSize) {
                        idPool--;
                        setIndexPool(idPool);
                        showGrozingCommand();
                    } else {
                        out.println("Please enter a right index");
                        showGrozingRequest(poolSize);
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the right command");
                    showGrozingRequest(poolSize);
                }

            } else if (cliState == GameState.GROZINGCOMMAND) {
                try {
                    int increase = Integer.parseInt(input);
                    if (increase == 0 || increase == 1) {
                        getConnection().useGrozingToolCard(super.getPlayerID(), indexPool, increase);
                    } else {
                        out.println("You are not choosing what to do");
                        showGrozingCommand();
                    }

                } catch (NumberFormatException e) {
                    out.println("You are not entering the correct number");
                    showGrozingCommand();
                }
            } else if (cliState == GameState.EGLOMISESTART) {
                try {
                    int idOne = Integer.parseInt(input);
                    if (idOne >= 1 && idOne <= 20) {
                        idOne--;
                        setIndexStartOne(idOne);
                        showEglomiseEnd();
                    } else {
                        out.println("Please enter the right index");
                        showEglomiseStart();
                    }

                } catch (NumberFormatException e) {
                    out.println("You are not entering the index of a pattern card");
                    showEglomiseStart();
                }

            } else if (cliState == GameState.EGLOMISEEND) {
                try {
                    int idTwo = Integer.parseInt(input);
                    if (idTwo >= 1 && idTwo <= 20) {
                        idTwo--;
                        setIndexEndOne(idTwo);
                        getConnection().useEglomiseToolCard(super.getPlayerID(), indexStartOne, indexEndOne);
                    } else {
                        out.println("Please, enter the right index");
                        showEglomiseEnd();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the index of a Pattern Card");
                    showEglomiseEnd();
                }
            } else if (cliState == GameState.COPPERSTART) {
                try {
                    int idOne = Integer.parseInt(input);
                    if (idOne >= 1 && idOne <= 20) {
                        idOne--;
                        setIndexStartOne(idOne);
                        showCopperFoilEnd();
                    } else {
                        out.println("Please enter the right index");
                        showCopperFoilStart();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the index of a pattern card");
                    showCopperFoilStart();
                }
            } else if (cliState == GameState.COPPEREND) {
                try {
                    int idTwo = Integer.parseInt(input);
                    if (idTwo >= 1 && idTwo <= 20) {
                        idTwo--;
                        setIndexEndOne(idTwo);
                        getConnection().useCopperFoilToolCard(super.getPlayerID(), indexStartOne, indexEndOne);
                    } else {
                        out.println("Please, enter the right index");
                        showCopperFoilEnd();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the index of a Pattern Card");
                    showCopperFoilEnd();
                }
            } else if (cliState == GameState.LATHEKINSTARTONE) {
                try {
                    int idOne = Integer.parseInt(input);
                    if (idOne >= 1 && idOne <= 20) {
                        idOne--;
                        setIndexStartOne(idOne);
                        showLathekinEnd();
                    } else {
                        out.println("Please enter a right index");
                        showLathekinStart();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the index of a Pattern Card");
                    showLathekinStart();
                }

            } else if (cliState == GameState.LATHEKINENDONE) {
                try {
                    int idEnd = Integer.parseInt(input);
                    if (idEnd >= 1 && idEnd <= 20) {
                        idEnd--;
                        setIndexEndOne(idEnd);
                        showLathekinStartTwo();
                    } else {
                        out.println("Please enter the right index");
                        showLathekinEnd();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the index of a Pattern Card");
                    showLathekinEnd();
                }

            } else if (cliState == GameState.LATHEKINSTARTTWO) {
                try {
                    int idTwo = Integer.parseInt(input);
                    if (idTwo >= 1 && idTwo <= 20) {
                        idTwo--;
                        setIndexStartTwo(idTwo);
                        showLathekinEndTwo();
                    } else {
                        out.println("Please enter a right index");
                        showLathekinStartTwo();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the index of a Pattern Card");
                    showLathekinStartTwo();
                }

            } else if (cliState == GameState.LATHEKINENDTWO) {

                try {
                    int idEndTwo = Integer.parseInt(input);
                    if (idEndTwo >= 1 && idEndTwo <= 20) {
                        idEndTwo--;
                        setIndexEndTwo(idEndTwo);
                        getConnection().useLathekinToolCard(super.getPlayerID(), indexStartOne, indexEndOne, indexStartTwo, indexEndTwo);
                    } else {
                        out.println("Please enter a right index");
                        showLathekinEndTwo();
                    }

                } catch (NumberFormatException e) {
                    out.println("You are not entering an index of the Pattern Card");
                    showLathekinEndTwo();
                }

            } else if (cliState == GameState.LENSCUTTERPOOL) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= poolSize) {
                        idPool--;
                        setIndexPool(idPool);
                        showLensCutterRound(roundList);
                    } else {
                        out.println("Please enter an index in the correct range");
                        showLensCutterRequest(poolSize, roundList);
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering an index of the pool");
                    showLensCutterRequest(poolSize, roundList);
                }
            } else if (cliState == GameState.LENSCUTTERROUND) {
                try {
                    int idRound = Integer.parseInt(input);
                    if (idRound >= 1 && idRound <= roundList.size()) {
                        idRound--;
                        setIndexRound(idRound);
                        showLensCutterDice(roundList, indexRound);
                    } else {
                        out.println("Please enter an index in the range");
                        showLensCutterRound(roundList);
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the index of a round");
                    showLensCutterRound(roundList);
                }
            } else if (cliState == GameState.LENSCUTTERDICE) {
                try {
                    int idPos = Integer.parseInt(input);
                    if (idPos >= 1 && idPos <= roundList.get(indexRound)) {
                        idPos--;
                        getConnection().useLensCutterToolCard(super.getPlayerID(), indexPool, indexRound, idPos);
                    } else {
                        out.println("Please enter a number in the range");
                        showLensCutterDice(roundList, indexRound);
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the index of a dice");
                    showLensCutterDice(roundList, indexRound);
                }
            } else if (cliState == GameState.FLUXBRUSH) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= poolSize) {
                        idPool--;
                        setIndexPool(idPool);
                        getConnection().useFluxBrushToolCard(super.getPlayerID(), indexPool);
                    } else {
                        out.println("Please enter a number in the range");
                        showFluxBrushRequest(poolSize);
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering an index in the range of the pool");
                    showFluxBrushRequest(poolSize);
                }
            } else if (cliState == GameState.GLAZINGHAMMER) {
                if (input.equalsIgnoreCase("start")) {
                    getConnection().useGlazingHammerToolCard(super.getPlayerID());
                } else {
                    out.println("Command not recognized for this card");
                }
            } else if (cliState == GameState.RUNNINGPOOL) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= poolSize) {
                        idPool--;
                        setIndexPool(idPool);
                        showRunningPliersEnd();
                    } else {
                        out.println("Please enter a number in the range");
                        showRunningPliersPool(poolSize);
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering an index in the correct range");
                    showRunningPliersPool(poolSize);
                }

            } else if (cliState == GameState.RUNNINGEND) {
                try {
                    int idPattern = Integer.parseInt(input);
                    if (idPattern >= 1 && idPattern <= 20) {
                        idPattern--;
                        setIndexEndOne(idPattern);
                        getConnection().useRunningPliersToolCard(super.getPlayerID(), indexPool, indexEndOne);
                    } else {
                        out.println("Please enter a number between 1 and 20");
                        showRunningPliersEnd();
                    }
                } catch (NumberFormatException e) {
                    out.println("You aren't entering an index correct");
                    showRunningPliersEnd();
                }

            } else if (cliState == GameState.CORKPOOL) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= poolSize) {
                        idPool--;
                        setIndexPool(idPool);
                        showCorkBackedEnd();
                    } else {
                        out.println("Please, enter a number in the correct range");
                        showCorkBackedPool(poolSize);
                    }
                } catch (NumberFormatException e) {
                    out.println("You aren't entering a correct index");
                    showCorkBackedPool(poolSize);
                }
            } else if (cliState == GameState.CORKEND) {
                try {
                    int idPattern = Integer.parseInt(input);
                    if (idPattern >= 1 && idPattern <= 20) {
                        idPattern--;
                        setIndexEndOne(idPattern);
                        getConnection().useCorkBackedToolCard(super.getPlayerID(), indexPool, indexEndOne);
                    } else {
                        out.println("Please, enter a number in the range");
                        showCorkBackedEnd();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering an index of the card");
                    showCorkBackedEnd();
                }
            } else if (cliState == GameState.GRINDING) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= poolSize) {
                        idPool--;
                        setIndexPool(idPool);
                        getConnection().useGrindingStoneToolCard(super.getPlayerID(), indexPool);
                    } else {
                        out.println("Please, enter a number in the range correct");
                        showGrindingStoneRequest(poolSize);
                    }

                } catch (NumberFormatException e) {
                    out.println("You are not entering an index for choosing the dice");
                    showGrindingStoneRequest(poolSize);
                }
            } else if (cliState == GameState.FLUXPOOL) {
                try {
                    int idPool = Integer.parseInt(input);
                    if (idPool >= 1 && idPool <= poolSize) {
                        idPool--;
                        setIndexPool(idPool);
                        showFluxRemoverValue();
                    } else {
                        out.println("Please, enter a number in the correct range to continue the game");
                        showFluxRemoverPool(colorDice, poolSize);
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering an index of the draft pool");
                    showFluxRemoverPool(colorDice, poolSize);
                }
            } else if (cliState == GameState.FLUXVALUE) {
                try {
                    int value = Integer.parseInt(input);
                    if (value >= 1 && value <= 6) {
                        getConnection().useFluxRemoverToolCard(super.getPlayerID(), indexPool, value);
                    } else {
                        out.println("Please, a dice should have as value" + value);
                        showFluxRemoverValue();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering a numeric value for the dice");
                    showFluxRemoverValue();
                }

            } else if (cliState == GameState.TAPNUMBER) {
                try {
                    int num = Integer.parseInt(input);
                    if (num == 1 || num == 2) {
                        setDiceNumber(num);
                        showTapWheelStartOne();
                    } else {
                        out.println("Please, enter a correct value!");
                        showTapWheelNumber();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the value expected");
                    showTapWheelNumber();
                }
            } else if (cliState == GameState.TAPSTARTONE) {
                try {
                    int idStartOne = Integer.parseInt(input);
                    if (idStartOne >= 1 && idStartOne <= 20) {
                        idStartOne--;
                        setIndexStartOne(idStartOne);
                        showTapWheelEndOne();
                    } else {
                        out.println("Please,enter a correct index for the pattern");
                        showTapWheelStartOne();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the expected value");
                    showTapWheelStartOne();
                }
            } else if (cliState == GameState.TAPENDONE) {
                try {
                    int idEndOne = Integer.parseInt(input);
                    if (idEndOne >= 1 && idEndOne <= 20) {
                        idEndOne--;
                        setIndexEndOne(idEndOne);

                        if (diceNumber == 1) {
                            getConnection().useTapWheelToolCard(super.getPlayerID(), diceNumber, indexStartOne, indexEndOne, 0, 0);
                        } else {
                            showTapWheelStartTwo();
                        }
                    } else {
                        out.println("Please, enter a correct index for the range");
                        showTapWheelEndOne();
                    }

                } catch (NumberFormatException e) {
                    out.println("You are not entering the correct index");
                    showTapWheelEndOne();
                }
            } else if (cliState == GameState.TAPSTARTTWO) {
                try {
                    int idStartTwo = Integer.parseInt(input);
                    if (idStartTwo >= 1 && idStartTwo <= 20) {
                        idStartTwo--;
                        setIndexStartTwo(idStartTwo);
                        showTapWheelEndTwo();
                    } else {
                        out.println("Please, enter the index for the range");
                        showTapWheelStartTwo();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the correct index");
                    showTapWheelStartTwo();
                }
            } else if (cliState == GameState.TAPENDTWO) {
                try {
                    int idEndTwo = Integer.parseInt(input);
                    if (idEndTwo >= 1 && idEndTwo <= 20) {
                        idEndTwo--;
                        setIndexEndTwo(idEndTwo);
                        getConnection().useTapWheelToolCard(super.getPlayerID(), diceNumber, indexStartOne, indexEndOne, indexStartTwo, indexEndTwo);
                    } else {
                        out.println("Please, enter the index correct for the range");
                        showTapWheelEndTwo();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering the correct index");
                    showTapWheelEndTwo();
                }
            }

            //------------------------single player--------------------------------------------------------

            else if (cliState == GameState.DIFFICULTYSP) {
                try {
                    int difficulty = Integer.parseInt(input);
                    if (difficulty >= 1 && difficulty <= 5) {
                        getConnection().setDifficultyToServer(super.getPlayerID(), difficulty);
                    } else {
                        out.println("Please, enter the difficulty");
                        showDifficultyRequest();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not choosing the difficulty");
                    showDifficultyRequest();
                }
            } else if (cliState == GameState.TOOLSP) {
                if (input.equalsIgnoreCase("yes")) {
                    showToolSingleChoose();
                } else if (input.equalsIgnoreCase("no")) {
                    getConnection().setNextTurnToServer(super.getPlayerID());
                } else {
                    out.println("You are not entering the right command");
                    out.println("Do you want to use a Tool Card ? - Enter yes or no");
                }
            } else if (cliState == GameState.TOOLSPCHOOSE) {
                try {
                    int index = Integer.parseInt(input);
                    if (index >= 1 && index <= toolSingleNumber) {
                        index--;
                        setIndexTool(index);
                        showToolSingleDice();
                    } else {
                        out.println("Please, enter the right command");
                        showToolSingleChoose();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not entering an index");
                    showToolSingleChoose();
                }
            } else if (cliState == GameState.TOOLSPDICE) {
                try {
                    int idDice = Integer.parseInt(input);
                    if (idDice >= 1 && idDice <= poolSize) {
                        idDice--;
                        setIndexPool(idDice);
                        getConnection().useToolSingleToServer(super.getPlayerID(), indexTool, indexPool);
                    } else {
                        out.println("Please, enter the right command");
                        showToolSingleDice();
                    }
                } catch (NumberFormatException e) {
                    out.println("You are not choosing the dice");
                    showToolSingleDice();
                }
            }

        }
    }




    //---------------------------enum for cli state--------------------------------------------------------

    /**
     * enum for the cli state
     */
    public enum GameState {

        MODE, NAME, ERRORNAME,
        PATTERN, CUSTOMPATTERN,
        ROLL, CHOOSE, MOVE,
        POOLINDEX, PATTERNINDEX,
        TOOL, TOOLINDEX, TOOLCOST,
        GROZINGPOOL, GROZINGCOMMAND,
        EGLOMISESTART, EGLOMISEEND,
        COPPERSTART, COPPEREND,
        LATHEKINSTARTONE, LATHEKINSTARTTWO, LATHEKINENDONE, LATHEKINENDTWO,
        LENSCUTTERPOOL, LENSCUTTERROUND, LENSCUTTERDICE,
        FLUXBRUSH, GLAZINGHAMMER,
        RUNNINGPOOL, RUNNINGEND,
        CORKPOOL, CORKEND,
        GRINDING, FLUXPOOL, FLUXVALUE,
        TAPNUMBER, TAPSTARTONE,
        TAPENDONE, TAPSTARTTWO,
        TAPENDTWO, DIFFICULTYSP,
        TOOLSP, TOOLSPCHOOSE,
        TOOLSPDICE, NOTAUTHORIZED,
        NOTAUTHORIZEDNAME, NOTCONNECTED,
    }


    //---------------------------ovveride metodi mostrano su view---------------------------------

    /**
     * method that provides the caller the connection
     * @return clientConnection
     */
    @Override
    public ClientInterface getConnection() {
        return connection;
    }

    /**
     * method that allows to set the connection of the client
     * @param connection client to set
     */
    @Override
    public void setConnection(ClientInterface connection) {
        this.connection = connection;
    }

    /**
     * method that allows to show the id of the player
     */
    @Override
    public void showID() {
        out.println("Player id set " + super.getPlayerID());
    }

    /**
     * method that allows to show request for the single player mode
     */
    @Override
    public void showSinglePlayerRequest() {
        setCliState(GameState.MODE);
        out.println("How do you want to play: Single or Multi?");
    }

    /**
     * method that allows to show that the game is started
     */
    @Override
    public void showGameStarted() {
        out.println("Match is started: " + super.isStarted());
    }

    /**
     * method that allows to show the choise of the name
     */
    @Override
    public void showNameChoose() {
        setCliState(GameState.NAME);
        out.println("\n" + "Enter your name ");
    }

    /**
     * method that allows to show the name
     */
    @Override
    public void showName() {
        setCliState(GameState.NOTAUTHORIZEDNAME);
        out.println("Name set as: " + super.getPlayerName());
    }

    /**
     * method that allows to show the current name to the other players
     * @param name name of the current player
     */
    @Override
    public void showNameOther(String name) {
        out.println("\n" + "Another player connected with name: " + name);
    }

    /**
     * method that allows to show that the current name is not permitted
     */
    @Override
    public void showNameError() {
        setCliState(GameState.ERRORNAME);
        out.println("This name is used by another player!");
    }

    /**
     *  method that allows to show the private card
     * @param privateObjectiveCard private card to show
     */
    @Override
    public void showPrivateCard(PrivateObjectiveCard privateObjectiveCard) {
        out.println("\n" + privateObjectiveCard.toString());
    }

    /**
     *  method that allows to show the list of the public cards
     * @param publicList list of public cards
     */
    @Override
    public void showPublicCard(List<PublicObjectiveCard> publicList) {
        for (PublicObjectiveCard publicCard : publicList) {
            out.println("\n" + publicCard.toString());
        }
    }

    /**
     * method that allows to show the list of the pattern cards
     * @param patternCards list of pattern cards
     */
    @Override
    public void showPatternList(List<PatternCard> patternCards) {
        for (PatternCard patternCard : patternCards) {
            out.println("\n" + patternCard.toString());
        }

        setCliState(GameState.PATTERN);
        out.println("\n" + "Choose your Pattern Card - Enter a number between 1 and 4 - or 0 to enter your custom card");
    }

    /**
     * method that show the user the path of the custom file he inteded to use
     */
    public void showCustomCardPath() {
        out.println("Enter the path of the file .json");
        String filePath = "src/main/resources/json/custom/";
        out.print(filePath);
        setCliState(GameState.CUSTOMPATTERN);
    }

    /**
     *  method that allows to show the pattern the player chose
     * @param patternCard pattern chosen by the player
     */
    @Override
    public void showPattern(PatternCard patternCard) {
        out.println("\n" + "This is the PatternCard you will use ");
        out.println(patternCard.toString());
    }

    /**
     *  method that allows to show the pattern during the game
     * @param patternCard pattern card of a player
     * @param name name of the player
     * @param id id of the player
     */
    @Override
    public void showOtherPattern(PatternCard patternCard, String name,  int id) {
        out.println("\n" + "Now Pattern of" + name + "is: ");
        out.println(patternCard.toString());

    }

    /**
     * method that allows to show the pattern of the current player to other players
     * @param patternCard pattern card chosen by the player
     * @param id id of the player
     */
    @Override
    public void showOtherStartPattern(PatternCard patternCard, int id) {
        out.println("The pattern of your enemy is: " + "\n");
        out.println(patternCard.toString());
        out.println("Choose your Pattern Card - Enter a number between 1 and 4");
    }

    /**
     * method that allows to show update of a selected pattern card
     * @param patternCard pattern card of a player
     */
    @Override
    public void showPatternUpdate(PatternCard patternCard) {
        out.println("Now you're Pattern Card is" + "\n");
        out.println(patternCard.toString());

    }

    /**
     * method that allows to show the tokens of a player
     * @param tokensNumber number of tokens
     */
    @Override
    public void showTokens(int tokensNumber) {
        out.println("\n" + "This your number of favor tokens available: " + tokensNumber);
    }

    /**
     * method that allows to show the start of a scene
     */
    @Override
    public void showStartScene() {
        out.println("Time to take the gloves off and build your own window!" + "\n");
    }

    /**
     * method that allows to show the current round during the game
     * @param round int round of the game
     */
    @Override
    public void showCurrentRound(int round) {
        out.println("Round " + round + " is started");
    }

    /**
     * method that allows to show the current turn during the game
     */
    @Override
    public void showCurrentTurn() {
        out.println("\n" + "It's your turn");
    }

    /**
     * method that allows to show to the other players, the current turn of the selected player
     * @param username name of the selected player
     */
    @Override
    public void showOtherCurrentTurn(String username) {
        if (!connected) {
            setCliState(GameState.NOTCONNECTED);
        } else {
            setCliState(GameState.NOTAUTHORIZED);
        }
        out.println("\n" + "It's " + username + "'s turn");
    }


    /**
     * method that allows to show to the current player  the command to rool the draft pool
     */
    @Override
    public void showRollCommand() {
        setCliState(GameState.ROLL);
        out.println("Write the command ROLL to casually roll the draft pool");
    }

    /**
     * method that allows to show the draft pool
     * @param draftPool draft pool of the game
     */
    @Override
    public void showDraftPool(DraftPool draftPool) {
        out.println("\n" + draftPool.toString());
    }

    /**
     * method that allows to show to the current player the command to choose
     */
    @Override
    public void showChooseCommand() {
        setCliState(GameState.CHOOSE);
        out.println("\n" + "What do you want to do: ? - Enter 0 to put dice, 1 to use a tool card");

    }

    /**
     * method that allows to show to the current player the command to move a dice
     * @param poolSize size of the pool
     */
    @Override
    public void showMoveCommand(int poolSize)  {
        setPoolSize(poolSize);
        setCliState(GameState.MOVE);
        out.println("\n" + "Do you want to move a dice from the pool to the card? - Enter yes or no?");
    }

    /**
     * method that allows to show the index of the pool of the dice the player wants to move
     * @param poolSize size of the pool
     */
    @Override
    public void showIndexPoolCommand(int poolSize) {
        setPoolSize(poolSize);
        setCliState(GameState.POOLINDEX);
        out.println("\n" + "Enter the index of the dice from the pool - from 1 to " + CliView.poolSize);
    }

    /**
     * method that allows to show the index of the patten where the player wants to move the dice
     */
    @Override
    public void showIndexPatternCommand() {
        setCliState(GameState.PATTERNINDEX);
        out.println("\n" + "Enter the index of the Pattern Card - Enter a number between 1 and 20");
    }

    /**
     * method that allows to show the command of the tool card
     * @param toolCards list of tool cards
     */
    @Override
    public void showToolCommand(List<ToolCard> toolCards) {
        toolCost = new ArrayList<>();
        for(ToolCard tool : toolCards) {
            toolCost.add(tool.getCost());
        }
        setCliState(GameState.TOOL);
        out.println("\n" + "Do you want to use a Tool Card ? - Enter yes or no");
    }

    /**
     * method that allows to show the selected tool card by the player
     */
    @Override
    public void showToolChooseCommand() {
        setCliState(GameState.TOOLINDEX);
        out.println("\n" + "Which tool card do you want to use? - Enter a number from 1 to 3");
    }

    /**
     * method that allows to show the cost of the selected tool card
     * @param toolCost list of tool card's costs
     * @param indexTool index of the selected tool
     */
    @Override
    public void showToolCostCommand(List<Integer> toolCost, int indexTool) {
        setCliState(GameState.TOOLCOST);
        int cost = toolCost.get(indexTool);
        out.println("\n" + "Do you want to use " + cost + " tokens to use this card? - Enter yes or no");
    }

    /**
     * method that allows to show the round tracker
     * @param roundTracker round tracker of the game
     */
    @Override
    public void showRoundTracker(RoundTracker roundTracker) {
        out.println("End of the round");
        out.println(roundTracker.toString());

    }

    /**
     * method that allows to show the final rank at the end of the game
     * @param playerList list of the players
     * @param ended boolean that indicates if the game is ended
     */
    @Override
    public void showFinalRank(List<Player> playerList, boolean ended) {
        out.println("Final Rank:" + "\n" );
        for (Player player : playerList) {
            out.println(player.toStringPoints());
        }
        getConnection().setEndGameTimer(super.getPlayerID());
    }

    /**
     * method that allows to show the player who won
     */
    @Override
    public void showWinner() {
        out.println("You win !!!!!!!!!");
        setCliState(GameState.NOTAUTHORIZED);
    }

    /**
     * method that allows to show the players who lost
     */
    @Override
    public void showLosers() {
        out.println("You lose maaaan!");
        setCliState(GameState.NOTAUTHORIZED);
    }

    /**
     * method that allows to show the timer is ended to the current player
     */
    @Override
    public void showTimer() {
        out.println("\n" + "You'r time is over");
    }

    /**
     * method that allows to show the current player's timer is ended to the other players
     * @param playerName name of the current player
     */
    @Override
    public void showOtherTimer(String playerName) {
        out.println("\n" + playerName + " turn time is ended");
    }

    /**
     * method that allows to show the list of tool cards
     * @param toolCardList list of tool cards
     */
    @Override
    public  void showToolCards(List<ToolCard> toolCardList) {
        for (ToolCard toolCard : toolCardList) {
            out.println("\n" + toolCard.toString());
        }
    }

    /**
     * method that allows to show that tokens isn't enough to use a tool card
     */
    @Override
    public void showTokenError() {
        out.println("You have not enough favor tokens to use this tool card");
    }



    //------------------------tool card----------------------------------------------------------------------------


    // tool grozing pliers
    /**
     * method that allows to show the request for the Grozing tool card
     * @param poolSize size of the pool
     */
    @Override
    public void showGrozingRequest(int poolSize) {
        setPoolSize(poolSize);
        setCliState(GameState.GROZINGPOOL);
        out.println("\n" + "Select a die from the pool - Enter a number between 1 and " + CliView.poolSize);

    }

    /**
     * method that allows to show the command to use Grozing tool card
     */
    @Override
    public void showGrozingCommand() {
        setCliState(GameState.GROZINGCOMMAND);
        out.println("Do you want to increase (1) or decrease (0)");
    }

    // tool eglomise brush

    /**
     * method that allows to show the start index for the Eglomise tool card
     */
    @Override
    public void showEglomiseStart() {
        setCliState(GameState.EGLOMISESTART);
        out.println("\n" + "Select a die from the pattern card to move - Enter a number between 1 and 20");
    }

    /**
     * method that allows to show the end index for the Eglomise tool card
     */
    @Override
    public void showEglomiseEnd() {
        setCliState(GameState.EGLOMISEEND);
        out.println("Enter the index where you want to move it - Enter a number between 1 and 20");

    }

    /**
     * method that allows to show the start index for the CopperFoil tool card
     */
    @Override
    public void showCopperFoilStart() {
        setCliState(GameState.COPPERSTART);
        out.println("\n" + "Select ad die from the pattern card to move - Enter a number from 1 to 20");

    }

    /**
     * method that allows to show the end index for the Copper Foil tool card
     */
    @Override
    public void showCopperFoilEnd() {
        setCliState(GameState.COPPEREND);
        out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
    }


    /**
     * method that allows to show the first index where to pick up the dice in Lathekin tool card
     */
    @Override
    public void showLathekinStart() {
        setCliState(GameState.LATHEKINSTARTONE);
        out.println("\n" + "Select the first die to move - Enter a number from 1 to 20");
    }

    /**
     * method that allows to show the second index where to pick up the dice in Lathekin tool card
     */
    @Override
    public void showLathekinEnd() {
        setCliState(GameState.LATHEKINENDONE);
        out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
    }

    /**
     * method that allows to show the first index where to move the dice in Lathekin tool card
     */
    @Override
    public void showLathekinStartTwo() {
        setCliState(GameState.LATHEKINSTARTTWO);
        out.println("Select the second die to move - Enter a number from 1 to 20");
    }

    /**
     * method that allows to show the second index where to move the dice in Lathekin tool card
     */
    @Override
    public void showLathekinEndTwo() {
        setCliState(GameState.LATHEKINENDTWO);
        out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
    }


    /**
     * method that allows to show the Lens Cutter tool card request
     * @param poolSize size of the pool
     * @param round round of the game
     */
    @Override
    public void showLensCutterRequest(int poolSize, List<Integer> round) {
        roundList = new ArrayList<>();
        roundList.addAll(round);
        setPoolSize(poolSize);
        setCliState(GameState.LENSCUTTERPOOL);
        out.println("\n" + "Selected the die from the draft pool you want to change - Enter a number from 1 to " + CliView.poolSize);
    }

    /**
     * method that allows to show the round of the round tracker for the Lens Cutter tool card
     * @param round round of the round tracker
     */
    @Override
    public void showLensCutterRound(List<Integer> round) {
        setCliState(GameState.LENSCUTTERROUND);
        out.println("Select the number of the round where you want to change - Enter a number from 1 to " + round.size());
    }

    /**
     * method that allows to show the dice in the round tracker for the Lens Cutter tool card
     * @param round round of the round tracker
     * @param roundIndex index of the round
     */
    @Override
    public void showLensCutterDice(List<Integer> round, int roundIndex) {
        setCliState(GameState.LENSCUTTERDICE);
        out.println("Selected the die of the round selected - Enter a number from 1 to " + round.get(roundIndex).toString());
    }

    /**
     * method that allows to show request for the Flux Brush tool card
     * @param poolSize size of the pool
     */
    @Override
    public void showFluxBrushRequest(int poolSize) {
        setPoolSize(poolSize);
        setCliState(GameState.FLUXBRUSH);
        out.println("\n" + "Selected the die to re-roll from the pool: - Enter a number between 1 and " + CliView.poolSize);
    }

    /**
     * method that allows to show request for the Glazing Hammer tool card
     */
    @Override
    public void showGlazingHammerRequest() {
        setCliState(GameState.GLAZINGHAMMER);
        out.println("\n" + "Enter START to roll the dice of the draft pool" );
    }

    /**
     * method that allows to show the index of the pool
     * @param poolSize size of the pool
     */
    @Override
    public void showRunningPliersPool(int poolSize) {
        setPoolSize(poolSize);
        setCliState(GameState.RUNNINGPOOL);
        out.println("\n" + "Selected a dice from the pool, but you'll skip your next turn - Enter a number from 1 to " + CliView.poolSize);

    }


    /**
     * method that allows to show the index where to move the dice in the pattern card
     */
    @Override
    public void showRunningPliersEnd() {
        setCliState(GameState.RUNNINGEND);
        out.println("Enter the index where you want to put the dice - Enter a number between 1 and 20");
    }


    /**
     * method that allows to show the index of the pool
     * @param poolSize size of the pool
     */
    @Override
    public void showCorkBackedPool(int poolSize) {
        setPoolSize(poolSize);
        setCliState(GameState.CORKPOOL);
        out.println("\n" + "Select a die from the pool - Enter a number from 1 to " + CliView.poolSize);
    }

    /**
     * method that allows to show the index where to move the dice in the pattern card
     */
    @Override
    public void showCorkBackedEnd() {
        setCliState(GameState.CORKEND);
        out.println("Enter where you want to put the dice in the pattern card - Enter a number from 1 to 20");
    }

    /**
     * method that allows to show the request for Cork Backed tool card
     * @param poolSize size of the pool
     */
    @Override
    public void showGrindingStoneRequest(int poolSize) {
        setPoolSize(poolSize);
        setCliState(GameState.GRINDING);
        out.println("\n" + "Select a die from the pool that should be flipped - Enter a number from 1 to " + CliView.poolSize);
    }
    /**
     * method that allows to show the color of the selected dice e the index of the pool
     * @param color color of the selected dice
     * @param poolSize index of the pool
     */
    @Override
    public void showFluxRemoverPool(DiceColor color, int poolSize) {
        setPoolSize(poolSize);
        setColorDice(color);
        setCliState(GameState.FLUXPOOL);
        out.println("\n" + "Select the die you want to return from the pool - Enter a number from 1 to " + CliView.poolSize);
    }

    /**
     * method that allows to show the new value of the selected dice
     */
    @Override
    public void showFluxRemoverValue() {
        setCliState(GameState.FLUXVALUE);
        out.println("The color of the die drafted from the bag is " + colorDice.toString());
        out.println("Which value do you want for the dice? - Enter a number from 1 to 6");
    }


    /**
     * method that allows to show the number of dice the player wants to move
     */
    @Override
    public void showTapWheelNumber() {
        setCliState(GameState.TAPNUMBER);
        out.println("\n" + "Enter the number of dice that you want to move - Enter 1 or 2");
    }

    /**
     * method that allows to show the first index where to pick up the dice in Tap Wheel tool card
     */
    @Override
    public void showTapWheelStartOne() {
        setCliState(GameState.TAPSTARTONE);
        out.println("Enter the index of the 1st dice you want to move - Enter a number from 1 to 20");
    }

    /**
     * method that allows to show the first index where to move the dice in Tap Wheel tool card
     */
    @Override
    public void showTapWheelEndOne() {
        setCliState(GameState.TAPENDONE);
        out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
    }


    /**
     * method that allows to show the second index where to pick up the dice in Tap Wheel tool card
     */
    @Override
    public void showTapWheelStartTwo() {
        setCliState(GameState.TAPSTARTTWO);
        out.println("Enter the index of the 2nd dice you want to move - Enter a number from 1 to 20");
    }

    /**
     * method that allows to show the second index where to move the dice in Tap Wheel tool card
     */
    @Override
    public void showTapWheelEndTwo() {
        setCliState(GameState.TAPENDTWO);
        out.println("Enter the index where you want to move it - Enter a number from 1 to 20");
    }

    /**
     * method that allows to show the board of the game
     * @param roundTracker round tracker of the game
     * @param draftPool draft pool of the game
     */
    @Override
    public void showBoard(RoundTracker roundTracker, DraftPool draftPool) {
        out.println("\n" + "Now Round Tracker is:");
        out.println(roundTracker.toString());
        out.println("\n" + "Now Draft Pool is: ");
        out.println(draftPool.toString());
    }

    /**
     * method that allows to show an invalid move
     * @param msg message to show
     */
    @Override
    public void showInvalidMove(String msg) {
        out.println("\n" + "ERROR: " + msg);
    }



    //---------------------------------------single player-------------------------------------------------------------


    /**
     * method that allows to show the difficulty chosen by the player
     */
    @Override
    public void showDifficultyRequest() {
        setCliState(GameState.DIFFICULTYSP);
        out.println("\n" + "You have to choose the difficulty - Enter a number from 1 to 5 - This will change the number of the Tool Card");
    }

    /**
     * method that allows to show the list of the private cards
     * @param publicList list of private cards
     */
    @Override
    public void showPrivateSingle(List<PrivateObjectiveCard> publicList) {
        for (PrivateObjectiveCard privateCard : publicList) {
            out.println("\n" + privateCard.toString());
        }
    }

    /**
     * method that allows to show the possiblity to choose a tool card
     * @param toolList list of the tool cards
     * @param poolSize size of the pool
     */
    @Override
    public void showToolSingleCommand(List<ToolCard> toolList, int poolSize) {
        setPoolSize(poolSize);
        setToolSingleNumber(toolList.size());
        setCliState(GameState.TOOLSP);
        out.println("\n" + "Do you want to use a Tool Card ? - Enter yes or no");
    }

    /**
     * method that allows to show the selected tool card by the player
     */
    @Override
    public void showToolSingleChoose() {
        setCliState(GameState.TOOLSPCHOOSE);
        out.println("Which tool card do you want to use? - Enter a number from 1 to " + toolSingleNumber);
    }

    /**
     * method that allows to show the selected dice to use the tool card
     */
    @Override
    public void showToolSingleDice() {
        setCliState(GameState.TOOLSPDICE);
        out.println("\n" + "Select a die from the pool, which has the same color of the Tool Card - Enter a number from 1 to " + poolSize);
    }

    /**
     * method that allows to show that the selected dice isn't right to use the tool card
     */
    @Override
    public void showMatchError() {
        out.println("\n" + "You are choosed a not right dice, it doesn't match the color of the tool card");
    }

    /**
     * method that allows to show if the player won the game
     * @param winner boolean that indicates if the player won
     * @param playerPoints total points of the player
     * @param gameThreshold threshold to overcome to win
     */
    @Override
    public void showEndSinglePlayer(boolean winner, int playerPoints, int gameThreshold) {
        if (winner) {
            out.println("\n" + "You win");
            out.println("You scored: " + playerPoints);
            out.println("The threshold of the round tracker is: " + gameThreshold);
        }
        else {
            out.println("\n" + "You lose maaan!");
            out.println("You scored: " + playerPoints);
            out.println("The threshold of the round tracker is: " + gameThreshold);
        }
    }

    //----------------------------disconnection-----------------------------------------------------------------------


    /**
     * method that allows to show that the limit of the player reached the maximum
     */
    @Override
    public void showMaxPlayerLogin() {
        out.println("The number of player reached the maximum, retry later!");
    }


    /**
     * method that allows to show the player that exited the game
     * @param playerName name of the player who exited the game
     */
    @Override
    public void showExitPlayer(String playerName) {
        out.println("\n" + "The player " + playerName + " disconnected from the game");
    }

    /**
     * method that allows to show the player that reconnected to the game
     * @param playerName name of the player that reconnected to the game
     */
    @Override
    public void showReconnectPlayer(String playerName) {
        out.println("\n" + "The player " + playerName + " reconnected to the game");
    }

    /**
     * method that allows to show that a player can't reconnect to a game because no players exit
     */
    @Override
    public void showNotPermittedReconnection() {
        out.println("\n" + "There's no player available to reconnect");
    }

    /**
     * method that allows to reload all the scene of the player who reconnected to the game
     * @param currPlayer current player
     * @param singlePlay boolean that indicates if the modality is single player
     * @param gameStart boolean that indicates if the game is started
     * @param tool list of tool cards
     * @param publicCard list of public cards
     * @param players list of players
     */
    @Override
    public void showReload(Player currPlayer,boolean singlePlay, boolean gameStart, List<ToolCard> tool, List<PublicObjectiveCard> publicCard, List<Player> players) {
        out.println("\n" + "You are returned to the game!");

    }


}





