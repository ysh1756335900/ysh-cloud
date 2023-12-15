package com.ysh.common.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)表实体类
 *
 * @author likunming
 * @since 2023-11-03 10:06:03
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {

    private Long id;

    private String password;

    private String email;
    //0-普通用户; 1-超级管理员; 2-版主;
    private int type;
    //0-未激活; 1-已激活;
    private int status;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    //手机号
    private String mobile;
    //用户名
    private String userName;
    //登录名
    private String loginName;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }
}

