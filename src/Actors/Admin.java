package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
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
    private boolean isResearcher;

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
}
