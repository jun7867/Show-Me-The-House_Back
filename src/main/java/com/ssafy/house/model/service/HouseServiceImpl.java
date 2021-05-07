package com.ssafy.house.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.PageBean;
import com.ssafy.house.model.PostDto;
import com.ssafy.house.model.mapper.HouseDao;
import com.ssafy.util.DBUtil;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.PageUtility;


@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	private SqlSession sqlSession;
	
//	@Autowired
//	private HouseDao dao;
	
	@Transactional
	@Override
	public List<HouseDto> listHouse(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("key", map.get("key") == null ? "" : map.get("key"));
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		int start = (currentPage - 1) * sizePerPage;
		param.put("start", start);
		param.put("spp", sizePerPage);
		return sqlSession.getMapper(HouseDao.class).listHouse(param);
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		int naviSize = 10;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(HouseDao.class).getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}
	@Override
	public HouseDto getHouse(int no) throws Exception {
		return sqlSession.getMapper(HouseDao.class).getHouse(no);
	}
	
	
//	@Transactional
//	@Override
//	public List<HouseDto> searchAll(PageBean bean) {
//		int total=dao.totalCount(bean);
//		PageUtility util = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
//		bean.setPageLink(util.getPageBar());
//		return dao.searchAll(bean);
//	}
//	
//	@Transactional
//	@Override
//	public HouseDto getHouse(int no) {
//		return dao.getHouse(no);
//	}

}
