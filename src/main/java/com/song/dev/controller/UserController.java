package com.song.dev.controller;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
 


import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  

import com.song.dev.model.User;
import com.song.dev.service.IUserService;
 
 
@Controller  
@RequestMapping("/user")  
public class UserController {
   @Resource  
   private IUserService userService;  
     
   @RequestMapping("/showUser")  
   public String toIndex(HttpServletRequest request,Model model){  
       String userId = request.getParameter("id");  
       User user = this.userService.getUserById(userId);  
       model.addAttribute("user", user);  
       return "views/showUser";
   }
   @RequestMapping("/createUser")  
   public String addUser(HttpServletRequest request,Model model){  
       String uid = this.userService.createUser();
       return "views/showUser";
   }
}