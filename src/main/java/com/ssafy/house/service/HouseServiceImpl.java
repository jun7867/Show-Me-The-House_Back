package com.ssafy.house.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.HouseDao;
import com.ssafy.house.dao.HouseDaoImpl;
import com.ssafy.house.dto.HouseDto;
import com.ssafy.house.dto.PageBean;
import com.ssafy.house.dto.PostDto;
import com.ssafy.util.DBUtil;


@Service
public class HouseServiceImpl implements HouseService {
	
	private static final Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);
	
	@Autowired
	private HouseDao dao;
	
	public List<HouseDto> searchAll(PageBean bean) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			return dao.searchAll(conn, bean);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtil.close(conn);
		}
		return null;
	}

	public List<PostDto> searchPost() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			return dao.searchPost(conn);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtil.close(conn);
		}
		return null;
	}

}
