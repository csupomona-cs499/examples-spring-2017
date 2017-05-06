package edu.cpp.l09_data_storage;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by yusun on 5/1/17.
 */

@Table(name = "student")
public class Student {

    @Column(name = "name")
    private String name;
    @Column(name = "major")
    private String major;
    @Column(name = "age")
    private int age;

    public Student() {
    }

    public Student(String name, String major, int age) {
        this.name = name;
        this.major = major;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                '}';
    }
}
