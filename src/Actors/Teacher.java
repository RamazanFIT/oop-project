package Actors;

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
public class Teacher extends Employee {

    /**
     * @generated
     */
    private Subject subjectSpecialization;

    /**
     * @generated
     */
    public boolean isResearcher;


    /**
     * @generated
     */
    private TeacherRole teacherRole;


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
        return Objects.hash(subjectSpecialization, isResearcher, teacherRole);
    }
}

