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
import Main.*;

/**
 * @generated
 */
public class Course {

    public int credit;
    /**
     * @generated
     */
    private Subject title;

    /**
     * @generated
     */
    private String description;

    /**
     * @generated
     */
    private Vector<Teacher> instructors;

    /**
     * @generated
     */
    private Vector<Student> students;

    private TreeMap<Student, Grade> grades;

    public void setMarkToStudent(Student student, Grade grade){
        grades.put(student, grade);
    }

    public TreeMap<Student, Grade> getGrades(){
        return grades;
    }


    /**
     * @generated
     */
    public Subject getTitle() {
        return this.title;
    }

    /**
     * @generated
     */
    public void setTitle(Subject title) {
        this.title = title;
    }


    /**
     * @generated
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @generated
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @generated
     */
    public Vector<Teacher> getInstructors() {
        return this.instructors;
    }

    /**
     * @generated
     */
    public void addInstructor(Teacher instructor) {
        this.instructors.add(instructor);
    }

    public void removeInstructor(Teacher instructor) {
        this.instructors.remove(instructor);
    }


    /**
     * @generated
     */
    public Vector<Student> getStudents() {
        return this.students;
    }

    /**
     * @generated
     */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }
}

