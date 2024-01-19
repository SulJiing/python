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
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.BuyerVO;

@Controller
@RequestMapping("/buyer/buyerUpdate.do")
public class BuyerUpdateController {
	
	@Inject
	private BuyerService service;
	
	@ModelAttribute("buyer")
	public BuyerVO buyer() {
		return new BuyerVO();
	}
	
	@GetMapping
	public String updateForm(@RequestParam("what") String buyerId, Model model) {
		BuyerVO buyer = service.retrieveBuyer(buyerId);
		
		model.addAttribute("buyer", buyer);
		
		return "buyer/buyerEdit";
	}
	
	@PostMapping
	public String updateProcess(
		@Validated(UpdateGroup.class) @ModelAttribute("buyer") BuyerVO buyer
		, BindingResult errors
		, Model model
	){
		
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyBuyer(buyer);
			String message = null;
			switch(result) {
			case OK:
				logicalViewName = "redirect:/buyer/buyerView.do?what="+buyer.getBuyerId();
				break;
			default:
				logicalViewName = "buyer/buyerEdit";
				message = "다시 입력 바람";
				break;
			}
			model.addAttribute("message", message);
		}
		else {
			logicalViewName = "buyer/buyerEdit";
		}
		return logicalViewName;
	}
}
