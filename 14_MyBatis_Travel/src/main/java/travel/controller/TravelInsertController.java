package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsertController {

	private final String command = "insert.tv";
	private final String getPage = "travelInsertForm";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao travelDao;
	// travelList.jsp에서 추가하기 클릭했을 때
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doInsertGet() {
		
		return getPage;
	}
	// travelInsertForm�뿉�꽌 
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doInsetPost(@ModelAttribute("travel") @Valid TravelBean tb, BindingResult result) {
		// @ModelAttribute("travel") dsdadsadasdsadsadsadsadsadsadad
		// kim 수정
		// kim 한줄 추가
		// dd
		// 추가추가ㅜ차구차구차구차구ㅏㅊ구ㅏ추가ㅜ차구차
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		int cnt = travelDao.insertTravel(tb);
		
		mav.setViewName(gotoPage);
		return mav;
	}
}
