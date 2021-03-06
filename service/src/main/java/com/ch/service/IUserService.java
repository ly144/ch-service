package com.ch.service;

import com.ch.models.UserLogin;
import com.ch.models.UserResponse;

/**
 * 用户操作接口
 */
public interface IUserService {
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 操作结果
     */
    UserResponse login(String username, String password);

    /**
     * 用户注册
     *
     * @param userLogin 用户信息
     * @return 操作结果
     */
    String register(UserLogin userLogin);

    int changeEmail(String email, int id);

    int changePhone(String phone, int id);

    int changePass(String password, int id);

    /**
     * 刷新密钥
     *
     * @param oldToken 原密钥
     * @return 新密钥
     */
    String refreshToken(String oldToken);
}
