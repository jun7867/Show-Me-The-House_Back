package com.ssafy.house.dto;

public class MemberDtoImpl implements MemberDto {

	private String userid;
	private String username;
	private String userpwd;
	private String email;
	
	
	public MemberDtoImpl() {}
	public MemberDtoImpl(String userid, String username, String userpwd, String email) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
