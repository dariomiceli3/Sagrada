package it.polimi.se2018.server.model.Events;

import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;

import java.util.List;

public class MVDrawPublic implements Event {

    private List<PublicObjectiveCard> publicCard;

    public MVDrawPublic(List<PublicObjectiveCard> publicCard){
        this.publicCard = publicCard;
    }

    public void setPublicCard(List<PublicObjectiveCard> publicCard) {
        this.publicCard = publicCard;
    }
}
