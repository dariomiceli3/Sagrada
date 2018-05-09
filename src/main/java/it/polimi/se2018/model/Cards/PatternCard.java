package it.polimi.se2018.model.Cards;

import it.polimi.se2018.model.Components.GlassBox;

import java.util.List;

public class PatternCard {
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


}