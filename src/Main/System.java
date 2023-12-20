package Main;

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
 * The type System.
 */
public class System implements Serializable {


    /**
     * Print all research papers vector.
     *
     * @return the vector
     */
    public Vector<ResearchPaper> printAllResearchPapers() {
        //TODO
        return new Vector<ResearchPaper>();
    }

    /**
     * Print all research papers vector.
     *
     * @param comparator the comparator
     * @return the vector
     */
    public Vector<ResearchPaper> printAllResearchPapers(Comparator comparator) {
        //TODO
        return new Vector<ResearchPaper>();
    }

    /**
     * Print top cited researchers vector.
     *
     * @param comparator the comparator
     * @return the vector
     */
    public Vector<Researcher> printTopCitedResearchers(Comparator comparator) {
        return new Vector<Researcher>();
    }

    /**
     * Print researchers vector.
     *
     * @param comparator the comparator
     * @return the vector
     */
    public Vector<Researcher> printResearchers(Comparator comparator) {
        return new Vector<Researcher>();
    }
}
