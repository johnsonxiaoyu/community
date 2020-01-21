package com.xxy.community.community.service.impl;

import com.xxy.community.community.entity.PageData;
import com.xxy.community.community.mapper.QuestionMapper;
import com.xxy.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName QuestionServiceImpl
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/19 20:36
 * @Vrrsion 1.0
 **/

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void editQuestion(PageData pd) {

    }
}
