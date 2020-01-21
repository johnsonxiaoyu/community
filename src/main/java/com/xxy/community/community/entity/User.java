package com.xxy.community.community.entity;

import lombok.Data;

/**
 * @ClassName User
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/9 13:23
 * @Vrrsion 1.0
 **/
@Data
public class User {

    private String id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModifid;
    private String avatarUrl;


}
