package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.exception.NoMemberException;
import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired private MemberService ms;

	@GetMapping("/memberList")	// localhost:8080/day11/member/memberList
	public void memberList(Model model) {
		// 1) 스프링 컨트롤러가 void형이면 요청주소를 viewName으로 활용한다
		// 2) String viewName = "/member" + "/memberList";
		// 3) String forward = prefix + viewName + suffix;
		// 4) "/WEB-INF/views" + "/member/memberList" + ".jsp"
		// 5) member관련된 함수는 MemberController에 작성한다
		// 6) member관련된 jsp는 /WEB-INF/views/member 폴더 안에 작성한다
		
		List<MemberDTO> list = ms.getMemberList();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(MemberDTO dto, String url, HttpSession session) throws Exception {
		MemberDTO login = ms.login(dto);
		if(login == null) {
			throw new NoMemberException();
		}
//		System.out.println("url : " + url);
		session.setAttribute("login", login);
		return "redirect:" + (url == null ? "/" : url);
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		session.invalidate();				// 현재 사용중인 세션을 무효화시킨다
		session.removeAttribute("login"); 	// 현재 세션에서 login 객체를 제거한다
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String join(String agreement, Model model) {
		if(agreement == null) {		// 약관 동의를 받지 않은 상태라면
			agreement = ms.getAgreement();				// 약관 내용을 불러와서
			model.addAttribute("agreement", agreement);	// 페이지에 전달하고
			return null;								// join.jsp 로 포워딩 
		}
		return "member/joinInput"; 	// 약관 동의가 있다면 joinInput.jsp 로 포워딩
	}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) throws Exception {
//		System.out.println(dto.getBirth());
//		return null;
		int row = ms.join(dto);
		return row == 1 ? "redirect:/member/login" : "redirect:/member/join";
	}
	
	// ID를 분실한 경우
	@GetMapping("/forgotId")
	public void forgotId() {}
	
	@PostMapping("/forgotId")
	public ModelAndView forgotId(MemberDTO dto) throws NoMemberException {
		// 가입 시 작성한 이메일과, 생년월일을 정확하게 입력하면 ID를 알려준다
		// SQL : select userid from member where email=#{email} and birth=#{birth}
		
		ModelAndView mav = new ModelAndView("message");
		String userid = ms.findId(dto);
		String message = String.format("요청하신 ID는 [ %s ] 입니다", userid);

		if(userid == null) {		// 만약, userid가 없으면 
			throw new NoMemberException();	// NoMemberException 을 발생시켜서 전가처리
		}
		mav.addObject("message", message);
		return mav;
	}
	
	@GetMapping("/forgotPassword")
	public void forgotPassword() {}
	// ID, E-mail, 생년월일
	
	@PostMapping("/forgotPassword")
	public ModelAndView forgotPassword(MemberDTO dto) throws Exception {
		ModelAndView mav = new ModelAndView("message");
		// 1) 입력받은 회원 정보가 일치하는가
		// 2) 랜덤한 문자열을 만들어서, hash 처리한 값을 테이블에 update 하고
		// 3) 사용자에게는 랜덤한 문자열 비밀번호를 화면에 보여준다
		
		// SQL) update member set userpw = #{hash} 
		//		where userid = #{userid} and email = #{email} and birth = #{birth}
		
		String newPassword = ms.renewPassword(dto);
		if(newPassword == null) {
			throw new NoMemberException();
		}

		String message = String.format("새로 발급된 비밀번호는 [ %s ] 입니다", newPassword);
		mav.addObject("message", message);
		return mav;
	}
	
	@GetMapping("/mypage")
	public ModelAndView mypage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDTO login = (MemberDTO)session.getAttribute("login");	// 현재 사용자 객체
		String userid = login.getUserid();		// id만 가져오기
		MemberDTO dto = ms.getMember(userid);	// id만 전달하여 일치하는 회원 정보 하나를 불러온다
		mav.addObject("dto", dto);				// 새로 DB에서 불러온 정보를 JSP에 전달
		
		// 1) 현재 로그인 한 사용자(세션에서 찾아온다)의 정보만 불러온다
		// 2) 단일 객체 (List가 아님 !!)를 불러와서 model에 추가한 후
		// 3) JSP로 넘겨서 화면에 출력한다
		
		return mav;
	}
	
	@GetMapping("/modify")
	public ModelAndView modify(HttpSession session) {
		String userid = ((MemberDTO)session.getAttribute("login")).getUserid();
		ModelAndView mav = new ModelAndView();
		MemberDTO dto = ms.getMember(userid);
		mav.addObject("dto", dto);
		return mav;
	}
	@PostMapping("/modify")
	public String modify(MemberDTO dto) throws Exception {
		int row = ms.modifyMember(dto);
		if(row == 0) {
			throw new NoMemberException();
		}
		return "redirect:/member/mypage";
	}
	
	@GetMapping("/withdraw")
	public void withdraw() {}
	
	// 특정 예외가 발생했을 때 수행되는 메서드, 응답을 반환할 수 있습니다
	// ExceptionHandler는 @Controller, @RestController, @ControllerAdvice 에서 작성 가능
	// @Service, @Repository 에서는 사용하지 못함
	// 발생하는 예외들을 모아서 컨트롤러 레벨에서 처리한다
	// 만약 모든 컨트롤러가 공통으로 발생하는 예외를 처리하고 싶다면 @ControllerAdvice 를 사용할 수 있다
	
	// ControllerAdvice 로 넘김
	
//	@ExceptionHandler(NullPointerException.class)
//	public ModelAndView npe(NullPointerException e) {
//		ModelAndView mav = new ModelAndView("message");
//		mav.addObject("message", "로그인 사용자를 찾을 수 없습니다");
//		return mav;
//	}
	
	
	
}


