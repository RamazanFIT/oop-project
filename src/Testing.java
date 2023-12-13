import Actors.*;
import Enums.*;
import Exceptions.*;

import java.util.Comparator.*;

import Science.*;

import java.util.*;

import Interfaces.*;
import Date.*;
import Task.*;

public class Testing {
    public static void main(String[] args) throws NotAutorizedException {
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
        Course course = new Course(5, Subject.ALGORITHM, "work hard");
        manager.addStudentToCourse(student, course);

//        System.out.println(course.getStudents());
        Teacher teacher = new Teacher("Ayazhan", "Some", "1212", LANGUAGES.EN, "calc",
                1000, Subject.ALGORITHM, TeacherRole.LECTOR);
        teacher.putMark(student, new Grade(70), course);
//        System.out.println(student.getTranscript().getGpa());
        TreeMap<Course, Grade> f = student.getTranscript().getCourseGrades();
//        for(Course c : f.keySet()){
//            System.out.println(c + " grade: " + f.get(c));
//        }
        student.login("12345");
//        System.out.println(student.getIsActive());
//        student.logout();
//        System.out.println(student.getLogFiles());
        ResearhJournal journal1 = new ResearhJournal();

    }


}
