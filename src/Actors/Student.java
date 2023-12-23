package Actors;

import Enums.*;
import Exceptions.*;
import Science.*;

import java.io.IOException;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
import Task.Organization;

/**
 * The type Student.
 */
public class Student extends User implements Researcher{
    /**
     * The Faculty.
     */
    public FACULTY faculty;

    /**
     * The Is researcher.
     */
    public boolean isResearcher;
    //Anuar

    /**
     * Instantiates a new Student.
     */
    public Student(){

    }

    /**
     * Instantiates a new Student.
     *
     * @param name           the name
     * @param surname        the surname
     * @param password       the password
     * @param lang           the lang
     * @param faculty        the faculty
     * @param diplomaProject the diploma project
     */
    public Student(String name, String surname, String password,
                   LANGUAGES lang, FACULTY faculty,
                   DiplomaProject diplomaProject)
                    throws IOException, ClassNotFoundException {
        super(name, surname, password, lang);
        this.faculty = faculty;
        isResearcher = false;
        createDiplomaProject(diplomaProject);
    }
    //Anuar

    /**
     * Gets enrolled courses.
     *
     * @return the enrolled courses
     */
    public Vector<Course> getEnrolledCourses() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getUserCourses(this); // добавлено
    }

    /**
     * Gets transcript.
     *
     * @return the transcript
     */
    public Transcript getTranscript() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        Transcript transcript = new Transcript();
        transcript.setCourseGrades(dataBase.getMarkOfStudent(this));
        transcript.setStudent(this);
        return transcript; // добавлено
    }

    /**
     * Gets credits.
     *
     * @return the credits
     */
    public int getCredits() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getCntOfCreditStudent(this);
    }


    /**
     * Gets organization.
     *
     * @return the organization
     */
    public Vector<Task.Organization> getOrganization() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getStudentOrganizations(this);
    }

    /**
     * Sets organization.
     *
     * @param organization the organization
     * @param role         the role
     */
    public void setOrganization(Enums.Organization organization, RoleOfOrganisation role) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.setOrganizationToStudent(this, organization, role);
    }

    /**
     * Sets organization.
     *
     * @param organization the organization
     */
    public void setOrganization(Enums.Organization organization) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.setOrganizationToStudent(this, organization);
    }

    /**
     * Gets faculty.
     *
     * @return the faculty
     */
    public FACULTY getFaculty() {
        return this.faculty;
    }

    /**
     * Sets faculty.
     *
     * @param faculty the faculty
     */
    public void setFaculty(FACULTY faculty) {
        this.faculty = faculty;
    }


    /**
     * Gets diploma project.
     *
     * @return the diploma project
     */
    public DiplomaProject getDiplomaProject() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getDiplomaProject(this); // добавлено
    }

    /**
     * Create diploma project.
     *
     * @param project the project
     */
    public void createDiplomaProject(DiplomaProject project) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        if(!dataBase.existsDiplomaProject(this)){
            dataBase.addDiplomaProject(project, this);
        }
    }

    /**
     * Gets info about teacher.
     *
     * @param course the course
     * @return the info about teacher
     */
    public Vector<Teacher> getInfoAboutTeacher(Course course) throws IOException, ClassNotFoundException {
       DataBase dataBase = DataBase.getInstance();
        return dataBase.getTeacherInfo(course); // добавлено
    }

    /**
     * Gets major.
     *
     * @return the major
     */
    public Vector<Course> getMajor() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMajorCoursesOfStudent(this);
    }

    /**
     * Gets minor.
     *
     * @return the minor
     */
    public Vector<Course> getMinor() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMinorCoursesOfStudent(this);
    }

    @Override
    public boolean isResearcher() {
        return isResearcher;
    }

    @Override
    public void setResearcher(boolean isResearcher) {
        this.isResearcher = isResearcher;
    }

    /**
     * Register for course.
     *
     * @param course the course
     * @throws ExceededCreditException the exceeded credit exception
     */
    public void registerForCourse(Course course) throws ExceededCreditException, IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.registerStudentForCourse(course, this); // добавлено
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
        try {
            return super.toString() + ", faculty: " + faculty + ", diploma project: " + getDiplomaProject() + ", researcher: " + isResearcher;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

