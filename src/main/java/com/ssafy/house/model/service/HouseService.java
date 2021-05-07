package com.ssafy.house.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.PageBean;
import com.ssafy.house.model.PostDto;
import com.ssafy.util.PageNavigation;

public interface HouseService {
	public List<HouseDto> listHouse(Map<String, String> map) throws Exception;
	
	public HouseDto getHouse(int no) throws Exception;

	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
}
