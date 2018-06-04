package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

/**
 * Interface PublicEffects(DP Strategy): the interface used for declare method to calculate the points
 * @author Salvatrore Fadda
 */
public interface PublicEffects  {
    int runPublic(PatternCard pattern);
}
