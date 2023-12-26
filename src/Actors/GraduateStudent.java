package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;

import java.io.IOException;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * The type Graduate student.
 */
public class GraduateStudent extends Student {
    /**
     * The Degree type.
     */
// Is used to determine is the student GraduateStudent
    public GRADUATE_STUDENT degreeType;
    /**
     * The Is researcher.
     */
    public boolean isResearcher;


    /**
     * Instantiates a new Graduate student.
     */
    public GraduateStudent(){

    }

    /**
     * Instantiates a new Graduate student.
     *
     * @param name           the name
     * @param surname        the surname
     * @param password       the password
     * @param lang           the lang
     * @param faculty        the faculty
     * @param diplomaProject the diploma project
     * @param degreeType     the degree type
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public GraduateStudent(String name, String surname,
                           String password, LANGUAGES lang, FACULTY faculty,
                           DiplomaProject diplomaProject, GRADUATE_STUDENT degreeType) throws IOException, ClassNotFoundException {
        super(name, surname, password, lang, faculty);
        this.degreeType = degreeType;
        this.isResearcher = true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GraduateStudent that = (GraduateStudent) o;
        return isResearcher == that.isResearcher && degreeType == that.degreeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), degreeType, isResearcher);
    }

    @Override
    public String toString() {
        return "GraduateStudent{" +
                "degreeType=" + degreeType +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
