package Task;

import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;

/**
 * @generated
 */
public class ResearhJournal {

    /**
     * @generated
     */
    private Vector<User> members;

    /**
     * @generated
     */
    private Vector<ResearchPaper> papers;

    public ResearhJournal() {
        this.members = new Vector<>();
        this.papers = new Vector<>();
    }

    /**
     * @generated
     */
    public Vector<User> getMembers() {
        return this.members;
    }

    /**
     * @generated
     */
    public void addMember(User member) {
        this.members.add(member);
    }

    /**
     * @generated
     */
    public void delMember(User member) {
        this.members.remove(member);
    }


    /**
     * @generated
     */
    public Vector<ResearchPaper> getPapers() {
        return this.papers;
    }

    /**
     * @generated
     */
    public void addPaper(ResearchPaper pape) {
        this.papers.add(pape);
    }

    /**
     * @generated
     */
    public void delPaper(ResearchPaper pape) {
        this.papers.remove(pape);
    }

}

