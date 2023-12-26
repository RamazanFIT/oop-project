package Science;

import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * The type Diploma project.
 */
public class DiplomaProject implements Comparable<DiplomaProject>, Serializable {

    private String topic;
    private String title;

    /**
     * Instantiates a new Diploma project.
     *
     * @param topic the topic
     * @param title the title
     */
    public DiplomaProject(String topic, String title) {
        this.topic = topic;
        this.title = title;
    }

    /**
     * Gets topic.
     *
     * @return the topic
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * Sets topic.
     *
     * @param topic the topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }


    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Gets members.
     *
     * @return the members
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public Vector<Student> getMembers() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMembersOfDiplomaProject(this);
    }

    /**
     * Add member.
     *
     * @param member the member
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void addMember(Student member) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.addMemberToDiplomaProject(this, member);
    }

    @Override
    public int compareTo(DiplomaProject o) {
        if(this.topic.compareTo(o.getTopic()) != 0){
            return this.topic.compareTo(o.getTopic());
        }
        return this.title.compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return "DiplomaProject{" +
                "topic='" + topic + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

