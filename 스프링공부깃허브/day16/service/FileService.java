package com.itbank.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	@Value("file:E:\\upload")
	private Resource dir;

	public String upload(MultipartFile uploadFile) throws IOException {
		File dest = new File(dir.getFile(), uploadFile.getOriginalFilename());
		uploadFile.transferTo(dest);
		return dest.exists() ? dest.getName() : null;
		// 업로드한 파일이 존재하면 파일이름을, 아니면 null을 반환
		// dest : 파일 전송의 목적지 (destination)
	}

}
