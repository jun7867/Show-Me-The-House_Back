package com.ssafy.house.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.house.model.MemberDto;
import com.ssafy.house.model.mapper.MemberDao;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		if (map.get("userid") == null || map.get("userpwd") == null)
			return null;
		return sqlSession.getMapper(MemberDao.class).login(map);
	}

	@Override
	public List<MemberDto> userList() {
		return sqlSession.getMapper(MemberDao.class).userList();
	}

	@Override
	public MemberDto userInfo(String userid) {
		return sqlSession.getMapper(MemberDao.class).userInfo(userid);
	}

	@Override
	public int userRegister(MemberDto memberDto) {
		return sqlSession.getMapper(MemberDao.class).userRegister(memberDto);
	}

	@Override
	public int userModify(MemberDto memberDto) {
		return sqlSession.getMapper(MemberDao.class).userModify(memberDto);
	}

	@Override
	public int userDelete(String userid) {
		return sqlSession.getMapper(MemberDao.class).userDelete(userid);
	}
}
