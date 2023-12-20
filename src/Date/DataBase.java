package Date;

import Actors.*;
import Enums.*;
import Exceptions.*;

import java.io.*;
import java.util.Comparator.*;

import Science.*;

import java.util.*;

import Interfaces.*;
import Date.*;
import Task.*;
import Main.*;
import Task.Organization;

import java.util.Timer;
import java.util.TimerTask;
import java.io.File;

/**
 * The type Data base.
 */
public class DataBase implements Serializable{
    /**
     * The Papers.
     */
//    private transient Timer timer;
    public  Vector<ResearchPaper> papers;
    /**
     * The Projects.
     */
    public  Vector<ResearchProject> projects;
    /**
     * The Courses.
     */
    public  Vector<Course> courses;
    /**
     * The Users.
     */
    public  Vector<User> users;
    /**
     * The Major on course.
     */
    public  TreeMap<FACULTY, Vector<Course>> majorOnCourse;
    /**
     * The Lessons on course.
     */
    public  TreeMap<Course, Vector<Lesson>> lessonsOnCourse;
    /**
     * The Message of support.
     */
    public  Vector<MessageSupport> messageOfSupport;
    /**
     * The Messages of user.
     */
    public  Vector<Message> messagesOfUser;
    /**
     * The Messages of dean.
     */
    public  Vector<MessageToDean> messagesOfDean;


    /**
     * The Diploma project.
     */
    public  TreeMap<DiplomaProject, Vector<Student>> diplomaProject;
    /**
     * The Organizations.
     */
    public  Vector<Task.Organization> organizations;
    /**
     * The Journals.
     */
    public  Vector<ResearhJournal> journals;
    /**
     * The News.
     */
    public  Vector<News> news;

    private static DataBase instance;

    private DataBase() throws IOException, ClassNotFoundException {
        papers = new Vector<ResearchPaper>();
        projects = new Vector<ResearchProject>();
        courses = new Vector<Course>();
        users = new Vector<User>();
        majorOnCourse = new TreeMap<FACULTY, Vector<Course>>();
        lessonsOnCourse = new TreeMap<Course, Vector<Lesson>>();
        messageOfSupport = new Vector<MessageSupport>();
        messagesOfUser = new Vector<Message>();
        messagesOfDean = new Vector<MessageToDean>();
        diplomaProject = new TreeMap<>();
        organizations = new Vector<>();
        journals = new Vector<>();
        news = new Vector<>();
//        scheduleSerialization();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized DataBase getInstance() throws IOException, ClassNotFoundException {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }


    public void saveToFile(String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
        }
    }

