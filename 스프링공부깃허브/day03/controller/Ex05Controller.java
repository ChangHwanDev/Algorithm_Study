package com.hwan.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex05Controller {
	
	@GetMapping("/ex05")
	public void ex05() {}
	
	@PostMapping("/ex05")
	public ModelAndView ex05(@RequestParam HashMap<String, String>map) {
		ModelAndView mav = new ModelAndView("ex05Result");
		
		System.out.println(map);
		mav.addObject("map",map);
		return mav;
	}
}
