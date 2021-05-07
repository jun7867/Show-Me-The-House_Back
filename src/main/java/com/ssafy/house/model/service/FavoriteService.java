package com.ssafy.house.model.service;

import java.util.List;

import com.ssafy.house.model.FavoriteDto;


public interface FavoriteService {
	public  List<FavoriteDto> listFavorite() throws Exception;
	public void addFavorite(String dong, String userid) throws Exception;
}
