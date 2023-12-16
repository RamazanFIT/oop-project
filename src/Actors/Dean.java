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

    public boolean isResearcher;

    public Dean(){

    }

    public Dean(String name, String surname, String password, LANGUAGES lang, String department, double salary){
        super(name, surname, password, lang, department, salary);
        isResearcher = false;
    }
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
