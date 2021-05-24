package com.ssafy.house.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.model.SidoGugunDongDto;

@Mapper
public interface MapDao {
	// 시도 리스트 반환
	public List<SidoGugunDongDto> selectSido();
	// 구군 리스트 반환
	public List<SidoGugunDongDto> selectGugun(String sido);
	// 동 리스트 반환
	public List<SidoGugunDongDto> selectDong(String gugun);
	// 시도 코드로 시도 이름 반환
	public String selectSidoName(String sidocode);
	// 구군 코드로 구군 이름 반환
	public String selectGugunName(String guguncode);
	// 동 코드로 동 이름 반환
	public String selectDongName(String dongcode);
	// 시도 이름으로 시도 코드 반환
	public String selectSiCode(String siname);
	// 구군 이름으로 구군 코드 반환
	public String selectGugunCode(String gugunname,String sidocode);
}
