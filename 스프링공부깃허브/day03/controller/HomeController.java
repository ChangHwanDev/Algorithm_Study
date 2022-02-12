package com.hwan.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/*
 * 	HTTP Request Method     Database DML
 * 	-GET					select
 * 	-POST					insert
 * 	-PUT					update
 * 	-DELETE					delete
 * 	-PATCH					update
 * 
 * 
 * 	HTTP Response Status Code
 * 	
 * 	200 - OK , 정상적으로 요청을 처리하여 응답을 돌려준 경우
 * 	302	- Redirect, 다른 페이지로 리다이렉트 요청을 클라이언트에게 전달
 * 
 * 	4XX - 클라이언트에서 발생한 원인에 의해 정상적으로 처리하지 못한 경우
 * 	400 - 클라이언트 요청 오류
 * 	401 - 인증되지 않음
 * 	403 - 권한 없음
 *  404 - Page Not Found, 주소가 없거나, 보여줄 문서가 없는 경우
 *  405 - Method Not Allowed, 주소는 있으나, 요청 메서드가 지원되지 않는 경우
 *  
 *  500 - Sever Internal Error, 서버에서 발생한 원인에 의해 정상적으로 처리하지 못한 경우
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	// 컨트롤러 메서드의 매개변수
	// HtttpSevletRequest , HttpSevletResponse, HttpSession

	@RequestMapping("/") // 메서드에 상관없이 주소만 일치하면 함수를 실행한다
	public String home() {
		return "home";
	}

	// 컨트롤러 메서드의 반환형
	// void : 문자열을 별도로 반환하지 않으면, 요청 주소의 이름을 viewName으로 활용한다
	// prefix + viewName + suffix

	// String : 반환하는 문자열을 viewName으로 지정하여 jsp를 찾는다

	// ModelAndView : 파라미터로 바는 Model 과 String viewName을 합친 형태의 객체를 반환
	@GetMapping("/ex01")
	public String ex01() {
		return "ex01";
	}

	@PostMapping("/ex01")
	public String ex01(HttpServletRequest request) {
//		try {
//			request.setCharacterEncoding("UTF-8");
//		}
//		catch(UnsupportedEncodingException e){}
		// 요청을 받아서 응답을 보내주는것이 컨트롤러의 역할이다
		// 모든 요청마다 request.setCharacterEncoding() 하무를 호출하기 번거로우므로
		// 특정 클래스가 모든 요청에 대해서 공통 작업을 수행하는 Filter를 사용하기도 한다.
		// 필터 인터셉터 AOP 가 공통 작업을 해줌
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String adult = age >= 20 ? "성인" : "미성년자";

		String msg = String.format("%s님은 %d살 이고 %s 입니다", name, age, adult);

		request.setAttribute("msg", msg);
		return "ex01Result";
	}

	@GetMapping("/ex02")
	public void ex02() {
	}

	@PostMapping("/ex02")
	public String ex02(String name, int age, Model model) {
		// 스프링 컨트롤러는파라미터를 매서드의 매개변수로 받을 수 있다 @RequestParam 생략함
		// 기본 자료형에 해당하는 값은 형변환을 알아서 처리해준다

		String adult = age >= 20 ? "성인" : "미성년자";
		String msg = String.format("%s님은 %d살 이고 %s 입니다", name, age, adult);
		model.addAttribute("msg", msg);
		// request 대신 jsp에게 attribute를 전달할 수 있는 객체
		return "ex02Result";
	}

	@GetMapping("/ex03")
	public void ex03() {
	}

	@PostMapping("/ex03")
	public ModelAndView ex03(String name, int age) {
		String adult = age >= 20 ? "성인" : "미성년자";
		String msg = String.format("%s님은 %d살 이고 %s 입니다", name, age, adult);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("ex03Result");
		mav.addObject("msg", msg);
		return mav;
	}
	
}
