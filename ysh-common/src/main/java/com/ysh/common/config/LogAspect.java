package com.ysh.common.config;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 接口入参出参日志打印
 *
 * @author likunming
 * @date 2023/12/11 09:32:45
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void logPointCut() {
        log.info("1231223123123213");
    }

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint pj) throws Throwable {
        MethodSignature methodSignature = (MethodSignature)pj.getSignature();
        //访问的类全路径
        String declaringTypeName = methodSignature.getDeclaringTypeName();
        //方法名
        String methodName = methodSignature.getName();
        //参数
        Object[] args = pj.getArgs();
        //方法的返回类
        Class returnType = methodSignature.getReturnType();
        //入参类
        Class[] parameterTypes = methodSignature.getParameterTypes();

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //请求url
        String requestURI = "";
        if (requestAttributes != null) {
            requestURI = requestAttributes.getRequest().getRequestURI();
        }

        if (parameterTypes.length == 1) {
            String jsonString = JSONObject.toJSONString(args[0]);
            log.info("url : {}, {} {}( {} ) request data : {}", requestURI, declaringTypeName, methodName, parameterTypes[0].getName(), jsonString);
        }
        else if (parameterTypes.length > 1) {
            JSONArray jsonArray = JSONArray.from(args);
            log.info("url : {}, {} {}( {} ) request data : {}", requestURI, declaringTypeName, methodName, parameterTypes, jsonArray);
        }
        else {
            log.info("url : {}, {} {}() request data : ", requestURI, declaringTypeName, methodName);
        }

        //执行当前方法，并获取返回参数
        Object responseData = pj.proceed();
        log.info("{} {} {}( {} ) response data : {}", returnType.getName(), declaringTypeName, methodName, parameterTypes, responseData);

        return responseData;
    }

    /**
     * 两种写法
     * ..表示多级目录
     */
//    @Around("execution(* com.ysh.*.controller..*(..))")
//    public Object logAround2(ProceedingJoinPoint pj) throws Throwable {
//        return pj.proceed();
//    }

}
