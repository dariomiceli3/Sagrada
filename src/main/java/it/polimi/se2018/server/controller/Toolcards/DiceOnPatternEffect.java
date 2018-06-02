package it.polimi.se2018.server.controller.Toolcards;

import com.sun.xml.internal.bind.v2.TODO;
import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;

import java.util.ArrayList;

public class DiceOnPatternEffect {

    public void eglomiseBrushEffect(PatternCard patternCard, Dice dice, int i) throws InvalidMoveException {
        patternCard.putDiceOnPatternEglomise(dice, i, patternCard);
    }

    public void copperFoilBurnisher(PatternCard patternCard, Dice dice, int i) throws InvalidMoveException {
        patternCard.putDiceOnPatternCopper(dice, i, patternCard);
    }


    public void lathekinEffect(PatternCard patternCard, ArrayList<Integer> PositionDiceToMove, ArrayList<Integer>PositionToArrive ) throws InvalidMoveException {
        Dice dice = patternCard.getDice(PositionDiceToMove.get(0));
        Dice dice1 = patternCard.removeDice(dice, PositionDiceToMove.get(0));
        Dice dice2 = patternCard.getDice(PositionDiceToMove.get(1));
        Dice dice3 = patternCard.removeDice(dice2, PositionDiceToMove.get(1));
        patternCard.putDiceOnPattern(dice1, PositionToArrive.get(0), patternCard);
        patternCard.putDiceOnPattern(dice3, PositionToArrive.get(1), patternCard);
    }

    //TODO assumo che i dadi siano del colore giusto (Toolcard 12)
    public void tapWheel(PatternCard patternCard, ArrayList<Integer> PositionDiceToMove,ArrayList<Integer>PositionToArrive) throws InvalidMoveException {
        for (int i=0; i<PositionDiceToMove.size(); i++){
            if (i==2) {
                break;
            }
            else {
            Dice dice = patternCard.getDice(PositionDiceToMove.get(i));
            Dice dice1 = patternCard.removeDice(dice, PositionDiceToMove.get(i));
            patternCard.putDiceOnPattern(dice1, PositionToArrive.get(i), patternCard);
            }
        }
    }
    public void corckBackedStraightedge(PatternCard patternCard, Dice dice, int position) throws InvalidMoveException {
        patternCard.putDice(dice, position);
    }
}
