package Actors;

import Enums.*;
import Exceptions.*;

import java.util.*;
import java.util.stream.Collectors;

import Main.*;
import Date.*;
import Task.*;

/**
 * @generatedo
 */
public abstract class User implements Comparable<User>{

    /**
     * @generated
     */
    public String name;
    public String surname;


    /**
     * @generated
     */
    private String password;

    /**
     * @generated
     */
    public boolean isActive;

    /**
     * @generated
     */
    private Vector<String> logFiles;

    /**
     * @generated
     */
    public LANGUAGES lang;

    public User(){
        logFiles = new Vector<String>();
    }


    public User(String name, String surname, String password, LANGUAGES lang){
        this();
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.lang = lang;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        addLogFile("getSurname");
        return surname;
    }


    /**
     * @generated
     */
    public String getName(){
        addLogFile("getName");

        return this.name;
    }

    /**
     * @generated
     */
    public void setName(String name) throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("setName");

        this.name = name;
    }


    /**
     * @generated
     */
    public String getPassword() throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("getPassword");

        return this.password;
    }

    /**
     * @generated
     */
    public void setPassword(String password) throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("setPassword");

        this.password = password;
    }

    public String getWhoIs(){
        addLogFile("getWhoIs");

        return this.getClass().getName();
    }


    /**
     * @generated
     */
    public boolean getIsActive() {
        addLogFile("getIsActive");

        return this.isActive;
//        work
    }

    /**
     * @generated
     */
    public void setIsActive(boolean isActive) {
        addLogFile("setIsActive");

        this.isActive = isActive;

    }


    /**
     * @generated
     */
    public Vector<String> getLogFiles() throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("getLogFiles");

        return this.logFiles;
        // work
    }
    public List<String> getLogFiles(int limit) throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("getLogFiles");

        return this.logFiles.stream().limit(limit).collect(Collectors.toList());
        // work
    }

    /**
     * @generated
     */
    public LANGUAGES getLang() throws NotAutorizedException {
        if(!isActive) kidaiException();
        addLogFile("getLang");

        return this.lang;
    }

    /**
     * @generated
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
     * @generated
     */
    public boolean login(String password) {
        addLogFile("login");

        if(this.password == password) {
            this.isActive = true;
            return true;
        } else{
            return false;
        }
    }

    /**
     * @generated
     */
    public void logout() {
        isActive = false;
        addLogFile("logout");

    }

    public void kidaiException() throws NotAutorizedException{
        throw new NotAutorizedException("Autorize");
    }

    public void cancelSubscriptions(ResearhJournal journal) throws NotAutorizedException{
        if(!isActive) kidaiException();
        addLogFile("cancelSubscriptions");

        journal.getMembers().remove(this); // WORK
    }
    public void subcribeToJournal(ResearhJournal journal) throws NotAutorizedException{
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        dataBase.addResearchJournal(journal);
        addLogFile("subcribeToJournal");
        journal.addMember(this); // WORK
    }

    public Vector<ResearhJournal> getSubscriptions() throws NotAutorizedException{
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        addLogFile("getSubscriptions");

        return dataBase.getUserSubscriptions(this); // WORK
    }

    public void sendMessage(User to, String messageText) throws NotAutorizedException{
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        Message message = new Message(this, to,  messageText);
        dataBase.addMessageToUser(message);
        addLogFile("sendMessage");

    }

    public Vector<Message> getMessage() throws NotAutorizedException{
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMessagesOfUser(this);
    }

    public Vector<Message> getSendMessage() throws NotAutorizedException{
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMessageWhichSendUser(this);
    }

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
