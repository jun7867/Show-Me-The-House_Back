package com.ssafy.house.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.FavoriteDao;
import com.ssafy.house.dao.FavoriteDaoImpl;
import com.ssafy.house.dto.FavoriteDto;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	private static final Logger logger = LoggerFactory.getLogger(FavoriteDaoImpl.class);
	
	@Autowired
	private FavoriteDao dao;
	
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
