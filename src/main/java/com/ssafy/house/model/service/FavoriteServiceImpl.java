package com.ssafy.house.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.house.model.FavoriteDto;
import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.MemberDto;
import com.ssafy.house.model.mapper.FavoriteDao;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	private static final Logger logger = LoggerFactory.getLogger(FavoriteServiceImpl.class);
	
	@Autowired
	private FavoriteDao dao;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	@Transactional
	public List<HouseDto> listFavorite(int user_no) throws Exception {
		return dao.listFavorite(user_no);
	}
	
	@Override
	@Transactional
	public boolean addFavorite(FavoriteDto fav) throws Exception {
		return sqlSession.getMapper(FavoriteDao.class).addFavorite(fav) == 1;
		
	}
	
	@Override
	@Transactional
	public boolean deleteFavorite(int user_no, int housedeal_no) throws Exception {
		return sqlSession.getMapper(FavoriteDao.class).deleteFavorite(user_no, housedeal_no) == 1;	
	}
}
