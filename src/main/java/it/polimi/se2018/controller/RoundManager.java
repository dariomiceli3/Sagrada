package it.polimi.se2018.controller;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.model.Components.DraftPool;
import it.polimi.se2018.model.Components.GlassBox;
import it.polimi.se2018.model.Components.Player;

import java.util.ArrayList;
import java.util.Iterator;

public class RoundManager {


    /*public void createDraftPool() {
        DraftPool draftPool = new DraftPool();

    }*/


    public ArrayList<Integer> calculatePrivate(ArrayList<Player> playerArrayList) {
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < playerArrayList.size(); i++) {
            int result;
            result = playerArrayList.get(i).getPrivate().RunPrivate(playerArrayList.get(i).getPattern());
            results.add(result);
        }
        return results;

    }

    public ArrayList<Integer> calculateTokens(ArrayList<Player> playerArrayList) {
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < playerArrayList.size(); i++) {
            int result;
            result = playerArrayList.get(i).getTokensNumber();
            results.add(result);
        }
        return results;

    }

    public ArrayList<Integer> calculateEmptyBox(ArrayList<Player> playerArrayList) {
        PatternCard result;
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < playerArrayList.size(); i++) {
            result = playerArrayList.get(i).getPattern();
            int boxEmptyCounter=0;

            for (int j = 0; j < result.getPattern().size(); j++) {
                if(result.getPattern().isEmpty()) {
                    boxEmptyCounter++;
                }

            }

            results.add(boxEmptyCounter);
        }
        return results;

    }

    public ArrayList<Integer> calculatePublic(ArrayList<Player> playerArrayList, ArrayList<PublicObjectiveCard> publicObjectiveCardArrayList) {
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < playerArrayList.size(); i++) {
            PatternCard result;
            int personalResult=0;
            result = playerArrayList.get(i).getPattern();
            for (int j = 0; j < publicObjectiveCardArrayList.size(); j++) {
                personalResult = personalResult + publicObjectiveCardArrayList.get(j).executeEffect(result);

            }
            results.add(personalResult);

            }
        return results;

    }


    
}
