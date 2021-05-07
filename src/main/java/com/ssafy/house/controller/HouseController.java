package com.ssafy.house.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.PageBean;
import com.ssafy.house.model.service.HouseService;
import com.ssafy.util.PageNavigation;


@Controller
@RequestMapping("/room")
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
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam Map<String, String> map, Model model) {
		String spp = map.get("spp");
		map.put("spp", spp != null ? spp : "10");//sizePerPage
		try {
			List<HouseDto> list = houseService.listHouse(map);
			PageNavigation pageNavigation = houseService.makePageNavigation(map);
			model.addAttribute("houses", list);
			model.addAttribute("navigation", pageNavigation);
			System.out.println("listlistlist houselist!!!!!!!!!!!");
			return "/house/housedeal";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "집목록을 얻어오는 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@GetMapping("search")
	public String search(Model model,int no) {
		try {
			model.addAttribute("house",houseService.getHouse(no));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/house/detail";
	}
	
//	@RequestMapping(value = "/housedeal", method = RequestMethod.GET)
//	public String housedeal() {
//		return "house/housedeal";
//	}
//	@GetMapping("listHouse")
//	public String listBook(Model model,@ModelAttribute("bean") PageBean bean) {
//		model.addAttribute("list", houseService.searchAll(bean));
//		return "house/housedeal";
//	}
	
//	@GetMapping("searchHouse")
//	public String searchBook(Model model, int no) {
//		model.addAttribute("house", houseService.search(no));
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







