package com.xxy.community.community.controller;

import com.xxy.community.community.entity.PageData;
import com.xxy.community.community.provider.Page;
import com.xxy.community.community.service.impl.QuestionServiceImpl;
import com.xxy.community.community.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName Question
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/19 16:05
 * @Vrrsion 1.0
 **/

@Controller
@RequestMapping(value = "/QuestionController")
public class QuestionController extends BaseController{

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

    @GetMapping("/question/{questionId}")
    public String question(@PathVariable(name = "questionId") String questionId,
                           Model model,
                           Page page){

        PageData pd =this.getPageData();
        pd.put("questionId",questionId);
        page.setPd(pd);
        List<PageData> QuestionList=userServiceImpl.findUserPageList(page);
        if(QuestionList.size()>0){
            pd.put("viewcount",QuestionList.get(0).get("viewcount"));
            pd.put("id",QuestionList.get(0).get("id"));
            questionServiceImpl.editQuestion(pd);
        }
        model.addAttribute("QuestionList",QuestionList.get(0));
        model.addAttribute("sectionName","我的问题");
        return "question";
    }
}
