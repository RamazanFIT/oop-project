package BrotherMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Actors.Student;
import Date.DataBase;
import Exceptions.ExceededCreditException;
import Science.*;
import Interfaces.*;
import Actors.*;
import Enums.*;
import Exceptions.*;
import java.io.IOException;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
public class StudentMenu {

    private Student student;
    private DataBase dataBase;
    private BufferedReader reader;

    public StudentMenu(Student student) throws IOException, ClassNotFoundException {
        this.student = student;
        this.dataBase = DataBase.getInstance();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showMenu() throws IOException, ClassNotFoundException {
        String menuOptions = "\nWelcome, Student: " + student.getName() + """
                \n1. View enrolled courses.
                2. View transcript.
                3. Register for a course.
                4. View diploma project.
                5. View major courses.
                6. View minor courses.
                7. View faculty.
                8. View organizations.
                9. View teacher info.
                10. Set Faculty.
                0. Logout.""";
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menuOptions);
            String option = reader.readLine();
            switch (option) {
                case "1":
                    viewEnrolledCourses();
                    break;
                case "2":
                    viewTranscript();
                    break;
                case "3":
                    registerForCourse();
                    break;
                case "4":
                    viewDiplomaProject();
                    break;
                case "5":
                    viewMajorCourses();
                    break;
                case "6":
                    viewMinorCourses();
                    break;
                case "7":
                    viewFacultyDetails();
                    break;
                case "8":
                    Organizations();
                    break;
                case "9":
                    viewTeacherInfo();
                    break;
                case "10":
                    setF();
                    break;
                case "11":
                    getCreditsOfCourse();
                    break;
                case "0":
                    isRunning = false;
                    dataBase.saveToFile("data.ser");
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void viewEnrolledCourses() throws IOException, ClassNotFoundException {
        System.out.println("Enrolled Courses: ");
        student.getEnrolledCourses().forEach(System.out::println);
    }

    private void viewTranscript() throws IOException, ClassNotFoundException {
        Transcript transcript = student.getTranscript();
        System.out.println("Transcript: " + transcript);
    }

    private void registerForCourse() throws IOException {
        System.out.println("Available Courses: ");
        dataBase.courses.forEach(System.out::println);
        System.out.print("Enter Course title to register: ");
        String courseTitle = reader.readLine();
        try {
            Course course = dataBase.getCourseByTitle(courseTitle);
            student.registerForCourse(course);
            System.out.println("Registered successfully for course: " + course.getTitle());
        } catch (ExceededCreditException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NotAutorizedException e) {
            throw new RuntimeException(e);
        }
    }

    private void viewDiplomaProject() throws IOException, ClassNotFoundException {
        System.out.println("Diploma Project: " + student.getDiplomaProject());
    }

    private void viewMajorCourses() throws IOException, ClassNotFoundException {
        System.out.println("Major Courses: ");
        student.getMajor().forEach(System.out::println);
    }

    private void viewMinorCourses() throws IOException, ClassNotFoundException {
        System.out.println("Minor Courses: ");
        student.getMinor().forEach(System.out::println);
    }

    private void viewFacultyDetails() {
        System.out.println("Faculty: " + student.getFaculty());
    }

    private void Organizations() throws IOException, ClassNotFoundException {
        System.out.println("Organizations: " + student.getOrganization());
    }

    public void viewTeacherInfo() {
        System.out.println("Enter a course name to see teacher info: ");
        String courseTitle;
        Course course;
        try {
            courseTitle = reader.readLine();
            course = dataBase.getCourseByTitle(courseTitle);
            System.out.println("Teacher info: " + student.getInfoAboutTeacher(course));
        } catch (IOException | NotAutorizedException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setF() throws IOException {
        System.out.println("""
                setting Faculty information
                1.  FIT
                      
                2.  SHENGI
                       
                3.  WXI
                        
                4.  MWE
                       
                5.  NGD
                """);
        String param = reader.readLine();
        FACULTY f;
        if(param.equals("1")){
            f = FACULTY.FIT;
        } else if(param.equals("2")){
            f = FACULTY.SHENGI;
        } else if(param.equals("3")){
            f = FACULTY.WXI;
        } else if(param.equals("4")){
            f = FACULTY.MWE;
        } else {
            f = FACULTY.NGD;
        }
        student.setFaculty(f);
        System.out.println("Successfully setFaculty information" +
                " to "
                +
                f);
    }

    public void getCreditsOfCourse() throws IOException, ClassNotFoundException {
        System.out.println("Count of courses credits: " + student.getCredits());

    }


}
