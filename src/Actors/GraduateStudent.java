package Actors;

import Actors.*;
import Enums.*;
import Exceptions.*;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

public class GraduateStudent extends Student {
    // Is used to determine is the student GraduateStudent
    public GRADUATE_STUDENT degreeType;
    public ResearchProject researchProject;
    public boolean isResearcher;


    public GraduateStudent(){

    }

    public GraduateStudent(String name, String surname, String password, LANGUAGES lang, FACULTY faculty, DiplomaProject diplomaProject, GRADUATE_STUDENT degreeType, ResearchProject researchProject){
        super(name, surname, password, lang, faculty, diplomaProject);
        this.degreeType = degreeType;
        this.researchProject = researchProject;
        isResearcher = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GraduateStudent that = (GraduateStudent) o;
        return isResearcher == that.isResearcher && degreeType == that.degreeType && Objects.equals(researchProject, that.researchProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), degreeType, researchProject, isResearcher);
    }

    public String toString(){
        return super.toString() + ", degree type: " + degreeType + ", research project: " + researchProject;
    }
}
