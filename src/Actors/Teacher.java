package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * @generated
 */
public class Teacher extends Employee {

    /**
     * @generated
     */
    public Subject subjectSpecialization;

    /**
     * @generated
     */
    public boolean isResearcher;


    /**
     * @generated
     */
    public TeacherRole teacherRole;

    public Teacher(){

    }

    public Teacher(String name, String surname, String password, LANGUAGES lang, String department, double salary, Subject subjectSpecialization, TeacherRole teacherRole){
        super(name, surname, password, lang, department, salary);
        this.subjectSpecialization = subjectSpecialization;
        this.teacherRole = teacherRole;
    }


    /**
     * @generated
     */
    public Subject getSubjectSpecialization() {
        return this.subjectSpecialization;
    }

    /**
     * @generated
     */
    public void setSubjectSpecialization(Subject subjectSpecialization) {
        this.subjectSpecialization = subjectSpecialization;
    }


    /**
     * @generated
     */
    public List<Course> getListCourses() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getTeachCourseList(this);
    }

    /**
     * @generated
     */
    public void addTeachCourse(Course course) {
        DataBase dataBase = DataBase.getInstance();
        dataBase.addTeacherToTeachCourse(this, course);
    }


    /**
     * @generated
     */
    public TeacherRole getTeacherRole() {
        return this.teacherRole;
    }

    /**
     * @generated
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

    public void putMark(Student student, Grade grade, Course course){
//        DataBase dataBase = DataBase.getInstance();
            course.setMarkToStudent(student, grade);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Teacher teacher = (Teacher) object;
        return isResearcher == teacher.isResearcher && java.util.Objects.equals(subjectSpecialization, teacher.subjectSpecialization) && java.util.Objects.equals(teacherRole, teacher.teacherRole);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), subjectSpecialization, isResearcher, teacherRole);
    }

    public String toString(){
        return super.toString() + ", Subject specialization: " + subjectSpecialization + ", Teacher role: " + teacherRole + ", Researcher: " + isResearcher;
    }
}

