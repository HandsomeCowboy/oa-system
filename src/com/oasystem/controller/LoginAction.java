package com.oasystem.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oasystem.pojo.TUser;
import com.oasystem.services.UserService;
import com.oasystem.util.MD5Utils;

@Controller
public class LoginAction {
	@Autowired
	private UserService userService;
	@RequestMapping("user_login")
	public String userLogin(String username,String password,HttpSession session) {
		TUser loginUser = new TUser();
		String md5 = MD5Utils.md5(password);
		loginUser.setcUsername(username);
		loginUser.setcPassword(md5);
		System.out.println(md5);
   		TUser queryUser = userService.queryUser(loginUser);
		System.out.println(queryUser);
		if(null != queryUser && !"".equalsIgnoreCase(queryUser.getcUsername())) {
			session.setAttribute("loginStatus", "true");
			System.out.println("用户登录成功");
			return "redirect:/index.action";
		}else {
			System.out.println("用户登录失败，重定向到登录页面");
			return "redirect:/login.html";
		}
	}
	@RequestMapping("user_logout")
	public void userLogout(HttpSession session,HttpServletResponse resp) {
		session.removeAttribute("loginStatus");
		try {
			resp.getWriter().write("logoutSuccess");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*访问WebContent下的index.jsp跳转到index.action*/
	@RequestMapping("index.action")
	public String index(){
		return "index";//返回WEB-INF下的index.jsp
	}
}
