package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * The Admin class extends the Employee class
 */
public class Admin extends Employee{

    /**
     * The isResearcher field is used to determine whether the user is a researcher or not
     */
    public boolean isResearcher;

    /**
     * Default constructor for Admin
     */
    public Admin(){

    }

    /**
     * Parameterized constructor for Admin
     */
    public Admin(String name, String surname, String password, LANGUAGES lang, String department, double salary){
        super(name, surname, password, lang, department, salary);
        isResearcher = false;
    }

    /**
     * The seeLogAboutUser method allows viewing the user's log
     */
    public Vector<String> seeLogAboutUser(User user) throws NotAutorizedException {
        return user.getLogFiles();
    }

    /**
     * The removeUser method removes a user
     */
    public void removeUser(User user){
        DataBase dataBase = DataBase.getInstance();
        dataBase.kickUser(user);
    }

    /**
     * The UpdateUser method updates a user's data
     */
    public void UpdateUser(User oldUser, User newUser) throws NotAutorizedException {
        oldUser.changeToNewDataOfUser(newUser);
    }

    /**
     * The addUser method adds a user
     */
    public void addUser(User user){
        DataBase dataBase = DataBase.getInstance();
        dataBase.addUser(user);
    }

    /**
     * The isResearcher method checks if the user is a researcher
     */
    @Override
    public boolean isResearcher() {
        return false;
    }

    /**
     * The setResearcher method sets the isResearcher field
     */
    @Override
    public void setResearcher(boolean isResearcher) {
        this.isResearcher = isResearcher;
    }

    /**
     * The equals method checks if two Admin objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return isResearcher == admin.isResearcher;
    }

    /**
     * The hashCode method returns the hash code of the Admin object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isResearcher);
    }

    /**
     * The toString method returns the string representation of the Admin object
     */
    public String toString(){
        return super.toString();
    }


}
