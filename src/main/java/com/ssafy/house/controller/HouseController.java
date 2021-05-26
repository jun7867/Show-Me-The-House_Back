package com.ssafy.house.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.house.model.HouseDto;
import com.ssafy.house.model.PageBean;
import com.ssafy.house.model.SidoGugunDongDto;
import com.ssafy.house.model.service.HouseService;
import com.ssafy.util.PageNavigation;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/room")
public class HouseController {
	
	private static final Logger logger = LoggerFactory.getLogger(HouseController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private HouseService houseService;
	
	
	@ApiOperation(value = "모든 아파트 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/apt/list")
	public ResponseEntity<List<HouseDto>> getHouseList() throws Exception{
		return new ResponseEntity<List<HouseDto>>(houseService.getHouseList(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "최신 아파트 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/apt/newlist")
	public ResponseEntity<List<HouseDto>> getNewestList() throws Exception{
		return new ResponseEntity<List<HouseDto>>(houseService.getNewestList(),HttpStatus.OK);
	}
	
	// 아파트 이름에 일치하는 아파트 정보 리스트
	@ApiOperation(value = "아파트 이름과 일치하는 아파트 정보 리스트를 반환한다.", response = List.class)
	@RequestMapping(value = "/apt/aptName/{aptName}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<HouseDto> getHouseAptNameList(@PathVariable("aptName") String aptName) throws Exception{
		return houseService.getHouseAptNameList(aptName);
	}
	
	// 아파트 이름에 일치하는 아파트 정보 리스트
	@ApiOperation(value = "동 이름과 일치하는 아파트 정보 리스트를 반환한다.", response = List.class)
	@RequestMapping(value = "/apt/dong/{dong}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<HouseDto> getHouseDongList(@PathVariable("dong") String dong) throws Exception{
		return houseService.getHouseDongList(dong);
	}
	
	@ApiOperation(value="아파트 no와 일치하는 아파트 반환한다.",response = HouseDto.class)
	@GetMapping(value="/apt/no/{no}")
	public HouseDto getHouse(@PathVariable("no") int no) throws Exception{
		return houseService.getHouse(no);
	}
}







