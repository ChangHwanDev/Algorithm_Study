package com.hwan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Member;

// 컨트롤러 클래스에 RequestMapping을 설정하여 주소만 지정하고
// 클래스 하위 함수에는@GetMapping, @PostMapping 등 Httpd 메서드를 지정할 수 있다

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	@GetMapping
	public void ex04() {}
	
	@PostMapping
	public ModelAndView ex04Result(Member dto) {
		ModelAndView mav = new ModelAndView("ex04Result");
		mav.addObject("dto",dto);
		return mav;
	}
}
