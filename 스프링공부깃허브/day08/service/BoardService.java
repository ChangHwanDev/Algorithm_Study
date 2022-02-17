package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.board.BoardDAO;
import com.itbank.board.BoardDTO;

@Service 	// 웹이나 DB에 종속적이지 않는, 자바 고유의 독립적인 코드를 수행
public class BoardService {

	@Autowired private BoardDAO dao;
	
	public List<BoardDTO> getBoardList() {
		return dao.selectBoardList();
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
