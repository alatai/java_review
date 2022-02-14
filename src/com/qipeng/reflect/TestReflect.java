package com.qipeng.reflect;

public class TestReflect {

    public static void main(String[] args) {
        // 除了int等基本类型外，Java的其他类型全部都是class（包括interface）
        // class（包括interface）的本质是数据类型（Type）。无继承关系的数据类型无法复制
        // Number num = new Double(123.456); // OK
        // String str = new Double(123.456); // compile error!

        // class是由JVM在执行过程中动态加载的。JVM在第一次读取到一种class类型时，将其加载进内存
        // 每加载一种class，JVM就为其创建一个Class类型的实例，并关联起来

        // 以String类为例，当JVM加载String类时，它首先读取String.class文件到内存
        // 然后，为String类创建一个Class实例并关联起来

        // 反射的目的是为了获得某个实例的信息
        // 拿到某个Object实例时，可以通过反射获取该Object的class信息
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);

        // 动态加载
        // JVM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存
        // 而是第一次需要用到class时才加载
        // 利用动态加载的特性，才能在运行期根据条件加载把不同的实现类
    }

    private static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());

        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }

        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
