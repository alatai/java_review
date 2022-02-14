package com.qipeng.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 13:40
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载器
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)  // 代理对象对应的自定义InvocationHandler
        );
    }
}
