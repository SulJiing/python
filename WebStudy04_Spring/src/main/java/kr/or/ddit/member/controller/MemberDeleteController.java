package kr.or.ddit.member.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;

// POJO(PlainOldJavaObject)

@Controller
public class MemberDeleteController {
	
	@Inject
	private MemberService service;
	
	@PostMapping
	@RequestMapping("/member/memberDelete.do")
	public String deleteProcess(Principal principal, String password, RedirectAttributes redirectAttributes){
		
//		HttpSession session = req.getSession();
		
		String memId = principal.getName();
		
		MemberVO inputData = new MemberVO(memId, password);
		ServiceResult result = service.removeMember(inputData);
		String logicalViewName = null;
		String message = null;
		
		switch (result) {
		case INVALIDPASSWORD:
			message = "비밀번호 오류";
			logicalViewName = "redirect:/mypage";
			redirectAttributes.addFlashAttribute("message", message);
			break;
		case OK:
//			session.invalidate();
			logicalViewName = "forward:/login/logOut.do";
			break;
		default:
			message = "서버오류났으니까 다시 해봐";
			logicalViewName = "redirect:/mypage";
			redirectAttributes.addFlashAttribute("message", message);
			break;
		}
		return logicalViewName;
	}
}
