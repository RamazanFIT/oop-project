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

    public void showMenu() throws IOException, ClassNotFoundException, NotAutorizedException {
        String menuOptions = "\nWelcome, " + """
                \n a1. View information about Admin
                a2. Remove user
                a3. Update user
                a4. Add user
                a5. See log about user
                a6. Change researcher status
                a7. next command
                """;
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menuOptions);
            String option = reader.readLine();
            switch (option) {
                case "a1":
                    System.out.println("Welcome: " + admin);
                    break;
                case "a2":
                    removeUser();
                    break;
                case "a3":
                    updateUser();
                    break;
                case "a4":
                    addUser();
                    break;
                case "a5":
                    seeLogAboutUser();
                    break;
                case "a6":
                    changeResearcherStatus();
                    break;
                case "0":
                    isRunning = false;
                    System.out.println("Logged out successfully.");
                    DataBase.getInstance().saveToFile("data.ser");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void removeUser() throws IOException, ClassNotFoundException {
        System.out.println("Enter the user name: ");
        String name = reader.readLine();
        System.out.println("Enter the user surname: ");
        String surname = reader.readLine();
        dataBase.kickUser(dataBase.getUser(name, surname));
        System.out.println("User removed successfully.");
    }

    private void updateUser() throws IOException, NotAutorizedException {
        System.out.println("Enter the old user name: ");
        String oldName = reader.readLine();
        System.out.println("Enter the old user surname: ");
        String oldSurname = reader.readLine();
        User oldUser = dataBase.getUser(oldName, oldSurname);

        System.out.println("Enter the new user name: ");
        String newName = reader.readLine();
        System.out.println("Enter the new user surname: ");
        String newSurname = reader.readLine();
        System.out.println("Enter the new user password: ");
        String newPassword = reader.readLine();
        User newUser = new User(newName, newSurname, newPassword, LANGUAGES.EN, "", 0);

        admin.UpdateUser(oldUser, newUser);
        System.out.println("User updated successfully.");
    }

    private void addUser() throws IOException, ClassNotFoundException {
        System.out.println("Enter the user name: ");
        String name = reader.readLine();
        System.out.println("Enter the user surname: ");
        String surname = reader.readLine();
        System.out.println("Enter the user password: ");
        String password = reader.readLine();
        System.out.println("Enter the user language (EN/KZ/RU): ");
        LANGUAGES language = LANGUAGES.valueOf(reader.readLine().toUpperCase());
        System.out.println("Enter the user department: ");
        String department = reader.readLine();
        System.out.println("Enter the user salary: ");
        double salary = Double.parseDouble(reader.readLine());

        User newUser = new User(name, surname, password, language, department, salary);
        admin.addUser(newUser);
        System.out.println("User added successfully.");
    }

    private void seeLogAboutUser() throws IOException, NotAutorizedException {
        System.out.println("Enter the user name: ");
        String name = reader.readLine();
        System.out.println("Enter the user surname: ");
        String surname = reader.readLine();
        User user = dataBase.getUser(name, surname);
        Vector<String> logFiles = admin.seeLogAboutUser(user);

        System.out.println("User log files: ");
        for (String file : logFiles) {
            System.out.println(file);
        }
    }

    private void changeResearcherStatus() throws IOException {
        System.out.println("Enter the new researcher status (true/false): ");
        boolean isResearcher = Boolean.parseBoolean(reader.readLine());
        admin.setResearcher(isResearcher);
        System.out.println("Researcher status changed successfully.");
    }
    }





}
