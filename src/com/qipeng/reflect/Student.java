package com.qipeng.reflect;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/09 20:38
 */
public class Student extends Person {

    public int score;
    private int grade;

    public Student() {

    }

    public Student(String name) {
        super(name);
    }

    public int getScore() {
        return 99;
    }

    private int getGrade() {
        return 1;
    }

    @Override
    public void hello() {
        System.out.println("Student:hello");
    }
}
