package com.ysh.system.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.ysh.system.dao.user.UserDao;
import com.ysh.common.entity.User;
import com.ysh.system.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author likunming
 * @since 2023-11-03 10:06:03
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {


    @Override
    public PageInfo<User> selectPageList(Page<User> page, User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(User::getUserName, user.getUserName());
        List<User> users = baseMapper.selectList(queryWrapper);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }
}

