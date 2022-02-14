package com.jch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jch.service.TestService;

@Controller
public class HomeController{
	
	@Autowired private TestService ts;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		String version = ts.getVersion();
		mav.addObject("version",version);
		return mav;
	}
}