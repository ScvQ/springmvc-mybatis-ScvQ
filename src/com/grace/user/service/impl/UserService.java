package com.grace.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grace.user.dao.UserDao;
import com.grace.user.entity.User;
import com.grace.user.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public Map<String, Object> login(String username, String password) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int a = this.userDao.getUserByUsernameAndPassword(username, password);
		
		if(a == 1){
			map.put("errcode", 1);
			map.put("errmsg", "Landed successfully");
		}else{
			map.put("errcode", 0);
			map.put("errmsg", "Wrong username or password");
		}
		
		return map;
	}

	@Override
	public User getUserByUsername(String username) {
		
		User user = this.userDao.getUserByUsername(username);
		
		return user;
	}

	@Override
	@Transactional
	public Map<String, Object> regist(User user) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int a = this.userDao.addUser(user);
		
		if(a == 1){
			map.put("errcode", 1);
			map.put("errmsg", "Registration success");
		}
		
		return map;
	}

	@Override
	public Map<String, Object> findUserByUsername(String username) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int a = this.userDao.findUserByUsername(username);
		
		if(a == 1){
			map.put("errcode", 0);
			map.put("errmsg", "Username already exists");
		}
		
		return map;
	}

}
