package it.polimi.se2018.exceptions;


/**
 * Class InvalidMoveException: custom exception to notify with a particular msg the client of an invalid move
 * @see java.lang.Exception
 * @author fadda-miceli-mundo
 */
public class InvalidMoveException extends Exception {

    public InvalidMoveException(String error) {
        super(error);
    }

}
