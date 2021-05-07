package com.ssafy.house.model;


public class HouseException extends RuntimeException {
	public HouseException() {
		super("house 정보를 처리 중 오류 발생");
	}
	public HouseException(String msg) {
		super(msg);
	}
}
