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
public class ResearcherMenu {

    private Researcher researcher;
    private DataBase dataBase;
    private BufferedReader reader;

    public ResearcherMenu(Researcher researcher) throws IOException, ClassNotFoundException {
        this.researcher = researcher;
        this.dataBase = DataBase.getInstance();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showMenu() throws IOException, ClassNotFoundException, NotAutorizedException {
        String menuOptions = "\nWelcome, Student: " + researcher.getName() + """
                \n1. Get Subject Specialization.
                2. Set Subject Specialization.
                3. Get List of Courses.
                4. Add Course to teacher.
                5. Get Teacher Role.
                6. Set Teacher Role.
                7. Put Mark to student.
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

    public void printPapers() throws IOException, ClassNotFoundException {
        System.out.println("The papers: " + researcher.getPapers());
    }

    public void cntHIndex() throws IOException, ClassNotFoundException {
        System.out.println("The H index of Researcher: " + researcher.cntHIndex());
    }

    public void getProjects() throws IOException, ClassNotFoundException {
        System.out.println("The projects: " + researcher.getProjects());
    }

    public void addProject() throws IOException, ClassNotFoundException, ImposterException {
        System.out.println("Enter the topic of project: ");
        String topic = reader.readLine();
        ResearchProject rp = new ResearchProject(topic);
        rp.setSuperVisor(researcher);
        rp.addProjectParticipant(researcher);
        researcher.addProject(rp);
        System.out.println("Success");
    }
}
