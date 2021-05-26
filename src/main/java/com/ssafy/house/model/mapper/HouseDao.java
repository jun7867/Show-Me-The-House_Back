package com.ssafy.house.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.model.HouseDto;

@Mapper
public interface HouseDao {
	
	// 전체 아파트 리스트 
	public List<HouseDto> listTotal();
	
	// 최신 매매 아파트 리스트
	public List<HouseDto> listNewest();
	
	// Apt name 리스트 
	public List<HouseDto> listApt(String aptname);
	// 동 리스트 
	public List<HouseDto> listDong(String dong);
	// 번호와 일치하는 아파트
	public HouseDto houseDetail(int no);
	
}
