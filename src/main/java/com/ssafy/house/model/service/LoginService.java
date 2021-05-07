package com.ssafy.house.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.house.model.MemberDto;

public interface LoginService {
	public MemberDto login(Map<String, String> map) throws Exception;
	
//	REST 
	public List<MemberDto> userList();
	public MemberDto userInfo(String userid);
	public int userRegister(MemberDto memberDto);
	public int userModify(MemberDto memberDto);
	public int userDelete(String userid);
	public void join(MemberDto memberDto) throws Exception;
}
