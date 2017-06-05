package com.grace.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.grace.user.entity.User;

@Repository("userDao")
public interface UserDao {
	
	@Select(" SELECT COUNT(1) FROM t_user u WHERE u.c_username=#{username} AND u.c_password=#{password} ")
	public int getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	@Select(" SELECT uc_id,u.c_username,u.c_password,u.c_sex,u.c_age,u.c_phoneno FROM t_user u WHERE u.c_username=#{username} ")
	public User getUserByUsername(@Param("username") String username);
	
	@Insert(" INSERT INTO t_user(c_id,c_username,c_password,c_sex,c_age,c_phoneno) VALUES(#{id},#{username},#{password},#{sex},#{age},#{phoneno}) ")
	public int addUser(User user);
	
	@Select(" SELECT COUNT(1) FROM t_user u WHERE u.c_username=#{username} ")
	public int findUserByUsername(@Param("username") String username);
	
}
