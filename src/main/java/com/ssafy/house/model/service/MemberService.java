package com.ssafy.house.model.service;

import java.util.List;

import com.ssafy.house.model.MemberDto;


public interface MemberService {
	public List<MemberDto> retrieveMember();
	public MemberDto detailMember(int user_no);
	public MemberDto detailMember(String user_id);
	public boolean writeMember(MemberDto member);
	public boolean updateMember(MemberDto member);
	public boolean deleteMember(int user_no);
	public boolean confirmMember(String user_id);
	public MemberDto login(MemberDto member);
}
