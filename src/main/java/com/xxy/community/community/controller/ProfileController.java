package com.xxy.community.community.controller;

import com.xxy.community.community.entity.PageData;
import com.xxy.community.community.provider.Page;
import com.xxy.community.community.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName ProfileController
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/19 14:06
 * @Vrrsion 1.0
 **/

@Controller
@RequestMapping(value = "/ProfileController")

public class ProfileController extends BaseController{

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/profile/{action}")
    public String profile(Model model, @PathVariable(name = "action") String action, Page page){
        PageData pd =this.getPageData();
        if("question".equals(action)){
            model.addAttribute("section","question");
        }else if("replies".equals(action)){
            model.addAttribute("section","replies");

        }
        model.addAttribute("sectionName","我的提问");
        pd.put("userid",this.getUser().getId());
        //获取问题列表信息
        page.setPd(pd);

        List<PageData> userList =userServiceImpl.findUserPageList(page);
        model.addAttribute("userList", userList);
        model.addAttribute("page", page);
        return "profile";
    }
}
