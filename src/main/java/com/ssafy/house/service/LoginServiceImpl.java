package com.ssafy.house.service;

import java.util.List;

import com.ssafy.house.dao.MemberDao;
import com.ssafy.house.dao.MemberDaoImpl;
import com.ssafy.house.dto.MemberDto;

public class LoginServiceImpl implements LoginService {
	public MemberDto login(String userid, String userpwd) throws Exception {
		MemberDao dao = new MemberDaoImpl();
		return dao.login(userid, userpwd);
	}
	
	public void join(String userid, String userpwd, String name, String email) throws Exception {
		MemberDao dao = new MemberDaoImpl();
		dao.join(userid, userpwd, name, email);
	}
	
	public List<MemberDto> listMember() throws Exception {
		MemberDao dao = new MemberDaoImpl();
		return dao.listMember();
	}
	public void delete(String userid) throws Exception {
		MemberDao dao = new MemberDaoImpl();
		dao.deleteMember(userid);
		
	}
	public void update(String userid, String userpwd, String name, String email) throws Exception {
		MemberDao dao = new MemberDaoImpl();
		dao.updateMember(userid, userpwd, name, email);
	}
}
