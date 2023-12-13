package Actors;

import Enums.*;
import Exceptions.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
import Task.Organization;

/**
 * @generated
 */
public class Student extends User implements Researcher, Comparable<Student> {
    public FACULTY faculty;

    public boolean isResearcher;
    //Anuar

    public Student(){

    }

    public Student(String name, String surname, String password, LANGUAGES lang, FACULTY faculty, DiplomaProject diplomaProject){
        super(name, surname, password, lang);
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
    public void registerForCourse(Course course) throws ExceededCreditException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.registerStudentForCourse(course, this);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Student student = (Student) object;
        return isResearcher() == student.isResearcher() && java.util.Objects.equals(getFaculty(), student.getFaculty());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getFaculty(), isResearcher());
    }

    public String toString(){
        return super.toString() + ", faculty: " + faculty + ", diploma project: " + getDiplomaProject() + ", researcher: " + isResearcher;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}

