package it.polimi.se2018.TestCards;

import it.polimi.se2018.model.Cards.PatternCard;
import org.junit.Test;

import java.io.FileNotFoundException;
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

}