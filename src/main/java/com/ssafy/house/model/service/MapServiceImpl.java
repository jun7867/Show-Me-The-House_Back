package com.ssafy.house.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.model.SidoGugunDongDto;
import com.ssafy.house.model.mapper.MapDao;

@Service
public class MapServiceImpl implements MapService {

	@Autowired
	private MapDao map;
	
	@Override
	public List<SidoGugunDongDto> getSido(){
		return map.selectSido();
	}

	@Override
	public List<SidoGugunDongDto> getGugunInSido(String sido){
		return map.selectGugun(sido);
	}

	@Override
	public List<SidoGugunDongDto> getDongInGugun(String gugun) {
		return map.selectDong(gugun);
	}

	@Override
	public String getSiName(String sidocode) {
		return map.selectSidoName(sidocode);
	}

	@Override
	public String getGugunName(String guguncode) {
		return map.selectGugunName(guguncode);
	}

	@Override
	public String getDongName(String dongcode) {
		return map.selectDongName(dongcode);
	}

	@Override
	public String getSiCode(String siname) {
		return map.selectSiCode(siname);
	}

	@Override
	public String getGugunCode(String gugunname, String sidocode) {
		return map.selectGugunCode(gugunname, sidocode);
	}


}
