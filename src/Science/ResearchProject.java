package Science;


import Interfaces.Researcher;
import Task.ResearchPaper;
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
 * The type Research project.
 */
public class ResearchProject implements Serializable, Comparable<ResearchProject> {

    private String topic;

    private Vector<ResearchPaper> publishedPapers;

    private Vector<Researcher> projectParticipant;

    private Researcher superVisor;

    /**
     * Instantiates a new Research project.
     */
    public ResearchProject() {};

    public ResearchProject(String topic) {
        this.topic = topic;
        this.publishedPapers = new Vector<ResearchPaper>();
        this.projectParticipant = new Vector<Researcher>();

    };


    /**
     * Instantiates a new Research project.
     *
     * @param topic              the topic
     * @param papers             the papers
     * @param projectParticipant the project participant
     * @param supervisor         the supervisor
     */
    public ResearchProject(String topic, Vector<ResearchPaper> papers, Vector<Researcher> projectParticipant, Researcher supervisor){
        this.projectParticipant = projectParticipant;
        this.publishedPapers = papers;
        this.topic = topic;
        this.superVisor = supervisor;
    }


    /**
     * Gets topic.
     *
     * @return the topic
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * Sets topic.
     *
     * @param topic the topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }


    /**
     * Gets published papers.
     *
     * @return the published papers
     */
    public Vector<ResearchPaper> getPublishedPapers() {
        return this.publishedPapers;
    }

    /**
     * Add paper.
     *
     * @param paper the paper
     */
    public void addPaper(ResearchPaper paper) {
        this.publishedPapers.add(paper);
    }


    /**
     * Gets project participant.
     *
     * @return the project participant
     */
    public Vector<Researcher> getProjectParticipant() {
        return this.projectParticipant;
    }

    /**
     * Add project participant.
     *
     * @param projectParticipant the project participant
     * @throws ImposterException the imposter exception
     */
    public void addProjectParticipant(Researcher projectParticipant) throws ImposterException {
        if(!projectParticipant.isResearcher()){
            throw new ImposterException("Not a reasercher");
        }
        this.projectParticipant.add(projectParticipant);
    }


    /**
     * Gets super visor.
     *
     * @return the super visor
     */
    public Researcher getSuperVisor() {
        return this.superVisor;
    }

    /**
     * Sets super visor.
     *
     * @param superVisor the super visor
     * @throws ImposterException the imposter exception
     */
    public void setSuperVisor(Researcher superVisor) throws ImposterException {
        if(!superVisor.isResearcher()){
            throw new ImposterException("Not a reasercher");
        }
        this.superVisor = superVisor;
    }


    @Override
    public int compareTo(ResearchProject o) {
        if(this.topic.compareTo(o.getTopic()) != 0){
            return this.topic.compareTo(o.getTopic());
        }
        if(this.publishedPapers.size() >= o.getPublishedPapers().size()){
            return 1;
        } else{
            return -1;
        }
    }
}
