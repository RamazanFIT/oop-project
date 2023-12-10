package Date;

import Actors.*;
import Enums.*;
import Exceptions.*;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
import Main.*;
import Task.Organization;

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
        return result; // TO TEST
    }

    public Vector<Course> getUserCourses(User user){
        Student student = (Student)(user);
        Vector<Course> result = new Vector<Course>();
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getStudents().contains(student)){
                result.add(courses.get(i));
            }
        }
        return result; // TO TEST
    }

    public TreeMap<Course, Grade> getMarkOfStudent(Student student){
        TreeMap<Course, Grade> result = new TreeMap<Course, Grade>();
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getGrades().containsKey(student)){
                result.put(courses.get(i), courses.get(i).getGrades().get(student));
            }
        }
        return result; // TO TEST
    }

    public int getCntOfCreditStudent(Student student){
        int cntOfCreditStudent = 0;
        Vector<Course> courseOfStudent = this.getUserCourses(student);
        for(Course c : courseOfStudent){
            cntOfCreditStudent += c.getCredit();
        }
        return cntOfCreditStudent; // TO TEST
    }

    public Vector<Task.Organization> getStudentOrganizations(Student student){
        Vector<Task.Organization> result = new Vector<Organization>();
        for(int i = 0; i < organizations.size(); i++){
            if(organizations.get(i).getStudent() == student){
                result.add(organizations.get(i));
            }
        }

        return result; // TO TEST
    }

    public void setOrganizationToStudent(Student student, Enums.Organization organization){
        if(!organizations.contains(new Task.Organization(organization, student))){
            organizations.add(new Task.Organization(organization, student));
        } // TO TEST
    }

    public void setOrganizationToStudent(Student student,
         Enums.Organization organization, RoleOfOrganisation role){

        if(!organizations.contains(new Task.Organization(organization, role, student))){
            organizations.add(new Task.Organization(organization, role, student));
        } // TO TEST
    }

    public boolean existsDiplomaProject(Student student){
        for(DiplomaProject project : diplomaProject.keySet()){
            if(diplomaProject.get(project).contains(student)){
                return true;
            }
        }
        return false; // TO TEST
    }


    public void addDiplomaProject(DiplomaProject project, Student student){
        Vector<Student> v = new Vector<Student>();
        v.add(student);
        diplomaProject.put(project, v); // TO TEST
    }

    public DiplomaProject getDiplomaProject(Student student){
        for(DiplomaProject project : diplomaProject.keySet()){
            if(diplomaProject.get(project).contains(student)){
                return project;
            }
        }
        return null; // TO TEST
    }
    public Vector<Course> getMajorCoursesOfStudent(Student student){
        Vector<Course> courses = this.getUserCourses(student);
        Vector<Course> majorCourses = this.majorOnCourse.get(student.getFaculty());
        Vector<Course> result = new Vector<Course>();
        for(Course c : courses){
            if(majorCourses.contains(c)){
                result.add(c);
            }
        }
        return result; // TO TEST
    }
    
    public Vector<Course> getMinorCoursesOfStudent(Student student){
        Vector<Course> courses = this.getUserCourses(student);
        Vector<Course> majorCourses = this.getMajorCoursesOfStudent(student);
        Vector<Course> result = new Vector<Course>();
        for(Course c : courses){
            if(!majorCourses.contains(c)){
                result.add(c);
            }
        }
        return result; // TO TEST
    }
    
    public Vector<ResearchProject> getStudentProjects(Student student) {
        Vector<ResearchProject> studentProjects = new Vector<>();
        for (ResearchProject project : projects) {
            if (project.getProjectParticipant().contains(student)) {
                studentProjects.add(project);
            }
        }

        return studentProjects; // TO TEST
    }

    public Vector<Teacher> getTeacherInfo(Course course){
        Vector<Teacher> result = new Vector<Teacher>();
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).equals(course)){
                result.addAll(course.getInstructors());
            }
        }
        return result; // TO TEST
    }

    public Vector<ResearchPaper> getResearchPaperOfStudent(Researcher researcher){
        Vector<ResearchPaper> result = new Vector<ResearchPaper>();
        for(ResearchPaper paper : papers){
            if(paper.getAuthor().equals(researcher)){
                result.add(paper);
            }

        }
        return result; // TO TEST
    }

    public void addResearchPaperToStudent(ResearchPaper paper){
        papers.add(paper);
    }
    
    public void removeResearchPaperFromStudent(ResearchPaper paper) {
        if (papers.contains(paper)) {
            papers.remove(paper);
        }
    }


































































}
