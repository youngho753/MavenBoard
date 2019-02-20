package com.myspring.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			return "redirect:getList";
			//return "redirect";
			//이렇게 해야 매핑된곳으로 감
		}
		
		@RequestMapping(value = "getList")
		public String getList(Model model) {
			List<BoardDTO> boardList = bService.getList();
			int currentPage;
			
			model.addAttribute("boardList",boardList);
			return "boardList";
		}
	
		@RequestMapping(value = "detail")
		public String detail(Model model,int seq) {
			BoardDTO board = bService.boardDetail(seq);
			model.addAttribute("board",board);
			return "boardDetail";
		}
		@RequestMapping(value = "update" ,method = RequestMethod.POST)
		public String detail(Model model,BoardDTO board){
			int result = bService.boardPwCheck(board.getSeq(), board.getPassword());
			if(result==1) {
				bService.boardUpdate(board);
				return "redirect:getList";
			}
			else{
				return "redirect:getList";
			}
		}
		
		
		@RequestMapping(value = "delete")
		public String delete(Model model,BoardDTO board) {
			int result = bService.boardPwCheck(board.getSeq(), board.getPassword());
			if(result==1) {
				bService.boardDelete(board.getSeq());
				return "redirect:getList";
			}
			else{
				return "redirect:getList";
			}
		}
		@RequestMapping("boardCount")
		public int boardCount() {
			return bService.boardCount();
		}
}