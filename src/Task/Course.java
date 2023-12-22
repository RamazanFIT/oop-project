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
import Main.*;

/**
 * The type Course.
 */
public class Course implements Comparable<Course>, Serializable {

    /**
     * The Credit.
     */
    public int credit;
    /**
     * The Title.
     */
    public Subject title;

    /**
     * The Description.
     */
    public String description;

    /**
     * The Instructors.
     */
    public Vector<Teacher> instructors;

    /**
     * The Students.
     */
    public Vector<Student> students;

    /**
     * The Grades.
     */
    public TreeMap<Student, Grade> grades;

    /**
     * Instantiates a new Course.
     */
    public Course(){

    }

    /**
     * Instantiates a new Course.
     *
     * @param credit      the credit
     * @param title       the title
     * @param description the description
     */
    public Course(int credit, Subject title, String description){
        this.credit = credit;
        this.title = title;
        this.description = description;
        this.instructors = new Vector<>();
        this.students = new Vector<>();
        this.grades = new TreeMap<>();
    }

    /**
     * Set mark to student.
     *
     * @param student the student
     * @param grade   the grade
     */
//    public void setMarkToStudent(Student student, Grade grade){
//        grades.put(student, grade);
//    }
    public void setMarkToStudent(Student student, int score, Attestation att){
        Grade someGrade;
        if(!grades.containsKey(student)){
            someGrade = new Grade();
        } else{
            someGrade = grades.get(student);
        }
        someGrade.setScore(att, score);
        grades.put(student, someGrade);
    }

    /**
     * Get grades tree map.
     *
     * @return the tree map
     */
    public TreeMap<Student, Grade> getGrades(){
        return grades;
    }


    /**
     * Gets title.
     *
     * @return the title
     */
    public Subject getTitle() {
        return this.title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(Subject title) {
        this.title = title;
    }


    /**
     * Set credit.
     *
     * @param credit the credit
     */
    public void setCredit(int credit){
        this.credit = credit;
    }

    /**
     * Get credit int.
     *
     * @return the int
     */
    public int getCredit(){
        return credit;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Gets instructors.
     *
     * @return the instructors
     */
    public Vector<Teacher> getInstructors() {
        return this.instructors;
    }

    /**
     * Add instructor.
     *
     * @param instructor the instructor
     */
    public void addInstructor(Teacher instructor) {
        this.instructors.add(instructor);
    }

    /**
     * Remove instructor.
     *
     * @param instructor the instructor
     */
    public void removeInstructor(Teacher instructor) {
        this.instructors.remove(instructor);
    }


    /**
     * Gets students.
     *
     * @return the students
     */
    public Vector<Student> getStudents() {
        return this.students;
    }

    /**
     * Add student.
     *
     * @param student the student
     */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * Remove student.
     *
     * @param student the student
     */
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
        return "title: " + title + ", course description: " + description;
    }

    @Override
    public int compareTo(Course o) {
        return 0;
    }
}


