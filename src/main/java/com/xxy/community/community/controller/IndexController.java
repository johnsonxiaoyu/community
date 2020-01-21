package com.xxy.community.community.controller;

import com.xxy.community.community.entity.PageData;
import com.xxy.community.community.entity.User;
import com.xxy.community.community.provider.Page;
import com.xxy.community.community.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GreetingController
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/6 15:47
 * @Vrrsion 1.0
 **/
@Controller
public class IndexController extends  BaseController{

    @Autowired
    private UserServiceImpl userServiceImpl;
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        Page page) {
        PageData pd =this.getPageData();

        //获取问题列表信息
        page.setPd(pd);
        List<PageData> userList =userServiceImpl.findUserPageList(page);
        model.addAttribute("userList", userList);
        model.addAttribute("page", page);
        return "index";
    }
}
