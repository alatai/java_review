package com.qipeng.proxy;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 15:11
 */
public class AliSmsService {

    public String send(String message) {
        System.out.println("send message: " + message);
        return message;
    }
}
