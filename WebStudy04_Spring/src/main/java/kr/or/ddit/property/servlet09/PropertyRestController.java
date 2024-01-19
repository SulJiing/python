package kr.or.ddit.property.servlet09;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.property.service.PropertyService;
import kr.or.ddit.vo.PropertyVO;

/**
 *	RESTfurl URI
 *	명사(자원의 식별작) : /mission/ajax/property
 *		/mission/ajax/property(GET) : 전체 조회
 *		/mission/ajax/property/a001(GET) : 한건 조회
 *		/mission/ajax/property/a001(PUT) : 한건 수정
 *		/mission/ajax/property/a001(DELETE) : 한건 삭제
 *		/mission/ajax/property(POST) : 신규 등록
 */
//@Controller
@Controller // 복합어노테이션(@Controller+@ResponseBody)
//consumes -> content-type
//produces -> accept
@RequestMapping("/09/propView.do")
public class PropertyRestController {
	
	@Inject
	private PropertyService service;
	
	@ModelAttribute("property")
	public PropertyVO property() {
		return new PropertyVO();
	}
	
	@GetMapping
	public String getAll(Model model) {
		List<PropertyVO> proeprty = service.retrieveProperties();
		model.addAttribute("proeprty", proeprty);
		return "09/propView";
	}
}
//	@GetMapping
//	public String getOne(@PathVariable String propertyName, Model model) {
//		PropertyVO property = service.retrieveProperty(propertyName);
//		model.addAttribute("property", property);
//		return "09/propView";
//	}
//	
//	@PostMapping
//	public String insert(@Validated({ InsertGroup.class, Default.class }) @ModelAttribute("property") PropertyVO property,
//			Errors errors, RedirectAttributes redirectAttributes) {
//		if (!errors.hasErrors()) {
//			String message = "프로퍼티 등록 성공";
//			redirectAttributes.addFlashAttribute("message", message);
//			return "redirect:/";
//		} else {
//			return "09/propView";
//		}
//	}
//	
//	@PutMapping
//	public String update(@ModelAttribute("property") PropertyVO modifyProp, Model model) {
//		boolean success = service.updateProperty(modifyProp);
//		String logicalViewName = null;
//		if(success) {
//			logicalViewName = "09/propView";
//		} else {
//			logicalViewName = "09/propView";
//		}
//		model.addAttribute("success", success);
//		return logicalViewName;
//	}
//	
//	@DeleteMapping
//	public String delete(@PathVariable String propertyName, Model model) {
//		boolean success = service.deleteProperty(propertyName);
//		model.addAttribute("success", success);
//		return "09/propView";
//	}
//}
