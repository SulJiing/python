package kr.or.ddit.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogOutController {
	@PostMapping("/login/logOut.do")
	public String logout(HttpServletRequest req ) {
		// 세션을 unbind로 사라지게 함
		req.getSession().invalidate();
		return "redirect:/";
	}
}
