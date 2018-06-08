package it.polimi.se2018.server.controller;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.InvalidMoveEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.*;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.PlayerPatternUpdateEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.UpdatePoolEvent;

import java.util.Observable;
import java.util.Observer;

public class ToolCardController implements Observer {

    private  Game game;
    private ToolCardEffect toolCardEffect;
    private Dice dice;

    protected ToolCardController (Game game) {
        this.game = game;
        this.toolCardEffect = new ToolCardEffect(game);
    }

    protected void toolCardEffectRequest(int n, VirtualView view) {

       if (n == 1) {

            view.sendEvent(new GrozingPliersRequestEvent(view.getPlayerID(), game.getModel().getDraftPool().getNowNumber()));

        } else if (n == 2) {

            view.sendEvent(new EglomiseBrushRequestEvent(view.getPlayerID()));

        }else if (n == 3) {

            view.sendEvent(new CopperFoilRequestEvent(view.getPlayerID()));

        }else if (n == 4) {

            view.sendEvent(new LathekinRequestEvent(view.getPlayerID()));

        }else if (n == 5) {

            view.sendEvent(new LensCutterRequestEvent(view.getPlayerID(), game.getModel().getDraftPool().getNowNumber(), game.getModel().getRoundTracker().getRoundsSizes()));

        }else if (n == 6) {

            view.sendEvent(new FluxBrushRequestEvent(view.getPlayerID(), game.getModel().getDraftPool().getNowNumber()));

        } else if (n == 7) {

            view.sendEvent(new GlazingHammerRequestEvent(view.getPlayerID()));

        } else if (n == 8) {

            view.sendEvent(new RunningPliersRequestEvent(view.getPlayerID(), game.getModel().getDraftPool().getNowNumber()));

        } else if (n == 9) {

            view.sendEvent(new CorkBackedRequestEvent(view.getPlayerID(), game.getModel().getDraftPool().getNowNumber()));

        } else if (n == 10) {

            view.sendEvent(new GrindingStoneRequestEvent(view.getPlayerID(), game.getModel().getDraftPool().getNowNumber()));

        }else if (n == 11) {

            dice = game.getModel().getDiceBag().getDice();
            view.sendEvent(new FluxRemoverRequestEvent(view.getPlayerID(), dice.getColor(), game.getModel().getDraftPool().getNowNumber()));

        } else {

            view.sendEvent(new TapWheelRequestEvent(view.getPlayerID()));

        }
    }

