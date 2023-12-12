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
    private String mark;

    public Grade(int score, String mark) {
        this.score = score;
        this.mark = mark;
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
        return this.mark;
    }

    /**
     * @generated
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Grade o) {
        return 0;
    }
}

