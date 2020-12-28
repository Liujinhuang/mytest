package com.lanwei.vo;


public class Response {
	 String msg;
	 int code;
	Boolean isSuc = true;
	Object data;
	
	public Response(){}
	public Response(Boolean isSuc,String msg, int code,Object data) {
		this.msg = msg;
		this.code = code;
		this.isSuc = isSuc;
		this.data=data;
		 
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Boolean getIsSuc() {
		return isSuc;
	}
	public void setIsSuc(Boolean isSuc) {
		this.isSuc = isSuc;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
