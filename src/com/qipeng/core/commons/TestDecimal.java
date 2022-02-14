package com.qipeng.core.commons;

import java.math.BigDecimal;

public class TestDecimal {

    public static void main(String[] args) {
        // BigDecimal可以表示一个任意大小且精度完全准确的浮点数
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.multiply(bd)); //15241.55677489

        // BigDecimal用scale()表示小数位数
        BigDecimal d1 = new BigDecimal("123.45");
        BigDecimal d2 = new BigDecimal("123.4500");
        BigDecimal d3 = new BigDecimal("1234500");
        System.out.println(d1.scale()); // 2
        System.out.println(d2.scale()); // 4
        System.out.println(d3.scale()); // 0

        // 通过stripTrailingZeros()方法
        // 可以将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal
        d1 = new BigDecimal("123.4500");
        d2 = d1.stripTrailingZeros();
        System.out.println(d1.scale()); // 4
        System.out.println(d2.scale()); // 2

        // 如果一个BigDecimal的scale()返回负数
        // 例如 -2，表示这个数是整数，并且末尾有2个0
        d3 = new BigDecimal("1234500");
        BigDecimal d4 = d3.stripTrailingZeros();
        System.out.println(d3.scale()); // 0
        System.out.println(d4.scale()); // -2

        // 在比较BigDecimal的值是否相等时
        // 使用equals()方法不但要求两个BigDecimal的值相等，还要求他们的scale()相等
        d1 = new BigDecimal("123.456");
        d2 = new BigDecimal("123.45600");
        System.out.println(d1.equals(d2)); // false
        System.out.println(d1.equals(d2.stripTrailingZeros())); // true
        System.out.println(d1.compareTo(d2)); // 0
    }
}
