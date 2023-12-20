package Exceptions;


/**
 * The type Exceeded credit exception.
 */
public class ExceededCreditException extends Exception {
    /**
     * Instantiates a new Exceeded credit exception.
     */
    public ExceededCreditException(){};

    /**
     * Instantiates a new Exceeded credit exception.
     *
     * @param message the message
     */
    public ExceededCreditException(String message){
        super(message);
    }
}
