package com.qipeng.remote.remoteService.impl;

import com.qipeng.remote.remoteService.CalculatorService;

/**
 * 電卓実現
 */
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double Arithmetic(String operation, double x, double y) {
        double ret = 0d;

        if (operation.equals("add")) {
            ret = x + y;
        } else if (operation.equals("sub")) {
            ret = x - y;
        } else if (operation.equals("mult")) {
            ret = x * y;
        } else if (operation.equals("div") && x != 0) {
            ret = x / y;
        }

        return ret;
    }
}
