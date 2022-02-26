package com.itbank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.itbank.controller")	// 패키지 단위로 영역을 제한하여 처리할 수도 있다
public class MemberExceptionHandler {

	@ExceptionHandler(NoMemberException.class)
	public ModelAndView nomember(NoMemberException e) {
		ModelAndView mav = new ModelAndView("message");
		mav.addObject("message", e);	// e == e.toString()
		return mav;
	}
	/*
	 	1) 스프링에서 예외를 처리하려면 ExceptionHandler를 이용한다
	 	2) ExceptionHandler는 Controller 내부에 있거나, ControllerAdvice에 넣을 수 있다
	 	3) ControllerAdvice는 범위를 지정하지 않으면 프로젝트 전체, 혹은 특정 패키지를 지정할 수도 있다
	 	4) 예외 클래스는 필요하다면 내가 직접 만들수 있다 (extends Exception or Throwable)
	 	5) 컨트롤러의 메서드에서는 특정상황을 예외로 규정하여 조건에 따라 예외를 발생시키기만 하면 된다
	 */
}
