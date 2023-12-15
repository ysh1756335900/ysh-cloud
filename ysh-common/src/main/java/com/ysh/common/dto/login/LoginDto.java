package com.ysh.common.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotBlank(message = "用户名不能为空")
    private String loginName;
    @NotBlank(message = "密码不能为空")
    private String password;
}
