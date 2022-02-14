package com.qipeng.core.grammar;


import java.util.Scanner;

@SuppressWarnings({"ConstantConditions", "unused"})
public class GrammarReview {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // var关键字：省略变量类型，可以使用var关键字
        // 编译器会根据语句自动推断出类型
        // var sb2 = new StringBuilder();

        // ++n表示先加1再引用n，n++表示先引用n再加1

        // 类型自动提升与强制转换
        // 在运算的过程中，如果参加运算的两个数类型不一致，那么计算结果为较大类型
        // 整数运算的结果永远是精确的

        // NaN: Not a Number
        // Infinity: 无穷大
        // -Infinity: 负无穷大

        // 格式化输出
        // %d：整数、%x：十六进制整数、%f：浮点数、%e：科学计数法表示的浮点数、%s：格式化字符串
        System.out.printf("format is %s \n", "printf");

        // 输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your name: ");
        String name = scanner.nextLine();
        System.out.printf("Hello %s", name);

        // 浮点数在计算机中常常无法精确表示，并且计算可能出现误差，判断浮点数相等用“==”不合适
        // 正确的方法是利用差值小于某个临界值来判断
        double x = 1 - 9.0 / 10;

        if (Math.abs(x - 0.1) < 0.00001) {
            System.out.println("x is 0.1");
        } else {
            System.out.println("x is NOT 0.1");
        }

        // Java 12以后的switch语句
        String fruit = "mango";

        // 新语法使用->，如果有多余的语句，需要用{}括起来
        // 不要写break语句，新语法只会执行匹配的语句，没有穿透效应
        switch (fruit) {
            case "apple" -> System.out.println("Selected apple");
            case "pear" -> System.out.println("Selected pear");
            case "mango" -> {
                System.out.println("Selected mango");
                System.out.println("Good choice!");
            }
            default -> System.out.println("No fruit selected");
        }

        // 利用switch赋值
        int opt = switch (fruit) {
            case "apple" -> 1;
            case "pear", "mango" -> 2;
            default -> {
                System.out.println("No fruit selected");
                // yield 返回一个值作为switch语句的返回值
                yield fruit.hashCode();
            }
        };

        System.out.println("opt = " + opt);
    }
}
