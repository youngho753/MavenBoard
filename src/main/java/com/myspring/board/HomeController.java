package com.myspring.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
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
			return "redirect:getList";
			//return "redirect";
			//이렇게 해야 매핑된곳으로 감
		}
		
		@RequestMapping(value = "getList")
		public String getList(Model model,String pageNum,String word,String field) {
			HashMap<String,String> map = new HashMap<>();
			//검색일때
			if(word != null) {
				if(word == "tmvmfld") {
					map.put("field","title");
					map.put("word","");
					word = "tmvmfld";
					field = "title";
				}
				else {
				if(field.equals("title"))map.put("field", "title");
				else map.put("field","writer");
				map.put("word",word);
				}
				//검색아닐때
			}else {
				map.put("field","title");
				map.put("word","");
				word = "tmvmfld";
				field = "title";
			}
			//페이징
			if(pageNum == null)pageNum = "1";
			int currentPage = Integer.parseInt(pageNum);
			int count = bService.boardCount(map);
			int pageSize = 5;
			
			int startRow= 1+(currentPage*pageSize-pageSize);
			int endRow = currentPage*pageSize;
			//총페이지수
			int totPage = count/pageSize+(count%pageSize==0?0:1);
			int blockPage =3; //[이전] 456 [다음]
			int startPage=((currentPage-1)/blockPage)*blockPage+1;
			int endPage=startPage+blockPage-1;
			
			if(endPage > totPage) endPage=totPage;
			
			
			map.put("startRow", startRow+"");
			map.put("endRow", endRow+"");
			
			List<BoardDTO> boardList = bService.getList(map);
			
			model.addAttribute("word",word);
			model.addAttribute("field",field);
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			model.addAttribute("blockPage",blockPage);
			model.addAttribute("totPage",totPage);
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
}