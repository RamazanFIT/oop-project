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
        // TODO
    }

    public Vector<Teacher> getInfoTeachers(Course course, Comparator compare) {
        // TODO
    }

    public void addStudentToCourse(Student student, Course course){
        // TODO
    }

    public void addNews(News news){
        // TODO
    }

}

