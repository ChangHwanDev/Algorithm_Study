package com.jch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jch.model.TestDAO;

@Service
public class TestService {
	
	@Autowired private TestDAO dao;
	
	public String getVersion() {
		String version = dao.selectVersion();
		return version;
	}
}
