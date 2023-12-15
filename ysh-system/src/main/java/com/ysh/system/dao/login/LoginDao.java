package com.ysh.system.dao.login;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysh.common.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginDao extends BaseMapper<User> {
}
