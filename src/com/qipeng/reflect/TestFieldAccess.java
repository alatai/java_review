package com.qipeng.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestFieldAccess {

    public static void main(String[] args) throws Exception {
        // Field getField(name)：根据字段名获取某个public的field（包括父类）
        // Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
        // Field[] getFields()：获取所有public的field（包括父类）
        // Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）

        Class<Student> studentClass = Student.class;

        // 获取public字段“score”
        System.out.println(studentClass.getField("score"));
        // 获取继承的public字段“name”
        // System.out.println(studentClass.getField("name"));
        // 获取private字段“grade”
        System.out.println(studentClass.getDeclaredField("grade"));

        // 一个Field对象包含了一个字段的所有信息
        Field field = String.class.getDeclaredField("value");

        System.out.println(field.getName());
        System.out.println(field.getType());

        // getModifiers()返回字段的修饰符，是一个int，不同的bit表示不同的含义
        int modifier = field.getModifiers();

        System.out.println(Modifier.isFinal(modifier));
        System.out.println(Modifier.isPublic(modifier));
        System.out.println(Modifier.isProtected(modifier));
        System.out.println(Modifier.isPrivate(modifier));
        System.out.println(Modifier.isStatic(modifier));

        // 获取字段值
        // 利用反射还可以拿到一个实例对应的该字段的值
        Person p = new Person("Xiao Ming");
        Class<?> c = p.getClass();
        Field f = c.getDeclaredField("name");

        // setAccessible(true)可以获取private字段的值
        // 正常情况下，编译器会根据public、protected和private决定是否允许访问字段，这样就达到了数据封装的目的
        // 而反射是一种非常规的用法，使用反射，首先代码非常繁琐
        // 其次，它更多的是给工具或底层框架来使用，目的是在不知道目标实例任何信息的情况下，获取特定字段的值
        // 此外，setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，那么它会根据规则进行检查
        // 有可能组织setAccessible(true)
        f.setAccessible(true);
        Object value = f.get(p);
        System.out.println(value);

        // 设置字段值
        // 通过Field实例既可以获取到指定实例的字段值，也可以设置字段的值
        f.set(p, "Tom");
        System.out.println(p.getName());
    }
}
