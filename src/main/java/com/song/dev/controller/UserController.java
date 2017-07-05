package com.song.dev.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.song.dev.model.UserInfo;
import com.song.dev.service.IUserService;
 
 
@Controller  
//@RequestMapping("/user")  
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource  
	private IUserService userService;
    
	@RequestMapping("/register")
	public String toRegister(HttpServletRequest request,Model model){
		return "views/register";
	}

	@RequestMapping("/login")
	public String toLogin(HttpServletRequest request,Model model){
		return "views/login";
	}
	
	@RequestMapping("/doRegister")
	public String doRegister(HttpServletRequest request,Model model){
		return "";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest request,Model model){
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String remenmberMe = request.getParameter("rememberMe");
		logger.info("User:{} Login With Password：{}", userId, password);
		UsernamePasswordToken token = new UsernamePasswordToken(userId, password);
		Subject subject = SecurityUtils.getSubject();
		String msg = "";
		try{
			subject.login(token);
			if(subject.isAuthenticated()){
				return "/showUser?id=1";
			}else{
				return "login";
			}
		}catch(Exception e){
			msg="登陆失败";
		}
		return "login";
	}
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		String userId = request.getParameter("id");
		logger.info("get UserInfo,id={}",userId);
		UserInfo user = this.userService.getUserById(Integer.valueOf(userId));
		model.addAttribute("user", user);
		return "views/showUser";
	}
	@RequestMapping("/createUser")
	public String addUser(HttpServletRequest request,Model model){
		String uid = this.userService.createUser();
		model.addAttribute("userId", uid);
		return "views/showUser";
	}
}