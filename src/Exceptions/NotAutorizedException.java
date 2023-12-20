package Exceptions;

/**
 * The type Not autorized exception.
 */
public class NotAutorizedException extends Exception {
    /**
     * Instantiates a new Not autorized exception.
     */
    public NotAutorizedException(){};

    /**
     * Instantiates a new Not autorized exception.
     *
     * @param message the message
     */
    public NotAutorizedException(String message){
        super(message);
    }
}
