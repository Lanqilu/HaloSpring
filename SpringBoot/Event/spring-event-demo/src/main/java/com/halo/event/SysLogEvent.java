package com.halo.event;

import com.halo.dto.OptLogDTO;
import org.springframework.context.ApplicationEvent;

/**
 * @author Halo
 * @create 2021/11/12 下午 11:09
 * @description 定义系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {
    public SysLogEvent(OptLogDTO optLogDTO) {
        super(optLogDTO);
    }
}