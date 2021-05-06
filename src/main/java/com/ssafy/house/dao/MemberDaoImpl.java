package com.ssafy.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.house.dto.MemberDto;
import com.ssafy.house.dto.MemberDtoImpl;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	public MemberDto login(String userid, String userpwd) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberDto member = new MemberDtoImpl();
		
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select *\n" + 
					"from happyhouse_member\n" + 
					"where userid = ? and userpwd = ?;");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid );
			pstmt.setString(2, userpwd );
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member.setUserid(rs.getString("userid"));
				member.setUserpwd(rs.getString("userpwd"));
				member.setUsername(rs.getString("username"));
				member.setEmail(rs.getString("emailid"));
			}
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return member;
	}
	
	
	public void join(String userid, String userpwd, String name, String email) throws SQLException {
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberDto member = new MemberDtoImpl();
		
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("insert into happyhouse_member (userid, username, userpwd, emailid)\n" + 
					"values (?,?,?,?);");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid );
			pstmt.setString(2, userpwd );
			pstmt.setString(3, name );
			pstmt.setString(4, email );
			
			
			pstmt.executeUpdate();
			
		}finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}
	
	public List<MemberDto> listMember() throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberDto> lst = new ArrayList<MemberDto>();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select *\n" + 
					"from happyhouse_member;");
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDto member = new MemberDtoImpl();
				member.setUserid(rs.getString("userid"));
				member.setUserpwd(rs.getString("userpwd"));
				member.setUsername(rs.getString("username"));
				member.setEmail(rs.getString("emailid"));
				lst.add(member);
			}
			
		}finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
		
		return lst;
	}

	public void updateMember(String userid, String userpwd, String username, String email) throws Exception {

		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("update");
		try {
			MemberDto member = new MemberDtoImpl();
			
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("update happyhouse_member set userpwd = ?, username = ?, emailid = ?\n" + 
					"where userid like ?;");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userpwd);
			pstmt.setString(2, username);
			pstmt.setString(3, email);
			pstmt.setString(4, userid );
			
			pstmt.executeUpdate();
			
		}finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}

	}
	public void deleteMember(String userid) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("delete");
		try {
			StringBuilder sql = new StringBuilder();
			
			sql.append("delete from happyhouse_member\n" + 
					"where userid = ?;");
			
			conn = DBUtil.getConnection();			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid );
			pstmt.executeUpdate();
			
		}finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
		
	}
	
}
