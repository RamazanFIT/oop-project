package Science;


import Interfaces.Researcher;
import Task.ResearchPaper;
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
public class ResearchProject {

    /**
     * @generated
     */
    private String topic;

    /**
     * @generated
     */
    private Vector<ResearchPaper> publishedPapers;

    /**
     * @generated
     */
    private Vector<Researcher> projectParticipant;

    /**
     * @generated
     */
    private Researcher superVisor;

    public ResearchProject() {};

    public ResearchProject(String topic, Vector<ResearchPaper> papers,
                           Vector<Researcher> projectParticipant, Researcher supervisor){
        this.projectParticipant = projectParticipant;
        this.publishedPapers = papers;
        this.topic = topic;
        this.superVisor = supervisor;
    }


    /**
     * @generated
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * @generated
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }


    /**
     * @generated
     */
    public Vector<ResearchPaper> getPublishedPapers() {
        return this.publishedPapers;
    }

    /**
     * @generated
     */
    public void addPaper(ResearchPaper paper) {
        this.publishedPapers.add(paper);
    }


    /**
     * @generated
     */
    public Vector<Researcher> getProjectParticipant() {
        return this.projectParticipant;
    }

    /**
     * @generated
     */
    public void addProjectParticipant(Researcher projectParticipant) throws ImposterException {
        if(!projectParticipant.isResearcher()){
            throw new ImposterException("Not a reasercher");
        }
        this.projectParticipant.add(projectParticipant);
    }


    /**
     * @generated
     */
    public Researcher getSuperVisor() {
        return this.superVisor;
    }

    /**
     * @generated
     */
    public void setSuperVisor(Researcher superVisor) throws ImposterException {
        if(!superVisor.isResearcher()){
            throw new ImposterException("Not a reasercher");
        }
        this.superVisor = superVisor;
    }


}
