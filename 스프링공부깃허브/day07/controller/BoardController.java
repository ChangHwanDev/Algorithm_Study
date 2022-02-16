package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.it.board.BoardDTO;
import com.it.service.BoardService;

@Controller // 요청과 응답에 관계되는 직접적인 처리를 수행
public class BoardController {
	
	@Autowired private BoardService bs;
	
	@GetMapping("/board")
	public ModelAndView board() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = bs.getBoardList();
		mav.addObject("list",list);
		return mav;
	}
	
	@GetMapping("/board/{idx}") //board 뒤에 어떤 값이 추가로 들어오면 글번호로 특정 글을 불러온다
	public ModelAndView view(@PathVariable int idx) { // 경로값을 변수로 사용한다
		ModelAndView mav = new ModelAndView("view");
		BoardDTO dto = bs.getBoard(idx); // 글 번호를 전달하여 단일 객체를 불러온다
		mav.addObject("dto", dto);
		return mav;
	}
}
