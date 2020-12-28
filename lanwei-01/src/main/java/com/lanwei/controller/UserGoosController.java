package com.lanwei.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanwei.pojo.GoosInfo;
import com.lanwei.pojo.User;
import com.lanwei.service.UserService;

@RestController
public class UserGoosController {

	@Autowired
	private UserService userService;


	//查询用户信息
	@RequestMapping("/commodityInfo")
	public Map doGet(@RequestBody User entity,@RequestBody GoosInfo userInfo) {

		//根据前端传来的商品名称查询商品信息
		List<GoosInfo>goosList=userService.findByName(userInfo.getGoosname());

		//根据传来的账号查询个人信息
		List<User>userList=userService.queryByUsername(entity.getAccount());

		HashMap<String, List> map = new HashMap<>();

		map.put("商品信息",goosList);
		map.put("用户信息",userList);
		return map;     	
	}
}
