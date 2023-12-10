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
        // TODO
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
