package com.qipeng.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 14:49
 */
public class DebugMethodInterceptor implements MethodInterceptor {

    /**
     * 用于拦截增强被代理类的方法
     *
     * @param obj         被代理对象（需要增强的对象)
     * @param method      被拦截的方法（需要增强的方法)
     * @param args        方法参数
     * @param methodProxy 用于调动原始方法
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 调用方法之前，添加自己的操作
        System.out.println("before method " + method.getName());
        Object object = methodProxy.invokeSuper(obj, args);
        // 调用方法之后，添加自己的操作
        System.out.println("after method " + method.getName());

        return object;
    }
}
