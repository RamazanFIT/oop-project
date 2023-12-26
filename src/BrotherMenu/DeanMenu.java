package BrotherMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Actors.Student;
import Date.DataBase;
import Actors.*;
import Enums.*;
import Exceptions.*;

import java.io.IOException;
import java.lang.System;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
import Main.*;


/**
 * The type Dean menu.
 */
public class DeanMenu {
    private Dean dean;
    private DataBase dataBase;
    private BufferedReader reader;

    /**
     * Instantiates a new Dean menu.
     *
     * @param dean the dean
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public DeanMenu(Dean dean) throws IOException, ClassNotFoundException {
        this.dean = dean;
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
        String menuOptions = "\nWelcome, Dean! " + """
                \n d1. View information about Dean
                d2. Send message to support
                d3. Check student
                d4. Get message to Dean
                d5. Kick student
                d6. Add student
                d7. Next command
                0. exit
                """;
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menuOptions);
            String option = reader.readLine();
            switch (option) {
                case "d1":
                    System.out.println("Welcome: " + dean);
                    break;
                case "d2":
                    sendMessageToSupport();
                    break;
                case "d3":
                    checkStudent();
                    break;
                case "d4":
                    getMessageToDean();
                    break;
                case "d5":
                    kickStudent();
                    break;
                case "d6":
                    addStudent();
                    break;
                case "d7":
                    isRunning = false;
                    System.out.println("Logged out successfully.");
                    DataBase.getInstance().saveToFile("data.ser");
                    break;
                case "0":
                    isRunning = false;
                    System.out.println("Logged out successfully.");
                    DataBase.getInstance().saveToFile("data.ser");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Send message to support.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void sendMessageToSupport() throws IOException, ClassNotFoundException {
        System.out.println("Enter the message to support: ");
        String messageText = reader.readLine();
        MessageSupport messageSupport = new MessageSupport();
        messageSupport.setMessage(messageText);
        dataBase.addMessageToSupport(messageSupport);
        System.out.println("Successfully sent message to support.");
    }

    /**
     * Check student.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void checkStudent() throws IOException, ClassNotFoundException {
        System.out.println("Enter the student name: ");
        String name = reader.readLine();
        System.out.println("Enter the student surname: ");
        String surname = reader.readLine();
        String studentInfo = dean.checkStudent((Student)dataBase.getUser(name, surname));
        System.out.println(studentInfo);
    }

    /**
     * Gets message to dean.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void getMessageToDean() throws IOException, ClassNotFoundException {
        MessageToDean messageToDean = dean.getMessageToDean();
        if (messageToDean != null) {
            System.out.println("Urgency Level: " + messageToDean.getLevel());
            System.out.println("Message: " + messageToDean.getMessage());
        } else {
            System.out.println("No messages for Dean.");
        }
    }

    /**
     * Kick student.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void kickStudent() throws IOException, ClassNotFoundException {
        System.out.println("Enter the student name: ");
        String name = reader.readLine();
        System.out.println("Enter the student surname: ");
        String surname = reader.readLine();
        dean.kickStudent((Student)dataBase.getUser(name, surname));
        System.out.println("Successfully kicked student.");
    }

    /**
     * Add student.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void addStudent() throws IOException, ClassNotFoundException {
        System.out.println("Enter the student name: ");
        String name = reader.readLine();
        System.out.println("Enter the student surname: ");
        String surname = reader.readLine();
        System.out.println("Enter the student password: ");
        String password = reader.readLine();
        Student student = new Student(name, surname, password, LANGUAGES.EN);
        StudentMenu sm = new StudentMenu(student);
        sm.setF();
        dean.addStudent(student);
        System.out.println("Successfully added student.");
    }
}
