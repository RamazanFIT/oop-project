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
public class CitationResearchPaperComparator implements Comparator<ResearchPaper>{
    @Override
    public int compare(ResearchPaper o1, ResearchPaper o2) {
        if(o1.getCitation() > o2.getCitation()) return 1;
        else if(o1.getCitation() < o2.getCitation()) return -1;
        else return 0;
    }
}
