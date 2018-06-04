package it.polimi.se2018.server.controller;

import it.polimi.se2018.server.VirtualView;

import java.util.Observable;
import java.util.Observer;

public class ToolCardController implements Observer {

    private  Game game;
    private ToolCardEffect toolCardEffect;

    protected ToolCardController (Game game) {
        this.game = game;
        this.toolCardEffect = new ToolCardEffect(game);
    }

    public void toolCardEffectRequest(int n, VirtualView view) {

       /*if (n == 1) {

            view.sendEvent(new GrozingPliersRequestEvent(view.getPlayerID()));

        } else if (n == 2) {

            view.sendEvent(new EglimiseBlushRequestEvent(view.getPlayerID()));

        } else if (n == 3) {

            view.sendEvent(new CopperFoilBurnisherRequestEvent(view.getPlayerID()));

        } else if (n == 4) {

            view.sendEvent(new LathekinRequestEvent(view.getPlayerID()));

        } else if (n == 5) {

            view.sendEvent(new LensCutterRequestEvent(view.getPlayerID()));

        } else if (n == 6) {

            view.sendEvent(new FluxBrushRequestEvent(view.getPlayerID()));

        } else if (n == 7) {

            view.sendEvent(new GlazingHammerRequestEvent(view.getPlayerID()));

        } else if (n == 8) {

            view.sendEvent(new RunningPliersRequestEvent(view.getPlayerID()));

        } else if (n == 9) {

            view.sendEvent(new CorkBackedRequestEvent(view.getPlayerID()));

        } else if (n == 10) {

            view.sendEvent(new GrindingStoneRequestEvent(view.getPlayerID()));

        } else if (n == 11) {

            view.sendEvent(new FluxRemoverRequestEvent(view.getPlayerID()));

        } else {

            view.sendEvent(new TapWheelRequestEvent(view.getPlayerID()));

        }*/
    }

    @Override
    public void update(Observable o, Object arg) {
        VirtualView virtualView = (VirtualView) o;

   /*     if (arg instanceof GrozingPliersEvent) {

            toolCardEffect.grozingPliersEffect();

        }

        if (arg instanceof EglimiseBlushEvent) {

            toolCardEffect.eglomiseBrushEffect();
        }

        if (arg instanceof CopperFoilBurnisherEvent) {

            toolCardEffect.copperFoilBurnisherEffect();
        }

        if (arg instanceof LathekinEvent) {

            toolCardEffect.lathekinEffect();
        }

        if (arg instanceof LensCutterEvent) {

            toolCardEffect.lensCutterEffect();
        }

        if (arg instanceof FluxBrushEvent) {

            toolCardEffect.fluxBrushEffect();
        }

        if (arg instanceof GlazingHammerEvent) {

            toolCardEffect.glazingHammerEffect();
        }

        if (arg instanceof RunningPliersEvent) {

            toolCardEffect.
        }

        if (arg instanceof CorkBackedEvent) {

            toolCardEffect.corckBackedStraightedgeEffect();
        }

        if (arg instanceof GrindingStoneEvent) {

            toolCardEffect.grindingStoneEffect();
        }

        if (arg instanceof FluxRemoverEvent) {

            toolCardEffect.fluxRemoverEffect();
        }

        if (arg instanceof TapWheelEvent) {

            toolCardEffect.tapWheelEffect();
        } */

    }
}
