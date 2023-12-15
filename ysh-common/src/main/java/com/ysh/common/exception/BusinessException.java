package com.ysh.common.exception;

import com.ysh.common.ctrl.ResultCode;
import lombok.Data;

/**
 * 自定义业务异常
 *
 * @author likunming
 * @date 2023/12/06 09:50:53
 */
@Data
public class BusinessException extends RuntimeException {
    private int errorCode;

    public BusinessException() {
    }

    public BusinessException(String msg) {
        super(msg);
        this.errorCode = ResultCode.FAILURE.getCode();
    }

    public BusinessException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }
}
