package BrotherMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Actors.Student;
import Date.DataBase;
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
public class AdminMenu {

    private Admin admin;
    private DataBase dataBase;
    private BufferedReader reader;

    public AdminMenu(Admin admin) throws IOException, ClassNotFoundException {
        this.admin = admin;
        this.dataBase = DataBase.getInstance();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showMenu() throws IOException, ClassNotFoundException {
        String menuOptions = "\nWelcome, Admin: " + admin.getName() + """
                \n1. View enrolled courses.
                2. View transcript.
                3. Register for a course.
                4. View diploma project.
                5. View major courses.
                6. View minor courses.
                7. View faculty.
                8. View organizations.
                9. View teacher info.
                10. Set Faculty.
                0. Logout.""";
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menuOptions);
            String option = reader.readLine();
            switch (option) {
                case "1":
//                    f
                    break;
                case "2":
//                    f
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





}
