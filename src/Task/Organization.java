package Task;

import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;

import java.io.Serializable;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * The type Organization.
 */
public class Organization implements Serializable, Comparable<Organization> {

    private Enums.Organization name;

    private RoleOfOrganisation role;


    private Student student;

    /**
     * Instantiates a new Organization.
     *
     * @param name    the name
     * @param role    the role
     * @param student the student
     */
    public Organization(Enums.Organization name, RoleOfOrganisation role, Student student) {
        this.name = name;
        this.role = role;
        this.student = student;
    }

    /**
     * Instantiates a new Organization.
     *
     * @param name    the name
     * @param student the student
     */
    public Organization(Enums.Organization name, Student student){
        this.name = name;
        this.student = student;
        this.role = RoleOfOrganisation.MEMBER;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public Enums.Organization getName() {
        return this.name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(Enums.Organization name) {
        this.name = name;
    }


    /**
     * Gets role.
     *
     * @return the role
     */
    public RoleOfOrganisation getRole() {
        return this.role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(RoleOfOrganisation role) {
        this.role = role;
    }


    /**
     * Gets student.
     *
     * @return the student
     */
    public Student getStudent() {
        return this.student;
    }

    /**
     * Sets student.
     *
     * @param student the student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int compareTo(Organization o) {
        return this.name.compareTo(o.getName());
    }
}
