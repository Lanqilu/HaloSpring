package com.halo.resolver;

import com.halo.anno.CurrentUser;
import com.halo.entity.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author Halo
 * @create 2021/11/19 下午 05:32
 * @description 自定义参数解析器
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    public CurrentUserMethodArgumentResolver() {
        System.out.println("CurrentUserMethodArgumentResolver 自定义参数解析器初始化...");
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 如果 Controller 的方法参数类型为 User 同时还加入了 CurrentUser 注解，则返回 true
        return parameter.getParameterType().equals(User.class) &&
                parameter.hasParameterAnnotation(CurrentUser.class);
    }

    // 当 supportsParameter 方法返回 true 时执行此方法
    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        System.out.println("参数解析器...");
        // 此处直接模拟了一个 User 对象，实际项目中可能需要从请求头中获取登录用户的令牌然后进行解析，
        // 最终封装成User对象返回即可，这样在 Controller 的方法形参就可以直接引用到 User 对象了
        User user = new User(1L, "admin");

        return user;
    }
}