package Comparators;
import Actors.*;

import java.util.*;

/**
 * The type Z to a comparator.
 */
public class ZToAComparator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        if(o1.getName().compareTo(o2.getName()) != 0){
            return -o1.getName().compareTo(o2.getName());
        }
        return -o1.getSurname().compareTo(o2.getSurname());
    }
}
