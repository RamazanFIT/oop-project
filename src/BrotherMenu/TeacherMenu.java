package BrotherMenu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Actors.Student;
import Date.DataBase;
import Enums.Organization;
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

/**
 * The type Teacher menu.
 */
public class TeacherMenu {

    private Teacher teacher;
    private DataBase dataBase;
    private BufferedReader reader;

    /**
     * Instantiates a new Teacher menu.
     *
     * @param teacher the teacher
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public TeacherMenu(Teacher teacher) throws IOException, ClassNotFoundException {
        this.teacher = teacher;
        this.dataBase = DataBase.getInstance();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Show menu.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws NotAutorizedException  the not autorized exception
     */
    public void showMenu() throws IOException, ClassNotFoundException, NotAutorizedException {
        String menuOptions = "\nWelcome, Student: " + teacher.getName() + """
                \n1. Get Subject Specialization.
                2. Set Subject Specialization.
                3. Get List of Courses.
                4. Add Course to teacher.
                5. Get Teacher Role.
                6. Set Teacher Role.
                7. Put Mark to student.
                8. next command
                0. Logout.""";
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menuOptions);
            String option = reader.readLine();
            switch (option) {
                case "1":
                    getSubjectSpec();
                    break;
                case "2":
                    setSubjectSpec();
                    break;
                case "3":
                    getListOfCourses();
                    break;
                case "4":
                    addCourseToTeacher();
                    break;
                case "5":
                    getTeacherRole();
                    break;
                case "6":
                    setTeacherRole();
                    break;
                case "7":
                    putMarkToStudent();
                    break;
                case "8":
                    isRunning = false;
                    dataBase.saveToFile("data.ser");
                    System.out.println("Logged out successfully.");
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

    /**
     * Get subject spec.
     */
    public void getSubjectSpec(){
        System.out.println("Subject specialization" + teacher.getSubjectSpecialization());

    }

    /**
     * Sets subject spec.
     *
     * @throws IOException the io exception
     */
    public void setSubjectSpec() throws IOException {
        System.out.println("setting specialization to teacher");
        Subject subject;
        System.out.println("""
                    Enter subject
                    1. CALCULUS1,
                        
                    2. CALCULUS2,
                        
                    3. OOP
                       
                    4. ALGORITHM
                        
                    5.  ENGLISH
                        
                    6. JAPANESE
                    """);


        String check = reader.readLine();
        if(check.equals("1")){
            subject = Subject.CALCULUS1;
        } else if(check.equals("2")){
            subject = Subject.CALCULUS2;
        } else if(check.equals("3")){
            subject = Subject.OOP;
        } else if(check.equals("4")){
            subject = Subject.ALGORITHM;
        } else if(check.equals("5")){
            subject = Subject.ENGLISH;
        } else{
            subject = Subject.JAPANESE;
        }
        teacher.setSubjectSpecialization(subject);
        System.out.println("Success");
    }

    /**
     * Gets list of courses.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void getListOfCourses() throws IOException, ClassNotFoundException {
        System.out.println("The courses of teacher" + teacher.getListCourses());
        System.out.println("Success");

    }

    /**
     * Add course to teacher.
     *
     * @throws IOException            the io exception
     * @throws NotAutorizedException  the not autorized exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void addCourseToTeacher() throws IOException, NotAutorizedException, ClassNotFoundException {
        System.out.println("Enter course Subject: ");
        Subject subject;
        System.out.println("""
                    Enter subject
                    1. CALCULUS1,
                        
                    2. CALCULUS2,
                        
                    3. OOP
                       
                    4. ALGORITHM
                        
                    5.  ENGLISH
                        
                    6. JAPANESE
                    """);
        String check = reader.readLine();
        if(check.equals("1")){
            subject = Subject.CALCULUS1;
        } else if(check.equals("2")){
            subject = Subject.CALCULUS2;
        } else if(check.equals("3")){
            subject = Subject.OOP;
        } else if(check.equals("4")){
            subject = Subject.ALGORITHM;
        } else if(check.equals("5")){
            subject = Subject.ENGLISH;
        } else{
            subject = Subject.JAPANESE;
        }
        Course c = dataBase.getCourseByTitle(subject);

        teacher.addTeachCourse(c);
        System.out.println("Success");
    }

    /**
     * Get teacher role.
     */
    public void getTeacherRole(){
        System.out.println("Teacher role is: " + teacher.getTeacherRole());
        System.out.println("Success");

    }

    /**
     * Sets teacher role.
     *
     * @throws IOException the io exception
     */
    public void setTeacherRole() throws IOException {
        System.out.println("""
                Which one: 
                1. LECTOR,
                       
                2.PROCESSOR
                """);
        String opt = reader.readLine();
        TeacherRole role;
        if(opt.equals("1")){
            role = TeacherRole.LECTOR;
        } else{
            role = TeacherRole.PROCESSOR;
        }
        teacher.setTeacherRole(role);
        System.out.println("Success");

    }

    /**
     * Put mark to student.
     *
     * @throws IOException           the io exception
     * @throws NotAutorizedException the not autorized exception
     */
    public void putMarkToStudent() throws IOException, NotAutorizedException {
        System.out.println("Enter course Subject: ");
        Subject subject;
        System.out.println("""
                    Enter subject
                    1. CALCULUS1,
                        
                    2. CALCULUS2,
                        
                    3. OOP
                       
                    4. ALGORITHM
                        
                    5.  ENGLISH
                        
                    6. JAPANESE
                    """);
        String check = reader.readLine();
        if(check.equals("1")){
            subject = Subject.CALCULUS1;
        } else if(check.equals("2")){
            subject = Subject.CALCULUS2;
        } else if(check.equals("3")){
            subject = Subject.OOP;
        } else if(check.equals("4")){
            subject = Subject.ALGORITHM;
        } else if(check.equals("5")){
            subject = Subject.ENGLISH;
        } else{
            subject = Subject.JAPANESE;
        }
        System.out.println("Enter the name of student");
        String name = reader.readLine();
        System.out.println("Enter the surname of student");
        String surname = reader.readLine();
        System.out.println("Score: ");
        int score = Integer.parseInt(reader.readLine());
        System.out.println("Which attestation:");
        System.out.println("""
                1.  FIRST
                2.  SECOND
                3.  FINAL
                """);
        String opt = reader.readLine();
        Attestation att;
        if(opt.equals("1")){
            att = Attestation.FIRST;
        } else if(opt.equals("2")){
            att = Attestation.SECOND;
        } else{
            att = Attestation.FINAL;
        }
        Course course = dataBase.getCourseByTitle(subject);
        Student student = (Student) dataBase.getUser(name, surname);
        teacher.putMark(student, score, course, att);
        System.out.println("Success");
    }
}
