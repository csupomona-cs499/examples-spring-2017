package edu.cpp.l08_quiz_app;

/**
 * Created by yusun on 4/26/17.
 */

public class Question {

    private int num1;
    private int num2;
    private int operator;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public String toString() {
        return num1 + " + " + num2 + " = ?";
    }

    public int getCorrectAnswer() {
        return num1 + num2;
    }
}
