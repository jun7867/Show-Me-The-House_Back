package com.ssafy.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna")
public class QnaController {
	
	@GetMapping("/qna")
	public String qna() {
		return "qna/QnA";
	}
	
}
