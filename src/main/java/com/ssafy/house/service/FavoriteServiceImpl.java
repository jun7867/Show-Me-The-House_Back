package com.ssafy.house.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.house.dao.FavoriteDao;
import com.ssafy.house.dto.FavoriteDto;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	private static final Logger logger = LoggerFactory.getLogger(FavoriteServiceImpl.class);
	
	@Autowired
	private FavoriteDao dao;
	
	@Override
	@Transactional
	public List<FavoriteDto> listFavorite() throws Exception {

		return dao.listFavorite();
	}
	
	@Override
	@Transactional
	public void addFavorite(String dong, String userid) throws Exception {

		dao.AddFavorite(dong, userid);
	}
}
