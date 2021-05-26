package com.ssafy.house.model.service;

import java.util.List;

import com.ssafy.house.model.FavoriteDto;
import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.MemberDto;


public interface FavoriteService {
	public  List<HouseDto> listFavorite(int user_no) throws Exception;
	public boolean addFavorite(FavoriteDto fav) throws Exception;
	public boolean deleteFavorite(int user_no, int housedeal_no) throws Exception;
}
