package it.polimi.se2018.server.controller;

import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Components.DiceColor;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class ToolCard implements Serializable, Observer {
    private String name;
    private DiceColor color;
    private int number;
    private ToolCardEffect toolCardEffectEffect;
    private Game game;

    public ToolCard (String name, DiceColor color, int number, Game game) {
        this.name = name;
        this.color = color;
        this.number = number;
        this.game = game;
        this.toolCardEffectEffect = new ToolCardEffect(game);
    }

    public DiceColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void toolCardEffectRequest(int n, VirtualView view){

        if (n == 1){

            view.sendEvent(new GrozingPliersRequestEvent());

        }else if (n == 2){

            view.sendEvent(new EglimiseBlushRequestEvent());

        }else  if(n == 3){

            view.sendEvent(new CopperFoilBurnisherRequestEvent());

        }else if (n == 4){

            view.sendEvent(new LathekinRequestEvent());

        }else if (n == 5){

            view.sendEvent(new LensCutterRequestEvent());

        }else  if(n == 6){

            view.sendEvent(new FluxBrushRequestEvent());

        }else if (n == 7){

            view.sendEvent(new GlazingHammerRequestEvent());

        }else if (n == 8){

            view.sendEvent(new RunningPliersRequestEvent());

        }else  if(n == 9){

            view.sendEvent(new CorkBackedRequestEvent());

        }else if (n == 10){

            view.sendEvent(new GrindingStoneRequestEvent());

        }else if (n == 11){

            view.sendEvent(new FluxRemoverRequestEvent());

        }else {

            view.sendEvent(new TapWheelRequestEvent());

        }
    }

    @Override
    public void update(Observable o, Object arg) {
        VirtualView virtualView = (VirtualView) o;

        if (arg instanceof GrozingPliersEvent) {

            toolCardEffectEffect.grozingPliersEffect();

        }

        if (arg instanceof EglimiseBlushEvent) {

            toolCardEffectEffect.eglomiseBrushEffect();
        }

        if (arg instanceof  CopperFoilBurnisherEvent){

            toolCardEffectEffect.copperFoilBurnisherEffect();
        }

        if (arg instanceof LathekinEvent){

            toolCardEffectEffect.lathekinEffect();
        }

        if (arg instanceof LensCutterEvent){

            toolCardEffectEffect.lensCutterEffect();
        }

        if (arg instanceof FluxBrushEvent){

            toolCardEffectEffect.fluxBrushEffect();
        }

        if (arg instanceof GlazingHammerEvent){

            toolCardEffectEffect.glazingHammerEffect();
        }

        if (arg instanceof RunningPliersEvent){

            toolCardEffectEffect.
        }

        if (arg instanceof CorkBackedEvent){

            toolCardEffectEffect.corckBackedStraightedgeEffect();
        }

        if (arg instanceof GrindingStoneEvent){

            toolCardEffectEffect.grindingStoneEffect()
        }

        if (arg instanceof FluxRemoverEvent){

            toolCardEffectEffect.
        }

        if (arg instanceof TapWheelEvent){

            toolCardEffectEffect.tapWheelEffect();
        }

        if (arg instanceof ToolCardStartEvent){
            //TODO inserire dentro game
        }


    }



}

