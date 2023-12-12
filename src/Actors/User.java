package Actors;

import Enums.*;
import Exceptions.*;

import java.util.*;
import Main.*;
import Date.*;
import Task.*;

/**
 * @generatedo
 */
public abstract class User {

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

    }


    public User(String name, String surname, String password, LANGUAGES lang){
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.lang = lang;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }


    /**
     * @generated
     */
    public String getName(){

        return this.name;
    }

    /**
     * @generated
     */
    public void setName(String name) throws NotAutorizedException {
        if(!isActive) kidaiException();

        this.name = name;
    }


    /**
     * @generated
     */
    public String getPassword() throws NotAutorizedException {
        if(!isActive) kidaiException();

        return this.password;
    }

    /**
     * @generated
     */
    public void setPassword(String password) throws NotAutorizedException {
        if(!isActive) kidaiException();

        this.password = password;
    }

    public String getWhoIs(){
        return this.getClass().getName();
    }


    /**
     * @generated
     */
    public boolean getIsActive() {
        return this.isActive;
    }

    /**
     * @generated
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    /**
     * @generated
     */
    public Vector<String> getLogFiles() throws NotAutorizedException {
        if(!isActive) kidaiException();

        return this.logFiles;
    }

    /**
     * @generated
     */
    public LANGUAGES getLang() throws NotAutorizedException {
        if(!isActive) kidaiException();

        return this.lang;
    }

    /**
     * @generated
     */
    public void setLang(LANGUAGES lang) throws NotAutorizedException {
        if(!isActive) kidaiException();
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
        if(this.password == password) {
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
    }

    public void kidaiException() throws NotAutorizedException{
        throw new NotAutorizedException("Autorize");
    }

    public void cancelSubscriptions(ResearhJournal journal) throws NotAutorizedException{
        if(!isActive) kidaiException();
        journal.getMembers().remove(this);
    }
    public void subcribeToJournal(ResearhJournal journal) throws NotAutorizedException{
        if(!isActive) kidaiException();
        journal.getMembers().add(this);
    }

    public Vector<ResearhJournal> getSubscriptions() throws NotAutorizedException{
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getUserSubscriptions(this);
    }

    public void sendMessage(User to, String messageText) throws NotAutorizedException{
        if(!isActive) kidaiException();
        DataBase dataBase = DataBase.getInstance();
        Message message = new Message(this, to,  messageText);
        dataBase.addMessageToUser(message);
    }

    public void changeToNewDataOfUser(User newDataUser) throws NotAutorizedException{
        if(!isActive) kidaiException();

        this.name = newDataUser.getName();
        this.surname = newDataUser.getSurname();
        this.password = newDataUser.getPassword();
        this.isActive = newDataUser.isActive;
        this.lang = newDataUser.getLang();
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

    @Override
    public String toString() {
        return super.toString() + ", Name: " + name + ", Surname: " + surname + ", Active: " + isActive + ", Language: " + lang + ", Password: " + getPassword();
    }
}
