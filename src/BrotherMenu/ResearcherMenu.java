package BrotherMenu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Actors.Student;
import Date.DataBase;
import Enums.Organization;
import Exceptions.ExceededCreditException;
import Science.*;
import Interfaces.*;
import Actors.*;
import Enums.*;
import Exceptions.*;
import java.io.IOException;
import java.util.Comparator.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * The type Researcher menu.
 */
public class ResearcherMenu {

    private Researcher researcher;
    private DataBase dataBase;
    private BufferedReader reader;

    /**
     * Instantiates a new Researcher menu.
     *
     * @param researcher the researcher
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public ResearcherMenu(Researcher researcher) throws IOException, ClassNotFoundException {
        this.researcher = researcher;
        this.dataBase = DataBase.getInstance();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Show menu.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws NotAutorizedException  the not autorized exception
     * @throws ImposterException      the imposter exception
     */
    public void showMenu() throws IOException, ClassNotFoundException, NotAutorizedException, ImposterException {
        String menuOptions = "\nWelcome, Student: " + researcher.getName() + """
                \n1. Print the papers.
                2. Count the H index.
                3. Get list of Projects.
                4. Add Project.
                5. Delete the project by topic.
                6. Add paper.
                7. Delete paper.
                8. Get Projects.
                9. Set the Researcher Status.
                0. Logout.""";
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menuOptions);
            String option = reader.readLine();
            switch (option) {
                case "1":
                    printPapers();
                    break;
                case "2":
                    cntHIndex();
                    break;
                case "3":
                    getProjects();
                    break;
                case "4":
                    addProject();
                    break;
                case "5":
                    delProject();
                    break;
                case "6":
                    addPapers();
                    break;
                case "7":
                    delPapers();
                    break;
                case "8":
                    getOwnProject();
                    break;
                case "9":
                    setToResearcher();
                    break;
                case "0":
                    isRunning = false;
                    dataBase.saveToFile("data.ser");
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Print papers.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void printPapers() throws IOException, ClassNotFoundException {
        System.out.println("The papers: " + researcher.getPapers());
    }

    /**
     * Cnt h index.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void cntHIndex() throws IOException, ClassNotFoundException {
        System.out.println("The H index of Researcher: " + researcher.cntHIndex());
    }

    /**
     * Gets projects.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void getProjects() throws IOException, ClassNotFoundException {
        System.out.println("The projects: " + researcher.getProjects());
    }

    /**
     * Add project.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws ImposterException      the imposter exception
     */
    public void addProject() throws IOException, ClassNotFoundException, ImposterException {
        System.out.println("Enter the topic of project: ");
        String topic = reader.readLine();
        ResearchProject rp = new ResearchProject(topic);
        rp.setSuperVisor(researcher);
        rp.addProjectParticipant(researcher);
        researcher.addProject(rp);
        System.out.println("Success");
    }

    /**
     * Del project.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void delProject() throws IOException, ClassNotFoundException {
        System.out.println("Enter the topic of project: ");
        String topic = reader.readLine();

        ResearchProject rp = dataBase.getResearchProjectByTopic(topic);
        researcher.delProject(rp);
        System.out.println("Success");

    }

    /**
     * Add papers.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws ImposterException      the imposter exception
     */
    public void addPapers() throws IOException, ClassNotFoundException, ImposterException {
        System.out.println("Enter the title of paper");
        String title = reader.readLine();
        System.out.println("Enter the citation of paper");
        String number = reader.readLine();
        int citation = Integer.parseInt(number);
        int pages = Integer.parseInt(reader.readLine());
        Date date = new Date();
        String doi = "121";
        ResearchPaper rp = new ResearchPaper(title, researcher, citation, pages, date, doi);
        researcher.addPapers(rp);
        System.out.println("Success");

    }

    /**
     * Del papers.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws ImposterException      the imposter exception
     */
    public void delPapers() throws IOException, ClassNotFoundException, ImposterException {
        System.out.println("Enter the title of paper");
        String title = reader.readLine();
        researcher.delPapers(dataBase.getResearchPaperByTitle(title));
        System.out.println("Success");

    }

    /**
     * Gets own project.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void getOwnProject() throws IOException, ClassNotFoundException {
        System.out.println("The own projects: " + researcher.getOwnProject());
        System.out.println("Success");
    }

    /**
     * Sets to researcher.
     *
     * @throws IOException the io exception
     */
    public void setToResearcher() throws IOException {
        System.out.println("Do you want to make to Researcher");
        System.out.println("""
                1. YES 
                2. NO
                """);
        String opt = reader.readLine();
        if(opt.equals("1")){
            researcher.setResearcher(true);
        } else{
            researcher.setResearcher(false);
        }
        System.out.println("Success");
        
    }

}
