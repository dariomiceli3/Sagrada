package it.polimi.se2018.model.Cards;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;


public class main {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/res/json/");

        String stampa = filePath + "Virtus" + ".json";

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(stampa));
        PatternCard patternCardObject = gson.fromJson(reader, PatternCard.class);

        System.out.println("path:");
        System.out.println(stampa);

        System.out.println(patternCardObject.getDifficulty());


    }

}






