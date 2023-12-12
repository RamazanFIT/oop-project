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
 * @generated
 */
public class Admin extends Employee {

    /**
     * This field is used to describe the User is a researcher?
     */
    public boolean isResearcher;

    public Admin(){

    }

    public Admin(String name, String surname, String password, LANGUAGES lang, String department, double salary){
        super(name, surname, password, lang, department, salary);
        isResearcher = false;
    }

    /**
     * @generated
     */
    public Vector<String> seeLogAboutUser(User user) throws NotAutorizedException {
        return user.getLogFiles();
    }

    /**
     * @generated
     */
    public void removeUser(User user){
        DataBase dataBase = DataBase.getInstance();
        dataBase.kickUser(user);
    }

    /**
     * @generated
     */
    public void UpdateUser(User oldUser, User newUser) throws NotAutorizedException {
        oldUser.changeToNewDataOfUser(newUser);
    }

    /**
     * @generated
     */
    public void addUser(User user){
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
