package com.itbank.service;

import java.util.HashMap;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class MailService {

	public int sendMail(HashMap<String, String> param) throws AddressException, MessagingException {
		// 메일 발송 시 필요한 내용
		String host = "smtp.naver.com";
		int port = 465;
		final String username = param.get("mailId");
		final String password = param.get("mailPw");
		
		// 메일 발송 서버에 대한 인증 및 속성을 설정
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);			// 메일을 보낼 서버의 이름
		props.put("mail.smpt.port", port);			// 메일을 보낼 서버의 포트
		props.put("mail.smtp.auth", "true");		// 메일 보낼때 인증이 필요한가
		props.put("mail.smtp.ssl.enable", "true");	// 메일 보낼때 암호화 처리되는가
		props.put("mail.smtp.trust", host);			// 신뢰할 수 있는 서버이름
		
		Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
			String un = username;	// 파라미터의 username을 익명클래스의 멤버 필드로 저장
			String pw = password;
			
			@Override	// wonkey1222@naver.com
			protected PasswordAuthentication getPasswordAuthentication() {
				// 멤버 필드에 등록된 계정과 비밀번호를 이용하여 새로운 비밀번호 인증 객체를 생성하고 반환
				return new PasswordAuthentication(un, pw);
			}
		});
		mailSession.setDebug(true);	// 디버그 모드 활성화 (진행 내용이 화면에 출력됨)
		
		// 메일 보낼 내용 - Message 를 구성한다
		Message mimeMessage = new MimeMessage(mailSession);
		String subject = param.get("title");
		String body = param.get("content");
		String from = param.get("src");
		String to = param.get("dst");
		
		// 보내는 사람의 주소		// 받는 사람의 주소
		mimeMessage.setFrom(new InternetAddress(from));
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		mimeMessage.setSubject(subject);
		mimeMessage.setText(body);									// 단순 텍스트를 보낼 경우
//		mimeMessage.setContent(body, "text/html; charset=utf-8");	// HTML 태그를 보낼 경우
		
		Transport.send(mimeMessage);
		
		return 1;
	}

}
