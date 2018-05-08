package it.polimi.se2018.model.Cards;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.polimi.se2018.model.GlassBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class main {
    public static void main(String[] args) {


        String patterJson ="{'name': 'Virtus', 'difficulty': 4, 'pattern': [{'constraintValue': 2 ,'constraintColor': 'Blue' },{'constraintValue': 1,'constraintColor':'Green'}]}";

        Gson gson = new Gson();


        PatternCard patternCardObject = gson.fromJson(patterJson, PatternCard.class);

    }
}
