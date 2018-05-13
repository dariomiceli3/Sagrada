package it.polimi.se2018.model.Cards;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;


public class main {
    public static void main(String[] args)  {

        ArrayList list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            list.add(null);
        }

        list.set(3, 1);
        list.set(6,2);

        System.out.println(list.size());
        System.out.println(list);



    }

}






