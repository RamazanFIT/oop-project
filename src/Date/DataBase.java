package Date;

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

public class DataBase {
    public Vector<ResearchPaper> papers;
    public Vector<ResearchProject> projects;
    public Vector<Course> courses;
    public Vector<User> users;
    public TreeMap<FACULTY, Vector<Course>> majorOnCourse;
    public TreeMap<Course, Vector<Lesson>> lessonsOnCourse;
    public Queue<MessageSupport> messageOfSupport;
    public TreeMap<User, Vector<Message>> messagesOfUser;
    public TreeMap<DiplomaProject, Vector<Student>> diplomaProject;
    public Vector<Task.Organization> organizations;
    public Vector<ResearhJournal> journals;
    private static DataBase instance = new DataBase();
    private DataBase(){

    }
    public static DataBase getInstance(){
        return instance;
    }

    public Vector<ResearhJournal> getUserSubscriptions(User user){
        Vector<ResearhJournal> result = new Vector<ResearhJournal>();
        for(int i = 0; i < journals.size(); i++){
            if(journals.get(i).getMembers().contains(user)){
                result.add(journals.get(i));
            }
        }
        return result;
    }

}
