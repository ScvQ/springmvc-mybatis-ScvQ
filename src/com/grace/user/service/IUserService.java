package com.grace.user.service;

import java.util.Map;

import com.grace.user.entity.User;

public interface IUserService {
	
	Map<String, Object> login(String username, String password);
	
	User getUserByUsername(String username);
	
	Map<String, Object> regist(User user);
	
	Map<String, Object> findUserByUsername(String username);
	
}
