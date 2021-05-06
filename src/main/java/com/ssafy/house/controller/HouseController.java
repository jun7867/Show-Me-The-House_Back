package com.ssafy.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.house.service.HouseService;


@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("/error");
		mav.addObject("msg", e.getMessage());
		e.printStackTrace();
		return mav;
	}
	
	
//	@GetMapping("listBook.do")
//	public String listBook(Model model) {
//		model.addAttribute("list", houseService.searchAll());
//		return "book/listBook";
//	}
//	
//	@GetMapping("searchBook.do")
//	public String searchBook(Model model, String isbn) {
//		model.addAttribute("book", houseService.search(isbn));
//		return "book/searchBook";
//	}
//	
//	@GetMapping("insertBookForm.do")
//	public String insertBookForm() {
//		return "book/insertBook";
//	}
//	
//	
//	@GetMapping("removeBook.do")
//	public String removeBook( String isbn) {
//		bookService.delete(isbn);
//		return "redirect:listBook.do";
//	}
//	
//	
//	@GetMapping("updateBookForm.do")
//	public String insertBookForm(Model model, String isbn) {
//		model.addAttribute("book", bookService.search(isbn));
//		return "book/updateBook";
//	}
//	
//	
//	@PostMapping("updateBook.do")
//	public String updateBook(Book book) {
//		bookService.update(book);
//		return "book/updateBook";
//	}
//	
//	@PostMapping("insertBook.do")
//	public String insertBook(Book book) {
//		bookService.insert(book);
//		return "redirect:searchBook.do?isbn="+book.getIsbn();
//	}
//	
//	
	
}







