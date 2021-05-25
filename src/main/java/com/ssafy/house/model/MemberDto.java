package com.ssafy.house.model;

import io.swagger.annotations.ApiModelProperty;

public class MemberDto {
	
	private int user_no;
	private String user_id;
	private String name;
	private String pwd;
	private String email;
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Member [user_no=" + user_no + ", user_id=" + user_id + ", name=" + name + ", pwd=" + pwd + ", email="
				+ email + "]";
	}

}
