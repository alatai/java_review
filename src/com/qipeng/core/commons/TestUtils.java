package com.qipeng.core.commons;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class TestUtils {

    public static void main(String[] args) {
        // Random用来创建伪随机数（只要给定一个初始的种子，产生的随机数序列是完全一样的）
        // Math.random()实际上内部调用了Random类
        Random r = new Random();
        System.out.println(r.nextInt());
        System.out.println(r.nextInt(10));
        System.out.println(r.nextInt(10));
        System.out.println(r.nextInt(10));

        // SecureRandom用来创建安全的随机数
        // 实际上真正的随机数只能通过量子力学原理获取
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextInt(100));


        // SecureRandom无法指定种子，它使用RNG(random number generator)算法
        // JDK的SecureRandom实际上有多种不同的底层实现
        // 有的使用安全随机数算法，有的使用真正的随机数生成器
        // 实际使用的时候，可以优先获取高强度的安全随机数生成器，如果没有，再使用普通等级的
        SecureRandom sr2 = null;

        try {
            // 获取高强度安全随机数生成器
            sr2 = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            // 获取普通的安全随机数生成器
            sr2 = new SecureRandom();
        }

        byte[] buffer = new byte[16];
        sr2.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
    }

}

/*
 SecureRandom的安全性是通过操作系统提供的安全随机种子来生成随机数
 这个种子是通过CPU的热噪声、读写磁盘的字节、网络流量等各种随机事件产生的“熵”
 */