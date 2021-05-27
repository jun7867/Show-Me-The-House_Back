package com.ssafy.house.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.ssafy.house.model.service.JwtService;
import com.ssafy.house.model.service.MemberService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/vue/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/vue/api/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private JwtService jwtService;
	
	@ApiOperation(value = "모든 유저의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<MemberDto>> retrieveMember() throws Exception {
		logger.debug("retrieveBoard - 호출");
		return new ResponseEntity<List<MemberDto>>(memberService.retrieveMember(), HttpStatus.OK);
	}

    @ApiOperation(value = "번호에 해당하는 유저의 정보를 반환한다.", response = MemberDto.class)    
	@GetMapping("{user_no}")
	public ResponseEntity<MemberDto> detailMemberInfo(@PathVariable int user_no) {
		logger.debug("detailMember - 호출");
		return new ResponseEntity<MemberDto>(memberService.detailMember(user_no), HttpStatus.OK);
	}
    
    @ApiOperation(value = "아이디에 해당하는 유저의 정보를 반환한다.", response = MemberDto.class)    
	@GetMapping("/id/{user_id}")
	public ResponseEntity<MemberDto> detailMember(@PathVariable String user_id) {
		logger.debug("detailMember - 호출");
		return new ResponseEntity<MemberDto>(memberService.detailMember(user_id), HttpStatus.OK);
	}
    
	@PostMapping("/confirm/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto member, HttpServletResponse response,
			HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println("USER::::" + member.toString());
		HttpStatus status = null;
		try {
			MemberDto loginUser = memberService.login(member);
			if (loginUser != null) {
				String token = jwtService.create(loginUser);
				logger.trace("로그인 토큰정보 : {}", token);

				resultMap.put("auth-token", token);
				resultMap.put("user-id", loginUser.getUser_id());
				resultMap.put("user-name", loginUser.getName());
				resultMap.put("status", true);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("status", false);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@GetMapping("/info")
	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		System.out.println("getinfo.........."+req.getHeader("auth-token"));
		try {
			resultMap.putAll(jwtService.get(req.getHeader("auth-token")));
			status = HttpStatus.ACCEPTED;
			System.out.println(status);
		} catch (RuntimeException e) {
			logger.error("정보조회 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

    @ApiOperation(value = "새로운 유저 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeMember(@RequestBody MemberDto member) {
		logger.debug("writeMember - 호출");
		if (memberService.writeMember(member)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "유저의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> updateMember(@RequestBody MemberDto member) {
		logger.debug("updateMember - 호출");
		logger.debug("" + member);
		
		if (memberService.updateMember(member)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "유저 번호에 해당하는 유저의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{user_no}")
	public ResponseEntity<String> deleteBoard(@PathVariable int user_no) {
		logger.debug("deleteMember - 호출");
		if (memberService.deleteMember(user_no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}