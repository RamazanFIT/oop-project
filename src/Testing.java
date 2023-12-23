import Actors.*;
import Enums.*;
import Exceptions.*;

import java.io.IOException;
import java.util.Comparator.*;

import Main.Message;
import Science.*;

import java.util.*;

import Interfaces.*;
import Date.*;
import Task.*;

import javax.xml.crypto.Data;

/**
 * The type Testing.
 */
public class Testing {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws NotAutorizedException  the not autorized exception
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void main(String[] args) throws NotAutorizedException, IOException, ClassNotFoundException {
        DataBase dataHolder = DataBase.getInstance();
        Manager manager = new Manager("ramazan", "syrlybay", "1234",
                LANGUAGES.EN, "some",
                12.11, ManagerType.OR);
        DiplomaProject diplomaProject = new DiplomaProject("algo", "datastoring");
        Student student = new Student("rustem",
                "syrlybau",
                "12345",
                LANGUAGES.EN,
                FACULTY.FIT,
                diplomaProject);
        Student student2 = new Student("dinara",
                "syrlybayeva",
                "12345",
                LANGUAGES.EN,
                FACULTY.FIT,
                diplomaProject);
        student2.login("12345");
        Course course = new Course(5, Subject.ALGORITHM, "work hard");
        manager.addStudentToCourse(student, course);

        System.out.println(course.getStudents());
        Teacher teacher = new Teacher("Ayazhan", "Some", "1212", LANGUAGES.EN, "calc",
                1000, Subject.ALGORITHM, TeacherRole.LECTOR);
        teacher.putMark(student, 1000, course, Attestation.FIRST);
        System.out.println(student.getTranscript().getGpa());
        TreeMap<Course, Grade> f = student.getTranscript().getCourseGrades();
        for(Course c : f.keySet()){
            System.out.println(c + " grade: " + f.get(c));
        }
        student.login("12345");
        System.out.println(student.getIsActive());
//        student.logout();
        System.out.println(student.getLogFiles());
        ResearhJournal journal1 = new ResearhJournal("TIMES");
        ResearhJournal journal2 = new ResearhJournal("New Cour");
        ResearhJournal journal3 = new ResearhJournal("Fan out");
        student.subcribeToJournal(journal1);
        student.subcribeToJournal(journal2);
        student.subcribeToJournal(journal3);
        student.subcribeToJournal(journal3);
        student.cancelSubscriptions(journal1);
        student2.subcribeToJournal(journal3);
        student2.cancelSubscriptions(journal3);

        System.out.println(student.getSubscriptions());

        System.out.println(student2.getSubscriptions());
        System.out.println(student.getLogFiles(3));
        student.sendMessage(student2, "hillo");
        student.sendMessage(student2, "how are you?");
        System.out.println(student2.getMessage());

        teacher.setResearcher(true);
        ResearchPaper rp1 = new ResearchPaper("some learning", teacher, 12, 13, "22bd");
        DataBase.getInstance().users.add(student);
        System.out.println(rp1.getCitation());
        System.out.println(rp1.getCitation(Format.Bibtex));
        System.out.println(rp1.getCitation(Format.PlainText));
        dataHolder.saveToFile("data.ser");
//            DataBase.loadFromFile("data.ser");
//        DataBase newDataManager = DataBase.getInstance();
//            System.out.println(newDataManager.courses);

    }


}
