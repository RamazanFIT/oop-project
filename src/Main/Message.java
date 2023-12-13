package Main;
import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * @generated
 */
public class Message {

    /**
     * @generated
     */
    private String message;

    /**
     * @generated
     */
    private Date date;

    /**
     * @generated
     */
    private User sender;
    private User receiver;

    public Message(User sender, User receiver, String message){
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.date = new Date();
    }


    /**
     * @generated
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * @generated
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * @generated
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * @generated
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * @generated
     */
    public User getSender() {
        return this.sender;
    }

    /**
     * @generated
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User user){
        this.receiver = user;
    }

    public User getReceiver() {
        return this.receiver;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
