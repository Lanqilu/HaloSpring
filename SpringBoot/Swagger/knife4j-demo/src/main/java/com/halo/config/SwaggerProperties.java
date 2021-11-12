package com.halo.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * 配置属性类，用于封装接口文档相关属性，从配置文件读取信息封装成当前对象
 */

@Data
@ConfigurationProperties(prefix = "halo.swagger")
public class SwaggerProperties {
    // 标题
    private String title = "在线文档";
    // 自定义组名
    private String group = "";
    // 描述
    private String description = "在线文档";
    // 版本
    private String version = "1.0";
    // 联系人
    private Contact contact = new Contact();
    // Swagger 会解析的包路径
    private String basePackage = "com.halo.controller";
    // Swagger 会解析的url规则
    private List<String> basePath = new ArrayList<>();
    // 在 basePath 基础上需要排除的 url 规则
    private List<String> excludePath = new ArrayList<>();
    // 分组文档
    private Map<String, DocketInfo> docket = new LinkedHashMap<>();

    public String getGroup() {
        if (group == null || "".equals(group)) {
            return title;
        }
        return group;
    }

    @Data
    public static class DocketInfo {
        private String title = "在线文档";
        private String group = "";
        private String description = "在线文档";
        private String version = "1.0";
        private Contact contact = new Contact();
        private String basePackage = "";
        private List<String> basePath = new ArrayList<>();
        private List<String> excludePath = new ArrayList<>();

        public String getGroup() {
            if (group == null || "".equals(group)) {
                return title;
            }
            return group;
        }
    }

    @Data
    public static class Contact {
        //联系人
        private String name = "halo";
        // 联系人 url
        private String url = "";
        // 联系人 email
        private String email = "885240677@qq.com";
    }
}