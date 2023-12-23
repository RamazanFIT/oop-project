package Actors;

import Enums.*;
import Exceptions.*;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import Main.*;
import Date.*;
import Task.*;

/**
 * The type User.
 */
public abstract class User implements Comparable<User>, Serializable {

    /**
     * The Name.
     */
    public String name;
    /**
     * The Surname.
     */
    public String surname;


    private String password;

    /**
     * The Is active.
     */
    public boolean isActive;

    private Vector<String> logFiles;

    /**
     * The Lang.
     */
    public LANGUAGES lang;

    /**
     * Instantiates a new User.
     */
    public User(){
        logFiles = new Vector<String>();
    }


    /**
     * Instantiates a new User.
     *
     * @param name     the name
     * @param surname  the surname
     * @param password the password
     * @param lang     the lang
     */
    public User(String name, String surname, String password, LANGUAGES lang){
        this();
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.lang = lang;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        addLogFile("getSurname");
        return surname;
    }


    /**
     * Get name string.
     *
     * @return the string
     */
    public String getName(){
        addLogFile("getName");

        return this.name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @throws NotAutorizedException the not autorized exception
     */
    public void setName(String name) throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("setName");

        this.name = name;
    }


    /**
     * Gets password.
     *
     * @return the password
     * @throws NotAutorizedException the not autorized exception
     */
    public String getPassword() throws NotAutorizedException {
        addLogFile("getPassword");
        return this.password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     * @throws NotAutorizedException the not autorized exception
     */
    public void setPassword(String password) throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("setPassword");

        this.password = password;
    }

    /**
     * Get who is string.
     *
     * @return the string
     */
    public String getWhoIs(){
        addLogFile("getWhoIs");

        return this.getClass().getName();
    }


    /**
     * Gets is active.
     *
     * @return the is active
     */
    public boolean getIsActive() {
        addLogFile("getIsActive");

        return this.isActive;
//        work
    }

    /**
     * Sets is active.
     *
     * @param isActive the is active
     */
    public void setIsActive(boolean isActive) {
        addLogFile("setIsActive");

        this.isActive = isActive;

    }


    /**
     * Gets log files.
     *
     * @return the log files
     * @throws NotAutorizedException the not autorized exception
     */
    public Vector<String> getLogFiles() throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("getLogFiles");

        return this.logFiles;
        // work
    }

    /**
     * Gets log files.
     *
     * @param limit the limit
     * @return the log files
     * @throws NotAutorizedException the not autorized exception
     */
    public List<String> getLogFiles(int limit) throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("getLogFiles");

        return this.logFiles.stream().limit(limit).collect(Collectors.toList());
        // work
    }

    /**
     * Gets lang.
     *
     * @return the lang
     * @throws NotAutorizedException the not autorized exception
     */
    public LANGUAGES getLang() throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("getLang");

        return this.lang;
    }

    /**
     * Sets lang.
     *
     * @param lang the lang
     * @throws NotAutorizedException the not autorized exception
     */
    public void setLang(LANGUAGES lang) throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("setLang");

        this.lang = lang;
    }


    @Override
    public String toString(){
        return "Name: " + getName() + ", Surname: " + getSurname();
    }

    /**
     * Login boolean.
     *
     * @param password the password
     * @return the boolean
     */
    public boolean login(String password) {
        addLogFile("login");

        if(this.password.equals(password)) {
            this.isActive = true;
            return true;
        } else{
            return false;
        }
    }

    /**
     * Logout.
     */
    public void logout() {
        isActive = false;
        addLogFile("logout");

    }

    /**
     * Kidai exception.
     *
     * @throws NotAutorizedException the not autorized exception
     */
    public void kidaiException() throws NotAutorizedException{
        throw new NotAutorizedException("Autorize");
    }

    /**
     * Cancel subscriptions.
     *
     * @param journal the journal
     * @throws NotAutorizedException the not autorized exception
     */
    public void cancelSubscriptions(ResearhJournal journal) throws NotAutorizedException{
        if(!isActive) kidaiException();
        addLogFile("cancelSubscriptions");

        journal.getMembers().remove(this); // WORK
    }

    /**
     * Subcribe to journal.
     *
     * @param journal the journal
     * @throws NotAutorizedException the not autorized exception
     */
    public void subcribeToJournal(ResearhJournal journal) throws NotAutorizedException, IOException, ClassNotFoundException {
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        dataBase.addResearchJournal(journal);
        addLogFile("subcribeToJournal");
        journal.addMember(this); // WORK
    }

    /**
     * Gets subscriptions.
     *
     * @return the subscriptions
     * @throws NotAutorizedException the not autorized exception
     */
    public Vector<ResearhJournal> getSubscriptions() throws NotAutorizedException, IOException, ClassNotFoundException {
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        addLogFile("getSubscriptions");

        return dataBase.getUserSubscriptions(this); // WORK
    }

    /**
     * Send message.
     *
     * @param to          the to
     * @param messageText the message text
     * @throws NotAutorizedException the not autorized exception
     */
    public void sendMessage(User to, String messageText) throws NotAutorizedException, IOException, ClassNotFoundException {
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        Message message = new Message(this, to,  messageText);
        dataBase.addMessageToUser(message);
        addLogFile("sendMessage");

    }

    /**
     * Gets message.
     *
     * @return the message
     * @throws NotAutorizedException the not autorized exception
     */
    public Vector<Message> getMessage() throws NotAutorizedException, IOException, ClassNotFoundException {
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMessagesOfUser(this);
    }

    /**
     * Gets send message.
     *
     * @return the send message
     * @throws NotAutorizedException the not autorized exception
     */
    public Vector<Message> getSendMessage() throws NotAutorizedException, IOException, ClassNotFoundException {
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMessageWhichSendUser(this);
    }

    /**
     * Change to new data of user.
     *
     * @param newDataUser the new data user
     * @throws NotAutorizedException the not autorized exception
     */
    public void changeToNewDataOfUser(User newDataUser) throws NotAutorizedException{
        if(!isActive) kidaiException();

        this.name = newDataUser.getName();
        this.surname = newDataUser.getSurname();
        this.password = newDataUser.getPassword();
        this.isActive = newDataUser.isActive;
        this.lang = newDataUser.getLang();
        addLogFile("changeToNewDataOfUser");

    }

    @Override
    public boolean equals(Object obj) {

        User user = (User) obj;
        if(user == this) return true;
        if(this.name.equals(user.getName()) && this.surname.equals(user.getSurname())
                && this.password.equals(user.password) && (this.isActive == user.getIsActive())) return true;
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, password, isActive, logFiles, lang);
    }

    /**
     * Add log file.
     *
     * @param s the s
     */
    public void addLogFile(String s){
        logFiles.add(s);
    }
    public int compareTo(User o) {
        if(this.getName().compareTo(o.getName()) != 0){
            return this.getName().compareTo(o.getName());
        }
        return this.getSurname().compareTo(o.getSurname());
    }

}
