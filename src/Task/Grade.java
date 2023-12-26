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

//    private int score;
    private int firstAttScore;
    private int secondAttScore;
    private int finalScore;

    /**
     * Instantiates a new Grade.
     */
    public Grade() {
        firstAttScore = 0;
        secondAttScore = 0;
        finalScore = 0;
    }

    /**
     * Instantiates a new Grade.
     *
     * @param firstAttScore  the first att score
     * @param secondAttScore the second att score
     * @param finalScore     the final score
     */
    public Grade(int firstAttScore, int secondAttScore, int finalScore) {
        this.firstAttScore = firstAttScore;
        this.secondAttScore = secondAttScore;
        this.finalScore = finalScore;
    }

    /**
     * Set score.
     *
     * @param att   the att
     * @param score the score
     */
    public void setScore(Attestation att, int score){
        if(att == Attestation.FINAL){
            this.finalScore = score;
        } else if(att == Attestation.FIRST){
            this.firstAttScore = score;
        } else{
            this.secondAttScore = score;
        }
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return finalScore + firstAttScore + secondAttScore;
    }

    /**
     * Get score int.
     *
     * @param att the att
     * @return the int
     */
    public int getScore(Attestation att){
        if(att == Attestation.FINAL){
            return finalScore;
        } else if(att == Attestation.FIRST){
            return firstAttScore;
        } else{
            return secondAttScore;
        }
    }

    /**
     * Gets mark.
     *
     * @return the mark
     */
    public String getMark() {
        if(getScore() >= 90) return "A";
        if(getScore() >= 80) return "B";
        if(getScore() >= 70) return "C";
        if(getScore() >= 60) return "D";
        return "F";
    }

    public String toString() {
        return getMark();
    }
    @Override
    public int compareTo(Grade o) {
        if(this.getScore() < o.getScore()){
            return 1;
        } else{
            return -1;
        }
    }
}

