package com.oasystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oasystem.pojo.TUser;
import com.oasystem.services.UserService;
import com.oasystem.util.MD5Utils;
@Controller
public class UserAction {
	@Autowired
	UserService userService;
	//�����һ���û�
	@RequestMapping(value="user_save.action",method = RequestMethod.POST)
	public String saveUser(TUser tuser){
		System.out.println("_________________________");
		System.out.println(tuser);
//		//���û�������MD5����
//		String password = tuser.getPassword();
//		System.out.println("-----------------"+password);
//		String md5 = MD5Utils.md5(password);
//		tuser.setPassword(md5);
//		//�����û���Ϣ
//		userService.saveUser(tuser);
		
		return "OK";
	}
}
