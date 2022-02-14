package com.qipeng.annotation;

import com.qipeng.core.oop.Person;

import java.lang.reflect.Field;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/10 21:11
 */
public class TestAnnotation {

    public static void main(String[] args) throws IllegalAccessException {
        Person p = new Person();
        p.setName("a");

        System.out.println(p);

        check(p);
    }

    // 第三方程序用于解析注解，赋予注解意义
    private static void check(Person person) throws IllegalAccessException {
        for (Field field : person.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Range range = field.getAnnotation(Range.class);

            if (range != null) {
                Object value = field.get(person);

                if (value instanceof String) {
                    String str = (String) value;

                    if (str.length() < range.min() || str.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }
}
