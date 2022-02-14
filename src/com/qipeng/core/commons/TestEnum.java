package com.qipeng.core.commons;

@SuppressWarnings("ConstantConditions")
public class TestEnum {

    public static void main(String[] args) {
        Weekday day = Weekday.MON;

        // enum的比较
        // enum类型的每个常量在JVM中只有一个唯一实例，所以可以直接用==比较
        if (day == Weekday.MON) {
            System.out.println("Weekday.MON");
        }
    }

    enum Weekday {
        SUN, MON, TUE, WED, THU, FRI, SAT;
    }

}

/*
 为了让编译器能自动检查某个值在枚举的集合内，并且不同用途的枚举需要不同的类型来标记、不能混用，可以使用enum
 1)enum常量本身带有信息类型，编译器会自动检查出类型错误
 2)不可能引用到非枚举的值，因为无法通过编译
 3)不同类型的枚举不能互相比较或者赋值，因为类型不符
 */