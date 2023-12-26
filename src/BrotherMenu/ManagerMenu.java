package BrotherMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Actors.*;
import Comparators.AToZComparator;
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

public class ManagerMenu {
    private Manager manager;

    private DataBase dataBase;

    private BufferedReader reader;

    public ManagerMenu(Manager manager) throws IOException, ClassNotFoundException{
        this.manager = manager;
        this.dataBase = DataBase.getInstance();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showMenu() throws IOException, ClassNotFoundException {
        String menuOptions = "\nWelcome, Manager: " + manager.getName() + """
                \n1. Get info about students on a course.
                2. Get info about teachers on a course.
                3. Add student to course.
                4. Add news.
                5. Delete news.
                6. Send message to Dean. """;
        boolean isRunning = true;
        while(isRunning){
            System.out.println(menuOptions);
            String options = reader.readLine();
            switch(options){
                case "1":

            }
        }
    }


    private void getStudentsInfo() throws IOException, ClassNotFoundException, NotAutorizedException {
        System.out.println("Enter course title: ");
        String courseName = reader.readLine();
        Course course = dataBase.getCourseByTitle(courseName);
        manager.getInfoStudents(course, new AToZComparator());
    }

    private void getTeacherInfo() throws IOException, ClassNotFoundException, NotAutorizedException {
        System.out.println("Enter course title: ");
        String courseName = reader.readLine();
        Course course = dataBase.getCourseByTitle(courseName);
        manager.getInfoTeachers(course, new AToZComparator());
    }

    private void addStudentToCourse() throws IOException, ClassNotFoundException, NotAutorizedException{
        System.out.println("Enter course title; ");
        String courseName = reader.readLine();
        System.out.println("Enter students name: ");
        String studName = reader.readLine();
        String studSurname = reader.readLine();
        Course course = dataBase.getCourseByTitle(courseName);
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
    }
}
