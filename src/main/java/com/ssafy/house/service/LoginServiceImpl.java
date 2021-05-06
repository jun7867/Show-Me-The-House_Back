package com.ssafy.house.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.house.dao.MemberDao;
import com.ssafy.house.dto.MemberDto;

@Service
public class LoginServiceImpl implements LoginService {
	
private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private MemberDao dao;
	
	@Transactional
	@Override
	public MemberDto login(String userid, String userpwd) throws Exception {
		return dao.login(userid, userpwd);
	}
	
	@Transactional
	@Override
	public void join(String userid, String userpwd, String name, String email) throws Exception {
		dao.join(userid, userpwd, name, email);
	}
	
	@Transactional
	@Override
	public List<MemberDto> listMember() throws Exception {

		return dao.listMember();
	}
	
	@Transactional
	@Override
	public void delete(String userid) throws Exception {
		dao.deleteMember(userid);
		
	}
	
	@Transactional
	@Override
	public void update(String userid, String userpwd, String name, String email) throws Exception {
		dao.updateMember(userid, userpwd, name, email);
	}
}
