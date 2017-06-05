package com.grace.user.controller;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grace.user.entity.User;
import com.grace.user.service.IUserService;
import com.grace.user.util.json.JsonUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	@RequestMapping("login")
	public void login(HttpServletRequest request,Model model){
		
	}
	
	@ResponseBody
	@RequestMapping("check_login")
	public String checklogin(HttpServletRequest request,@RequestParam("username")String username, @RequestParam("password")String password){
		
		Map<String, Object> map = this.userService.login(username, password);
		
		String result = JsonUtil.getJsonFromObject(map);
		
		User user = this.userService.getUserByUsername(username);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("username", username);
		
		return result;
	}
	
	@RequestMapping("regist")
	public void regist(HttpServletRequest request,Model model){
		
	}
	
	@ResponseBody
	@RequestMapping("check_regist")
	public String checkregist(HttpServletRequest request,@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("sex")String sex,@RequestParam("age")String age,@RequestParam("phoneno")String phoneno){
		
		Map<String, Object> map = this.userService.findUserByUsername(username);
		
		String result = null;
		
		if(map == null || map.size() < 1){
			User user = new User();
			user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			user.setUsername(username);
			user.setPassword(password);
			user.setSex(Integer.parseInt(sex));
			user.setAge(Integer.parseInt(age));
			user.setPhoneno(phoneno);
			Map<String, Object> map1 = this.userService.regist(user);
			result = JsonUtil.getJsonFromObject(map1);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}else{
			result = JsonUtil.getJsonFromObject(map);
		}
		
		return result;
		
	}
	
	@RequestMapping("success")
	public void success(){
		
	}

}
