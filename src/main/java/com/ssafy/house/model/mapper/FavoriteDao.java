package com.ssafy.house.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.model.FavoriteDto;
import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.MemberDto;
@Mapper
public interface FavoriteDao {
	public  List<HouseDto> listFavorite(int user_no) throws Exception;
	public int addFavorite(FavoriteDto fav) throws Exception;
	public int deleteFavorite(int user_no, int housedeal_no) throws Exception;
}
