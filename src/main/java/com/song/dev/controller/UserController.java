package com.song.dev.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.dev.model.UserAuth;
import com.song.dev.model.UserInfo;
import com.song.dev.service.IPasswordService;
import com.song.dev.service.IUserService;
import com.song.dev.util.Constants;
 
 
@Controller  
//@RequestMapping("/user")  
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource  
	private IUserService userService;
	@Resource
	private IPasswordService passwordService;
    
	@RequestMapping("/register")
	public String toRegister(HttpServletRequest request,Model model){
		System.out.println("register page...");
		return "views/register";
	}

	@RequestMapping("/login")
	public String toLogin(HttpServletRequest request,Model model){
		return "views/login";
	}
	
	@RequestMapping(value="/doRegister", method=RequestMethod.POST)
	@Scope("prototype")
	@ResponseBody
	public Map<String,Object> doRegister(HttpServletRequest request, UserInfo uInfo){
		//UserInfo uInfo = new UserInfo();
		UserAuth uAuth = new UserAuth();
		uInfo.setUsername(request.getParameter("name"));
		uInfo.setEmail(request.getParameter("email"));
		uAuth.setIdentifier(uInfo.getEmail());
		uAuth.setIdentityType(Constants.IdentityType.EMAIL);
		uAuth.setCredential(request.getParameter("password"));
		passwordService.encryptPassword(uAuth);
		userService.createUser(uInfo, uAuth);
		Map<String,Object> resultMap = new HashMap<String, Object>(); 
		resultMap.put("message", "注册成功！");
		resultMap.put("status", 200);
		logger.info("新用户【{}】注册成功，登陆帐号为【{}】。",uInfo.getUsername(),uInfo.getEmail());
		return resultMap;
	}
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public String doLogin(HttpServletRequest request,Model model){
		String identifier = request.getParameter("identifier");
		String credential = request.getParameter("credential");
		String remenmberMe = request.getParameter("rememberMe");
		logger.info("User:{} Login With Password：{}", identifier, credential);
		String msg = "";
		try{
			UsernamePasswordToken token = new UsernamePasswordToken(identifier, credential);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			if(subject.isAuthenticated()){
				return "/showUser?id=1";
			}else{
				return "login";
			}
		}catch(Exception e){
			msg="登陆失败";
		}
		return "{\"message\", \""+msg+"！\")";
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