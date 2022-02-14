package com.qipeng.general;

import java.util.Date;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/10 22:31
 */
public class TestGeneral {

    public static void main(String[] args) {
        DateInter dateInter = new DateInter();
        dateInter.setFirst(new Date());
        // dateInter.setLast(new Object()); // 编译错误
    }

    private static void test() {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }

    // 使用Pair<? extends Number>是的方法接受所有泛型类型为Number或Number子类的Pair类型
    // 这种使用<? extends Number>的泛型定义称之为上界通配符（Upper Bounds Wildcards)，即把泛型类型T的上界限定在Number
    private static int add(Pair<? extends Number> pair) {
        Number first = pair.getFirst();
        Number last = pair.getLast();

        return first.intValue() + last.intValue();
    }
}
