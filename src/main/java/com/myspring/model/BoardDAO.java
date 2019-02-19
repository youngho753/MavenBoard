package com.myspring.model;

import java.util.List;

public interface BoardDAO {
	//전체보기
	//검색
	//추가
	//수정
	//삭제
	//상세보기
	//패스워드체크
	//게시글수
	public List<BoardDTO> getList(String sqlid);
	public List<BoardDTO> getSearchList(String sqlid,String word);
	public void boardInsert(String sqlid,BoardDTO board);
	public void boardUpdate(String sqlid,BoardDTO board);
	public void boardDelete(String sqlid);
	public BoardDTO boardDetail(String sqlid,int id);
	public int boardPwCheck(String sqlid,String pw);
	public int boardCount(String sqlid);
	
}
