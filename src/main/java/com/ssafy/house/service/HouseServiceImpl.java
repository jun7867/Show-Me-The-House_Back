package com.ssafy.house.service;

import java.sql.Connection;
import java.util.List;

import com.ssafy.house.dao.HouseDao;
import com.ssafy.house.dao.HouseDaoImpl;
import com.ssafy.house.dto.HouseDto;
import com.ssafy.house.dto.PageBean;
import com.ssafy.house.dto.PostDto;
import com.ssafy.util.DBUtil;

public class HouseServiceImpl implements HouseService {

	HouseDao dao = new HouseDaoImpl();
	
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
