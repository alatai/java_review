package com.qipeng.jdbc.util;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/12/31 20:48
 */
public class ConnectionPool {

    private static final ConnectionPool CONNECTION_POOL = new ConnectionPool();


    private ConnectionPool() {}

    public static ConnectionPool getInstance() {
        return CONNECTION_POOL;
    }
}
