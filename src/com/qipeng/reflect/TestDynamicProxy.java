package com.qipeng.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/09 21:53
 */
public class TestDynamicProxy {

    public static void main(String[] args) {
        // 比较Java的class和interface
        // 可以实例化class（非abstract)
        // 不能实例化interface

        // 所有interface类型的变量总是通过向上转型并指向某个实例
        CharSequence cs = new StringBuilder();

        // 不创建实例，在运行期创建某个interface的实例？
        // Java标准库提供了一种动态代理（Dynamic Proxy)的机制：可以在运行期创建某个interface的实例
        // 不去编写实现类，直接通过JDK提供的一个Proxy.newProxyInstance()创建一个Hello接口对象

        // 1)定义一个InvocationHandler实例，它负责实现接口的方法调用
        // 2)通过Proxy.newProxyInstance()创建interface实例
        // ① 使用的ClassLoader，通常就是接口的ClassLoader
        // ② 需要实现的接口数组，至少需要传入一个接口进去
        // ③ 用来处理接口方法调用的InvocationHandler实例
        // 3)将返回的Object强制转换为接口
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);

                if (method.getName().equals("morning")) {
                    System.out.println("Good morning" + args[0]);
                }

                return null;
            }
        };

        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, handler);
        hello.morning("Bod");
    }
}
