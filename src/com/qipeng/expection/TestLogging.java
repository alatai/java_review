package com.qipeng.expection;

import java.util.logging.Logger;

public class TestLogging {

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
    }
}

/*
 JDK的Logging定义了7个日志级别，从严重到普通
    SERVER
    WARNING
    INFO
    CONFIG
    FIN
    FINER
    FINEST
 默认级别是INFO，因此，INFO级别以下的日志，不会被打印出来

 使用Java标准库内置的Logging有以下局限
    Logging系统在JVM启动时读取配置文件并完成初始化，一旦开始运行main()方法，就无法修改配置
    配置不太方便，需要在JVM启动时传递参数-Djava.util.logging.config.file=<config-file-name>
 */
