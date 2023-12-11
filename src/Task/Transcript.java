package Task;

import Actors.*;
import Enums.*;
import Exceptions.*;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
import Task.Organization;
import com.sun.source.tree.Tree;

/**
 * @generated
 */
public class Transcript {
    TreeMap<String, Integer> grades = new TreeMap<>();

    /**
     * @generated
     */
    private TreeMap<Course, Grade> courseGrades;


    /**
     * @generated
     */
    private Student student;



    /**
     * @generated
     */
    public Transcript(){
        grades.put("A", 4);
        grades.put("B", 3);
        grades.put("C", 2);
        grades.put("D", 1);
        grades.put("F", 0);
    }
    public TreeMap<Course, Grade> getCourseGrades() {
        return this.courseGrades;
    }

    public void setCourseGrades(TreeMap<Course, Grade> courseGrades){
        this.courseGrades = courseGrades;
    }


    /**
     * @generated
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
     * @generated
     */
    public Student getStudent() {
        return this.student;
    }

    /**
     * @generated
     */
    public void setStudent(Student student) {
        this.student = student;
    }



}
