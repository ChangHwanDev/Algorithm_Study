package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.board.UserDTO;
import com.itbank.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService us;

	@GetMapping("joinForm")
	public String joinForm() {
		return "/joinForm";
	}
	
	@GetMapping("loginForm")
	public String loginForm() {
		return "/loginForm";
	}

	@PostMapping("joinForm")
	public String joinForm(UserDTO dto) {
		int row = us.join(dto);
		System.out.println(row == 1 ? "삭제 성공" : "삭제 실패");
		return "/home";
	}
}
