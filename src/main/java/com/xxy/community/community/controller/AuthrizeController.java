package com.xxy.community.community.controller;

import com.xxy.community.community.dto.AccessTokenDTO;
import com.xxy.community.community.dto.GitHubUser;
import com.xxy.community.community.entity.User;
import com.xxy.community.community.provider.GitHubProvider;
import com.xxy.community.community.service.UserService;
import com.xxy.community.community.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @ClassName AuthrizeController
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/8 14:33
 * @Vrrsion 1.0
 **/
@Controller
public class AuthrizeController extends BaseController{

    @Autowired
    private GitHubProvider gitHubProvider;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Value("${github.client.id}")
    private String clienId;

    @Value("${github.redirect.uri}")
    private String uri;

    @Value("${github.client.secret}")
    private String secret;



    @GetMapping("/callback")
    public String Callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(uri);
        accessTokenDTO.setClient_id(clienId);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret(secret);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser gitHubUser =gitHubProvider.getUsert(accessToken);
        if(gitHubUser != null){
            //登录成功
            request.getSession().setAttribute("user",gitHubUser);
            User user = new User();
            String token =UUID.randomUUID().toString();
            user.setId(get32UUID());
            user.setAccountId(String.valueOf(gitHubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setName(gitHubUser.getName());
            user.setToken(token);
            user.setAvatarUrl(gitHubUser.getAvatarUrl());
            response.addCookie(new Cookie("token",token));
            userServiceImpl.inserUser(user);
            return "redirect:/";
        }else {
            //登录失败
            return "redirect:/";
        }
    }
}
