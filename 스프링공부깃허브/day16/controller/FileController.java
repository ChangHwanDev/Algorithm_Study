package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.FileDTO;
import com.itbank.service.FileService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
// 스프링의 MultipartRequest는 cos의 MultipartRequest와는 구성이 조금 다르다

@Controller
public class FileController {
	
	@Autowired private FileService fs;
	
	@Value("file:E:/upload")
	Resource dir;

	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")
	public ModelAndView ex01(MultipartRequest request) throws IOException {
//		MultipartRequest mpRequest = new MultipartRequest(request, "UTF-8", defaultNamePolicy);
//		JSP때 사용하던 MultipartRequest와는 다르다 !!
		
		ModelAndView mav = new ModelAndView("ex01Result");
//		MultipartRequest mpRequest = (MultipartRequest) request;
		MultipartFile mf = request.getFile("uploadFile");
		
		System.out.println("<input>의 name속성 값 : " + mf.getName());
		System.out.println("파일 이름 : " + mf.getOriginalFilename());
		System.out.println("파일 크기 : " + mf.getSize());
		System.out.println("파일 유형 : " + mf.getContentType());
		
//		File f = new File(pathname);
//		File dir = this.dir.getFile();
//		System.out.println(dir);
		
		File dir = new File("E:\\upload");
		if(dir.exists() == false) {
			dir.mkdirs(); 		// 상위 디렉토리가 없다면 같이 만들어주기
		}
		File f = new File(dir, mf.getOriginalFilename());
		mf.transferTo(f); 	// 사용자가 전송한 mf를 서버의 지정한 위치에 f로 전송한다 (복사)
		
		mav.addObject("fileName", f.getName());
		if(mf.getContentType().startsWith("image")) {	// 만약 유형이 이미지라면
			mav.addObject("img", true);					// img라는 속성값을 넣는다
		}
		return mav;
	}

	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public ModelAndView ex02(MultipartFile uploadFile, String memo) throws IOException {
		ModelAndView mav = new ModelAndView("ex02Result");
		// 파라미터를 전달하여 파일을 지정된 위치에 업로드시키고, 결과를 반환하는 함수
		String fileName = fs.upload(uploadFile);	
		mav.addObject("fileName", fileName);
		mav.addObject("memo", memo);
		mav.addObject("img", uploadFile.getContentType().startsWith("image"));
		return mav;
	}
	
	@GetMapping("/ex03")
	public ModelAndView ex03() throws IOException {
		ModelAndView mav = new ModelAndView();
		String[] arr = this.dir.getFile().list();	// DB없이 파일시스템에서 파일이름을 받아오기
		mav.addObject("arr", arr);
		return mav;
	}
	
	@PostMapping("/ex03")
	public String ex03(FileDTO dto) throws IOException {
		// DB에 내용을 추가하려면, dto로 받아서 파일만 업로드 처리한 후
		// 파일의 이름을 추출하여 DB에 저장해두면
		// 원하는 파일을 참조할때 DB에 저장된 파일이름을 불러와서 언제든지 참조 가능
		fs.upload(dto.getUploadFile());
		return "redirect:/ex03";	// GetMapping 함수를 다시 호출
	}


}
