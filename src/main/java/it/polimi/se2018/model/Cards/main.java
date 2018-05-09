package it.polimi.se2018.model.Cards;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class main {
    public static void main(String[] args) {


        String patterJson ="{'name': 'Virtus', 'difficulty': 4, 'pattern': [{'constraintValue': 2 ,'constraintColor': 'Blue' },{'constraintValue': 1,'constraintColor':'Green'}]}";

        Gson gson = new Gson();


        PatternCard patternCardObject = gson.fromJson(patterJson, PatternCard.class);

    }
}
