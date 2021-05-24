package com.ssafy.house.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.model.SidoGugunDongDto;
import com.ssafy.house.model.service.MapService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/map")
public class MapController {

	private static final Logger logger = LoggerFactory.getLogger(MapController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private MapService housemapService;

	// 모든 시도를 반환
	@ApiOperation(value = "모든 시도를 반환한다.", response = List.class)
	@GetMapping(value = "/sido")
	public ResponseEntity<List<SidoGugunDongDto>> getSido() throws Exception{
		return new ResponseEntity<List<SidoGugunDongDto>>(housemapService.getSido(),HttpStatus.OK);
	}
	
	// 선택한 시코드로 구군을 반환
	@ApiOperation(value = "선택한 시코드로 구군을 반환한다.", response = List.class)
	@RequestMapping(value = "/sido/{sidoCode}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<SidoGugunDongDto> getGugunInSido(@PathVariable("sidoCode") String sido) throws Exception {
		return housemapService.getGugunInSido(sido);
	}
	
	// 선택한 구군코드로 동을 반환
	@ApiOperation(value = "선택한 구군코드로 동을 반환한다.", response = List.class)
	@RequestMapping(value = "/sido/gugun/{gugunCode}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<SidoGugunDongDto> getDongInGugun(@PathVariable("gugunCode") String gugun) throws Exception {
		return housemapService.getDongInGugun(gugun);
	}
	
	// 선택한 시코드로 시이름을 반환
	@ApiOperation(value = "선택한 시코드로 시이름을 반환한다.", response = List.class)
	@GetMapping(value = "/getSiName/{sidoCode}")
	public String getSiName(@PathVariable("sidoCode") String sidocode) throws Exception {
		return housemapService.getSiName(sidocode);
	}
	
	// 선택한 구군코드로 구이름을 반환
	@ApiOperation(value = "선택한 구군코드로 구이름을 반환한다.", response = List.class)
	@GetMapping(value = "/getGugunName/{gugunCode}")
	public String getGugunName(@PathVariable("gugunCode") String guguncode) throws Exception {
		return housemapService.getGugunName(guguncode);
	}
	
	// 선택한 동코드로 동이름을 반환
	@ApiOperation(value = "선택한 동코드로 동이름을 반환한다.", response = List.class)
	@GetMapping(value = "/getDongName/{dongCode}")
	public String getDongName(@PathVariable("dongCode") String dongcode) throws Exception {
		return housemapService.getDongName(dongcode);
	}
	
	// 선택한 시이름으로 시코드를 반환
	@ApiOperation(value = "선택한 시이름으로 시코드를 반환한다.", response = String.class)
	@GetMapping(value = "/getSiCode/{siName}")
	public String getSiCode(@PathVariable("siName") String siName) throws Exception {
		return housemapService.getSiCode(siName);
	}
	
	// 선택한 구군이름으로 구군코드를 반환
	@ApiOperation(value = "선택한 구군이름으로 구군코드를 반환한다.", response = String.class)
	@GetMapping(value = "/getGugunCode/{gugunName}/{sidoCode}")
	public String getGugunCode(@PathVariable("gugunName") String gugunName,@PathVariable("sidoCode") String sidoCode) throws Exception {
		return housemapService.getGugunCode(gugunName,sidoCode);
	}
}