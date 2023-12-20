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
public class MessageToDean implements Serializable {

    private UrgencyLevel level;

    private String message;


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

}
