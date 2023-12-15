package com.ysh.common.ctrl;

import lombok.Data;
import java.util.Optional;

@Data
public class R<T> {
    private static final long serialVersionUID = 1L;

    private boolean isSuccess;
    private int code;
    private String msg;
    private T data;

    private R() {
    }

    private R(boolean isSuccess, int code) {
        this.isSuccess = isSuccess;
        this.code = code;
    }

    private R(boolean isSuccess, int code, String msg) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.msg = msg;
    }

    public R(boolean isSuccess, int code, String msg, T data) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private R(IResultCode resultCode) {
        resultCode = Optional.ofNullable(resultCode).orElse(ResultCode.FAILURE);
        this.isSuccess = resultCode.getIsSuccess();
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }

    private R(IResultCode resultCode, T data) {
        this.isSuccess = resultCode.getIsSuccess();
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        this.data = data;
    }

    private R(IResultCode resultCode, String msg) {
        this.isSuccess = resultCode.getIsSuccess();
        this.code = resultCode.getCode();
        this.msg = msg;
    }

    private R(IResultCode resultCode, String msg, T data) {
        this.isSuccess = resultCode.getIsSuccess();
        this.code = resultCode.getCode();
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> ok() {
        return new R<T>(ResultCode.SUCCESS);
    }

    public static <T> R<T> ok(String msg) {
        return new R<T>(ResultCode.SUCCESS, msg);
    }

    public static <T> R<T> ok(T data) {
        return new R<T>(ResultCode.SUCCESS, data);
    }

    public static <T> R<T> ok(String msg, T data) {
        return new R<T>(ResultCode.SUCCESS, msg, data);
    }

    public static <T> R<T> fail() {
        return new R<T>(ResultCode.FAILURE);
    }

    public static <T> R<T> fail(String msg) {
        return new R<T>(ResultCode.FAILURE, msg);
    }

    public static <T> R<T> fail(T data) {
        return new R<T>(ResultCode.FAILURE, data);
    }

    public static <T> R<T> fail(String msg, T data) {
        return new R<T>(ResultCode.FAILURE, msg, data);
    }

    public static <T> R<T> fail(IResultCode resultCode, T data) {
        return new R<T>(resultCode, data);
    }

    public static <T> R<T> fail(IResultCode resultCode, String msg, T data) {
        return new R<T>(resultCode, msg, data);
    }
}
