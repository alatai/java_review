package com.qipeng.expection;

public class TestAssert {

    public static void main(String[] args) {
        // 断言（Assertion）是一种调试程序的方法
        // Java中使用assert关键字来实现断言
        double x = Math.abs(-123.45);
        // 语句 assert x >= 0; 即为断言
        // 断言条件 x >= 0 预期为true
        // 如果计算结果为false，则断言失败，抛出AssertionError
        // 可以添加可选断言消息
        assert x >= 0 : "x must >= 0";
        System.out.println(x);

        // Java断言的特点是：断言失败时会抛出AssertionError，导致程序结束退出
        // 因此，断言不能用于可恢复的程序错误，只用用于开发和测试阶段
        // 实际开发中，很少使用断言。更好的方法是编写单元测试
    }
}
