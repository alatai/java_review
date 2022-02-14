package com.qipeng.core.commons;

import java.math.BigInteger;

public class TestBigInteger {

    public static void main(String[] args) {
        // java.math.BigInteger用来表示任意大小的整数（内部用int[]来模拟一个非常大的整数）
        BigInteger bi = new BigInteger("1234567890");
        System.out.println(bi.pow(5));

        // 对BigInteger做运算的时候，只能使用实例方法
        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2);

        // 和long型整数运算比，BigInteger不会有范围限制，但是缺点是速度比较慢
        // 可以把BigInteger转换成long
        BigInteger i = new BigInteger("123456789000");
        System.out.println(i.longValue());
        // ArithmeticException: BigInteger out of long range
        System.out.println(i.multiply(i).longValueExact());
    }
}
