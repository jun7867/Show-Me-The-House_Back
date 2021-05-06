package com.ssafy.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.house.dto.FavoriteDto;
import com.ssafy.house.dto.FavoriteDtoImpl;
import com.ssafy.util.DBUtil;

public class FavoriteDaoImpl implements FavoriteDao {
	
	
	public List<FavoriteDto> listFavorite() throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<FavoriteDto> lst = new ArrayList<FavoriteDto>();
		try {
			// SQL 수정 지역
			StringBuilder sql = new StringBuilder();
			sql.append("select f.member_id, d.city, d.gugun, d.dong \n" + 
					"from favorites f, dongcode d\n" +
					"where f.dong_id = d.dongcode;");
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			System.out.println("데이터 읽어오기");
			while(rs.next()) {
				// SQL 수정하기
				FavoriteDto favorite = new FavoriteDtoImpl();
				favorite.setUserid(rs.getString("member_id"));
				favorite.setDongcode(rs.getString("city") + " " + rs.getString("gugun") + " "  + rs.getString("dong"));
				System.out.println(favorite.getUserid());
				System.out.println(favorite.getDongcode());
				lst.add(favorite);
			}
			
		}finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
		
		return lst;
	}
	
	@Override
	public void AddFavorite(String dong, String userid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			
			dong = dongTocode(dong);
			System.out.println("결과" + dong);
			
			if(dong != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("insert into favorites(member_id, dong_id) value (?, ?);");
			
				System.out.println(sql.toString());
			
				pstmt = conn.prepareStatement(sql.toString());
			
				pstmt.setString(1, userid);
				pstmt.setString(2, dong);
			
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

	}
	
	public String dongTocode(String dong) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String code = null;
		
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select dongcode from dongcode where dong = ?;");
						
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dong);

			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				code = rs.getString("dongcode");
			}
			
		} catch (Exception e) {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return code;
	}
	
}
