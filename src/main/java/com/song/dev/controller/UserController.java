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
       int userId = Integer.parseInt(request.getParameter("id"));  
       int id = userId;
       User user = this.userService.getUserById(id);  
       model.addAttribute("user", user);  
       return "sites/showUser";
   }
}