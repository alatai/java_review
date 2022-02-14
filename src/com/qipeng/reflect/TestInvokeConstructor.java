package com.qipeng.reflect;

import java.lang.reflect.Constructor;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/09 21:40
 */
public class TestInvokeConstructor {

    public static void main(String[] args) throws Exception {
        // getConstructor(Class...)：获取某个public的Constructor
        // getDeclaredConstructor(Class...)：获取某个Constructor
        // getConstructors()：获取所有public的Constructor
        // getDeclaredConstructors()：获取所有Constructor

        // 获取构造方法Integer(int)
        Constructor<Integer> c = Integer.class.getConstructor(int.class);
        // 调用构造方法
        Integer n = c.newInstance(123);
        System.out.println(n);

        // 获取构造方法Integer(String)
        Constructor<Integer> c1 = Integer.class.getConstructor(String.class);
        Integer n1 = c1.newInstance("12345");
        System.out.println(n1);

        // Constructor总是当前类定义的构造方法，和父类无关，因此不存在多态问题
        // 调用非public的Constructor时，必须首先通过setAccessible(true)设置允许访问，有可能会失败
    }
}
