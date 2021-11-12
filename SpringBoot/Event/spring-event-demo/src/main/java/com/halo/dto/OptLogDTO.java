package com.halo.dto;

import lombok.Data;

/**
 * @author Halo
 * @create 2021/11/12 下午 11:07
 * @description
 */
@Data
public class OptLogDTO {
    // 操作 IP
    private String requestIp;
    // 日志类型 LogType{OPT:操作类型;EX:异常类型}
    private String type;
    // 操作人
    private String userName;
    // 操作描述
    private String description;
}
