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
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

import javax.xml.crypto.Data;

public class GeneralMenu {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NotAutorizedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DataBase.loadFromFile("data.ser");
        showMainMenu(reader);
    }

    private static void showMainMenu(BufferedReader reader) throws IOException, NotAutorizedException, ClassNotFoundException {
        System.out.println("""
                Welcome to the System
                1. Login
                0. Exit""");

        String input = reader.readLine();
        while (!input.equals("0")) {
            if (input.equals("1")) {
                showLoginMenu(reader);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
            input = reader.readLine();
        }

        System.out.println("Exiting the system. Have a nice day!");
    }

    private static void showLoginMenu(BufferedReader reader) throws IOException, NotAutorizedException, ClassNotFoundException {
            User user = findUser(reader);
            if (user != null) {
                navigateToRoleMenu(user);
            }
    }

    private static void navigateToRoleMenu(User user) throws IOException, ClassNotFoundException, NotAutorizedException {
        if (user instanceof Student) {
//            StudentMenu.menu(user);
            UserMenu menu = new UserMenu(user);
            menu.showMenu();
        } else {
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


}
