package com.lumengjun.hgshop.pojo;

import java.io.Serializable;

/**
 * 回调
 * @author ASUS
 *
 */
public class CallBack implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4737572260290751380L;
	//回调值
	private Integer data;
	//错误提示信息
	private String error;
	//正确提示信息
	private String  msg;

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CallBack [data=" + data + ", error=" + error + ", msg=" + msg
				+ "]";
	}

	public CallBack(Integer data, String error, String msg) {
		super();
		this.data = data;
		this.error = error;
		this.msg = msg;
	}

	public CallBack() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
