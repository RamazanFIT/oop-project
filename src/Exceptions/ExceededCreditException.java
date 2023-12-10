package Exceptions;


public class ExceededCreditException extends Exception {
    public ExceededCreditException(){};
    public ExceededCreditException(String message){
        super(message);
    }
}
