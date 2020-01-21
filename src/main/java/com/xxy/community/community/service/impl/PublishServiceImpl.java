package com.xxy.community.community.service.impl;

import com.xxy.community.community.entity.PageData;
import com.xxy.community.community.mapper.PublishMapper;
import com.xxy.community.community.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName PublishServiceImpl
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/15 15:12
 * @Vrrsion 1.0
 **/

@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    PublishMapper publishMapper;

    @Override
    public String addQuestion(PageData pd) {
        int i=publishMapper.addQuestion(pd);
        if(i>0){
            return "true";
        }
        return "false";
    }
}
