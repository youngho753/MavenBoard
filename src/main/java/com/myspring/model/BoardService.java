package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bService")
public class BoardService {
	@Autowired
	private BoardDAOImpl bDao;

	public void insert(BoardDTO board) {
		bDao.boardInsert("boardInsert", board);
	}
	public List<BoardDTO> getList(HashMap<String,String> map) {
		return bDao.getList("getList",map);
	}
	public BoardDTO boardDetail(int seq) {
		return bDao.boardDetail("boardDetail", seq);
	}
	public int boardPwCheck(int seq,String pw) {
		return bDao.boardPwCheck("boardPwCheck", seq,pw);
		
	}
	public void boardUpdate(BoardDTO board) {
		bDao.boardUpdate("boardUpdate", board);
		
	}
	public void boardDelete(int seq) {
		bDao.boardDelete("boardDelete", seq);
	}
	public int boardCount(HashMap<String,String> map) {
		return bDao.boardCount("boardCount",map);
	}
	public void boardReply(BoardDTO board) {
		bDao.reInsert("replyInsert", board);
		bDao.steps("maxStep", board);
	}
}