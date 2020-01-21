package com.xxy.community.community.service;

import com.xxy.community.community.entity.PageData;
import com.xxy.community.community.entity.User;
import com.xxy.community.community.provider.Page;

import java.util.List;

public interface UserService {
    public void inserUser(User user);

    public User findUserToken(String token);

    public List<PageData> findUserPageList(Page page);
}
