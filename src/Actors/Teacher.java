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
        return this.listCourses; // TODO
    }

    /**
     * @generated
     */
    public void addTeachCourse(Course course) {
        this.listCourses = listCourses; // TODO
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

