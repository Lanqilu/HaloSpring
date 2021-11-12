package com.halo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Halo
 * @create 2021/11/12 下午 04:26
 * @description 过滤所有提交到服务器的请求参数
 */
public class XssFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 传入重写后的 Request
        filterChain.doFilter(new XssRequestWrapper(request), servletResponse);
    }
}