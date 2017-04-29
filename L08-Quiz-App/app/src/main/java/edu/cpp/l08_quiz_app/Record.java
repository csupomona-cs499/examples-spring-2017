package edu.cpp.l08_quiz_app;

/**
 * Created by yusun on 4/26/17.
 */

public class Record {
    private String name;
    private Long timespent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimespent() {
        return timespent;
    }

    public void setTimespent(Long timespent) {
        this.timespent = timespent;
    }

    public String toString() {
        return name + " : " + timespent;
    }
}
