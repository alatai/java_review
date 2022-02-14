package com.qipeng.core.oop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class TestOOP {

    public static void main(String[] args) throws IntrospectionException {
        // 面向抽象编程使得调用者只关心抽象方法的定义，不关心子类的具体实现
        Person stu = new Student();

        // 多态，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法
        stu.run(); // student -> run()

        // 内省机制
        // 用于查看和操作JavaBean中的属性
        // 获取JavaBean的描述对象（该类和父类)
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);
        // 获取JavaBean中的属性描述器
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor pd : pds) {
            System.out.println(pd.getName());
        }
    }
}

/*
 面向对象编程，是一种通过对象的方式，把现实世界映射都计算机模型的一种编程方法
    class是一种对象模板，它定义了如何创建实例。因此，class本身就是一种数据类型。而instance是对象实例，instance是根据class创建的实例，可以创建多个instance，每个instance类型相同，但各自属性可能不同

 面向抽象编程的本质
    上层代码之定义规范
    不需要子类就可以实现业务逻辑
    具体的业务逻辑由不同的子类实现，调用者不关心

 接口
    Java的接口（interface）定义了纯抽象规范，一个类可以实现多个接口
    接口也是数据类型，适用于向上转型和向下转型
    接口的所有方法都是抽象方法，接口不能定义实例字段
    接口可以定义default方法（JDK >= 1.8）
 */