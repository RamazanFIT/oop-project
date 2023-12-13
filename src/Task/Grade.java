package Task;
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
public class Grade implements Comparable<Grade>{

    /**
     * @generated
     */
    private int score;

    /**
     * @generated
     */
    public Grade(int score) {
        this.score = score;
    }

    /**
     * @generated
     */
    public int getScore() {
        return this.score;
    }

    /**
     * @generated
     */
    public void setScore(Integer score) {
        this.score = score;
    }


    /**
     * @generated
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

