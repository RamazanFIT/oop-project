package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;

import java.io.IOException;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * The type Teacher.
 */
public class Teacher extends Employee {

    /**
     * The Subject specialization.
     */
    public Subject subjectSpecialization;

    /**
     * The Is researcher.
     */
    public boolean isResearcher;


    /**
     * The Teacher role.
     */
    public TeacherRole teacherRole;

    /**
     * Instantiates a new Teacher.
     */
    public Teacher(){

    }

    /**
     * Instantiates a new Teacher.
     *
     * @param name                  the name
     * @param surname               the surname
     * @param password              the password
     * @param lang                  the lang
     * @param department            the department
     * @param salary                the salary
     * @param subjectSpecialization the subject specialization
     * @param teacherRole           the teacher role
     */
    public Teacher(String name, String surname, String password,
                   LANGUAGES lang, String department,
                   double salary, Subject subjectSpecialization, TeacherRole teacherRole){
        super(name, surname, password, lang, department, salary);
        this.subjectSpecialization = subjectSpecialization;
        this.teacherRole = teacherRole;
    }


    /**
     * Gets subject specialization.
     *
     * @return the subject specialization
     */
    public Subject getSubjectSpecialization() {
        return this.subjectSpecialization;
    }

    /**
     * Sets subject specialization.
     *
     * @param subjectSpecialization the subject specialization
     */
    public void setSubjectSpecialization(Subject subjectSpecialization) {
        this.subjectSpecialization = subjectSpecialization;
    }


    /**
     * Gets list courses.
     *
     * @return the list courses
     */
    public List<Course> getListCourses() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getTeachCourseList(this);
    }

    /**
     * Add teach course.
     *
     * @param course the course
     */
    public void addTeachCourse(Course course) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.addTeacherToTeachCourse(this, course);
    }


    /**
     * Gets teacher role.
     *
     * @return the teacher role
     */
    public TeacherRole getTeacherRole() {
        return this.teacherRole;
    }

    /**
     * Sets teacher role.
     *
     * @param teacherRole the teacher role
     */
    public void setTeacherRole(TeacherRole teacherRole) {
        this.teacherRole = teacherRole;
    }


    @Override
    public boolean isResearcher() {
        return isResearcher;
    }

    @Override
    public void setResearcher(boolean isResearcher) {
        this.isResearcher = isResearcher;
    }

    /**
     * Put mark.
     *
     * @param student the student
     * @param grade   the grade
     * @param course  the course
     */
//    public void putMark(Student student, Grade grade, Course course, Attestation){
////            course.setMarkToStudent(student, grade);
//
//    }
    public void putMark(Student student, int score, Course course, Attestation att){
        course.setMarkToStudent(student, score, att);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Teacher teacher = (Teacher) object;
        return isResearcher == teacher.isResearcher
                && java.util.Objects.equals(subjectSpecialization, teacher.subjectSpecialization)
                && java.util.Objects.equals(teacherRole, teacher.teacherRole);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(),
                subjectSpecialization, isResearcher, teacherRole);
    }

    public String toString(){
        return super.toString() + ", Subject specialization: " +
                subjectSpecialization + ", Teacher role: " +
                teacherRole + ", Researcher: " + isResearcher;
    }
}

