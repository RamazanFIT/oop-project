package Science;

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
public class DiplomaProject implements Comparable<DiplomaProject>{

    /**
     * @generated
     */
    private String topic;

    /**
     * @generated
     */
    private String title;

    public DiplomaProject(String topic, String title) {
        this.topic = topic;
        this.title = title;
    }

    /**
     * @generated
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * @generated
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }


    /**
     * @generated
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @generated
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * @generated
     */
    public Vector<Student> getMembers() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMembersOfDiplomaProject(this);
    }

    /**
     * @generated
     */
    public void addMember(Student member) {
        DataBase dataBase = DataBase.getInstance();
        dataBase.addMemberToDiplomaProject(this, member);
    }

    @Override
    public int compareTo(DiplomaProject o) {
        return 0;
    }
}

