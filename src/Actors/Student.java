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
     * @param name     the name
     * @param surname  the surname
     * @param password the password
     * @param lang     the lang
     */
    public Student(String name, String surname, String password, LANGUAGES lang){
        super(name, surname, password, lang);
    }

    /**
     * Instantiates a new Student.
     *
     * @param name     the name
     * @param surname  the surname
     * @param password the password
     * @param lang     the lang
     * @param f        the f
     */
    public Student(String name, String surname, String password, LANGUAGES lang, FACULTY f){
        super(name, surname, password, lang);
        faculty = f;
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


    /**
     * Gets enrolled courses.
     *
     * @return the enrolled courses
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public Vector<Course> getEnrolledCourses() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getUserCourses(this); // добавлено
    }

    /**
     * Gets transcript.
     *
     * @return the transcript
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
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
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public int getCredits() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getCntOfCreditStudent(this); // done
    }


    /**
     * Gets organization.
     *
     * @return the organization
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public Vector<Task.Organization> getOrganization() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getStudentOrganizations(this); // done
    }

    /**
     * Sets organization.
     *
     * @param organization the organization
     * @param role         the role
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void setOrganization(Enums.Organization organization, RoleOfOrganisation role) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.setOrganizationToStudent(this, organization, role); // done
    }

    /**
     * Sets organization.
     *
     * @param organization the organization
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
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
    } // done

    /**
     * Sets faculty.
     *
     * @param faculty the faculty
     */
    public void setFaculty(FACULTY faculty) {
        this.faculty = faculty;
    } // done


    /**
     * Gets diploma project.
     *
     * @return the diploma project
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public DiplomaProject getDiplomaProject() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getDiplomaProject(this); // добавлено
    }

    /**
     * Create diploma project.
     *
     * @param project the project
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void createDiplomaProject(DiplomaProject project) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        if(!dataBase.existsDiplomaProject(this)){
            dataBase.addDiplomaProject(project, this); // done
        }
    }

    /**
     * Gets info about teacher.
     *
     * @param course the course
     * @return the info about teacher
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public Vector<Teacher> getInfoAboutTeacher(Course course) throws IOException, ClassNotFoundException {
       DataBase dataBase = DataBase.getInstance();
        return dataBase.getTeacherInfo(course); // добавлено
    }

    /**
     * Gets major.
     *
     * @return the major
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public Vector<Course> getMajor() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMajorCoursesOfStudent(this);  // done
    }

    /**
     * Gets minor.
     *
     * @return the minor
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public Vector<Course> getMinor() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMinorCoursesOfStudent(this);// done
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
     * @throws IOException             the io exception
     * @throws ClassNotFoundException  the class not found exception
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

