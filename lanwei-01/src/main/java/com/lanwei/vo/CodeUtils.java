package com.lanwei.vo;

import java.util.Random;

public class CodeUtils {
 
	 private final static int codeLength =6;
	
    
    /**
     * @see 产生随机验证码
     * @return 验证码字符串
     */
	  public static int getCode(){
		  
		 Random rand = new  Random();
		 int  a ;
		 int  result =0;
		 for( int j =0; j<codeLength; j++ ){
			 a = Math.abs( rand.nextInt()%9 );
			 result += Integer.valueOf(a);
		 }
		 return  result;
	  }
	  
}