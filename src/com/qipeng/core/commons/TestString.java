package com.qipeng.core.commons;

import java.util.Arrays;

@SuppressWarnings({"ConstantConditions", "StringEquality"})
public class TestString {

    public static void main(String[] args) {
        // 字符串比较
        // 比较两个字符串的内容是否相同，必须使用equals而不是==
        String str1 = "hello";
        String str2 = "hello";

        // Java编译器在编译器，会自动把所有相同的字符串当作一个对象放入常量池
        // == 比较返回 true 纯属巧合
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        // 是否包含子串
        System.out.println("Hello".contains("ll"));

        // 提取子串
        System.out.println("Hello".substring(2));

        // 去除首尾空白字符
        System.out.println("    \tHello\r\n".trim());
        // 与trim()不通过，类似中文的空格字符\u3000也会被移除
        System.out.println("\u3000Hello\u3000".strip());
        System.out.println("\u3000Hello\u3000".trim());

        // 判断字符是否为空和空白
        System.out.println("".isEmpty());
        System.out.println("    ".isEmpty());
        System.out.println(" \n".isBlank());
        System.out.println(" Hello ".isBlank());

        // 替换子串
        String str = "hello";
        str = str.replace("l", "w");
        System.out.println(str);
        // 通过正则表达式

        // 分割字符串，并且传入的也是正则表达式
        str = "A,B,C,D";
        String[] chars = str.split(",");
        System.out.println(Arrays.toString(chars));

        // 拼接字符串
        System.out.println(String.join("", chars));

        // 格式化

        // 类型转换
        System.out.println(String.valueOf(123));

        // 分隔符拼接数组 StringJoiner/String.join()
        String[] names = {"Bob", "Alice", "Grace"};
        var s = String.join(", ", names);
        System.out.println(s);
    }
}

/*
 Java字符串String是不可变对象
 字符串操作不改变原字符串内容，而是返回新字符串
 常用的字符串操作：提取子串、查找、替换、大小写转换符
 Java使用Unicode编码表示String和char
 转换编码就是将String和byte[]转换，需要指定编码
 转换为byte[]时，始终优先考虑UTF-8编码
 */