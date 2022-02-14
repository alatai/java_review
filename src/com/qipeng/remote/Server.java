package com.qipeng.remote;

import com.qipeng.remote.remoteService.CalculatorService;
import com.qipeng.remote.remoteService.impl.CalculatorServiceImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * サーバ
 */
public class Server {

    public static void main(String[] args) throws Exception {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        // com.qipeng.remote タイプに変換する
        CalculatorService remoteCalculatorService = (CalculatorService) UnicastRemoteObject.exportObject(calculatorService, 0);

        // RMIのデフォルトポート == 1099
        Registry registry = LocateRegistry.createRegistry(1099);
        // サーバをインストールする
        registry.rebind("calculatorService", remoteCalculatorService);
    }
}
