package Task;

import Actors.*;
import Enums.*;
import Exceptions.*;

import java.io.Serializable;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
import Task.Organization;
import com.sun.source.tree.Tree;

/**
 * The type Transcript.
 */
public class Transcript implements Serializable, Comparable<Transcript> {
    /**
     * The Grades.
     */
    TreeMap<String, Integer> grades = new TreeMap<>();

    private TreeMap<Course, Grade> courseGrades;


    private Student student;


    /**
     * Instantiates a new Transcript.
     */
    public Transcript(){
        grades.put("A", 4);
        grades.put("B", 3);
        grades.put("C", 2);
        grades.put("D", 1);
        grades.put("F", 0);
    }

    /**
     * Gets course grades.
     *
     * @return the course grades
     */
    public TreeMap<Course, Grade> getCourseGrades() {
        return this.courseGrades;
    }

    /**
     * Set course grades.
     *
     * @param courseGrades the course grades
     */
    public void setCourseGrades(TreeMap<Course, Grade> courseGrades){
        this.courseGrades = courseGrades;
    }


    /**
     * Gets gpa.
     *
     * @return the gpa
     */
    public double getGpa() {
        double gpa = 0.000;
        int cntOfCredits = 0;
        for(Course c  : this.courseGrades.keySet()){
            gpa += c.getCredit() * grades.get(courseGrades.get(c).getMark());
            cntOfCredits += c.getCredit();
        }
        return gpa / cntOfCredits;
    }

    /**
     * Gets student.
     *
     * @return the student
     */
    public Student getStudent() {
        return this.student;
    }

    /**
     * Sets student.
     *
     * @param student the student
     */
    public void setStudent(Student student) {
        this.student = student;
    }


    @Override
    public int compareTo(Transcript o) {
        if(this.getGpa() > o.getGpa()){
            return 1;
        } else if(this.getGpa() < o.getGpa()){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "grades=" + grades +
                ", courseGrades=" + courseGrades +
                '}';
    }
}
