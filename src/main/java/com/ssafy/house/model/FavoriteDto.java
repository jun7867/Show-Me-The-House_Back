package com.ssafy.house.model;

public class FavoriteDto {
	
	public int fav_no;
	public int housedeal_no;
	public int user_no;
	public int getFav_no() {
		return fav_no;
	}
	public void setFav_no(int fav_no) {
		this.fav_no = fav_no;
	}
	public int getHousedeal_no() {
		return housedeal_no;
	}
	public void setHousedeal_no(int housedeal_no) {
		this.housedeal_no = housedeal_no;
	}
	public int getMember_no() {
		return user_no;
	}
	public void setMember_no(int member_no) {
		this.user_no = member_no;
	}

}
