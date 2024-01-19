package kr.or.ddit.buyer.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.common.paging.PaginationRenderer;
import kr.or.ddit.vo.BuyerVO;

@Controller
@RequestMapping("/buyer")
public class BuyerListController {
	
	@Inject
	BuyerService service;
	
	@GetMapping("buyerList.do")
	public String list(
		@RequestParam Map<String, Object> detailCondition
		, @RequestParam(name="page", required = false, defaultValue = "1") int currentPage
		, Model model
	){
		
		PaginationInfo paging = new PaginationInfo(3,2);
		
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(detailCondition);
		
		List<BuyerVO> buyerList = service.retrieveBuyerList(paging);

		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#submitForm");

		String pagingHTML = renderer.renderPagination(paging);

		model.addAttribute("buyerList", buyerList);
		model.addAttribute("pagingHTML", pagingHTML);
		model.addAttribute("condition", detailCondition);

		return "buyer/buyerList";
	}
	
	@GetMapping("buyerView.do")
	public String buyerOne(@RequestParam("what") String prodLgu, Model model){
		
		BuyerVO buyer = service.retrieveBuyer(prodLgu);
		
		model.addAttribute("buyer", buyer);
		
		return "buyer/buyerView";
	}
}
