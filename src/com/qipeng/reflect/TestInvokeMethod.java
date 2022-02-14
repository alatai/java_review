package com.qipeng.reflect;

import java.lang.reflect.Method;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/09 21:19
 */
public class TestInvokeMethod {

    public static void main(String[] args) throws Exception {
        // Method getMethod(name, Class...)：获取某个public的Method（包括父类）
        // Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
        // Method[] getMethods()：获取所有public的Method（包括父类）
        // Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）

        Class<Student> studentClass = Student.class;
        // 获取public方法getScore
        System.out.println(studentClass.getMethod("getScore"));
        // 获取继承的public方法getName
        System.out.println(studentClass.getMethod("getName"));
        // 获取private方法getGrade
        System.out.println(studentClass.getDeclaredMethod("getGrade"));

        // 调用方法
        String s = "Hello World";
        Method m = String.class.getMethod("substring", int.class);
        String r = (String) m.invoke(s, 6);
        System.out.println(r);

        // 调用静态方法
        Method m1 = Integer.class.getMethod("parseInt", String.class);
        Integer n = (Integer) m1.invoke(null, "12345");
        System.out.println(n);

        // 调用非public方法
        // 对于非public方法，虽然可以通过Class.getDeclaredMethod()获得该方法的实例
        // 但直接对其调用将得到一个IllegalAccessException
        // 为了调用非public方法，通过Method.setAccessible(true)允许其调用
        // setAccessible(true)可能会失败。如果JVM运行期间存在SecurityManager
        // 那么它会根据规则进行检测，有可能会阻止setAccessible(true)
        Person p = new Person();
        Method m2 = p.getClass().getDeclaredMethod("setName", String.class);
        m2.setAccessible(true);
        m2.invoke(p, "Bod");
        System.out.println(p.getName());

        // 多态
        Method h = Person.class.getMethod("hello");
        h.invoke(new Student());
    }
}
