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
 * The type Lesson.
 */
public class Lesson implements Serializable {

    private LessonType type;

    private Time duration;

    private Subject subject;

    private Teacher teacher;


    /**
     * Gets type.
     *
     * @return the type
     */
    public LessonType getType() {
        return this.type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(LessonType type) {
        this.type = type;
    }


    /**
     * Gets duration.
     *
     * @return the duration
     */
    public Time getDuration() {
        return this.duration;
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(Time duration) {
        this.duration = duration;
    }


    /**
     * Gets subject.
     *
     * @return the subject
     */
    public Subject getSubject() {
        return this.subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    /**
     * Gets teacher.
     *
     * @return the teacher
     */
    public Teacher getTeacher() {
        return this.teacher;
    }

    /**
     * Sets teacher.
     *
     * @param teacher the teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
