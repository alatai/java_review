package com.qipeng.reflect;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/09 21:45
 */
public class TestInherit {

    public static void main(String[] args) throws Exception {
        // 当我们获取到某个Class对象时，实际上就获取到了一个类的类型
        Class<String> cls = String.class; // 获取到String的Class
        // 还可以用实例的getClass()方法获取
        String s = "";
        Class<? extends String> cls1 = s.getClass();
        // 通过Class.forName("")，传入Class的完整类名获取
        Class<?> cls2 = Class.forName("java.lang.String");
        // 三种方式获取的Class实例都是同一个实例，因为JVM对每个加载的Class只创建一个Class实例来表示它的类型

        // 获取父类的Class
        Class<Integer> i = Integer.class;
        Class<? super Integer> n = i.getSuperclass();
        System.out.println(n);

        Class<? super Integer> o = n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());

        // 获取interface
        // getInterface()只返回当前类直接实现的接口类型，并不包括父类实现的接口类型
        Class<?>[] is = i.getInterfaces();

        for (Class<?> c : is) {
            System.out.println(c);
        }
    }
}
