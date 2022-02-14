package com.qipeng.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 13:36
 */
public class DebugInvocationHandler implements InvocationHandler {

    // 代理类中的真实对象
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  动态生成的代理类
     * @param method 与代理鳄梨对象调用的方法相对应
     * @param args   当前method方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用方法之前，可以添加自己的操作
        System.out.println("before method " + method.getName());
        // 当
        Object result = method.invoke(target, args);
        // 调用方法之后，同样可以添加自己的操作
        System.out.println("after method " + method.getName());

        return result;
    }
}
