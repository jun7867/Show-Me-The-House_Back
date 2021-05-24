package com.ssafy.house.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.mapper.HouseDao;

@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	private HouseDao house;
	
	@Override
	public List<HouseDto> getHouseList() {
		return house.listTotal();
	}

	@Override
	public List<HouseDto> getHouseAptNameList(String aptname) {
		return house.listApt(aptname);
	}

	@Override
	public List<HouseDto> getHouseDongList(String dong) {
		return house.listDong(dong);
	}

	@Override
	public HouseDto getHouse(int no) {
		return house.houseDetail(no);
	}


}
