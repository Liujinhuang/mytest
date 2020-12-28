package com.lanwei.service;

import java.util.List;

import com.lanwei.pojo.GoosInfo;


import com.lanwei.pojo.User;
/* 用户信息  */
public interface UserService {
	
	
	//基于商品名称获取商品信息
	List<GoosInfo> findByName(String goosname);
	
	//基于账号获取用户的所有信息
	List<User> queryByUsername(String account);

	int addUser(User entity);//用于添加用户个人信息


}
