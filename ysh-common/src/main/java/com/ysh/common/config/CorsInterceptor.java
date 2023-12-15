package com.ysh.common.config;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * 暂无用
 */

public class CorsInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 此处配置的是允许任意域名跨域请求，可根据需求指定
        String origin = request.getHeader("origin");
        if(null!=origin){
            String rqHeader = URLEncoder.encode(origin, "UTF-8");
            response.setHeader("Access-Control-Allow-Origin", rqHeader);
        }

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,  POST");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Access-Control-Allow-Headers", "*");

        // 如果是OPTIONS则结束请求
//        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
//            response.setStatus(HttpStatus.NO_CONTENT.value());
//            return false;
//        }
        return true;
    }
}
