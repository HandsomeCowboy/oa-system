package com.oasystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oasystem.pojo.TUser;
import com.oasystem.services.UserService;

@Controller
public class LoginAction {
	@Autowired
	private UserService userService;
	@RequestMapping("user_login")
	public String userLogin(String username,String password) {
		TUser loginUser = new TUser();
		loginUser.setcUsername(username);
		loginUser.setcPassword(password); 
 		TUser queryUser = userService.queryUser(loginUser);
		System.out.println(queryUser);
		if(null != queryUser && !"".equalsIgnoreCase(queryUser.getcUsername())) {
			System.out.println(123232323);
			System.out.println(123);
			return "redirect:/index.html";
		}else {
			System.out.println("µÇÂ¼Ò³Ãæ");
			return "redirect:/login.html";
		}
	}
}
