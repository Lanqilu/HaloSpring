package com.halo.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Halo
 * @create 2021/11/12 下午 10:26
 * @description Logback 使用方法
 */

public class LogbackTest {
    // 简单使用
    @Test
    public void test1() {
        // 通过工厂获得一个 Logger 日志记录器对象
        Logger logger = LoggerFactory.getLogger("com.halo.logback.HelloWorld");
        logger.debug("[debug] ...");
    }

    // 打印日志内部状态
    @Test
    public void test2() {
        Logger logger = LoggerFactory.getLogger("com.halo.logback.HelloWorld");
        logger.debug("[debug] ...");
        // 打印内部的状态
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }

    // 日志输出级别：ERROR > WARN > INFO > DEBUG > TRACE
    // 测试默认的日志输出级别
    @Test
    public void test3() {
        Logger logger = LoggerFactory.getLogger("com.halo.logback.HelloWorld");
        logger.error("error ...");
        logger.warn("warn ...");
        logger.info("info ...");
        logger.debug("debug ...");
        // 因为默认的输出级别为 debug，所以这一条日志不会输出
        logger.trace("trace ...");
    }

    // 设置日志输出级别
    @Test
    public void test4() {
        // 向下转型
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.halo.logback.HelloWorld");
        logger.setLevel(Level.WARN);
        logger.error("error ...");
        logger.warn("warn ...");
        logger.info("info ...");
        logger.debug("debug ...");
        logger.trace("trace ...");
    }

    // 测试 Logger 的继承
    @Test
    public void test5() {
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.halo");
        logger.setLevel(Level.INFO);
        logger.error("error ...");
        logger.warn("warn ...");
        logger.info("info ...");
        logger.debug("debug ...");
        logger.trace("trace ...");

        // "com.halo.logback" 会继承 "com.halo" 的有效级别
        Logger barLogger = LoggerFactory.getLogger("com.halo.logback");
        // 这条日志会打印，因为 INFO >= INFO
        barLogger.info("子级信息");
        // 这条日志不会打印，因为 DEBUG < INFO
        barLogger.debug("子级调试信息");
    }

    // Logger 获取，根据同一个名称获得的 logger 都是同一个实例
    @Test
    public void test6() {
        Logger logger1 = LoggerFactory.getLogger("com.halo");
        Logger logger2 = LoggerFactory.getLogger("com.halo");
        System.out.println(logger1 == logger2);
    }

    // 参数化日志
    @Test
    public void test7() {
        Logger logger = LoggerFactory.getLogger("com.halo");
        logger.debug("hello {}", "world");
    }
}