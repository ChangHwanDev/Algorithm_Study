package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.board.BoardDAO;
import com.itbank.board.BoardDTO;

@Service 	// 웹이나 DB에 종속적이지 않는, 자바 고유의 독립적인 코드를 수행
public class BoardService {

	@Autowired private BoardDAO dao;
	
	public HashMap<String, Object> getBoardList(Integer page) {
		// List도 반환하고, 다른 정보도 같이 반환하고 싶다면
		// 자바는 동시에 하나의 객체만 반환할 수 있으므로,
		// Map 형식으로 묶어서 반환한다
		HashMap<String, Object> ret = new HashMap<String, Object>();
		
		if(page==null) 		page = 1;
		int perPage = 10;
		int offset = (page -1) * perPage;
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("perPage", perPage);
		param.put("offset", offset);
		List<BoardDTO> list = dao.selectBoardList(param);
		
		int pageCount = dao.selectPageCount(perPage);
		
		int perSection = 10;
		int begin = (page -1 ) / 10 * 10 + 1;
		int end = begin + 10 -1;
		end = end > pageCount ? pageCount : end;
		
		ret.put("list",list);
		ret.put("pageCount",pageCount);
		ret.put("page",page);
		ret.put("begin", begin);
		ret.put("end", end);
		return ret;
	}

	public BoardDTO getBoard(int idx) {
		return dao.selectBoard(idx);
	}

	public int write(BoardDTO dto) {
		return dao.insertBoard(dto);
	}

	public int delete(int idx) {
		return dao.deleteBoard(idx);
	}

	public int modify(BoardDTO dto) {
		return dao.updateBoard(dto);
	}
	
	

}
