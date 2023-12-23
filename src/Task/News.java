package Task;

import Actors.*;
import Enums.*;
import Exceptions.*;
import Comparators.*;
import Science.*;

import java.io.Serializable;
import java.util.*;
import Interfaces.*;
import Date.*;
import Task.*;

/**
 * The type News.
 */
public class News implements Serializable, Comparable<News> {

    private String title;

    private String content;

    private Vector<String> comments;


    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * Gets comments.
     *
     * @return the comments
     */
    public Vector<String> getComments() {
        return this.comments;
    }

    /**
     * Add comment.
     *
     * @param comment the comment
     */
    public void addComment(String comment) {
        this.comments.add(comment);
    }

    /**
     * Del comment.
     *
     * @param comment the comment
     */
    public void delComment(String comment) {
        this.comments.remove(comment);
    }

    @Override
    public int compareTo(News o) {
        if(this.title.compareTo(o.getTitle()) != 0){
            return this.title.compareTo(o.getTitle());
        }
        return this.content.compareTo(o.getContent());
    }
}
