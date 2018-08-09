package com.ch.service.serviceImpl;

import com.ch.dao.UserMapper;
import com.ch.config.JwtTokenUtil;
import com.ch.models.User;
import com.ch.models.UserLogin;
import com.ch.models.UserResponse;
import com.ch.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户操作接口实现
 */
@Service
public class IUserServiceImpl implements IUserService {

    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private UserMapper userMapper;

    @Autowired
    public IUserServiceImpl(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil, UserMapper userMapper) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse login(String username, String password) {
        System.out.println("1."+username+"-"+password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username); // 用户判断
//        System.out.println(BCrypt.checkpw(password, userDetails.getPassword()));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 使用BCrypt加密算法
        if ( !passwordEncoder.matches(password, userDetails.getPassword()) ) { // 解码
            return null;
        }
        User user = this.userMapper.getUserByName(username);
        return new UserResponse(user.getId(), jwtTokenUtil.generateToken(userDetails)); // 生成令牌
    }

    @Override
    public String register(UserLogin userLogin) {
        String username = userLogin.getUsername();
        if (userMapper.getUserByName(username) != null) {
            return "用户已存在";
        }
//        System.out.println(BCrypt.hashpw(password, BCrypt.gensalt()));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 使用BCrypt加密算法对密码加密
        userLogin.setPassword(passwordEncoder.encode(userLogin.getPassword())); // 给密码加密
        System.out.println(userLogin.getPassword());
        if (userMapper.regis(userLogin) > 0) {
            return "true";
        } else {
            return "false";
        }
    }

    @Override
    public int changeEmail(String email, int id) {
        return this.userMapper.changeEmail(email, id);
    }

    @Override
    public int changePhone(String phone, int id) {
        return this.userMapper.changePhone(phone, id);
    }

    @Override
    public int changePass(String password, int id) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 使用BCrypt加密算法对密码加密
        password = passwordEncoder.encode(password); // 给密码加密
        return this.userMapper.changePass(password, id);
    }

    @Override
    public String refreshToken(String oldToken) {
        String token = oldToken.substring("Bearer ".length());
        if (!jwtTokenUtil.isTokenExpired(token)) { // 判断是否过期
            return jwtTokenUtil.refreshToken(token); // 刷新令牌
        }
        return "false";
    }
}
