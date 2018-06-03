package it.polimi.se2018.exceptions;

public class InvalidMoveException extends Exception {


    public InvalidMoveException(String error) {
        super(error);
        System.out.println(error.toString());
    }


}
