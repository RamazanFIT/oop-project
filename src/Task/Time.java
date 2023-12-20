package Task;

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
 * The type Time.
 */
public class Time implements Serializable {

    private int hour;

    private int minute;


    /**
     * Gets hour.
     *
     * @return the hour
     */
    public int getHour() {
        return this.hour;
    }

    /**
     * Sets hour.
     *
     * @param hour the hour
     */
    public void setHour(Integer hour) {
        this.hour = hour;
    }


    /**
     * Gets minute.
     *
     * @return the minute
     */
    public int getMinute() {
        return this.minute;
    }

    /**
     * Sets minute.
     *
     * @param minute the minute
     */
    public void setMinute(Integer minute) {
        this.minute = minute;
    }


}
