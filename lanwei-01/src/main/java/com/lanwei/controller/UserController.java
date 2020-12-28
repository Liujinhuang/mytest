package com.lanwei.controller;

/*  实现账号密码登录接口   刘锦煌 2020-09-28*/

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserController {

	@Autowired
	private UserService userService;

	protected  static final Logger logger=LoggerFactory.getLogger(UserController.class);
	/* 用户注册  */
	@RequestMapping( value ="/111",method = RequestMethod.POST)
	public Response register(@RequestBody User user){
		//1. 判断账号、密码是否为空
		if( StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword()) ){
			return new Response(false,"账号密码不能为空",-1,null);
		} 
		//判断流水号是否为空
		if(StringUtils.isEmpty(user.getSerial())) {
			return new Response(false,"流水号错误为空",-1,null);
		}
		//判断IMEI是否为空
		if(StringUtils.isEmpty(user.getImei())) {
			return new Response(false,"IMEI不能为空",-1,null);
		}
		//判断随机数是否为空
		if(StringUtils.isEmpty(user.getRandom())) {
			return new Response(false,"随机数错误",-1,null);
		}
		//判断日期是否为空
		if(StringUtils.isEmpty(user.getDate())) {
			return new Response(false,"日期错误",-1,null);
		}
		//判断时间是否为空
		if(StringUtils.isEmpty(user.getTime())) {
			return new Response(false,"时间错误",-1,null);
		}
		if(user.getClientType()==0||user.getClientType()==null) {
			return new Response(false,"终端类型错误",-1,null);
		}
		//3.判断是否有重复账号
		List<User> list =  userService.queryByUsername(user.getAccount());
		if( list.size()==1){
			return new Response(false,"注册失败,账号重复,请更换",-1,null);
		}

		//4.将账号密码添加到数据库中
		userService.addUser(user);  

		List<User>list1=userService.queryByUsername(user.getAccount());

		logger.info("注册成功:"+"姓名:"+user.getUsername()+""+"账号: " + user.getAccount() + " ,密码: " + user.getPassword());
		logger.error("这是错误提示:");
		//
		return new Response(true,"注册成功",1,list1);        
	}


	/* 
	 * 
	 * 
	 * 用户登录
	 * 
	 *  
	 *  
	 *  */
	@RequestMapping(value ="/222",method = RequestMethod.POST)
	public Response  login(@RequestBody User user){
		//    	 String account=request.getParameter("account");//获取账号
		//  	   	 String password=request.getParameter("password");//获取密码   
		//1. 判断账号、密码是否为空
		if( StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword()) ){
			logger.error("账号错误");
			return new Response(false,"账号密码不能为空",-1,null);
		} 
		//判断流水号是否为空
		if(StringUtils.isEmpty(user.getSerial())) {
			return new Response(false,"流水号错误为空",-1,null);
		}
		//判断IMEI是否为空
		if(StringUtils.isEmpty(user.getImei())) {
			return new Response(false,"IMEI不能为空",-1,null);
		}
		//判断随机数是否为空
		if(StringUtils.isEmpty(user.getRandom())) {
			return new Response(false,"随机数错误",-1,null);
		}
		//判断日期是否为空
		if(StringUtils.isEmpty(user.getDate())) {
			return new Response(false,"日期错误",-1,null);
		}
		//判断时间是否为空
		if(StringUtils.isEmpty(user.getTime())) {
			return new Response(false,"时间错误",-1,null);
		}
		String str1=user.getImei();
		Integer a=user.getClientType();
		String str2=Integer.toString(a);
		String str3=user.getDate();
		String str4=user.getTime();
		String str5=user.getRandom();
		String str6=str1+str2+str3+str4+str5;
		String c =String.valueOf(str6.hashCode());

		//判断哈希码值是否相同
		if(!user.getSerial().equals(c)) {
			return new Response(false,"流水号错误",-1,null);
		}
		List<User> users = userService.queryByUsername(user.getAccount());
		//判断流水号是否重复
		if(user.getSerial().equals(users.get(0).getSerial())) {
			return new Response(false,"流水号重复",-1,null);
		}

		//3.查看是否有添加到数据库
		if(users.size()<=0){
			return new Response(false,"账号不存在",-1,null);
		}
		//4.判断前端传来的账号密码是否和数据库的账号密码一致
		if (!user.getAccount().equals(users.get(0).getAccount())||!user.getPassword().equals(users.get(0).getPassword())) {
			return new Response(false,"账号或密码错误",-1,null);
		}
		List<User> list1=userService.queryByUsername(user.getAccount());
		logger.info("登录成功:"+"账号: " + user.getAccount() + " ,密码: " + user.getPassword()+"流水号:"+user.getSerial());
		logger.error("错误信息:");

		return new Response(true,"登录成功",1,list1);
	}
}






//         if(entity.getAccount()!=users.get(0).getAccount() || entity.getPassword()!= users.get(0).getPassword()) {
//        	 return new Response(false,"账号或密码错误",-1);
//         }


/*
 * try { StringUtils.isEmpty(user.getAccount()); } catch (Exception e) {
 * logger.error("账号错误", e); return new Response(false,"账号不能为空",-1,null); }
 */

