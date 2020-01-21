package com.xxy.community.community.mapper;

import com.xxy.community.community.entity.PageData;
import org.springframework.stereotype.Repository;

/**
 * @ClassName PublishMapper
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/15 15:13
 * @Vrrsion 1.0
 **/

@Repository
public interface PublishMapper {


    public int addQuestion(PageData pd);
}
