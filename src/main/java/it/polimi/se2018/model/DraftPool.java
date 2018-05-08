package it.polimi.se2018.model;

import java.util.ArrayList;
import java.util.Iterator;


public class DraftPool {

    private final int DEFAULT = 0;
    //NUMERO DEI GIOCATORI
    private int number;
    private DiceBag diceBag;
    private ArrayList<Dice> dicePlay;
    private ArrayList<Dice> listDice;


    public DraftPool(){
        this.number = DEFAULT;
        this.dicePlay = null;
        this.diceBag = null;

    }

    public DraftPool(int number, DiceBag dicebag) {
        this.number = number;
        this.diceBag = dicebag;
        this.dicePlay = new ArrayList<>();
        for(int i=0; i <= (2*number); i++) {
            this.dicePlay.add(this.diceBag.getDice());
        }
    }

    //ritorna il numero di dadi nella draftpool
    public int getNowNumber(){
        return dicePlay.size();
    }

    public int getNumber() {
        return number;
    }

    //prende un dado dalla dicebag e lo rimuove
    public Dice getDice() {
        return dicePlay.remove(DEFAULT);
    }

    //passare una copia della lista dei dadi della pool-------------------
    public ArrayList<Dice> getDraftPool() {//clone necessaria
        return dicePlay;
    }

    //aggiunge un dado alla draftpool
    public void setDice(Dice dice){
        dicePlay.add(dice);
    }

    public ArrayList<Dice> getListDice(){
        listDice = new ArrayList<>();
        Iterator<Dice> it = dicePlay.iterator();
        while(it.hasNext()){
            listDice.add(it.next());
            it.remove();

        }
        return listDice;
    }


}