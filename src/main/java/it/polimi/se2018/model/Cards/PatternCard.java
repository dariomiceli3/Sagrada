package it.polimi.se2018.model.Cards;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.model.Components.GlassBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PatternCard {
     private final int NUMBER_OF_CARDS = 24;
     private String name;
     private int difficulty;
     private List<GlassBox> pattern;

     public int getDifficulty(){
          return difficulty;
     }

     public String getName(){
          return name;
     }

     public List<GlassBox> getPattern() {//rivista, passare una copia di pattern card-----------
          return pattern;
     }

     public ArrayList<PatternCard> loadPatternList() throws FileNotFoundException
     {
          ArrayList<PatternCard> patternList = new ArrayList<>();

          File file = new File("./");
          String filePath = file.getAbsolutePath().replace(".", "src/main/res/json/");

          for(int i = 1; i <= NUMBER_OF_CARDS; i++){

               patternList.add(loadCard(filePath + i + ".json"));
          }

          return patternList;
     }

     public PatternCard loadCard(String fileName) throws FileNotFoundException
     {
          Gson gson = new Gson();
          JsonReader reader = new JsonReader(new FileReader(fileName));
          PatternCard patternCardObject = gson.fromJson(reader, PatternCard.class);

          return patternCardObject;
     }


}