package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;

import java.io.IOException;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
import Main.*;

/**
 * The type Dean.
 */
public class Dean extends Employee implements Researcher{

    /**
     * The Is researcher.
     */
    public boolean isResearcher;

    /**
     * Instantiates a new Dean.
     */
    public Dean(){

    }

    /**
     * Instantiates a new Dean.
     *
     * @param name       the name
     * @param surname    the surname
     * @param password   the password
     * @param lang       the lang
     * @param department the department
     * @param salary     the salary
     */
    public Dean(String name, String surname, String password, LANGUAGES lang, String department, double salary){
        super(name, surname, password, lang, department, salary);
        isResearcher = false;
    }

    /**
     * Send message to support.
     *
     * @param messageSupport the message support
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void sendMessageToSupport(MessageSupport messageSupport) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.addMessageToSupport(messageSupport);
    }

    /**
     * Check student string.
     *
     * @param student the student
     * @return the string
     */
    public String checkStudent(Student student){
        return student.toString();
    }

    /**
     * Get message to dean message to dean.
     *
     * @return the message to dean
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public MessageToDean getMessageToDean() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMessageToDean();
    }


    /**
     * Kick student.
     *
     * @param student the student
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void kickStudent(Student student) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.kickUser(student);
    }

    /**
     * Add student.
     *
     * @param student the student
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void addStudent(Student student) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.addUser(student);
    }


    @Override
    public boolean isResearcher() {
        return false;
    }

    @Override
    public void setResearcher(boolean isResearcher) {
        this.isResearcher = isResearcher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dean dean = (Dean) o;
        return isResearcher == dean.isResearcher;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isResearcher);
    }

    public String toString(){
        return super.toString();
    }

}
