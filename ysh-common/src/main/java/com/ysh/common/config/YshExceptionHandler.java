package com.ysh.common.config;

import com.ysh.common.ctrl.R;
import com.ysh.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常统一处理
 *
 * @author likunming
 * @date 2023/12/06 10:54:18
 */
@Slf4j
@ControllerAdvice
public class YshExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public R businessExceptionHandler(BusinessException exception) {
        log.error("业务异常：{}", exception.getMessage());
        return R.fail(exception.getMessage());
    }
}
