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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.model.MemberDto;
import com.ssafy.house.model.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// RestController를 써서 모든게 다 JSON으로 return이 됨. (jacson-bind가 필요함)
@RestController
@RequestMapping("/admin")
@Api("어드민 컨트롤러 API V1")
@CrossOrigin("*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private LoginService userService;
	
//	@RequestMapping(value = "/user", method = RequestMethod.GET, headers = { "Content-type=application/json" })
//	public  List<MemberDto> userList() {
//		return userService.userList();
//	}
//	
//	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Content-type=application/json" })
//	public List<MemberDto> userRegister(@RequestBody MemberDto memberDto) {
//		userService.userRegister(memberDto);
//		return userService.userList();
//	}
//	
//	// url 경로에 있는 userid를 받아서 사용해야 하므로 PathVariable로 받는다. 
//	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
//	public MemberDto userInfo(@PathVariable("userid") String userid) {
//		return userService.userInfo(userid);
//	}
//	
//	// PUT으로 받아서 수정과 등록을 구분	
//	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
//	public List<MemberDto> userModify(@RequestBody MemberDto memberDto) {
//		userService.userModify(memberDto);
//		return userService.userList();
//	}
//	
//	@RequestMapping(value = "/user/{userid}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
//	public List<MemberDto> userDelete(@PathVariable("userid") String userid) {
//		userService.userDelete(userid);
//		return userService.userList();
//	}
	
	///////////////////////////////////////////////////////////
	
	
	@ApiOperation(value = "회원 목록",notes = "회원의 <big>전체 목록</big>을 반환해 줍니다.")
	@ApiResponses({
		@ApiResponse(code=200,message="회원 목록 OK"),
		@ApiResponse(code=404,message="페이지 ㄴㄴ"),
		@ApiResponse(code=500,message="서버 에러!"),
	})
	@GetMapping(value = "/user")
	public ResponseEntity<List<MemberDto>> userList() {
		List<MemberDto> list = userService.userList();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@ApiOperation(value = "회원 등록",notes = "회원의 정보를 받아서 DB에 저장.")
	@PostMapping(value = "/user")
	public ResponseEntity<List<MemberDto>> userRegister(@RequestBody @ApiParam(value="회원 한명의 정보",required = true) MemberDto memberDto) {
		int cnt = userService.userRegister(memberDto);
		if(cnt != 0) {
			List<MemberDto> list = userService.userList();
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//			return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
		} else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원 정보 검색 ",notes = "userid에 해당하는 회원 한명 받아서 리턴.")
	@GetMapping(value = "/user/{userid}")
	public ResponseEntity<MemberDto> userInfo(@PathVariable("userid") @ApiParam(value = "검색할회원 id") String userid) {
		logger.debug("파라미터 : {}", userid);
		MemberDto memberDto = userService.userInfo(userid);
		if(memberDto != null)
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원 정보 수정",notes = "회원 정보 수정 후 DB에 저장.")
	@PutMapping(value = "/user")
	public ResponseEntity<List<MemberDto>> userModify(@RequestBody @ApiParam(value = "수정할 회원정보",required = true) MemberDto memberDto) {
		userService.userModify(memberDto);
		List<MemberDto> list = userService.userList();
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/user/{userid}")
	public ResponseEntity<List<MemberDto>> userDelete(@PathVariable("userid") String userid) {
		userService.userDelete(userid);
		List<MemberDto> list = userService.userList();
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	}
	
}
