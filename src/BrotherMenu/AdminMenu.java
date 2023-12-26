package BrotherMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Actors.Student;
import Date.DataBase;
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
 * The type Admin menu.
 */
public class AdminMenu {

    private Admin admin;
    private DataBase dataBase;
    private BufferedReader reader;

    /**
     * Instantiates a new Admin menu.
     *
     * @param admin the admin
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public AdminMenu(Admin admin) throws IOException, ClassNotFoundException {
        this.admin = admin;
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
        String menuOptions = "\nWelcome, " + """
                \n a1. View information about Admin
                a2. Remove user
                a3. Update user
                a4. Add user
                a5. See log about user
                a6. next command
                0. exit
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
                    isRunning = false;
                    System.out.println("Logged out successfully.");
                    DataBase.getInstance().saveToFile("data.ser");
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

    private void updateUser() throws IOException, NotAutorizedException, ClassNotFoundException {
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
        User newUser = new Student(newName, newSurname, newPassword, LANGUAGES.EN);
        admin.UpdateUser(oldUser, newUser);
        System.out.println("User updated successfully.");
    }

    /**
     * Add user.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void addUser() throws IOException, ClassNotFoundException {
        System.out.println("Enter the type of  user: ");
        System.out.println("""
                1. Student
                2. Dean
                3. Manager
                4. Teacher
                5. TechSupport
                6. MasterStudent
                7. Admin
                """);
        String option = reader.readLine();
        System.out.println("Enter the user name: ");
        String name = reader.readLine();
        System.out.println("Enter the user surname: ");
        String surname = reader.readLine();
        System.out.println("Please enter password: ");
        String password = reader.readLine();
        System.out.println("Enter the language: ");
        System.out.println("""
                    1. English
                    2. Russian
                    3. Kazakh
                    """);
        String opt = reader.readLine();
        LANGUAGES lang;
        if(opt.equals("1")){
            lang = LANGUAGES.EN;
        } else if(opt.equals("2")){
            lang = LANGUAGES.RU;
        } else{
            lang = LANGUAGES.KZ;
        }
        if(option.equals("1")){
            System.out.println("""
                
                setting Faculty information
                1.  FIT
                      
                2.  SHENGI
                       
                3.  WXI
                        
                4.  MWE
                       
                5.  NGD
                """);
            String p = reader.readLine();
            FACULTY f;
            if(p.equals("1")){
                f = FACULTY.FIT;
            } else if(p.equals("2")){
                f = FACULTY.SHENGI;
            } else if(p.equals("3")){
                f = FACULTY.WXI;
            } else if(p.equals("4")){
                f = FACULTY.MWE;
            } else {
                f = FACULTY.NGD;
            }
            Student st = new Student(name, surname, password, lang, f);
            DataBase.getInstance().addUser(st);
        } else if(option.equals("2")){
            System.out.println("enter department");
            String depart = reader.readLine();

            System.out.println("enter salary");
            String toParse = reader.readLine();
            double salary = Double.parseDouble(toParse);
            Dean dean = new Dean(name, surname, password, lang, depart, salary);
            DataBase.getInstance().addUser(dean);
        } else if(option.equals("3")){
            System.out.println("enter department");
            String depart = reader.readLine();
            System.out.println("enter salary");
            String toParse = reader.readLine();
            double salary = Double.parseDouble(toParse);
            System.out.println("""
                    Enter the manager type:
                    1. FINANCE
                    2. HR
                    3. OR
                    4. DEPARTMENTS
                    """);
            ManagerType type;
            String check = reader.readLine();
            if(check.equals("1")){
                type = ManagerType.FINANCE;
            } else if(check.equals("2")){
                type = ManagerType.HR;
            } else if(check.equals("3")){
                type = ManagerType.OR;
            } else{
                type = ManagerType.DEPARTMENTS;
            }
            Manager manager = new Manager(name, surname, password, lang, depart, salary, type);
            DataBase.getInstance().addUser(manager);
        } else if(option.equals("4")){
            System.out.println("enter department");
            String depart = reader.readLine();
            System.out.println("enter salary");
            String toParse = reader.readLine();
            double salary = Double.parseDouble(toParse);
            Subject subject;
            System.out.println("""
                    Enter subject
                    1. CALCULUS1,
                        
                    2. CALCULUS2,
                        
                    3. OOP
                       
                    4. ALGORITHM
                        
                    5.  ENGLISH
                        
                    6. JAPANESE
                    """);


            String check = reader.readLine();
            if(check.equals("1")){
                subject = Subject.CALCULUS1;
            } else if(check.equals("2")){
                subject = Subject.CALCULUS2;
            } else if(check.equals("3")){
                subject = Subject.OOP;
            } else if(check.equals("4")){
                subject = Subject.ALGORITHM;
            } else if(check.equals("5")){
                subject = Subject.ENGLISH;
            } else{
                subject = Subject.JAPANESE;
            }
            TeacherRole teacherRole;
            System.out.println("""
                    Type 
                    1. LECTOR,
                       
                    2. PROCESSOR
                    """);
            check = reader.readLine();
            if(check.equals("1")){
                teacherRole = TeacherRole.LECTOR;
            } else{
                teacherRole = TeacherRole.PROCESSOR;
            }
            Teacher teacher = new Teacher(name, surname, password, lang, depart, salary, subject, teacherRole);
            DataBase.getInstance().addUser(teacher);

        } else if(option.equals("5")){
            System.out.println("enter department");
            String depart = reader.readLine();

            System.out.println("enter salary");
            String toParse = reader.readLine();
            double salary = Double.parseDouble(toParse);
            TechSupportSpecialist tech = new TechSupportSpecialist(name, surname, password, lang, depart, salary);
            DataBase.getInstance().addUser(tech);

        } else if(option.equals("6")){
            System.out.println("""
                
                setting Faculty information
                1.  FIT
                      
                2.  SHENGI
                       
                3.  WXI
                        
                4.  MWE
                       
                5.  NGD
                """);
            String p = reader.readLine();
            FACULTY f;
            if(p.equals("1")){
                f = FACULTY.FIT;
            } else if(p.equals("2")){
                f = FACULTY.SHENGI;
            } else if(p.equals("3")){
                f = FACULTY.WXI;
            } else if(p.equals("4")){
                f = FACULTY.MWE;
            } else {
                f = FACULTY.NGD;
            }
            System.out.println("Enter degree type");
            System.out.println("""
                    1. MASTER
                       
                    2. PHD
                    """);
            String degreeOption = reader.readLine();
            GRADUATE_STUDENT gs;
            if(degreeOption.equals("1")){
                gs = GRADUATE_STUDENT.MASTER;
            } else{
                gs = GRADUATE_STUDENT.PHD;
            }
            GraduateStudent st = new GraduateStudent(name, surname, password, lang, f, null, gs);
            DataBase.getInstance().addUser(st);
        } else{
            System.out.println("enter department");
            String depart = reader.readLine();

            System.out.println("enter salary");
            String toParse = reader.readLine();
            double salary = Double.parseDouble(toParse);
            Admin admin = new Admin(name, surname, password, lang, depart, salary);
            DataBase.getInstance().addUser(admin);
        }

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

//    private void changeResearcherStatus() throws IOException {
//        System.out.println("Enter the new researcher status (true/false): ");
//        boolean isResearcher = Boolean.parseBoolean(reader.readLine());
//        admin.setResearcher(isResearcher);
//        System.out.println("Researcher status changed successfully.");
//    }






}
