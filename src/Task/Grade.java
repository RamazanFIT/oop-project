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
 * The type Grade.
 */
public class Grade implements Comparable<Grade>, Serializable {

    private int score;

    /**
     * Instantiates a new Grade.
     *
     * @param score the score
     */
    public Grade(int score) {
        this.score = score;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(Integer score) {
        this.score = score;
    }


    /**
     * Gets mark.
     *
     * @return the mark
     */
    public String getMark() {
        if(score >= 90) return "A";
        if(score >= 80) return "B";
        if(score >= 70) return "C";
        if(score >= 60) return "D";
        return "F";
    }

    public String toString() {
        return getMark();
    }
    @Override
    public int compareTo(Grade o) {
        return 0;
    }
}

