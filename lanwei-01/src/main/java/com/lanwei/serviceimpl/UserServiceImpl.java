package com.lanwei.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanwei.mapper.GoosInfoMapper;

import com.lanwei.mapper.UserMapper;
import com.lanwei.pojo.GoosInfo;

import com.lanwei.pojo.User;
import com.lanwei.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private GoosInfoMapper goosInfoMapper;


	@Override
	public int addUser(User entity){

		int count = userMapper.addUser(entity);

		return count;
	}
	@Override
	public List <User> queryByUsername(String account){
		List <User> userList = userMapper.queryByUsername(account);

		return userList;
	}

	@Override
	public List<GoosInfo> findByName(String goosname) {

		return goosInfoMapper.findByName(goosname);
	}
	





}