package com.ysh.system.service.login.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysh.common.ctrl.R;
import com.ysh.common.dto.login.LoginDto;
import com.ysh.common.entity.User;
import com.ysh.common.exception.BusinessException;
import com.ysh.common.util.SM3Util;
import com.ysh.system.dao.user.UserDao;
import com.ysh.system.service.login.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<UserDao, User> implements LoginService {

    @Override
    public R login(LoginDto dto) {
        if (null == dto.getLoginName()) {
            throw new BusinessException("参数不能为空");
        }

        User user = baseMapper.selectByLoginName(dto.getLoginName());
        if (user == null) {
            throw new BusinessException("账号或密码错误");
        }

        String password = dto.getPassword();
        String dbPassword = user.getPassword();
        if (!SM3Util.check(SM3Util.encrypt(password), dbPassword)) {
            throw new BusinessException("账号或密码错误");
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userData", user);
        jsonObject.put("token", "123");
        return R.ok(jsonObject);
    }

    @Override
    public R register(LoginDto dto) {
        User user = new User();
        user.setLoginName(dto.getLoginName());
        user.setPassword(SM3Util.encrypt(dto.getPassword()));
        int insert = baseMapper.insert(user);

        return R.ok("成功");
    }
}
