package com.lanwei.controller;


import java.util.List;

/*  实现短信验证登录  刘锦煌 2020-09-28*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lanwei.pojo.User;
import com.lanwei.service.UserService;
import com.lanwei.vo.Response;


@RestController
@RequestMapping("/api")
public class CodeController {

	@Autowired
	private UserService userService;

	//注册
	@RequestMapping(value ="/zhuce",method = RequestMethod.POST)
	public Response shortMessageSend(@RequestBody User user){

		//1.判断手机号码是否正确
		if(StringUtils.isEmpty(user.getPhoneNum())) {
			return new Response(false,"手机号码为空",-1,null);
		}
		//2.判断账号是否为空
		if(StringUtils.isEmpty(user.getAccount())) {
			return new Response(false,"账号为空",-1,null);
		}
		//3.判断流水号是否为空
		if(StringUtils.isEmpty(user.getSerial())) {
			return new Response(false,"流水号为空",-1,null);
		}
		//4.判断流水号的哈希码值是否相同
		if(!user.getSerial().equals(user.getImei().hashCode())) {
			return new Response(false,"流水号错误",-1,null);
		}
		//5.添加到数据库
		userService.addUser(user);
		
		List<User> list1 = userService.queryByUsername(user.getAccount());
		return  new Response(true,"成功",1,list1);
	}
	
	//登录    暂时保留
	@RequestMapping(value ="/denglu",method = RequestMethod.POST)
	public Response login(@RequestBody User user){
		
		if(StringUtils.isEmpty(user.getSerial())) {
			return new Response(false,"流水号为空",-1,null);
		}


		userService.addUser(user);

		return new Response(true,"登录成功",1,null);
	}
}