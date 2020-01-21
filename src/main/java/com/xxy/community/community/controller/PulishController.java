package com.xxy.community.community.controller;

import com.xxy.community.community.entity.PageData;
import com.xxy.community.community.service.impl.PublishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

/**
 * @ClassName PulishController
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/10 15:33
 * @Vrrsion 1.0
 **/
@Controller
@RequestMapping(value = "/PlishController")
public class PulishController extends BaseController{

    @Autowired
    private PublishServiceImpl publishServiceImpl;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/addQuestion")
    @ResponseBody
    public String addQuestion(){
        PageData pd =this.getPageData();
        String flag ="error";
        if (getUser() == null){
            flag = "user is null";
        }else {
            pd.put("id",get32UUID());
            pd.put("createuser",getUser().getId());
            pd.put("createtime",System.currentTimeMillis());
            flag = publishServiceImpl.addQuestion(pd);
        }
        return flag;
    }
}
