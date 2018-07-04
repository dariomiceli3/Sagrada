package it.polimi.se2018.TestCards;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestPatternCard {

    @Test
    public void testLoadPatternList() {
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1 = new PatternCard(patternCard);
        //try {
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
            assertEquals("Chromatic Splendor",patternCardArrayList.get(9).getName());
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
            assertEquals("Symphony Of Light",patternCardArrayList.get(13).getName());
            assertEquals(6,patternCardArrayList.get(13).getDifficulty());
            assertEquals(20, patternCardArrayList.get(13).getPattern().size());
            assertEquals("Aurorae Sagradis",patternCardArrayList.get(14).getName());
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
            assertEquals("Water Of Life",patternCardArrayList.get(18).getName());
            assertEquals(6,patternCardArrayList.get(18).getDifficulty());
            assertEquals(20, patternCardArrayList.get(18).getPattern().size());
            assertEquals("Ripples Of Light",patternCardArrayList.get(19).getName());
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
            assertEquals("Fulgor Del Cielo",patternCardArrayList.get(23).getName());
            assertEquals(5,patternCardArrayList.get(23).getDifficulty());
            assertEquals(20, patternCardArrayList.get(23).getPattern().size());
        /*}
        catch (FileNotFoundException e){
            fail();
        }*/
    }

    @Test(expected = InvalidMoveException.class)
    public void testPutDice() throws InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(3, DiceColor.RED);
        //try {
            ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
            patternCardArrayList.get(0).putDice(dice, 2);
            patternCardArrayList.get(0).putDice(dice1, 0);

        /*} catch (FileNotFoundException e) {
            fail();
        }*/
    }

    @Test
    public void testGetDice() {
        PatternCard patternCard = new PatternCard();
        Dice dice = new Dice(3, DiceColor.YELLOW);
        //Dice dice1 = new Dice(3, DiceColor.RED);
        //try {
            ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
            try {
                patternCardArrayList.get(0).putDice(dice, 2);
                Dice dice1 = patternCardArrayList.get(0).getDice(2);
            }
            catch (InvalidMoveException e){
                fail();
            }
        /*} catch (FileNotFoundException e) {
            fail();
        }*/
    }

    @Test
    public void testRemoveDice() {
        PatternCard patternCard = new PatternCard();
        Dice dice = new Dice(3, DiceColor.YELLOW);
        //Dice dice1 = new Dice(3, DiceColor.RED);
        //try {
            ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
            try {
                patternCardArrayList.get(0).putDice(dice, 2);
                patternCardArrayList.get(0).removeDice(2);
                }
            catch (InvalidMoveException e){
                fail();
            }
        /*} catch (FileNotFoundException e) {
            fail();
        }*/
    }

    @Test
    public void testPutAnyDice() throws FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6= patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putAnyDice(diceBlue1, 0);
        assertEquals(diceBlue1, patternCard6.getDice(0));
    }

    @Test
    public void testPutDiceOnPattern() throws InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard2 = new PatternCard();
        PatternCard patternCard3 = new PatternCard();

        //try {
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

            PatternCard patternCard4 = patternCard.loadPatternForTesting();
            //patternCard4.putDiceOnPattern(diceBlue1, 5, patternCard4);
            //patternCard4.putDiceOnPattern(diceBlue2, 1, patternCard4);
            patternCard4.putDiceOnPattern(diceBlue2, 14, patternCard4);
            patternCard4.putDiceOnPattern(diceBlue2, 8, patternCard4);
            patternCard4.putDiceOnPattern(diceBlue2, 4, patternCard4);





        /*} catch (FileNotFoundException e) {
            fail();
        }*/
    }

    @Test
    public void testPutDiceOnPattern2() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard4 = new PatternCard();
        patternCard4 = patternCard4.loadPatternForTesting();
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        patternCard4.putDiceOnPattern(diceBlue2, 19, patternCard4);
        patternCard4.putDiceOnPattern(diceBlue2, 13, patternCard4);
        patternCard4.putDiceOnPattern(diceBlue2, 9, patternCard4);
    }


    @Test (expected = InvalidMoveException.class)
    public void testPutDiceOnPatternException() throws InvalidMoveException {

        PatternCard patternCard = new PatternCard();
        PatternCard patternCard2 = new PatternCard();
        PatternCard patternCard3 = new PatternCard();
        PatternCard patternCard4 = new PatternCard();
        PatternCard patternCard5 = new PatternCard();

        //try {
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

            PatternCard patternCard6 = patternCard.loadPatternForTesting();
            patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
            patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);



        /*} catch (FileNotFoundException e) {
            fail();
        }*/
    }

    @Test (expected = InvalidMoveException.class)
    public void examples() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void examples1() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,19,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 1, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 2, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 3, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex1() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 19, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 1, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex4() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1, 19, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 4, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex5() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1, 19, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 5, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex6() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1, 19, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 6, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex9() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 9, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex15() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 15, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex16() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 16, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex19() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 19, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex0Constraint() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 1, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex1Constraint() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 0, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 1, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex4Constraint() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 3, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 4, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex5Constraint() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 0, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 5, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex6Constraint() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 1, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 6, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex9Constraint() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 4, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 9, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex15Constraint() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 10, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 15, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex16Constraint() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 15, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 16, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex19Constraint() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 18, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 19, patternCard6);
    }

    @Test
    public void testIndex1() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1, 5, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 1, patternCard6);
    }

    @Test
    public void testIndex5() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1, 1, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 5, patternCard6);
    }

    @Test
    public void testIndex19() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1, 17, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 13, patternCard6);
        patternCard6.putDiceOnPattern(diceBlue2, 19, patternCard6);
    }


    @Test
    public void testPutDiceOnPatternEglomise() throws InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard2 = new PatternCard();
        PatternCard patternCard3 = new PatternCard();

        //try {
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

            patternCard.putDiceOnPatternEglomise(diceBlue4,0,patternCard);
            patternCard.putDiceOnPatternEglomise(diceYellow1, 1, patternCard);
            patternCard.putDiceOnPatternEglomise(diceBlue2, 2, patternCard);
            patternCard.putDiceOnPatternEglomise(diceBlue2, 6, patternCard);
            patternCard.putDiceOnPatternEglomise(diceYellow3, 5, patternCard);
            patternCard.putDiceOnPatternEglomise(dicePurple6,7, patternCard);
            patternCard.putDiceOnPatternEglomise(diceGreen1, 8, patternCard);
            patternCard.putDiceOnPatternEglomise(dicePurple2,9,patternCard);
            patternCard.putDiceOnPatternEglomise(diceGreen1, 4,patternCard);
            patternCard.putDiceOnPatternEglomise(diceYellow5, 3, patternCard);
            patternCard.putDiceOnPatternEglomise(dicePurple4, 13, patternCard);
            patternCard.putDiceOnPatternEglomise(diceBlue6, 14, patternCard);
            patternCard.putDiceOnPatternEglomise(diceGreen5, 19, patternCard);
            patternCard.putDiceOnPatternEglomise(dicePurple4, 10, patternCard);
            patternCard.putDiceOnPatternEglomise(diceGreen2, 12, patternCard);
            patternCard.putDiceOnPatternEglomise(dicePurple1, 17, patternCard);
            patternCard.putDiceOnPatternEglomise(diceYellow3, 18, patternCard);
            patternCard.putDiceOnPatternEglomise(diceYellow3, 11, patternCard);
            patternCard.putDiceOnPatternEglomise(diceRed5, 15, patternCard);
            patternCard.putDiceOnPatternEglomise(diceGreen6, 16, patternCard);

            patternCard2 = patternCardArrayList.get(2);

            patternCard2.putDiceOnPatternEglomise(diceBlue2,2, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceGreen3,7, patternCard2);
            //patternCard2.putDiceOnPattern(diceGreen6,12, patternCard2);
            //patternCard2.putDiceOnPattern(diceRed3, 12, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceBlue6, 12, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceGreen2, 18, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceRed4,19,patternCard2);
            patternCard2.putDiceOnPatternEglomise(dicePurple1, 14, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceRed3,13, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceYellow5,17, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceGreen1,11, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceBlue1,15, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceYellow3, 10, patternCard2);
            patternCard2.putDiceOnPatternEglomise(dicePurple2, 5, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceBlue5, 6, patternCard2);
            patternCard2.putDiceOnPatternEglomise(dicePurple3, 16, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceYellow6, 9, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceGreen2, 4,patternCard2);
            patternCard2.putDiceOnPatternEglomise(dicePurple4, 3, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceBlue5, 8, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceRed5, 0, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceGreen4, 1 , patternCard2);

            patternCard3 = patternCardArrayList.get(19);

            patternCard3.putDiceOnPatternEglomise(diceBlue2, 10, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceGreen1, 6, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceRed2, 0, patternCard3);
            patternCard3.putDiceEglomise(diceRed5, 7);
            System.out.println(patternCard3.toString());





        /*} catch (FileNotFoundException e) {
            fail();
        }*/
    }
    @Test (expected = InvalidMoveException.class)
    public void testPutDiceOnPatternEglomiseException() throws InvalidMoveException {

        PatternCard patternCard = new PatternCard();
        PatternCard patternCard2 = new PatternCard();
        PatternCard patternCard3 = new PatternCard();
        PatternCard patternCard4 = new PatternCard();
        PatternCard patternCard5 = new PatternCard();
        PatternCard patternCard33 = new PatternCard();

        //try {
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

            patternCard33 = patternCardArrayList.get(19);
            patternCard33.putDiceOnPatternEglomise(diceBlue2, 10, patternCard33);
            patternCard33.putDiceOnPatternEglomise(diceGreen1, 6, patternCard33);
            patternCard33.putDiceOnPatternEglomise(diceRed2, 0, patternCard33);
            patternCard33.putDiceOnPatternEglomise(diceRed5, 7,patternCard33);

            patternCard = patternCardArrayList.get(1);

            patternCard.putDiceOnPatternEglomise(diceBlue3, 15, patternCard);
            patternCard.putDiceOnPatternEglomise(diceBlue1, 4, patternCard);
            patternCard.putDiceOnPatternEglomise(diceYellow5,3,patternCard);
            patternCard.putDiceOnPatternEglomise(diceGreen4, 0, patternCard);
            patternCard.putDiceOnPatternEglomise(diceBlue2, 2, patternCard);
            patternCard.putDiceOnPatternEglomise(dicePurple6, 7, patternCard);
            patternCard.putDiceOnPatternEglomise(diceBlue2, 6, patternCard);
            patternCard.putDiceOnPatternEglomise(diceGreen4, 0, patternCard);
            patternCard.putDiceOnPatternEglomise(diceBlue4, 5, patternCard);
            patternCard.putDiceOnPatternEglomise(dicePurple4, 10, patternCard);


            patternCard2 = patternCardArrayList.get(2);

            patternCard2.putDiceOnPatternEglomise(diceBlue2,2, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceGreen3,7, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceBlue6, 12, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceRed2, 18, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceRed4,19,patternCard2);
            patternCard2.putDiceOnPatternEglomise(dicePurple1, 14, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceRed3,13, patternCard2);
            patternCard2.putDiceOnPatternEglomise(dicePurple5,17, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceGreen1,11, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceBlue1,15, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceYellow1, 10, patternCard2);
            patternCard2.putDiceOnPatternEglomise(dicePurple5, 5, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceBlue5, 6, patternCard2);
            patternCard2.putDiceOnPatternEglomise(dicePurple3, 16, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceYellow4, 9, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceGreen2, 4,patternCard2);
            patternCard2.putDiceOnPatternEglomise(dicePurple4, 3, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceBlue5, 8, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceRed5, 0, patternCard2);
            patternCard2.putDiceOnPatternEglomise(diceGreen5, 1 , patternCard2);

            patternCard3 = patternCardArrayList.get(3);

            patternCard3.putDiceOnPatternEglomise(diceBlue1, 8, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceBlue1, 0, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceGreen4, 5, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceBlue3, 10, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceGreen3, 11, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceRed3, 11, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceBlue4, 12, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceBlue6,4, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceBlue3, 8, patternCard3);
            patternCard3.putDiceOnPatternEglomise(diceGreen3,14, patternCard3);

            patternCard4 = patternCardArrayList.get(19);

            patternCard4.putDiceOnPatternEglomise(diceBlue1, 5, patternCard4);
            patternCard4.putDiceOnPatternEglomise(diceGreen2, 1, patternCard4);
            patternCard4.putDiceOnPatternEglomise(diceGreen1, 0, patternCard4);

            patternCard5 = patternCardArrayList.get(19);

            patternCard5.putDiceOnPatternEglomise(diceBlue1, 5, patternCard5); // ok
            patternCard5.putDiceOnPatternEglomise(diceGreen2, 2, patternCard5); // no
            patternCard5.putDiceOnPatternEglomise(diceGreen1, 3, patternCard5); // no
            patternCard5.putDiceOnPatternEglomise(diceRed3, 0, patternCard5);// ok
            patternCard5.putDiceOnPatternEglomise(diceGreen5, 1, patternCard5); //ok
            patternCard5.putDiceOnPatternEglomise(dicePurple5, 7, patternCard5); //ok
            patternCard5.putDiceOnPatternEglomise(diceRed4, 3, patternCard5); //ok
            patternCard5.putDiceOnPatternEglomise(diceRed2, 2, patternCard5); // no






        /*} catch (FileNotFoundException e) {
            fail();
        }*/
    }

    @Test (expected = InvalidMoveException.class)
    public void examplesEglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 0, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void examples1Eglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,19,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 1, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 2, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 3, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex1Eglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 19, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 1, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex4Eglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 19, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 4, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex5Eglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 19, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 5, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex6Eglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 19, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 6, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex9Eglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 9, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex15Eglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 15, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex16Eglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 16, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex19Eglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 19, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex0ConstraintEglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 1, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 0, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex1ConstraintEglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 0, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 1, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex4ConstraintEglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 3, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 4, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex5ConstraintEglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 0, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 5, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex6ConstraintEglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 1, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 6, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex9ConstraintEglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 4, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 9, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex15ConstraintEglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 10, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 15, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex16ConstraintEglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 15, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 16, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex19ConstraintEglomise() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 18, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 19, patternCard6);
    }

    @Test
    public void testIndex1Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 5, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 1, patternCard6);
    }

    @Test
    public void testIndex4Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 2, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 8, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 4, patternCard6);
    }

    @Test
    public void testIndex5Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 1, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 5, patternCard6);
    }

    @Test
    public void testIndex9Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1 = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 3, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 9, patternCard6);

        /*PatternCard patternCard7 = patternCard1.loadPatternForTesting();
        patternCard7.putDiceOnPatternEglomise(diceBlue1, 19, patternCard6);
        patternCard7.putDiceOnPatternEglomise(diceBlue2, 13, patternCard6);
        patternCard7.putDiceOnPatternEglomise(diceBlue2, 9, patternCard6);*/

    }

    @Test
    public void testIndex19Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1, 17, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 13, patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue2, 19, patternCard6);
    }

    @Test
    public void testPutDiceOnPatternCopper() throws InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard2 = new PatternCard();
        PatternCard patternCard3 = new PatternCard();

        //try {
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

            patternCard.putDiceOnPatternCopper(diceBlue4,0,patternCard);
            patternCard.putDiceOnPatternCopper(diceYellow1, 1, patternCard);
            patternCard.putDiceOnPatternCopper(diceBlue2, 2, patternCard);
            patternCard.putDiceOnPatternCopper(diceBlue2, 6, patternCard);
            patternCard.putDiceOnPatternCopper(diceYellow3, 5, patternCard);
            patternCard.putDiceOnPatternCopper(dicePurple6,7, patternCard);
            patternCard.putDiceOnPatternCopper(diceGreen1, 8, patternCard);
            patternCard.putDiceOnPatternCopper(dicePurple2,9,patternCard);
            patternCard.putDiceOnPatternCopper(diceGreen1, 4,patternCard);
            patternCard.putDiceOnPatternCopper(diceYellow5, 3, patternCard);
            patternCard.putDiceOnPatternCopper(dicePurple4, 13, patternCard);
            patternCard.putDiceOnPatternCopper(diceBlue6, 14, patternCard);
            patternCard.putDiceOnPatternCopper(diceGreen5, 19, patternCard);
            patternCard.putDiceOnPatternCopper(dicePurple4, 10, patternCard);
            patternCard.putDiceOnPatternCopper(diceGreen2, 12, patternCard);
            patternCard.putDiceOnPatternCopper(dicePurple1, 17, patternCard);
            patternCard.putDiceOnPatternCopper(diceYellow3, 18, patternCard);
            patternCard.putDiceOnPatternCopper(diceYellow3, 11, patternCard);
            patternCard.putDiceOnPatternCopper(diceRed5, 15, patternCard);
            patternCard.putDiceOnPatternCopper(diceGreen6, 16, patternCard);

            patternCard2 = patternCardArrayList.get(2);

            patternCard2.putDiceOnPatternCopper(diceBlue2,2, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceGreen3,7, patternCard2);
            //patternCard2.putDiceOnPattern(diceGreen6,12, patternCard2);
            //patternCard2.putDiceOnPattern(diceRed3, 12, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceBlue6, 12, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceGreen2, 18, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceRed4,19,patternCard2);
            patternCard2.putDiceOnPatternCopper(dicePurple1, 14, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceRed3,13, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceYellow5,17, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceGreen1,11, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceBlue1,15, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceYellow3, 10, patternCard2);
            patternCard2.putDiceOnPatternCopper(dicePurple2, 5, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceBlue5, 6, patternCard2);
            patternCard2.putDiceOnPatternCopper(dicePurple3, 16, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceYellow6, 9, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceGreen2, 4,patternCard2);
            patternCard2.putDiceOnPatternCopper(dicePurple4, 3, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceBlue5, 8, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceRed5, 0, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceGreen4, 1 , patternCard2);

            patternCard3 = patternCardArrayList.get(19);

            patternCard3.putDiceOnPatternCopper(diceBlue2, 10, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceGreen1, 6, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceRed2, 0, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceBlue3, 12, patternCard3);
            System.out.println(patternCard3.toString());




        /*} catch (FileNotFoundException e) {
            fail();
        }*/
    }

    @Test (expected = InvalidMoveException.class)
    public void testPutDiceCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6= patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceCopper(diceBlue1, 0);
        patternCard6.putDiceCopper(diceBlue1, 0);

    }

    @Test (expected = InvalidMoveException.class)
    public void testPutDiceOnPatternCopperException() throws InvalidMoveException {

        PatternCard patternCard = new PatternCard();
        PatternCard patternCard2 = new PatternCard();
        PatternCard patternCard3 = new PatternCard();
        PatternCard patternCard4 = new PatternCard();
        PatternCard patternCard5 = new PatternCard();

        //try {
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

            patternCard.putDiceOnPatternCopper(diceBlue3, 15, patternCard);
            patternCard.putDiceOnPatternCopper(diceBlue1, 4, patternCard);
            patternCard.putDiceOnPatternCopper(diceYellow5,3,patternCard);
            patternCard.putDiceOnPatternCopper(diceGreen4, 0, patternCard);
            patternCard.putDiceOnPatternCopper(diceBlue2, 2, patternCard);
            patternCard.putDiceOnPatternCopper(dicePurple6, 7, patternCard);
            patternCard.putDiceOnPatternCopper(diceBlue2, 6, patternCard);
            patternCard.putDiceOnPatternCopper(diceGreen4, 0, patternCard);
            patternCard.putDiceOnPatternCopper(diceBlue4, 5, patternCard);
            patternCard.putDiceOnPatternCopper(dicePurple4, 10, patternCard);


            patternCard2 = patternCardArrayList.get(2);

            patternCard2.putDiceOnPatternCopper(diceBlue2,2, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceGreen3,7, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceBlue6, 12, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceRed2, 18, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceRed4,19,patternCard2);
            patternCard2.putDiceOnPatternCopper(dicePurple1, 14, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceRed3,13, patternCard2);
            patternCard2.putDiceOnPatternCopper(dicePurple5,17, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceGreen1,11, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceBlue1,15, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceYellow1, 10, patternCard2);
            patternCard2.putDiceOnPatternCopper(dicePurple5, 5, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceBlue5, 6, patternCard2);
            patternCard2.putDiceOnPatternCopper(dicePurple3, 16, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceYellow4, 9, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceGreen2, 4,patternCard2);
            patternCard2.putDiceOnPatternCopper(dicePurple4, 3, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceBlue5, 8, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceRed5, 0, patternCard2);
            patternCard2.putDiceOnPatternCopper(diceGreen5, 1 , patternCard2);

            patternCard3 = patternCardArrayList.get(3);

            patternCard3.putDiceOnPatternCopper(diceBlue1, 8, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceBlue1, 0, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceGreen4, 5, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceBlue3, 10, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceGreen3, 11, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceRed3, 11, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceBlue4, 12, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceBlue6,4, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceBlue3, 8, patternCard3);
            patternCard3.putDiceOnPatternCopper(diceGreen3,14, patternCard3);

            patternCard4 = patternCardArrayList.get(19);

            patternCard4.putDiceOnPatternCopper(diceBlue1, 5, patternCard4);
            patternCard4.putDiceOnPatternCopper(diceGreen2, 1, patternCard4);
            patternCard4.putDiceOnPatternCopper(diceGreen1, 0, patternCard4);

            patternCard5 = patternCardArrayList.get(19);

            patternCard5.putDiceOnPatternCopper(diceBlue1, 5, patternCard5); // ok
            patternCard5.putDiceOnPatternCopper(diceGreen2, 2, patternCard5); // no
            patternCard5.putDiceOnPatternCopper(diceGreen1, 3, patternCard5); // no
            patternCard5.putDiceOnPatternCopper(diceRed3, 0, patternCard5);// ok
            patternCard5.putDiceOnPatternCopper(diceGreen5, 1, patternCard5); //ok
            patternCard5.putDiceOnPatternCopper(dicePurple5, 7, patternCard5); //ok
            patternCard5.putDiceOnPatternCopper(diceRed4, 3, patternCard5); //ok
            patternCard5.putDiceOnPatternCopper(diceRed2, 2, patternCard5); // no





        /*} catch (FileNotFoundException e) {
            fail();
        }*/
    }

    @Test (expected = InvalidMoveException.class)
    public void examplesCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 0, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void examples1Copper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,19,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 1, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 2, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 3, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex1Copper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 19, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 1, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex4Copper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 19, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 4, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex5Copper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 19, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 5, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex6Copper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 19, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 6, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex9Copper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 9, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex15Copper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 15, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex16Copper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 16, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex19Copper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 19, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex0ConstraintCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 1, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 0, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex1ConstraintCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 0, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 1, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex4ConstraintCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 3, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 4, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex5ConstraintCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 0, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 5, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex6ConstraintCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6= patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 1, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 6, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex9ConstraintCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 4, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 9, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex15ConstraintCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 10, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 15, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex16ConstraintCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 15, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 16, patternCard6);
    }

    @Test (expected = InvalidMoveException.class)
    public void exceptionIndex19ConstraintCopper() throws InvalidMoveException, FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 18, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 19, patternCard6);
    }
    @Test
    public void testIndex1Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1, 5, patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue2, 0, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 1, patternCard6);
    }

    @Test
    public void testIndex4Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 2, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 8, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 4, patternCard6);
    }

    @Test
    public void testIndex5Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 1, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 5, patternCard6);
    }

    @Test
    public void testIndex9Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1 = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 3, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 9, patternCard6);

        /*PatternCard patternCard7 = patternCard1.loadPatternForTesting();
        patternCard7.putDiceOnPatternEglomise(diceBlue1, 19, patternCard6);
        patternCard7.putDiceOnPatternEglomise(diceBlue2, 13, patternCard6);
        patternCard7.putDiceOnPatternEglomise(diceBlue2, 9, patternCard6);*/

    }

    @Test
    public void testIndex19Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceBlue2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 17, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 13, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue2, 19, patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testCheckNearCostraint() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceRed1 = new Dice(1, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1, 17, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceRed1, 16, patternCard6);
        patternCard6.putDiceOnPatternCopper(diceRed1, 19, patternCard6);
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

    @Test
    public void testvalid() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1,3,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,2,patternCard6);

    }

    @Test
    public void testValid2() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceBlue1,17,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,12,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,2,patternCard6);
    }

    @Test
    public void testvalidEglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1,3,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,2,patternCard6);

    }

    @Test
    public void testValid2Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceBlue1,17,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,12,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,2,patternCard6);
    }

    @Test
    public void testvalidCopper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1,3,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,2,patternCard6);

    }

    @Test
    public void testValid2Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceBlue1,17,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,12,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,2,patternCard6);
    }

    @Test
    public void testvalid3() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPattern(diceBlue1,9,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,8,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,2,patternCard6);
    }

    @Test
    public void testvalid3Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternCopper(diceBlue1,9,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,8,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,2,patternCard6);
    }

    @Test
    public void testvalid3Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.putDiceOnPatternEglomise(diceBlue1,9,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,8,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,2,patternCard6);
    }


    @Test
    public void testValid3() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceBlue1,15,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,11,patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,5,patternCard6);
    }

    @Test
    public void testValidEglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceBlue1,15,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,11,patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,5,patternCard6);
    }

    @Test
    public void testValid3Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceBlue1,15,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,11,patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue1,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,5,patternCard6);
    }

    @Test
    public void testValid6() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceBlue1,2,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,6,patternCard6);
    }

    @Test
    public void testValid60() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceBlue1,0,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,6,patternCard6);
    }

    @Test
    public void testValid6Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceBlue1,2,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,6,patternCard6);
    }

    @Test
    public void testValid60Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceBlue1,0,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,6,patternCard6);
    }

    @Test
    public void testValid6Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceBlue1,2,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,6,patternCard6);
    }

    @Test
    public void testValid60Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceBlue1,0,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,6,patternCard6);
    }

    @Test
    public void testValid9() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceBlue1,3,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,9,patternCard6);
    }



    @Test
    public void testValid9Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceBlue1,3,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,9,patternCard6);
    }



    @Test
    public void testValid9Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceBlue1,3,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,9,patternCard6);
    }

    @Test
    public void testValid16() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceBlue1,16,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,15,patternCard6);
    }

    @Test
    public void testValid16Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceBlue1,16,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,15,patternCard6);
    }

    @Test
    public void testValid16Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceBlue1,16,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,15,patternCard6);
    }

    @Test
    public void testValid15() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceBlue1,17,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,16,patternCard6);
    }

    @Test
    public void testValid1516() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceBlue1,14,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,13,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,12,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,16,patternCard6);
    }

    @Test
    public void testValid15Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceBlue1,17,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,16,patternCard6);
    }

    @Test
    public void testValid1516Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceBlue1,14,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,13,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,12,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,16,patternCard6);
    }
    @Test
    public void testValid15Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceBlue1,17,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,16,patternCard6);
    }

    @Test
    public void testValid1516Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceBlue1,14,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,13,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,12,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,16,patternCard6);
    }

    @Test
    public void testValid612Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceGreen2,17,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,12,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,6,patternCard6);
    }

    @Test
    public void testValid612Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceGreen2,17,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,12,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,6,patternCard6);
    }

    @Test
    public void testValid912Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceGreen2,18,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,13,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,9,patternCard6);
    }

    @Test
    public void testValid912Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.GREEN);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceGreen2,18,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,13,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,9,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceGreen2,5,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,0,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraintEglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceGreen2,5,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,0,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraintCopper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceGreen2,5,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,0,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint1() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceGreen2,2,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,1,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint12() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceRed4,5,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,6,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,1,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint1Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceGreen2,2,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,1,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint12Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceRed4,5,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,6,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,1,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint1Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceGreen2,2,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,1,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint12Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceRed4,5,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,6,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,1,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint4() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceBlue1,9,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,4,patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue1,1,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint4Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceBlue1,9,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,4,patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue1,1,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint4Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceBlue1,9,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,4,patternCard6);
        //patternCard6.putDiceOnPattern(diceBlue1,1,patternCard6);

    }


    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint5() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5, DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceRed4,16,patternCard6);
        patternCard6.putDiceOnPattern(diceYellow5,11,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,6,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,5,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint52() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceRed4,15,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,10,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,5,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint5Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5, DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceRed4,16,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceYellow5,11,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,6,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,5,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint52Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceRed4,15,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,10,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,5,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint5Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5, DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceRed4,16,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceYellow5,11,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,6,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,5,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testCOnstraint52Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceRed4,15,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,10,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,5,patternCard6);

    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint6() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        //patternCard6.putDiceOnPatternCopper(diceRed4,15,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,5,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,6,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint61() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceYellow5,17,patternCard6);
        patternCard6.putDiceOnPattern(diceRed4,12,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,7,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,6,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint612() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        //patternCard6.putDiceOnPattern(diceYellow5,17,patternCard6);
        patternCard6.putDiceOnPattern(diceRed4,16,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,11,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,6,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint61Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceYellow5,17,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceRed4,12,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,7,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,6,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint612Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        //patternCard6.putDiceOnPattern(diceYellow5,17,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceRed4,16,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,11,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,6,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint61Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceYellow5,17,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceRed4,12,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,7,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,6,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint612Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        //patternCard6.putDiceOnPattern(diceYellow5,17,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceRed4,16,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,11,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,6,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint9() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceYellow5,18,patternCard6);
        patternCard6.putDiceOnPattern(diceRed4,13,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,8,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,9,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint914() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        //patternCard6.putDiceOnPattern(diceYellow5,18,patternCard6);
        patternCard6.putDiceOnPattern(diceRed4,19,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,14,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,9,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint9Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceYellow5,18,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceRed4,13,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,8,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,9,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint914Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        //patternCard6.putDiceOnPattern(diceYellow5,18,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceRed4,19,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,14,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,9,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint9Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceYellow5,18,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceRed4,13,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,8,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,9,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint914Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        //patternCard6.putDiceOnPattern(diceYellow5,18,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceRed4,19,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,14,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,9,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint15() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();


        patternCard6.putDiceOnPattern(diceGreen2,16,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,15,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint15Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();


        patternCard6.putDiceOnPatternEglomise(diceGreen2,16,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,15,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint15Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();


        patternCard6.putDiceOnPatternCopper(diceGreen2,16,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,15,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint16() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceYellow5,1,patternCard6);
        patternCard6.putDiceOnPattern(diceRed4,6,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,11,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,16,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint161() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        //patternCard6.putDiceOnPattern(diceYellow5,2,patternCard6);
        //patternCard6.putDiceOnPattern(diceRed4,12,patternCard6);
        patternCard6.putDiceOnPattern(diceGreen2,17,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,16,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint16Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceYellow5,1,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceRed4,6,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,11,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,16,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint161Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        //patternCard6.putDiceOnPattern(diceYellow5,2,patternCard6);
        //patternCard6.putDiceOnPattern(diceRed4,12,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceGreen2,17,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,16,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint16Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceYellow5,1,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceRed4,6,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,11,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,16,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint161Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        //patternCard6.putDiceOnPattern(diceYellow5,2,patternCard6);
        //patternCard6.putDiceOnPattern(diceRed4,12,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceGreen2,17,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,16,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint19() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPattern(diceGreen2,14,patternCard6);
        patternCard6.putDiceOnPattern(diceBlue1,19,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint19Eglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceGreen2,14,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,19,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint19Copper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceGreen2,14,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,19,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint6finalEglomise() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternEglomise(diceGreen2,5,patternCard6);
        patternCard6.putDiceOnPatternEglomise(diceBlue1,6,patternCard6);
    }

    @Test(expected = InvalidMoveException.class)
    public void testConstraint6finalCopper() throws FileNotFoundException, InvalidMoveException {
        PatternCard patternCard = new PatternCard();
        Dice diceBlue1 = new Dice(1, DiceColor.BLUE);
        Dice diceGreen2 = new Dice(2, DiceColor.BLUE);
        Dice diceRed4 = new Dice(4, DiceColor.RED);
        Dice diceYellow5 = new Dice(5,DiceColor.YELLOW);

        PatternCard patternCard6 = patternCard.loadPatternForTesting();

        patternCard6.putDiceOnPatternCopper(diceGreen2,5,patternCard6);
        patternCard6.putDiceOnPatternCopper(diceBlue1,6,patternCard6);
    }

    @Test
    public void test() throws FileNotFoundException {
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard6 = patternCard.loadPatternForTesting();
        patternCard6.isCustom();
    }
}
