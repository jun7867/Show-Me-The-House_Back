package com.ssafy.house.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.house.dto.FavoriteDto;

public interface FavoriteDao {
	public  List<FavoriteDto> listFavorite() throws Exception;
	public void AddFavorite(String dong, String userid) throws Exception;
}
