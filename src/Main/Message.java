package Main;
import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;

import java.io.Serializable;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * The type Message.
 */
public class Message implements Serializable {

    private String message;

    private Date date;

    private User sender;
    private User receiver;

    /**
     * Instantiates a new Message.
     *
     * @param sender   the sender
     * @param receiver the receiver
     * @param message  the message
     */
    public Message(User sender, User receiver, String message){
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.date = new Date();
    }


    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * Gets sender.
     *
     * @return the sender
     */
    public User getSender() {
        return this.sender;
    }

    /**
     * Sets sender.
     *
     * @param sender the sender
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    /**
     * Set receiver.
     *
     * @param user the user
     */
    public void setReceiver(User user){
        this.receiver = user;
    }

    /**
     * Gets receiver.
     *
     * @return the receiver
     */
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
