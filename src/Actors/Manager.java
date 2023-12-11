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
public class Manager extends Employee {

    /**
     * @generated
     */

    private boolean isResearcher;
    private ManagerType managerType;

    /**
     * @generated
     */
    public ManagerType getManagerType() {
        return this.managerType;
    }

    /**
     * @generated
     */
    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    public Vector<Student> getInfoStudents(Course course, Comparator compare) {
        Vector<Student> students = course.getStudents();
        Collections.sort(students, compare);
        return students;
    }


    public Vector<Teacher> getInfoTeachers(Course course, Comparator compare) {
        Vector<Teacher> teachers = course.getInstructors();
        Collections.sort(teachers, compare);
        return teachers;
    }

    public void addStudentToCourse(Student student, Course course){
        course.addStudent(student);
    }

    public void addNews(News news){
        DataBase dataBase = DataBase.getInstance();
        dataBase.addNews(news);
    }

    public void removeNews(News news){
        DataBase dataBase = DataBase.getInstance();
        dataBase.removeNews(news);
    }

    @Override
    public boolean isResearcher() {
        return false;
    }

    @Override
    public void setResearcher(boolean isResearcher) {
        this.isResearcher = isResearcher;
    }
}

