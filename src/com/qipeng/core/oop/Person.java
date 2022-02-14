package com.qipeng.core.oop;


import com.qipeng.annotation.Range;

// 正常情况下，只要某个class没有final修饰符，那么任何类都可以从该class继承
// 如果一个class定义了方法，但没有具体执行代码，这个方法就是抽象方法，抽象方法用abstract修饰
// 使用abstract修饰的类就是抽象类，无法实例化一个抽象类
// abstract在方法中也同样适用
public class Person {

    @Range(min = 10, max = 20)
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void run() {
        System.out.println("person -> run()");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
