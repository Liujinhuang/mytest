package com.lanwei.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lanwei.pojo.GoosInfo;


@Mapper
public interface GoosInfoMapper  {

	@Select("select * from goosinfo")
	List<GoosInfo>findAll(); //查询商品所有信息
	
	@Select("select * from goosinfo where goosname=#{goosname}")
	List<GoosInfo> findByName(String goosname);//根据商品名称查询该商品的全部信息
}
 