package kr.or.ddit.member.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.member.exception.AuthenticateException;
import kr.or.ddit.member.service.AuthenticateService;
import kr.or.ddit.validate.LoginGroup;
import kr.or.ddit.vo.MemberVO;

@Controller
@RequestMapping("/login/loginProcess.do")
public class LoginController {
//	AuthenticateService와 의존관계 형성
	@Inject
	private AuthenticateService service;
	
	@Inject
	private WebApplicationContext context;
	
	private String contextPath;
	
	@PostConstruct
	public void init() {
		contextPath = context.getServletContext().getContextPath();
	}
	
	@PostMapping
	public String loginProcess(
		@Validated(LoginGroup.class) MemberVO inputData
		, BindingResult errors
		, HttpSession session
		, Optional<String> rememberMe
		, HttpServletResponse resp
		, RedirectAttributes redirectAttributes
	){

		boolean valid = !errors.hasErrors();
		String logicalViewName = null;
		String message = null;
		
		if (valid) {
			try {
				MemberVO authMember = service.authenticate(inputData);
				if(session.isNew()) {
					message = "브라우저의 설정 오류, 쿠키 정보를 확인하세요.";
					logicalViewName = "/login/loginForm.jsp";
				} else {
					// 클라이언트의 새로운 요청 - 로그인 성공
					logicalViewName = "/";
					session.setAttribute("authMember", authMember);
					int maxAge = rememberMe
										.map(rv->60*60*24*3)
										.orElse(0);
					Cookie rememberMeCookie = new Cookie("rememberMe", inputData.getMemId());
					rememberMeCookie.setMaxAge(maxAge);
					rememberMeCookie.setPath(contextPath);
					resp.addCookie(rememberMeCookie);
				}
				// 사용 못함 - req에서 끝나기 때문에 사라짐
//				req.setAttribute("authId", inputData.getMemId());
			} catch(AuthenticateException e) {
				// 클라이언트의 잘못된 요청 - 로그인 실패
				logicalViewName = "/login/loginForm.jsp";
				message = "아이디나 비밀번호 오류";
			}
		} else {
			// ID, PASSWORD 둘다입력하지 않음
//			resp.sendError(400);
			logicalViewName = "/login/loginForm.jsp";
			message = "아이디와 비밀번호를 모두 입력하세요.";
		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/"+logicalViewName;
	}
}