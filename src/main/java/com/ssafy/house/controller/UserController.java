package com.ssafy.house.controller;

import java.util.Map;

import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.house.model.MemberDto;
import com.ssafy.house.model.service.LoginService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private LoginService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberDto memberDto, Model model, HttpSession session) {
		if(memberDto != null) {
			try {
				userService.join(memberDto);
				return "/index";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "글작성중 문제가 발생했습니다.");
				return "error/error";
			}
		} else {
			model.addAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletResponse response) {
		try {
			MemberDto memberDto = userService.login(map);
			if(memberDto != null) {
				session.setAttribute("userinfo", memberDto);
				
				Cookie cookie = new Cookie("ssafy_id", memberDto.getUserid());
				cookie.setPath("/");
				if("saveok".equals(map.get("idsave"))) {
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);//40년간 저장.
				} else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);
				
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/error";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "user/list";
	}
}
