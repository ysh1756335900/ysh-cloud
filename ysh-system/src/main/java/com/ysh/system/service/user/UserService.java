package com.ysh.system.service.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.ysh.common.entity.User;

/**
 * (User)表服务接口
 *
 * @author likunming
 * @since 2023-11-03 10:06:03
 */
public interface UserService extends IService<User> {
    PageInfo<User> selectPageList(Page<User> page, User user);
}

