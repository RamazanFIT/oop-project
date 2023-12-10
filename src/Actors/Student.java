package Actors;

import Enums.*;
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
    public FACULTY faculty;

    public boolean isResearcher;
    //Anuar

    public Student(){

    }

    public Student( FACULTY faculty, DiplomaProject diplomaProject){
        this.faculty = faculty;
        isResearcher = false;
        createDiplomaProject(diplomaProject);
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
        return dataBase.getStudentOrganizations(this);
    }

    /**
     * @generated
     */
    public void setOrganization(Enums.Organization organization, RoleOfOrganisation role) {
        DataBase dataBase = DataBase.getInstance();
        dataBase.setOrganizationToStudent(this, organization, role);
    }

    public void setOrganization(Enums.Organization organization) {
        DataBase dataBase = DataBase.getInstance();
        dataBase.setOrganizationToStudent(this, organization);
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
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getDiplomaProject(this);
    }

    public void createDiplomaProject(DiplomaProject project) {
        DataBase dataBase = DataBase.getInstance();
        if(!dataBase.existsDiplomaProject(this)){
            dataBase.addDiplomaProject(project, this);
        }
    }

    /**
     * @generated
     */
    public Vector<Teacher> getInfoAboutTeacher(Course course) {
       DataBase dataBase = DataBase.getInstance();
        return dataBase.getTeacherInfo(course);
    }

    /**
     * @generated
     */
    public Vector<Course> getMajor() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMajorCoursesOfStudent(this);
    }

    /**
     * @generated
     */
    public Vector<Course> getMinor() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMinorCoursesOfStudent(this);
    }

//    @Override
//    public Vector<ResearchPaper> printPapers(Comparator comparator) {
//        DataBase dataBase = DataBase.getInstance();
//        return dataBase.getResearchPaperOfStudent(this, comparator);
//        // TODO
//    }

    public Vector<ResearchPaper> printPapers() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getResearchPaperOfStudent(this);
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
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getStudentProjects(this);
    }

    /**
     * @generated
     */
    @Override
    public boolean isResearcher() {
        return isResearcher;
    }

    /**
     * @generated
     */
    @Override
    public void setResearcher(boolean isResearcher) {
        this.isResearcher = isResearcher;
    }

    /**
     * @generated
     */
//    public void registerForCourse(Course course) {
//        //TODO
//    }

}

