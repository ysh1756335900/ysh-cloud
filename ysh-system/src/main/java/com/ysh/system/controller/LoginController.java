package com.ysh.system.controller;

import com.ysh.common.ctrl.R;
import com.ysh.common.dto.login.LoginDto;
import com.ysh.system.service.login.LoginService;
import com.ysh.system.service.user.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author likunming
 * @since 2023-11-03 10:41:06
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public R login(@RequestBody LoginDto dto) {
        return loginService.login(dto);
    }

    @RequestMapping("/register")
    public R register(@Validated @RequestBody LoginDto dto) {
        return loginService.register(dto);
    }

    @RequestMapping("/test")
    public R test() {
        return R.ok();
    }
}
