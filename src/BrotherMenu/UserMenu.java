package BrotherMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Actors.Student;
import Date.DataBase;
import Exceptions.ExceededCreditException;
import Main.Message;
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
 * The type User menu.
 */
public class UserMenu {

    private User user;
    private DataBase dataBase;
    private BufferedReader reader;

    /**
     * Instantiates a new User menu.
     *
     * @param user the user
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public UserMenu(User user) throws IOException, ClassNotFoundException {
        this.user = user;
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
                \n u1. View information about User
                u2. Change the name
                u3. Change the surname
                u4. Change the password
                u5. View the log files
                u6. subscribe to journal
                u7. cancel subscription to journal
                u8. View subscription 
                u9. send message
                u10. get message
                u11. get sent message
                u12. change all data of user
                u13. next command
                0. exit program
                """;
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menuOptions);
            String option = reader.readLine();
            switch (option) {
                case "u1":
                    System.out.println("Welcome: " + user);
                    break;
                case "u2":
                    changeName();
                    break;
                case "u3":
                    changeSurname();
                    break;
                case "u4":
                    changePassword();
                    break;
                case "u5":
                    seeLogFiles();
                    break;
                case "u6":
                    subsToJournal();
                    break;
                case "u7":
                    cancelSubsToJournal();
                    break;
                case "u8":
                    getSubsToJournal();
                    break;
                case "u9":
                    sendMessage();
                    break;
                case "u10":
                    getMessage();
                    break;
                case "u11":
                    getSendMessage();
                    break;
                case "u12":
                    changeAllData();
                    break;
                case "u13":
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

    /**
     * Change name.
     *
     * @throws IOException           the io exception
     * @throws NotAutorizedException the not autorized exception
     */
    public void changeName() throws IOException, NotAutorizedException {
        System.out.println("Please enter your new name: ");
        String name = reader.readLine();
        user.setName(name);
        System.out.println("Successfully changed to " + name);
    }

    /**
     * Change surname.
     *
     * @throws IOException           the io exception
     * @throws NotAutorizedException the not autorized exception
     */
    public void changeSurname() throws IOException, NotAutorizedException {
        System.out.println("Please enter your new surname: ");
        String surname = reader.readLine();
        user.setSurname(surname);
        System.out.println("Successfully changed to " + surname);
    }

    /**
     * Change password.
     *
     * @throws IOException           the io exception
     * @throws NotAutorizedException the not autorized exception
     */
    public void changePassword() throws IOException, NotAutorizedException {
        System.out.println("Please enter your new password: ");
        String password = reader.readLine();
        user.setPassword(password);
        System.out.println("Successfully changed to " + password);
    }

    /**
     * See log files.
     *
     * @throws NotAutorizedException the not autorized exception
     */
    public void seeLogFiles() throws NotAutorizedException {
        String log = "";
        for(String file : user.getLogFiles()){
            log += file + "\n";
        }
        System.out.println("Your log files: ");
        System.out.println(log);
    }

    /**
     * Subs to journal.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws NotAutorizedException  the not autorized exception
     */
    public void subsToJournal() throws IOException, ClassNotFoundException, NotAutorizedException {
        System.out.println("Enter the title of the journal");
        String title = reader.readLine();
        ResearhJournal journal = DataBase.getInstance().getResearchJournalByTitle(title);
        if(journal != null){
            journal.addMember(user);
            System.out.println("Successfully enrolled to " + title);
        } else{
            System.out.println("Try again");
        }
    }

    /**
     * Cancel subs to journal.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws NotAutorizedException  the not autorized exception
     */
    public void cancelSubsToJournal() throws IOException, ClassNotFoundException, NotAutorizedException {
        System.out.println("Enter the title of the journal");
        String title = reader.readLine();
        ResearhJournal journal = DataBase.getInstance().getResearchJournalByTitle(title);
        journal.delMember(user);
        System.out.println("Successfully removed from " + title);
    }

    /**
     * Gets subs to journal.
     *
     * @throws IOException            the io exception
     * @throws NotAutorizedException  the not autorized exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void getSubsToJournal() throws IOException, NotAutorizedException, ClassNotFoundException {
        System.out.println("Your subscription to journals");
        String ans = "";
        for(ResearhJournal journal : user.getSubscriptions()){
            ans += journal.getTitle() + "\n";
        }
        System.out.println(ans);
    }

    /**
     * Send message.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws NotAutorizedException  the not autorized exception
     */
    public void sendMessage() throws IOException, ClassNotFoundException, NotAutorizedException {
        System.out.println("Enter the user name: ");
        String name = reader.readLine();
        System.out.println("Enter the user surname: ");
        String surname = reader.readLine();
        System.out.println("Enter the message: ");
        String message = reader.readLine();
        User toUser = DataBase.getInstance().getUser(name, surname);
        user.sendMessage(toUser, message);
        System.out.println("Successfully send a message");
    }

    /**
     * Gets message.
     *
     * @throws NotAutorizedException  the not autorized exception
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void getMessage() throws NotAutorizedException, IOException, ClassNotFoundException {
        String ans = "";
        for(Message m : user.getMessage()){
            ans += m + "\n";
        }
        System.out.println(ans);

    }

    /**
     * Gets send message.
     *
     * @throws NotAutorizedException  the not autorized exception
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void getSendMessage() throws NotAutorizedException, IOException, ClassNotFoundException {
        String ans = "";
        for(Message m : user.getSendMessage()){
            ans += m + "\n";
        }
        System.out.println(ans);
    }

    /**
     * Change all data.
     *
     * @throws NotAutorizedException the not autorized exception
     * @throws IOException           the io exception
     */
    public void changeAllData() throws NotAutorizedException, IOException{
        changeName();
        changeSurname();
        changePassword();
    }

}
