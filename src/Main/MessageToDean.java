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
 * The type Message to dean.
 */
public class MessageToDean implements Serializable, Comparable<MessageToDean> {

    private UrgencyLevel level;

    private String message;

    public MessageToDean(UrgencyLevel level, String message) {
        this.level = level;
        this.message = message;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public UrgencyLevel getLevel() {
        return this.level;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(UrgencyLevel level) {
        this.level = level;
    }


    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    @Override
    public int compareTo(MessageToDean o) {
        int x, y;
        if(this.getLevel() == UrgencyLevel.LOW){
            x = 0;
        } else if(this.getLevel() == UrgencyLevel.MEDIUM){
            x = 1;
        } else {
            x = 2;
        }
        if(o.getLevel() == UrgencyLevel.LOW){
            y = 0;
        } else if(o.getLevel() == UrgencyLevel.MEDIUM){
            y = 1;
        } else {
            y = 2;
        }
        if(x > y){
            return 1;
        } else if(x < y){
            return -1;
        } else {
            return 0;
        }
    }
}
