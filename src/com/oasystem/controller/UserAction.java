package com.oasystem.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oasystem.pojo.TUser;
import com.oasystem.services.UserService;
import com.oasystem.util.MD5Utils;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	
	//新增用户
	@RequestMapping("/user_save")
	public String saveUser(TUser tuser,HttpServletRequest request, HttpServletResponse reponse){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String salary = request.getParameter("salary");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String station = request.getParameter("station");
		String telephone = request.getParameter("telephone");
		tuser.setcUsername(username);
		//MD5加密
		String md5 = MD5Utils.md5(password);
		tuser.setcPassword(md5);
		tuser.setcAge(18);
		tuser.setcId(1);
		tuser.setcRemark("");
		tuser.setcNickname(nickname);
		tuser.setcSalary(salary);
		tuser.setcBirthday(birthday);
		tuser.setcGender(gender);
		tuser.setcStation(station);
		tuser.setcSalary(salary);
		
		//保存用户
		userService.saveUser(tuser);
		
		return "redirect:pages/system/userlist.html";
	}
	/*@RequestMapping("/customer/loginUser")
	public String loginUserCustomer(TUser user, Model model, HttpServletRequest request) {
		TUser tCustomer1 = null;

		List<TUser> selectByName = userService.selectByName(user);
		for (TUser tCustomer : selectByName) {
			System.out.println(
					tCustomer.getUsername() + "-----" + tCustomer.getPassword());
			tCustomer1 = tCustomer;
		}

		if (selectByName.size() != 0) {
			request.getSession().setAttribute("user", tCustomer1);
			return "customer";

		} else {
			model.addAttribute("msg", "�û������������");
			return "login";
		}

	}*/
	@ResponseBody
	@RequestMapping("/user_list")
	public List<TUser> list(HttpServletRequest request,HttpServletResponse reponse) {
		//查询所有用户
		List<TUser> users = userService.findAll();
		System.out.println(users);
		return users;
	}
}
