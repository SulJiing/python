package kr.or.ddit.buyer.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.BuyerVO;

@Controller
@RequestMapping("/buyer/buyerInsert.do")
public class BuyerInsertController {
	
	@Inject
	private BuyerService service;
	
	@ModelAttribute("buyer")
	public BuyerVO buyer() {
		return new BuyerVO();
	}
	
	@GetMapping
	public String insertForm() {
		return "buyer/buyerForm";
	}
	
	@PostMapping
	public String insertProcess(
		@Validated(InsertGroup.class) @ModelAttribute("buyer") BuyerVO buyer
		, BindingResult errors
		, Model model
	){
		
		String logicalViewName = null;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.createBuyer(buyer);
			String message = null;
			switch (result) {
			case OK:
				logicalViewName = "redirect:/buyer/buyerView.do?what="+buyer.getBuyerId();
				break;
			default:
				logicalViewName = "buyer/buyerForm";
				message = "바꿔야 돼";
				break;
			}
			model.addAttribute("message", message);
			
		} else {
			logicalViewName = "buyer/buyerForm";
		}
		return logicalViewName;
	}
}

