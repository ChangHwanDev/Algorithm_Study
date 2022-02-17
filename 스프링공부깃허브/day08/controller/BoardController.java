package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.board.BoardDTO;
import com.itbank.service.BoardService;

@Controller	// 요청과 응답에 관계되는 직접적인 처리를 수행
public class BoardController {
	
	@Autowired private BoardService bs;

	@GetMapping("/board")	// board로 끝나는 주소이면 목록을 출력한다
	public ModelAndView board() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = bs.getBoardList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/board/{idx}")	// board 뒤에 어떤 값이 추가로 들어오면 글번호로 특정 글을 불러온다
	public ModelAndView view(@PathVariable int idx) {	// 경로값을 변수로 사용한다
		ModelAndView mav = new ModelAndView("view");
		BoardDTO dto = bs.getBoard(idx);	// 글 번호를 전달하여 단일 객체를 불러온다
		mav.addObject("dto", dto);
		
		// 단일 게시글을 읽더라도 하단에 게시글 목록을 출력하기 위해서 추가로 작성한 내용
		List<BoardDTO> list = bs.getBoardList();
		mav.addObject("list", list);
		
		return mav;
	}
	
	@GetMapping("/board/write")	// 읽기와 주소형식은 비슷하지만, 이쪽이 더 구체적인 형식이다
	public String write() {
		return "write";
	}
	
	@PostMapping("/board/write")
	public String write(BoardDTO dto) {	// 스프링 커맨드 객체, 여러 파라미터를 dto에 setting
		int row = bs.write(dto);
		System.out.println(row == 1 ? "작성 성공" : "작성 실패");
		return "redirect:/board";
		// 그냥 문자열만 반환하면 기본값은 forward, 
		// 문자열 앞에 redirect: 으로 시작하고 주소를 작성하면 리다이렉트
	}
	
	@GetMapping("/board/delete/{idx}")
	public String delete(@PathVariable int idx) {
		int row = bs.delete(idx);
		System.out.println(row == 1 ? "삭제 성공" : "삭제 실패");
		return "redirect:/board";
	}
	
	@GetMapping("/board/modify/{idx}")
	public ModelAndView modify(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("write");
		// write 작성 페이지를 일부 수정하여 작성과 수정에 활용해보기
		BoardDTO dto = bs.getBoard(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/board/modify/{idx}")
	public String modify(BoardDTO dto) {
		int row = bs.modify(dto);
		System.out.println(row == 1 ? "수정 성공" : "수정 실패");
		return "redirect:/board/" + dto.getIdx();
	}
	
	
	
}











