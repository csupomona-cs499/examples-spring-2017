package edu.cpp.l09_data_sync;

/**
 * Created by yusun on 5/3/17.
 */

public class Student {

    private int id;
    private String name;
    private String major;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return name;
    }
}
