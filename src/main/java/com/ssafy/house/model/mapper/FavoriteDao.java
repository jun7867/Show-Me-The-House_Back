package com.ssafy.house.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.model.FavoriteDto;
@Mapper
public interface FavoriteDao {
	public  List<FavoriteDto> listFavorite() throws Exception;
	public void AddFavorite(String dong, String userid) throws Exception;
}
