package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.itbank.component.SHA512;
import com.itbank.member.MemberDAO;
import com.itbank.member.MemberDTO;

@Service
public class MemberService {
	
	@Autowired private MemberDAO dao;
	@Autowired private SHA512 hash;
	

	public List<MemberDTO> getMemberList() {
		return dao.selectMemberList();
	}

	public MemberDTO login(MemberDTO dto) throws Exception {
		dto.setUserpw(hash.getHash(dto.getUserpw()));
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

	public int join(MemberDTO dto) throws Exception {
		dto.setUserpw(hash.getHash(dto.getUserpw()));
		return dao.insertMember(dto);
	}

	public String findId(MemberDTO dto) {
		return dao.selectId(dto);
	}

	public String renewpw(MemberDTO dto) throws Exception {
		// 1) 랜덤 문자열을 가져와서 비밀번호 hash처리를 수행하고 dto에 넣어둔다
		String  chars = "abcdefghijklmnopqrstuvwyz0123456789!@#._-";
		Random ran = new Random();
		int length = 8;
		String newPassword="";
		while(newPassword.length()<length) {
			int num= ran.nextInt(chars.length());
			newPassword += chars.charAt(num);
		}
		
		// 1-2) RandomUUID를 활용한 임시 비밀번호 만들기
		// UUID는 자원을 고유하게 식별하는데 사용하는 값이다
		// 랜덤한 형식의 UUID를 문자열로 변경하고, 8글자만 잘라내서 ,소문자로 변경하고 저장
		// String newPassword = UUID.randomUUID().toString.substirng(0,8).toLowercase();
		String hashPassword = hash.getHash(newPassword);
		dto.setUserpw(hashPassword);

		// 2) 조건에 맞는 회원 정보를 수정하고, 그 결과를 정수로 받는다
		int row=dao.renewPassword(dto);
		
		// 3) 수정된 줄 수가 0이 아니라면, 위에서 새로 만든 비밀번호(해시처리 이전값)을 반환한다
		return row != 0 ? newPassword : null;
	}

	public MemberDTO getMember(String userid) {
		return dao.selectMemberUsingId(userid);
	}



}
