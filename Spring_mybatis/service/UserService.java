package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.board.UserDAO;
import com.itbank.board.UserDTO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	
	public int join(UserDTO dto) {
		return dao.insertUser(dto);
	}
}
