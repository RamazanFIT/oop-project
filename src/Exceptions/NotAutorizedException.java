package Exceptions;

public class NotAutorizedException extends Exception {
    public NotAutorizedException(){};
    public NotAutorizedException(String message){
        super(message);
    }
}
