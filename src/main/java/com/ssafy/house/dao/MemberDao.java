package com.ssafy.house.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.dto.MemberDto;
@Mapper
public interface MemberDao {
	public MemberDto login(String userid, String userpwd) throws SQLException;
	public void join(String userid, String userpwd, String name, String email) throws SQLException;
	public  List<MemberDto> listMember() throws Exception;
	public void updateMember(String userid, String userpwd, String name, String email) throws Exception;
	public void deleteMember(String userid) throws Exception;
}
