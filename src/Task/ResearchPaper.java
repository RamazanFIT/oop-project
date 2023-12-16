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

    public ResearchPaper(String title, Researcher author, int citations, int pages, Date date, String doi) {
        this.title = title;
        this.author = author;
        this.citations = citations;
        this.pages = pages;
        this.date = date;
        this.doi = doi;
    }

    public ResearchPaper(String title, Researcher author, int citations, int pages, String doi) {
        this.title = title;
        this.author = author;
        this.citations = citations;
        this.pages = pages;
        this.doi = doi;
        this.date = new Date();
    }

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
    private String formatPlainText() {
        return String.format("%s by %s, %s, DOI: %s", this.title, this.author.getName(), this.date.toString(), this.doi);
    } // work

    /**
     * @generated
     */
    private String formatBibtex() {
        return String.format("@article{%s,\nauthor = {%s},\ntitle = {%s},\nyear = {%tY},\ndoi = {%s}\n}",
                this.author.getName().replaceAll("\\s+", "").toLowerCase() + this.date.getYear(),
                this.author.getName(),
                this.title,
                this.date,
                this.doi); // work
    }

    public String getCitation(Format f) { // work
        if(f == Format.Bibtex){
            return this.formatBibtex();
        } else{
            return this.formatPlainText();
        }
    }

    public int getCitation() {
        return citations; // work
    }


}

