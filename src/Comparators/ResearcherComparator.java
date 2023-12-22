package Comparators;
import Actors.*;
import Interfaces.Researcher;

import java.util.*;

public class ResearcherComparator implements Comparator<Researcher>{
    @Override
    public int compare(Researcher o1, Researcher o2) {
        boolean b1 = o1.isResearcher();
        boolean b2 = o2.isResearcher();
        int ib1 = 0, ib2 = 0;
        if(b1){
            ib1 = 1;
        }
        if(b2){
            ib1 = 1;
        }
        if(ib1 == ib1) return 0;
        else if(ib1 > ib2) return 1;
        else return -1;
    }
}
