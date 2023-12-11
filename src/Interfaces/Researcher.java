package Interfaces;

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
public interface Researcher {

    /**
     * @generated
     */
    default public Vector<ResearchPaper> printPapers(Comparator comparator) {
        DataBase dataBase = DataBase.getInstance();
//        return dataBase.getResearchPaperOfStudent(this, comparator);
        // TODO
        return new Vector<ResearchPaper>();
    }

    default public Vector<ResearchPaper> printPapers() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getResearchPaper(this);
    }


    /**
     * @generated
     */
    default public int cntHIndex() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.calculateHIndexOfResearcher(this);
    }

    /**
     * @generated
     */
    default public Vector<ResearchProject> getProjects() {
        return this.getOwnProject();
    }

    /**
     * @generated
     */
    default public void addProject(ResearchProject project) throws ImposterException {
        DataBase dataBase = DataBase.getInstance();
        if(!project.getProjectParticipant().contains(project) ||
                !project.getSuperVisor().equals(this)){
            throw new ImposterException("ProjectParticipant not in project");
        }
        dataBase.addResearchProject(project);
    }

    /**
     * @generated
     */
    default public void delProject(ResearchProject project) {
        DataBase dataBase = DataBase.getInstance();
        dataBase.delResearchProject(project);
    }
    /**
     * @generated
     */
    default public Vector<ResearchPaper> getPapers() {
        return this.printPapers();
    }


    /**
     * @generated
     */
    default public void addPapers(ResearchPaper paper) throws ImposterException {
        DataBase dataBase = DataBase.getInstance();
        paper.setAuthor(this);
        dataBase.addResearchPaperToStudent(paper);
    }
    /**
     * @generated
     */
    default public void delPapers(ResearchPaper paper) throws ImposterException {
        DataBase dataBase = DataBase.getInstance();
        if(!paper.getAuthor().equals(this)) throw  new ImposterException("Can't delete'");
        dataBase.removeResearchPaperFromStudent(paper);
    }
    /**
     * @generated
     */
    default public Vector<ResearchProject> getOwnProject() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getResearcherProjects(this);
    }
    /**
     * @generated
     */
    public boolean isResearcher();

    public void setResearcher(boolean isResearcher);
}

