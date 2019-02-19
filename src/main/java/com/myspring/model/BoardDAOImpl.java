package com.myspring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mDao")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlMap;
	
	@Override
	public List<BoardDTO> getList(String sqlid) {
		return sqlMap.selectList(sqlid);
	}

	@Override
	public List<BoardDTO> getSearchList(String sqlid, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardInsert(String sqlid, BoardDTO board) {
		sqlMap.insert(sqlid,board);
		
	}

	@Override
	public void boardUpdate(String sqlid, BoardDTO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardDelete(String sqlid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardDTO boardDetail(String sqlid, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardPwCheck(String sqlid, String pw) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardCount(String sqlid) {
		// TODO Auto-generated method stub
		return 0;
	}


}
