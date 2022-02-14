package com.qipeng.lambda;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/07 21:34
 */
public class Demo4LambdaImpl {

    public static void main(String[] args) {
        goSwimming(() -> System.out.println("Lambda..."));
    }

    public static void goSwimming(Swimmable swimmable) {
        swimmable.swimming();
    }
}
