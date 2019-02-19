package com.myspring.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.model.BoardDTO;
import com.myspring.model.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Resource(name="bService")
	BoardService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	//insert-form
		@RequestMapping("insert")
		public String insert() {
			return "boardInsert";
		}

		@RequestMapping(value = "insert", method = RequestMethod.POST)
		public String insert(BoardDTO board) {
			bService.insert(board);
			return "boardList";
			//return "redirect";
			//이렇게 해야 매핑된곳으로 감
		}
		
		@RequestMapping(value = "getList")
		public String getList(Model model) {
			List<BoardDTO> boardList = bService.getList();
			model.addAttribute("boardList",boardList);
			return "boardList";
			//이렇게 해야 매핑된곳으로 감
		}
	
}
