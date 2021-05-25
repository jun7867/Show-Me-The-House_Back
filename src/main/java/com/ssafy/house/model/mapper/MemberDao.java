package com.ssafy.house.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.model.MemberDto;

@Mapper
public interface MemberDao {
	public List<MemberDto> selectMember();
	public MemberDto selectMemberByNo(int user_no);
	public MemberDto selectMemberById(String user_id);
	public int insertMember(MemberDto member);
	public int updateMember(MemberDto member);
	public int deleteMember(int user_no);
	public int confirmeMember(String user_id);
	public MemberDto login(MemberDto member);
}
