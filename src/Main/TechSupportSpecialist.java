package Main;

import Date.DataBase;
import Enums.OrderStatus;
import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;

import java.io.IOException;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * The type Tech support specialist.
 */
public class TechSupportSpecialist extends Employee {

    private boolean isResearcher;

    /**
     * Instantiates a new Tech support specialist.
     *
     * @param name       the name
     * @param surname    the surname
     * @param password   the password
     * @param lang       the lang
     * @param department the department
     * @param salary     the salary
     */
    public TechSupportSpecialist(String name, String surname, String password, LANGUAGES lang, String department, double salary) {
        super(name, surname, password, lang, department, salary);
        this.isResearcher = false;
    }

    /**
     * Gets task.
     *
     * @return the task
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public MessageSupport getTask() throws IOException, ClassNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMessageSupport();
    }

    /**
     * Change to done.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void ChangeToDone() throws IOException, ClassNotFoundException {
        this.getTask().setStatus(OrderStatus.DONE);
    }

    /**
     * Change to accepted.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void ChangeToAccepted() throws IOException, ClassNotFoundException {
        this.getTask().setStatus(OrderStatus.ACCEPTED);
    }

    @Override
    public boolean isResearcher() {
        return false;
    }

    @Override
    public void setResearcher(boolean isResearcher) {
        this.isResearcher = isResearcher;
    }
}
