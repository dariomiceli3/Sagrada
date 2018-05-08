package it.polimi.se2018.model.Cards;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.polimi.se2018.model.GlassBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class main {
    public static void main(String[] args) {


        //String patterJson ="{'name': 'Virtus', 'difficulty': 4, 'pattern': [{'constraintValue': 2 ,'constraintColor': 'Blue' },{'constraintValue': 1,'constraintColor':'Green'}]}";
        try {
            BufferedReader reader = new BufferedReader((new FileReader("C:\\Users\\Dario Miceli\\IdeaProjects\\ing-sw-2018-fadda-miceli-mundo\\src\\main\\java\\it\\polimi\\se2018\\json\\Virtus.json")));
            //System.out.println(reader.lines().collect(Collectors.joining()));
            Gson gson = new Gson();
            String string = reader.lines().collect(Collectors.joining());

            PatternCard patternCardObject = gson.fromJson(string, PatternCard.class);

        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }
        }
    }

