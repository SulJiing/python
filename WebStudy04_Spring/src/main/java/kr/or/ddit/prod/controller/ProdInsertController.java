package kr.or.ddit.prod.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.ProdVO;

@Controller
@RequestMapping("/prod/prodInsert.do")
public class ProdInsertController {
	
	@Inject
	private ProdService service;
	
	@ModelAttribute("prod") // 핸들러 어댑터를 실행하기 전에 먼저 한번 실행함
	public ProdVO prod() {
		return new ProdVO();
	}
	
	@GetMapping
	public String insertForm() { // 눈엔 안보이지만 prod를 가지고 있음
		return "prod/prodForm";
	}
	
	@PostMapping
	public String insertProcess(
		@Validated(InsertGroup.class) @ModelAttribute("prod") ProdVO prod // 재활용
		, BindingResult errors
		, Model model
	) {
		
		String logicalViewName = null;
		
		if(!errors.hasErrors()) {
//			3. 가입 로직 처리
			ServiceResult result = service.createProd(prod);
//			4. 로직의 실행 결과에 따른 뷰 선택
			String message = null;
			switch (result) {
			case OK:
				logicalViewName = "redirect:/prod/prodView.do?what="+prod.getProdId(); // Post-Redirect-Get
				break;
			default: // 아이디 중복
				logicalViewName = "prod/prodForm";
				message = "바꿔야 돼";
				break;
			}
			model.addAttribute("message", message);
			
		} else {
			logicalViewName = "prod/prodForm";
		}
		return logicalViewName;
	}
}
