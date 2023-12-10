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
    public String printPapers(Comparator comparator);

    /**
     * @generated
     */
    public int cntHIndex();

    /**
     * @generated
     */
    public Vector<ResearchProject> getProjects();

    /**
     * @generated
     */
    public void addProject(ResearchProject project);


    /**
     * @generated
     */
    public void delProject(ResearchProject project);

    /**
     * @generated
     */
    public Vector<ResearchPaper> getPapers();

    /**
     * @generated
     */
    public void addPapers(ResearchPaper paper);

    /**
     * @generated
     */
    public void delPapers(ResearchPaper paper);

    /**
     * @generated
     */
    public Vector<ResearchProject> getOwnProject();

    /**
     * @generated
     */
    public boolean isResearcher();

    public void setResearcher(boolean isResearcher);
}

