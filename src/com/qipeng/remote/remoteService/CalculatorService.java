package com.qipeng.remote.remoteService;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 電卓インタフェース
 */
public interface CalculatorService extends Remote {

    double Arithmetic(String operation, double x, double y) throws RemoteException;
}
