package com.halo.anno;

import java.lang.annotation.*;

/**
 * @author Halo
 * @create 2021/11/19 下午 05:31
 * @description 绑定当前登录用户
 */

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
