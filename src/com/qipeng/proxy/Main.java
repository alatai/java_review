package com.qipeng.proxy;

import com.qipeng.proxy.cglib.CglibProxyFactory;
import com.qipeng.proxy.jdk.JdkProxyFactory;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 13:43
 */
public class Main {

    public static void main(String[] args) {
        // jdk动态代理
        SmsService proxyByJdk = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        proxyByJdk.send("jdk");

        // CGLIB动态代理
        AliSmsService proxyByCglib = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        proxyByCglib.send("cglib");
    }
}
