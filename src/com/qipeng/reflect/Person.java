package com.qipeng.reflect;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/09 20:38
 */
public class Person {

    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("Person:hello");
    }
}