    @Override
    public void update(Observable o, Object arg) {

        VirtualView virtualView = (VirtualView) o;

        if (arg instanceof GrozingPliersEvent) {

            try {
                toolCardEffect.grozingPliersEffect(virtualView.getPlayerID(), ((GrozingPliersEvent) arg).getIndexPool(), ((GrozingPliersEvent) arg).getIncrease());
                game.nextStepTool(virtualView);
            }
            catch (InvalidMoveException e ){

                virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                game.getModel().updatePoolAndNotify();
                virtualView.sendEvent(new GrozingPliersRequestEvent(virtualView.getPlayerID(),game.getModel().getDraftPool().getNowNumber() ));
            }


        }

        if (arg instanceof EglomiseBrushEvent) {

            Dice dice = game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().getDice( ((EglomiseBrushEvent) arg).getIndexStart());

            try {
                toolCardEffect.eglomiseBrushEffect(virtualView.getPlayerID(), ((EglomiseBrushEvent) arg).getIndexStart(), ((EglomiseBrushEvent) arg).getIndexEnd());
                game.nextStepTool(virtualView);
            }
            catch(InvalidMoveException e){
                 virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                 game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().putAnyDice(dice, ((EglomiseBrushEvent) arg).getIndexStart());
                 virtualView.sendEvent(new EglomiseBrushRequestEvent(virtualView.getPlayerID()));
            }
            catch (NullPointerException e) {
                virtualView.sendEvent(new InvalidMoveEvent("There's no dice to move in the start index", virtualView.getPlayerID()));
                game.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                game.startTool(virtualView);
            }

        }

        if (arg instanceof CopperFoilEvent) {

            Dice dice = game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().getDice( ((CopperFoilEvent) arg).getIndexStart());

            try {
                toolCardEffect.copperFoilBurnisherEffect(virtualView.getPlayerID(), ((CopperFoilEvent)arg).getIndexStart(), ((CopperFoilEvent) arg).getIndexEnd());
                game.nextStepTool(virtualView);
            }
            catch(InvalidMoveException e){
                virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().putAnyDice(dice, ((CopperFoilEvent) arg).getIndexStart());
                virtualView.sendEvent(new CopperFoilRequestEvent(virtualView.getPlayerID()));

            }
            catch (NullPointerException e) {
                virtualView.sendEvent(new InvalidMoveEvent("There's no dice to move in the start index", virtualView.getPlayerID()));
                game.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                game.startTool(virtualView);
            }

        }

        if (arg instanceof LathekinEvent) {

            Dice dice1 = game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().getDice( ((LathekinEvent) arg).getIndexStartOne());
            Dice dice2 = game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().getDice( ((LathekinEvent) arg).getIndexStartTwo());
            try {
               toolCardEffect.lathekinEffect(virtualView.getPlayerID(), ((LathekinEvent)arg).getIndexStartOne(), ((LathekinEvent) arg).getIndexEndOne(), ((LathekinEvent)arg).getIndexStartTwo(), ((LathekinEvent) arg).getIndexEndTwo());
                game.nextStepTool(virtualView);
            }
            catch(InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("Error first dice")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(),virtualView.getPlayerID()));
                    game.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                    virtualView.sendEvent(new LathekinRequestEvent(virtualView.getPlayerID()));
                }

