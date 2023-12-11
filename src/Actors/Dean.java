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

public class Dean extends Employee implements Researcher{
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
        // TODO
    }

    public void addStudent(Student student){
        // TODO
    }


    @Override
    public boolean isResearcher() {
        return false;
    }

    @Override
    public void setResearcher(boolean isResearcher) {

    }
}
