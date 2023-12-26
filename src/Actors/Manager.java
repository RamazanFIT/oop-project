package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;

import java.io.IOException;
import java.util.Comparator.*;
import Main.MessageToDean;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;


/**
 * The type Manager.
 */
public class Manager extends Employee {

    /**
     * The Is researcher.
     */
    public boolean isResearcher;
    /**
     * The Manager type.
     */
    public ManagerType managerType;

    /**
     * Instantiates a new Manager.
     */
    public Manager(){

    }

    /**
     * Instantiates a new Manager.
     *
     * @param name        the name
     * @param surname     the surname
     * @param password    the password
     * @param lang        the lang
     * @param department  the department
     * @param salary      the salary
     * @param managerType the manager type
     */
    public Manager(String name, String surname, String password, LANGUAGES lang, String department, double salary, ManagerType managerType){
        super(name, surname, password, lang, department, salary);
        this.managerType = managerType;
        isResearcher = false;
    }

    /**
     * Gets manager type.
     *
     * @return the manager type
     */
    public ManagerType getManagerType() {
        return this.managerType;
    }

    /**
     * Sets manager type.
     *
     * @param managerType the manager type
     */
    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    /**
     * Gets info students.
     *
     * @param course  the course
     * @param compare the compare
     * @return the info students
     */
    public Vector<Student> getInfoStudents(Course course, Comparator compare) {
        Vector<Student> students = course.getStudents();
        Collections.sort(students, compare);
        return students;
    }


    /**
     * Gets info teachers.
     *
     * @param course  the course
     * @param compare the compare
     * @return the info teachers
     */
    public Vector<Teacher> getInfoTeachers(Course course, Comparator compare) {
        Vector<Teacher> teachers = course.getInstructors();
        Collections.sort(teachers, compare);
        return teachers;
    }

    /**
     * Add student to course.
     *
     * @param student the student
     * @param course  the course
     */
    public void addStudentToCourse(Student student, Course course) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        course.addStudent(student);
        dataBase.addCourse(course);
//        проверено
    }

    /**
     * Add news.
     *
     * @param news the news
     */
    public void addNews(News news) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.addNews(news);
    }

    /**
     * Remove news.
     *
     * @param news the news
     */
    public void removeNews(News news) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.removeNews(news);
    }

    public void addCourse(Course course) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.addCourse(course);
    }

    @Override
    public boolean isResearcher() {
        return false;
    }

    @Override
    public void setResearcher(boolean isResearcher) {
        this.isResearcher = isResearcher;
    }

    /**
     * Send message to dean.
     *
     * @param messageToDean the message to dean
     */
    public void sendMessageToDean(MessageToDean messageToDean) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.sendMessageToDean(messageToDean);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return isResearcher == manager.isResearcher && managerType == manager.managerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isResearcher, managerType);
    }

    public String toString(){
        return super.toString() + ", Manager type: " + managerType;
    }
}

