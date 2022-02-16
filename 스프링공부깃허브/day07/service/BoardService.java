package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.board.BoardDAO;
import com.it.board.BoardDTO;


@Service // 웹이나 DB에 종속적이지 않는, 자바 고유의 독립적인 코드를 수행
public class BoardService {

	@Autowired private BoardDAO dao;
	
	public List<BoardDTO> getBoardList() {
		// TODO Auto-generated method stub
		return dao.selectBoardList();
	}

	public BoardDTO getBoard(int idx) {
		// TODO Auto-generated method stub
		return dao.selectBoard(idx);
	}

}
