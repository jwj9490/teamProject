package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {
	
	// travel.tv 한글왜 깨지냐고
	
	private final String command = "list.tv";
	private final String getPage = "travelList";
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
								@RequestParam(value="whatColumn", required = false) String whatColumn,
								@RequestParam(value="keyword", required = false) String keyword,
								@RequestParam(value="pageNumber", required = false) String pageNumber,
								HttpServletRequest request) {
		
		System.out.println("ListController whatColumn : " + whatColumn);
		System.out.println("ListController keyword : " + keyword);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%" + keyword + "%");
		System.out.println("TravelListController doAction pageNumber : " + pageNumber);
		
		int totalCount = travelDao.getTotalCount(map);
		System.out.println("totalCount : " + totalCount);
		
		String url = request.getContextPath() + "/" + command;
		System.out.println("TravelListController url : " + url);
		
		Paging pageInfo = new Paging(pageNumber, "2", totalCount, url, whatColumn, keyword);
		System.out.println("offset : " + pageInfo.getOffset());
		System.out.println("limit : " + pageInfo.getLimit());
		
		System.out.println("ListController mputkeyword : " + keyword);
		
		List<TravelBean> lists = travelDao.getTravelList(pageInfo, map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("travelLists", lists);
		mav.addObject("totalCount", totalCount);
		mav.addObject("pageInfo", pageInfo);
		
		mav.setViewName(getPage);
		
		return mav;
		// kim도 수정함
		// kim 추가함
		// kim 추가함
		// kim또또 수정함
		// kim이 또 수정함
		// kim dddddd
	}
}
