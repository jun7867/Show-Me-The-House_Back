package com.ssafy.house.service;

import java.util.List;

import com.ssafy.house.dao.FavoriteDao;
import com.ssafy.house.dao.FavoriteDaoImpl;
import com.ssafy.house.dto.FavoriteDto;

public class FavoriteServiceImpl implements FavoriteService {
	@Override
	public List<FavoriteDto> listFavorite() throws Exception {
		FavoriteDao dao = new FavoriteDaoImpl();
		return dao.listFavorite();
	}
	
	@Override
	public void addFavorite(String dong, String userid) throws Exception {
		FavoriteDao dao = new FavoriteDaoImpl();
		dao.AddFavorite(dong, userid);
	}
}
