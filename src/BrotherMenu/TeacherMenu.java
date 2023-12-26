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
public class TeacherMenu {

    private Teacher teacher;
    private DataBase dataBase;
    private BufferedReader reader;

    public TeacherMenu(Teacher teacher) throws IOException, ClassNotFoundException {
        this.teacher = teacher;
        this.dataBase = DataBase.getInstance();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showMenu() throws IOException, ClassNotFoundException, NotAutorizedException {
        String menuOptions = "\nWelcome, Student: " + student.getName() + """
                \n1. Get Subject Specialization.
                2. Set Subject Specialization.
                3. Get List of Courses.
                4. Add Course to teacher.
                5. Get Teacher Role.
                6. Set Teacher Role.
                7. Put Mark to student.
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
    public void getSubjectSpec(){
        System.out.println("Subject specialization" + teacher.getSubjectSpecialization());

    }

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
    public void getListOfCourses() throws IOException, ClassNotFoundException {
        System.out.println("The courses of teacher" + teacher.getListCourses());
        System.out.println("Success");

    }

    public void addCourseToTeacher() throws IOException, NotAutorizedException, ClassNotFoundException {
        System.out.println("Enter the title of course: ");
        String title = reader.readLine();
        Course c = dataBase.getCourseByTitle(title);
        teacher.addTeachCourse(c);
        System.out.println("Success");
    }

    public void getTeacherRole(){
        System.out.println("Teacher role is: " + teacher.getTeacherRole());
        System.out.println("Success");

    }
}
