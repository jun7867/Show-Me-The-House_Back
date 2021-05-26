package com.ssafy.house.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.PageBean;
import com.ssafy.house.model.PostDto;
import com.ssafy.util.PageNavigation;

public interface HouseService {
	// 전체 list
	public List<HouseDto> getHouseList();
	
	// 최신 매매 매물 목록
	public List<HouseDto> getNewestList();
	
	// 아파트 이름 List
	public List<HouseDto> getHouseAptNameList(String aptname);
	
	// 동 List 
	public List<HouseDto> getHouseDongList(String dong);
	
	// 번호로 찾는 House
	public HouseDto getHouse(int no);
}
