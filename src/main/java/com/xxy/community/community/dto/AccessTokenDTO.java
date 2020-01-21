package com.xxy.community.community.dto;

import lombok.Data;

/**
 * @ClassName AccessTokenDTO
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/8 14:48
 * @Vrrsion 1.0
 **/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;


}
