package com.smhrd.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;
import com.smhrd.entity.Board;

public class BoardDAO {
	
	private SqlSessionFactory factory = SqlSessionManager.getSqlSessionFactory();
	
	// Ex10. 게시글 목록 출력 기능 만들기
	public List<Board> list(){
		
		SqlSession session = factory.openSession(true);
		
		List<Board> list = session.selectList("list");
		
		session.close();
		
		return list;
	}
	
	// Ex11. 게시글 상세보기 기능 만들기
	public Board view(int idx){
		
		SqlSession session = factory.openSession(true);
		
		Board board = session.selectOne("view", idx);
		
		session.close();
		
		return board;
	}
	
	// Ex12. 게시글 작성하기
	public int write(Board board) {
		
		SqlSession session = factory.openSession(true);
		
		int cnt = session.insert("write", board);
		
		session.close();
		
		return cnt;
		
	}
	
	// Ex14. 게시글 검색하기
	public List<Board> search(String search){
		
		SqlSession session = factory.openSession(true);
		
		List<Board> list = session.selectList("search", search);
		
		session.close();
		
		return list;
	}
	
	
}
