package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
/**
 * @generated
 */
public abstract class Employee extends User implements Researcher {


    /**
     * @generated
     */
    private String department;
    private double salary;

    /**
     * @generated
     */
    private boolean isResearcher;

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


}

