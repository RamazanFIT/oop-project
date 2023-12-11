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
    private List<Course> listCourses;

    /**
     * @generated
     */
    private TeacherRole teacherRole;


    /**
     * @generated
     */
    private Course course;



    /**
     * @generated
     */
    public Subject getSubjectSpecialization() {
        return this.subjectSpecialization;
    }

    /**
     * @generated
     */
    public Subject setSubjectSpecialization(Subject subjectSpecialization) {
        this.subjectSpecialization = subjectSpecialization;
    }


    /**
     * @generated
     */
    public List<Course> getListCourses() {
        return this.listCourses;
    }

    /**
     * @generated
     */
    public List<Course> setListCourses(List<Course> listCourses) {
        this.listCourses = listCourses;
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
    public TeacherRole setTeacherRole(TeacherRole teacherRole) {
        this.teacherRole = teacherRole;
    }



    /**
     * @generated
     */
    public Course getCourse() {
        return this.course;
    }

    /**
     * @generated
     */
    public Course setCourse(Course course) {
        this.course = course;
    }

    @Override
    public Vector<ResearchPaper> printPapers(Comparator comparator) {
        return null;
    }

    @Override
    public int cntHIndex() {
        return 0;
    }

    @Override
    public Vector<ResearchProject> getProjects() {
        return null;
    }

    @Override
    public void addProject(ResearchProject project) throws ImposterException {

    }

    @Override
    public void delProject(ResearchProject project) {

    }

    @Override
    public Vector<ResearchPaper> getPapers() {
        return null;
    }

    @Override
    public void addPapers(ResearchPaper paper) throws ImposterException {

    }

    @Override
    public void delPapers(ResearchPaper paper) throws ImposterException {

    }

    @Override
    public Vector<ResearchProject> getOwnProject() {
        return null;
    }

    @Override
    public boolean isResearcher() {
        return false;
    }

    @Override
    public void setResearcher(boolean isResearcher) {

    }


    //                          Operations


}

