package com.qipeng.factory;

import java.time.LocalDate;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/09/08 23:15
 */
public class Main {

    public static void main(String[] args) {
        LocalDate localDate = LocalDateFactory.fromInt(20220908);
        System.out.println(localDate);
    }
}
