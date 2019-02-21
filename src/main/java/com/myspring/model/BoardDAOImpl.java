package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mDao")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlMap;
	
	@Override
	public List<BoardDTO> getList(String sqlid,HashMap<String,String> map) {
		return sqlMap.selectList(sqlid,map);
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
		sqlMap.update(sqlid,board);
	}

	@Override
	public void boardDelete(String sqlid, int seq) {
		sqlMap.delete(sqlid,seq);
		
	}

	@Override
	public BoardDTO boardDetail(String sqlid, int seq) {
		return sqlMap.selectOne(sqlid,seq);
	}

	@Override
	public int boardPwCheck(String sqlid, int seq,String password) {
		HashMap<String, String> map = new HashMap<>();
		map.put("seq", seq+"");
		map.put("password", password);
		
		return sqlMap.selectOne(sqlid,map);
	}

	@Override
	public int boardCount(String sqlid,HashMap<String,String> map) {
		return sqlMap.selectOne(sqlid,map);
	}


}