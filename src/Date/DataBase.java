package Date;

import Task.Organization;
import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

public class DataBase {
//    Vector<ResearchPaper> papers;
//    Vector<ResearchProject> projects;
//    Vector<Course> courses;
//    Vector<User> users;
//    TreeMap<faculty, Vector<Course>> majorOnCourse;
//    TreeMap<Course, Vector<lesson>> lessonsOnCourse;
//    Queue<MessageSupport> messageOfSupport;
//    TreeMap<User, Vector<Message>> messagesOfUser;
//    TreeMap<DiplomaProject, Vector<Student>> diplomaProject;
    Vector<Task.Organization> organizations;
    private static DataBase instance = new DataBase();
    private DataBase(){

    }
    public DataBase getInstance(){
        return instance;
    }


}
