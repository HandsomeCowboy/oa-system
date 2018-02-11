package com.oasystem.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 验证用户登录
 * @author Administrator
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object obj, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object obj, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception {
		System.out.println("进入拦截器");
		String loginStatus = (String) req.getSession().getAttribute("loginStatus");
		System.out.println("loginStatus:"+loginStatus);
		if("true".equalsIgnoreCase(loginStatus)) {
			System.out.println("用户登录成功");
			return true;
		}else {
			System.out.println("用户登录失败");
			resp.sendRedirect("login.html");
			return false;
		}
	}
}
