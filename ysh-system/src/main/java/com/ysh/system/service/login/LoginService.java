package com.ysh.system.service.login;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysh.common.ctrl.R;
import com.ysh.common.dto.login.LoginDto;
import com.ysh.common.entity.User;

/**
 * 用户登录
 *
 * @author likunming
 * @date 2023/11/30 11:36:15
 */
public interface LoginService extends IService<User> {

    /**
     * 用户登录接口
     *
     * @param dto
     * @return
     */
    R login(LoginDto dto);

    /**
     * 用户注册接口
     *
     * @param dto
     * @return
     */
    R register(LoginDto dto);
}
