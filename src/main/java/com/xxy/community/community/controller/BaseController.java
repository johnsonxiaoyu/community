package com.xxy.community.community.controller;




import com.xxy.community.community.entity.PageData;
import com.xxy.community.community.entity.User;
import com.xxy.community.community.provider.Logger;
import com.xxy.community.community.provider.Page;
import com.xxy.community.community.provider.UuidUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 6357869213649815390L;
	/**
	 * 得到PageData
	 */
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}

	/**
	 * 得到当前用户
	 * @return
	 */
	public User getUser(){
		//Subject currentUser = SecurityUtils.getSubject();
		HttpSession session = getRequest().getSession();
		User user = (User)session.getAttribute("user");
		return user;
	}
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}

	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		return request;
	}

	/**
	 * 得到32位的uuid
	 * @return
	 */
	public String get32UUID(){

		return UuidUtil.get32UUID();
	}

	/**
	 * 得到分页列表的信息
	 */
	public Page getPage(){

		return new Page();
	}

	public static void logBefore(Logger logger, String interfaceName){
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}

	public static void logAfter(Logger logger){
		logger.info("end");
		logger.info("");
	}

}
