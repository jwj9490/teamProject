package travel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {

	private final String command = "update.tv";
	private final String getPage = "travelUpdateForm";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao tdao;	
	
	@RequestMapping(value=command, method =  RequestMethod.GET)
	public String getUpdate(@RequestParam("num") int num, Model model) {	
		
		TravelBean tb = tdao.getOneSelect(num);
		model.addAttribute("travel", tb);
		
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView postUpdate(@ModelAttribute("travel") @Valid TravelBean tb, BindingResult result) {
		System.out.println("postUpdate : " + tb);
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		int cnt = tdao.updateTravel(tb);
		
		mav.setViewName(gotoPage);
		return mav;
	}
	
}
