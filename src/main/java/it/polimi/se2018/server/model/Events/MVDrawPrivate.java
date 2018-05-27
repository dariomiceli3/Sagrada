package it.polimi.se2018.server.model.Events;


import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;

public class MVDrawPrivate implements Event {

    private PrivateObjectiveCard privateCard;

    public MVDrawPrivate(PrivateObjectiveCard privateCard){
        this.privateCard = privateCard;
    }

    public PrivateObjectiveCard getPrivateCard() {
        return privateCard;
    }

}
