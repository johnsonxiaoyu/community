package com.xxy.community.community.service.impl;

import com.xxy.community.community.entity.PageData;
import com.xxy.community.community.entity.User;
import com.xxy.community.community.mapper.UserMapper;
import com.xxy.community.community.provider.Page;
import com.xxy.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/9 13:30
 * @Vrrsion 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void inserUser(User user) {
         userMapper.addUser(user);
    }

    @Override
    public User findUserToken(String token) {
        return userMapper.findUserToken(token);
    }

    @Override
    public List<PageData> findUserPageList(Page page) {
        return userMapper.findUserPageList(page);
    }
}
