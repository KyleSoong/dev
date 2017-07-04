package com.song.dev.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.song.dev.model.UserInfo;
import com.song.dev.service.IUserService;
 
 
@Controller  
@RequestMapping("/user")  
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource  
	private IUserService userService;
     
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