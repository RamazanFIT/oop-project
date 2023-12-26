package BrotherMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Actors.Student;
import Date.DataBase;
import Enums.Organization;
import Exceptions.ExceededCreditException;
import Main.TechSupportSpecialist;
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
 * The type Tech support menu.
 */
public class TechSupportMenu {

    private TechSupportSpecialist techSupportSpecialist;
    private DataBase dataBase;
    private BufferedReader reader;

    /**
     * Instantiates a new Tech support menu.
     *
     * @param techSupportSpecialist the tech support specialist
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public TechSupportMenu(TechSupportSpecialist techSupportSpecialist) throws IOException, ClassNotFoundException {
        this.techSupportSpecialist = techSupportSpecialist;
        this.dataBase = DataBase.getInstance();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Show menu.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws NotAutorizedException  the not autorized exception
     */
    public void showMenu() throws IOException, ClassNotFoundException, NotAutorizedException {
        String menuOptions = "\nWelcome, Student: " + techSupportSpecialist.getName() + """
                \n1. Get Task message.
                2. Change To Done message.
                3. Change To Accepted message.
                4. next command
                0. Logout.""";
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menuOptions);
            String option = reader.readLine();
            switch (option) {
                case "1":
                    getTaskMess();
                    break;
                case "2":
                    changeTaskMess();
                    break;
                case "3":
                    changeToAcceptedMess();
                    break;
                case "4":
                    isRunning = false;
                    dataBase.saveToFile("data.ser");
                    System.out.println("Logged out successfully.");
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
     * Gets task mess.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void getTaskMess() throws IOException, ClassNotFoundException {
        System.out.println("Message task: " + techSupportSpecialist.getTask());
    }

    /**
     * Change task mess.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void changeTaskMess() throws IOException, ClassNotFoundException {
        System.out.println("Successfully changed to Done task.");
        techSupportSpecialist.ChangeToDone();
    }

    /**
     * Change to accepted mess.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void changeToAcceptedMess() throws IOException, ClassNotFoundException {
        System.out.println("Successfully changed to Accepted task.");
        techSupportSpecialist.ChangeToAccepted();
    }

}
