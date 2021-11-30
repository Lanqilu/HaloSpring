package com.halo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Halo
 * @create 2021/11/30 下午 03:32
 * @description 全局异常处理
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    // 异常处理方法，Controller 发生异常后会执行此方法，在此进行统一处理
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        System.out.println("统一处理异常信息:" + e.getMessage());
        return "系统错误";
    }
}