package BrotherMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Actors.*;
import Comparators.AToZComparator;
import Date.DataBase;
import Enums.Organization;
import Exceptions.ExceededCreditException;
import Main.MessageToDean;
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

public class ManagerMenu {
    private Manager manager;

    private DataBase dataBase;

    private BufferedReader reader;

    public ManagerMenu(Manager manager) throws IOException, ClassNotFoundException{
        this.manager = manager;
        this.dataBase = DataBase.getInstance();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showMenu() throws IOException, ClassNotFoundException, NotAutorizedException {
        String menuOptions = "\nWelcome, Manager: " + manager.getName() + """
                \n1. Get info about students on a course.
                2. Get info about teachers on a course.
                3. Add student to course.
                4. Add news.
                5. Delete news.
                6. Send message to Dean. 
                7. Add Course
                8. next command
                0. Logout. """;
        boolean isRunning = true;
        while(isRunning){
            System.out.println(menuOptions);
            String options = reader.readLine();
            switch(options){
                case "1":
                    getStudentsInfo();
                    break;
                case "2":
                    getTeacherInfo();
                    break;
                case "3":
                    addStudentToCourse();
                    break;
                case "4":
                    addNews();
                    break;
                case "5":
                    removeNews();
                    break;
                case "6":
                    sendMessageToDean();
                    break;
                case "7":
                    addCourse();
                    break;
                case "8":
                    isRunning = false;
                    dataBase.saveToFile("data.ser");
                    System.out.println("Logged out successfully");
                    break;
                case "0":
                    isRunning = false;
                    dataBase.saveToFile("data.ser");
                    System.out.println("Logged out successfully");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private void getStudentsInfo() throws IOException, ClassNotFoundException, NotAutorizedException {
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
        Course course = dataBase.getCourseByTitle(subject);
        manager.getInfoStudents(course, new AToZComparator());
    }

    private void getTeacherInfo() throws IOException, ClassNotFoundException, NotAutorizedException {
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
        Course course = dataBase.getCourseByTitle(subject);
        manager.getInfoTeachers(course, new AToZComparator());
    }

    private void addStudentToCourse() throws IOException, ClassNotFoundException, NotAutorizedException{
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
        System.out.println("Enter student's name: ");
        String studName = reader.readLine();
        System.out.println("Enter student's surname: ");
        String studSurname = reader.readLine();
        Course course = dataBase.getCourseByTitle(subject);
        Student student = (Student) dataBase.getUser(studName, studSurname);
        manager.addStudentToCourse(student, course);
    }

    private void addNews() throws IOException, ClassNotFoundException, NotAutorizedException {
        System.out.println("Set news title: ");
        String title = reader.readLine();
        System.out.println("Enter news content: ");
        String body = reader.readLine();
        News news = new News(title, body);
        manager.addNews((news));
    }

    private void removeNews() throws IOException, ClassNotFoundException, NotAutorizedException {
        System.out.println("Enter news title: ");
        String title = reader.readLine();
        News news = dataBase.getNewsByTitle(title);
        manager.removeNews(news);
    }

    private void sendMessageToDean() throws IOException, ClassNotFoundException, NotAutorizedException {
        UrgencyLevel level;
        System.out.println("""
                Set urgency level:
                1. LOW
                2. MEDIUM
                3. HIGH
                """);
        String check = reader.readLine();
        if(check.equals("1")){
            level = UrgencyLevel.LOW;
        } else if (check.equals("2")) {
            level = UrgencyLevel.MEDIUM;
        } else  {
            level = UrgencyLevel.HIGH;
        }
        String message = reader.readLine();
        MessageToDean messageToDean = new MessageToDean(level, message);
        manager.sendMessageToDean(messageToDean);
    }
    public void addCourse() throws IOException, ClassNotFoundException {
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

        System.out.println("Enter course description: ");
        String description = reader.readLine();
        System.out.println("Enter course credit: ");
        int credit = Integer.parseInt(reader.readLine());
        Course course = new Course(credit, subject, description);
        manager.addCourse(course);
    }
}
