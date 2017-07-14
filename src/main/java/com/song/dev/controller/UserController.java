package com.song.dev.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
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
import com.song.dev.service.IAuthService;
import com.song.dev.service.IUserService;
import com.song.dev.util.Constants;
 
 
@Controller  
//@RequestMapping("/user")  
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource  
	private IUserService userService;
	@Resource
	private IAuthService authService;

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
		logger.info("新用户注册：用户名【{}】,邮箱【{}】,密码【{}】.",uInfo.getUsername(),uInfo.getEmail(),uAuth.getCredential());
		authService.encryptPassword(uAuth);
		userService.createUser(uInfo, uAuth);
		Map<String,Object> resultMap = new HashMap<String, Object>(); 
		resultMap.put("message", "注册成功！");
		resultMap.put("status", 200);
		logger.info("新用户【{}】注册成功,登陆帐号为【{}】。",uInfo.getUsername(),uInfo.getEmail());
		return resultMap;
	}
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public Map<String,Object> doLogin(HttpServletRequest request,Model model){
		String identifier = request.getParameter("identifier");
		String credential = request.getParameter("credential");
		String remenmberMe = request.getParameter("rememberMe");
		logger.info("User【{}】 Login With Password【{}】。", identifier, credential);
		String msg = "";
		String backUrl = "";
		Map<String,Object> resultMap = new HashMap<String, Object>(); 
		try{
			UsernamePasswordToken token = new UsernamePasswordToken(identifier, credential);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			if(subject.isAuthenticated()){
				backUrl="/showUser?id=1";
			}
		}catch(UnknownAccountException e) {
			msg="用户名不存在";
		}catch(IncorrectCredentialsException e) {
			msg="密码不正确";
		}catch(DisabledAccountException e) {
			msg="用户被冻结";
		}catch(Exception e){
			msg="授权失败";
		}
		resultMap.put("message", msg);
		resultMap.put("back_url", backUrl);
		return resultMap;
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