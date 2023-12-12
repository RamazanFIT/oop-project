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
import Main.*;

/**
 * @generated
 */
public class Course {

    public int credit;
    /**
     * @generated
     */
    public Subject title;

    /**
     * @generated
     */
    public String description;

    /**
     * @generated
     */
    public Vector<Teacher> instructors;

    /**
     * @generated
     */
    public Vector<Student> students;

    public TreeMap<Student, Grade> grades;

    public Course(){

    }

    public Course(int credit, Subject title, String description){
        this.credit = credit;
        this.title = title;
        this.description = description;
    }

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


    public void setCredit(int credit){
        this.credit = credit;
    }

    public int getCredit(){
        return credit;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credit == course.credit && title == course.title && Objects.equals(description, course.description) && Objects.equals(instructors, course.instructors) && Objects.equals(students, course.students) && Objects.equals(grades, course.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credit, title, description, instructors, students, grades);
    }

    @Override
    public String toString() {
        return "Course credits: " + credit + ", title: " + title + ", course description: " + description + ", instructors: " + instructors + ", student enrolled: " + students;
    }
}


