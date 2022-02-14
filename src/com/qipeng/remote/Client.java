package com.qipeng.remote;

import com.qipeng.remote.remoteService.CalculatorService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * クライアント
 */
public class Client {

    public static void main(String[] args) throws Exception {
        // サーバに接続する
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        // calculatorServiceという名前のサーバを探し、実装する
        CalculatorService calculatorService = (CalculatorService) registry.lookup("calculatorService");

        // メソッドコール
        double ret0 = calculatorService.Arithmetic("add", 1, 1);
        double ret1 = calculatorService.Arithmetic("sub", 5, 3);
        double ret2 = calculatorService.Arithmetic("mult", 1.5, 4.2);
        double ret3 = calculatorService.Arithmetic("div", 12.5, 8);

        System.out.println(ret0);
        System.out.println(ret1);
        System.out.println(ret2);
        System.out.println(ret3);
    }
}
