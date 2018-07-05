package it.polimi.se2018.server.controller;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.network.VirtualView;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.events.clientserver.*;
import it.polimi.se2018.events.InvalidMoveEvent;
import it.polimi.se2018.events.serverclient.controllerview.*;

import java.util.Observable;
import java.util.Observer;

public class ToolCardController implements Observer {

    private GameController gameController;
    private ToolCardEffect toolCardEffect;
    private Dice dice;

    ToolCardController(GameController gameController) {
        this.gameController = gameController;
        this.toolCardEffect = new ToolCardEffect(gameController);
    }

    void toolCardEffectRequest(int n, VirtualView view) {

       if (n == 1) {
            view.sendEvent(new GrozingPliersRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
       } else if (n == 2) {
            view.sendEvent(new EglomiseBrushRequestEvent(view.getPlayerID()));
       }
       else if (n == 3) {
            view.sendEvent(new CopperFoilRequestEvent(view.getPlayerID()));
       }
       else if (n == 4) {
            view.sendEvent(new LathekinRequestEvent(view.getPlayerID()));
       }
       else if (n == 5) {
            view.sendEvent(new LensCutterRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber(), gameController.getModel().getRoundTracker().getRoundsSizes()));
       }
       else if (n == 6) {
            view.sendEvent(new FluxBrushRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
       }
       else if (n == 7) {
            view.sendEvent(new GlazingHammerRequestEvent(view.getPlayerID()));
       }
       else if (n == 8) {
            view.sendEvent(new RunningPliersRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
       }
       else if (n == 9) {
            view.sendEvent(new CorkBackedRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
       }
       else if (n == 10) {
            view.sendEvent(new GrindingStoneRequestEvent(view.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
       }
       else if (n == 11) {
            dice = gameController.getModel().getDiceBag().getDice();
            view.sendEvent(new FluxRemoverRequestEvent(view.getPlayerID(), dice.getColor(), gameController.getModel().getDraftPool().getNowNumber()));
       }
       else {
           view.sendEvent(new TapWheelRequestEvent(view.getPlayerID()));
       }
    }

    @Override
    public void update(Observable o, Object arg) {

        VirtualView virtualView = (VirtualView) o;

        if (arg instanceof GrozingPliersEvent) {

            try {
                toolCardEffect.grozingPliersEffect(virtualView.getPlayerID(), ((GrozingPliersEvent) arg).getIndexPool(), ((GrozingPliersEvent) arg).getIncrease());
                gameController.nextStepTool(virtualView);
            }
            catch (InvalidMoveException e ){

                virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                gameController.getModel().updatePoolAndNotify();
                virtualView.sendEvent(new GrozingPliersRequestEvent(virtualView.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber() ));
            }
        }
        if (arg instanceof EglomiseBrushEvent) {

            Dice eglomiseDice = gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().getDice( ((EglomiseBrushEvent) arg).getIndexStart());

            try {
                toolCardEffect.eglomiseBrushEffect(virtualView.getPlayerID(), ((EglomiseBrushEvent) arg).getIndexStart(), ((EglomiseBrushEvent) arg).getIndexEnd());
                gameController.nextStepTool(virtualView);
            }
            catch(InvalidMoveException e){
                 virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                 gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().putAnyDice(eglomiseDice, ((EglomiseBrushEvent) arg).getIndexStart());
                 virtualView.sendEvent(new EglomiseBrushRequestEvent(virtualView.getPlayerID()));
            }
            catch (NullPointerException e) {
                virtualView.sendEvent(new InvalidMoveEvent("There's no dice to move in the start index", virtualView.getPlayerID()));
                gameController.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                invalidMove(virtualView, 2);
                gameController.startTool(virtualView);
            }
        }

        if (arg instanceof CopperFoilEvent) {

            Dice copperDice = gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().getDice( ((CopperFoilEvent) arg).getIndexStart());

            try {
                toolCardEffect.copperFoilBurnisherEffect(virtualView.getPlayerID(), ((CopperFoilEvent)arg).getIndexStart(), ((CopperFoilEvent) arg).getIndexEnd());
                gameController.nextStepTool(virtualView);
            }
            catch(InvalidMoveException e){
                virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().putAnyDice(copperDice, ((CopperFoilEvent) arg).getIndexStart());
                virtualView.sendEvent(new CopperFoilRequestEvent(virtualView.getPlayerID()));

            }
            catch (NullPointerException e) {
                virtualView.sendEvent(new InvalidMoveEvent("There's no dices to move in the start index", virtualView.getPlayerID()));
                gameController.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                invalidMove(virtualView, 3);
                gameController.startTool(virtualView);
            }
        }
        if (arg instanceof LathekinEvent) {

            Dice dice1 = gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().getDice( ((LathekinEvent) arg).getIndexStartOne());

            try {
               toolCardEffect.lathekinEffect(virtualView.getPlayerID(), ((LathekinEvent)arg).getIndexStartOne(), ((LathekinEvent) arg).getIndexEndOne(), ((LathekinEvent)arg).getIndexStartTwo(), ((LathekinEvent) arg).getIndexEndTwo());
                gameController.nextStepTool(virtualView);
            }
            catch(InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("Error first dice")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(),virtualView.getPlayerID()));
                    gameController.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                    virtualView.sendEvent(new LathekinRequestEvent(virtualView.getPlayerID()));
                }

                if (e.getMessage().equalsIgnoreCase("Error second dice")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(),virtualView.getPlayerID()));
                    gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().removeDice( ((LathekinEvent)arg).getIndexEndOne());
                    gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().putAnyDice(dice1, ((LathekinEvent)arg).getIndexStartOne());
                    gameController.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                    virtualView.sendEvent(new LathekinRequestEvent(virtualView.getPlayerID()));
                }

            }
            catch (NullPointerException e) {
                virtualView.sendEvent(new InvalidMoveEvent("There is no dice to move in the start index", virtualView.getPlayerID()));
                gameController.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                invalidMove(virtualView, 4);
                gameController.startTool(virtualView);
            }
        }
        if (arg instanceof LensCutterEvent) {

            toolCardEffect.lensCutterEffect(virtualView.getPlayerID(), ((LensCutterEvent) arg).getIndexPool(), ((LensCutterEvent) arg).getIndexRound(), ((LensCutterEvent) arg).getIndexPosition());
            gameController.nextStepTool(virtualView);
        }
        if (arg instanceof FluxBrushEvent) {

            toolCardEffect.fluxBrushEffect(virtualView.getPlayerID(), ((FluxBrushEvent)arg).getIndexPool());
            gameController.nextStepTool(virtualView);
        }
        if (arg instanceof GlazingHammerEvent) {

            try {
                toolCardEffect.glazingHammerEffect(virtualView.getPlayerID());
                gameController.nextStepTool(virtualView);
            } catch (InvalidMoveException e) {
                virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                invalidMove(virtualView, 7);
                gameController.startTool(virtualView);
            }
        }
        if (arg instanceof RunningPliersEvent) {

            Dice runningPDice = gameController.getModel().getDraftPool().getDraftPool().get( ((RunningPliersEvent) arg).getIndexPool());

            try {
                toolCardEffect.runningPliers(virtualView.getPlayerID(), ((RunningPliersEvent)arg).getIndexPool(), ((RunningPliersEvent)arg).getIndexPattern());
                gameController.nextTurn();
            } catch (InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("Invalid turn moment")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    invalidMove(virtualView, 8);
                    gameController.startTool(virtualView);
                }
                else {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    gameController.getModel().getDraftPool().getDraftPool().add(runningPDice);
                    gameController.getModel().updatePoolAndNotify();
                    virtualView.sendEvent(new RunningPliersRequestEvent(virtualView.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
                }
            }
        }
        if (arg instanceof CorkBackedEvent) {

            Dice corkDice = gameController.getModel().getDraftPool().getDraftPool().get( ((CorkBackedEvent) arg).getIndexPool() );

            try {
                toolCardEffect.corkBackedStraightedgeEffect(virtualView.getPlayerID(), ((CorkBackedEvent)arg).getIndexPool(), ((CorkBackedEvent)arg).getIndexPattern() );
                gameController.nextTurn();
            } catch (InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("Invalid turn moment")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    invalidMove(virtualView, 9);
                    gameController.startTool(virtualView);
                }
                else
                {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    gameController.getModel().getDraftPool().getDraftPool().add(corkDice);
                    virtualView.sendEvent(new CorkBackedRequestEvent(virtualView.getPlayerID(), gameController.getModel().getDraftPool().getNowNumber()));
                }
            }
        }

        if (arg instanceof GrindingStoneEvent) {

            toolCardEffect.grindingStoneEffect(virtualView.getPlayerID(), ((GrindingStoneEvent)arg).getIndexPool());
            gameController.nextStepTool(virtualView);
        }

        if (arg instanceof FluxRemoverEvent) {

            toolCardEffect.fluxRemoverEffect(virtualView.getPlayerID(), ((FluxRemoverEvent)arg).getIndexPool(), ((FluxRemoverEvent)arg).getDiceValue(), dice);
            gameController.nextStepTool(virtualView);
        }

        if (arg instanceof TapWheelEvent) {

            try {
                toolCardEffect.tapWheelEffect(virtualView.getPlayerID(),((TapWheelEvent) arg).getNumberDice(), ((TapWheelEvent) arg).getIndexStartOne(), ((TapWheelEvent) arg).getIndexEndOne(),
                        ((TapWheelEvent) arg).getIndexStartTwo(), ((TapWheelEvent) arg).getIndexEndTwo());
                gameController.nextStepTool(virtualView);
            }

            catch (NullPointerException e) {

                virtualView.sendEvent(new InvalidMoveEvent("There' s no dice to move in the start index", virtualView.getPlayerID()));
                gameController.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                invalidMove(virtualView, 12);
                gameController.startTool(virtualView);
            }

            catch (InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("There's no dice on the Round Tracker of the same color") || e.getMessage().equalsIgnoreCase("You choose two dice with different colors")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    invalidMove(virtualView, 12);
                    gameController.startTool(virtualView);
                }

                if ((e.getMessage().equalsIgnoreCase("Error in the first dice")) || e.getMessage().equalsIgnoreCase("Error in the second dice")) {

                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    gameController.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                    virtualView.sendEvent(new TapWheelRequestEvent(virtualView.getPlayerID()));

                }
            }
        }
    }

    private void invalidMove(VirtualView virtualView,int n){

        if(gameController.isSinglePlayer()) {
            gameController.getModel().getDraftPool().getDraftPool().add(gameController.getDiceToolSinglePlayer());
            gameController.getModel().updatePoolAndNotify();
            gameController.getModel().getToolCardList().add(gameController.getToolRemoveSinglePlayer());
        }
        else if(gameController.getTool(n).getUsage() == 1){
            gameController.getTool(n).setCost(1);
            int t = gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).getTokensNumber();
            gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).setTokensNumber(t + 1);
            gameController.getTool(n).setUsage(0);
        }
        else {
            int t = gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).getTokensNumber();
            gameController.getModel().getPlayerFromID(virtualView.getPlayerID()).setTokensNumber(t + 2);
        }
    }
}
