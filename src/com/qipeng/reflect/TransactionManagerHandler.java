package com.qipeng.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 *
 * @author Alatai
 * @version 1.0
 * @date 2021/04/12 17:39
 */
@SuppressWarnings("unchecked")
public class TransactionManagerHandler implements InvocationHandler {

    // 真实对象
    private Object target;

    // 获取代理对象
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), // 类加载器
                target.getClass().getInterfaces(), // 需要增强的目标对象的接口
                this // 代理执行处理器
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;

        try {
            // 记录日志
            // 设置事务活动状态
            // 通过反射调用真实对象的方法
            ret = method.invoke(target, args);
            // 提交事务
        } catch (Exception exp) {
            exp.printStackTrace();
            // 回滚事务
        }

        return ret;
    }
}
