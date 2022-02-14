package com.qipeng.expection;

import com.sun.tools.javac.Main;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestCommonsLogging {

    // 使用Commons Logging时，如果在静态方法中引用Log，通常直接定义一个静态类型变量
    static final Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        // Commons Logging由Apache创建的日志模块
        // 可以挂接不同的日志系统，并通过配置文件制定挂接的日志系统
        // 默认情况下，Commons Logging自动搜索并使用Log4j
        // 如果没有找到Log4j，再使用JDK Logging
        log.info("start...");
        log.warn("end.");
    }
}