    public static void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            instance = (DataBase) in.readObject();
        }
    }



    /**
     * Gets user subscriptions.
     *
     * @param user the user
     * @return the user subscriptions
     */
    public Vector<ResearhJournal> getUserSubscriptions(User user) {
        Vector<ResearhJournal> result = new Vector<ResearhJournal>();
        for (int i = 0; i < journals.size(); i++) {
            if (journals.get(i).getMembers().contains(user)) {
                result.add(journals.get(i));
            }
        }
        return result; // TO TEST
    }

    /**
     * Gets user courses.
     *
     * @param user the user
     * @return the user courses
     */
    public Vector<Course> getUserCourses(User user) {
        Student student = (Student) (user);
        Vector<Course> result = new Vector<Course>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getStudents().contains(student)) {
                result.add(courses.get(i));
            }
        }
        return result; // TO TEST
    }

    /**
     * Gets mark of student.
     *
     * @param student the student
     * @return the mark of student
     */
    public TreeMap<Course, Grade> getMarkOfStudent(Student student) {
        TreeMap<Course, Grade> result = new TreeMap<Course, Grade>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getGrades().containsKey(student)) {
                result.put(courses.get(i), courses.get(i).getGrades().get(student));
            }
        }
        return result; // TO TEST
    }

    /**
     * Gets cnt of credit student.
     *
     * @param student the student
     * @return the cnt of credit student
     */
    public int getCntOfCreditStudent(Student student) {
        int cntOfCreditStudent = 0;
        Vector<Course> courseOfStudent = this.getUserCourses(student);
        for (Course c : courseOfStudent) {
            cntOfCreditStudent += c.getCredit();
        }
        return cntOfCreditStudent; // TO TEST
    }

    /**
     * Gets student organizations.
     *
     * @param student the student
     * @return the student organizations
     */
    public Vector<Task.Organization> getStudentOrganizations(Student student) {
        Vector<Task.Organization> result = new Vector<Organization>();
        for (int i = 0; i < organizations.size(); i++) {
            if (organizations.get(i).getStudent() == student) {
                result.add(organizations.get(i));
            }
        }

        return result; // TO TEST
    }

    /**
     * Sets organization to student.
     *
     * @param student      the student
     * @param organization the organization
     */
    public void setOrganizationToStudent(Student student, Enums.Organization organization) {
        if (!organizations.contains(new Task.Organization(organization, student))) {
            organizations.add(new Task.Organization(organization, student));
        } // TO TEST
    }

    /**
     * Sets organization to student.
     *
     * @param student      the student
     * @param organization the organization
     * @param role         the role
     */
    public void setOrganizationToStudent(Student student,
                                         Enums.Organization organization, RoleOfOrganisation role) {

        if (!organizations.contains(new Task.Organization(organization, role, student))) {
            organizations.add(new Task.Organization(organization, role, student));
        } // TO TEST
    }

    /**
     * Exists diploma project boolean.
     *
     * @param student the student
     * @return the boolean
     */
    public boolean existsDiplomaProject(Student student) {
        for (DiplomaProject project : diplomaProject.keySet()) {
            if (diplomaProject.get(project).contains(student)) {
                return true;
            }
        }
        return false; // TO TEST
    }


    /**
     * Add diploma project.
     *
     * @param project the project
     * @param student the student
     */
    public void addDiplomaProject(DiplomaProject project, Student student) {
        Vector<Student> v = new Vector<Student>();
        v.add(student);
        diplomaProject.put(project, v); // TO TEST
    }

    /**
     * Gets diploma project.
     *
     * @param student the student
     * @return the diploma project
     */
    public DiplomaProject getDiplomaProject(Student student) {
        for (DiplomaProject project : diplomaProject.keySet()) {
            if (diplomaProject.get(project).contains(student)) {
                return project;
            }
        }
        return null; // TO TEST
    }

    /**
     * Gets major courses of student.
     *
     * @param student the student
     * @return the major courses of student
     */
    public Vector<Course> getMajorCoursesOfStudent(Student student) {
        Vector<Course> courses = this.getUserCourses(student);
        Vector<Course> majorCourses = this.majorOnCourse.get(student.getFaculty());
        Vector<Course> result = new Vector<Course>();
        for (Course c : courses) {
            if (majorCourses.contains(c)) {
                result.add(c);
            }
        }
        return result; // TO TEST
    }

    /**
     * Gets minor courses of student.
     *
     * @param student the student
     * @return the minor courses of student
     */
    public Vector<Course> getMinorCoursesOfStudent(Student student) {
        Vector<Course> courses = this.getUserCourses(student);
        Vector<Course> majorCourses = this.getMajorCoursesOfStudent(student);
        Vector<Course> result = new Vector<Course>();
        for (Course c : courses) {
            if (!majorCourses.contains(c)) {
                result.add(c);
            }
        }
        return result; // TO TEST
    }

    /**
     * Gets researcher projects.
     *
     * @param researcher the researcher
     * @return the researcher projects
     */
    public Vector<ResearchProject> getResearcherProjects(Researcher researcher) {
        Vector<ResearchProject> studentProjects = new Vector<>();
        for (ResearchProject project : projects) {
            if (project.getProjectParticipant().contains(researcher)) {
                studentProjects.add(project);
            }
        }

        return studentProjects; // TO TEST
    }

    /**
     * Gets teacher info.
     *
     * @param course the course
     * @return the teacher info
     */
    public Vector<Teacher> getTeacherInfo(Course course) {
        Vector<Teacher> result = new Vector<Teacher>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).equals(course)) {
                result.addAll(course.getInstructors());
            }
        }
        return result; // TO TEST
    }

    /**
     * Gets research paper.
     *
     * @param researcher the researcher
     * @return the research paper
     */
    public Vector<ResearchPaper> getResearchPaper(Researcher researcher) {
        Vector<ResearchPaper> result = new Vector<ResearchPaper>();
        for (ResearchPaper paper : papers) {
            if (paper.getAuthor().equals(researcher)) {
                result.add(paper);
            }

        }
        return result; // TO TEST
    }

    /**
     * Add research paper to student.
     *
     * @param paper the paper
     */
    public void addResearchPaperToStudent(ResearchPaper paper) {
        papers.add(paper);
    }

    /**
     * Remove research paper from student.
     *
     * @param paper the paper
     */
    public void removeResearchPaperFromStudent(ResearchPaper paper) {
        if (papers.contains(paper)) {
            papers.remove(paper);
        }
    }

    /**
     * Add research project.
     *
     * @param researchProject the research project
     */
    public void addResearchProject(ResearchProject researchProject) {
        this.projects.add(researchProject);
    }

    /**
     * Del research project.
     *
     * @param researchProject the research project
     */
    public void delResearchProject(ResearchProject researchProject) {
        this.projects.remove(researchProject);
    }

    /**
     * Register student for course.
     *
     * @param course  the course
     * @param student the student
     * @throws ExceededCreditException the exceeded credit exception
     */
    public void registerStudentForCourse(Course course, Student student) throws ExceededCreditException {
        int maxCredit = 30;
        int sumCredit = course.getCredit();

        Vector<Course> coursesOfStudent = this.getUserCourses(student);
        for (Course course1 : coursesOfStudent) {
            sumCredit += course1.getCredit();
        }
        if (sumCredit >= maxCredit) {
            throw new ExceededCreditException("Exceeded credit limit");
        }
        for (Course course1 : courses) {
            if (course1.equals(course)) {
                if (!course1.getStudents().contains(student))
                    course1.addStudent(student);
            }
        }
    }


    /**
     * Calculate h index of researcher int.
     *
     * @param researcher the researcher
     * @return the int
     */
    public int calculateHIndexOfResearcher(Researcher researcher) {
        Vector<ResearchPaper> somePapers = this.getResearchPaper(researcher);
        Vector<ResearchProject> someProjects = this.getResearcherProjects(researcher);
        for (ResearchProject project : someProjects) {
            for (ResearchPaper paper : project.getPublishedPapers()) {
                if (!somePapers.contains(paper)) {
                    somePapers.add(paper);
                }
            }
        }
        Vector<Integer> citations = new Vector<Integer>();
        for (ResearchPaper paper : somePapers) {
            citations.add(paper.getCitation());
        }
        Collections.sort(citations);
        int hIndex = 0;
        for (int i = citations.size() - 1; i >= 0; i--) {
            int citation = citations.get(i);
            int rank = citations.size() - i;
            if (citation >= rank) {
                hIndex = rank;
            } else {
                break;
            }
        }
        return hIndex;
    }

    /**
     * Add message to user.
     *
     * @param message the message
     */
    public void addMessageToUser(Message message) {
        this.messagesOfUser.add(message);
    }

    /**
     * Gets messages of user.
     *
     * @param user the user
     * @return the messages of user
     */
    public Vector<Message> getMessagesOfUser(User user) {
        Vector<Message> result = new Vector<Message>();
        for (Message message : messagesOfUser) {
            if (message.getReceiver().equals(user)) {
                result.add(message);
            }
        }
        return result;
    }

    /**
     * Gets message which send user.
     *
     * @param user the user
     * @return the message which send user
     */
    public Vector<Message> getMessageWhichSendUser(User user) {
        Vector<Message> result = new Vector<Message>();
        for (Message message : messagesOfUser) {
            if (message.getSender().equals(user)) {
                result.add(message);
            }
        }
        return result;
    }

    /**
     * Gets teach course list.
     *
     * @param teacher the teacher
     * @return the teach course list
     */
    public Vector<Course> getTeachCourseList(Teacher teacher) {
        Vector<Course> result = new Vector<Course>();
        for (Course c : courses) {
            if (c.getInstructors().contains(teacher)) {
                result.add(c);
            }
        }
        return result;
    }

    /**
     * Add teacher to teach course.
     *
     * @param teacher the teacher
     * @param course  the course
     */
    public void addTeacherToTeachCourse(Teacher teacher, Course course) {
        for (Course c : courses) {
            if (c.equals(course)) {
                c.addInstructor(teacher);
                return;
            }
        }
    }

    /**
     * Put mark to student.
     *
     * @param student the student
     * @param grade   the grade
     * @param course  the course
     */
    public void putMarkToStudent(Student student, Grade grade, Course course) {
//        Vector<Course> coursesOfStudent = this.getUserCourses(student);
//        for(Course c : coursesOfStudent){
//            if(c.equals(course)){
//                c.setMarkToStudent(student, grade);
//                return;
//            }  // DO NOT DELEtE this method
//
    }

    /**
     * Add news.
     *
     * @param news the news
     */
    public void addNews(News news) {
        this.news.add(news);
    }

    /**
     * Remove news.
     *
     * @param news the news
     */
    public void removeNews(News news) {
        this.news.remove(news);
    }

    /**
     * Add message to support.
     *
     * @param message the message
     */
    public void addMessageToSupport(MessageSupport message) {
        if (!messageOfSupport.contains(message))
            messageOfSupport.add(message);
    }

    /**
     * Gets message to dean.
     *
     * @return the message to dean
     */
    public MessageToDean getMessageToDean() {
//        Collection.sort(messagesOfDean, comparatorOfUrgency);
        return messagesOfDean.get(0);
    }

    /**
     * Send message to dean.
     *
     * @param message the message
     */
    public void sendMessageToDean(MessageToDean message) {
        if (!messagesOfDean.contains(message)) {
            messagesOfDean.add(message);
        }
    }

    /**
     * Kick user.
     *
     * @param user the user
     */
    public void kickUser(User user) {
        Vector<Course> coursesToDelete = this.getUserCourses(user);
        for (Course c : coursesToDelete) {
            c.removeStudent((Student) user);
        }
        Vector<ResearchPaper> toRemove = this.getResearchPaper((Researcher) user);
        for (ResearchPaper paper : papers) {
            papers.remove(paper);
        }
        Vector<ResearchProject> projectsToDelete = this.getResearcherProjects((Researcher) user);
        for (ResearchProject project : projectsToDelete) {
            projects.remove(project);
        }
        Vector<Message> messagesToDelete = this.getMessagesOfUser(user);
        for (Message message : messagesToDelete) {
            this.messagesOfUser.remove(message);
        }
        messagesToDelete = this.getMessageWhichSendUser(user);
        for (Message message : messagesToDelete) {
            this.messagesOfUser.remove(message);
        }
        users.remove(user);
    }

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Gets message support.
     *
     * @return the message support
     */
    public MessageSupport getMessageSupport() {
//        Collections.sort(messageOfSupport, comparatorOfStatusOrder);
        return messageOfSupport.get(0);
    }

    /**
     * Gets members of diploma project.
     *
     * @param project the project
     * @return the members of diploma project
     */
    public Vector<Student> getMembersOfDiplomaProject(DiplomaProject project) {
        return diplomaProject.get(project);
    }

    /**
     * Add member to diploma project.
     *
     * @param project the project
     * @param student the student
     */
    public void addMemberToDiplomaProject(DiplomaProject project, Student student) {
        if(!diplomaProject.get(project).contains(student))
        diplomaProject.get(project).add(student);
    }

    /**
     * Add course.
     *
     * @param course the course
     */
    public void addCourse(Course course) {
        if(!courses.contains(course))
        this.courses.add(course);
    }

    /**
     * Add research journal.
     *
     * @param journal the journal
     */
    public void addResearchJournal(ResearhJournal journal) {
        if(!journals.contains(journal))
            this.journals.add(journal);
    }

}
