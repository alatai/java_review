package com.qipeng.proxy;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 13:31
 */
public class SmsServiceImpl implements SmsService {


    @Override
    public String send(String message) {
        System.out.println("send message: " + message);
        return message;
    }
}
