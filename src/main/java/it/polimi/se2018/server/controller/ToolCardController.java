package it.polimi.se2018.server.controller;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.*;

import java.util.Observable;
import java.util.Observer;

public class ToolCardController implements Observer {

    private  Game game;
    private ToolCardEffect toolCardEffect;

    protected ToolCardController (Game game) {
        this.game = game;
        this.toolCardEffect = new ToolCardEffect(game);
    }

    protected void toolCardEffectRequest(int n, VirtualView view) {

       if (n == 1) {

            view.sendEvent(new GrozingPliersRequestEvent(view.getPlayerID()));

        } else if (n == 2) {

            view.sendEvent(new EglomiseBrushRequestEvent(view.getPlayerID()));

        }else if (n == 3) {

            view.sendEvent(new CopperFoilRequestEvent(view.getPlayerID()));

        }else if (n == 4) {

            view.sendEvent(new LathekinRequestEvent(view.getPlayerID()));

        }else if (n == 5) {

            view.sendEvent(new LensCutterRequestEvent(view.getPlayerID()));

        }else if (n == 6) {

            view.sendEvent(new FluxBrushRequestEvent(view.getPlayerID()));

        } else if (n == 7) {

            view.sendEvent(new GlazingHammerRequestEvent(view.getPlayerID()));

        } else if (n == 8) {

            view.sendEvent(new RunningPliersRequestEvent(view.getPlayerID()));

        } else if (n == 9) {

            view.sendEvent(new CorkBackedRequestEvent(view.getPlayerID()));

        } else if (n == 10) {

            view.sendEvent(new GrindingStoneRequestEvent(view.getPlayerID()));

        }else if (n == 11) {

            view.sendEvent(new FluxRemoverRequestEvent(view.getPlayerID()));

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
            }catch (InvalidMoveException e ){
                e.printStackTrace();
            }
            game.nextStepTool(virtualView);

        }

        if (arg instanceof EglomiseBrushEvent) {

            try {
                toolCardEffect.eglomiseBrushEffect(virtualView.getPlayerID(), ((EglomiseBrushEvent) arg).getIndexStart(), ((EglomiseBrushEvent) arg).getIndexEnd());
            }catch(InvalidMoveException e){
                e.printStackTrace();
            }
            game.nextStepTool(virtualView);
        }

        if (arg instanceof CopperFoilEvent) {

            try {
                toolCardEffect.copperFoilBurnisherEffect(virtualView.getPlayerID(), ((CopperFoilEvent)arg).getIndexStart(), ((CopperFoilEvent) arg).getIndexEnd());
            }catch(InvalidMoveException e){
                e.printStackTrace();
            }
            game.nextStepTool(virtualView);
        }

        if (arg instanceof LathekinEvent) {

           try {
               toolCardEffect.lathekinEffect(virtualView.getPlayerID(), ((LathekinEvent)arg).getIndexStartOne(), ((LathekinEvent) arg).getIndexEndOne(), ((LathekinEvent)arg).getIndexStartTwo(), ((LathekinEvent) arg).getIndexEndTwo());
           }catch(InvalidMoveException e){
               e.printStackTrace();
           }
           game.nextStepTool(virtualView);
        }

        if (arg instanceof LensCutterEvent) {

            try {
                toolCardEffect.lensCutterEffect(virtualView.getPlayerID(), ((LensCutterEvent)arg).getIndexPool(), ((LensCutterEvent)arg).getIndexRound(), ((LensCutterEvent)arg).getIndexPosition());
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
            game.nextStepTool(virtualView);
        }

        if (arg instanceof FluxBrushEvent) {

            toolCardEffect.fluxBrushEffect(virtualView.getPlayerID(), ((FluxBrushEvent)arg).getIndexPool());
            game.nextTurn();
        }

        if (arg instanceof GlazingHammerEvent) {

            try {
                toolCardEffect.glazingHammerEffect(virtualView.getPlayerID());
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

      /*  if (arg instanceof RunningPliersEvent) {

            toolCardEffect.
        }*/

        if (arg instanceof CorkBackedEvent) {

            try {
                toolCardEffect.corkBackedStraightedgeEffect(virtualView.getPlayerID(), ((CorkBackedEvent)arg).getIndexPool(), ((CorkBackedEvent)arg).getIndexPattern() );
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

        if (arg instanceof GrindingStoneEvent) {

            toolCardEffect.grindingStoneEffect(virtualView.getPlayerID(), ((GrindingStoneEvent)arg).getIndexPool());
        }

        /*if (arg instanceof FluxRemoverEvent) {

            toolCardEffect.fluxRemoverEffect();
        }*/

        if (arg instanceof TapWheelEvent) {

            try {
                System.out.println("entro nell effetto");
                toolCardEffect.tapWheelEffect(virtualView.getPlayerID(),((TapWheelEvent) arg).getNumberDice(), ((TapWheelEvent) arg).getIndexStartOne(), ((TapWheelEvent) arg).getIndexEndOne(),
                        ((TapWheelEvent) arg).getIndexStartTwo(), ((TapWheelEvent) arg).getIndexEndTwo());
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

    }
}
