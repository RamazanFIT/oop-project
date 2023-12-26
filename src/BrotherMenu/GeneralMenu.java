package BrotherMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Actors.*;
import Actors.*;
import Enums.*;
import Exceptions.*;

import java.io.IOException;
import java.util.Comparator.*;

import Main.TechSupportSpecialist;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

import javax.xml.crypto.Data;

public class GeneralMenu {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NotAutorizedException, ImposterException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DataBase.loadFromFile("data.ser");
        showMainMenu(reader);
    }

    private static void showMainMenu(BufferedReader reader) throws IOException, NotAutorizedException, ClassNotFoundException, ImposterException {
        System.out.println("""
                Welcome to the System
                2. Create a new account
                1. Login
                0. Exit""");

        String input = reader.readLine();
        while (!input.equals("0")) {

            if (input.equals("1")) {
                showLoginMenu(reader);
            } else if(input.equals("2")){
                register(reader);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
            input = reader.readLine();
        }

        System.out.println("Exiting the system. Have a nice day!");
        DataBase.getInstance().saveToFile("data.ser");
    }

    private static void showLoginMenu(BufferedReader reader) throws IOException, NotAutorizedException, ClassNotFoundException, ImposterException {
            User user = findUser(reader);
            if (user != null) {
                navigateToRoleMenu(user);
            }
    }

    private static void navigateToRoleMenu(User user) throws IOException, ClassNotFoundException, NotAutorizedException, ImposterException {
        if (user instanceof Student) {
            UserMenu umenu = new UserMenu(user);
            umenu.showMenu();
            StudentMenu menu = new StudentMenu((Student) user);
            menu.showMenu();
            Student student = (Student) user;
            if(student.isResearcher()) {
                ResearcherMenu rmenu = new ResearcherMenu((Researcher) user);
                rmenu.showMenu();
            }
        } else if (user instanceof Teacher) {
            UserMenu umenu = new UserMenu(user);
            umenu.showMenu();
            TeacherMenu menu = new TeacherMenu((Teacher) user);
            menu.showMenu();
            Teacher teacher = (Teacher) user;
            if(teacher.isResearcher()) {
                ResearcherMenu rmenu = new ResearcherMenu((Researcher) user);
                rmenu.showMenu();
            }
        } if (user instanceof Admin) {
            UserMenu umenu = new UserMenu(user);
            umenu.showMenu();
            AdminMenu menu = new AdminMenu((Admin) user);
            menu.showMenu();
            Admin admin = (Admin) user;
            if(admin.isResearcher()) {
                ResearcherMenu rmenu = new ResearcherMenu((Researcher) user);
                rmenu.showMenu();
            }
        } if (user instanceof Dean) {
            UserMenu umenu = new UserMenu(user);
            umenu.showMenu();
            DeanMenu menu = new DeanMenu((Dean) user);
            menu.showMenu();
            Dean dean = (Dean) user;
            if(dean.isResearcher()) {
                ResearcherMenu rmenu = new ResearcherMenu((Researcher) user);
                rmenu.showMenu();
            }
        } if (user instanceof Manager) {
            UserMenu umenu = new UserMenu(user);
            umenu.showMenu();
            ManagerMenu menu = new ManagerMenu((Manager) user);
            menu.showMenu();
            Manager manager = (Manager) user;
            if(manager.isResearcher()) {
                ResearcherMenu rmenu = new ResearcherMenu((Researcher) user);
                rmenu.showMenu();
            }
        } if (user instanceof TechSupportSpecialist) {
            UserMenu umenu = new UserMenu(user);
            umenu.showMenu();
            TechSupportMenu menu = new TechSupportMenu((TechSupportSpecialist) user);
            menu.showMenu();
            TechSupportSpecialist techSupportSpecialist = (TechSupportSpecialist) user;
            if(techSupportSpecialist.isResearcher()) {
                ResearcherMenu rmenu = new ResearcherMenu((Researcher) user);
                rmenu.showMenu();
            }
        }
        else {
            System.out.println("User role is not recognized.");
        }
    }

    private static User findUser(BufferedReader reader) throws IOException, ClassNotFoundException, NotAutorizedException {
        System.out.print("Enter your name: ");
        String name = reader.readLine();

        System.out.print("Enter your surname: ");
        String surname = reader.readLine();

        User user = DataBase.getInstance().getUser(name, surname);
        if(user == null) {
            System.out.println("Invalid credentials or user not found.");
            return null;
        }
        while(true){
            System.out.print("Enter your password (or enter 0 to cancel): ");
            String password = reader.readLine();
            if(password.equals("0")){
                return null;
            }
            if(DataBase.getInstance().checkPasswordOfUser(password, user)){
                return user;
            } else
            System.out.println("Password is incorrect.");
        }
    }

    public static void register(BufferedReader reader) throws IOException, ClassNotFoundException {
        AdminMenu adminMenu = new AdminMenu(new Admin());
        adminMenu.addUser();
    }


}
