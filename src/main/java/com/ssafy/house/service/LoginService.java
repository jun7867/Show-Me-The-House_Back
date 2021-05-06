package com.ssafy.house.service;

import java.util.List;

import com.ssafy.house.dto.MemberDto;

public interface LoginService {
	public MemberDto login(String userid, String userpwd) throws Exception;
	public void join(String userid, String userpwd, String name, String email) throws Exception;
	public void update(String userid, String userpwd, String name, String email) throws Exception;
	public void delete(String userid) throws Exception;

	public  List<MemberDto> listMember() throws Exception;
}
