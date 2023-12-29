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

import java.util.TreeMap;
import java.util.Vector;
import java.io.IOException;

import static org.junit.Assert.*;


public class    DataBaseTest {
    private DataBase dataBase;
    private ResearhJournal journalSubscribed;
    private ResearhJournal journalNotSubscribed;
    private User testUser;
    private Student testStudent;
    private Course courseSubscribed;
    private Course courseNotSubscribed;

    private DiplomaProject diplomaProject;
    private Student studentD1;
    private Student studentD2;
    private Course course;
    private Student student;


    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // Инициализация базы данных
        dataBase = DataBase.getInstance();

        // Создание анонимного класса User, так как User является абстрактным
        testUser = new User("Иван", "Иванов", "12334", LANGUAGES.RU) {};

        // Инициализация журналов
        journalSubscribed = new ResearhJournal();
        journalSubscribed.addMember(testUser);
        journalNotSubscribed = new ResearhJournal();

        // Добавление журналов в базу данных
        dataBase.journals.add(journalSubscribed);
        dataBase.journals.add(journalNotSubscribed);

    }




    @Test
    public void testAddMember() throws IOException, ClassNotFoundException {
        diplomaProject.addMember(studentD1);
        diplomaProject.addMember(studentD2);

        Vector<Student> members = diplomaProject.getMembers();

        assertTrue("Student should be a member of the diploma project", members.contains(studentD1));
        assertTrue("Student should be a member of the diploma project", members.contains(studentD2));

    }



    @Test
    public void testGetUserSubscriptions() {
        //Действие: получить список подписок пользователей.
        Vector<ResearhJournal> subscriptions = dataBase.getUserSubscriptions(testUser);

        // Assert:// Утверждаем: подписанный журнал есть в списке, а неподписанный нет
        assertTrue("The subscriptions should contain the journal user is subscribed to",
                subscriptions.contains(journalSubscribed));
        assertFalse("The subscriptions should not contain journals the user is not subscribed to",
                subscriptions.contains(journalNotSubscribed));
    }

    @Test
    public void getUserCourses_ShouldReturnCoursesForUser(){

        Vector<Course> courses = dataBase.getUserCourses(testStudent);
        assertTrue("The list of courses must respect the course in which the student is enrolled.",
                courses.contains(courseSubscribed));
        assertFalse("The list of courses should not contain courses for which the student is not enrolled.",
                courses.contains(courseNotSubscribed));
    }

    @Test
    public void  getCntOfCreditStudent_ShouldReturnTotalCreditsOfStudent(){
        Vector<Course> courses = dataBase.getUserCourses(testStudent);
        int calculatedCredits = 0;
        for (Course c : courses) {
            int courseCredits = c.getCredit();
            calculatedCredits += courseCredits;
        }
        int totalCredits = dataBase.getCntOfCreditStudent(testStudent);

        Assert.assertEquals("The total credits of the student should be equal to the credits of the course they are enrolled in."
                ,calculatedCredits, totalCredits);
    }

    @Test
    public void testGetMarkStudent(){
        Grade grade1 = new Grade(23,25,34);

        courseSubscribed.getGrades().put(testStudent,grade1);

        TreeMap<Course,Grade> studentGrade = dataBase.getMarkOfStudent(testStudent);

        assertEquals(grade1,studentGrade.get(courseSubscribed));
//        assertNull("The student's grades should not include the grade for the non-subscribed course (null));", studentGrade.get(courseNotSubscribed));
    }





}