                if (e.getMessage().equalsIgnoreCase("Error second dice")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(),virtualView.getPlayerID()));
                    game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().removeDice( ((LathekinEvent)arg).getIndexEndOne());
                    game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().putAnyDice(dice1, ((LathekinEvent)arg).getIndexStartOne());
                    game.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                    virtualView.sendEvent(new LathekinRequestEvent(virtualView.getPlayerID()));
                }

            }
            catch (NullPointerException e) {
                virtualView.sendEvent(new InvalidMoveEvent("There's no dice to move in the start index", virtualView.getPlayerID()));
                game.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                game.startTool(virtualView);
            }

        }

        if (arg instanceof LensCutterEvent) {

            toolCardEffect.lensCutterEffect(virtualView.getPlayerID(), ((LensCutterEvent) arg).getIndexPool(), ((LensCutterEvent) arg).getIndexRound(), ((LensCutterEvent) arg).getIndexPosition());
            game.nextStepTool(virtualView);
        }

        if (arg instanceof FluxBrushEvent) {

            toolCardEffect.fluxBrushEffect(virtualView.getPlayerID(), ((FluxBrushEvent)arg).getIndexPool());
            game.nextStepTool(virtualView);
        }

        if (arg instanceof GlazingHammerEvent) {

            try {
                toolCardEffect.glazingHammerEffect(virtualView.getPlayerID());
                game.nextStepTool(virtualView);
            } catch (InvalidMoveException e) {
                virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                game.getTool(7, game.getToolCardList()).setCost(1);
                game.startTool(virtualView);
            }

        }

        if (arg instanceof RunningPliersEvent) {

            Dice dice = game.getModel().getDraftPool().getDraftPool().get( ((RunningPliersEvent) arg).getIndexPool());

            try {
                toolCardEffect.runningPliers(virtualView.getPlayerID(), ((RunningPliersEvent)arg).getIndexPool(), ((RunningPliersEvent)arg).getIndexPattern());
                game.nextTurn();
            } catch (InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("Invalid turn moment")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    game.startTool(virtualView);
                }

                else {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    game.getModel().getDraftPool().getDraftPool().add(dice);
                    game.getModel().updatePoolAndNotify();
                    virtualView.sendEvent(new RunningPliersRequestEvent(virtualView.getPlayerID(), game.getModel().getDraftPool().getNowNumber()));
                }

            }
        }

        if (arg instanceof CorkBackedEvent) {

            Dice dice = game.getModel().getDraftPool().getDraftPool().get( ((CorkBackedEvent) arg).getIndexPool() );

            try {
                toolCardEffect.corkBackedStraightedgeEffect(virtualView.getPlayerID(), ((CorkBackedEvent)arg).getIndexPool(), ((CorkBackedEvent)arg).getIndexPattern() );
                game.nextTurn();
            } catch (InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("Invalid turn moment")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    game.startTool(virtualView);
                }
                else
                {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    game.getModel().getDraftPool().getDraftPool().add(dice);
                    virtualView.sendEvent(new CorkBackedRequestEvent(virtualView.getPlayerID(), game.getModel().getDraftPool().getNowNumber()));


                }
            }

        }

        if (arg instanceof GrindingStoneEvent) {

            toolCardEffect.grindingStoneEffect(virtualView.getPlayerID(), ((GrindingStoneEvent)arg).getIndexPool());
            game.nextStepTool(virtualView);
        }

        if (arg instanceof FluxRemoverEvent) {

            toolCardEffect.fluxRemoverEffect(virtualView.getPlayerID(), ((FluxRemoverEvent)arg).getIndexPool(), ((FluxRemoverEvent)arg).getDiceValue(), dice);
            game.nextStepTool(virtualView);
        }

        if (arg instanceof TapWheelEvent) {

            Dice dice1 = game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().getDice( ((TapWheelEvent)arg).getIndexStartOne());

            Dice dice2 = game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().getDice( ((TapWheelEvent)arg).getIndexStartTwo());

            try {
                toolCardEffect.tapWheelEffect(virtualView.getPlayerID(),((TapWheelEvent) arg).getNumberDice(), ((TapWheelEvent) arg).getIndexStartOne(), ((TapWheelEvent) arg).getIndexEndOne(),
                        ((TapWheelEvent) arg).getIndexStartTwo(), ((TapWheelEvent) arg).getIndexEndTwo());
            }

            catch (NullPointerException e) {

                virtualView.sendEvent(new InvalidMoveEvent("There's no dice to move in the start index", virtualView.getPlayerID()));
                game.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                game.startTool(virtualView);
            }

            catch (InvalidMoveException e) {

                if (e.getMessage().equalsIgnoreCase("There's no dice on the Round Tracker of the same color") || e.getMessage().equalsIgnoreCase("You choose two dice with different colors")) {
                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    game.startTool(virtualView);
                }


                else if (((TapWheelEvent)arg).getNumberDice() == 1  || (e.getMessage().equalsIgnoreCase("Error in the first dice"))) {

                    virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                    game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().putAnyDice(dice1,((TapWheelEvent) arg).getIndexStartOne());
                    game.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                    virtualView.sendEvent(new TapWheelRequestEvent(virtualView.getPlayerID()));

                }

                else {
                   if (e.getMessage().equalsIgnoreCase("Error in the second dice")) {
                       virtualView.sendEvent(new InvalidMoveEvent(e.getMessage(), virtualView.getPlayerID()));
                       game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().removeDice(((TapWheelEvent)arg).getIndexEndOne());
                       game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().putAnyDice(dice1, ((TapWheelEvent)arg).getIndexStartOne());
                       game.getModel().getPlayerFromID(virtualView.getPlayerID()).getPattern().putAnyDice(dice2, ((TapWheelEvent) arg).getIndexStartTwo());
                       game.getModel().updatePatternAndNotify(virtualView.getPlayerID());
                       virtualView.sendEvent(new TapWheelRequestEvent(virtualView.getPlayerID()));
                   }
                }



            }



        }

    }
}
