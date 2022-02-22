package com.itbank.service;

import java.io.File;
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
	// classpath라고 지정하면 src/main/java 혹은 src/main/resources에서 파일을 찾는다
	// 현재 프로젝트의 특정 폴더를 위치 기준으로 지정하므로, 절대 경로로 작성하지 않아도 된다
	// JSP 에서는 application 내장객체를 통해 위치를 참조하는 방식이 있다
	// Spring에서는 특정 객체에 대한 의존도를 낮추면서도 파일을 불러오게 @Value를 사용할 수 있다
	@Value("classpath:agreement.txt")
	private Resource agreement;
	
	public String getAgreement() {
		Scanner sc = null;
		String data = "";
		try {
			File f = agreement.getFile(); // new File
			 sc = new Scanner(f);
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

	public int join(MemberDTO dto) {
		return dao.insertMember(dto);
	}

}
