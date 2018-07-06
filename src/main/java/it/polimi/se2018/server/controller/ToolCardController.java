package it.polimi.se2018.server.controller;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.network.VirtualView;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.events.clientserver.*;
import it.polimi.se2018.events.InvalidMoveEvent;
import it.polimi.se2018.events.serverclient.controllerview.*;

import java.util.Observable;
import java.util.Observer;

/**
 * Class ToolCardController: the class represents the controller of the tool card effect, decide which effect to call depending
 * on the the runtime event received from the notification of the virtual view e let the effect do the rest, and decide which
 * request send to the player depending on the tool card the player decide to use. The tool card controller has the same features
 * of the controller (Observer of the virtual view) of the MVC pattern, but it's purpose is to separate from the main controller
 * of the game, the handling of the tool card events
 * @see java.util.Observer
 * @author fadda-miceli-mundo
 */
public class ToolCardController implements Observer {

    private GameController gameController;
    private ToolCardEffect toolCardEffect;
    private Dice dice;

    /**
     * Class constructor linked with the main controller of the project
     * @param gameController to link the controller
     */
    ToolCardController(GameController gameController) {
        this.gameController = gameController;
        this.toolCardEffect = new ToolCardEffect(gameController);
    }

    /**
     * method that send to the virtual view an event containing the request of the different tool card depending on
     * the choose of the player
     * @param n the number of the tool card
     * @param view the virtual view to send the message
     */
    void toolCardEffectRequest(int n, VirtualView view) {

        if (n == 1) {
            view.sendEvent(new GrozingPliersRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
        } else if (n == 2) {
            view.sendEvent(new EglomiseBrushRequestEvent(view.getPlayerID()));
        } else if (n == 3) {
            view.sendEvent(new CopperFoilRequestEvent(view.getPlayerID()));
        } else if (n == 4) {
            view.sendEvent(new LathekinRequestEvent(view.getPlayerID()));
        } else if (n == 5) {
            view.sendEvent(new LensCutterRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber(), gameController.getModel().getRoundTracker().getRoundsSizes()));
        } else if (n == 6) {
            view.sendEvent(new FluxBrushRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
        } else if (n == 7) {
            view.sendEvent(new GlazingHammerRequestEvent(view.getPlayerID()));
        } else if (n == 8) {
            view.sendEvent(new RunningPliersRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
        } else if (n == 9) {
            view.sendEvent(new CorkBackedRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
        } else if (n == 10) {
            view.sendEvent(new GrindingStoneRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
        } else if (n == 11) {
            dice = gameController.getModel().getDiceBag().getDice();
            view.sendEvent(new FluxRemoverRequestEvent(view.getPlayerID(), dice.getColor(), gameController.getModel().getDraftPool().getNowNumber()));
        } else {
            view.sendEvent(new TapWheelRequestEvent(view.getPlayerID()));
        }
    }

    /**
     * Override of the update Observer method, the method is invoked after the tool card controller has received a notification from the virtual view
     * that the player want to use a tool card to update its state and call the effect depending on the tool card chose by the player, it handles
     * the invalid move event if something goes wrong
     * @param o observable virtual view
     * @param arg the object received
     */
    @Override
    public void update(Observable o, Object arg) {

        VirtualView virtualView = (VirtualView) o;

        if (arg instanceof GrozingPliersEvent) {

            try {
                toolCardEffect.grozingPliersEffect(virtualView.getPlayerID(), ((GrozingPliersEvent) arg).getIndexPool(), ((GrozingPliersEvent) arg).getIncrease());
                gameController.nextStepTool(virtualView);
            } catch (InvalidMoveException e) {
                virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                virtualView.sendEvent(new GrozingPliersRequestEvent(virtualView.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
            }
        }
        if (arg instanceof EglomiseBrushEvent) {

            try {
                toolCardEffect.moveOneDiceEffect(virtualView.getPlayerID(), ((EglomiseBrushEvent) arg).getIndexStart(), ((EglomiseBrushEvent) arg).getIndexEnd(), 2);
                gameController.nextStepTool(virtualView);
            } catch (InvalidMoveException e) {
                virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                virtualView.sendEvent(new EglomiseBrushRequestEvent(virtualView.getPlayerID()));
            } catch (NullPointerException e) {
                virtualView.sendEvent(new InvalidMoveEvent("There's no dice to move in the start index", virtualView.getPlayerID()));
                gameController.getModel().tokenRefactor(gameController.isSinglePlayer(), virtualView.getPlayerID(), 2);
                gameController.startTool(virtualView);
            }
        }

        if (arg instanceof CopperFoilEvent) {

            try {
                toolCardEffect.moveOneDiceEffect(virtualView.getPlayerID(), ((CopperFoilEvent) arg).getIndexStart(), ((CopperFoilEvent) arg).getIndexEnd(), 3);
                gameController.nextStepTool(virtualView);
            } catch (InvalidMoveException e) {
                virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                virtualView.sendEvent(new CopperFoilRequestEvent(virtualView.getPlayerID()));
            } catch (NullPointerException e) {
                virtualView.sendEvent(new InvalidMoveEvent("There's no dices to move in the start index", virtualView.getPlayerID()));
                gameController.getModel().tokenRefactor(gameController.isSinglePlayer(), virtualView.getPlayerID(), 3);
                gameController.startTool(virtualView);
            }
        }
        if (arg instanceof LathekinEvent) {

            try {
                toolCardEffect.lathekinEffect(virtualView.getPlayerID(), ((LathekinEvent) arg).getIndexStartOne(), ((LathekinEvent) arg).getIndexEndOne(), ((LathekinEvent) arg).getIndexStartTwo(), ((LathekinEvent) arg).getIndexEndTwo());
                gameController.nextStepTool(virtualView);
            } catch (InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("Error first dice 4")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    virtualView.sendEvent(new LathekinRequestEvent(virtualView.getPlayerID()));
                }
                if (e.getMessage().equalsIgnoreCase("Error second dice 4")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    virtualView.sendEvent(new LathekinRequestEvent(virtualView.getPlayerID()));
                }
            } catch (NullPointerException e) {
                virtualView.sendEvent(new InvalidMoveEvent("There is no dice to move in the start index", virtualView.getPlayerID()));
                gameController.getModel().tokenRefactor(gameController.isSinglePlayer(), virtualView.getPlayerID(), 4);
                gameController.startTool(virtualView);
            }
        }
        if (arg instanceof LensCutterEvent) {

            toolCardEffect.lensCutterEffect(virtualView.getPlayerID(), ((LensCutterEvent) arg).getIndexPool(), ((LensCutterEvent) arg).getIndexRound(), ((LensCutterEvent) arg).getIndexPosition());
            gameController.nextStepTool(virtualView);
        }
        if (arg instanceof FluxBrushEvent) {

            toolCardEffect.changeDiceValueEffect(virtualView.getPlayerID(), ((FluxBrushEvent) arg).getIndexPool(), 6);
            gameController.nextStepTool(virtualView);
        }
        if (arg instanceof GlazingHammerEvent) {

            try {
                toolCardEffect.glazingHammerEffect(virtualView.getPlayerID());
                gameController.nextStepTool(virtualView);
            } catch (InvalidMoveException e) {
                virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                gameController.getModel().tokenRefactor(gameController.isSinglePlayer(), virtualView.getPlayerID(), 7);
                gameController.startTool(virtualView);
            }
        }
        if (arg instanceof RunningPliersEvent) {

            try {
                toolCardEffect.runningPliers(virtualView.getPlayerID(), ((RunningPliersEvent) arg).getIndexPool(), ((RunningPliersEvent) arg).getIndexPattern());
                gameController.nextStepTool(virtualView);
            } catch (InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("Invalid turn moment")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    gameController.getModel().tokenRefactor(gameController.isSinglePlayer(), virtualView.getPlayerID(), 8);
                    gameController.startTool(virtualView);
                } else {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    virtualView.sendEvent(new RunningPliersRequestEvent(virtualView.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
                }
            }
        }
        if (arg instanceof CorkBackedEvent) {

            try {
                toolCardEffect.corkBackedStraightedgeEffect(virtualView.getPlayerID(), ((CorkBackedEvent) arg).getIndexPool(), ((CorkBackedEvent) arg).getIndexPattern());
                gameController.nextTurn();
            } catch (InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("Invalid turn moment")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    gameController.getModel().tokenRefactor(gameController.isSinglePlayer(), virtualView.getPlayerID(), 9);
                    gameController.startTool(virtualView);
                } else {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    virtualView.sendEvent(new CorkBackedRequestEvent(virtualView.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
                }
            }
        }

        if (arg instanceof GrindingStoneEvent) {

            toolCardEffect.changeDiceValueEffect(virtualView.getPlayerID(), ((GrindingStoneEvent) arg).getIndexPool(), 10);
            gameController.nextStepTool(virtualView);
        }

        if (arg instanceof FluxRemoverEvent) {

            toolCardEffect.fluxRemoverEffect(virtualView.getPlayerID(), ((FluxRemoverEvent) arg).getIndexPool(), ((FluxRemoverEvent) arg).getDiceValue(), dice);
            gameController.nextStepTool(virtualView);
        }

        if (arg instanceof TapWheelEvent) {

            try {
                toolCardEffect.tapWheelEffect(virtualView.getPlayerID(), ((TapWheelEvent) arg).getNumberDice(), ((TapWheelEvent) arg).getIndexStartOne(), ((TapWheelEvent) arg).getIndexEndOne(),
                        ((TapWheelEvent) arg).getIndexStartTwo(), ((TapWheelEvent) arg).getIndexEndTwo());
                gameController.nextStepTool(virtualView);
            }
            catch (NullPointerException e) {
                virtualView.sendEvent(new InvalidMoveEvent("There' s no dice to move in the start index", virtualView.getPlayerID()));
                gameController.getModel().tokenRefactor(gameController.isSinglePlayer(), virtualView.getPlayerID(), 12);
                gameController.startTool(virtualView);
            }
            catch (InvalidMoveException e) {
                if (e.getMessage().equalsIgnoreCase("There's no dice on the Round Tracker of the same color") || e.getMessage().equalsIgnoreCase("You choose two dice with different colors")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    gameController.getModel().tokenRefactor(gameController.isSinglePlayer(), virtualView.getPlayerID(), 12);
                    gameController.startTool(virtualView);
                }
                if ((e.getMessage().equalsIgnoreCase("Error first dice 12")) || e.getMessage().equalsIgnoreCase("Error second dice 12")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    virtualView.sendEvent(new TapWheelRequestEvent(virtualView.getPlayerID()));
                }
            }
        }
    }
}


