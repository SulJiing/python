package kr.or.ddit.others.advice;

import java.util.List;

import java.util.Map;

import javax.inject.Inject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.or.ddit.others.dao.OthersDAO;

//prod 패키지 아래에 있는  컨트롤러가 동작할 때는 무조건 이 컨트롤러를 한번 실행함
@ControllerAdvice(basePackages = {"kr.or.ddit.prod","kr.or.ddit.property"}) 
public class OthersControllerAdvice {
	@Inject
	private OthersDAO dao;
	
	// 분류와 제조사 값 가져오기
	@ModelAttribute("lprodList")
	public List<Map<String, Object>> addLprodList() {
		return dao.selectLprodList();
	}
	
	@ModelAttribute("buyerList")
	public List<Map<String, Object>> addBuyerList() {
		return dao.selectBuyerList();
	}
}
