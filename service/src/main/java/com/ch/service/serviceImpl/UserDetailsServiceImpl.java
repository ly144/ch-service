package com.ch.service.serviceImpl;

import com.ch.dao.UserMapper;
import com.ch.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * 用户验证方法
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        System.out.println("用户存在");
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
