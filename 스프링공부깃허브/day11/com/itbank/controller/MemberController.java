package com.itbank.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired private MemberService ms;

	@GetMapping("/memberList")	// localhost:8080/day11/member/memberList
	public void memberList(Model model) {
		// 1) 스프링 컨트롤러가 void형이면 요청주소를 viewName으로 활용한다
		// 2) String viewName = "/member" + "/memberList";
		// 3) String forward = prefix + viewName + suffix;
		// 4) "/WEB-INF/views" + "/member/memberList" + ".jsp"
		// 5) member관련된 함수는 MemberController에 작성한다
		// 6) member관련된 jsp는 /WEB-INF/views/member 폴더 안에 작성한다
		
		List<MemberDTO> list = ms.getMemberList();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(MemberDTO dto, HttpSession session) {
		MemberDTO login = ms.login(dto);
		session.setAttribute("login", login);
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		session.invalidate();				// 현재 사용중인 세션을 무효화시킨다
		session.removeAttribute("login"); 	// 현재 세션에서 login 객체를 제거한다
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public void join(Model model) {
		String agreement = ms.getAgreement();
		model.addAttribute("agreement", agreement);
	}
	
	
	
	
	
	
	
}


