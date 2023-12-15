package com.ysh.common.ctrl;

import java.io.Serializable;

public interface IResultCode extends Serializable {
    boolean getIsSuccess();
    String getMessage();
    int getCode();
}