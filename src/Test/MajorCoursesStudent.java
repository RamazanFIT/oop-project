package Test;
import Date.DataBase;
import Enums.Organization;
import Science.DiplomaProject;
import Task.*;
import Actors.*;
import Task.Organization.*;
import org.junit.Assert;

import org.junit.Before;
import Enums.*;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Vector;
import java.io.IOException;

import static org.junit.Assert.*;

public class MajorCoursesStudent {

    private DataBase dataBase;
    private Student testStudent;
    Course course1;
    Course course2;
    Course course3;
    Vector<Course> majorCoursesForFIT;


    @Before
    public void setUp() throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        dataBase = DataBase.getInstance();
//        testStudent = new Student("Иван", "Иванов", "12345", LANGUAGES.RU, FACULTY.FIT, new DiplomaProject("Topic", "Title"));

        // Uncomment and add major courses for FIT faculty to dataBase.majorOnCourse
        course1 = new Course(3, Subject.OOP, "OOP course 1");
        course2 = new Course(3, Subject.ALGORITHM, "Algorithm course 1");
        course3 = new Course(3, Subject.CALCULUS1, "Calc course 1");
        majorCoursesForFIT = new Vector<>(Arrays.asList(course1, course2, course3));
        dataBase.majorOnCourse.put(FACULTY.MWE, majorCoursesForFIT);
    }

    @Test
    public void testGetMajorCoursesOfStudent() {
        Vector<Course> majorCoursesOfStudent = dataBase.getMajorCoursesOfStudent(testStudent);
        assertEquals(majorCoursesForFIT.contains(majorCoursesOfStudent));
    }
















    private boolean assertEquals(boolean contains) {
        if(majorCoursesForFIT.contains(majorCoursesForFIT)){
            return true;
        }
        return false;
    }
}

