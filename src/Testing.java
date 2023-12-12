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
    public static void main(String[] args) {
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
        DataBase.getInstance().addCourse(course);
        manager.addStudentToCourse(student, course);

//        System.out.println(course.getStudents());
        Teacher teacher = new Teacher("Ayazhan", "Some", "1212", LANGUAGES.EN, "calc",
                1000, Subject.ALGORITHM, TeacherRole.LECTOR);
        teacher.putMark(student, new Grade(100, "A"), course);
        System.out.println(student.getTranscript().getGpa());


    }


}
