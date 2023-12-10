package Task;

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
public class Organization {

    /**
     * @generated
     */
    private Enums.Organization name;

    /**
     * @generated
     */
    private RoleOfOrganisation role;


    /**
     * @generated
     */
    private Student student;

    public Organization(Enums.Organization name, RoleOfOrganisation role, Student student) {
        this.name = name;
        this.role = role;
        this.student = student;
    }

    public Organization(Enums.Organization name, Student student){
        this.name = name;
        this.student = student;
        this.role = RoleOfOrganisation.MEMBER;
    }



    /**
     * @generated
     */
    public Enums.Organization getName() {
        return this.name;
    }

    /**
     * @generated
     */
    public void setName(Enums.Organization name) {
        this.name = name;
    }


    /**
     * @generated
     */
    public RoleOfOrganisation getRole() {
        return this.role;
    }

    /**
     * @generated
     */
    public void setRole(RoleOfOrganisation role) {
        this.role = role;
    }



    /**
     * @generated
     */
    public Student getStudent() {
        return this.student;
    }

    /**
     * @generated
     */
    public void setStudent(Student student) {
        this.student = student;
    }

}
