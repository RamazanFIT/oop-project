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

/**
 * The type Researh journal.
 */
public class ResearhJournal implements Serializable, Comparable<ResearhJournal> {

    /**
     * The Title.
     */
    private String title;

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    private Vector<User> members;

    private Vector<ResearchPaper> papers;

    /**
     * Instantiates a new Researh journal.
     */
    public ResearhJournal() {
        this.members = new Vector<>();
        this.papers = new Vector<>();
    }

    @Override
    public String toString() {
        return
                "title=" + title;
    }

    /**
     * Instantiates a new Researh journal.
     *
     * @param title the title
     */
    public ResearhJournal(String title) {
        this();
        this.title = title;
    }

    /**
     * Gets members.
     *
     * @return the members
     */
    public Vector<User> getMembers() {
        return this.members;
    }

    /**
     * Add member.
     *
     * @param member the member
     */
    public void addMember(User member) {
        this.members.add(member);
    }

    /**
     * Del member.
     *
     * @param member the member
     */
    public void delMember(User member) {
        this.members.remove(member);
    }


    /**
     * Gets papers.
     *
     * @return the papers
     */
    public Vector<ResearchPaper> getPapers() {
        return this.papers;
    }

    /**
     * Add paper.
     *
     * @param pape the pape
     */
    public void addPaper(ResearchPaper pape) {
        this.papers.add(pape);
    }

    /**
     * Del paper.
     *
     * @param pape the pape
     */
    public void delPaper(ResearchPaper pape) {
        this.papers.remove(pape);
    }

    @Override
    public int compareTo(ResearhJournal o) {
        return this.title.compareTo(o.getTitle());
    }
}

