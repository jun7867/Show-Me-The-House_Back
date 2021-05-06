package com.ssafy.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.house.dto.HouseDto;
import com.ssafy.house.dto.PageBean;
import com.ssafy.house.dto.PostDto;
import com.ssafy.util.DBUtil;

public class HouseDaoImpl implements HouseDao {

	public List<HouseDto> searchAll(Connection conn, PageBean bean) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HouseDto> list = new LinkedList<HouseDto>();
		
		try {
			String key = bean.getKey();
			String word = bean.getWord();
			int startNo = bean.getStartNo();
			int interval = bean.getInterval();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM housedeal	\n");

			// 검색 조건에 맞는 쿼리 작성 => 동적 쿼리
			if (key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if (key.equals("AptName")) {
					sql.append(" where AptName like ? \n");
				} else if (key.equals("dong")) {
					sql.append(" where dong like ?  \n");
				}
			}
			
			sql.append("ORDER BY no desc limit  ?, ? ");
			// 검색 문 여기에 추가 예정
			
			pstmt = conn.prepareStatement(sql.toString());
			
			// 데이타 설정
			int idx = 1; // ? 번호를 위한 변수 => 조건에 따라서 ?의 번호가 달라지므로 변수를 사용한다.

			if (key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if (key.equals("AptName")) {
					pstmt.setString(idx++, "%" + word + "%");
				} else if (key.equals("dong")) {
					pstmt.setString(idx++, "%" + word + "%");
				}
			}

			pstmt.setInt(idx++, startNo);
			pstmt.setInt(idx++, interval);
			
			rs = pstmt.executeQuery();
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>> Select 문 접속");
			while(rs.next()) {
				HouseDto houseDto = new HouseDto();
				houseDto.setNo(rs.getInt("no"));
				houseDto.setDong(rs.getString("dong"));
				houseDto.setAptName(rs.getString("AptName"));
				houseDto.setCode(rs.getInt("code"));
				houseDto.setDealAmount(rs.getString("dealAmount"));
				houseDto.setBuildYear(rs.getInt("buildYear"));
				houseDto.setDealYear(rs.getInt("dealYear"));
				houseDto.setDealMonth(rs.getInt("dealMonth"));
				houseDto.setDealDay(rs.getInt("dealDay"));
				houseDto.setArea(rs.getDouble("area"));
				houseDto.setFloor(rs.getInt("floor"));
				houseDto.setJibun(rs.getString("jibun"));
				houseDto.setType(rs.getInt("type"));
				list.add(houseDto);
			}
			System.out.println(">>>>>>>>>>>>>>>" + list.size() + "개 출력");
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return list;
	}

	public List<PostDto> searchPost(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PostDto> list = new LinkedList<PostDto>();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM post\n");
			sql.append("ORDER BY no desc  ");
			// 검색 문 여기에 추가 예정
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostDto postDto = new PostDto();
				postDto.setNo(rs.getInt("no"));
				postDto.setName(rs.getString("name"));
				postDto.setInfo(rs.getString("info"));
				list.add(postDto);
			}
			System.out.println(list.size());
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return list;
	}
}
