package com.qipeng.factory;

import java.time.LocalDate;
import java.util.List;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/09/08 23:10
 */
public class LocalDateFactory {

    public static LocalDate fromInt(int ld) {
        LocalDate dt;
        String date = String.valueOf(ld);

        if (date.length() != 8) {
            throw new IllegalArgumentException("参数非法,请输入yyyyMMdd格式的数字：" + ld);
        }

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));

        //判断month是否合法
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException("非法参数，月份不能超过1~12");
        }

        //判断day是否合法
        if (day <= 0 || day > 31) {
            throw new IllegalArgumentException("非法参数，日不能超过1~31");
        }

        //判断day是否合法
        judgeDay(year, month, day);
        dt = LocalDate.of(year, month, day);

        return dt;
    }

    /**
     * 判断day是否合法
     */
    static void judgeDay(int year, int month, int day) {
        boolean leapYearFlag = judgeLeapYear(year);

        //平年的2月不能超过28天
        if ((!leapYearFlag) && (month == 2) && (day > 28)) {
            throw new IllegalArgumentException("非法参数day：" + day + ", " + year + "是平年，2月不能超过28天");
        }

        //闰年的2月不能超过29天
        if (leapYearFlag && (month == 2) && (day > 29)) {
            throw new IllegalArgumentException("非法参数day：" + day + ", " + year + "是闰年，2月不能超过29天");
        }

        //小月不能超过30天
        boolean bigMonthFlag = judgeMonth(month);

        if ((!bigMonthFlag) && day > 30) {
            throw new IllegalArgumentException("非法参数day：" + day + ", " + month + "月份不能超过30天");
        }
    }

    /**
     * 判断是否闰年
     *
     * @param year
     * @return
     */
    static boolean judgeLeapYear(int year) {
        //能被400整除的是闰年
        if ((year % 400) == 0) {
            return true;
        }

        //能被4整除但不能被100整除的是闰年
        //不满足上述2个条件的则是平年
        return (year % 4) == 0 && (year % 100) != 0;

    }

    /**
     * 判断是否大月
     *
     * @param month
     * @return
     */
    static boolean judgeMonth(int month) {
        List<Integer> bigMonth = List.of(1, 3, 5, 7, 8, 10, 12);

        return bigMonth.contains(month);
    }
}
