package kr.or.ddit.property.servlet09;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.property.service.PropertyService;
import kr.or.ddit.vo.PropertyVO;

/**
 *	1. Model1에서 Model2로 리팩토링
 *	2. 기존 property 패키지의 계층 구조 활용
 *	3. 최종 뷰에서 layout.jsp에 있는 페이지 모듈화 구조 활용
 */
@Controller
@RequestMapping("/12/jdbcDesc.do")
public class JdbcDescController {
	
	@Inject
	private PropertyService service;
	
	@GetMapping
	public String list(Model model) {
		
		List<PropertyVO> propList = service.retrieveProperties();
		model.addAttribute("propList", propList);
		
		return "12/jdbcDesc";
	}
}
