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
import Task.Organization;

/**
 * @generated
 */
public class Student extends User implements Researcher {

    public int credits;
    public Organization organization;
    public FACULTY faculty;
    public DiplomaProject diplomaProject;
    public boolean isResearcher;

    public Student(){

    }

    public Student(int credits, Organization organization, FACULTY faculty, DiplomaProject diplomaProject){
        this.credits = credits;
        this.organization = organization;
        this.faculty = faculty;
        this.diplomaProject = diplomaProject;
        isResearcher = false;
    }


    /**
     * @generated
     */
//    public Vector<Course> getEnrolledCourses() {
////        return "";
//    }

    /**
     * @generated
     */
//    public Transcript getTranscript() {
////        return ""
//    }

    /**
     * @generated
     */
//    public int getCredits() {
//        return "";
//    }


    /**
     * @generated
     */
//    public Organization getOrganization() {
//        return ""
//    }

    /**
     * @generated
     */
//    public void setOrganization(Organization organization) {
//
//    }


    /**
     * @generated
     */
    public FACULTY getFaculty() {
        return this.faculty;
    }

    /**
     * @generated
     */
    public void setFaculty(FACULTY faculty) {
        this.faculty = faculty;
    }


    /**
     * @generated
     */
//    public DiplomaProject getDiplomaProject() {
//        return // TODO
//    }

    /**
     * @generated
     */
//    public String getInfoAboutTeacher(Course course) {
//        //TODO
//        return "";
//    }

    /**
     * @generated
     */
    public String getMajor() {
        //TODO
        return "";
    }

    /**
     * @generated
     */
    public String getMinor() {
        //TODO
        return "";
    }

    @Override
    public String printPapers(Comparator comparator) {
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
    public void addProject(ResearchProject project) {

    }

    @Override
    public void delProject(ResearchProject project) {

    }

    @Override
    public Vector<ResearchPaper> getPapers() {
        return null;
    }

    @Override
    public void addPapers(ResearchPaper paper) {

    }

    @Override
    public void delPapers(ResearchPaper paper) {

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

    /**
     * @generated
     */
//    public void registerForCourse(Course course) {
//        //TODO
//    }

}

