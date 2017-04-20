package edu.cpp.l05_http;

/**
 * Created by yusun on 4/19/17.
 */

public class Test {

    static class Student {
        private String name;
        private String major;

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

        public String toString() {
            return "Name: " + name + ", Major: " + major;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("yu");
        System.out.println(s1);
    }
}
