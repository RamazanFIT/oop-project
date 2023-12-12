package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
/**
 * @generated1
 */
public abstract class Employee extends User implements Researcher {


    /**
     * @generated
     */
    public String department;
    public double salary;

    /**
     * @generated
     */
    public boolean isResearcher;


    public Employee(){

    }
    public Employee(String name, String surname, String password, LANGUAGES lang, String department, double salary){
        super(name, surname, password, lang);
        this.department = department;
        this.salary = salary;
        isResearcher = false;
    }

    /**
     * @generated
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * @generated
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @generated
     */
    public boolean IsResearcher() {
        return this.isResearcher;
    }

    /**
     * @generated
     */
    public void setIsResearcher(Boolean isResearcher) {
        this.isResearcher = isResearcher;
    }


    /**
     * @generated
     */
    public double calculateSalary() {
        //TODO
        return this.salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && isResearcher == employee.isResearcher && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department, salary, isResearcher);
    }

    public String toString(){
        return super.toString() + ", Department: " + department;
    }
}

