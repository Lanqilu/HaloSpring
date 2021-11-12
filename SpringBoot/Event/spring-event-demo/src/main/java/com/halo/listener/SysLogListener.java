package com.halo.listener;

import com.halo.dto.OptLogDTO;
import com.halo.event.SysLogEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Halo
 * @create 2021/11/12 下午 11:10
 * @description 异步监听日志事件
 */
@Component
public class SysLogListener {
    // 异步处理
    @Async
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        OptLogDTO sysLog = (OptLogDTO) event.getSource();
        long id = Thread.currentThread().getId();
        System.out.println("监听到日志操作事件：" + sysLog + " 线程id：" + id);
        // 将日志信息保存到数据库...
    }
}
