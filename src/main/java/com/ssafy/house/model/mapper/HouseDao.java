package com.ssafy.house.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.MemberDto;
import com.ssafy.house.model.PageBean;
import com.ssafy.house.model.PostDto;
@Mapper
public interface HouseDao {
	
	public List<HouseDto> listHouse(Map<String, Object> map) throws SQLException;
	public int getTotalCount(Map<String, String> map) throws SQLException;
	
	public HouseDto getHouse(int no) throws SQLException;
	
//	public MemberDto login(Map<String, String> map) throws SQLException;
//	public List<MemberDto> userList();
//	public MemberDto userInfo(String userid);
//	public int userRegister(MemberDto memberDto);
//	public int userModify(MemberDto memberDto);
//	public int userDelete(String userid);
//	public List<HouseDto> searchAll(PageBean bean);
//	public int totalCount(PageBean bean);
//	public HouseDto getHouse(int no);
//	
	
//	public List<PostDto> searchPost();
}
