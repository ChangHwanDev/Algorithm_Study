package com.itbank.component;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component // Spring MVC 필수 구성요소는 아니지만 스프링 빈으로 등록하여 사용하는 경우
// 12회차 강의
public class SHA512 {
	public String getHash(String data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.reset();
		md.update(data.getBytes("UTF-8"));
		String hash = String.format("%0128x", new BigInteger(1, md.digest()));
		return hash;
	}
}
