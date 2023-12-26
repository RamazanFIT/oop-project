package Interfaces;

import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * The interface Researcher.
 */
public interface Researcher extends Serializable {

    /**
     * Print papers vector.
     *
     * @param comparator the comparator
     * @return the vector
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    default public Vector<ResearchPaper> printPapers(Comparator comparator) throws IOException, ClassNotFoundException {
        Vector<ResearchPaper> result = this.printPapers();
        Collections.sort(result, comparator);
        return result;
    }

    /**
     * Print papers vector.
     *
     * @return the vector
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    default public Vector<ResearchPaper> printPapers() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getResearchPaper(this);
    }


    /**
     * Cnt h index int.
     *
     * @return the int
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    default public int cntHIndex() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.calculateHIndexOfResearcher(this);
    }

    /**
     * Gets projects.
     *
     * @return the projects
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    default public Vector<ResearchProject> getProjects() throws IOException, ClassNotFoundException {
        return this.getOwnProject();
    }

    /**
     * Add project.
     *
     * @param project the project
     * @throws ImposterException      the imposter exception
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    default public void addProject(ResearchProject project) throws ImposterException, IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        if(!project.getProjectParticipant().contains(project) ||
                !project.getSuperVisor().equals(this)){
            throw new ImposterException("ProjectParticipant not in project");
        }
        dataBase.addResearchProject(project);
    }

    /**
     * Del project.
     *
     * @param project the project
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    default public void delProject(ResearchProject project) throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.delResearchProject(project);
    }

    /**
     * Gets papers.
     *
     * @return the papers
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    default public Vector<ResearchPaper> getPapers() throws IOException, ClassNotFoundException {
        return this.printPapers();
    }


    /**
     * Add papers.
     *
     * @param paper the paper
     * @throws ImposterException      the imposter exception
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    default public void addPapers(ResearchPaper paper) throws ImposterException, IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        paper.setAuthor(this);
        dataBase.addResearchPaperToStudent(paper);
    }

    /**
     * Del papers.
     *
     * @param paper the paper
     * @throws ImposterException      the imposter exception
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    default public void delPapers(ResearchPaper paper) throws ImposterException, IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        if(!paper.getAuthor().equals(this)) throw  new ImposterException("Can't delete'");
        dataBase.removeResearchPaperFromStudent(paper);
    }

    /**
     * Gets own project.
     *
     * @return the own project
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    default public Vector<ResearchProject> getOwnProject() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getResearcherProjects(this);
    }

    /**
     * Is researcher boolean.
     *
     * @return the boolean
     */
    public boolean isResearcher();

    /**
     * Sets researcher.
     *
     * @param isResearcher the is researcher
     */
    public void setResearcher(boolean isResearcher);

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName();
}

