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
import Main.*;

/**
 * @generated
 */
public class Dean extends Employee implements Researcher{

    private boolean isResearcher;
    public void sendMessageToSupport(MessageSupport messageSupport){
        DataBase dataBase = DataBase.getInstance();
        dataBase.addMessageToSupport(messageSupport);
    }

    public String checkStudent(Student student){
        return student.toString();
    }

    public MessageToDean getMessageToDean(){
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMessageToDean();
    }



    public void kickStudent(Student student){
        DataBase dataBase = DataBase.getInstance();
        dataBase.kickUser(student);
    }

    public void addStudent(Student student){
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
}
