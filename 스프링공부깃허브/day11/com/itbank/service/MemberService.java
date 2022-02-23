package com.itbank.service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.itbank.member.MemberDAO;
import com.itbank.member.MemberDTO;

@Service
public class MemberService {
	
	@Autowired private MemberDAO dao;
	
	

	public List<MemberDTO> getMemberList() {
		return dao.selectMemberList();
	}

	public MemberDTO login(MemberDTO dto) {
		return dao.selectMember(dto);
	}

	// src/main/resources 에서 파일을 찾아서 자원의 형태로 등록
	@Value("classpath:agreement.txt")
	private Resource agreement;
	
	public String getAgreement() {
		Scanner sc = null;
		String data = "";
		try {
			 sc = new Scanner(agreement.getFile());
			 while(sc.hasNextLine()) {
//				 System.out.println(sc.nextLine());
				 data += sc.nextLine() + "\n";
			 }
		} catch (IOException e) {}
		finally {
			if(sc != null)	sc.close();
		}
		
		return data;
	}

}
