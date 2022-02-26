package com.itbank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice	// 프로젝트 전역에서 발생하는 예외를 모아서 처리
public class ExceptionHandlerClass {
	
//	@RequestMapping("/")						  : 지정한 주소로 요청이 발생하면 함수가 실행된다
//	@ExceptionHandler(NullPointerException.class) : 지정한 형식의 예외가 발생하면 함수가 실행된다
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView npe(NullPointerException e) {
//		System.out.println("예외 발생 : " + e);
		ModelAndView mav = new ModelAndView("message");
		mav.addObject("message", "잘못된 접근입니다");
		return mav;
	}

}
