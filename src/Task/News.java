package Task;

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
public class News {

    /**
     * @generated
     */
    private String title;

    /**
     * @generated
     */
    private String content;

    /**
     * @generated
     */
    private Vector<String> comments;



    /**
     * @generated
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @generated
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * @generated
     */
    public String getContent() {
        return this.content;
    }

    /**
     * @generated
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * @generated
     */
    public Vector<String> getComments() {
        return this.comments;
    }

    /**
     * @generated
     */
    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public void delComment(String comment) {
        this.comments.remove(comment);
    }

}
