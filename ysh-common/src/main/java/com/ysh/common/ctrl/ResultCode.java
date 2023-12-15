package com.ysh.common.ctrl;


public enum ResultCode implements IResultCode {
    SUCCESS(true,200, "操作成功"),
    FAILURE(false,400, "业务异常"),
    UN_AUTHORIZED(false,401, "请求未授权"),
    CLIENT_UN_AUTHORIZED(false,401, "客户端请求未授权"),
    NOT_FOUND(false,404, "404 没找到请求"),
    MSG_NOT_READABLE(false,400, "消息不能读取"),
    METHOD_NOT_SUPPORTED(false,405, "不支持当前请求方法"),
    MEDIA_TYPE_NOT_SUPPORTED(false,415, "不支持当前媒体类型"),
    REQ_REJECT(false,403, "请求被拒绝"),
    INTERNAL_SERVER_ERROR(false,500, "服务器异常"),
    ;

    private final boolean isSuccess;
    private final int code;
    private final String message;

    @Override
    public int getCode() {
        return this.code;
    }
    @Override
    public boolean getIsSuccess() {
        return isSuccess;
    }
    @Override
    public String getMessage() {
        return this.message;
    }

    private ResultCode(final boolean isSuccess, final int code, final String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}

