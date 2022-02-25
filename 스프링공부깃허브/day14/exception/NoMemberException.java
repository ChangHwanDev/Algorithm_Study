package com.itbank.exception;

public class NoMemberException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "입력하신 정보와 일치하는 계정 정보를 확인할 수 없습니다";
	}
}
