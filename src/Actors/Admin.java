package Actors;

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
 * The type Admin.
 */
public class Admin extends Employee{

    /**
     * The Is researcher.
     */
    public boolean isResearcher;

    /**
     * Instantiates a new Admin.
     */
    public Admin(){

    }

    /**
     * Instantiates a new Admin.
     *
     * @param name       the name
     * @param surname    the surname
     * @param password   the password
     * @param lang       the lang
     * @param department the department
     * @param salary     the salary
     */
    public Admin(String name, String surname, String password,
                 LANGUAGES lang, String department, double salary){
        super(name, surname, password, lang, department, salary);
        isResearcher = false;
    }

    /**
     * See log about user vector.
     *
     * @param user the user
     * @return the vector
     * @throws NotAutorizedException the not autorized exception
     */
    public Vector<String> seeLogAboutUser(User user) throws NotAutorizedException {
        return user.getLogFiles();
    }

    /**
     * Remove user.
     *
     * @param user the user
     */
    public void removeUser(User user) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.kickUser(user);
    }

    /**
     * Update user.
     *
     * @param oldUser the old user
     * @param newUser the new user
     * @throws NotAutorizedException the not autorized exception
     */
    public void UpdateUser(User oldUser, User newUser) throws NotAutorizedException {
        oldUser.changeToNewDataOfUser(newUser);
    }

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.addUser(user);
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
        Admin admin = (Admin) o;
        return isResearcher == admin.isResearcher;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isResearcher);
    }

    public String toString(){
        return super.toString();
    }


}
