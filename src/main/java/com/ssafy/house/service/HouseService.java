package com.ssafy.house.service;

import java.util.List;

import com.ssafy.house.dto.HouseDto;
import com.ssafy.house.dto.PageBean;
import com.ssafy.house.dto.PostDto;

public interface HouseService {
	public List<HouseDto> searchAll(PageBean bean);
	public List<PostDto> searchPost();
}
