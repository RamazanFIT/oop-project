package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;
import java.util.Comparator.*;
import Main.MessageToDean;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;


/**
 * @generated
 */
public class Manager extends Employee {

    /**
     * @generated
     */

    public boolean isResearcher;
    public ManagerType managerType;

    public Manager(){

    }

    public Manager(String name, String surname, String password, LANGUAGES lang, String department, double salary, ManagerType managerType){
        super(name, surname, password, lang, department, salary);
        this.managerType = managerType;
        isResearcher = false;
    }

    /**
     * @generated
     */
    public ManagerType getManagerType() {
        return this.managerType;
    }

    /**
     * @generated
     */
    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    public Vector<Student> getInfoStudents(Course course, Comparator compare) {
        Vector<Student> students = course.getStudents();
        Collections.sort(students, compare);
        return students;
    }


    public Vector<Teacher> getInfoTeachers(Course course, Comparator compare) {
        Vector<Teacher> teachers = course.getInstructors();
        Collections.sort(teachers, compare);
        return teachers;
    }

    public void addStudentToCourse(Student student, Course course){
        DataBase dataBase = DataBase.getInstance();
        course.addStudent(student);
        dataBase.addCourse(course);
//        проверено
    }

    public void addNews(News news){
        DataBase dataBase = DataBase.getInstance();
        dataBase.addNews(news);
    }

    public void removeNews(News news){
        DataBase dataBase = DataBase.getInstance();
        dataBase.removeNews(news);
    }

    @Override
    public boolean isResearcher() {
        return false;
    }

    @Override
    public void setResearcher(boolean isResearcher) {
        this.isResearcher = isResearcher;
    }
    public void sendMessageToDean(MessageToDean messageToDean){
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

