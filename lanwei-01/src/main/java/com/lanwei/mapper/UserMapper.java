package com.lanwei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lanwei.pojo.User;

@Mapper
public interface UserMapper  {
   

	  @Insert("insert into user (account,password,phoneNum,username,age,sex,serial,imei,clientType,random,date,time) values (#{account},#{password},#{phoneNum},#{username},#{age},#{sex},#{serial},#{imei},#{clientType},#{random},#{date},#{time})")
	   int addUser(User entity);
   
   //根据账号,查询该账户的所有信息
   @Select("select * from user where account=#{account}")
   List<User> queryByUsername(String account);
  
}
