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
 * The type Employee.
 */
public abstract class Employee extends User implements Researcher {


    /**
     * The Department.
     */
    public String department;
    /**
     * The Salary.
     */
    public double salary;

    /**
     * The Is researcher.
     */
    public boolean isResearcher;


    /**
     * Instantiates a new Employee.
     */
    public Employee(){

    }

    /**
     * Instantiates a new Employee.
     *
     * @param name       the name
     * @param surname    the surname
     * @param password   the password
     * @param lang       the lang
     * @param department the department
     * @param salary     the salary
     */
    public Employee(String name, String surname, String password, LANGUAGES lang, String department, double salary){
        super(name, surname, password, lang);
        this.department = department;
        this.salary = salary;
        isResearcher = false;
    }

    /**
     * Gets department.
     *
     * @return the department
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Sets department.
     *
     * @param department the department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Is researcher boolean.
     *
     * @return the boolean
     */
    public boolean IsResearcher() {
        return this.isResearcher;
    }

    /**
     * Sets is researcher.
     *
     * @param isResearcher the is researcher
     */
    public void setIsResearcher(Boolean isResearcher) {
        this.isResearcher = isResearcher;
    }


    /**
     * Calculate salary double.
     *
     * @return the double
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

