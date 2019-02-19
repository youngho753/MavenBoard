package com.myspring.model;

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
	public List<BoardDTO> getList() {
		return bDao.getList("getList");
	}


}
