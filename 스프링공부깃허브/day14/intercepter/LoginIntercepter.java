package com.itbank.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.member.MemberDTO;

/*
	intercepter : 요청을 가로채서 원하는 내용을 처리하는 클래스
	
	인터셉터 작동 시점
	1) preHandle 		: 요청이 컨트롤러에 도달하기 전에 가로채서 처리한다
	2) postHandle 		: 컨트롤러의 메서드가 수행된 후에 처리한다 (응답은 도착하기 전)
	3) afterCompletion 	: 컨트롤러 메서드 수행의 결과가 클라이언트에 도달한 후 처리한다 
 */
public class LoginIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// boolean 을 반환
		// 요청이 컨트롤러에 도달하기 전에 가로챘으니, 이후 남은 컨트롤러의 처리를 계속 수행할것인가에 대한 여부
		HttpSession session = request.getSession();
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		String cpath = request.getContextPath();
		String requestURL = request.getRequestURL().toString();
//		System.out.println(requestURL);
		
		if(login == null) {	// 세션에 로그인된 객체가 있는지 확인하고, 없으면
			response.sendRedirect(cpath + "/member/login?url=" + requestURL);	
							// 지정한 주소로 이동시킨다
							// 원래 이동하려고 했던 주소를 url 파라미터(쿼리스트링)형식으로 전달한다
			return false;	// 예정되어있던 컨트롤러 처리를 수행하지 않는다
		}
		
		return true;	// 로그인 되어있다면 예정된대로 컨트롤러의 처리를 수행한다
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println("afterCompletion.handler : " + handler);	
		super.afterCompletion(request, response, handler, ex);
	}

	
}
