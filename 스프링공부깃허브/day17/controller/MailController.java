package com.itbank.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itbank.service.MailService;

@Controller
public class MailController {
	
	@Autowired private MailService ms;
	
	@Value("classpath:account.dat")
	private Resource accountFile;

	@GetMapping("/ex01")
	public void ex01() {}
	
	// "/ex01" 주소로 요청받으면 함수가 실행된다
	// produces : 함수가 실행되어서 만들어지는 내용이 text/html 형식이고, 인코딩이 utf-8이다
	@PostMapping(value="/ex01", produces="text/html; charset=utf-8")
	@ResponseBody	
	// 내가 보내는 문자열이 jsp의 이름이 아니라 응답의 내용이 된다
	public String ex01(@RequestParam HashMap<String, String> param) throws IOException, AddressException, MessagingException {
		
		String mailId = null, mailPw = null;
		File f = accountFile.getFile();
		Scanner sc = new Scanner(f);
		if(sc.hasNextLine()) {
			String data = sc.nextLine();
			mailId = data.split("/")[0];
			mailPw = data.split("/")[1];
		}
		sc.close();
		param.put("mailId", mailId);
		param.put("mailPw", mailPw);
		
		int row = ms.sendMail(param);
		System.out.println(row);
		
		String message = row == 1 ? "메일이 성공적으로 전송되었습니다 !!" : "메일 전송 실패";
		String url = "/day17";
		String code = ""
				+ "<script>\n"
				+ "		alert('%s')\n"
				+ "		location.href = '%s'\n"
				+ "</script>\n";
		code = String.format(code, message, url);
		return code;
	}
}
