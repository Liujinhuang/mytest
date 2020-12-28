package com.lanwei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lanwei.pojo.GoosUser;

@Mapper
public interface GoosUserMapper {

	
	
	@Select("select * from goosinfo where userId=#{userId}")
	List<GoosUser>findById(Integer userId);//基于用户id获取商品id,获取商品信息
}
