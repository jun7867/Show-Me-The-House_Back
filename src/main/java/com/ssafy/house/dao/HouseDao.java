package com.ssafy.house.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.house.dto.HouseDto;
import com.ssafy.house.dto.PageBean;
import com.ssafy.house.dto.PostDto;

public interface HouseDao {
	public List<HouseDto> searchAll(Connection conn, PageBean bean) throws SQLException;
	public List<PostDto> searchPost(Connection conn)  throws SQLException;
}
