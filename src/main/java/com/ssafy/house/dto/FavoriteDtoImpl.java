package com.ssafy.house.dto;

public class FavoriteDtoImpl implements FavoriteDto {

	private String userid;
	private String dongcode;
	
	
	public FavoriteDtoImpl() {}
	public FavoriteDtoImpl(String userid, String username, String userpwd, String dongcode) {
		super();
		this.userid = userid;
		this.dongcode = dongcode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	
	
}
