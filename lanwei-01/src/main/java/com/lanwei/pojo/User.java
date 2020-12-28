package com.lanwei.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/* 封装用户信息 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	
	private Integer userId; 	//用户ID
	private String account;		//账号
    private String password; 	//密码
    private String phoneNum;	//手机号码
    private String username; 	//用户姓名
	private Integer  age;		//用户年龄
	private String  sex;		//用户性别
	private String serial;		//流水号哈希码值
	private String imei;		//IMEI
	private Integer clientType;  //终端类型
	private String random;		//随机数
	private String date;		//日期
	private String time;		//时间
	
	/*
	 * @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	 * 
	 * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") private Date
	 * createTime; //注册时间
	 */	
    
    
     
}