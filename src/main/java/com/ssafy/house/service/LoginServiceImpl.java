package com.ssafy.house.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.MemberDao;
import com.ssafy.house.dao.MemberDaoImpl;
import com.ssafy.house.dto.MemberDto;

@Service
public class LoginServiceImpl implements LoginService {
	
private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private MemberDao dao;
	
	@Override
	public MemberDto login(String userid, String userpwd) throws Exception {
		MemberDao dao = new MemberDaoImpl();
		return dao.login(userid, userpwd);
	}
	
	@Override
	public void join(String userid, String userpwd, String name, String email) throws Exception {
		MemberDao dao = new MemberDaoImpl();
		dao.join(userid, userpwd, name, email);
	}
	
	@Override
	public List<MemberDto> listMember() throws Exception {
		MemberDao dao = new MemberDaoImpl();
		return dao.listMember();
	}
	
	@Override
	public void delete(String userid) throws Exception {
		MemberDao dao = new MemberDaoImpl();
		dao.deleteMember(userid);
		
	}
	
	@Override
	public void update(String userid, String userpwd, String name, String email) throws Exception {
		MemberDao dao = new MemberDaoImpl();
		dao.updateMember(userid, userpwd, name, email);
	}
}
