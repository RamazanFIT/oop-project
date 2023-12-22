package Comparators;
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
import Main.*;

public class GpaStudentCompare implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        int gpa1, gpa2;
        try {
            gpa1 = (int) o1.getTranscript().getGpa();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            gpa2 = (int) o2.getTranscript().getGpa();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(gpa1 > gpa2){
            return 1;
        } else if(gpa2 > gpa1){
            return -1;
        }
        return 0;
    }
}
