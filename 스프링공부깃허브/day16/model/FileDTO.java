package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {

	private String memo;
	private MultipartFile uploadFile;	// DTO에 파일을 선언하면 묶어서 받는것도 가능
	private String uploadFileName;	// 파일을 통째로 DB에 저장하지는 않기 때문에 파일이름만 따로 추출
	// oracle DB의 자료형 중에 Blob도 존재한다
	// Binary Large OBject 를 말하며, 대용량의 바이너리 파일을 DB에 저장하는 형식이다
	// 보통은 파일이름 혹은 경로만 문자열 형태(varchar2)로 저장한다
	// 파일은 이후, 별도의 전송기술을 이용하여 웹 서버가 아닌 다른 서버에 저장하는 경우가 많다
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
}
