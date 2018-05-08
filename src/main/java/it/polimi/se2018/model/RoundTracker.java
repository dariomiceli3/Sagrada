package it.polimi.se2018.model;



import java.util.ArrayList;
//singleton, uno che tiene conto di tutti i dadi avanzati in ogni round dalla draftpool
// e li assegna ad un array list per ogni round
public class RoundTracker {

    private final int IN = 0;
    private final int ROUND = 10;
    private ArrayList<Dice> listDice[];
    private Dice dice;

    public RoundTracker(){
        this.listDice = null;
        this.dice = null;
    }

    public RoundTracker(ArrayList<Dice> listDice){
        this.listDice = new ArrayList[ROUND];
        this.listDice[IN] = listDice;
    }

    //aggiunge un set di dadi nella posizione round
    public void setTracker(int round, ArrayList<Dice> listDice){
        this.listDice[round] = listDice;
    }

    //rimuove il dado in posizione pos del roundracker del round round
    public Dice getDice(int round, int pos){

        return listDice[round].remove(pos);

    }
    //aggiunge un dado nel roundtracker del round indicato
    public void addDice(Dice dice, int round){

        listDice[round].add(dice);
    }

    //restituisce una copia della lista di dadi del round indicato se gia giocato----------------
    //eccezioni e controlli ancora da gestire
    public ArrayList<Dice> getRoundDice(int round){
        return listDice[round];
    }





}





