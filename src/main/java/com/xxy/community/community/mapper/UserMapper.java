package com.xxy.community.community.mapper;

import com.xxy.community.community.entity.PageData;
import com.xxy.community.community.entity.User;
import com.xxy.community.community.provider.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public void addUser(User user);

    public User findUserToken(String token);

    public List<PageData> findUserPageList(Page page);
}
