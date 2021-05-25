package com.ssafy.house.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.house.model.MemberDto;
import com.ssafy.house.model.mapper.MemberDao;


@Service
public class MemberServiceImpl implements MemberService {
	
    @Autowired
    private MemberDao memberDao;
    
    @Autowired
	private SqlSession sqlSession;
    
    
	@Override
	public List<MemberDto> retrieveMember() {
		return memberDao.selectMember();
	}

	@Override
	public MemberDto detailMember(int user_no) {
		return memberDao.selectMemberByNo(user_no);
	}
	
	@Override
	public MemberDto detailMember(String user_id) {
		return memberDao.selectMemberById(user_id);
	}

	@Override
	public boolean writeMember(MemberDto member) {
		return sqlSession.getMapper(MemberDao.class).insertMember(member) == 1;
	}

	@Override
	public boolean updateMember(MemberDto member) {
		return memberDao.updateMember(member) == 1;
	}

	@Override
	public boolean deleteMember(int user_no) {
		return sqlSession.getMapper(MemberDao.class).deleteMember(user_no) == 1;
	}

	@Override
	public boolean confirmMember(String user_id) {
		return memberDao.confirmeMember(user_id) == 1;
	}
	
	@Override
	public MemberDto login(MemberDto member) {
		return sqlSession.getMapper(MemberDao.class).login(member);
	}
 
}