package Main;

import Date.DataBase;
import Enums.OrderStatus;
import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;
/**
 * @generated
 */
public class TechSupportSpecialist extends Employee {

    private boolean isResearcher;

    /**
     * @generated
     */
    public MessageSupport getTask() {
        DataBase dataBase = DataBase.getInstance();
        return dataBase.getMessageSupport();
    }

    /**
     * @generated
     */
    public void ChangeToDone(){
        this.getTask().setStatus(OrderStatus.DONE);
    }

    /**
     * @generated
     */
    public void ChangeToAccepted(){
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
