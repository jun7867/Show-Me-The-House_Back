package com.ssafy.house.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.model.FavoriteDto;
import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.MemberDto;
import com.ssafy.house.model.service.FavoriteService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {
	
	private static final Logger logger = LoggerFactory.getLogger(HouseController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private FavoriteService favoriteService;
	
	@ApiOperation(value = "관심 매물 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/list/{user_no}")
	public ResponseEntity<List<HouseDto>> listFavorite(@PathVariable int user_no) throws Exception{
		System.out.println("...........controller"+user_no);
		return new ResponseEntity<List<HouseDto>>(favoriteService.listFavorite(user_no),HttpStatus.OK);
	}
	
	@ApiOperation(value = "새로운 관심매물 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> addFavorite(@RequestBody FavoriteDto fav) throws Exception{
		logger.debug("addFavorite - 호출");
		if (favoriteService.addFavorite(fav)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{user_no}/{housedeal_no}")
	public ResponseEntity<String> deleteBoard(@PathVariable int user_no, @PathVariable int housedeal_no) throws Exception {
		logger.debug("deleteMembe - 호출");
		if (favoriteService.deleteFavorite(user_no, housedeal_no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
