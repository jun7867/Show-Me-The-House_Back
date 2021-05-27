package com.ssafy.house.model.service;

import java.util.List;

import com.ssafy.house.model.SidoGugunDongDto;

public interface MapService {

	List<SidoGugunDongDto> getSido();
	List<SidoGugunDongDto> getGugunInSido(String sido);
	List<SidoGugunDongDto> getDongInGugun(String gugun);
	String getSiName(String sidocode);
	String getGugunName(String guguncode);
	String getDongName(String dongcode);
	String getSiCode(String siName);
	String getGugunCode(String gugunName, String sidoCode);

}
