package com.ssafy.house.model.service;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ssafy.house.model.MemberDto;

import io.jsonwebtoken.*;

@Component
public class JwtService {
	
	public static final Logger logger = LoggerFactory.getLogger(JwtService.class);
	
	private String signature = "VUETOKEN";
	private Long expireMin = 5L;

	public String create(MemberDto memberDto) {
		JwtBuilder jwtBuilder = Jwts.builder();
		
		jwtBuilder.setHeaderParam("typ", "JWT"); // 토큰의 타입으로 고정 값.

		jwtBuilder
			.setSubject("로그인토큰") // 토큰의 제목 설정
			.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin)) // 유효기간 설정
			.claim("user", memberDto).claim("greeting", "환영합니다. " + memberDto.getName()); // 담고 싶은 정보 설정.
		
		jwtBuilder.signWith(SignatureAlgorithm.HS256, signature.getBytes());
		
		System.out.println(jwtBuilder);
		String jwt = jwtBuilder.compact();
		logger.info("jwt : {}", jwt);
		return jwt;
	}
	
	public void checkValid(String jwt) {
		Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
	}
	
	public Map<String, Object> get(String jwt) {
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
        } catch (final Exception e) {
        	e.printStackTrace();
            throw new RuntimeException();
        }

        logger.info("claims : {}", claims);
        return claims.getBody();
    }
}
