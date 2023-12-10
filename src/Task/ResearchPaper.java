package Task;
import java.util.Date;
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
public class ResearchPaper {

    /**
     * @generated
     */
    private String title;

    /**
     * @generated
     */
    private Researcher author;

    /**
     * @generated
     */
    private int citations;

    /**
     * @generated
     */
    private int pages;

    /**
     * @generated
     */
    private Date date;

    /**
     * @generated
     */
    private String doi;

    /**
     * @generated
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @generated
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @generated
     */
    public Researcher getAuthor() {
        return this.author;
    }

    /**
     * @generated
     */
    public void setAuthor(Researcher author) throws ImposterException {
        if(!author.isResearcher()){
            throw new ImposterException("Not a reasercher");
        }
        this.author = author;
    }



    /**
     * @generated
     */
    public void setCitations(int citations) {
        this.citations = citations;
    }



    /**
     * @generated
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * @generated
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * @generated
     */
    public String getDoi() {
        return this.doi;
    }

    /**
     * @generated
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }



    /**
     * @generated
     */
    public String getCitation(Format f) {
        //TODO
        return "";
    }


}

