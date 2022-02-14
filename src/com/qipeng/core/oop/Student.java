package com.qipeng.core.oop;


public class Student extends Person {

    private int score;
    // 继承是is关系，组合是has关系
    private Book book;

    public Student() {

    }

    public Student(int score) {
        // Java中，任何class的构造方法，第一行必须是父类的构造方法
        // 如果没有的明确地调用父类的构造方法，编译器会自动追加一个无参构造器super()
        // 但是父类必须存在这个无参构造器
        this.score = score;
    }

    public Student(String name, int age, int score) {
        super(name, age);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void run() {
        System.out.println("student -> run()");
    }
}
