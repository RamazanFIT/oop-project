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

    public Organization organization;
    public FACULTY faculty;
    public DiplomaProject diplomaProject;
    public boolean isResearcher;
    //Anuar

    public Student(){

    }

    public Student(Organization organization, FACULTY faculty, DiplomaProject diplomaProject){
        this.organization = organization;
        this.faculty = faculty;
        this.diplomaProject = diplomaProject;
        isResearcher = false;
    }
    //Anuar

    /**
     * @generated
     */
    public Vector<Course> getEnrolledCourses() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getUserCourses(this);
    }

    /**
     * @generated
     */
    public Transcript getTranscript() {
        DataBase dataBase = DataBase.getInstance();
        Transcript transcript = new Transcript();
        transcript.setCourseGrades(dataBase.getMarkOfStudent(this));
        transcript.setStudent(this);
        return transcript;
    }

    /**
     * @generated
     */
    public int getCredits() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getCntOfCreditStudent(this);
    }


    /**
     * @generated
     */
    public Vector<Task.Organization> getOrganization() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getStudentOrganizations(this)
    }

    /**
     * @generated
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }


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
    public DiplomaProject getDiplomaProject() {
        return diplomaProject;
    }

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

