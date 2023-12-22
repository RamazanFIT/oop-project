package Task;
import java.io.Serializable;
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
 * The type Research paper.
 */
public class ResearchPaper implements Serializable, Comparable<ResearchPaper> {

    private String title;

    private Researcher author;

    private int citations;

    private int pages;

    private Date date;

    private String doi;

    /**
     * Instantiates a new Research paper.
     *
     * @param title     the title
     * @param author    the author
     * @param citations the citations
     * @param pages     the pages
     * @param date      the date
     * @param doi       the doi
     */
    public ResearchPaper(String title, Researcher author, int citations, int pages, Date date, String doi) {
        this.title = title;
        this.author = author;
        this.citations = citations;
        this.pages = pages;
        this.date = date;
        this.doi = doi;
    }

    /**
     * Instantiates a new Research paper.
     *
     * @param title     the title
     * @param author    the author
     * @param citations the citations
     * @param pages     the pages
     * @param doi       the doi
     */
    public ResearchPaper(String title, Researcher author, int citations, int pages, String doi) {
        this.title = title;
        this.author = author;
        this.citations = citations;
        this.pages = pages;
        this.doi = doi;
        this.date = new Date();
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public Researcher getAuthor() {
        return this.author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     * @throws ImposterException the imposter exception
     */
    public void setAuthor(Researcher author) throws ImposterException {
        if(!author.isResearcher()){
            throw new ImposterException("Not a reasercher");
        }
        this.author = author;
    }


    /**
     * Sets citations.
     *
     * @param citations the citations
     */
    public void setCitations(int citations) {
        this.citations = citations;
    }


    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * Gets doi.
     *
     * @return the doi
     */
    public String getDoi() {
        return this.doi;
    }

    /**
     * Sets doi.
     *
     * @param doi the doi
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }



    private String formatPlainText() {
        return String.format("%s by %s, %s, DOI: %s", this.title, this.author.getName(), this.date.toString(), this.doi);
    } // work

    private String formatBibtex() {
        return String.format("@article{%s,\nauthor = {%s},\ntitle = {%s},\nyear = {%tY},\ndoi = {%s}\n}",
                this.author.getName().replaceAll("\\s+", "").toLowerCase() + this.date.getYear(),
                this.author.getName(),
                this.title,
                this.date,
                this.doi); // work
    }

    /**
     * Gets citation.
     *
     * @param f the f
     * @return the citation
     */
    public String getCitation(Format f) { // work
        if(f == Format.Bibtex){
            return this.formatBibtex();
        } else{
            return this.formatPlainText();
        }
    }

    /**
     * Gets citation.
     *
     * @return the citation
     */
    public int getCitation() {
        return citations; // work
    }


    @Override
    public int compareTo(ResearchPaper o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}

