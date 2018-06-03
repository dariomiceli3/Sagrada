package it.polimi.se2018.TestCards;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestPatternCard {

    @Test
    public void testLoadPatternList() {
        PatternCard patternCard = new PatternCard();
        try {
            ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
            assertEquals(24, patternCardArrayList.size());
            assertEquals("Kaleidoscopic Dream",patternCardArrayList.get(0).getName());
            assertEquals(4,patternCardArrayList.get(0).getDifficulty());
            assertEquals(20, patternCardArrayList.get(0).getPattern().size());
            assertEquals("Virtus",patternCardArrayList.get(1).getName());
            assertEquals(5,patternCardArrayList.get(1).getDifficulty());
            assertEquals(20, patternCardArrayList.get(1).getPattern().size());
            assertEquals("Aurorae Magnificus",patternCardArrayList.get(2).getName());
            assertEquals(5,patternCardArrayList.get(2).getDifficulty());
            assertEquals(20, patternCardArrayList.get(2).getPattern().size());
            assertEquals("Via Lux",patternCardArrayList.get(3).getName());
            assertEquals(4,patternCardArrayList.get(3).getDifficulty());
            assertEquals(20, patternCardArrayList.get(3).getPattern().size());
            assertEquals("Sun Catcher",patternCardArrayList.get(4).getName());
            assertEquals(3,patternCardArrayList.get(4).getDifficulty());
            assertEquals(20, patternCardArrayList.get(4).getPattern().size());
            assertEquals("Bellesguard",patternCardArrayList.get(5).getName());
            assertEquals(3,patternCardArrayList.get(5).getDifficulty());
            assertEquals(20, patternCardArrayList.get(5).getPattern().size());
            assertEquals("Gravitas",patternCardArrayList.get(6).getName());
            assertEquals(5,patternCardArrayList.get(6).getDifficulty());
            assertEquals(20, patternCardArrayList.get(6).getPattern().size());
            assertEquals("Fractal Drops",patternCardArrayList.get(7).getName());
            assertEquals(3,patternCardArrayList.get(7).getDifficulty());
            assertEquals(20, patternCardArrayList.get(7).getPattern().size());
            assertEquals("Lux Astram",patternCardArrayList.get(8).getName());
            assertEquals(5,patternCardArrayList.get(8).getDifficulty());
            assertEquals(20, patternCardArrayList.get(8).getPattern().size());
            assertEquals("Chromatic Splender",patternCardArrayList.get(9).getName());
            assertEquals(4,patternCardArrayList.get(9).getDifficulty());
            assertEquals(20, patternCardArrayList.get(9).getPattern().size());
            assertEquals("Firelight",patternCardArrayList.get(10).getName());
            assertEquals(5,patternCardArrayList.get(10).getDifficulty());
            assertEquals(20, patternCardArrayList.get(10).getPattern().size());
            assertEquals("Luz Celestial",patternCardArrayList.get(11).getName());
            assertEquals(3,patternCardArrayList.get(11).getDifficulty());
            assertEquals(20, patternCardArrayList.get(11).getPattern().size());
            assertEquals("Firmitas",patternCardArrayList.get(12).getName());
            assertEquals(5,patternCardArrayList.get(12).getDifficulty());
            assertEquals(20, patternCardArrayList.get(12).getPattern().size());
            assertEquals("Symphony of Light",patternCardArrayList.get(13).getName());
            assertEquals(6,patternCardArrayList.get(13).getDifficulty());
            assertEquals(20, patternCardArrayList.get(13).getPattern().size());
            assertEquals("Aurora Sagradis",patternCardArrayList.get(14).getName());
            assertEquals(4,patternCardArrayList.get(14).getDifficulty());
            assertEquals(20, patternCardArrayList.get(14).getPattern().size());
            assertEquals("Industria",patternCardArrayList.get(15).getName());
            assertEquals(5,patternCardArrayList.get(15).getDifficulty());
            assertEquals(20, patternCardArrayList.get(15).getPattern().size());
            assertEquals("Shadow Thief",patternCardArrayList.get(16).getName());
            assertEquals(5,patternCardArrayList.get(16).getDifficulty());
            assertEquals(20, patternCardArrayList.get(16).getPattern().size());
            assertEquals("Batllo",patternCardArrayList.get(17).getName());
            assertEquals(5,patternCardArrayList.get(17).getDifficulty());
            assertEquals(20, patternCardArrayList.get(17).getPattern().size());
            assertEquals("Water of Life",patternCardArrayList.get(18).getName());
            assertEquals(6,patternCardArrayList.get(18).getDifficulty());
            assertEquals(20, patternCardArrayList.get(18).getPattern().size());
            assertEquals("Ripples of Light",patternCardArrayList.get(19).getName());
            assertEquals(5,patternCardArrayList.get(19).getDifficulty());
            assertEquals(20, patternCardArrayList.get(19).getPattern().size());
            assertEquals("Lux Mundi",patternCardArrayList.get(20).getName());
            assertEquals(6,patternCardArrayList.get(20).getDifficulty());
            assertEquals(20, patternCardArrayList.get(20).getPattern().size());
            assertEquals("Comitas",patternCardArrayList.get(21).getName());
            assertEquals(5,patternCardArrayList.get(21).getDifficulty());
            assertEquals(20, patternCardArrayList.get(21).getPattern().size());
            assertEquals("Suns Glory",patternCardArrayList.get(22).getName());
            assertEquals(6,patternCardArrayList.get(22).getDifficulty());
            assertEquals(20, patternCardArrayList.get(22).getPattern().size());
            assertEquals("Fulgor del Cielo",patternCardArrayList.get(23).getName());
            assertEquals(5,patternCardArrayList.get(23).getDifficulty());
            assertEquals(20, patternCardArrayList.get(23).getPattern().size());
        }
        catch (FileNotFoundException e){
            fail();
        }
    }

    @Test(expected = InvalidMoveException.class)
    public void testPutDice() throws InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(3, DiceColor.RED);
        try {
            ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
            patternCardArrayList.get(0).putDice(dice, 2);
            patternCardArrayList.get(0).putDice(dice1, 0);

        } catch (FileNotFoundException e) {
            fail();
        }
    }

    @Test
    public void testGetDice() {
        PatternCard patternCard = new PatternCard();
        Dice dice = new Dice(3, DiceColor.YELLOW);
        //Dice dice1 = new Dice(3, DiceColor.RED);
        try {
            ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
            try {
                patternCardArrayList.get(0).putDice(dice, 2);
                Dice dice1 = patternCardArrayList.get(0).getDice(2);
            }
            catch (InvalidMoveException e){
                fail();
            }
        } catch (FileNotFoundException e) {
            fail();
        }
    }

    @Test
    public void testRemoveDice() {
        PatternCard patternCard = new PatternCard();
        Dice dice = new Dice(3, DiceColor.YELLOW);
        //Dice dice1 = new Dice(3, DiceColor.RED);
        try {
            ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
            try {
                patternCardArrayList.get(0).putDice(dice, 2);
                patternCardArrayList.get(0).removeDice(dice,2);
                }
            catch (InvalidMoveException e){
                fail();
            }
        } catch (FileNotFoundException e) {
            fail();
        }
    }

    @Test
    public void testPutDiceOnPattern() throws InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard2 = new PatternCard();
        PatternCard patternCard3 = new PatternCard();

        try {
            Dice diceYellow1 = new Dice(1, DiceColor.YELLOW);
            Dice diceYellow2 = new Dice(2, DiceColor.YELLOW);
            Dice diceYellow3 = new Dice(3, DiceColor.YELLOW);
            Dice diceYellow4 = new Dice(4, DiceColor.YELLOW);
            Dice diceYellow5 = new Dice(5, DiceColor.YELLOW);
            Dice diceYellow6 = new Dice(6, DiceColor.YELLOW);
            Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
            Dice diceBlue2 = new Dice(2, DiceColor.BLUE);
            Dice diceBlue3 = new Dice(3, DiceColor.BLUE);
            Dice diceBlue4 = new Dice(4, DiceColor.BLUE);
            Dice diceBlue5 = new Dice(5, DiceColor.BLUE);
            Dice diceBlue6 = new Dice(6, DiceColor.BLUE);
            Dice diceRed1 = new Dice(1, DiceColor.RED);
            Dice diceRed2 = new Dice(2, DiceColor.RED);
            Dice diceRed3 = new Dice(3, DiceColor.RED);
            Dice diceRed4 = new Dice(4, DiceColor.RED);
            Dice diceRed5 = new Dice(5, DiceColor.RED);
            Dice diceRed6 = new Dice(6, DiceColor.RED);
            Dice dicePurple1 = new Dice(1,DiceColor.PURPLE);
            Dice dicePurple2 = new Dice(2,DiceColor.PURPLE);
            Dice dicePurple3 = new Dice(3,DiceColor.PURPLE);
            Dice dicePurple4 = new Dice(4,DiceColor.PURPLE);
            Dice dicePurple5 = new Dice(5,DiceColor.PURPLE);
            Dice dicePurple6 = new Dice(6,DiceColor.PURPLE);
            Dice diceGreen1 = new Dice(1, DiceColor.GREEN);
            Dice diceGreen2 = new Dice(2, DiceColor.GREEN);
            Dice diceGreen3 = new Dice(3, DiceColor.GREEN);
            Dice diceGreen4 = new Dice(4, DiceColor.GREEN);
            Dice diceGreen5 = new Dice(5, DiceColor.GREEN);
            Dice diceGreen6 = new Dice(6, DiceColor.GREEN);


            ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
            patternCard = patternCardArrayList.get(1);

            patternCard.putDiceOnPattern(diceBlue4,0,patternCard);
            patternCard.putDiceOnPattern(diceYellow1, 1, patternCard);
            patternCard.putDiceOnPattern(diceBlue2, 2, patternCard);
            patternCard.putDiceOnPattern(diceBlue2, 6, patternCard);
            patternCard.putDiceOnPattern(diceYellow3, 5, patternCard);
            patternCard.putDiceOnPattern(dicePurple6,7, patternCard);
            patternCard.putDiceOnPattern(diceGreen1, 8, patternCard);
            patternCard.putDiceOnPattern(dicePurple2,9,patternCard);
            patternCard.putDiceOnPattern(diceGreen1, 4,patternCard);
            patternCard.putDiceOnPattern(diceYellow5, 3, patternCard);
            patternCard.putDiceOnPattern(dicePurple4, 13, patternCard);
            patternCard.putDiceOnPattern(diceBlue6, 14, patternCard);
            patternCard.putDiceOnPattern(diceGreen5, 19, patternCard);
            patternCard.putDiceOnPattern(dicePurple4, 10, patternCard);
            patternCard.putDiceOnPattern(diceGreen2, 12, patternCard);
            patternCard.putDiceOnPattern(dicePurple1, 17, patternCard);
            patternCard.putDiceOnPattern(diceYellow3, 18, patternCard);
            patternCard.putDiceOnPattern(diceYellow3, 11, patternCard);
            patternCard.putDiceOnPattern(diceRed5, 15, patternCard);
            patternCard.putDiceOnPattern(diceGreen6, 16, patternCard);

            patternCard2 = patternCardArrayList.get(2);

            patternCard2.putDiceOnPattern(diceBlue2,2, patternCard2);
            patternCard2.putDiceOnPattern(diceGreen3,7, patternCard2);
            //patternCard2.putDiceOnPattern(diceGreen6,12, patternCard2);
            //patternCard2.putDiceOnPattern(diceRed3, 12, patternCard2);
            patternCard2.putDiceOnPattern(diceBlue6, 12, patternCard2);
            patternCard2.putDiceOnPattern(diceGreen2, 18, patternCard2);
            patternCard2.putDiceOnPattern(diceRed4,19,patternCard2);
            patternCard2.putDiceOnPattern(dicePurple1, 14, patternCard2);
            patternCard2.putDiceOnPattern(diceRed3,13, patternCard2);
            patternCard2.putDiceOnPattern(diceYellow5,17, patternCard2);
            patternCard2.putDiceOnPattern(diceGreen1,11, patternCard2);
            patternCard2.putDiceOnPattern(diceBlue1,15, patternCard2);
            patternCard2.putDiceOnPattern(diceYellow3, 10, patternCard2);
            patternCard2.putDiceOnPattern(dicePurple2, 5, patternCard2);
            patternCard2.putDiceOnPattern(diceBlue5, 6, patternCard2);
            patternCard2.putDiceOnPattern(dicePurple3, 16, patternCard2);
            patternCard2.putDiceOnPattern(diceYellow6, 9, patternCard2);
            patternCard2.putDiceOnPattern(diceGreen2, 4,patternCard2);
            patternCard2.putDiceOnPattern(dicePurple4, 3, patternCard2);
            patternCard2.putDiceOnPattern(diceBlue5, 8, patternCard2);
            patternCard2.putDiceOnPattern(diceRed5, 0, patternCard2);
            patternCard2.putDiceOnPattern(diceGreen4, 1 , patternCard2);

            patternCard3 = patternCardArrayList.get(19);

            patternCard3.putDiceOnPattern(diceBlue2, 10, patternCard3);
            patternCard3.putDiceOnPattern(diceGreen1, 6, patternCard3);
            patternCard3.putDiceOnPattern(diceRed2, 0, patternCard3);




        } catch (FileNotFoundException e) {
            fail();
        }
    }


    @Test (expected = InvalidMoveException.class)
    public void testPutDiceOnPatternException() throws InvalidMoveException {

        PatternCard patternCard = new PatternCard();
        PatternCard patternCard2 = new PatternCard();
        PatternCard patternCard3 = new PatternCard();
        PatternCard patternCard4 = new PatternCard();
        PatternCard patternCard5 = new PatternCard();

        try {
            Dice diceYellow1 = new Dice(1, DiceColor.YELLOW);
            Dice diceYellow2 = new Dice(2, DiceColor.YELLOW);
            Dice diceYellow3 = new Dice(3, DiceColor.YELLOW);
            Dice diceYellow4 = new Dice(4, DiceColor.YELLOW);
            Dice diceYellow5 = new Dice(5, DiceColor.YELLOW);
            Dice diceYellow6 = new Dice(6, DiceColor.YELLOW);
            Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
            Dice diceBlue2 = new Dice(2, DiceColor.BLUE);
            Dice diceBlue3 = new Dice(3, DiceColor.BLUE);
            Dice diceBlue4 = new Dice(4, DiceColor.BLUE);
            Dice diceBlue5 = new Dice(5, DiceColor.BLUE);
            Dice diceBlue6 = new Dice(6, DiceColor.BLUE);
            Dice diceRed1 = new Dice(1, DiceColor.RED);
            Dice diceRed2 = new Dice(2, DiceColor.RED);
            Dice diceRed3 = new Dice(3, DiceColor.RED);
            Dice diceRed4 = new Dice(4, DiceColor.RED);
            Dice diceRed5 = new Dice(5, DiceColor.RED);
            Dice diceRed6 = new Dice(6, DiceColor.RED);
            Dice dicePurple1 = new Dice(1,DiceColor.PURPLE);
            Dice dicePurple2 = new Dice(2,DiceColor.PURPLE);
            Dice dicePurple3 = new Dice(3,DiceColor.PURPLE);
            Dice dicePurple4 = new Dice(4,DiceColor.PURPLE);
            Dice dicePurple5 = new Dice(5,DiceColor.PURPLE);
            Dice dicePurple6 = new Dice(6,DiceColor.PURPLE);
            Dice diceGreen1 = new Dice(1, DiceColor.GREEN);
            Dice diceGreen2 = new Dice(2, DiceColor.GREEN);
            Dice diceGreen3 = new Dice(3, DiceColor.GREEN);
            Dice diceGreen4 = new Dice(4, DiceColor.GREEN);
            Dice diceGreen5 = new Dice(5, DiceColor.GREEN);
            Dice diceGreen6 = new Dice(6, DiceColor.GREEN);


            ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
            patternCard = patternCardArrayList.get(1);

            patternCard.putDiceOnPattern(diceBlue3, 15, patternCard);
            patternCard.putDiceOnPattern(diceBlue1, 4, patternCard);
            patternCard.putDiceOnPattern(diceYellow5,3,patternCard);
            patternCard.putDiceOnPattern(diceGreen4, 0, patternCard);
            patternCard.putDiceOnPattern(diceBlue2, 2, patternCard);
            patternCard.putDiceOnPattern(dicePurple6, 7, patternCard);
            patternCard.putDiceOnPattern(diceBlue2, 6, patternCard);
            patternCard.putDiceOnPattern(diceGreen4, 0, patternCard);
            patternCard.putDiceOnPattern(diceBlue4, 5, patternCard);
            patternCard.putDiceOnPattern(dicePurple4, 10, patternCard);


            patternCard2 = patternCardArrayList.get(2);

            patternCard2.putDiceOnPattern(diceBlue2,2, patternCard2);
            patternCard2.putDiceOnPattern(diceGreen3,7, patternCard2);
            patternCard2.putDiceOnPattern(diceBlue6, 12, patternCard2);
            patternCard2.putDiceOnPattern(diceRed2, 18, patternCard2);
            patternCard2.putDiceOnPattern(diceRed4,19,patternCard2);
            patternCard2.putDiceOnPattern(dicePurple1, 14, patternCard2);
            patternCard2.putDiceOnPattern(diceRed3,13, patternCard2);
            patternCard2.putDiceOnPattern(dicePurple5,17, patternCard2);
            patternCard2.putDiceOnPattern(diceGreen1,11, patternCard2);
            patternCard2.putDiceOnPattern(diceBlue1,15, patternCard2);
            patternCard2.putDiceOnPattern(diceYellow1, 10, patternCard2);
            patternCard2.putDiceOnPattern(dicePurple5, 5, patternCard2);
            patternCard2.putDiceOnPattern(diceBlue5, 6, patternCard2);
            patternCard2.putDiceOnPattern(dicePurple3, 16, patternCard2);
            patternCard2.putDiceOnPattern(diceYellow4, 9, patternCard2);
            patternCard2.putDiceOnPattern(diceGreen2, 4,patternCard2);
            patternCard2.putDiceOnPattern(dicePurple4, 3, patternCard2);
            patternCard2.putDiceOnPattern(diceBlue5, 8, patternCard2);
            patternCard2.putDiceOnPattern(diceRed5, 0, patternCard2);
            patternCard2.putDiceOnPattern(diceGreen5, 1 , patternCard2);

            patternCard3 = patternCardArrayList.get(3);

            patternCard3.putDiceOnPattern(diceBlue1, 8, patternCard3);
            patternCard3.putDiceOnPattern(diceBlue1, 0, patternCard3);
            patternCard3.putDiceOnPattern(diceGreen4, 5, patternCard3);
            patternCard3.putDiceOnPattern(diceBlue3, 10, patternCard3);
            patternCard3.putDiceOnPattern(diceGreen3, 11, patternCard3);
            patternCard3.putDiceOnPattern(diceRed3, 11, patternCard3);
            patternCard3.putDiceOnPattern(diceBlue4, 12, patternCard3);
            patternCard3.putDiceOnPattern(diceBlue6,4, patternCard3);
            patternCard3.putDiceOnPattern(diceBlue3, 8, patternCard3);
            patternCard3.putDiceOnPattern(diceGreen3,14, patternCard3);

            patternCard4 = patternCardArrayList.get(19);

            patternCard4.putDiceOnPattern(diceBlue1, 5, patternCard4);
            patternCard4.putDiceOnPattern(diceGreen2, 1, patternCard4);
            patternCard4.putDiceOnPattern(diceGreen1, 0, patternCard4);

            patternCard5 = patternCardArrayList.get(19);

            patternCard5.putDiceOnPattern(diceBlue1, 5, patternCard5); // ok
            patternCard5.putDiceOnPattern(diceGreen2, 2, patternCard5); // no
            patternCard5.putDiceOnPattern(diceGreen1, 3, patternCard5); // no
            patternCard5.putDiceOnPattern(diceRed3, 0, patternCard5);// ok
            patternCard5.putDiceOnPattern(diceGreen5, 1, patternCard5); //ok
            patternCard5.putDiceOnPattern(dicePurple5, 7, patternCard5); //ok
            patternCard5.putDiceOnPattern(diceRed4, 3, patternCard5); //ok
            patternCard5.putDiceOnPattern(diceRed2, 2, patternCard5); // no





        } catch (FileNotFoundException e) {
            fail();
        }




    }

    @Test
    public void testToString() throws IOException, InvalidMoveException {

        System.setProperty("jansi.passthrough", "true");


        PatternCard patternCard = new PatternCard();
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard = patternCardArrayList.get(7);

        Dice dice = new Dice(4, DiceColor.RED);
        Dice dice2 = new Dice(5, DiceColor.YELLOW);
        patternCard.putDiceOnPattern(dice, 1, patternCard);
        patternCard.putDiceOnPattern(dice2, 2, patternCard);

        System.out.println(patternCard.toString());




    }







    }
